package project.model.dao;

import java.util.List;

public interface ProductDao <T,V> extends AppDao<T,V>{
    List<T> searchProductByName(String productName);
    List<T> findAllShortProductInfo();
    List<T> getProductByCatalog(Integer catID);
    List<T> getProductHome();
}
