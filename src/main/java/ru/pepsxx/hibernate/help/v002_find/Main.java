package ru.pepsxx.hibernate.help.v002_find;

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
        Person person3 = session.find(Person.class, 1); // Session и EntityManager
        Person person2 = session.get(Person.class, 2);  // Session
        Person person1 = session.load(Person.class, 3); // Session (ленивый)

        // load возвращает proxy объект с Id без загрузки из db сущности
        System.out.println("person1.getId() = " + person1.getId());

        System.out.println("person1 = " + person1); // load ленивый

        // Закрытие Транзакции
        session.getTransaction().commit();
        // Закрытие сессии
        session.close();

        System.out.println("person2 = " + person2);
        System.out.println("person3 = " + person3);

    }
}