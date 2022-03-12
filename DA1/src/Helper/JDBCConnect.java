/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author hoang
 */
public class JDBCConnect {
      private static Connection conn;
    public static Connection getConnection(){
        if (conn == null) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String user = "sa";
                String pass = "hoang200802";
                String url = "jdbc:sqlserver:localhost:1433;databaseName = DA1 ";
                conn = DriverManager.getConnection(url, user, pass);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
    public static PreparedStatement prepa (String sql) throws SQLException {
        return getConnection().prepareStatement(sql);
    }
}
