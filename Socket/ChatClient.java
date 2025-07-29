package assignments.sockets;
import java.net.*;
import java.io.*;
import java.util.*;

public class ChatClient {
    Socket server;
    DataInputStream dis, local;
    PrintStream ps;
    String clientName;

    public ChatClient(String name)
    {
        clientName = name;
        try {
            server = new Socket("localhost",11000);
            DataInputStream dis = new DataInputStream(server.getInputStream());
            PrintStream ps = new PrintStream(server.getOutputStream());
            DataInputStream local = new DataInputStream(System.in);
            Thread th1 = new Thread(new Runnable() {
                public void run()
                {
                    while (true) {
                        try {
                            String s = dis.readLine();
                            System.out.println(s);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                }
            });
            Thread th2 = new Thread(new Runnable() {
                public void run()
                {
                    while (true) {
                        try {
                            String s = local.readLine();
                            s = clientName + " : "+s;
                            ps.println(s);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        
                    }
                }
            });
            th1.start();
            th2.start();
        } catch (Exception e) {
            System.out.println(e);
        }  
    }

    public static void main(String[] args) {
        new ChatClient(args[0]);
    }
}
