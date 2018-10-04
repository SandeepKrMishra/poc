/**
 * Created by sandeepmishra on 04/08/18.
 */
import java.util.Vector;

public class ProducerConsumer extends Thread {
    private static int i = 0;

    private static Vector<Integer> v = new Vector<Integer>(5);

    private ProducerConsumer tt;
    private ProducerConsumer tt1;

    private void setNextObj(ProducerConsumer tt) {
        this.tt = tt;
    }

    private void setNextObj1(ProducerConsumer tt1) {
        this.tt1 = tt1;
    }

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer oe1 = new ProducerConsumer();
        ProducerConsumer oe2 = new ProducerConsumer();
        ProducerConsumer oe3 = new ProducerConsumer();
        ProducerConsumer oe4 = new ProducerConsumer();
        ProducerConsumer oe5 = new ProducerConsumer();

        oe1.setNextObj(oe2);
        oe2.setNextObj(oe3);
        oe3.setNextObj(oe1);
        oe4.setNextObj1(oe5);
        oe5.setNextObj1(oe4);

        oe1.start();
        oe2.start();
        oe3.start();


        Thread.sleep(1000);

        synchronized (oe1) {
            oe1.notify();
        }


        oe4.start();
        oe5.start();

        Thread.sleep(1000);

        synchronized (oe4) {
            oe4.notify();
        }
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                try {
                    Thread.sleep(1000);
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (v.size() == 0 || v.size() < 5) {

                synchronized (tt) {
                    System.out.println(Thread.currentThread() + " HKHR producer : " + i);
                    v.addElement(i);
                    i++;

                    tt.notify();
                }
            } else if (v.size() != 0) {

                synchronized (tt) {
                    Integer value = v.remove(0);
                    System.out.println(Thread.currentThread() + " HKHR consumer : " + value);
                    tt.notify();
                }
            }
        }

    }

}
