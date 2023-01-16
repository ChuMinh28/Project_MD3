package project.model.service;

import project.model.entity.Order;

import java.util.List;

public interface OrderService <T,V>{
    List<Order> findAllOder();
    boolean updateOrderStatus(V id);
    boolean save(T t);
}
