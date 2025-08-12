package com.meuprojeto.tarefas.view;

import java.util.Scanner;
import com.meuprojeto.tarefas.model.Tarefa;
import com.meuprojeto.tarefas.service.TarefaService;

public class ConsoleView {
    private TarefaService service = new TarefaService();
    private Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        while (true) {
            System.out.println("\n=== Board de Tarefas ===");
            System.out.println("1. Criar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Atualizar Tarefa");
            System.out.println("4. Excluir Tarefa");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> criar();
                case 2 -> listar();
                case 3 -> atualizar();
                case 4 -> excluir();
                case 0 -> {
                    System.out.println("Saindo...");
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void criar() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        service.criarTarefa(titulo, descricao);
        System.out.println("Tarefa criada com sucesso!");
    }

    private void listar() {
        for (Tarefa t : service.listarTarefas()) {
            System.out.println(t);
        }
    }

    private void atualizar() {
        System.out.print("ID da tarefa: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Novo título: ");
        String titulo = scanner.nextLine();
        System.out.print("Nova descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Novo status (PENDENTE, EM_ANDAMENTO, CONCLUIDA): ");
        Tarefa.Status status = Tarefa.Status.valueOf(scanner.nextLine().toUpperCase());

        if (service.atualizarTarefa(id, titulo, descricao, status)) {
            System.out.println("Tarefa atualizada!");
        } else {
            System.out.println("Tarefa não encontrada!");
        }
    }

    private void excluir() {
        System.out.print("ID da tarefa: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (service.excluirTarefa(id)) {
            System.out.println("Tarefa removida!");
        } else {
            System.out.println("Tarefa não encontrada!");
        }
    }
}
