package project.model.dao;

import project.model.entity.User;

public interface UserDao<T,V> extends AppDao<T,V>{
    User checkLogIn (String userAccount, String userPassWord);
    boolean lockUser (Integer id);
    boolean unLockUser (Integer id);
}
