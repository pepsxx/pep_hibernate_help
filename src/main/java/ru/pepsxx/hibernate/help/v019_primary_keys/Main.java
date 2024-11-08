package ru.pepsxx.hibernate.help.v019_primary_keys;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.pepsxx.hibernate.help.pre_start.PreStartUtil;

public class Main {
    public static void main(String[] args) {
        PreStartUtil.go();

        Configuration configuration = new Configuration()
                .addAnnotatedClass(PrimaryKeysTable.class)
                .addAnnotatedClass(PrimaryKeysIdentity.class)
                .addAnnotatedClass(PrimaryKeysSequence.class);


        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            for (int i = 0; i < 5; i++) {
                session.persist(new PrimaryKeysTable());
                session.persist(new PrimaryKeysIdentity());
                session.persist(new PrimaryKeysSequence());
            }

            session.getTransaction().commit();
            session.close();
        }

    }

}