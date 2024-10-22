package ru.pepsxx.hibernate.help.v016_many_to_many.v001_3class;

import jakarta.persistence.*;

@Entity
@Table(name = "room_guest")
public class RoomGuest {

    public RoomGuest(){}

    public RoomGuest(Guest guest, Room room) {
        this.guest = guest;
        this.room = room;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "guest_id", referencedColumnName = "id")
    private Guest guest;

    @Id
    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;
}
