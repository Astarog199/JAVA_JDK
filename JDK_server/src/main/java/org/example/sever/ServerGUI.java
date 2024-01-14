package org.example.sever;

import org.example.client.Client;
import org.example.sever.repository.Storage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerGUI extends JFrame {
    private final Server server;
    private static final int WINDOW_HEIGHT = 300;
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_POSX = 500;
    private static final int WINDOW_POSY = 550;


    JPanel paneLServerManagement, mainPanel;
    JButton btnConnection, btnDisconnect;
    JTextArea log;



    public ServerGUI(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false); // Метод позволяет задать возможность изменения размера окна.
        setTitle("Chat server");
        setAlwaysOnTop(true); //Метод позволяет установить окно на передний план, чтобы оно всегда было видно, даже если другие окна находятся поверх него

        add(createMainPanel());

        setVisible(true);
        server = new Server(this);
    }

    public Server getServer(){
        return server;
    }
    public Server.Status getServerStatus() {
        return server.getServerStatus();
    }


    private Component createButtonStart(){
        btnConnection =new JButton("Connection");
        btnConnection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.serverStart();
            }
        });
        return btnConnection;
    }

    private Component createButtonExit(){
        btnDisconnect = new JButton("Disconnect");
        btnDisconnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.serverStopped();
            }
        });
        return btnDisconnect;
    }

    public void connectUser(Client client, JTextField login){
       server.connectUser(client, login);
    }

    private Component createMainPanel(){
        mainPanel = new JPanel(new GridLayout(2,1));
        log = new JTextArea();
        mainPanel.add(createPaneLServerManagement(), BorderLayout.CENTER);
        mainPanel.add(log);
        return mainPanel;
    }

    private Component createPaneLServerManagement(){
        paneLServerManagement = new JPanel(new GridLayout(1,2));
        paneLServerManagement.add(createButtonStart());
        paneLServerManagement.add(createButtonExit());
        return paneLServerManagement;
    }
}
