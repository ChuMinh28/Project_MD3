package project.model.daoImp;

import project.model.dao.ProductDao;
import project.model.entity.Product;
import project.model.util.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImp implements ProductDao<Product, Integer> {
    @Override
    public List<Product> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> listProduct = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getAllProduct()}");
            ResultSet resultSet = callSt.executeQuery();
            listProduct = new ArrayList<>();
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductID(resultSet.getInt("ProductID"));
                product.setProductName(resultSet.getString("ProductName"));
                product.setPrice(resultSet.getFloat("Price"));
                product.setQuantity(resultSet.getInt("Quantity"));
                product.setProductTitle(resultSet.getString("ProductTitle"));
                product.setProductImage(resultSet.getString("ProductImage"));
                product.setDescriptions(resultSet.getString("Descriptions"));
                product.setCatalog(resultSet.getInt("CatalogID"));
                product.setProductStatus(resultSet.getBoolean("ProductStatus"));
                //Lay tat ca link anh phu cua san pham
                CallableStatement callSt2 = conn.prepareCall("{call proc_getImageById(?)}");
                callSt2.setInt(1, product.getProductID());
                ResultSet rs2 = callSt2.executeQuery();
                while (rs2.next()) {
                    product.getListImageLink().add(rs2.getString("ImageLink"));
                }
                callSt2.close();
                listProduct.add(product);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listProduct;
    }

    @Override
    public Product findById(Integer id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Product product = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getProductById(?)}");
            callSt.setInt(1, id);
            ResultSet resultSet = callSt.executeQuery();
            product = new Product();
            if (resultSet.next()) {
                product.setProductID(resultSet.getInt("ProductID"));
                product.setProductName(resultSet.getString("ProductName"));
                product.setPrice(resultSet.getFloat("Price"));
                product.setQuantity(resultSet.getInt("Quantity"));
                product.setProductTitle(resultSet.getString("ProductTitle"));
                product.setProductImage(resultSet.getString("ProductImage"));
                product.setDescriptions(resultSet.getString("Descriptions"));
                product.setCatalog(resultSet.getInt("CatalogID"));
                product.setProductStatus(resultSet.getBoolean("ProductStatus"));
                //Lay tat ca link anh phu cua san pham
                CallableStatement callSt2 = conn.prepareCall("{call proc_getImageById(?)}");
                callSt2.setInt(1, id);
                ResultSet rs2 = callSt2.executeQuery();
                while (rs2.next()) {
                    product.getListImageLink().add(rs2.getString("ImageLink"));
                }
                callSt2.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return product;
    }

    @Override
    public boolean save(Product product) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        boolean result = true;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_insertProduct(?,?,?,?,?,?,?,?)}");
            callableStatement.setString(1, product.getProductName());
            callableStatement.setFloat(2, product.getPrice());
            callableStatement.setInt(3, product.getQuantity());
            callableStatement.setString(4, product.getProductTitle());
            callableStatement.setString(5, product.getProductImage());
            callableStatement.setString(6, product.getDescriptions());
            callableStatement.setInt(7, product.getCatalog());
            callableStatement.registerOutParameter(8, Types.INTEGER);
            callableStatement.execute();
            int productId = callableStatement.getInt(8);
            for (String proLink : product.getListImageLink()) {
                CallableStatement callSt2 = connection.prepareCall("{call proc_insertImage(?,?)}");
                callSt2.setString(1, proLink);
                callSt2.setInt(2, productId);
                callSt2.executeUpdate();
                callSt2.close();
            }
        } catch (SQLException ex) {
            result = false;
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }
        return result;
    }

    @Override
    public boolean update(Product product) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        boolean result = true;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_updateProduct(?,?,?,?,?,?,?,?,?)}");
            callableStatement.setInt(1, product.getProductID());
            callableStatement.setString(2, product.getProductName());
            callableStatement.setFloat(3, product.getPrice());
            callableStatement.setInt(4, product.getQuantity());
            callableStatement.setString(5, product.getProductTitle());
            callableStatement.setString(6, product.getProductImage());
            callableStatement.setString(7, product.getDescriptions());
            callableStatement.setInt(8, product.getCatalog());
            callableStatement.setBoolean(9, product.isProductStatus());

            CallableStatement callSt3 = connection.prepareCall("{call proc_deleteImage(?)}");
            callSt3.setInt(1, product.getProductID());
            callSt3.executeUpdate();
            callSt3.close();

            callableStatement.executeUpdate();
            for (String proLink : product.getListImageLink()) {
                CallableStatement callSt2 = connection.prepareCall("{call proc_insertImage(?,?)}");
                callSt2.setString(1, proLink);
                callSt2.setInt(2, product.getProductID());
                callSt2.executeUpdate();
                callSt2.close();
            }
        } catch (SQLException ex) {
            result = false;
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }
        return result;
    }

    @Override
    public boolean delete(Integer id) {
        boolean result = true;
        Connection connection = null;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_updateProductStatus(?)}");
            callableStatement.setInt(1, id);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            result = false;
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }
        return result;
    }

    @Override
    public List<Product> searchProductByName(String productName) {
        List<Product> listProduct = null;
        Connection connection = null;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_getProductByName(?)}");
            callableStatement.setString(1,productName);
            ResultSet resultSet = callableStatement.executeQuery();
            listProduct = new ArrayList<>();
            while (resultSet.next()){
                Product product = new Product();
                product.setProductID(resultSet.getInt("ProductID"));
                product.setProductName(resultSet.getString("ProductName"));
                product.setPrice(resultSet.getFloat("Price"));
                product.setQuantity(resultSet.getInt("Quantity"));
                product.setProductImage(resultSet.getString("ProductImage"));
                product.setCatalog(resultSet.getInt("CatalogID"));
                product.setProductStatus(resultSet.getBoolean("ProductStatus"));
                listProduct.add(product);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection,callableStatement);
        }
        return listProduct;
    }

    @Override
    public List<Product> findAllShortProductInfo() {
        List<Product> listProduct = null;
        Connection connection = null;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_getShortProductAdmin()}");
            ResultSet resultSet = callableStatement.executeQuery();
            listProduct = new ArrayList<>();
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductID(resultSet.getInt("ProductID"));
                product.setProductName(resultSet.getString("ProductName"));
                product.setPrice(resultSet.getFloat("Price"));
                product.setQuantity(resultSet.getInt("Quantity"));
                product.setCatalog(resultSet.getInt("CatalogID"));
                product.setProductStatus(resultSet.getBoolean("ProductStatus"));
                listProduct.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }
        return listProduct;
    }

    @Override
    public List<Product> getProductByCatalog(Integer catID) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        List<Product> listProduct = null;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_getProductByCatalog(?)}");
            callableStatement.setInt(1,catID);
            listProduct = new ArrayList<>();
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductID(resultSet.getInt("ProductID"));
                product.setProductName(resultSet.getString("ProductName"));
                product.setPrice(resultSet.getFloat("Price"));
                product.setQuantity(resultSet.getInt("Quantity"));
                product.setProductImage(resultSet.getString("ProductImage"));
                product.setCatalog(resultSet.getInt("CatalogID"));
                product.setProductStatus(resultSet.getBoolean("ProductStatus"));
                listProduct.add(product);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection,callableStatement);
        }
        return listProduct;
    }

    @Override
    public List<Product> getProductHome() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> listProduct = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getAllProductHome()}");
            ResultSet resultSet = callSt.executeQuery();
            listProduct = new ArrayList<>();
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductID(resultSet.getInt("ProductID"));
                product.setProductName(resultSet.getString("ProductName"));
                product.setPrice(resultSet.getFloat("Price"));
                product.setQuantity(resultSet.getInt("Quantity"));
                product.setProductTitle(resultSet.getString("ProductTitle"));
                product.setProductImage(resultSet.getString("ProductImage"));
                product.setDescriptions(resultSet.getString("Descriptions"));
                product.setCatalog(resultSet.getInt("CatalogID"));
                product.setProductStatus(resultSet.getBoolean("ProductStatus"));
                //Lay tat ca link anh phu cua san pham
                CallableStatement callSt2 = conn.prepareCall("{call proc_getImageById(?)}");
                callSt2.setInt(1, product.getProductID());
                ResultSet rs2 = callSt2.executeQuery();
                while (rs2.next()) {
                    product.getListImageLink().add(rs2.getString("ImageLink"));
                }
                callSt2.close();
                listProduct.add(product);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listProduct;
    }
}
