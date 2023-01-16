package project.model.serviceImp;

import org.springframework.stereotype.Service;
import project.model.dao.CatalogDao;
import project.model.daoImp.CatalogDaoImp;
import project.model.entity.Catalog;
import project.model.entity.ShortCatalog;
import project.model.service.CatalogService;

import java.util.List;
@Service

public class CatalogServiceImp implements CatalogService<Catalog,Integer> {
    private CatalogDao<Catalog,Integer> catalogDao = new CatalogDaoImp();

    @Override
    public List<Catalog> findAll() {
        return catalogDao.findAll();
    }

    @Override
    public Catalog findById(Integer id) {
        return catalogDao.findById(id);
    }

    @Override
    public boolean save(Catalog catalog) {
        return catalogDao.save(catalog);
    }

    @Override
    public boolean update(Catalog catalog) {
        return catalogDao.update(catalog);
    }

    @Override
    public boolean delete(Integer id) {
        return catalogDao.delete(id);
    }

    @Override
    public List<Catalog> searchCatalogByName(String catalogName) {
        return catalogDao.searchCatalogByName(catalogName);
    }

    @Override
    public List<ShortCatalog> getShortCatalog() {
        return catalogDao.getShortCatalog();
    }

    @Override
    public List<Catalog> phanTrang(int index, int limit) {
        return catalogDao.phanTrang(index,limit);
    }

    @Override
    public int soLuongTrang(int limitValue) {
        return catalogDao.soLuongTrang(limitValue);
    }
}
