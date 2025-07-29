
package assignments.sockets;
import java.net.*;
import java.io.*;
import java.util.*;

public class ChatServer 
{
    ServerSocket server;
    Vector v;

    public ChatServer()
    {
        v = new Vector();
        try {
            server = new ServerSocket(11000);
            Thread th1 = new Thread(new Runnable() {
                public void run()
                {
                    while (true) {
                        try {
                            Socket client = server.accept();
                            DataInputStream dis = new DataInputStream(client.getInputStream());
                            PrintStream ps = new PrintStream(client.getOutputStream());
                            v.add(ps);
                            Type2Thread type2 = new Type2Thread(dis,ps);
                            type2.start();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        

                    }

                }
            });
            th1.start();
        } catch (Exception e) 
        {
            System.out.println(e);
        }
    }

    class Type2Thread extends Thread
    {
        DataInputStream dis;
        PrintStream ps;
        public Type2Thread(DataInputStream dis, PrintStream ps)
        {
            this.dis = dis;
            this.ps = ps;
        }
        public void run()
        {
            while (true) {
                try 
                {  
                    String s = dis.readLine();
                    broadCastMsg(s);
                } catch (Exception e) 
                {
                    v.remove(ps);
                    stop();
                }
            }
        }
    }

    public void broadCastMsg(String msg)
    {
        Enumeration en = v.elements();
        while (en.hasMoreElements()) {
            PrintStream ps = (PrintStream)en.nextElement();
            ps.println(msg);
        }
    }

    public static void main(String[] args) {
        new ChatServer();
    }

}
