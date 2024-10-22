package ru.pepsxx.hibernate.help.v016_many_to_many.v002_2class;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Room.class)
                .addAnnotatedClass(Guest.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Guest alex = new Guest("Alex");
            Guest xandr = new Guest("Xandr");
            Room room1 = new Room(101);
            Room room2 = new Room(202);

            room1.getGuests().add(alex);
            room1.getGuests().add(xandr);
            room2.getGuests().add(alex);

            session.persist(alex);
            session.persist(xandr);
            session.persist(room1);
            session.persist(room2);

            session.getTransaction().commit();
        }

    }
}