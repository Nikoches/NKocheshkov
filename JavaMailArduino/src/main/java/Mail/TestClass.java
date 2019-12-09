package Mail;

import javax.mail.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestClass {
//    String   IMAP_AUTH_EMAIL = "ara-gangster@yandex.ru" ;
//    String   IMAP_AUTH_PWD   = "646ara646"           ;
    String   IMAP_Server     = "imap.yandex.ru";
//    String   IMAP_Port       = "993"           ;
    Properties property;
    public void ReadEmail()
    { try (FileInputStream loader = new FileInputStream("C:\\Projects\\JavaMailArduino\\src\\main\\resources\\app.properties")) {
        property = new Properties();
        property.load(loader);
    } catch (IOException e) {
        System.err.println("Property does not exists!");
    }
//        Properties properties = new Properties();
//        properties.put("mail.debug"          , "false"  );
//        properties.put("mail.store.protocol" , "imaps"  );
//        properties.put("mail.imap.ssl.enable", "true"   );
//        properties.put("mail.imap.port"      , property.get("IMAP_Port"));
//        System.out.println(properties.toString());
        Authenticator auth = new EmailAuth(property.get("IMAP_AUTH_EMAIL").toString(),
                property.get("IMAP_AUTH_PWD").toString());
        Session session = Session.getDefaultInstance(property, auth);
        session.setDebug(false);
        try {
            Store store = session.getStore("imaps");

            // Подключение к почтовому серверу
            store.connect(IMAP_Server, (property.get("IMAP_AUTH_EMAIL").toString()),  property.get("IMAP_AUTH_PWD").toString());

            // Папка входящих сообщений
            Folder inbox = store.getFolder("INBOX");

            // Открываем папку в режиме только для чтения
            inbox.open(Folder.READ_ONLY);

            System.out.println("Количество сообщений : " + inbox.getMessageCount());
            if (inbox.getMessageCount() == 0)
                return;
            // Последнее сообщение; первое сообщение под номером 1
            Message message = inbox.getMessage(inbox.getMessageCount());
            Multipart mp = (Multipart) message.getContent();
            // Вывод содержимого в консоль
            for (int i = 0; i < mp.getCount(); i++){
                BodyPart  bp = mp.getBodyPart(i);
                if (bp.getFileName() == null)
                    System.out.println("    " + i + ". сообщение : '" +
                            bp.getContent() + "'");
                else
                    System.out.println("    " + i + ". файл : '" +
                            bp.getFileName() + "'");
            }
        } catch (NoSuchProviderException e) {
            System.err.println(e.getMessage());
            e.getCause();
        } catch (MessagingException e) {
            e.getCause();
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.getCause();
        }
    }

    public static void main(String[] args)
    {
        new TestClass().ReadEmail();
    }

}
