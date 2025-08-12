package com.meuprojeto.tarefas;

import org.flywaydb.core.Flyway;

public class DataBaseMigration {
    public static void migrate() {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:file:./data/boarddb", "sa", "")
                .load();
        flyway.migrate();
    }
}
