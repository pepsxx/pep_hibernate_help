package ru.pepsxx.hibernate.help.v010_collection;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "card_collection")
public class CardCollection {

    public CardCollection() {
    }

    public CardCollection(String name) {
        this.name = name;
        this.list = List.of("One", "Two", "Three", "Four", "Five");
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ElementCollection
    @CollectionTable(
            name = "card_collection_list",
            joinColumns = @JoinColumn(name = "card_collection_id"))
    private List<String> list = new ArrayList<String>();

}
