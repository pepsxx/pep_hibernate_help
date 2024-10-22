package ru.pepsxx.hibernate.help.v009_delPerson;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Person")
public class Person {

    // Должен существовать конструктор по умолчанию
    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.items = new ArrayList<>();
    }

    //

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;


    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "person")
    private List<Item> items;

    // get

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Item> getItems() {
        return items;
    }

    // set

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    // toString


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", items=" + items.stream().map(Item::getDescription).toList() +
                '}';
    }

    // delete Person (Custom)
    public void deletePersonCustom() {
            items.forEach(item -> item.setPerson(null));
            items.clear();
    }
}
