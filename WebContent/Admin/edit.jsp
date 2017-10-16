<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
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
<form action="${pageContext.request.contextPath}/admin/updateAdmin.action" method="post" class="definewidth m20">
<input type="hidden" name="admin_id" value="${admin.admin_id}""/>
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
        <td width="10%" class="tableleft">登录名</td>
        <td><input type="text" name="admin_username" value="${admin.admin_username }"/></td>
    </tr>
    <tr>
        <td class="tableleft">密码</td>
        <td><input type="password" name="admin_password" value="${admin.admin_password }"/></td>
    </tr>
    <tr>
        <td class="tableleft">真实姓名</td>
        <td><input type="text" name="admin_name" value="${admin.admin_name }"/></td>
    </tr>
    <tr>
        <td class="tableleft">电话</td>
        <td><input type="text" name="admin_phone" value="${admin.admin_phone }"/></td>
    </tr>
    <tr>
        <td class="tableleft">邮箱</td>
        <td><input type="text" name="admin_email" value="${admin.admin_email }"/></td>
    </tr>
    <tr>
        <td class="tableleft">角色</td>
        <td>
        	<input type="radio" name="admin_action_id" value="1"/> 超级管理员
           <input type="radio" name="admin_action_id" value="2" checked="checked"/> 1级管理员
           <input type="radio" name="admin_action_id" value="3"/> 普通管理员
        </td>
    </tr>
        <tr>
            <td class="tableleft"></td>
            <td>
                <button type="submit" class="btn btn-primary" type="button">保存</button>				 &nbsp;&nbsp;<button type="button" onclick="back()" class="btn btn-success" name="backid" id="backid">返回列表</button>
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