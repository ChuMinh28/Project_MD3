package project.controller;

import project.model.entity.Catalog;
import project.model.entity.Product;
import project.model.service.CatalogService;
import project.model.service.ProductService;
import project.model.serviceImp.CatalogServiceImp;
import project.model.serviceImp.ProductServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HomeServlet", value = "/HomeServlet")
public class HomeServlet extends HttpServlet {
    private ProductService<Product, Integer> productService = new ProductServiceImp();
    private CatalogService<Catalog, Integer> catalogService = new CatalogServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("Home")){
            request.setAttribute("listProduct",productService.findAll());
            request.getRequestDispatcher("views/user/index.jsp").forward(request,response);
        } else if (action.equals("Shop")){
            request.setAttribute("listProduct",productService.getProductHome());
            request.setAttribute("listCatalog",catalogService.findAll());
            request.getRequestDispatcher("views/user/shop.jsp").forward(request,response);
        } else if (action.equals("Detail")) {
            int productID = Integer.parseInt(request.getParameter("productID"));
            request.setAttribute("product",productService.findById(productID));
            request.getRequestDispatcher("views/user/product-details.jsp").forward(request,response);
        } else if (action.equals("ProByCat")) {
            int catID = Integer.parseInt(request.getParameter("catID"));
            request.setAttribute("listCatalog",catalogService.findAll());
            request.setAttribute("listProduct",productService.getProductByCatalog(catID));
            request.setAttribute("catID",catID);
            request.getRequestDispatcher("views/user/shop.jsp").forward(request,response);
        } else if (action.equals("SearchUser")) {
            String productName = request.getParameter("searchName");
            request.setAttribute("listCatalog",catalogService.findAll());
            request.setAttribute("listProduct",productService.searchProductByName(productName));
            request.getRequestDispatcher("views/user/shop.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
