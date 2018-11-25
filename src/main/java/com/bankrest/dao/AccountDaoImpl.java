package com.bankrest.dao;

import com.bankrest.dao.interFaces.AccountDao;
import com.bankrest.model.Account;

import javax.inject.Singleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class AccountDaoImpl implements AccountDao {
    private static final String SELECT_BY_ID = "SELECT * FROM Score WHERE id=?";
    private final static String UPDATE = "UPDATE Score SET userID = ?,balance=?,currencyCode=? WHERE ID=? ";
    private static final String GET_ALL = "SELECT * FROM Score";
    private final static String INSERT = "INSERT INTO Score (userID,balance,currencyCode) VALUES (?,?,?)";
    private static final String DELETE = "DELETE FROM Score WHERE id = ?";


    @Override
    public Account getScoreById(long scoreId) {

        ResultSet rs = null;
        Account account = null;
        try (Connection conn = H2DaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)
        ) {
            stmt.setLong(1, scoreId);
            rs = stmt.executeQuery();
            if (rs.next()) {
                account = new Account(rs.getLong("id"),
                        rs.getLong("userID"),
                        rs.getBigDecimal("balance"),
                        rs.getString("currencyCode"));
            }
            return account;
        } catch (Exception e) {

        }
        return account;
    }

    @Override
    public List<Account> getScoreByCurrencyCode(String code) {

        ResultSet rs = null;
        Account account = null;
        List<Account> accounts = new ArrayList<Account>();
        try (Connection conn = H2DaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Score WHERE currencyCode=?")
        ) {
            stmt.setString(1, code);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Account u = new Account(rs.getLong("id"),
                        rs.getLong("userID"),
                        rs.getBigDecimal("balance"),
                        rs.getString("currencyCode"));
                accounts.add(u);
            }

        } catch (Exception e) {


        }
        return accounts;
    }

    @Override
    public List<Account> getAllScores() {


        ResultSet rs = null;
        List<Account> accounts = new ArrayList<Account>();
        try (Connection conn = H2DaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(GET_ALL)
        ) {
            rs = stmt.executeQuery();
            while (rs.next()) {
                Account u = new Account(rs.getLong("id"),
                        rs.getLong("userID"),
                        rs.getBigDecimal("balance"),
                        rs.getString("currencyCode"));
                accounts.add(u);
            }
            return accounts;
        } catch (SQLException e) {

        }
        return accounts;
    }

    @Override
    public void insertScore(Account account) {

        try (Connection conn = H2DaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT)
        ) {
            stmt.setLong(1, account.getUserId());
            stmt.setBigDecimal(2, account.getBalance());
            stmt.setString(3, account.getCurrencyCode());
            stmt.executeUpdate();
        } catch (SQLException e) {

        }
    }

    @Override
    public void updateScore(Long scoreId, Account account) {

        try (Connection conn = H2DaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE);
        ) {
            stmt.setLong(1, account.getUserId());
            stmt.setBigDecimal(2, account.getBalance());
            stmt.setString(3, account.getCurrencyCode());
            stmt.setLong(4, scoreId);
            stmt.executeUpdate();
        } catch (SQLException e) {

        }
    }

    @Override
    public void deleteScore(long scoreId) {

        try (Connection conn = H2DaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE)
        ) {
            stmt.setLong(1, scoreId);
            stmt.executeUpdate();
        } catch (SQLException e) {

        }
    }
}
