package ru.pepsxx.hibernate.help.v015_one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .addAnnotatedClass(People.class)
                .addAnnotatedClass(Address.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            People alex = new People("Alex");
            People xandr = new People("Xandr");
            session.persist(alex);
            session.persist(xandr);

            Address trueStreet = new Address("TrueStreet", alex);
            Address falseStreet = new Address("FalseStreet", xandr);
            session.persist(trueStreet);
            session.persist(falseStreet);

            session.getTransaction().commit();
        }

    }
}