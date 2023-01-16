package project.model.service;

import project.model.entity.Product;

import java.util.List;

public interface WishListService<T,V> {
    List<Product> getWishList(Integer userID);
    boolean save(T t);
    boolean delete(V id);
    boolean checkExist(V id);
}
