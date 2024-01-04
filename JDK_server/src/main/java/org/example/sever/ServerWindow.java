package org.example.sever;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerWindow extends JFrame {

    private static final int WINDOW_HEIGHT = 300;
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_POSX = 500;
    private static final int WINDOW_POSY = 550;
    private Status status;
    JPanel paneLServerManagement, mainPanel;
    JButton btnStart, btnExit;

    public final JTextArea log = new JTextArea();

    protected enum Status {
        online, offline
    }

    public Status getServerStatus() {
        return this.status;
    }

    public ServerWindow(){
        status = Status.offline;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false); // Метод позволяет задать возможность изменения размера окна.
        setTitle("Chat server");
        setAlwaysOnTop(true); //Метод позволяет установить окно на передний план, чтобы оно всегда было видно, даже если другие окна находятся поверх него

        add(createMainPanel());

        setVisible(true);
    }

    private Component createButtonStart(){
        btnStart =new JButton("Start");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(status==Status.offline){
                    status = Status.online;
                    log.append("Server started " + status + "\n");
                }else {
                    log.append("Server: " + status + "\n");
                }

            }
        });
        return btnStart;
    }

    private Component createButtonExit(){
        btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(status == Status.online){
                    status = Status.offline;
                    log.append("Server stopped " + status + "\n");
                }else {
                    log.append("Server: " + status + "\n");
                }
            }
        });
        return btnExit;
    }

    private Component createMainPanel(){
        mainPanel = new JPanel(new GridLayout(2,1));
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
