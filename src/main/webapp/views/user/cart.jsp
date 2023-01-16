<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/22/2022
  Time: 6:38 PM
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
  <title>Amado - Furniture Ecommerce Template | Cart</title>
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
      <a href="index.jsp"><img src="<%=request.getContextPath()%>/views/img/core-img/logo.png" alt=""></a>
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
          <div class="cart-title mt-50">
            <h2>Shopping Cart</h2>
          </div>

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
                      <a style="padding: 15px" href="<%=request.getContextPath()%>/ShoppingCartServlet?action=Delete&&productID=${cart.product.productID}"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                        <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                        <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                      </svg></a>
                  </div>

                </td>
              </tr>
              </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
        <div class="col-12 col-lg-4">
          <div class="cart-summary">
            <h5>Cart Total</h5>
            <ul class="summary-table">
              <li><span>Name:</span> <span>${userLogin.fullName}</span></li>
              <li><span>delivery:</span> <span>Free</span></li>
              <li><span>total:</span> <span>
                $${total}
              </span></li>
            </ul>
            <div class="cart-btn mt-100">
              <a href="<%=request.getContextPath()%>/UserServlet?action=CheckOut&&pageRequestLogin=${pageContext.request.requestURI}" class="checkout btn amado-btn w-100">Payment</a>
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
            <a href="index.jsp"><img src="<%=request.getContextPath()%>/views/img/core-img/logo2.png" alt=""></a>
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
                  <li class="nav-item active">
                    <a class="nav-link" href="cart.jsp">Cart</a>
                  </li>
                  <li class="nav-item">
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