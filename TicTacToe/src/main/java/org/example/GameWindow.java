package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

//    Константы с параметрами окна
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;

    //Кнопки
    JButton btnStart = new JButton("New Game");
    JButton btnExit = new JButton("Exit");
    Map map;
    SettingsWindow settings;

    GameWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("TicTacToe");
        setResizable(false);
        setVisible(true);

        map = new Map();
        settings= new SettingsWindow(this);

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });

        settings.setVisible(true);

        JPanel panBottom =new JPanel(new GridLayout(1, 2)); // создаём панель с одной строкой и двумя ячейками
        panBottom.add(btnStart);    // добавляем кнопку в первую ячейку панели
        panBottom.add(btnExit);     // добавляем кнопку во вторую ячейку панели
        add(panBottom, BorderLayout.SOUTH);  // добавляем в GameWindow панель с кнопками
        add(map);



    }

    void startNewGame (int mode, int fSzX, int fSzY, int wLen) {
        map.startNewGame(mode, fSzX, fSzY, wLen);
    }

}
