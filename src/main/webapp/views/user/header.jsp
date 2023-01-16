<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/22/2022
  Time: 5:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Search Wrapper Area Start -->
<header class="header-area clearfix">
    <!-- Close Icon -->
    <div class="nav-close">
        <i class="fa fa-close" aria-hidden="true"></i>
    </div>
    <!-- Logo -->
    <div class="logo">
        <a href="index.jsp"><img src="<%=request.getContextPath()%>/views/img/core-img/logo.png" alt=""></a>
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