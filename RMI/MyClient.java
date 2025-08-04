package assignments.rmi;
import java.rmi.*;

import assignments.rmi.MyInterface;

public class MyClient {
    public static void main(String[] args) {

        System.out.println("Starting Client Application");
        System.out.println("Looking up for server club");
        try {
            MyInterface mi = (MyInterface)Naming.lookup("rmi://localhost:1099/mikado");
            System.out.println("Got the stub");
            System.out.println("Calling remote method");
            System.out.println(mi.getMessage());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
