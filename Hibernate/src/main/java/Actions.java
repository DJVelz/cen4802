import entity.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class Actions {
    private final SessionFactory sessionFactory;

    public Actions(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addItem(Item item) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(item);
            tx.commit();
        }
    }

    public List<Item> getAllItems() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Item", Item.class).list();
        }
    }

    public void deleteItem(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Item item = session.get(Item.class, id);
            if (item != null) {
                session.remove(item);
            }
            tx.commit();
        }
    }
}