package assignments.jdbc;
import java.sql.*;

public class SPAddCategory{
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MikadoBookStore","root" ,"root");
            CallableStatement cst = con.prepareCall("{call AddCategory(?)}");
            cst.setString(1, "C#");
            cst.execute();
            cst.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
