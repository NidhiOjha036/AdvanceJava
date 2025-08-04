package assignments.jdbc;
import java.sql.*;

public class JdbcUpdate
{
    public static void main(String args[])
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JdbcExamples","root","root");
            Statement stmt = con.createStatement();
            int i = stmt.executeUpdate("update employee set salary=40000 where id=4");
            System.out.println("No. of rows affected = "+i);
            stmt.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
