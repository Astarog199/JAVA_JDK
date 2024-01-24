package Ex002;

import java.util.Random;

public class Philosopher implements Runnable{

    private String name;
    Fork left, right;
    Action action;
    boolean hungry;

    @Override
    public void run() {
        while (true) {
            if (hungry) {
                try {
                    hungry = eat();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            else ponders();
            try {
                timer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public enum Action{
        eats, ponders
    }

    public Action getAction(){
        return action;
    }

    public Philosopher(String name, Fork left, Fork right){
        this.left = left;
        this.right = right;
        this.name = name;
        this.action =Action.ponders;
        this.hungry= false;
    }

    public boolean eat() throws InterruptedException{
        boolean statusLeftFork =left.getAction() == Fork.Action.notUsed;
        boolean statusRightFork =right.getAction() == Fork.Action.notUsed;

        if (statusLeftFork && statusRightFork && hungry){
            left.action = Fork.Action.used;
            right.action = Fork.Action.used;
            action = Action.eats;
            System.out.println(name + ": " + action);
        }
        Thread.sleep(5000);
        return false;
    }

    public void ponders()  {
        if (!hungry){
            left.action = Fork.Action.notUsed;
            right.action = Fork.Action.notUsed;
            action = Action.ponders;
            System.out.println(name + ": " + action);
        }

    }

    private void timer() throws InterruptedException {
        if (Action.eats != getAction()){
            Thread.sleep(getMills());
            hungry = true;
            System.out.println(name + " hungry: " + hungry);
        }
    }

    private int getMills(){
        Random r = new Random();
        int mills =  r.nextInt(2500, 10000);
//        System.out.println("mils= " + mills);
        return mills;
    }

    @Override
    public String toString() {
        return String.format("Philosopher: %s", name);
    }
}
