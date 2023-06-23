package com.mywebapp.services;

import com.mywebapp.models.User;
import com.mywebapp.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {
    public User login(String username, String password) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseUtil.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();

            if (rs.next()) {
                // Crear y devolver el objeto User si se encontró una coincidencia en la base de datos
                User user = new User(rs.getString("username"), rs.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil.closeResultSet(rs);
            DatabaseUtil.closeStatement(stmt);
            DatabaseUtil.closeConnection(conn);
        }

        return null; // Devolver null si no se encontró una coincidencia o hubo un error
    }
}

