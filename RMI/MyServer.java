package assignments.rmi;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import assignments.rmi.MyInterface;



public class MyServer extends UnicastRemoteObject implements MyInterface {

    String identity = "mikado";
    //String identity = "rmi://localhost:2000/mikado";

    public MyServer() throws RemoteException
    {
        System.out.println("Starting Server Application");
        System.out.println("Starting RMI Registry");
        try{
            LocateRegistry.createRegistry(1099);
            System.out.println("Registry Started");
            System.out.println("Binding stub");
            Naming.rebind(identity, this);
            System.out.println("Stub Bound");
            System.out.println("Waiting for Client Calls");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public String getMessage(){
        return "Hello Client";
    }

    public static void main(String[] args) {
        try {
            new MyServer();
        } catch (Exception e) {
           System.out.println(e);
        }
        
    }

}
