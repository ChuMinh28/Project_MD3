package project.controller;

import project.model.entity.Catalog;
import project.model.entity.Product;
import project.model.entity.User;
import project.model.service.CatalogService;
import project.model.service.ProductService;
import project.model.service.UserService;
import project.model.serviceImp.CatalogServiceImp;
import project.model.serviceImp.ProductServiceImp;
import project.model.serviceImp.UserServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    private UserService<User,Integer> userService = new UserServiceImp();
    private CatalogService<Catalog,Integer> catalogService = new CatalogServiceImp();
    private ProductService<Product,Integer> productService = new ProductServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equals("GetAll")){
            getAllUser(request,response);
        } else if (action.equals("Unlock")) {
            int userID = Integer.parseInt(request.getParameter("userID"));
            boolean unlock = userService.unLockUser(userID);
            if (unlock) {
                getAllUser(request,response);
            }
        } else if (action.equals("Lock")) {
            int userID = Integer.parseInt(request.getParameter("userID"));
            boolean lock = userService.lockUser(userID);
            if (lock) {
                getAllUser(request,response);
            }
        } else if (action.equals("CheckOut")) {
            String userName = String.valueOf(request.getSession().getAttribute("userLogin"));
            if (userName == "null") {
                //Chua dang nhap --> Login
                String pageRequestLogin = request.getParameter("pageRequestLogin");
                request.setAttribute("pageRequestLogin",pageRequestLogin);
                request.getRequestDispatcher("views/user/login.jsp").forward(request,response);
            } else {
                request.getRequestDispatcher("views/user/checkout.jsp").forward(request,response);
            }
        } else if (action.equals("LogOut")) {
            HttpSession session = request.getSession();
            session.removeAttribute("userLogin");
            request.setAttribute("listProduct",productService.getProductHome());
            request.setAttribute("listCatalog",catalogService.findAll());
            request.getRequestDispatcher("views/user/index.jsp").forward(request,response);
        }
        getAllUser(request,response);
    }
    public void getAllUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> listUser = userService.findAll();
        request.setAttribute("listUser",listUser);
        request.getRequestDispatcher("views/admin/listUser.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action != null && action.equals("Register")) {
            User userNew = new User();
            userNew.setUserAccount(request.getParameter("account"));
            userNew.setFullName(request.getParameter("fullName"));
            userNew.setAddress(request.getParameter("address"));
            userNew.setPhone(request.getParameter("phone"));
            userNew.setUserPassWord(request.getParameter("passWord"));
            String confirm = request.getParameter("confirm");
            if (userNew.getUserPassWord().equals(confirm)){
                boolean result = userService.save(userNew);
                if (result) {
                    request.getRequestDispatcher("views/user/login.jsp").forward(request,response);
                } else {
                    request.getRequestDispatcher("views/user/error.jsp").forward(request,response);
                }
            } else {
                request.getRequestDispatcher("views/user/error.jsp").forward(request,response);
            }
        } else if (action!=null && action.equals("login")) {
            String account = request.getParameter("account");
            String pass = request.getParameter("passWord");
            if (account.equals("admin")&&pass.equals("123")) {
                List<Catalog> listCatalog = catalogService.findAll();
                request.setAttribute("listCatalog",listCatalog);
                request.getRequestDispatcher("views/admin/listCatalog.jsp").forward(request,response);
            }
            User user = userService.checkLogIn(account,pass);
            if (user!=null){
                HttpSession session = request.getSession();
                session.setAttribute("userLogin",user);
                if (user.isPermission()) {
                    if (user.isUserStatus()) {
                        String pageRequestLogin = request.getParameter("pageRequestLogin");
                        if (pageRequestLogin.equals("/views/user/cart.jsp")) {
                            response.sendRedirect(pageRequestLogin);
                        } else {
                            request.getRequestDispatcher("index.jsp").forward(request,response);
                        }

                    } else {
                        request.setAttribute("errorLogin","Tài khoản tạm thời đang bị khóa");
                        request.getRequestDispatcher("views/user/login.jsp").forward(request,response);
                    }
                } else {
                    request.setAttribute("errorLogin","UserName or PassWord Incorrect");
                    request.getRequestDispatcher("views/user/login.jsp").forward(request,response);
                }
            }
        }
    }
}
