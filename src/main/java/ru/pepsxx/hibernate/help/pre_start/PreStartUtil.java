package ru.pepsxx.hibernate.help.pre_start;

import liquibase.exception.LiquibaseException;

import java.io.IOException;
import java.sql.SQLException;

public class PreStartUtil {
    private PreStartUtil() {
    }

    static public void go() {
        try {
            DockerComposeUtil.start();
            Thread.sleep(3_000);
            LiquibaseUtil.start();
        } catch (LiquibaseException | SQLException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("****************************************************************************************************");
    }
}
