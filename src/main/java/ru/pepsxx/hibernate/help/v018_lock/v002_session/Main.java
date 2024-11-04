package ru.pepsxx.hibernate.help.v018_lock.v002_session;

import jakarta.persistence.LockModeType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.pepsxx.hibernate.help.pre_start.PreStartUtil;

public class Main {
    public static void main(String[] args) {
        PreStartUtil.go();

        Configuration configuration = new Configuration()
                .addAnnotatedClass(TableForTestLock.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            TableForTestLock tableForTestLock = new TableForTestLock("TableForTestLock");
            session.persist(tableForTestLock);
            System.out.println("tableForTestLock = " + tableForTestLock);

            session.lock(tableForTestLock, LockModeType.NONE);
            tableForTestLock.setName("NONE");
            System.out.println("NONE");
            session.flush();
            session.lock(tableForTestLock, LockModeType.OPTIMISTIC);
            tableForTestLock.setName("OPTIMISTIC");
            System.out.println("OPTIMISTIC");
            session.flush();
            session.lock(tableForTestLock, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
            tableForTestLock.setName("OPTIMISTIC_FORCE_INCREMENT");
            System.out.println("OPTIMISTIC_FORCE_INCREMENT");
            session.flush();
            session.lock(tableForTestLock, LockModeType.PESSIMISTIC_READ);
            tableForTestLock.setName("PESSIMISTIC_READ");
            System.out.println("PESSIMISTIC_READ");
            session.flush();
            session.lock(tableForTestLock, LockModeType.PESSIMISTIC_WRITE);
            tableForTestLock.setName("PESSIMISTIC_WRITE");
            System.out.println("PESSIMISTIC_WRITE");
            session.flush();
            session.lock(tableForTestLock, LockModeType.PESSIMISTIC_FORCE_INCREMENT);
            tableForTestLock.setName("PESSIMISTIC_FORCE_INCREMENT");
            System.out.println("PESSIMISTIC_FORCE_INCREMENT");
            session.flush();
            tableForTestLock.setName("FINISH");

            session.getTransaction().commit();
        }

    }
}