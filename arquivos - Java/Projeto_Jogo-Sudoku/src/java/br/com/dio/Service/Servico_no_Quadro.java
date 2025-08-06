package br.com.dio.Service;
import br.com.dio.model.Quadro;
import br.com.dio.model.GameStatusEnum;
import br.com.dio.model.Espaco;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Servico_no_Quadro {
    private final static int BOARD_LIMIT = 9;

    private final Quadro quadro;

    public Servico_no_Quadro(final Map<String, String> gameConfig) {
        this.quadro = new Quadro(initBoard(gameConfig));
    }

    public List<List<Espaco>> getEspacos(){
        return quadro.getEspacos();
    }

    public void reset(){
        quadro.reset();
    }

    public boolean temErros(){
        return quadro.temErros();
    }

    public GameStatusEnum getStatus(){
        return quadro.getStatus();
    }

    public boolean gameIsFinished(){
        return quadro.gameIsFinished();
    }

    private List<List<Espaco>> initBoard(final Map<String, String> gameConfig) {
        List<List<Espaco>> espacos = new ArrayList<>();
        for (int i = 0; i < BOARD_LIMIT; i++) {
            espacos.add(new ArrayList<>());
            for (int j = 0; j < BOARD_LIMIT; j++) {
                var positionConfig = gameConfig.get("%s,%s".formatted(i, j));
                var expected = Integer.parseInt(positionConfig.split(",")[0]);
                var fixed = Boolean.parseBoolean(positionConfig.split(",")[1]);
                var currentEspaco = new Espaco(expected, fixed);
                espacos.get(i).add(currentEspaco);
            }
        }

        return espacos;
    }
}
