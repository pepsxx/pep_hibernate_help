package ru.pepsxx.hibernate.help.v000_jpa_vs_hibernate;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.pepsxx.hibernate.help.v001_persist.Person;

public class Main {

    public static void main(String[] args) {


        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class);

        Person personForSesion = new Person();
        personForSesion.setName("TestPersonForSesion");
        personForSesion.setAge(22);

        Person personForManager = new Person();
        personForManager.setName("TestPersonForManager");
        personForManager.setAge(33);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {

            // Hibernate
            Session session = sessionFactory.openSession();
            session.getTransaction().begin();

            session.save(personForSesion);    // Добавляет сущности в контекст
            session.flush();                  // Принудительно записывает все изменения в базу данных
            session.refresh(personForSesion); // Обновляет состояние сущности из базы данных
            session.evict(personForSesion);   // Удаляет сущность из контекста
            session.update(personForSesion);  // Заново присоединяет сущность к контексту
            personForSesion = session.get(Person.class, personForSesion.getId()); // Загружает сущность базы данных
            session.delete(personForSesion);  // Удаляет сущность из базы данных

            session.getTransaction().commit();
            session.close();
            System.out.println("--------------------------------------------------");

            // JPA
            EntityManager entityManager = sessionFactory.createEntityManager();
            entityManager.getTransaction().begin();

            entityManager.persist(personForManager); // Добавляет сущности в контекст
            entityManager.flush();                   // Принудительно записывает все изменения в базу данных
            entityManager.refresh(personForManager); // Обновляет состояние сущности из базы данных
            entityManager.detach(personForManager);  // Удаляет сущность из контекста
            entityManager.merge(personForManager);   // Заново присоединяет сущность к контексту
            personForManager = entityManager.find(Person.class, personForManager.getId()); // Загружает сущность базы данных
            entityManager.remove(personForManager);  // Удаляет сущность из базы данных

            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("--------------------------------------------------");
        }
    }
}