package project.model.serviceImp;

import org.springframework.stereotype.Service;
import project.model.dao.UserDao;
import project.model.daoImp.UserDaoImp;
import project.model.entity.User;
import project.model.service.UserService;

import java.util.List;
@Service
public class UserServiceImp implements UserService<User,Integer> {
    private UserDao<User,Integer> userDao = new UserDaoImp();
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public boolean save(User user) {
        return userDao.save(user);
    }

    @Override
    public boolean update(User user) {
        return userDao.update(user);
    }

    @Override
    public boolean delete(Integer id) {
        return userDao.delete(id);
    }

    @Override
    public User checkLogIn(String userAccount, String userPassWord) {
        return userDao.checkLogIn(userAccount,userPassWord);
    }

    @Override
    public boolean lockUser(Integer id) {
        return userDao.lockUser(id);
    }

    @Override
    public boolean unLockUser(Integer id) {
        return userDao.unLockUser(id);
    }
}
