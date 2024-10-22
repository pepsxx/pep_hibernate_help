package ru.pepsxx.hibernate.help.v016_many_to_many.v001_3class;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Room {

    public Room(){}

    public Room(int number) {
        this.number = number;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int number;

    @OneToMany(mappedBy = "room")
    private List<RoomGuest> roomGuests;

}
