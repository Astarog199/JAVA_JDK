package org.example.sever;

import org.example.client.Client;
import org.example.sever.repository.DB_Users;
import org.example.sever.repository.Storage;
import org.example.sever.repository.User;

import javax.swing.*;
import java.util.Iterator;


public class Server {
    private Status status;
    private Storage storage; // сохранение и загрузка истории переписки
    private DB_Users dbUsers;

    private final ServerGUI serverGUI;
    public enum Status {
        online, offline
    }

    Server(ServerGUI serverGUI){
        status = Status.offline;
        this.serverGUI = serverGUI;
        this.storage = new Storage();
        this.dbUsers = new DB_Users();
    }

    public Status getServerStatus() {
        return this.status;
    }

    protected void serverStart(){
        if(status== Status.offline){
            status = Status.online;
            serverGUI.log.append("Server start " + "\n");
        }else {
           serverGUI.log.append("Server: " + status  + "\n");
        }
    }

    protected void serverStopped(){
        if(status == Status.online){
            status = Status.offline;
            serverGUI.log.append("Server stopped " + "\n");


        }else {
            serverGUI.log.append("Server: " + status + "\n");
        }
    }

    public void logWrite(String str) {
        storage.logWrite(str);
    }

    public void readLog(Client user){
        storage.readLog(user);
    }

    public boolean connectUser(Client client, JTextField login){

        if (status== Status.online){
            client.connectToServer(login);
            dbUsers.add(new User(client.getName(), "qwerty", "8189", "127.0.0.1"));
            dbUsers.usersConnect(serverGUI.log);
            return true;
        }
        else {
            client.serverAnswer("Server status: " + getServerStatus() + "\n");
            return false;
        }
    }


}
