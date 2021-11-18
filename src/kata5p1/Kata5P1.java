package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Kata5P1 {

    public static void main(String[] args) {
        selectAll();
    }
    
    private static Connection connect() {
        String URL = "jdbc:sqlite:Kata5.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    private static void selectAll() {
        String SQL = "SELECT * FROM PEOPLE";
        try {
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            
            while (rs.next()) {
                System.out.println(rs.getInt("ID") + ", " + 
                                   rs.getString("NOMBRE") + ", " +
                                   rs.getString("APELLIDOS") + ", " +
                                   rs.getString("DEPARTAMENTO"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
