package project.controller;

import project.model.entity.Cart;
import project.model.entity.Product;
import project.model.service.ProductService;
import project.model.serviceImp.ProductServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShoppingCartServlet", value = "/ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
    private ProductService<Product,Integer> productService = new ProductServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("AddToCart")) {
            int productID = Integer.parseInt(request.getParameter("productID"));
            Product productAdd = new Product();
            for (Product pro:productService.findAll()) {
                if (pro.getProductID() == productID) {
                    productAdd = pro;
                }
            }
            HttpSession session = request.getSession();
            List<Cart> listCart =(List<Cart>) session.getAttribute("listCart");

            if (listCart == null) {
                //Khách chưa mua hàng
                listCart = new ArrayList<>();
                if (productAdd.isProductStatus()) {
                    if (productAdd.getQuantity() > 0) {
                        Cart cart = new Cart(productAdd,1);
                        listCart.add(cart);
                    } else {
                        request.getRequestDispatcher("views/user/error.jsp").forward(request,response);
                    }
                } else {
                    request.getRequestDispatcher("views/user/error.jsp").forward(request,response);

                }
            } else {
                //Khách đã mua hàng
                boolean checkExist = false;
                for (Cart cart:listCart) {
                    if (cart.getProduct().getProductID() == productID) {
                        if (cart.getProduct().getQuantity() > 0) {
                            cart.setQuantity(cart.getQuantity()+1);
                            checkExist = true;
                            break;
                        }
                    }
                }
                if (!checkExist){
                    Cart cart = new Cart(productAdd,1);
                    listCart.add(cart);
                }
            }
            float totalAmount = 0F;
            //Add listCart vao Session
            for (Cart cart:listCart) {
                totalAmount+=cart.getProduct().getPrice()*cart.getQuantity();
            }
            session.setAttribute("total",totalAmount);
            session.setAttribute("listCart",listCart);
            //Chuyen sang trang Cart
            request.getRequestDispatcher("views/user/cart.jsp").forward(request,response);
        } else if (action.equals("Delete")) {
            int productID = Integer.parseInt(request.getParameter("productID"));
            List<Cart> listCart = (List<Cart>) request.getSession().getAttribute("listCart");
            for (int i = 0; i < listCart.size(); i++) {
                if (listCart.get(i).getProduct().getProductID() == productID) {
                    listCart.remove(i);
                    break;
                }
            }
            request.getSession().setAttribute("listCart",listCart);
            float totalAmount = 0F;
            //Add listCart vao Session
            for (Cart cart:listCart) {
                totalAmount+=cart.getProduct().getPrice()*cart.getQuantity();
            }
            request.getSession().setAttribute("total",totalAmount);
            request.getRequestDispatcher("views/user/cart.jsp").forward(request,response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
