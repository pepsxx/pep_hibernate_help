package ru.pepsxx.hibernate.help.v011_embedded;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .addAnnotatedClass(PeopleForEmbed.class)
                .addAnnotatedClass(UserForEmbed.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            PeopleForEmbed peopleForEmbed = new PeopleForEmbed("Driving",
                    new FIOForEmbed("Alex1", "Xandr1", "Sergeevich1"));
            UserForEmbed userForEmbed = new UserForEmbed("PepSxx",
                    new FIOForEmbed("Alex2", "Xandr2", "Sergeevich2"));

            session.persist(peopleForEmbed);
            session.persist(userForEmbed);

            session.getTransaction().commit();

        }
    }
}