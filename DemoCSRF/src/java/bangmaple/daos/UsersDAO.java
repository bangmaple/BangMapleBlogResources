/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bangmaple.daos;

import bangmaple.utils.DBUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bangmaple
 */
public class UsersDAO implements Serializable {

    private Connection conn;
    private PreparedStatement prStm;
    private ResultSet rs;

    public void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (prStm != null) {
            prStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public String checkLogin(final String username, final String password)
            throws SQLException, ClassNotFoundException {
        String role = "failed";
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT Role FROM Users WHERE username = ? AND password = ?";
                prStm = conn.prepareStatement(sql);
                prStm.setString(1, username);
                prStm.setString(2, password);
                rs = prStm.executeQuery();
                if (rs.next()) {
                    role = rs.getString("Role");
                }
            }
        } finally {
            closeConnection();
        }
        return role;
    }

    public boolean changePassword(final String username, final String passwordChange)
            throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE Users SET Password = ? WHERE Username = ?";
                prStm = conn.prepareStatement(sql);
                prStm.setString(1, passwordChange);
                prStm.setString(2, username);
                check = prStm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }
}
