<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/22/2022
  Time: 7:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->

<!DOCTYPE html>
<html>

<!-- Head -->
<head>

  <title>Login</title>

  <!-- Meta-Tags -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta name="keywords" content="Existing Login Form Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design">
  <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
  <!-- //Meta-Tags -->

  <link href="<%=request.getContextPath()%>/views/css/popuo-box.css" rel="stylesheet" type="text/css" media="all" />

  <!-- Style --> <link rel="stylesheet" href="<%=request.getContextPath()%>/views/css/style.css" type="text/css" media="all">

  <!-- Fonts -->
  <link href="//fonts.googleapis.com/css?family=Quicksand:300,400,500,700" rel="stylesheet">
  <!-- //Fonts -->

</head>
<!-- //Head -->

<!-- Body -->
<body>

<h1>WELCOME BACK</h1>

<div class="w3layoutscontaineragileits">
  <h2>Login</h2>
  <form action="<%=request.getContextPath()%>/UserServlet" method="post">
    <input type="text" Name="account" placeholder="USER" required="">
    <input type="password" Name="passWord" placeholder="PASSWORD" required="">
    <input type="hidden" name="pageRequestLogin" value="<%=request.getParameter("pageRequestLogin")%>"/>
    <p style="color: red;"><c:if test="${errorLogin!=null}">${errorLogin}</c:if></p>
    <ul class="agileinfotickwthree">
      <li  style="padding: 10px">
        <input type="checkbox" id="brand1" value="">
        <label for="brand1"><span></span>Remember me</label>
        <a href="error.jsp">Forgot password?</a>
      </li>
    </ul>
    <div class="aitssendbuttonw3ls">
      <input type="submit" name="action" value="login">
      <p> To register new account <span>→</span> <a class="w3_play_icon1" href="#small-dialog1"> Click Here</a></p>
      <div class="clear"></div>
    </div>
  </form>
</div>

<!-- for register popup -->
<div id="small-dialog1" class="mfp-hide">
  <div class="contact-form1">
    <div class="contact-w3-agileits">
      <h3>Register Form</h3>
      <form action="<%=request.getContextPath()%>/userController/create?" method="post">
        <div class="form-sub-w3ls">
          <input placeholder="User Name" name="userAccount"  type="text" required="">
          <div class="icon-agile">
            <i class="fa fa-user" aria-hidden="true"></i>
          </div>
        </div>
        <div class="form-sub-w3ls">
          <input placeholder="Full Name" name="fullName"  type="text" required="">
          <div class="icon-agile">
            <i class="fa fa-user" aria-hidden="true"></i>
          </div>
        </div>
        <div class="form-sub-w3ls">
          <input placeholder="Address" name="address"  type="text" required="">
          <div class="icon-agile">
            <i class="fa fa-user" aria-hidden="true"></i>
          </div>
        </div>
        <div class="form-sub-w3ls">
          <input placeholder="Phone" name="phone"  type="text" required="">
          <div class="icon-agile">
            <i class="fa fa-user" aria-hidden="true"></i>
          </div>
        </div>
        <div class="form-sub-w3ls">
          <input placeholder="Password" name="userPassWord"  type="password" required="">
          <div class="icon-agile">
            <i class="fa fa-unlock-alt" aria-hidden="true"></i>
          </div>
        </div>
        <div class="form-sub-w3ls">
          <input placeholder="Confirm Password" name="confirm"  type="password" required="">
          <div class="icon-agile">
            <i class="fa fa-unlock-alt" aria-hidden="true"></i>
          </div>
        </div>
        <div class="login-check">
          <label class="checkbox"><input type="checkbox" name="checkbox" checked="">I Accept Terms & Conditions</label>
        </div>
        <div class="submit-w3l">
          <input type="submit" name="action" value="Register">
        </div>
      </form>
    </div>
  </div>
</div>
<!-- //for register popup -->

<div class="w3footeragile">
  <p> &copy; 2017 Existing Login Form. All Rights Reserved | Design by <a href="http://w3layouts.com" target="_blank">W3layouts</a></p>
</div>


<script type="text/javascript" src="<%=request.getContextPath()%>/views/js/jquery-2.1.4.min.js"></script>

<!-- pop-up-box-js-file -->
<script src="<%=request.getContextPath()%>/views/js/jquery.magnific-popup.js" type="text/javascript"></script>
<!--//pop-up-box-js-file -->
<script>
  $(document).ready(function() {
    $('.w3_play_icon,.w3_play_icon1,.w3_play_icon2').magnificPopup({
      type: 'inline',
      fixedContentPos: false,
      fixedBgPos: true,
      overflowY: 'auto',
      closeBtnInside: true,
      preloader: false,
      midClick: true,
      removalDelay: 300,
      mainClass: 'my-mfp-zoom-in'
    });

  });
</script>

</body>
<!-- //Body -->
</html>