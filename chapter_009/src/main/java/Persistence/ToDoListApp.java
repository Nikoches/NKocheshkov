package Persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ToDoListApp implements ItemDao{
    private final static ToDoListApp toDoListApp = new ToDoListApp();

    public static ToDoListApp getInstance() {
        return toDoListApp;
    }

    private ToDoListApp(){

    }
    @Override
    public void save(Item item) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction =session.beginTransaction();
        session.save(item);
        transaction.commit();
        session.close();
    }

    @Override
    public Item findByid(Integer id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        return session.get(Item.class,id);
    }

    @Override
    public void update(Item item) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(item);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Item id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(id);
        tx1.commit();
        session.close();
    }

    @Override
    public List<Item> getAll() {
       return HibernateUtils.getSessionFactory().openSession().createQuery("From Persistence.Item").list();
    }
}
