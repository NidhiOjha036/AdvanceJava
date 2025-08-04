package assignments.jdbc;

import java.sql.*;
import java.util.Properties;

public class JdbcSelect
{
    public static void main(String args[])
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JdbcExamples","root","root");

            /* Properties props = new Properties();
            props.put("user","root");
            props.put("password","mikado");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JdbcExamples",props);
            */

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from employee");
            ResultSetMetaData rsmd = rs.getMetaData();
            int cols = rsmd.getColumnCount();
            while(rs.next())
            {
                for(int i = 1; i<=cols; i++)
                {
                    System.out.print(rs.getString(i)+"\t");
                }
                System.out.println("");
            }
            rs.close();
            stmt.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
