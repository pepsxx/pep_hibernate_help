package ru.pepsxx.hibernate.help.v016_many_to_many;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Guest {

    public Guest() {
    }

    public Guest(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "guest")
    private List<RoomGuest> roomGuests;

}
