<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/22/2022
  Time: 6:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="description" content="">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

  <!-- Title  -->
  <title>Amado - Furniture Ecommerce Template | Checkout</title>

  <!-- Favicon  -->
  <link rel="icon" href="<%=request.getContextPath()%>/views/img/core-img/favicon.ico">

  <!-- Core Style CSS -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/views/css/core-style.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/views/style.css">

</head>

<body>
<!-- Search Wrapper Area Start -->
<div class="search-wrapper section-padding-100">
  <div class="search-close">
    <i class="fa fa-close" aria-hidden="true"></i>
  </div>
  <div class="container">
    <div class="row">
      <div class="col-12">
        <div class="search-content">
          <form action="<%=request.getContextPath()%>/HomeServlet" method="get">
            <input type="search" name="searchName" id="search" placeholder="Type your keyword...">
            <button name="action" value="SearchUser" type="submit"><img src="<%=request.getContextPath()%>/views/img/core-img/search.png" alt=""></button>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- Search Wrapper Area End -->

<!-- ##### Main Content Wrapper Start ##### -->
<div class="main-content-wrapper d-flex clearfix">

  <!-- Mobile Nav (max width 767px)-->
  <div class="mobile-nav">
    <!-- Navbar Brand -->
    <div class="amado-navbar-brand">
      <a href="index.jsp"><img src="../img/core-img/logo.png" alt=""></a>
    </div>
    <!-- Navbar Toggler -->
    <div class="amado-navbar-toggler">
      <span></span><span></span><span></span>
    </div>
  </div>

  <!-- Header Area Start -->
  <jsp:include page="header.jsp"/>
  <!-- Header Area End -->

  <div class="cart-table-area section-padding-10">
    <div class="container-fluid">
      <div class="row">
        <div class="col-12 col-lg-8">
          <div class="checkout_details_area mt-50 clearfix">

            <div class="cart-title">
              <h2>Check Out</h2>
            </div>

            <form action="<%=request.getContextPath()%>/OrderServlet" method="post">
              <div class="row">
                <div class="col-md-12 mb-3">
                  <input type="hidden" class="form-control" name="userID" value="${userLogin.userID}" placeholder="Full Name" required>
                </div>
                <div class="col-md-12 mb-3">
                  <input type="text" class="form-control" name="fullName" value="${userLogin.fullName}" placeholder="Full Name" required>
                </div>
                <div class="col-12 mb-3">
                  <input type="text" class="form-control" required name="address" placeholder="Address" value="${userLogin.address}">
                </div>
                <div class="col-md-12 mb-3">
                  <input type="text" class="form-control" required name="phone" placeholder="Phone No" value="${userLogin.phone}">
                </div>
                <div class="col-md-12 mb-3">
                  <input type="submit" class="checkout btn amado-btn w-100" name="action" value="Payment">
                </div>
                <div class="col-12">
                  <div class="cart-table clearfix">
                    <table class="table table-responsive">
                      <thead>
                      <tr>
                        <th></th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                      </tr>
                      </thead>
                      <tbody>
                      <c:forEach items="${listCart}" var="cart">
                        <tr>
                          <td class="cart_product_img">
                            <a href="#"><img src="<%=request.getContextPath()%>/views/img/product-img/${cart.product.productImage}" alt="${cart.product.productName}"></a>
                          </td>
                          <td class="cart_product_desc">
                            <h5 style="margin-top: 5px">${cart.product.productName}</h5>
                          </td>
                          <td class="price">
                            <span>$${cart.product.price}</span>
                          </td>
                          <td class="qty">
                            <div class="qty-btn d-flex">
                              <p>${cart.quantity}</p>
                            </div>
                          </td>
                        </tr>
                      </c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div>
                </div>
            </form>
          </div>
        </div>
        <div class="col-12 col-lg-4">
          <div class="cart-summary">
            <h5>Cart Total</h5>
            <ul class="summary-table">
              <li><span>Name:</span> <span>${userLogin.fullName}</span></li>
              <li><span>delivery:</span> <span>Free</span></li>
              <li><span>total:</span> <span>${total}</span></li>
            </ul>

            <div class="payment-method">
              <!-- Cash on delivery -->
              <div class="custom-control custom-checkbox mr-sm-2">
                <input type="checkbox" class="custom-control-input" id="cod" checked>
                <label class="custom-control-label" for="cod">Cash on Delivery</label>
              </div>
              <!-- Paypal -->

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- ##### Newsletter Area End ##### -->

<!-- ##### Footer Area Start ##### -->
<footer class="footer_area clearfix">
  <div class="container">
    <div class="row align-items-center">
      <!-- Single Widget Area -->
      <div class="col-12 col-lg-4">
        <div class="single_widget_area">
          <!-- Logo -->
          <div class="footer-logo mr-50">
            <a href="index.html"><img src="<%=request.getContextPath()%>/views/img/core-img/logo2.png" alt=""></a>
          </div>
          <!-- Copywrite Text -->

          <p class="copywrite"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a> & Re-distributed by <a href="https://themewagon.com/" target="_blank">Themewagon</a>
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
        </div>
      </div>
      <!-- Single Widget Area -->
      <div class="col-12 col-lg-8">
        <div class="single_widget_area">
          <!-- Footer Menu -->
          <div class="footer_menu">
            <nav class="navbar navbar-expand-lg justify-content-end">
              <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#footerNavContent" aria-controls="footerNavContent" aria-expanded="false" aria-label="Toggle navigation"><i class="fa fa-bars"></i></button>
              <div class="collapse navbar-collapse" id="footerNavContent">
                <ul class="navbar-nav ml-auto">
                  <li class="nav-item">
                    <a class="nav-link" href="index.jsp">About us</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Home</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="shop.jsp">Shop</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="product-details.jsp">Product</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="cart.jsp">Cart</a>
                  </li>
                  <li class="nav-item active">
                    <a class="nav-link" href="checkout.jsp">Check Out</a>
                  </li>
                </ul>
              </div>
            </nav>
          </div>
        </div>
      </div>
    </div>
  </div>
</footer>
<!-- ##### Footer Area End ##### -->

<!-- ##### jQuery (Necessary for All JavaScript Plugins) ##### -->
<script src="<%=request.getContextPath()%>/views/js/jquery/jquery-2.2.4.min.js"></script>
<!-- Popper js -->
<script src="<%=request.getContextPath()%>/views/js/popper.min.js"></script>
<!-- Bootstrap js -->
<script src="<%=request.getContextPath()%>/views/js/bootstrap.min.js"></script>
<!-- Plugins js -->
<script src="<%=request.getContextPath()%>/views/js/plugins.js"></script>
<!-- Active js -->
<script src="<%=request.getContextPath()%>/views/js/active.js"></script>

</body>

</html>