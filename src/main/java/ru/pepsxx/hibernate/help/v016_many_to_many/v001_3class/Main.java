package ru.pepsxx.hibernate.help.v016_many_to_many.v001_3class;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Room.class)
                .addAnnotatedClass(Guest.class)
                .addAnnotatedClass(RoomGuest.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Guest alex = new Guest("Alex");
            Room room = new Room(101);
            RoomGuest roomGuest = new RoomGuest(alex, room);

            session.persist(alex);
            session.persist(room);
            session.persist(roomGuest);

            session.getTransaction().commit();
        }

    }
}