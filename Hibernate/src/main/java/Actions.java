import entity.Item;
import jakarta.persistence.*;
import java.util.List;

public class Actions {
    private EntityManagerFactory emf;

    public Actions(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void addItem(String description) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(new Item(description));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Item> getAllItems() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT i FROM Item i", Item.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void deleteItem(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Item item = em.find(Item.class, id);
            if (item != null) {
                em.remove(item);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}