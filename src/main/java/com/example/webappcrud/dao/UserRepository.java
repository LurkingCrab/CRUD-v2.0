package com.example.webappcrud.dao;

import com.example.webappcrud.models.Role;
import com.example.webappcrud.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select distinct user from User user join fetch user.roles roles")
    List<User> findAll();

    @Query("select distinct user from User user join fetch user.roles roles where user.id=:id")
    Optional<User> findById(Integer integer);

    @Query("select distinct user from User user join fetch user.roles roles where user.login=:login")
    User findUserByLogin(String login);

    //Role findRoleByName(String roleName);
}