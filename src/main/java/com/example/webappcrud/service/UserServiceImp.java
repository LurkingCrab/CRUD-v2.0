package com.example.webappcrud.service;

import com.example.webappcrud.dao.UserDao;
import com.example.webappcrud.models.Role;
import com.example.webappcrud.models.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> showAll() {
        return userDao.showAll();
    }

    @Override
    public User showById(int id) {
        return userDao.showById(id);
    }

    @Override
    public User showByLogin(String login) {
        return userDao.showByLogin(login);
    }

    @Override
    public Role showRoleByName(String roleName) {
        return userDao.showRoleByName(roleName);
    }

    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteById(int id) {
        userDao.deleteById(id);
    }

    @Override
    public List<Role> showRoles() {
        return userDao.showRoles();
    }
}