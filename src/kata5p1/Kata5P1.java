package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Kata5P1 {

    public static void main(String[] args) {
        createNewTable();
    }
    
    public static void createNewTable() {
        String URL = "jdbc:sqlite:Kata5.db";
        String SQL = "CREATE TABLE IF NOT EXISTS EMAIL "
                   + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, MAIL TEXT NOT NULL)";
        try {
            Connection conn = DriverManager.getConnection(URL);
            Statement stmt = conn.createStatement();
            stmt.execute(SQL);
            System.out.println("Tabla creada.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
