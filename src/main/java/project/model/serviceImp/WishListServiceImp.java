package project.model.serviceImp;

import project.model.dao.WishListDao;
import project.model.daoImp.WishListDaoImp;
import project.model.entity.Product;
import project.model.entity.WishList;
import project.model.service.WishListService;

import java.util.List;

public class WishListServiceImp implements WishListService<WishList,Integer> {
    WishListDao<WishList,Integer> wishListDao = new WishListDaoImp();
    @Override
    public List<Product> getWishList(Integer userID) {
        return wishListDao.getWishList(userID);
    }

    @Override
    public boolean save(WishList wishList) {
        return wishListDao.save(wishList);
    }

    @Override
    public boolean delete(Integer id) {
        return wishListDao.delete(id);
    }

    @Override
    public boolean checkExist(Integer id) {
        return wishListDao.checkExist(id);
    }
}
