public class CounterThreads {

    public static void main(String[] args) {
        Thread countUpThread = new Thread(new CountUp());
        countUpThread.start();

        try {
            countUpThread.join(); // Wait for countUp to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread countDownThread = new Thread(new CountDown());
        countDownThread.start();

        try {
            countDownThread.join(); // Wait for countDown to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CountUp implements Runnable {
    public void run() {
        for (int i = 0; i <= 20; i++) {
            System.out.println("Count Up: " + i);
            try {
                Thread.sleep(100); // Delay for visibility
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class CountDown implements Runnable {
    public void run() {
        for (int i = 20; i >= 0; i--) {
            System.out.println("Count Down: " + i);
            try {
                Thread.sleep(100); // Delay for visibility
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}