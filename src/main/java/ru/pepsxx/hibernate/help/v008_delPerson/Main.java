package ru.pepsxx.hibernate.help.v008_delPerson;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
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

            Person person = session.get(Person.class, random);
            List<Item> items = person.getItems();
            System.out.println(person);
            items.forEach(System.out::println);
            System.out.println("-------------------------");

            // Удаляем в SQL
            session.remove(person);
            System.out.println("-------------------------");

            // Удаляем в JAVA (Custom)
            person.deletePersonCustom();

            System.out.println(person);
            items.forEach(System.out::println);
            System.out.println("------------------------");


            session.getTransaction().commit();
        }

    }
}