package ru.pepsxx.hibernate.help.v017_entity_manager;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.pepsxx.hibernate.help.v001_persist.Person;

public class Main {
    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            EntityManager entityManager = sessionFactory.createEntityManager();
            Person person = entityManager.find(Person.class, 1L);
            System.out.println("person = " + person);

            session.getTransaction().commit();
        }

    }
}