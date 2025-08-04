package assignments.jdbc;
import java.sql.*;

public class BatchInsert{
    public static void main(String[] args) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JdbcExamples", "root", "root");
            Statement stmt = con.createStatement();

            stmt.addBatch("Insert into Employee values(1,'Sanjay',15000)");
            stmt.addBatch("Insert into Employee values(2,'Sarvesh',10000)");
            stmt.addBatch("Insert into Employee values(3,'Paresh',20000)");
            int[] i = stmt.executeBatch();
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
       
    }
}