package org.example;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 10;

    private static final int MODE_HVA = 0;
    private static final int MODE_HVH = 1;

    private static final int WINDOW_HEIGHT = 430;
    private static final int WINDOW_WIDTH = 350;

    private static final String titleBtnStartGame = "Начать игру";
    private static final String labelModeSelection = "Выберите режим игры";
    private static final String titleBtnATVsHuman = "Человек против компьютера";
    private static final String titleBtnHumanVsHuman = "Человек против человека";
    private static final String labelFieldSize = "Установленный размер поля:";
    private static final String titlelabelLength = "Установленная длина:";
    private static final String labelSelectFieldSizes = "Выберите размеры поля";
    private static final String titlelabellengthToWin = "Выберите длину для победы";
    int size;

    GameWindow gameWindow;
    JRadioButton btnAtVsHuman, btnHumanVsHuman;
    JSlider sliderFieldSizes;


    SettingsWindow(GameWindow gameWindow) {

        this.gameWindow = gameWindow;
//        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);


        int centerGameWindowX = gameWindow.getX() + gameWindow.getWidth()/2;
        int centerGameWindowY = gameWindow.getY() + gameWindow.getHeight()/2;
        setLocation(centerGameWindowX - WIDTH/2, centerGameWindowY - HEIGHT/2);

        add(createPanel());
        add(createButtonStart(), BorderLayout.SOUTH);
    }

    private Component createButtonStart() {
        JButton btnStartGame = new JButton(titleBtnStartGame);
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
                setVisible(false);
            }
        });

        return btnStartGame;
    }

    private void startGame() {
        int mode;
        if (btnAtVsHuman.isSelected()) {
            mode = MODE_HVA;
        } else if (btnHumanVsHuman.isSelected()) {
            mode = MODE_HVH;

        } else {
            throw new RuntimeException("Unknown game mode");
        }
        size = sliderFieldSizes.getValue();

        gameWindow.startNewGame(mode, size, size, 3);
    }

    private Component createPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1));

        panel.add(createPanelModeSelection());
        panel.add(createPanelFieldSizes());
        panel.add(createPanelConditionsForVictory());
        return panel;
    }

    private Component createPanelModeSelection() {

        JPanel panelMode = new JPanel(new GridLayout(3, 1));

        JLabel modeSelection = new JLabel(labelModeSelection);
        btnAtVsHuman = new JRadioButton(titleBtnATVsHuman);
        btnHumanVsHuman = new JRadioButton(titleBtnHumanVsHuman);
        btnAtVsHuman.setSelected(true);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(btnAtVsHuman);
        buttonGroup.add(btnHumanVsHuman);

        panelMode.add(modeSelection);
        panelMode.add(btnAtVsHuman);
        panelMode.add(btnHumanVsHuman);

        return panelMode;
    }

    private Component createPanelFieldSizes() {

        JPanel panelSelectFieldSizes = new JPanel(new GridLayout(3, 1));
        JLabel selectFieldSizes = new JLabel(labelSelectFieldSizes);
        sliderFieldSizes = new JSlider(MIN_SIZE, MAX_SIZE, MIN_SIZE);
        JLabel fieldSize = new JLabel(labelFieldSize + MIN_SIZE);

        sliderFieldSizes.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int curSize = sliderFieldSizes.getValue();
                fieldSize.setText(labelFieldSize + curSize);

            }
        });

        panelSelectFieldSizes.add(selectFieldSizes);
        panelSelectFieldSizes.add(sliderFieldSizes);
        panelSelectFieldSizes.add(fieldSize);

        return panelSelectFieldSizes;
    }

    private Component createPanelConditionsForVictory() {
        JPanel panelConditionsForVictory = new JPanel(new GridLayout(3, 1));

        JLabel labellengthToWin = new JLabel(titlelabellengthToWin);
        JSlider sliderlengthToWin = new JSlider(MIN_SIZE, MAX_SIZE,MIN_SIZE);
        JLabel labelLength = new JLabel(titlelabelLength + MIN_SIZE);

        sliderlengthToWin.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int lengthToWin = sliderlengthToWin.getValue();
                labelLength.setText(titlelabelLength + lengthToWin);
            }
        });


        panelConditionsForVictory.add(labellengthToWin);
        panelConditionsForVictory.add(sliderlengthToWin);
        panelConditionsForVictory.add(labelLength);


        return panelConditionsForVictory;
    }

    public int getsize(){
        return size;
    }
}
