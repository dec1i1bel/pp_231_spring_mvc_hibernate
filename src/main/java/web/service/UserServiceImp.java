package web.service;

import web.dao.UserDaoImp;
import web.model.User;

import java.util.List;

public class UserServiceImp implements UserService{

    @Override
    public List<User> findAll() {
        return new UserDaoImp().findAll();
    }
}
