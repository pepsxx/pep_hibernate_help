package ru.pepsxx.hibernate.help.v016_many_to_many.v002_2class;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Room {

    public Room() {
    }

    public Room(int number) {
        this.guests = new HashSet<>();
        this.number = number;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int number;

    @ManyToMany()
    @JoinTable(name = "room_guest",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "guest_id"))
    private Set<Guest> guests;

    public Set<Guest> getGuests() {
        return guests;
    }
}
