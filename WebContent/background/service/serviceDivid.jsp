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
    <!--/meta 作为公共模版分离出去-->

    <title>服务分配</title>
    <meta name="keywords" content="服务分配">
    <meta name="description" content="服务分配">
</head>

<body>
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 客户服务管理 <span class="c-gray en">&gt;</span> 服务分配<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a></nav>
    <div class="cl pd-5 bg-1 bk-gray"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> </span> </div>
   
        <table class="table table-border table-bordered table-bg table-hover table-sort table-responsive" id="table">
            <thead>
                <tr>
                    <th scope="col" colspan="9">待分配服务</th>
                </tr>
                <tr class="text-c">
                    <th width="25"><input type="checkbox" name="" value=""></th>
                    <th width="40">编号</th>
                    <th width="150">客户</th>
                    <th >概要</th>
                    <th width="150">服务类型</th>
                    <th width="100">创建人</th>
                    <th width="150">创建日期</th>
                    <th width="300">分配给</th>
                </tr>
            </thead>
            <tbody>
            <s:iterator value="#request.csList" var="cs">
                <tr class="text-c">
                    <td><input type="checkbox" value="1" name=""></td>
                    <td>${cs.id}</td>
                    <td>${cs.customerinfo.name }</td>
                    <td>${cs.summary }</td>
                    <td>${cs.type.context}</td>
                    <td>${cs.cman.name }</td>
                    <td>${cs.ctime }</td>
                    <td>
                    <form class="form form-horizontal" method="post" action="service_divid.action?cs.id=${cs.id}">
                        <div class="formControls"> <span class="select-box">
				<s:select list="#request.mList" 
			  headerKey="-1"
			  headerValue="--请选择客户经理--"
			  listKey="id"
			  listValue="name"
			  name="cs.manager.id"
			  class="select"
			  theme="simple"
			  />
				</span></div>
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;分配&nbsp;&nbsp;">
                    </form>
                    </td>
                </tr>
                </s:iterator>
            </tbody>
        </table>
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
	  {"orderable":false,"aTargets":[0,7]}// 不参与排序的列
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

/*资讯-添加*/
function article_add(title,url,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*资讯-编辑*/
function article_edit(title,url,id,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*资讯-删除*/
function article_del(obj,id){
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

/*资讯-审核*/
function article_shenhe(obj,id){
	layer.confirm('审核文章？', {
		btn: ['通过','不通过','取消'], 
		shade: false,
		closeBtn: 0
	},
	function(){
		$(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="article_start(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
		$(obj).remove();
		layer.msg('已发布', {icon:6,time:1000});
	},
	function(){
		$(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="article_shenqing(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-danger radius">未通过</span>');
		$(obj).remove();
    	layer.msg('未通过', {icon:5,time:1000});
	});	
}
/*资讯-下架*/
function article_stop(obj,id){
	layer.confirm('确认要下架吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="article_start(this,id)" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已下架</span>');
		$(obj).remove();
		layer.msg('已下架!',{icon: 5,time:1000});
	});
}

/*资讯-发布*/
function article_start(obj,id){
	layer.confirm('确认要发布吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="article_stop(this,id)" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
		$(obj).remove();
		layer.msg('已发布!',{icon: 6,time:1000});
	});
}
/*资讯-申请上线*/
function article_shenqing(obj,id){
	$(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">待审核</span>');
	$(obj).parents("tr").find(".td-manage").html("");
	layer.msg('已提交申请，耐心等待审核!', {icon: 1,time:2000});
}

</script> 
</body>

</html>