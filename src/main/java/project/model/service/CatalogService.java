package project.model.service;

import project.model.entity.Catalog;
import project.model.entity.ShortCatalog;

import java.util.List;

public interface CatalogService<T,V> extends AppService<T,V> {
    List<T> searchCatalogByName(String catalogName);
    List<ShortCatalog> getShortCatalog();
    List<Catalog> phanTrang(int index, int limit);
    int soLuongTrang(int limitValue);
}
