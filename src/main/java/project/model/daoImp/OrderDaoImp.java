package project.model.daoImp;

import project.model.dao.OrderDao;
import project.model.entity.Order;
import project.model.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImp implements OrderDao<Order,Integer> {
    @Override
    public List<Order> findAllOder() {
        Connection connection = null;
        CallableStatement callableStatement = null;
        List<Order> listOrder = null;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_findAllOrder()}");
            ResultSet resultSet = callableStatement.executeQuery();
            listOrder = new ArrayList<>();
            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderID(resultSet.getInt("OderID"));
                order.setUserID(resultSet.getInt("UserID"));
                order.setCreated(resultSet.getDate("Created"));
                order.setOrderStatus(resultSet.getBoolean("OderStatus"));
                order.setTotalAmount(resultSet.getFloat("TotalAmount"));
                listOrder.add(order);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection,callableStatement);
        }
        return listOrder;
    }

    @Override
    public boolean updateOrderStatus(Integer id) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        boolean result = true;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_updateOrder(?)}");
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
    public boolean save(Order order) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        boolean result = true;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_saveOrder(?,?)}");
            callableStatement.setInt(1,order.getUserID());
            callableStatement.setFloat(2,order.getTotalAmount());
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
