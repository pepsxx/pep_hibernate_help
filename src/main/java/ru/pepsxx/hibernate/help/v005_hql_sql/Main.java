package ru.pepsxx.hibernate.help.v005_hql_sql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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

        String HQL = """
                from Person
                where id > 1""";
        String SQL = """
                SELECT *
                FROM Person
                WHERE id > 1""";
        Query<Person> HQLQuery = session.createQuery(HQL, Person.class);
        Query<Person> SQLQuery = session.createNativeQuery(SQL, Person.class);

        System.out.println("HQLQuery:");
        HQLQuery.getResultList().forEach(System.out::println);
        System.out.println("SQLQuery:");
        SQLQuery.getResultList().forEach(System.out::println);

        // Закрытие Транзакции
        session.getTransaction().commit();
        // Закрытие сессии
        session.close();

    }
}