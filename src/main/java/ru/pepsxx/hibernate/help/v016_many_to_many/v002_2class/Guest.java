package ru.pepsxx.hibernate.help.v016_many_to_many.v002_2class;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Guest {

    public Guest() {
    }

    public Guest(String name) {
        this.name = name;
        this.rooms = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToMany(mappedBy = "guests")
    private Set<Room> rooms;

    public Set<Room> getRooms() {
        return rooms;
    }
}
