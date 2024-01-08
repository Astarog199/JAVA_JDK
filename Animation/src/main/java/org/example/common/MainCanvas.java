package org.example.common;

import javax.swing.*;
import java.awt.*;

/**
 * Панель для рисования
 */
public class MainCanvas extends JPanel {

    private final CanvasRepaintListener controller;
    private long lastFrameTime;

    public MainCanvas(CanvasRepaintListener controller) {
        this.controller = controller;
        lastFrameTime = System.nanoTime();
    }
    /**
     * Метод выполняет отрисовку на панели
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        sleep(16);
        onDraw(g);
        repaint();
    }

    /**
     * Метод выполняет рисование элементов на панели
     * Метод System.nanoTime() используется для получения текущего времени системы в наносекундах.
     * lastFrameTime используется для хранения времени последнего кадра
     * deltaTime это время прошедшее с момента последнего кадра
     */
    private void onDraw(Graphics g){
        float deltaTime = (System.nanoTime() - lastFrameTime) *0.000000001f;
        controller.onDrawFrame(this, g, deltaTime);
        lastFrameTime = System.nanoTime();
    }

    /**
     * Метод используется для задержки отрисовки интерфейса на 16 миллисекунд, что помогает сглаживать анимацию.
     * И оптимизировать нагрузку на процессор компьютера.
     * @param mills время задержки
     */
    private void sleep (long mills){
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public int getLeft() {
        return 0;
    }

    public int getRight() {
        return getWidth() - 1;
    }

    public int getTop() {
        return 0;
    }

    public int getBottom() {
        return getHeight() - 1;
    }
}
