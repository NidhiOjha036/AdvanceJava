package assignments.sockets;
import java.net.*;
import java.io.*;


public class ClientApp {
    public static void main(String[] args) {
        try {
            Socket server = new Socket("localhost",11000);
            System.out.println("Connection established with server");
            DataInputStream dis = new DataInputStream(server.getInputStream());
            PrintStream ps = new PrintStream(server.getOutputStream());
            ps.println("Hello Server"); 
            String s = dis.readLine();
            System.out.println("Server: "+s);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}
