package project.model.daoImp;

import org.springframework.stereotype.Repository;
import project.model.dao.CatalogDao;
import project.model.entity.Catalog;
import project.model.entity.ShortCatalog;
import project.model.util.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository

public class CatalogDaoImp implements CatalogDao<Catalog,Integer> {
    @Override
    public List<Catalog> findAll() {
        List<Catalog> listCatalog = null;
        Connection connection = null;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_getAllCatalog()}");
            ResultSet resultSet = callableStatement.executeQuery();
            listCatalog = new ArrayList<>();
            while (resultSet.next()) {
                Catalog catalog = new Catalog();
                catalog.setCatalogID(resultSet.getInt("CatalogID"));
                catalog.setCatalogName(resultSet.getString("CatalogName"));
                catalog.setCatalogTitle(resultSet.getString("CatalogTitle"));
                catalog.setCreated(resultSet.getDate("Created"));
                catalog.setCatalogStatus(resultSet.getBoolean("CatalogStatus"));
                listCatalog.add(catalog);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }
        return listCatalog;
    }

    @Override
    public Catalog findById(Integer id) {
        Catalog catalog = null;
        Connection connection = null;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_getCatalogById(?)}");
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            catalog = new Catalog();
            if (resultSet.next()) {
                catalog.setCatalogID(resultSet.getInt("CatalogID"));
                catalog.setCatalogName(resultSet.getString("CatalogName"));
                catalog.setCatalogTitle(resultSet.getString("CatalogTitle"));
                catalog.setCreated(resultSet.getDate("Created"));
                catalog.setCatalogStatus(resultSet.getBoolean("CatalogStatus"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }
        return catalog;
    }

    @Override
    public boolean save(Catalog catalog) {
        boolean result = true;
        Connection connection = null;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_insertCatalog(?,?,?)}");
            callableStatement.setString(1, catalog.getCatalogName());
            callableStatement.setString(2, catalog.getCatalogTitle());
            callableStatement.setBoolean(3, catalog.isCatalogStatus());
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
    public boolean update(Catalog catalog) {
        boolean result = true;
        Connection connection = null;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_updateCatalog(?,?,?,?)}");
            callableStatement.setInt(1, catalog.getCatalogID());
            callableStatement.setString(2, catalog.getCatalogName());
            callableStatement.setString(3, catalog.getCatalogTitle());
            callableStatement.setBoolean(4, catalog.isCatalogStatus());
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
    public boolean delete(Integer id) {
        boolean result = true;
        Connection connection = null;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_updateCatalogStatus(?)}");
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
    public List<Catalog> searchCatalogByName(String catalogName) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        List<Catalog> listCatalog = null;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_getCatalogByName(?)}");
            callableStatement.setString(1, catalogName);
            ResultSet resultSet = callableStatement.executeQuery();
            listCatalog = new ArrayList<>();
            while (resultSet.next()) {
                Catalog catalog = new Catalog();
                catalog.setCatalogID(Integer.parseInt(resultSet.getString("CatalogID")));
                catalog.setCatalogName(resultSet.getString("CatalogName"));
                catalog.setCatalogTitle(resultSet.getString("CatalogTitle"));
                catalog.setCreated(resultSet.getDate("Created"));
                catalog.setCatalogStatus(resultSet.getBoolean("CatalogStatus"));
                listCatalog.add(catalog);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }
        return listCatalog;
    }

    @Override
    public List<ShortCatalog> getShortCatalog() {
        List<ShortCatalog> listShortCatalog = null;
        Connection connection = null;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call proc_getShortCatalog()}");
            ResultSet resultSet = callableStatement.executeQuery();
            listShortCatalog = new ArrayList<>();
            while (resultSet.next()) {
                ShortCatalog shortCatalog = new ShortCatalog();
                shortCatalog.setCatalogID(resultSet.getInt("CatalogID"));
                shortCatalog.setCatalogName(resultSet.getString("CatalogName"));
                listShortCatalog.add(shortCatalog);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection,callableStatement);
        }
        return listShortCatalog;
    }

    @Override
    public List<Catalog> phanTrang(int index, int limit) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        List<Catalog> listCatalog = null;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call phantrang(?,?)}");
            callableStatement.setInt(1,index);
            callableStatement.setInt(2,limit);
            listCatalog = new ArrayList<>();
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Catalog catalog = new Catalog();
                catalog.setCatalogID(resultSet.getInt("CatalogID"));
                catalog.setCatalogName(resultSet.getString("CatalogName"));
                catalog.setCatalogTitle(resultSet.getString("CatalogTitle"));
                catalog.setCreated(resultSet.getDate("Created"));
                catalog.setCatalogStatus(resultSet.getBoolean("CatalogStatus"));
                listCatalog.add(catalog);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection,callableStatement);
        }
        return listCatalog;
    }

    @Override
    public int soLuongTrang(int limitValue) {
        int total = 0;
        Connection connection = null;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call tongTrang(?)}");
            callableStatement.setInt(1,limitValue);
            ResultSet resultSet = callableStatement.executeQuery();
            if (resultSet.next()) {
                total = resultSet.getInt("total");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection,callableStatement);
        }
        return total;
    }
}
