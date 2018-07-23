<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
    <title>服务详情</title>
    <meta name="keywords" content="服务详情">
    <meta name="description" content="服务详情">
</head>

<body>
    <article class="page-container">
        <form class="form form-horizontal" id="form-article-add" action="service_addOrUpdate.action" method="post">
            <input type="hidden" value="${requestScope.cs.id}" name="cs.id"/>
            <table class="table table-border table-bordered table-hover" id="table">
                <!--       服务创建显示区块        -->
                <s:if test="#request.cs.statu==\"新创建\"">
                <tr class="text-c">
                    <td><label><span class="c-red">*</span>服务类型：</label></td>
                    <td>
                        <div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<s:select list="#request.serveTypes" 
			  headerKey="-1"
			  headerValue="--请选择服务类型--"
			  listKey="id"
			  listValue="context"
			  name="cs.type.id"
			  class="select"
			  theme="simple"
			  />
				</span></div>
                    </td>
                    <td><label><span class="c-red">*</span>概要：</label></td>
                    <td>
                        <div class="formControls col-xs-8 col-sm-9">
                            <input type="text" class="input-text" value="" placeholder="" id="articletitle" name="cs.summary">
                        </div>
                    </td>
                </tr>
                <tr class="text-c">
                    <td><label><span class="c-red">*</span>客户：</label></td>
                    <td>
                        <div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<s:select list="#request.customerinfos" 
			  headerKey="-1"
			  headerValue="--请选择客户--"
			  listKey="id"
			  listValue="name"
			  name="cs.customerinfo.id"
			  class="select"
			  theme="simple"
			  />
				</span></div>
                    </td>
                    <td><label><span class="c-red">*</span>状态：</label></td>
                    <td>                    
                         <div class="formControls col-xs-8 col-sm-9">
                            <input type="hidden" value="${requestScope.cs.statu }" name="cs.statu"/>
                            ${requestScope.cs.statu }
                        </div>
                    </td>
                </tr>
                <tr class="text-c">
                    <td><label><span class="c-red">*</span>服务请求：</label></td>
                    <td colspan="3">
                        <div class="formControls col-xs-8 col-sm-9">
                            <textarea name="cs.request" cols="" rows="" class="textarea" placeholder="请输入服务请求...最少输入10个字符" datatype="*10-100" dragonfly="true" nullmsg="备注不能为空！"></textarea>                   
                        </div>
                    </td>
                </tr>
                <tr class="text-c">
                    <td><label><span class="c-red">*</span>创建人：</label></td>
                    <td>
                        <div class="formControls col-xs-8 col-sm-9">
                            <input type="hidden" value="${sessionScope.loginer.id }" name="cs.cman.id"/>
                            <input type="text" class="input-text" value="${sessionScope.loginer.name}" placeholder="当前登录人" disabled id="articletitle" name="cs.cman.name">
                        </div>
                    </td>
                    <td><label><span class="c-red">*</span>创建时间：</label></td>
                    <td>
                        <div class="formControls col-xs-8 col-sm-9">
                            <input type="text" class="input-text" value="${requestScope.cs.ctime}" placeholder="当前系统时间" disabled id="articletitle" name="cs.ctime">
                        </div>
                    </td>
                </tr>
            </s:if>
                <!--       分配区块,类型代号：divid         -->
                <s:if test="#request.cs.statu==\"已分配\" or #request.cs.statu==\"已处理\" or #request.cs.statu==\"已归档\"">
                <tr class="text-c">
                    <td><label>服务类型：</label></td>
                    <td>
                        <input type="hidden" value="${requestScope.cs.type.id}" name="cs.type.id"/>
                        ${requestScope.cs.type.context}
                    </td>
                    <td><label>概要：</label></td>
                    <td>
                    <input type="hidden" value="${requestScope.cs.summary }" name="cs.summary "/>
                        ${requestScope.cs.summary }
                    </td>
                </tr>
                <tr class="text-c">
                    <td><label>客户：</label></td>
                    <td>
                    <input type="hidden" value="${requestScope.cs.customerinfo.id }" name="cs.customerinfo.id "/>
                        ${requestScope.cs.customerinfo.name}
                    </td>
                    <td><label>状态：</label></td>
                    <td>
                    <input type="hidden" value="${requestScope.cs.statu }" name="cs.statu "/>
                        ${requestScope.cs.statu }
                    </td>
                </tr>
                <tr class="text-c">
                    <td><label>服务请求：</label></td>
                    <td colspan="3">
                    <input type="hidden" value="${requestScope.cs.request }" name="cs.request "/>
                        ${requestScope.cs.request }
                    </td>
                </tr>
                <tr class="text-c">
                    <td><label>创建人：</label></td>
                    <td>
                    <input type="hidden" value="${requestScope.cs.cman.id }" name="cs.cman.id "/>
                        ${requestScope.cs.cman.name}
                    </td>
                    <td><label>创建时间：</label></td>
                    <td>
                    <input type="hidden" value="${requestScope.cs.ctime }" name="cs.ctime "/>
                        ${requestScope.cs.ctime }
                    </td>
                </tr>
                <tr class="text-c divid">
                    <td colspan="4"></td>
                </tr>
                <tr class="text-c divid">
                    <td><label>分配给：</label></td>
                    <td>
                    <input type="hidden" value="${requestScope.cs.manager.id}" name="cs.manager.id "/>
                      ${requestScope.cs.manager.name }
                    </td>
                    <td><label>分配时间：</label></td>
                    <td>
                    <input type="hidden" value="${requestScope.cs.dtime}" name="cs.dtime "/>
                      ${requestScope.cs.dtime }
                    </td>
                </tr>
                </s:if>
                <!--服务处理显示区块，类型代号：handle-->  
                <s:if test="#request.cs.statu==\"已分配\"">          
                <tr class="text-c handle">
                    <td colspan="4"></td>
                </tr>
                <tr class="text-c handle">
                    <td><label><span class="c-red">*</span>服务处理：</label></td>
                    <td colspan="3">
                        <div class="formControls col-xs-8 col-sm-9">
                            <textarea name="cs.deal" cols="" rows="" class="textarea" placeholder="请输入服务请求...最少输入10个字符" datatype="*10-100" dragonfly="true" nullmsg="备注不能为空！"></textarea>
                        </div>
                    </td>
                </tr>
                <tr class="text-c handle">
                    <td><label><span class="c-red">*</span>处理人：</label></td>
                    <td>
                        <div class="formControls col-xs-8 col-sm-9">
                            <input type="hidden" value="${sessionScope.loginer.id }" name="cs.dealman.id"/>
                            <input type="text" class="input-text" value="${sessionScope.loginer.name}" placeholder="当前登录人" disabled id="articletitle" name="cs.dealman.name">
                        </div>
                    </td>
                    <td><label><span class="c-red">*</span>处理时间：</label></td>
                    <td>
                        <div class="formControls col-xs-8 col-sm-9">
                            <input type="text" class="input-text" value="${requestScope.time}" placeholder="当前系统时间" disabled id="articletitle" name="cs.dealtime">
                        </div>
                    </td>
                </tr>
                   </s:if>
                   <s:if test="#request.cs.statu==\"已处理\" or #request.cs.statu==\"已归档\"">
                       <tr class="text-c handle">
                    <td colspan="4"></td>
                </tr>
                <tr class="text-c handle">
                    <td><label>服务处理：</label></td>
                    <td colspan="3">
                    <input type="hidden" value="${requestScope.cs.deal}" name="cs.deal "/>
                        ${requestScope.cs.deal }
                    </td>
                </tr>
                <tr class="text-c handle">
                    <td><label>处理人：</label></td>
                    <td>
                    <input type="hidden" value="${requestScope.cs.dealman.id}" name="cs.dealman.id "/>
                        ${requestScope.cs.dealman.name }
                    </td>
                    <td><label>处理时间：</label></td>
                    <td>
                    <input type="hidden" value="${requestScope.cs.dealtime}" name="cs.dealtime "/>
                        ${requestScope.cs.dealtime }
                    </td>
                </tr>
                   </s:if>
                <!--       处理结果操作显示区块，类型代号：result         -->
                <s:if test="#request.cs.statu==\"已处理\"">
                <tr class="text-c result">
                    <td colspan="4"></td>
                </tr>
                <tr class="text-c result">
                    <td><label><span class="c-red">*</span>处理结果：</label></td>
                    <td>
                        <div class="formControls col-xs-8 col-sm-9">
                            <input type="text" class="input-text" value="" placeholder="" id="articletitle" name="cs.result">
                        </div>
                    </td>
                    <td><label><span class="c-red">*</span>满意度：</label></td>
                    <td>
                        <div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<s:select list="#request.satisfactions" 
			  headerKey="-1"
			  headerValue="--请选择满意度--"
			  listKey="id"
			  listValue="context"
			  name="cs.csi.id"
			  class="select"
			  theme="simple"
			  />
				</span></div>
                    </td>
                </tr>
                </s:if>
                <s:if test="#request.cs.statu==\"已归档\"">
                <tr class="text-c result">
                    <td colspan="4"></td>
                </tr>
                <tr class="text-c result">
                    <td><label>处理结果：</label></td>
                    <td>
                    <input type="hidden" value="${requestScope.cs.result}" name="cs.result"/>
                        ${requestScope.cs.result }
                    </td>
                    <td><label>满意度：</label></td>
                    <td>
                    <input type="hidden" value="${requestScope.cs.csi.id}" name="cs.csi.id"/>
                        ${requestScope.cs.csi.context }
                    </td>
                </tr>
                </s:if>
                <!--     提交保存          -->
                <s:if test="#request.cs.statu!=\"已归档\"">
                <tr class="text-c">
                    <td colspan="4">
                        <div class="row cl">
                            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
                                <button onClick="article_save_submit();" class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存并提交审核</button>
                                <button onClick="removeIframe();" class="btn btn-default radius" type="reset">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
                            </div>
                        </div>
                    </td>
                </tr>
                </s:if>
            </table>
        </form>
    </article>


    <script type="text/javascript" src="${pageContext.request.contextPath }/lib/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/lib/layer/2.4/layer.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/h-ui/js/H-ui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/h-ui.admin/js/H-ui.admin.js"></script>
    <!--/_footer /作为公共模版分离出去-->
    <!--请在下方写此页面业务相关的脚本-->
    <script type="text/javascript" src="${pageContext.request.contextPath }/lib/My97DatePicker/4.8/WdatePicker.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/lib/webuploader/0.1.5/webuploader.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/lib/ueditor/1.4.3/ueditor.config.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/lib/ueditor/1.4.3/ueditor.all.min.js">


    </script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>
    <script type="application/javascript">
        $(function() {})

    </script>
</body>

</html>