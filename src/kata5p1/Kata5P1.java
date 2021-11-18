package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;

public class Kata5P1 {

    public static void main(String[] args) {
        String fileName = "email.txt";
        List<String> emails = MailListReader.read(fileName);
        addEmailsDB(emails);
    }
    
    public static void addEmailsDB(List<String> emails) {
        for (String email : emails) {
            insert(email);
        }
    }
    
    public static void insert(String email) {
        String SQL = "INSERT INTO EMAIL(MAIL) VALUES(?)";
        String URL = "jdbc:sqlite:Kata5.db";
        
        try {
            Connection conn = DriverManager.getConnection(URL);
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, email);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
