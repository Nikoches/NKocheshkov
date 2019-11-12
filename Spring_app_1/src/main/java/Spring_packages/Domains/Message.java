package Spring_packages.Domains;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {
    private String author;
    private String text;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    protected Message() {

    }

    public Message(String author, String text) {
            this.text =text;
            this.author=author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.author + "  text=" + this.text;
    }
}
