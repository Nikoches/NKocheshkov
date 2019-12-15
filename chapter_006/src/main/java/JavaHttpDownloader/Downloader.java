package JavaHttpDownloader;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Downloader {
    private String url;
    private int limit;
    public Downloader(String url, int limit) {
        this.url = url;
        this.limit = limit;
    }

    public static void main(String... args)  {
        new Downloader(args[0],Integer.parseInt(args[1])).getFile();
    }

    private void getFile()  {
        try  {
            URL linkUrl = new URL(this.url);
            FileOutputStream fileOutputStream = new FileOutputStream(linkUrl.getFile());
            HttpURLConnection myUrlCon = (HttpURLConnection) linkUrl.openConnection();
            if (myUrlCon.getResponseCode() != HttpURLConnection.HTTP_OK) {
                System.out.println("URL response code" + myUrlCon.getResponseCode());
                return;
            }
            InputStream fileReader = myUrlCon.getInputStream();
            Thread rubb = new Thread(new SpeedLimiter(fileReader,limit));
            rubb.start();
            System.out.println("Main Thread availble = " + fileReader.available());
            fileReader.transferTo(fileOutputStream);
            fileReader.close();
            rubb.interrupt();
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
