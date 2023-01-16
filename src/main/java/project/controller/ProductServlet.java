package project.controller;

import project.model.entity.Catalog;
import project.model.entity.Product;
import project.model.entity.ShortCatalog;
import project.model.service.CatalogService;
import project.model.service.ProductService;
import project.model.serviceImp.CatalogServiceImp;
import project.model.serviceImp.ProductServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 10
)
public class ProductServlet extends HttpServlet {
    private ProductService<Product, Integer> productService = new ProductServiceImp();
    private CatalogService<Catalog, Integer> catalogService = new CatalogServiceImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("NewProduct")) {
            List<ShortCatalog> listShortCatalog = catalogService.getShortCatalog();
            request.setAttribute("listShortCatalog", listShortCatalog);
            request.getRequestDispatcher("views/admin/newProduct.jsp").forward(request, response);
        } else if (action.equals("GetById")) {
            int productID = Integer.parseInt(request.getParameter("productID"));
            request.setAttribute("productDetail", productService.findById(productID));
            request.getRequestDispatcher("views/admin/productDetail.jsp").forward(request, response);
        } else if (action.equals("Delete")) {
            int productID = Integer.parseInt(request.getParameter("productID"));
            for (Product pro : productService.findAllShortProductInfo()) {
                if (pro.getProductID() == productID) {
                    productService.delete(productID);
                    break;
                }
            }
        } else if (action.equals("Update")) {
            int productID = Integer.parseInt(request.getParameter("productID"));
            List<ShortCatalog> listShortCatalog = catalogService.getShortCatalog();
            request.setAttribute("listShortCatalog", listShortCatalog);
            request.setAttribute("updateProduct", productService.findById(productID));
            request.getRequestDispatcher("views/admin/updateProduct.jsp").forward(request, response);
        } else if (action.equals("Search")) {
            String productName = request.getParameter("searchName");
            request.setAttribute("listProduct",productService.searchProductByName(productName));
            request.getRequestDispatcher("views/admin/listProduct.jsp").forward(request,response);
        } else {
            getProductShort(request, response);
        }
        getProductShort(request, response);
    }

    public void getProductShort(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> listProduct = productService.findAllShortProductInfo();
        request.setAttribute("listProduct", listProduct);
        request.getRequestDispatcher("views/admin/listProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equals("Create")) {
            Product productNew = new Product();
            productNew.setProductName(request.getParameter("productName"));
            productNew.setPrice(Float.parseFloat(request.getParameter("price")));
            productNew.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            productNew.setProductTitle(request.getParameter("productTitle"));
            productNew.setDescriptions(request.getParameter("descriptions"));
            productNew.setCatalog(Integer.parseInt(request.getParameter("catalog")));
            String pathFolderImage = "D:/Project_MD3/Project_MD3/src/main/webapp/views/img/product-img";
            File file = new File(pathFolderImage);
            if (!file.exists()) {
                file.mkdirs();
            }
            for (Part part : request.getParts()) {
                if (part.getName().equals("productImage")) {
                    String timeCur = String.valueOf(System.currentTimeMillis());
                    productNew.setProductImage(part.getSubmittedFileName()+timeCur);
                    part.write(pathFolderImage + File.separator + part.getSubmittedFileName());
                } else if (part.getName().equals("subImages")) {
                    String timeCur = String.valueOf(System.currentTimeMillis());
                    productNew.getListImageLink().add(part.getSubmittedFileName()+timeCur);
                    part.write(pathFolderImage + File.separator + part.getSubmittedFileName());
                }
            }
            boolean result = productService.save(productNew);
            if (result) {
                getProductShort(request, response);
            } else {
                request.getRequestDispatcher("views/user/error.jsp").forward(request, response);
            }
        } else if (action.equals("Update")) {
            Product productUpdate = new Product();
            productUpdate.setProductID(Integer.parseInt(request.getParameter("productID")));
            productUpdate.setProductName(request.getParameter("productName"));
            productUpdate.setPrice(Float.parseFloat(request.getParameter("price")));
            productUpdate.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            productUpdate.setProductTitle(request.getParameter("productTitle"));
            productUpdate.setDescriptions(request.getParameter("descriptions"));
            productUpdate.setCatalog(Integer.parseInt(request.getParameter("catalog")));
            productUpdate.setProductStatus(productUpdate.getQuantity() > 0);
            String pathFolderImage = "D:/Project_MD3/Project_MD3/src/main/webapp/views/img/product-img";
            for (Part part : request.getParts()) {
                if (part.getName().equals("productImage")) {
                    productUpdate.setProductImage(part.getSubmittedFileName());
                    part.write(pathFolderImage + File.separator + part.getSubmittedFileName());
                } else if (part.getName().equals("subImages")) {
                    productUpdate.getListImageLink().add(part.getSubmittedFileName());
                    part.write(pathFolderImage + File.separator + part.getSubmittedFileName());
                }
            }
            boolean result = productService.update(productUpdate);
            if (result) {
                getProductShort(request, response);
            } else {
                request.getRequestDispatcher("views/user/error.jsp").forward(request, response);
            }
        }
        getProductShort(request,response);
    }
}
