package org.example.circles;

import org.example.common.MainCanvas;
import org.example.common.Sprite;

import java.awt.*;
import java.util.Random;

public class Ball extends Sprite {
    private static Random rnd = new Random();
    private final Color color;
    private float vX;
    private float vY;

     public Ball() {
        halfHeight = 20 + rnd.nextFloat(50);
        halfWidth = halfHeight;
        this.color = new Color(rnd.nextInt());
        this.vX = 100f + rnd.nextFloat(200);  // перемещение
        this.vY = 100f + rnd.nextFloat(200);  // перемещение
    }

    /**
     * Метод рисует fillOval(круги) на холсте
     * @param canvas холост
     * @param g объект графики
     */
    @Override
    public void render(MainCanvas canvas, Graphics g) {
        g.setColor(color);
        g.fillOval((int) getLeft(), (int)getTop(),
                (int)getWidth(), (int)getHeight());
    }

    @Override
    public void update(MainCanvas canvas, float deltaTime) {
        x += vX * deltaTime;
        y += vY * deltaTime;

        if(getLeft() < canvas.getLeft()){
            setLeft(canvas.getLeft());
            vX=-vX;
        }

        if (getRight() > canvas.getRight()){
            setRight(canvas.getRight());
            vX = -vX;
        }
        if (getTop() < canvas.getTop()){
            setTop(canvas.getTop());
            vY = -vY;
        }
        if (getBottom() > canvas.getBottom()){
            setBottom(canvas.getBottom());
            vY = -vY;
        }
    }
}
