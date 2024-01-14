package org.example;



import org.example.client.ClientGUI;
import org.example.sever.ServerGUI;

public class Main {
    public static void main(String[] args) {
        ServerGUI serverGUI = new ServerGUI();
        new ClientGUI(serverGUI);
        new ClientGUI(serverGUI);


    }
}