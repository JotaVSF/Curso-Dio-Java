package com.meuprojeto.tarefas.view;
import com.meuprojeto.tarefas.DataBaseMigration;

public class App {
    public static void main(String[] args) {
        // Primeiro, rodamos a migração do banco de dados
        System.out.println("Rodando migrations...");
        DataBaseMigration.migrate();
        System.out.println("Migrations concluídas!");

        // Em seguida, iniciamos a interface do console
        ConsoleView view = new ConsoleView();
        view.iniciar();
    }
}
