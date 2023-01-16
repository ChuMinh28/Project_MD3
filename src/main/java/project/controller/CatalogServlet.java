package project.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import project.model.entity.Catalog;
import project.model.service.CatalogService;
import project.model.serviceImp.CatalogServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@WebServlet(name = "CatalogServlet", value = "/CatalogServlet")
public class CatalogServlet extends HttpServlet {
    private CatalogService<Catalog,Integer> catalogService = new CatalogServiceImp();
    private static final Gson GSON = new GsonBuilder().create();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("GetAll")){
            String userName = String.valueOf(request.getSession().getAttribute("userLogin"));
            if (userName == "null") {
                //Chua dang nhap --> Login
                String pageRequestLogin = request.getParameter("pageRequestLogin");
                request.setAttribute("pageRequestLogin",pageRequestLogin);
                request.getRequestDispatcher("views/user/login.jsp").forward(request,response);
            } else {
                getAllCatalog(request,response);
            }
        } else if (action.equals("GetById")) {
            int catalogId = Integer.parseInt(request.getParameter("catalogID"));
            Catalog catalogUpdate = catalogService.findById(catalogId);
            String json = GSON.toJson(catalogUpdate);
            response.setCharacterEncoding("UTF-8");
            response.setStatus(200);
            response.setHeader("Content-Type","application/json");
            Writer out = response.getWriter();
            out.write(json);
            out.flush();
        }
    }
    public void getAllCatalog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Catalog> listCatalog = catalogService.findAll();
        request.setAttribute("listCatalog",listCatalog);
        request.getRequestDispatcher("views/admin/listCatalog.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action!=null && action.equals("Create")){
            Catalog catalog = new Catalog();
            catalog.setCatalogName(request.getParameter("catalogName"));
            catalog.setCatalogTitle(request.getParameter("title"));
            catalog.setCatalogStatus(Boolean.parseBoolean(request.getParameter("catalogStatus")));
            boolean result = catalogService.save(catalog);
            if (result){
                getAllCatalog(request,response);
            }else {
                request.getRequestDispatcher("views/user/error.jsp").forward(request,response);
            }
        } else if (action!=null && action.equals("Delete")) {
            int catalogId = Integer.parseInt(request.getParameter("catDeleteId"));
            boolean result = catalogService.delete(catalogId);
            if (result){
                getAllCatalog(request,response);
            }else {
                request.getRequestDispatcher("views/user/error.jsp").forward(request,response);
            }
        } else if (action!=null && action.equals("Update")) {
            Catalog catalog = new Catalog();
            catalog.setCatalogID(Integer.parseInt(request.getParameter("catalogID")));
            catalog.setCatalogName(request.getParameter("catalogName"));
            catalog.setCatalogTitle(request.getParameter("catalogTitle"));
            catalog.setCatalogStatus(Boolean.parseBoolean(request.getParameter("catalogStatus")));
            boolean result = catalogService.update(catalog);
            if (result){
                getAllCatalog(request,response);
            }else {
                request.getRequestDispatcher("views/user/error.jsp").forward(request,response);
            }
        } else if (action!=null && action.equals("Search")) {
            String catalogName = request.getParameter("catalogName");
            request.setAttribute("listCatalog",catalogService.searchCatalogByName(catalogName));
            request.getRequestDispatcher("views/admin/listCatalog.jsp").forward(request,response);
        }
    }
}
