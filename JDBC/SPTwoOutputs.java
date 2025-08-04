package assignments.jdbc;
import java.sql.*;

public class SPTwoOutputs{
    public static void main(String[] args) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MikadoBookStore", "root", "root");
            CallableStatement cst = con.prepareCall("{call TwoOutputs(?,?)}");
            cst.registerOutParameter(1, Types.INTEGER);
            cst.registerOutParameter(2, Types.DOUBLE);
            cst.execute();
            int i = cst.getInt(1);
            Double j = cst.getDouble(2);
            System.out.println("Total No. Of Books = "+i);
            System.out.println("Average Price of Books = "+j);
            cst.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
       
    }
}