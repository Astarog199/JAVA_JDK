package org.example.client;


import org.example.sever.ServerWindow;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;


public class ClientWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 400;
    private static final int WINDOW_WIDTH = 300;

    private ServerWindow server;

    JPanel topPanel, bottomPanel;
    JTextField ipPort, tfPort, login, password;
    JTextArea logs, message;
    JButton btnSend, btnLogin;


    public ClientWindow(ServerWindow server){
        this.server = server;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        add(createTopPanel(), BorderLayout.NORTH);
        add(createBottomPanel(), BorderLayout.SOUTH);
        add(createTextArea());
        setVisible(true);
    }

    private Component createTopPanel(){

        ipPort = new JTextField("127.0.0.1");
        tfPort = new JTextField("8189");
        login = new JTextField("Astarog");
        password = new JTextField("qwerty");
        btnLogin = new JButton("Login");


        topPanel = new JPanel(new GridLayout(2,3));
        topPanel.add(ipPort);
        topPanel.add(tfPort);
        topPanel.add(login);
        topPanel.add(password);
        topPanel.add(btnLogin);

        return topPanel;
    }

    private Component createBottomPanel(){
        bottomPanel = new JPanel(new GridLayout(1,2));
        message = new JTextArea();

        bottomPanel.add(message);
        bottomPanel.add(createBtnSend());

        return bottomPanel;
    }

    private Component createBtnSend(){

        btnSend = new JButton("Send");
            btnSend.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JTextArea log = server.log;
                    String status = String.valueOf(server.getServerStatus());
                    if (status.equals("online")){
                    log.append(String.format ("%s: %s", login.getText(), message.getText()));
                        try(FileWriter writer = new FileWriter("text.tht")) {
                            writer.write(message.getText());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }else {
                        log.append("Server offline");
                    }
                }
            });
            return btnSend;
    }


    /**
     * Этот метод создает текстовую область (JTextArea),
     * устанавливает ее как не редактируемую и добавляет ее в контейнер
     * с помощью JScrollPane.
     * Это обычно используется для отображения текста,
     * который не нужно редактировать, например, логов или вывода информации.
     */
    private Component createTextArea(){
        logs = new JTextArea();
        logs.setEditable(false);
        return new JScrollPane(logs);
    }

    /*
    2. Клиентское приложение должно отправлять сообщения из текстового поля сообщения в серверное приложение по нажатию кнопки или по нажатию клавиши Enter на поле ввода сообщения;
    3. Продублировать импровизированный лог (историю) чата в файле;
    4. При запуске клиента чата заполнять поле истории из файла, если он существует.
    Обратите внимание, что чаще всего история сообщений хранится на сервере и заполнение истории чата лучше делать при соединении с сервером, а не при открытии окна клиента.
     */



}
