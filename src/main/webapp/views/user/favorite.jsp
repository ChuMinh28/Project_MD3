<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/22/2022
  Time: 6:56 PM
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
  <title>Amado - Furniture Ecommerce Template | Favorite List</title>

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
          <form action="#" method="get">
            <input type="search" name="search" id="search" placeholder="Type your keyword...">
            <button type="submit"><img src="../img/core-img/search.png" alt=""></button>
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
      <a href="<%=request.getContextPath()%>/views/user/index.jsp"><img src="<%=request.getContextPath()%>/views/img/core-img/logo.png" alt=""></a>
    </div>
    <!-- Navbar Toggler -->
    <div class="amado-navbar-toggler">
      <span></span><span></span><span></span>
    </div>
  </div>

  <!-- Header Area Start -->
  <header class="header-area clearfix">
    <!-- Close Icon -->
    <div class="nav-close">
      <i class="fa fa-close" aria-hidden="true"></i>
    </div>
    <!-- Logo -->
    <div class="logo">
      <a href="<%=request.getContextPath()%>/views/user/index.jsp"><img src="<%=request.getContextPath()%>/views/img/core-img/logo.png" alt=""></a>
    </div>
    <!-- Amado Nav -->
    <nav class="amado-nav">
      <ul>
        <li><a href="<%=request.getContextPath()%>/HomeServlet?action=Home">Home</a></li>
        <li class="active"><a href="<%=request.getContextPath()%>/HomeServlet?action=Shop">Shop</a></li>
      </ul>
    </nav>
    <!-- Button Group -->
    <div class="amado-btn-group mt-10 mb-10">
      <c:choose>
        <c:when test="${empty account}">
          <a class="btn-discount btn amado-btn mb-15" href="<%=request.getContextPath()%>/views/user/login.jsp">Login</a>
        </c:when>
        <c:otherwise>
          <a href="<%=request.getContextPath()%>/UserServlet?action=LogOut" class="btn-discount btn amado-btn mb-15">Log Out</a>
        </c:otherwise>
      </c:choose>
    </div>
    <!-- Cart Menu -->
    <div class="cart-fav-search mb-100">
      <a href="<%=request.getContextPath()%>/views/user/cart.jsp" class="cart-nav"><img src="<%=request.getContextPath()%>/views/img/core-img/cart.png" alt=""> Cart <span>(0)</span></a>
      <a href="<%=request.getContextPath()%>/WishListServlet?action=GetAll" class="fav-nav"><img src="<%=request.getContextPath()%>/views/img/core-img/favorites.png" alt=""> Favourite</a>
      <a href="#" class="search-nav"><img src="<%=request.getContextPath()%>/views/img/core-img/search.png" alt=""> Search</a>
    </div>
    <!-- Social Button -->
    <div class="social-info d-flex justify-content-between">
      <a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a>
      <a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a>
      <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
      <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
    </div>
  </header>
  <!-- Header Area End -->


  <div class="amado_product_area section-padding-100">
    <div class="container-fluid">

      <div class="row">
        <div class="col-12">
          <div class="product-topbar d-xl-flex align-items-end justify-content-between">
            <!-- Total Products -->
            <h2>Favorite List</h2>
          </div>
        </div>
      </div>

      <div class="row">

        <!-- Single Product Area -->
        <c:forEach items="${listProduct}" var="pro">
        <div class="col-6 col-sm-3 col-md-6 col-xl-3">
          <div class="single-product-wrapper">
            <!-- Product Image -->
            <div class="product-img">
              <a href="<%=request.getContextPath()%>/HomeServlet?action=Detail&&productID=${pro.productID}">
              <img src="<%=request.getContextPath()%>/views/img/product-img/${pro.productImage}" alt="${pro.productName}">
              <!-- Hover Thumb -->
              </a>
            </div>

            <!-- Product Description -->
            <div class="product-description d-flex align-items-center justify-content-between">
              <!-- Product Meta Data -->
              <div class="product-meta-data">
                <div class="line"></div>
                <p class="product-price">$${pro.price}</p>
                <a href="product-details.jsp">
                  <h6>${pro.productName}</h6>
                </a>
              </div>
              <!-- Ratings & Cart -->
              <div class="ratings-cart text-right">
                <div class="ratings">
                  <i class="fa fa-star" aria-hidden="true"></i>
                  <i class="fa fa-star" aria-hidden="true"></i>
                  <i class="fa fa-star" aria-hidden="true"></i>
                  <i class="fa fa-star" aria-hidden="true"></i>
                  <i class="fa fa-star" aria-hidden="true"></i>
                </div>
                <div class="cart">
                  <a href="<%=request.getContextPath()%>/WishListServlet?action=Delete&&productID=${pro.productID}" data-toggle="tooltip" data-placement="left" title="Delete"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                    <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                    <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                  </svg></a>
                  <a href="<%=request.getContextPath()%>/ShoppingCartServlet?action=AddToCart&&productID=${pro.productID}" data-toggle="tooltip" data-placement="left" title="Add to Cart"><img src="<%=request.getContextPath()%>/views/img/core-img/cart.png" alt=""></a>
                </div>
              </div>
            </div>
          </div>
        </div>
        </c:forEach>

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
            <a href="index.jsp"><img src="../img/core-img/logo2.png" alt=""></a>
          </div>
          <!-- Copywrite Text -->
          <p class="copywrite"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a> & Re-distributed by <a href="https://themewagon.com/" target="_blank">Themewagon</a>
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
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
                  <li class="nav-item">
                    <a class="nav-link" href="checkout.jsp">Checkout</a>
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