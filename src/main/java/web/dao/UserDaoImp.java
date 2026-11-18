package web.dao;

import web.model.User;

import java.util.List;

public class UserDaoImp implements UserDao{

    @Override
    public List<User> findAll() {
        return List.of(
                new User("Пользователь 1", "+79123456781", "user1@mail.ru"),
                new User("Пользователь 2", "+79123456782", "user2@mail.ru"),
                new User("Пользователь 3", "+79123456783", "user3@mail.ru")
        );
    }
}
