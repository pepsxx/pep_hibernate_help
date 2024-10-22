package ru.pepsxx.hibernate.help.v009_delItem;

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


            Item item = session.get(Item.class, random);
            Person person = item.getPerson();
            List<Item> items = person.getItems();
            System.out.println(person);
            items.forEach(System.out::println);
            System.out.println("-------------------------");

            // Удаляем в SQL
            session.remove(item);
            System.out.println("-------------------------");

            // Правим в JAVA
            item.deleteItemCustom();
            System.out.println("-------------------------");

            System.out.println(person);
            items.forEach(System.out::println);
            System.out.println("------------------------");

            session.getTransaction().commit();
        }

    }
}