package ru.pepsxx.hibernate.help.pre_start;

import java.io.IOException;

public class DockerComposeUtil {
    private DockerComposeUtil() {

    }

    static public void start() throws IOException, InterruptedException {
        System.out.println("""
                ****************************************************************************************************
                docker_compose

                Настройки в compose.yml:
                name: pep_XXXXX_help-4XX54                  # Имя compose stack
                services:
                    my_name:                                # Имя ?
                        container_name: PostgresSQL-4XX54   # Имя container в stack
                        image: postgres                     # Название образа на котором основан контейнер
                        ports:
                            - "4XX54:5432"                  # forwarding port
                        environment:
                            POSTGRES_USER: admin            # Имя администратора db
                            POSTGRES_PASSWORD: qQ111111     # Пароль администратора db
                            POSTGRES_DB: pep_db             # Имя db
                ****************************************************************************************************""");
        new ProcessBuilder("docker-compose", "-f", "compose.yml", "up", "-d")
                .start()
                .waitFor();
        System.out.println("Docker-compose - Запущен");
    }
}
