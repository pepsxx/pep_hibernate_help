package ru.pepsxx.hibernate.help.v018_lock.v001_entityManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .addAnnotatedClass(TableForTestLock.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {

            EntityManager entityManager = sessionFactory.createEntityManager();
            entityManager.getTransaction().begin();

            TableForTestLock tableForTestLock = new TableForTestLock("TableForTestLock");
            entityManager.persist(tableForTestLock);
            System.out.println("tableForTestLock = " + tableForTestLock);

            entityManager.lock(tableForTestLock, LockModeType.NONE);
            tableForTestLock.setName("NONE");
            System.out.println("NONE");
            entityManager.flush();
            entityManager.lock(tableForTestLock, LockModeType.OPTIMISTIC);
            tableForTestLock.setName("OPTIMISTIC");
            System.out.println("OPTIMISTIC");
            entityManager.flush();
            entityManager.lock(tableForTestLock, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
            tableForTestLock.setName("OPTIMISTIC_FORCE_INCREMENT");
            System.out.println("OPTIMISTIC_FORCE_INCREMENT");
            entityManager.flush();
            entityManager.lock(tableForTestLock, LockModeType.PESSIMISTIC_READ);
            tableForTestLock.setName("PESSIMISTIC_READ");
            System.out.println("PESSIMISTIC_READ");
            entityManager.flush();
            entityManager.lock(tableForTestLock, LockModeType.PESSIMISTIC_WRITE);
            tableForTestLock.setName("PESSIMISTIC_WRITE");
            System.out.println("PESSIMISTIC_WRITE");
            entityManager.flush();
            entityManager.lock(tableForTestLock, LockModeType.PESSIMISTIC_FORCE_INCREMENT);
            tableForTestLock.setName("PESSIMISTIC_FORCE_INCREMENT");
            System.out.println("PESSIMISTIC_FORCE_INCREMENT");
            entityManager.flush();
            tableForTestLock.setName("FINISH");

            entityManager.getTransaction().commit();
        }

    }
}