package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection conn = null;

    public static Connection getConnection(){
        if (conn == null){
            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    public static void closeConnection(){
        if (conn != null){
            try {
                conn.close();
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
        System.out.println("Connection closed");
    }

    private static Properties loadProperties() {
        try(FileInputStream fis = new FileInputStream("db.properties")) {
            Properties prop = new Properties();
            prop.load(fis);
            return prop;
        }
        catch(IOException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void closeStatement(Statement st) {

        if (st != null) {
            try {
                st.close();
            }
            catch (SQLException e) {
                throw new DbException(e.getMessage());
            }

            System.out.println("Statement closed");
        }

    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            }
            catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
            System.out.println("ResultSet closed");
        }


    }

    public static void closePreparedStatment(PreparedStatement ps){
        if (ps != null){
            try{
                ps.close();
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
            System.out.println("PreparedStatement closed");
        }
    }

}
