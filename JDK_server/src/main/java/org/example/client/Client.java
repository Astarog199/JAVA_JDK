package org.example.client;

import org.example.sever.Server;
import javax.swing.*;
import java.util.Objects;

public class Client {
    private String name;
    private ClientGUI clientGUI;
    private final Server server;
    private boolean connected;


    public Client (ClientGUI clientGUI, Server server){
        this.clientGUI = clientGUI;
        this.server = server;
        connected = false;
    }

    public boolean getConnected(){
        return connected;
    }

    public String getName() {
        return name;
    }

    public void connectToServer(JTextField login){
        Server.Status status = server.getServerStatus();
        this.name = login.getText();
        if (status == Server.Status.online && !connected)
        {
            connected = true;
            prinText(name + " подключился к беседе \n");
            server.readLog(this);
        } else if (connected) {
            prinText("Вы уже подключены \n");
        }

    }


    public void disconnectToServer(){
        if (connected){
            connected = false;
            prinText(name + " покинул беседу \n");
        }
    }


    public void sendMessage(){
        String str = clientGUI.message();
        Server.Status status = server.getServerStatus();

        if (status == Server.Status.online ) {
            if (!Objects.equals(str, " ") && connected){
            server.logWrite(str);
            prinText(str);
                    } else prinText("Подключитесь к серверу");
        } else {
            prinText("Server offline");
        }
    }

    public void serverAnswer(String answer){
        prinText(answer);
    }

    private void prinText(String text){
        clientGUI.showMessage(text);
    }

}
