<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/h-ui.admin/css/style.css" />

<title>管理员列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 权限管理 <span class="c-gray en">&gt;</span> 管理员列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a href="javascript:;" onclick="admin_add('添加管理员','power_initAdd.action','800','500')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加管理员</a></span> </div>
	<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
		<thead>
			<tr>
				<th scope="col" colspan="7">员工列表</th>
			</tr>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name="" value=""></th>
				<th width="40">ID</th>
				<th width="150">登录名</th>
				<th width="150">姓名</th>
				<th >职位</th>
				<th width="130">状态</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
		<s:iterator value="#request.mList" var="m">
                <tr class="text-c">
				<td><input type="checkbox" value="1" name=""></td>
				<td>${m.id}</td>
				<td>${m.account }</td>
				<td>${m.name }</td>
				<td>${m.post.name }</td>
				<td>${m.statu }</td>
				<td class="td-manage"><a style="text-decoration:none" onClick="admin_stop(this,'10001')" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a> <a title="编辑" href="javascript:;" onclick="admin_edit('管理员编辑','power_initUpdate.action?id=${m.id}','800','500')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> <a title="删除" href="javascript:;" onclick="admin_del(this,'1')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
			</tr>
                </s:iterator>
		</tbody>
	</table>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath }/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${pageContext.request.contextPath }/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
$('.table-sort').dataTable({
	"aaSorting": [[ 1, "asc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aLengthMenu":[1,2,3,4,5,10,20],//可自行选择 每页显示条数
	"pading":false,
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  {"orderable":false,"aTargets":[0,6]}// 不参与排序的列
	],
	"oLanguage" : { // 国际化配置
        "sProcessing" : "正在获取数据，请稍后...",
        "sLengthMenu" : "显示 _MENU_ 条",
        "sZeroRecords" : "没有找到数据",
        "sInfo" : "从 _START_ 到  _END_ 条记录 总记录数为 _TOTAL_ 条",
        "sInfoEmpty" : "记录数为0",
        "sInfoFiltered" : "(全部记录数 _MAX_ 条)",
        "sInfoPostFix" : "",
        "sSearch" : "关键字查询",
        "sUrl" : "",
        "oPaginate" : {
            "sFirst" : "第一页",
            "sPrevious" : "上一页",
            "sNext" : "下一页",
            "sLast" : "最后一页"
        }
    }
});

/*
	参数解释：
	title	标题
	url		请求的url
	id		需要操作的数据id
	w		弹出层宽度（缺省调默认值）
	h		弹出层高度（缺省调默认值）
*/
/*管理员-增加*/
function admin_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*管理员-删除*/
function admin_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '',
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").remove();
				layer.msg('已删除!',{icon:1,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}

/*管理员-编辑*/
function admin_edit(title,url,w,h){
	layer_show(title,url,w,h);
}
/*管理员-停用*/
function admin_stop(obj,id){
	layer.confirm('确认要停用吗？',function(index){
		//此处请求后台程序，下方是成功后的前台处理……
		
		$(obj).parents("tr").find(".td-manage").prepend('<a onClick="admin_start(this,id)" href="javascript:;" title="启用" style="text-decoration:none"><i class="Hui-iconfont">&#xe615;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">已禁用</span>');
		$(obj).remove();
		layer.msg('已停用!',{icon: 5,time:1000});
	});
}

/*管理员-启用*/
function admin_start(obj,id){
	layer.confirm('确认要启用吗？',function(index){
		//此处请求后台程序，下方是成功后的前台处理……
		
		
		$(obj).parents("tr").find(".td-manage").prepend('<a onClick="admin_stop(this,id)" href="javascript:;" title="停用" style="text-decoration:none"><i class="Hui-iconfont">&#xe631;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
		$(obj).remove();
		layer.msg('已启用!', {icon: 6,time:1000});
	});
}
</script>
</body>
</html>