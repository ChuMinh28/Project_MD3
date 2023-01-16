package project.model.daoImp;

import org.springframework.stereotype.Repository;
import project.model.dao.UserDao;
import project.model.entity.User;
import project.model.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UserDaoImp implements UserDao <User,Integer> {
    @Override
    public List<User> findAll() {
        Connection connection = null;
        CallableStatement callableStatement = null;
        List<User> listUser = null;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_getAllUser()}");
            ResultSet resultSet = callableStatement.executeQuery();
            listUser = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setUserID(resultSet.getInt("UserID"));
                user.setUserAccount(resultSet.getString("UserAccount"));
                user.setFullName(resultSet.getString("FullName"));
                user.setAddress(resultSet.getString("Address"));
                user.setPhone(resultSet.getString("Phone"));
                user.setCreated(resultSet.getDate("Created"));
                user.setPermission(resultSet.getBoolean("Permission"));
                user.setUserStatus(resultSet.getBoolean("UserStatus"));
                listUser.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection,callableStatement);
        }
        return listUser;
    }

    @Override
    public User findById(Integer id) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        User user = null;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_getUserById(?)}");
            callableStatement.setInt(1,id);
            ResultSet resultSet = callableStatement.executeQuery();
            user = new User();
            if (resultSet.next()) {
                user.setUserID(resultSet.getInt("UserID"));
                user.setUserAccount(resultSet.getString("UserAccount"));
                user.setFullName(resultSet.getString("FullName"));
                user.setAddress(resultSet.getString("Address"));
                user.setPhone(resultSet.getString("Phone"));
                user.setPermission(resultSet.getBoolean("Permission"));
                user.setUserStatus(resultSet.getBoolean("UserStatus"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection,callableStatement);
        }
        return user;
    }

    @Override
    public boolean save(User user) {
        boolean result = true;
        Connection connection = null;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_insertUser(?,?,?,?,?)}");
            callableStatement.setString(1,user.getUserAccount());
            callableStatement.setString(2,user.getUserPassWord());
            callableStatement.setString(3,user.getFullName());
            callableStatement.setString(4,user.getAddress());
            callableStatement.setString(5,user.getPhone());
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
    public boolean update(User user) {
        boolean result = true;
        Connection connection = null;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_updateUser(?,?,?,?,?)}");
            callableStatement.setInt(1,user.getUserID());
            callableStatement.setString(2,user.getFullName());
            callableStatement.setString(3,user.getAddress());
            callableStatement.setString(4,user.getPhone());
            callableStatement.setBoolean(5,user.isUserStatus());
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
        return false;
    }

    @Override
    public User checkLogIn(String userAccount, String userPassWord) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        User user = null;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_checkLogin(?,?)}");
            callableStatement.setString(1,userAccount);
            callableStatement.setString(2,userPassWord);
            ResultSet resultSet = callableStatement.executeQuery();
            user = new User();
            if (resultSet.next()) {
                user.setUserID(resultSet.getInt("UserID"));
                user.setUserAccount(resultSet.getString("UserAccount"));
                user.setUserPassWord(resultSet.getString("PassWordUser"));
                user.setPhone(resultSet.getString("Phone"));
                user.setAddress(resultSet.getString("Address"));
                user.setUserStatus(resultSet.getBoolean("UserStatus"));
                user.setPermission(resultSet.getBoolean("Permission"));
                user.setFullName(resultSet.getString("FullName"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection,callableStatement);
        }
        return user;
    }

    @Override
    public boolean lockUser(Integer id) {
        boolean result = true;
        Connection connection = null;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_updateUserStatus(?)}");
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
    public boolean unLockUser(Integer id) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        boolean result = true;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_unlockUserStatus(?)}");
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
}
