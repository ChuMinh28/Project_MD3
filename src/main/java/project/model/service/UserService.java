package project.model.service;

import project.model.entity.User;

public interface UserService <T,V> extends AppService<T,V>{
    User checkLogIn (String userAccount, String userPassWord);
    boolean lockUser (Integer id);
    boolean unLockUser (Integer id);
}
