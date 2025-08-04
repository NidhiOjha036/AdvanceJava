package assignments.jdbc;
import java.sql.*;

public class SPSelectPro {
    public static void main(String[] args) {

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MikadoBookStore", "root", "root");
            CallableStatement cst = con.prepareCall("{ call SelectPro()}");
            ResultSet rs = cst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int col = rsmd.getColumnCount();
            while (rs.next()) {
                for(int i=1; i<=col; i++){
                    System.out.print(rs.getString(i)+"\t");
                }
                System.out.println("");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        

    }
}