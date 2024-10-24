package ru.pepsxx.hibernate.help.v020_fetch.v003_batch_size;

import jakarta.persistence.*;
import org.hibernate.annotations.BatchSize;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Person")
public class Person {

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.items = new ArrayList<>();
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;


    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    @BatchSize(size=2)
    private List<Item> items;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", items=" + items.stream().map(Item::getDescription).toList() +
                '}';
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }
}
