package project.model.dao;

import project.model.entity.Catalog;
import project.model.entity.ShortCatalog;

import java.util.List;

public interface CatalogDao <T,V> extends AppDao<T,V>{
    List<T> searchCatalogByName(String catalogName);
    List<ShortCatalog> getShortCatalog();
    List<Catalog> phanTrang(int index,int limit);
    int soLuongTrang(int limitValue);
}
