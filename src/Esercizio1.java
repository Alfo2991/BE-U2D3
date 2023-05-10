
public class Esercizio1 {
    public static void main(String[] args) {
        SimboloThread thread1 = new SimboloThread("*");
        SimboloThread thread2 = new SimboloThread("#");

        thread1.start();
        thread2.start();
    }
}

class SimboloThread extends Thread {
    private final String symbol;

    public SimboloThread(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.print(symbol);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
