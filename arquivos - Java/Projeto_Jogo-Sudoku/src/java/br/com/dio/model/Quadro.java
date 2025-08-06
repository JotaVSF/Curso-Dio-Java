package br.com.dio.model;

import java.util.Collection;
import java.util.List;

import static br.com.dio.model.GameStatusEnum.COMPLETE;
import static br.com.dio.model.GameStatusEnum.INCOMPLETE;
import static br.com.dio.model.GameStatusEnum.NON_STARTED;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Quadro {

    private final List<List<Espaco>> espacos;

    public Quadro(final List<List<Espaco>> espacos){
        this.espacos = espacos;
    }

    public List<List<Espaco>> getEspacos(){
        return espacos;
    }

    public GameStatusEnum getStatus(){
        if(espacos.stream().flatMap(Collection::stream).noneMatch(e -> !e.isFixado() && nonNull(e.getAtual()))){
            return NON_STARTED;
        }

        return espacos.stream().flatMap(Collection::stream)
                .anyMatch(e -> isNull(e.getAtual())) ? INCOMPLETE : COMPLETE;
    }

    public boolean temErros(){
        if (getStatus() == NON_STARTED){
            return false;
        }

        return espacos.stream().flatMap(Collection::stream)
                .anyMatch(e -> nonNull(e.getAtual()) && !e.getAtual().equals(e.getEsperado()));
    }

    public boolean alterarValor(final int col, final int row, final int valor){
        var casa = espacos.get(col).get(row);
        if(casa.isFixado()){
            return false;
        }

        casa.setAtual(valor);
        return true;
    }

    public boolean limparValor(final int col, final int row) {
        var casa = espacos.get(col).get(row);
        if (casa.isFixado()) {
            return false;
        }

        casa.clearEspaco();
        return true;
    }

    public void resetar(){
        espacos.forEach(coluna -> coluna.forEach(Espaco::clearEspaco));
    }

    public boolean jogoFinalizado(){
        return !temErros() && getStatus() == COMPLETE;
    }
}
