package project.model.service;

import java.util.List;

public interface ProductService <T,V> extends AppService<T,V>{
    List<T> searchProductByName(String productName);
    List<T> findAllShortProductInfo();
    List<T> getProductByCatalog(Integer catID);
    List<T> getProductHome();

}
