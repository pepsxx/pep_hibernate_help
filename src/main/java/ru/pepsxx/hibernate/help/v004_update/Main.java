package ru.pepsxx.hibernate.help.v004_update;

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

        // Получили из базы
        Person person1 = session.get(Person.class, 1);
        Person person3 = session.get(Person.class, 3);

        person1.setName("NewName");
        person3.setAge(11);

        // Закрытие Транзакции
        session.getTransaction().commit();
        // Закрытие сессии
        session.close();

        System.out.println("В db данные обновились по окончанию транзакции");
        System.out.println("person1 = " + person1);
        System.out.println("person3 = " + person3);

    }
}