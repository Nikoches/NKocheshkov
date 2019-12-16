import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestDownloader {
    @Test
    public void testlink() throws MalformedURLException {
        URL mylink = new URL("https://speed.hetzner.de/100MB.bin");
        System.out.println(mylink.getFile());

    }
}
