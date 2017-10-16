<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>管理员列表</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="../css/style.css" />
    <script type="text/javascript" src="../Js/jquery.js"></script>
    <script type="text/javascript" src="../Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="../Js/bootstrap.js"></script>
    <script type="text/javascript" src="../Js/ckform.js"></script>
    <script type="text/javascript" src="../Js/common.js"></script>

 

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
</head>
<body>
<form class="form-inline definewidth m20" action="${pageContext.request.contextPath }/admin/selectAdminByName.action" method="get">    
    姓名查询：
    <input type="text" name="username" id="username" class="abc input-default" placeholder="" value="">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; <button type="button" class="btn btn-success" id="addnew" onclick="return add()">新增用户</button>
</form>

<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>管理员id</th>
        <th>管理员账号</th>
        <th>真实姓名</th>
        <th>邮箱</th>
        <th>操作</th>
    </tr>
    </thead>
    	
    	<c:forEach items="${adminList }" var="admin" varStatus="vs">  
        <tr>  
              
            <td>${admin.admin_id}</td>  
            <td>${admin.admin_username }</td>
            <td>${admin.admin_name }</td>
            <td>${admin.admin_email }</td> 
            <td>
                <a href="${pageContext.request.contextPath }/admin/selectAdminById.action?admin_id=${admin.admin_id}">编辑</a>
                <a href="${pageContext.request.contextPath }/admin/deleteAdmin.action?admin_id=${admin.admin_id}">删除</a>              
	        </td>  
         </tr>  
		</c:forEach>  
    	
	<!--     
	     <tr>
            <td>2</td>
            <td>admin</td>
            <td>管理员</td>
            <td></td>
            <td>
                <a href="edit.html">编辑</a>                
            </td>
        </tr>	
         -->
</table>
</body>
</html>
<script>
    $(function () {
        

		$('#addnew').onclick(function(){

				window.location.href="${pageContext.request.contextPath }/Admin/add.html";
		 });


    });

    function add()
	{
    	window.location.href="../Admin/add.jsp";
		
	}
    
	function del(id)
	{
		
		
		if(confirm("确定要删除吗？"))
		{
		
			var url = "index.html";
			
			window.location.href=url;		
		
		}
	
	}
</script>