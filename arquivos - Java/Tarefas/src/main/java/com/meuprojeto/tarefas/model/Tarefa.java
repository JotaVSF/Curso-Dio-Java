package com.meuprojeto.tarefas.model;

public class Tarefa {
    private int id;
    private String titulo;
    private String descricao;
    private Status status;

    public enum Status {
        PENDENTE, EM_ANDAMENTO, CONCLUIDA
    }

    public Tarefa(int id, String titulo, String descricao, Status status) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
    }

    // Getters e setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; } // <-- Adicione esta linha

    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public Status getStatus() { return status; }

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setStatus(Status status) { this.status = status; }

    @Override
    public String toString() {
        return "[" + id + "] " + titulo + " (" + status + ") - " + descricao;
    }
}