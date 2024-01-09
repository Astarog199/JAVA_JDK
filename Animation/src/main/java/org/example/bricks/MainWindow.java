package org.example.bricks;

import org.example.common.Background;
import org.example.common.CanvasRepaintListener;
import org.example.common.Interactable;
import org.example.common.MainCanvas;

import javax.swing.*;
import java.awt.*;

/**
 * Основное окно
 */
public class MainWindow extends JFrame implements CanvasRepaintListener {
    private static final int POS_X=400;
    private static final int POS_Y =200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private static final int DEFAULT_COUNT_SPRITES = 10;
    private Interactable[] sprites;

    protected MainWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Bricks");

        createObjects();
        MainCanvas canvas = new MainCanvas(this);
        add(canvas);

        setVisible(true);
    }

    /**
     * Метод создаёт объекты
     */
    private void createObjects(){
        sprites = new Interactable[DEFAULT_COUNT_SPRITES];
        sprites[0] = new Background();
        for (int i =1; i< sprites.length; i++){
            sprites[i] = new Brick();
        }
    }

    /**
     *Рисование и анимация объектов
     */
    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    /**
     * Метод изменяет состояние объектов со временем
     * @param canvas панель для рисования
     */
    public void update(MainCanvas canvas, float deltaTime) {
        for (int i =0; i< sprites.length; i++){
            sprites[i].update(canvas, deltaTime);
        }
    }

    /**
     * Метод отрисовывает объекты
     * @param canvas объект панели для рисования
     */
    public void render(MainCanvas canvas,Graphics g) {
        for (int i = 0; i < sprites.length; i++){
            sprites[i].render(canvas, g);
        }
    }
}
