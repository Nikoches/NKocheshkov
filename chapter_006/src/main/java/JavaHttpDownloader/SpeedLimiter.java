package JavaHttpDownloader;

import java.io.IOException;
import java.io.InputStream;

public class SpeedLimiter implements Runnable {
    private InputStream myUrlCon;
    private int limit;
    public SpeedLimiter(InputStream downloader, int limit) {
        this.myUrlCon = downloader;
        this.limit = limit;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println("Availble from thread=" + myUrlCon.available() + "bytes");
                if(myUrlCon.available()>limit){
                    Thread.sleep(6000);
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