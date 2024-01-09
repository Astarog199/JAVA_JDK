package org.example.circles;

import org.example.MouseListener.CreateMouseListener;
import org.example.MouseListener.MouseListener;
import org.example.common.Background;
import org.example.common.CanvasRepaintListener;
import org.example.common.Interactable;
import org.example.common.MainCanvas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Основное окно
 */
public class MainWindow extends JFrame implements CanvasRepaintListener, Thread.UncaughtExceptionHandler {
    private static final int POS_X=400;
    private static final int POS_Y =200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private static int DEFAULT_COUNT_SPRITES = 5;

    private Interactable[] sprites;

    protected MainWindow(){
        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circle");

        createCircle();
        MainCanvas canvas = new MainCanvas(this);

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                try {
                    addNewCircle(e);
                } catch (java.lang.Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        add(canvas);

        setVisible(true);
    }

    /**
     * Метод создаёт объекты
     */
    private void createCircle(){
        sprites = new Interactable[DEFAULT_COUNT_SPRITES+1];
        sprites[0] = new Background();
        for (int i =1; i< sprites.length; i++){
            sprites[i] = new Ball();
        }
    }

    /**
     * Метод добавляет новые объекты по нажатию левой кнопки мыши
     * И убирает по нажатию правой кнопки мыши
     */
    private void addNewCircle(MouseEvent e) throws java.lang.Exception {
        //Описать появление и убирание шариков
        //по клику мышки левой и правой кнопкой соответственно;

        CreateMouseListener add = new CreateMouseListener();
        MouseListener l = new MouseListener() {
            @Override
            public void leftMouseButtonAction()  {
                if (DEFAULT_COUNT_SPRITES <= 15) {
                    DEFAULT_COUNT_SPRITES +=1;
                    createCircle();
                }else {
                   throw new ArrayIndexOutOfBoundsException("Достигнуто максимальное количество шаров.");
                }
            }

            @Override
            public void RightMouseButtonAction() {
                if (DEFAULT_COUNT_SPRITES >=2){
                    DEFAULT_COUNT_SPRITES -=1;
                    createCircle();
                }else {
                    throw new ArrayIndexOutOfBoundsException("Достигнуто минимальное количество шаров.");
                }
            }
        };
        add.CreateMouseListener(l,e);
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

    /**
     * Метод выводит исключение на экран
     * @param t the thread(поток)
     * @param e the exception(ошибка в потоке)
     */

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        StringBuilder mes = new StringBuilder(e.getMessage());
        mes.replace(0, mes.indexOf(":")+1, "");
        JOptionPane.showMessageDialog(
                null, mes.toString(),
                "Exception", JOptionPane.ERROR_MESSAGE);
    }
}

