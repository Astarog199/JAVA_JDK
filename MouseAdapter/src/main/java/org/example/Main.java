package org.example;

public class Main {
    public static void main(String[] args) {
        action1();
        action2();
    }

    static void action1(){
        addMouseListener add = new addMouseListener();
        add.addMouseListener(new MouseAdapter());
    }

    static void action2(){
        addMouseListener add = new addMouseListener();

        MouseListener l = new MouseListener() {
            @Override
            public void mouseUp() {
                System.out.println("клик2");
            }

            @Override
            public void mouseDown() {

            }
        };
        add.addMouseListener(l);
    }


}