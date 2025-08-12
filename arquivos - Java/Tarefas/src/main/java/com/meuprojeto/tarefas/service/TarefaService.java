package com.meuprojeto.tarefas.service;

import java.util.List;
import com.meuprojeto.tarefas.model.Tarefa;
import com.meuprojeto.tarefas.repository.TarefaRepository;

public class TarefaService {
    private TarefaRepository repository = new TarefaRepository();

    public Tarefa criarTarefa(String titulo, String descricao) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Título não pode ser vazio");
        }
        return repository.salvar(titulo, descricao);
    }

    public List<Tarefa> listarTarefas() {
        return repository.listar();
    }

    public boolean atualizarTarefa(int id, String titulo, String descricao, Tarefa.Status status) {
        return repository.atualizar(id, titulo, descricao, status);
    }

    public boolean excluirTarefa(int id) {
        return repository.remover(id);
    }
}

