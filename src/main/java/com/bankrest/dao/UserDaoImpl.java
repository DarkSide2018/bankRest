package com.bankrest.dao;

import com.bankrest.dao.interFaces.UserDao;
import com.bankrest.model.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl implements UserDao {

    private final static String GET_BY_ID = "SELECT * FROM USER WHERE ID=?";
    private final static String GET_ALL = "SELECT * FROM User";
    private final static String GET_BY_NAME = "SELECT * FROM User WHERE name = ? ";
    private final static String INSERT = "INSERT INTO User (name) VALUES (?)";
    private final static String UPDATE = "UPDATE User SET name = ? WHERE ID=? ";
    private final static String DELETE_BY_ID = "DELETE FROM User WHERE id = ? ";

    @Override
    public User getUserById(long userId) {

        ResultSet rs = null;
        User u = null;
        try (Connection conn = H2DaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(GET_BY_ID)
        ) {
            stmt.setLong(1, userId);
            rs = stmt.executeQuery();
            if (rs.next()) {
                u = new User(rs.getLong("id"), rs.getString("name"));

            }
            return u;
        } catch (Exception e) {

        }
        return u;
    }

    @Override
    public List<User> getAllUsers() {

        ResultSet rs = null;
        List<User> users = new ArrayList<User>();
        try (Connection conn = H2DaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(GET_ALL)
        ) {
            rs = stmt.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getLong("id"), rs.getString("name"));
                users.add(u);
            }
            return users;
        } catch (SQLException e) {

        }
        return users;
    }

    @Override
    public User getUserByName(String userName) {

        ResultSet rs = null;
        User u = null;
        try (Connection conn = H2DaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(GET_BY_NAME);
        ) {
            stmt.setString(1, userName);
            rs = stmt.executeQuery();
            if (rs.next()) {
                u = new User(rs.getLong("id"), rs.getString("name"));
            }
            return u;
        } catch (SQLException e) {

        }
        return u;
    }

    @Override
    public void insertUser(User user) {

        try (Connection conn = H2DaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT)
        ) {
            stmt.setString(1, user.getName());
            stmt.executeUpdate();
        } catch (SQLException e) {

        }
    }

    @Override
    public void updateUser(Long userId, User user) {

        try (Connection conn = H2DaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE);
        ) {
            stmt.setString(1, user.getName());
            stmt.setLong(2, userId);
            stmt.executeUpdate();
        } catch (SQLException e) {

        }
    }

    @Override
    public void deleteUser(long userId) {

        try (Connection conn = H2DaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE_BY_ID)
        ) {
            stmt.setLong(1, userId);
            stmt.executeUpdate();
        } catch (SQLException e) {

        }
    }
}
