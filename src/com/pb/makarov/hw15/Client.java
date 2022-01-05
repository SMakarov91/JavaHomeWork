package com.pb.makarov.hw15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client extends JFrame {
    private static final String serverIp = "127.0.0.1";
    private static final int serverPort = 1234;

    private Socket server;
    private Scanner inMsg;
    private PrintWriter outMsg;

    private JTextArea jtAreaMessage;
    private JTextField jtfMessage;

    public Client() {
        try {
            server = new Socket(serverIp, serverPort);
            inMsg = new Scanner(server.getInputStream());
            outMsg = new PrintWriter(server.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        setBounds(600, 300, 600, 500);
        setTitle("Client");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jtAreaMessage = new JTextArea();
        jtAreaMessage.setEditable(false);
        jtAreaMessage.setLineWrap(true);
        add(jtAreaMessage, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);
        jtfMessage = new JTextField();
        bottomPanel.add(jtfMessage, BorderLayout.CENTER);
        JButton jbSendMessage = new JButton("Отправить");
        bottomPanel.add(jbSendMessage, BorderLayout.EAST);

        jbSendMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jtfMessage.getText().trim().isEmpty()) {
                    sendMsg();
                }
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (inMsg.hasNext()) {
                            String inMes = inMsg.nextLine();

                            jtAreaMessage.append(inMes);
                            jtAreaMessage.append("\n");
                        }
                    }
                } catch (Exception e) {
                }
            }
        }).start();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    outMsg.println("Отключился");
                    outMsg.flush();
                    outMsg.close();
                    inMsg.close();
                    server.close();
                } catch (IOException exc) {
                }
            }
        });
        setVisible(true);
    }

    public void sendMsg() {
        String messageStr = jtfMessage.getText();
        outMsg.println(messageStr);
        outMsg.flush();
        jtfMessage.setText("");
    }
}