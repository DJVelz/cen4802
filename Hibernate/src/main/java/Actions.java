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
        em.getTransaction().begin();
        em.persist(new Item(description));
        em.getTransaction().commit();
        em.close();
    }

    public List<Item> getAllItems() {
        EntityManager em = emf.createEntityManager();
        List<Item> items = em.createQuery("SELECT i FROM Item i", Item.class).getResultList();
        em.close();
        return items;
    }

    public void deleteItem(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Item item = em.find(Item.class, id);
        if (item != null) {
            em.remove(item);
        }
        em.getTransaction().commit();
        em.close();
    }
}
