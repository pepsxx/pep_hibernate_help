package ru.pepsxx.hibernate.help.v018_lock.v002_session;

import jakarta.persistence.*;

@Entity
@Table(name = "table_for_test_lock")
public class TableForTestLock {

    public TableForTestLock(){}

    public TableForTestLock(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Version
    private long version;

    private String name;

    public void setName(String name) {
        this.name = name;
    }
}
