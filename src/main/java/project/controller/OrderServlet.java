package project.controller;

import project.model.entity.Catalog;
import project.model.entity.Order;
import project.model.service.OrderService;
import project.model.serviceImp.OrderServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderServlet", value = "/OrderServlet")
public class OrderServlet extends HttpServlet {
    private OrderService<Order,Integer> orderService = new OrderServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("GetAllOrder")) {
            getAllOrder(request,response);
        } else if (action.equals("Update")) {
            int orderID = Integer.parseInt(request.getParameter("orderID"));
            boolean result = orderService.updateOrderStatus(orderID);
            if (result) {
                getAllOrder(request,response);
            } else {
                request.getRequestDispatcher("views/user/error.jsp").forward(request,response);
            }
        }
    }
    public void getAllOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listOrder",orderService.findAllOder());
        request.getRequestDispatcher("views/admin/listOrder.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("Payment")) {
            Order order = new Order();
            order.setUserID(Integer.parseInt(request.getParameter("userID")));
            float total = (float) request.getSession().getAttribute("total");
            order.setTotalAmount(total);
            boolean result = orderService.save(order);
            if (result) {
                request.getRequestDispatcher("views/user/paymentSuccess.jsp").forward(request,response);
            } else {
                request.getRequestDispatcher("views/user/error.jsp").forward(request,response);
            }
        }
    }
}
