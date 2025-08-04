package assignments.jdbc;
import java.sql.*;

public class ScrollResult {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JdbcExamples", "root", "root");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("Select * from Employee");
            ResultSetMetaData rsmd = rs.getMetaData();
            int cols = rsmd.getColumnCount();
            while(rs.next()){
                for(int i = 1; i<=cols; i++){
                    System.out.println(rs.getString(i)+"\t");
                }
                System.out.println("");
            }
            //Checking for Updatable
            rs.absolute(2);
            rs.updateString("name", "sujata");
            rs.updateRow();

            //Checking for sensitive
            // rs.absolute(2);
            // System.out.println("Name of Employee at row 2 is "+rs.getString(2));
            // System.in.read();
            // System.out.println("Name of Employee at now row 2 is "+rs.getString(2));

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}
