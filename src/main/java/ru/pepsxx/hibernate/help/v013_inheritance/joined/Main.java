package ru.pepsxx.hibernate.help.v013_inheritance.joined;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .addAnnotatedClass(InheritParent.class)
                .addAnnotatedClass(InheritChildOne.class)
                .addAnnotatedClass(InheritChildTwo.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            InheritParent bob = new InheritParent("Bob");
            InheritChildOne childOne = new InheritChildOne("Alex", "child1");
            InheritChildTwo childTwo = new InheritChildTwo("Xandr", "child2");

            session.persist(bob);
            session.persist(childOne);
            session.persist(childTwo);

            session.getTransaction().commit();

        }
    }
}