package project.controller;

import project.model.entity.Product;
import project.model.entity.User;
import project.model.entity.WishList;
import project.model.service.ProductService;
import project.model.service.WishListService;
import project.model.serviceImp.ProductServiceImp;
import project.model.serviceImp.WishListServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "WishListServlet", value = "/WishListServlet")
public class WishListServlet extends HttpServlet {
    private WishListService<WishList,Integer> wishListService = new WishListServiceImp();
    private ProductService<Product,Integer> productService = new ProductServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        User user = (User) request.getSession().getAttribute("userLogin");
        if (action.equals("GetAll")) {
            String userName = String.valueOf(request.getSession().getAttribute("userLogin"));
            if (userName == "null") {
                //Chua dang nhap --> Login
                String pageRequestLogin = request.getParameter("pageRequestLogin");
                request.setAttribute("pageRequestLogin",pageRequestLogin);
                request.getRequestDispatcher("views/user/login.jsp").forward(request,response);
            }
            else {
                getAllWishList(request,response);
            }
        } else if (action.equals("AddToFavorite")) {
            String userName = String.valueOf(request.getSession().getAttribute("userLogin"));
            if (userName == "null") {
                //Chua dang nhap --> Login
                String pageRequestLogin = request.getParameter("pageRequestLogin");
                request.setAttribute("pageRequestLogin",pageRequestLogin);
                request.getRequestDispatcher("views/user/login.jsp").forward(request,response);
            }
            WishList wishList = new WishList();
            int productID = Integer.parseInt(request.getParameter("productID"));
            Product product = productService.findById(productID);
            wishList.setUserID(user.getUserID());
            wishList.setProduct(product);
            boolean result = wishListService.save(wishList);
            if (result) {
                getAllWishList(request,response);
            } else {
                request.getRequestDispatcher("views/user/error.jsp").forward(request,response);
            }
        } else if (action.equals("Delete")) {
            int productID = Integer.parseInt(request.getParameter("productID"));
            boolean result = wishListService.delete(productID);
            if (result) {
                getAllWishList(request,response);
            } else {
                request.getRequestDispatcher("views/user/error.jsp").forward(request,response);
            }
        }
        getAllWishList(request,response);
    }
    public void getAllWishList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("userLogin");
        request.setAttribute("listProduct",wishListService.getWishList(user.getUserID()));
        request.getRequestDispatcher("views/user/favorite.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("userLogin");
        String action = request.getParameter("action");

    }
}
