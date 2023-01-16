package project.model.serviceImp;

import project.model.dao.ProductDao;
import project.model.daoImp.ProductDaoImp;
import project.model.entity.Product;
import project.model.service.ProductService;

import java.util.List;

public class ProductServiceImp implements ProductService<Product,Integer> {
    private ProductDao<Product,Integer> productDao = new ProductDaoImp();
    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productDao.findById(id);
    }

    @Override
    public boolean save(Product product) {
        return productDao.save(product);
    }

    @Override
    public boolean update(Product product) {
        return productDao.update(product);
    }

    @Override
    public boolean delete(Integer id) {
        return productDao.delete(id);
    }

    @Override
    public List<Product> searchProductByName(String productName) {
        return productDao.searchProductByName(productName);
    }

    @Override
    public List<Product> findAllShortProductInfo() {
        return productDao.findAllShortProductInfo();
    }

    @Override
    public List<Product> getProductByCatalog(Integer catID) {
        return productDao.getProductByCatalog(catID);
    }

    @Override
    public List<Product> getProductHome() {
        return productDao.getProductHome();
    }
}
