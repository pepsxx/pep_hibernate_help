package ru.pepsxx.hibernate.help.v007_addPerson;

import jakarta.persistence.*;

@Entity
@Table(name = "Item")
public class Item {

    // Должен существовать конструктор по умолчанию
    public Item() {
    }

    public Item(String description, Person person) {
        this.description = description;
        this.person = person;
    }

    //

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    // get

    public String getDescription() {
        return description;
    }

    public Person getPerson() {
        return person;
    }

    // set

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    // toString

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", person=" + person.getName() +
                '}';
    }
}
