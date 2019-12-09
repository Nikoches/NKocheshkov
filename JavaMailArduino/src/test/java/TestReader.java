import Mail.MailReader;
import org.junit.Test;

import javax.mail.Message;
import javax.mail.MessagingException;
import java.io.IOException;

public class TestReader {


    @Test
    public void testMail() throws IOException, MessagingException {
        MailReader ml = new MailReader();
      ml.createSession();
      for (Message x:ml.getMessages()){
          System.out.println(x.getContent()!=null?x.getContent():"emptyMessage");
      }
    }
}
