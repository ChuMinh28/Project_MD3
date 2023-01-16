package project.model.serviceImp;

import project.model.dao.OrderDao;
import project.model.daoImp.OrderDaoImp;
import project.model.entity.Order;
import project.model.service.OrderService;

import java.util.List;

public class OrderServiceImp implements OrderService<Order,Integer> {
    private OrderDao<Order,Integer> orderDao = new OrderDaoImp();
    @Override
    public List<Order> findAllOder() {
        return orderDao.findAllOder();
    }

    @Override
    public boolean updateOrderStatus(Integer id) {
        return orderDao.updateOrderStatus(id);
    }

    @Override
    public boolean save(Order order) {
        return orderDao.save(order);
    }
}
