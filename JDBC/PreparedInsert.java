package assignments.jdbc;
import java.sql.*;

public class PreparedInsert {

    public static void main(String[] args) {

        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JdbcExamples", "root", "root");
        PreparedStatement pstmt = con.prepareStatement("Insert into employee values(?,?,?)");
        pstmt.setInt(1,4);
        pstmt.setString(2, "Rupesh");
        pstmt.setDouble(3, 15000);
        int i = pstmt.executeUpdate();
        System.out.println("No of rows affected= "+i);
        pstmt.close();
        con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
       
    }
    
}
