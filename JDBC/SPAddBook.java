package assignments.jdbc;
import java.sql.*;

public class SPAddBook {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MikadoBookStore", "root", "root");
            CallableStatement cst = con.prepareCall("{? = call AddBook(?,?,?,?)}");
            cst.setInt(2, 2);
            cst.setString(3, "C# Unleashed");
            cst.setString(4,"Tim May");
            cst.setDouble(5, 500);
            cst.registerOutParameter(1, Types.INTEGER);
            cst.execute();
            int i = cst.getInt(1);
            System.out.println("Primary Key assigned was "+i);
            cst.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}
