package ru.pepsxx.hibernate.help.v020_fetch.v004_fetch_mode;

import jakarta.persistence.*;

@Entity
@Table(name = "Item")
public class Item {

    public Item() {
    }

    public Item(String description, Person person) {
        this.description = description;
        this.person = person;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", person=" + person.getName() +
                '}';
    }

    public String getDescription() {
        return description;
    }
}
