package com.meuprojeto.tarefas.DAO;

import com.meuprojeto.tarefas.model.Tarefa;
import com.meuprojeto.tarefas.exception.TarefaNotFoundException;
import com.meuprojeto.tarefas.model.Tarefa.Status;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TarefaDao {
    private Connection getConnection() throws SQLException {
        // Usa as mesmas configurações do Flyway
        return DriverManager.getConnection("jdbc:h2:file:./data/boarddb", "sa", "");
    }

    public Tarefa salvar(Tarefa tarefa) {
        String sql = "INSERT INTO tarefas (titulo, descricao, status) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, tarefa.getTitulo());
            pstmt.setString(2, tarefa.getDescricao());
            pstmt.setString(3, tarefa.getStatus().name());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    tarefa.setId(rs.getInt(1));
                }
            }
            return tarefa;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar a tarefa: " + e.getMessage());
        }
    }

    public List<Tarefa> listar() {
        String sql = "SELECT * FROM tarefas";
        List<Tarefa> tarefas = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Tarefa tarefa = new Tarefa(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("descricao"),
                        Status.valueOf(rs.getString("status"))
                );
                tarefas.add(tarefa);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar tarefas: " + e.getMessage());
        }
        return tarefas;
    }

    public Tarefa buscarPorId(int id) {
        String sql = "SELECT * FROM tarefas WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Tarefa(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("descricao"),
                            Status.valueOf(rs.getString("status"))
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar tarefa: " + e.getMessage());
        }
        throw new TarefaNotFoundException("Tarefa com ID " + id + " não encontrada.");
    }

    public boolean atualizar(Tarefa tarefa) {
        String sql = "UPDATE tarefas SET titulo = ?, descricao = ?, status = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tarefa.getTitulo());
            pstmt.setString(2, tarefa.getDescricao());
            pstmt.setString(3, tarefa.getStatus().name());
            pstmt.setInt(4, tarefa.getId());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar tarefa: " + e.getMessage());
        }
    }

    public boolean remover(int id) {
        String sql = "DELETE FROM tarefas WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover tarefa: " + e.getMessage());
        }
    }
}
