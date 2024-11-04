package ru.pepsxx.hibernate.help.v003_remove;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.pepsxx.hibernate.help.pre_start.PreStartUtil;

public class Main {
    public static void main(String[] args) {
        PreStartUtil.go();

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
        Person person1 = session.find(Person.class, 1);
        Person person2 = session.find(Person.class, 2);
        Person person3 = session.find(Person.class, 3);

        // Удаление
        session.remove(person1);
        session.remove(person2); // Session и EntityManager
        session.delete(person3); // Session

        // Закрытие Транзакции
        session.getTransaction().commit();
        // Закрытие сессии
        session.close();

    }
}