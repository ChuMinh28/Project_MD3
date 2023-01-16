<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/22/2022
  Time: 5:27 PM
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
    <title>Amado - Furniture Ecommerce Template | Home</title>

    <!-- Favicon  -->
    <link rel="icon" href="<%=request.getContextPath()%>/views/img/core-img/favicon.ico">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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
                <li class="active"><a href="<%=request.getContextPath()%>/HomeServlet?action=Home">Home</a></li>
                <li><a href="<%=request.getContextPath()%>/HomeServlet?action=Shop">Shop</a></li>
            </ul>
        </nav>
        <!-- Button Group -->
        <div class="amado-btn-group mt-10 mb-10">
            <c:choose>
                <c:when test="${empty userLogin}">
                    <a class="btn-discount btn amado-btn mb-15" href="<%=request.getContextPath()%>/views/user/login.jsp">Login</a>
                </c:when>
                <c:otherwise>
                    <a href="<%=request.getContextPath()%>/UserServlet?action=LogOut" class="btn-discount btn amado-btn mb-15">Log Out</a>
                </c:otherwise>
            </c:choose>
        </div>
        <!-- Cart Menu -->
        <div class="cart-fav-search mb-100">
            <a href="<%=request.getContextPath()%>/views/user/cart.jsp" class="cart-nav"><img src="<%=request.getContextPath()%>/views/img/core-img/cart.png" alt=""> Cart <span></span></a>
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

    <!-- Product Catagories Area Start -->
    <div class="products-catagories-area clearfix">
        <!-- Header Banner -->
        <div id="carouselExampleFade" class="carousel slide carousel-fade" data-bs-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="<%=request.getContextPath()%>/views/img/banner/banner1.webp" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="<%=request.getContextPath()%>/views/img/banner/banner2.webp" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="<%=request.getContextPath()%>/views/img/banner/banner3.webp" class="d-block w-100" alt="...">
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
        <!--End Header Banner -->
        <div class="amado-pro-catagory clearfix">

            <!-- Single Catagory -->
            <c:forEach items="${listProduct}" var="pro">
            <div class="single-products-catagory clearfix">
                <a href="<%=request.getContextPath()%>/HomeServlet?action=Detail&&productID=${pro.productID}">
                    <img src="<%=request.getContextPath()%>/views/img/product-img/${pro.productImage}" alt="${pro.productName}">
                    <!-- Hover Content -->
                    <div class="hover-content">
                        <div class="line"></div>
                        <p>From $${pro.price}</p>
                        <h4>${pro.productName}</h4>
                    </div>
                </a>
            </div>
            </c:forEach>
        </div>
    </div>
    <!-- Product Catagories Area End -->
</div>
<!-- ##### Main Content Wrapper End ##### -->

<!-- ##### Newsletter Area Start ##### -->
<!-- <section class="newsletter-area section-padding-100-0">
    <div class="container">
        <div class="row align-items-center"> -->
<!-- Newsletter Text -->
<!-- <div class="col-12 col-lg-6 col-xl-7">
    <div class="newsletter-text mb-100">
        <h2>Subscribe for a <span>25% Discount</span></h2>
        <p>Nulla ac convallis lorem, eget euismod nisl. Donec in libero sit amet mi vulputate consectetur. Donec auctor interdum purus, ac finibus massa bibendum nec.</p>
    </div>
</div> -->
<!-- Newsletter Form -->
<!-- <div class="col-12 col-lg-6 col-xl-5">
    <div class="newsletter-form mb-100">
        <form action="#" method="post">
            <input type="email" name="email" class="nl-email" placeholder="Your E-mail">
            <input type="submit" value="Subscribe">
        </form>
    </div>
</div>
</div>
</div>
</section> -->
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
                                    <li class="nav-item active">
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
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>