package ru.pepsxx.hibernate.help.v020_fetch.v003_batch_size;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
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

            System.out.println("Основной запрос на получение Person-------------------------");
            String HQL = """
                    FROM Person AS p 
                    WHERE p.id IN (:ids)""";
            Query<Person> query = session.createQuery(HQL, Person.class);
            query.setParameter("ids",  List.of(random - 1, random - 2, random - 3, random - 4));
            List<Person> personList = query.getResultList();
            System.out.println("Получение листа У Person c Item-----------------------------");
            List<List<Item>> items = new ArrayList<>();
            for (Person person : personList) {
                items.add(person.getItems());
            }
            System.out.println("Получение Item (элемента листа)-----------------------------");
            for (List<Item> item : items) {
                item.forEach(System.out::println);
            }
            System.out.println("Получение всех полей Person---------------------------------");
            for (Person person : personList) {
                System.out.println("person = " + person);
            }
            System.out.println("5-----------------------------------------------------------");
            session.getTransaction().commit();  // LazyInitializationException
        }

    }
}