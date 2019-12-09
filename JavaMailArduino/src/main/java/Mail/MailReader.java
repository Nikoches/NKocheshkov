package Mail;

import Mail.EmailAuth;

import javax.mail.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MailReader {
    private Properties property;
    private Store store;

    public MailReader() {
        try (FileInputStream loader = new FileInputStream("C:\\Projects\\JavaMailArduino\\src\\main\\resources\\app.properties")) {
            property = new Properties();
            property.load(loader);
        } catch (IOException e) {
            System.err.println("Property does not exists!");
        }
    }

    public Message[] getMessages() {
        Message[] messages = new Message[5];
        try {
            System.out.println();
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            System.out.println("Количество сообщений : " + inbox.getMessageCount());
            System.out.println("Количество сообщений : " + inbox.getUnreadMessageCount());
            for (int i=0;i<5;i++) {
                messages[i] = inbox.getMessage(i);
            }

        } catch (MessagingException e) {
            System.err.println(e.getMessage());
        }
        return messages;
    }

    public void createSession() {
        try {
            Authenticator auth = new EmailAuth(property.getProperty("IMAP_AUTH_EMAIL"), property.getProperty("IMAP_AUTH_PWD"));
            Session session = Session.getDefaultInstance(property, auth);
            session.setDebug(false);
            store = session.getStore();
        } catch (Exception e) {
            e.getMessage();
        }
    }

}
