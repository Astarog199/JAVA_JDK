package org.example.client;
import org.example.sever.ServerGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;


public class ClientGUI extends JFrame implements ClientView {
    private static final int WINDOW_HEIGHT = 400;
    private static final int WINDOW_WIDTH = 300;
    private final ServerGUI serverGUI;
    private final Client client;

    JPanel topPanel, bottomPanel;
    JTextField ipPort, tfPort, login, password;
    JTextArea logs, message;
    JButton btnSend, btnLogin, btnExit;


    public ClientGUI(ServerGUI serverGUI) {
        this.serverGUI = serverGUI;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        add(createTopPanel(), BorderLayout.NORTH);
        add(createBottomPanel(), BorderLayout.SOUTH);
        add(createTextArea());

        setVisible(true);

        client = new Client( this, serverGUI.getServer());
    }

    private Component createTopPanel() {

        ipPort = new JTextField("127.0.0.1");
        tfPort = new JTextField("8189");
        login = new JTextField("User");
        password = new JTextField("qwerty");

        topPanel = new JPanel(new GridLayout(2, 3));
        topPanel.add(ipPort);
        topPanel.add(tfPort);
        topPanel.add(login);
        topPanel.add(password);
        topPanel.add(createBtnLogin());
        topPanel.add(createBtnExit());

        return topPanel;
    }

    private Component createBottomPanel() {
        bottomPanel = new JPanel(new GridLayout(1, 2));
        message = new JTextArea();

        bottomPanel.add(message);
        bottomPanel.add(createBtnSend());

        return bottomPanel;
    }

    public String message() {
        return String.format("%s: %s \n", login.getText(), message.getText());
    }

    private Component createBtnSend() {
        btnSend = new JButton("Send");
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.sendMessage();
            }
        });
        return btnSend;
    }

    private Component createBtnLogin(){
        btnLogin = new JButton("Login");

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serverGUI.connectUser(client, login);
            }
        });

        return btnLogin;
    }

    private Component createBtnExit(){
        btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.disconnectToServer();
            }
        });
        return btnExit;
    }



    /**
     * Этот метод создает текстовую область (JTextArea),
     * устанавливает ее как не редактируемую и добавляет ее в контейнер
     * с помощью JScrollPane.
     * Это обычно используется для отображения текста,
     * который не нужно редактировать, например, логов или вывода информации.
     */
    private Component createTextArea() {
        logs = new JTextArea();
        logs.append("Server status: " + serverGUI.getServerStatus() + "\n");
        logs.setEditable(false);
        return new JScrollPane(logs);
    }

    @Override
    public void showMessage(String text) {
        logs.append(text);
    }

    @Override
    public void disconnectFromServer() {
        client.disconnectToServer();
    }

    @Override
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING){
            disconnectFromServer();
        }
    }
}
