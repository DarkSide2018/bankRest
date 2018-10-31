package com.bankrest.dao.interFaces;

import com.bankrest.model.User;

import java.util.List;

public interface UserDao {
    User getUserById(long userId);

    List<User> getAllUsers();

    User getUserByName(String userName);

    void insertUser(User user);

    void updateUser(Long userId, User user);

    void deleteUser(long userId);
}
