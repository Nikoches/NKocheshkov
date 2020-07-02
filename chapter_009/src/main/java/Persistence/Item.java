package Persistence;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "items")
public class Item {
    //Можно не указывать имя столбца, если совпадает с таблицей.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "desc")
    private String desc;
    @Column(name = "done")
    private boolean done;
    @Column(name = "created")
    private Date created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Desc = " + desc + "IsDone" + done;
    }
}
