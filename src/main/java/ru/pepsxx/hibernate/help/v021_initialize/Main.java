package ru.pepsxx.hibernate.help.v021_initialize;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Person.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            int random = ThreadLocalRandom.current().nextInt(10, 50);

            System.out.println("1-------------------------");
            Person person = session.get(Person.class, random);
            System.out.println("2-------------------------");
            Hibernate.initialize(person.getItems());
            System.out.println("3-------------------------");
            person.getItems().forEach(System.out::println);
            System.out.println("4-------------------------");
            System.out.println("person = " + person);
            System.out.println("5-------------------------");


            session.getTransaction().commit();
        }

    }
}