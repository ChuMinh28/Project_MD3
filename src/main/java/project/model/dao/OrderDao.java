package project.model.dao;

import project.model.entity.Order;

import java.util.List;

public interface OrderDao<T,V>{
    List<Order> findAllOder();
    boolean updateOrderStatus(V id);
    boolean save(T t);
}
