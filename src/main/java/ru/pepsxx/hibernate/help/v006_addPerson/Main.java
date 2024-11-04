package ru.pepsxx.hibernate.help.v006_addPerson;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.pepsxx.hibernate.help.pre_start.PreStartUtil;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        PreStartUtil.go();

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Person.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            int random = ThreadLocalRandom.current().nextInt(10, 50);

            // Создаём в JAVA
            Person person = new Person("TestPersonAdd", random);
            System.out.println("-------------------------");

            // Фиксирует в SQL
            session.persist(person);
            System.out.println("-------------------------");

            System.out.println(person);
            List<Item> items = person.getItems();
            items.forEach(System.out::println);
            System.out.println("-------------------------");

            session.getTransaction().commit();
        }

    }
}