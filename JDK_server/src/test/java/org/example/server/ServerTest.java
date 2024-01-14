package org.example.server;

import org.example.client.Client;
import org.example.client.ClientGUI;
import org.example.sever.Server;
import org.example.sever.ServerGUI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class ServerTest {

    ServerGUI serverGUI = new ServerGUI();
    Server server = serverGUI.getServer();
    Client client = new Client(new ClientGUI(serverGUI), server);

    @Test
    void testCreateServer(){
        new ClientGUI(serverGUI);
        Assertions.assertEquals(Server.Status.offline, serverGUI.getServerStatus());
    }

    @Test
    void testServerStart(){

    }

    @Test
    void testConnectUser() {
        JTextField login = new JTextField("Bob");
        Server server = serverGUI.getServer();
        Assertions.assertEquals(false, server.connectUser(client, login));

    }




}
