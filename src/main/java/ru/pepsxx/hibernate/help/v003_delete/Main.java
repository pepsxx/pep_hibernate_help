package ru.pepsxx.hibernate.help.v003_delete;

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
        Person person2 = session.get(Person.class, 2);

        // Удаление
        // session.delete(person1); // Deprecated
        session.remove(person2);

        // Закрытие Транзакции
        session.getTransaction().commit();
        // Закрытие сессии
        session.close();

    }
}