public class Example {
    public static void main(String[] args) throws InterruptedException {
        Thread run = new Thread() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        System.out.println("Sleep");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Is interrupted");
                        Thread.currentThread().interrupt();
                    }
                }
            }
        };

        run.start();
        Thread.sleep(500);
        run.interrupt();
    }
}
