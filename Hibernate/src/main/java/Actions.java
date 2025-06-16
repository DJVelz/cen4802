import entity.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class Actions {

    public void addItem(Item item) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(item);
            tx.commit();
        }
    }

    public List<Item> getAllItems() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM ToDoItem", Item.class).list();
        }
    }

    public void deleteItem(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Item item = session.get(Item.class, id);
            if (item != null) {
                session.remove(item);
            }
            tx.commit();
        }
    }
}
