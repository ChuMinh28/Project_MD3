package project.model.daoImp;

import project.model.dao.WishListDao;
import project.model.entity.Product;
import project.model.entity.WishList;
import project.model.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WishListDaoImp implements WishListDao<WishList,Integer>{
    @Override
    public List<Product> getWishList(Integer userID) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        List<Product> listProduct = null;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_getAllWishList(?)}");
            callableStatement.setInt(1,userID);
            ResultSet resultSet = callableStatement.executeQuery();
            listProduct = new ArrayList<>();
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductID(resultSet.getInt("ProductID"));
                product.setProductName(resultSet.getString("ProductName"));
                product.setProductImage(resultSet.getString("ProductImage"));
                product.setPrice(resultSet.getFloat("Price"));
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
    public boolean save(WishList wishList) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        boolean result = true;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_addToWishList(?,?)}");
            callableStatement.setInt(1,wishList.getUserID());
            callableStatement.setInt(2,wishList.getProduct().getProductID());
            callableStatement.executeUpdate();
        }catch (SQLException e){
            result = false;
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection,callableStatement);
        }
        return result;
    }

    @Override
    public boolean delete(Integer id) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        boolean result = true;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_deleteProductFromWishList(?)}");
            callableStatement.setInt(1,id);
            callableStatement.executeUpdate();
        }catch (SQLException e){
            result = false;
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection,callableStatement);
        }
        return result;
    }

    @Override
    public boolean checkExist(Integer id) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        boolean result = true;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_checkExist(?)}");
            callableStatement.setInt(1,id);
            callableStatement.executeUpdate();
        }catch (SQLException e) {
            result = false;
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection,callableStatement);
        }
        return result;
    }
}
