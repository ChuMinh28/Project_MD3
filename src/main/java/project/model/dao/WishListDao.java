package project.model.dao;

import project.model.entity.Product;

import java.util.List;

public interface WishListDao<T,V> {
    List<Product> getWishList(Integer userID);
    boolean save(T t);
    boolean delete(V id);
    boolean checkExist(V id);
}
