package org.example.sever;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ServerWindow extends JFrame {

    private static final int WINDOW_HEIGHT = 300;
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_POSX = 500;
    private static final int WINDOW_POSY = 550;
    public static final String LOG_PATH = "JDK_server/src/main/java/org/example/sever/log.tht";
    private Status status;
    JPanel paneLServerManagement, mainPanel;
    JButton btnConnection, btnDisconnect;
    JTextArea log;

     enum Status {
        online, offline
    }

    public Status getServerStatus() {
        return this.status;
    }

    public JTextArea getLog(){
         return log;
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
        btnConnection =new JButton("Connection");
        btnConnection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(status==Status.offline){
                    status = Status.online;
                    log.append("Server started " + "\n");
                    readLog();
                }else {
                    log.append("Server: " + "\n");
                }

            }
        });
        return btnConnection;
    }

    private Component createButtonExit(){
        btnDisconnect = new JButton("Disconnect");
        btnDisconnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(status == Status.online){
                    status = Status.offline;
                    log.append("Server stopped " + "\n");
                }else {
                    log.append("Server: " + "\n");
                }
            }
        });
        return btnDisconnect;
    }

    public void logWrite(String str) {
        try (FileWriter writer = new FileWriter("JDK_server/src/main/java/org/example/sever/log.tht", true)) {
            writer.write(str);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void readLog(){
         try(FileReader reader = new FileReader(LOG_PATH)) {
             BufferedReader r = new BufferedReader(reader);
            String line;
            while ((line =r.readLine())!= null){
                log.append(line + "\n");
             }
         }catch (Exception e){
             e.printStackTrace();
         }
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
