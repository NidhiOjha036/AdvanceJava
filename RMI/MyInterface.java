package assignments.rmi;
import java.rmi.*;

public interface MyInterface extends Remote {
    public String getMessage() throws RemoteException;
} 
