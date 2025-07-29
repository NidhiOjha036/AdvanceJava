package assignments.sockets;
import java.net.*;
import java.io.*;


public class ClientApp1 {
    public static void main(String[] args) {
        try {
            Socket server = new Socket("localhost",11000);
            System.out.println("Connection established with server");
            DataInputStream dis = new DataInputStream(server.getInputStream());
            PrintStream ps = new PrintStream(server.getOutputStream());
            DataInputStream local = new DataInputStream(System.in);
            while (true) {
                String s = local.readLine();
                ps.println(s);
                if(s.equalsIgnoreCase("bye"))
                    break;
                String s1 = dis.readLine();
                System.out.println("Server: "+s1);
                if(s1.equalsIgnoreCase("bye"))
                    break;
            }
            Thread.sleep(200);

        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}
