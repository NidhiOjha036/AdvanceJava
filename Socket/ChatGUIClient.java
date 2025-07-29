package assignments.sockets;

import javax.swing.*;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

public class ChatGUIClient extends JFrame implements ActionListener {

    Panel1 p1;
    Panel2 p2;

    Socket server;
    BufferedReader br;
    PrintStream ps;

    String clientName;

    public ChatGUIClient(String name) {
        super("Chat Client " + name);
        clientName = name;
        setLocation(100, 100);
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        p1 = new Panel1();
        p2 = new Panel2();
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
        setVisible(true);

        p2.jtf.addActionListener(this);
        p2.jbtn.addActionListener(this);

        try {
            server = new Socket("localhost", 11000);
            br = new BufferedReader(new InputStreamReader(server.getInputStream()));
            ps = new PrintStream(server.getOutputStream());

            Thread th1 = new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        try {
                            String s = br.readLine();
                            p1.jta.append(s + "\n");
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                }
            });
            th1.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void actionPerformed(ActionEvent e) {
        String msg = p2.jtf.getText();
        msg = clientName + ": " + msg;
        ps.println(msg);
        p2.jtf.setText("");
    }

    public static void main(String args[]) {
        new ChatGUIClient(args[0]);
    }
}

class Panel1 extends JPanel {
    JTextArea jta;
    JScrollPane jsp;

    public Panel1() {
        jta = new JTextArea(13, 20);
        jsp = new JScrollPane(jta);
        add(jsp);
    }
}

class Panel2 extends JPanel {
    JTextField jtf;
    JButton jbtn;

    public Panel2() {
        add(jtf = new JTextField(15));
        add(jbtn = new JButton("Send"));
    }
}
