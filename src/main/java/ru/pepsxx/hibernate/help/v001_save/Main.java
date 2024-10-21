package ru.pepsxx.hibernate.help.v001_save;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        System.out.println("""
                1:  Для работы hibernate нужна зависимость
                    hibernate-core
                2:  Для настройки H нужно создать файл
                    hibernate.properties
                3:  Для работы с PostgreSQL через JDBC Driver нужна зависимость
                    postgresql""");

        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Получение сессии
        Session session = sessionFactory.getCurrentSession();
        // Открытие Транзакции
        session.beginTransaction();

        Person person1 = new Person("Alex", 41);
        Person person2 = new Person("Jony", 31);
        Person person3 = new Person("Boby", 21);

        // Сохранение в базу
        // session.save(person1); // Deprecated
        session.persist(person2);
        session.persist(person3);

        // Закрытие Транзакции
        session.getTransaction().commit();
        // Закрытие сессии
        session.close();

    }
}