package org.example.client;

import org.example.sever.ServerGUI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;


import javax.swing.*;

import static org.mockito.Mockito.*;


public class ClientTest {

    @Mock
    ServerGUI serverGUI = new ServerGUI();
    @Mock
    ClientGUI clientGUI = new ClientGUI(serverGUI);
    @Mock
    JTextField login = mock(clientGUI.login);
    @Mock
    JTextArea message = mock(clientGUI.message);


    @Test
    public void testMessage() {
        doReturn("Test Login").when(login).getText();
        doReturn("Test Message").when(message).getText();
        String result = clientGUI.message();

        Assertions.assertEquals("Test Login: Test Message \n", result);
    }

}

