package JavaHttpDownloader;

import java.io.IOException;
import java.io.InputStream;

public class SpeedLimiter implements Runnable {
    private InputStream myUrlCon;
    private int limit;
    private long time;

    public SpeedLimiter(InputStream downloader, int limit) {
        this.myUrlCon = downloader;
        this.limit = limit;
    }

    @Override
    public void run() {
        time = System.currentTimeMillis();
        while (!Thread.currentThread().isInterrupted()) {
            time = time == System.currentTimeMillis() - 6000 ? System.currentTimeMillis() : time;
            try {
                System.out.println("Availble from thread=" + myUrlCon.available() + "bytes");
                if (myUrlCon.available() > limit) {
                    Thread.sleep(System.currentTimeMillis()-time);
                    System.out.println("wait");
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        Thread.currentThread().interrupt();
    }
}