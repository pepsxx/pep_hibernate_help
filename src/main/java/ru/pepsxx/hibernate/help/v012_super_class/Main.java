package ru.pepsxx.hibernate.help.v012_super_class;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.pepsxx.hibernate.help.v011_embedded.FIOForEmbed;
import ru.pepsxx.hibernate.help.v011_embedded.PeopleForEmbed;
import ru.pepsxx.hibernate.help.v011_embedded.UserForEmbed;

public class Main {
    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .addAnnotatedClass(SupperClassChildOne.class)
                .addAnnotatedClass(SupperClassChildTwo.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            SupperClassChildOne xandr = new SupperClassChildOne("Xandr", "Driver");
            SupperClassChildTwo alex = new SupperClassChildTwo("Alex", 42);

            session.persist(xandr);
            session.persist(alex);

            session.getTransaction().commit();

        }
    }
}