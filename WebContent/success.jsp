<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>Login Page | LOADING...</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="format-detection" content="telephone=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="alternate icon" type="image/png" href="assets/i/favicon.png">
  <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
  <script src="http://code.jquery.com/jquery-2.1.3.min.js"></script>
  <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  <style>
            .loader {
                position: fixed;
                left: 0px;
                top: 0px;
                width: 100%;
                height: 100%;
                z-index: 9999;
                background: url('http://img.zcool.cn/community/01ec5a5996ac89a8012156033739b5.gif') 50% 50% no-repeat rgb(255,255,255);
            }
        </style>
  
</head>
<body>
<div class="loader"></div>
        <script type="text/javascript">
            $(window).load(function() {
                $(".loader").fadeOut("slow");
            })
        </script>
        
 <h3 class="text-center">欢迎回来，${sessionScope.username}<br/>
<small>正在跳转，请稍后......</small></h3>      


<script type="text/javascript">
$(document).ready(function () {    
            //$("#submitbtn").click(function(){    
                              setTimeout(function(){//两秒后跳转  
                                 location.href = "${pageContext.request.contextPath}/admin_index.jsp";//PC网页式跳转  
                              },2000);  
           // });    
    
        }); 
        
</script>


</body>
</html>
