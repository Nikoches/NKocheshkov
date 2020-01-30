package ExecutorCervice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailNotification {
    private String subject  = "Notification {%s} to email {%s}";
    private String body  = "Add a new event to {username}";
    private ExecutorService pool = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );
    public void emailTo (User user) {
        pool.submit(new Runnable() {
            @Override
            public void run() {
                send(String.format(subject,user.getName(),user.getEmail()),String.format(body,user.getName()),user.getEmail());

            }
        });
    }
    public void send(String suject, String body, String email){
        System.out.println("subject"+suject+"\nExecute " + Thread.currentThread().getName());
    }
    public boolean close() {
        pool.shutdown();
        return true;
    }

    public static void main(String[] args) {
        EmailNotification exc = new EmailNotification();
        exc.emailTo(new User("User1","user1@email.de"));
        exc.close();
    }
}
