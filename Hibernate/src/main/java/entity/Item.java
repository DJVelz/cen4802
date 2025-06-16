package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Description", nullable = false, length = 45)
    private String description;

    public Item() {}

    public Item(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}