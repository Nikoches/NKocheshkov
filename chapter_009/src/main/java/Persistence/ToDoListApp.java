package Persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ToDoListApp implements ItemDao {
    private final static ToDoListApp toDoListApp = new ToDoListApp();

    private ToDoListApp() {
    }

    public static ToDoListApp getInstance() {
        return toDoListApp;
    }
    @Override
    public void save(Item item) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(item);
        transaction.commit();
        session.close();
    }

    @Override
    public Item findByid(Integer id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        return session.get(Item.class, id);
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
    public List<Item> getByExcecuted(int i) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        if(i == 1) {
            return getAll();
        } else if(i == 2) {
            String hql = "FROM Persistence.Item e WHERE e.done = true";
            Query query = session.createQuery(hql);
            return query.list();
        } else if (i == 3) {
            String hql = "FROM Persistence.Item e WHERE e.done = false";
            Query query = session.createQuery(hql);
            return query.list();
        }
        String hql = "FROM Persistence.Item e WHERE e.done = true";
        Query query = session.createQuery(hql);
        List results = query.list();
        return results;
    }
}
