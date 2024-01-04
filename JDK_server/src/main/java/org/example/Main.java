package org.example;



import org.example.client.ClientWindow;
import org.example.sever.ServerWindow;

public class Main {
    public static void main(String[] args) {
        ServerWindow serverWindow = new ServerWindow();
        new ClientWindow(serverWindow);
    }
}