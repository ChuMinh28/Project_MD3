<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/22/2022
  Time: 6:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>Amado - Furniture Ecommerce Template | Product Details</title>

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
            <a href="index.html"><img src="<%=request.getContextPath()%>/views/img/core-img/logo.png" alt=""></a>
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
            <a href="<%=request.getContextPath()%>/HomeServlet?action=Home"><img src="<%=request.getContextPath()%>/views/img/core-img/logo.png" alt=""></a>
        </div>
        <!-- Amado Nav -->
        <nav class="amado-nav">
            <ul>
                <li><a href="<%=request.getContextPath()%>/HomeServlet?action=Home">Home</a></li>
                <li><a href="<%=request.getContextPath()%>/HomeServlet?action=Shop">Shop</a></li>
                <li class="active"><a href="">Product</a></li>
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

    <!-- Product Details Area Start -->
    <div class="single-product-area section-padding-10 clearfix">
        <div class="container-fluid">

            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb mt-50">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item"><a href="#">Furniture</a></li>
                            <li class="breadcrumb-item active" aria-current="page">${product.productName}</li>
                        </ol>
                    </nav>
                </div>
            </div>

            <div class="row">
                <div class="col-12 col-lg-7">
                    <div class="single_product_thumb">
                        <div id="product_details_slider" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <c:forEach items="${product.listImageLink}" var="link">
                                <li data-target="#product_details_slider" data-slide-to="0" style="background-image: url(<%=request.getContextPath()%>/views/img/product-img/${link});">
                                </li>
                                </c:forEach>
                            </ol>
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <a class="gallery_img" href="<%=request.getContextPath()%>/views/img/product-img/${product.productImage}">
                                        <img class="d-block w-100" src="<%=request.getContextPath()%>/views/img/product-img/${product.productImage}" alt="${product.productName}">
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-lg-5">
                    <div class="single_product_desc">
                        <!-- Product Meta Data -->
                        <div class="product-meta-data">
                            <div class="line"></div>
                            <p class="product-price">$${product.price}</p>
                            <a href="product-details.jsp">
                                <h6>${product.productName}</h6>
                            </a>
                            <!-- Ratings & Review -->
                            <div class="ratings-review mb-15 d-flex align-items-center justify-content-between">
                                <div class="ratings">
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                </div>

                            </div>
                            <!-- Avaiable -->
                            <p class="avaibility"><i class="fa fa-circle"></i>  <c:out value="${product.productStatus==true?'Active':'Inactive'}"></c:out></p>
                        </div>
                        <div class="short_overview my-4">
                            <h6>${product.productTitle}</h6>
                        </div>
                        <div class="short_overview my-4">
                            <p>${product.descriptions}</p>
                        </div>

                        <!-- Add to Cart Form -->
                        <div class="cart clearfix">
                            <div class="cart-btn d-flex mb-50">
                                <p>Qty</p>
                                <div class="quantity">
                                    <span class="qty-minus" onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty ) &amp;&amp; qty &gt; 1 ) effect.value--;return false;"><i class="fa fa-caret-down" aria-hidden="true"></i></span>
                                    <input type="number" class="qty-text" id="qty" step="1" min="1" max="300" name="quantity" value="1">
                                    <span class="qty-plus" onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty )) effect.value++;return false;"><i class="fa fa-caret-up" aria-hidden="true"></i></span>
                                </div>
                            </div>
                            <a href="<%=request.getContextPath()%>/ShoppingCartServlet?action=AddToCart&&productID=${product.productID}" data-toggle="tooltip" data-placement="left" title="Add to Cart">
                            <button class="btn amado-btn">Add to cart</button></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="pt-5 mt-5">
            <h3 class="mb-5">2 Comments</h3>
            <ul class="children">
                <li class="comment">
                    <div class="vcard bio">
                        <img width="50" height="50" src="<%=request.getContextPath()%>/views/admin/img/avatars/avatar-4.jpg" alt="Image placeholder">
                    </div>
                    <div class="comment-body">
                        <h3>John Doe</h3>
                        <div class="meta">June 27, 2018 at 2:21pm</div>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Pariatur quidem laborum necessitatibus, ipsam impedit vitae autem, eum officia, fugiat saepe enim sapiente iste iure! Quam voluptas earum impedit necessitatibus, nihil?</p>
                    </div>
            </ul>

            <ul class="children">
                <li class="comment">
                    <div class="vcard bio">
                        <img width="50" height="50" src="<%=request.getContextPath()%>/views/admin/img/avatars/avatar-4.jpg" alt="Image placeholder">
                    </div>
                    <div class="comment-body">
                        <h3>John Doe</h3>
                        <div class="meta">June 27, 2018 at 2:21pm</div>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Pariatur quidem laborum necessitatibus, ipsam impedit vitae autem, eum officia, fugiat saepe enim sapiente iste iure! Quam voluptas earum impedit necessitatibus, nihil?</p>
                    </div>
                </li>
            </ul>

            <!-- END comment-list -->

            <div class="comment-form-wrap pt-5">
                <h3 class="mb-5">Leave a comment</h3>
                <form action="#" class="p-5 bg-light">
                    <div class="form-group">
                        <label for="name">Name *</label>
                        <input type="text" class="form-control" id="name">
                    </div>
                    <div class="form-group">
                        <label for="email">Email *</label>
                        <input type="email" class="form-control" id="email">
                    </div>
                    <div class="form-group">
                        <label for="website">Website</label>
                        <input type="url" class="form-control" id="website">
                    </div>

                    <div class="form-group">
                        <label for="message">Message</label>
                        <textarea name="" id="message" cols="30" rows="10" class="form-control"></textarea>
                    </div>
                    <div class="form-group">
                        <input type="submit" value="Post Comment" class="btn py-3 px-4 btn-primary">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- Product Details Area End -->
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
                                    <li class="nav-item">
                                        <a class="nav-link" href="index.jsp">Home</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="shop.jsp">Shop</a>
                                    </li>
                                    <li class="nav-item active">
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

</body>

</html>
