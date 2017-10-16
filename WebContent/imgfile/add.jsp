<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>上传图片</title>
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

<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/img/imgFileup.action" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td class="tableleft">上传文件</td>
        <td><input type="file" name="item_pic"/></td>
    </tr>
    <tr>
        <td class="tableleft">标题</td>
        <td><input type="text" name="img_name"/></td>
    </tr>
    <tr>
        <td class="tableleft">拍摄时间</td>
        <td><input type="text" name="img_time"/></td>
    </tr>
    <tr>
        <td class="tableleft">类型</td>
         <td>
	        <c:forEach items="${img_typeList }" var="type" varStatus="vs">  
	           <input type="radio" name="img_type_name" value="${type.img_type_name }"/>
	            ${type.img_type_name } &nbsp;&nbsp;
			</c:forEach>
		</td>
    </tr>
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid" onclick="back()">返回列表</button>
        </td>
    </tr>
</table>
</form>
</body>
</html>
<script>
    function back(){
				window.location.href="${pageContext.request.contextPath}/admin/findAllAdmin.action";
		 }
</script>