package com.meuprojeto.tarefas.repository;

import com.meuprojeto.tarefas.DAO.TarefaDao;
import com.meuprojeto.tarefas.model.Tarefa;
import com.meuprojeto.tarefas.model.Tarefa.Status;

import java.util.List;

public class TarefaRepository {
    private TarefaDao tarefaDao = new TarefaDao();

    public Tarefa salvar(String titulo, String descricao) {
        Tarefa tarefa = new Tarefa(0, titulo, descricao, Status.PENDENTE);
        return tarefaDao.salvar(tarefa);
    }

    public List<Tarefa> listar() {
        return tarefaDao.listar();
    }

    public Tarefa buscarPorId(int id) {
        try {
            return tarefaDao.buscarPorId(id);
        } catch (Exception e) {
            return null; // ou você pode propagar a exceção
        }
    }

    public boolean atualizar(int id, String novoTitulo, String novaDescricao, Status novoStatus) {
        Tarefa tarefa = buscarPorId(id);
        if (tarefa != null) {
            tarefa.setTitulo(novoTitulo);
            tarefa.setDescricao(novaDescricao);
            tarefa.setStatus(novoStatus);
            return tarefaDao.atualizar(tarefa);
        }
        return false;
    }

    public boolean remover(int id) {
        return tarefaDao.remover(id);
    }
}