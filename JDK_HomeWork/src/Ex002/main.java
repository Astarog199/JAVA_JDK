package Ex002;

public class main {
    /*
    Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
    Вилки лежат на столе между каждой парой ближайших философов.
    Каждый философ может либо есть, либо размышлять.
    Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
    Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)
    Философ может взять только две вилки сразу, то есть обе вилки должны быть свободны
     */

    public static void main(String[] args) {
        Table table = new Table();
        for (int i = 1; i <= 5; i++) {
            table.add(new Fork());
        }

        System.out.println(Thread.currentThread());
        Thread philosopher1 = new Thread(new Philosopher("philosopher1", table.get(0), table.get(1)));
        Thread philosopher2 = new Thread(new Philosopher("philosopher2", table.get(1), table.get(2)));
        Thread philosopher3 = new Thread(new Philosopher("philosopher3", table.get(2), table.get(3)));
        Thread philosopher4 = new Thread(new Philosopher("philosopher4", table.get(3), table.get(4)));
        Thread philosopher5 = new Thread(new Philosopher("philosopher5", table.get(4), table.get(0)));
        philosopher1.start();
        philosopher2.start();
        philosopher3.start();
        philosopher4.start();
        philosopher5.start();

    }
}