package br.com.dio.Ui.Custom.Screen;

import br.com.dio.Service.Servico_no_Quadro;
import br.com.dio.Ui.Custom.Frame.MainMoldura;
import br.com.dio.Ui.Custom.Input.Numero;
import br.com.dio.Ui.Custom.Painel.MainPainel;
import br.com.dio.Ui.Custom.Painel.SudokuSector;
import br.com.dio.Ui.Custom.button.BotaoFinalizarJogo;
import br.com.dio.Ui.Custom.button.BotaoResetar;
import br.com.dio.Ui.Custom.button.botaoChecarStatusJogo;
import br.com.dio.model.Espaco;

import javax.swing.*;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static br.com.dio.model.GameStatusEnum.INCOMPLETE;
import static br.com.dio.model.GameStatusEnum.NON_STARTED;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

public class MainTela {

    private final static Dimension dimension = new Dimension(600, 600);

    private final Servico_no_Quadro Servico_no_Quadro;
    private final NotifierService notifierService;

    private JButton botaoChecarStatusJogo;
    private JButton BotaoFinalizarJogo;
    private JButton BotaoResetar;

    public MainTela(final Map<String, String> gameConfig) {
        this.Servico_no_Quadro = new Servico_no_Quadro(gameConfig);
        this.notifierService = new NotifierService();
    }

    public void buildMainTela(){
        JPanel mainPainel = new MainPainel(dimension);
        JFrame mainMoldura = new MainMoldura(dimension, mainPainel);
        for (int r = 0; r < 9; r+=3) {
            var endRow = r + 2;
            for (int c = 0; c < 9; c+=3) {
                var endCol = c + 2;
                var espacos = getEspacosFromSector(Servico_no_Quadro.getEspacos(), c, endCol, r, endRow);
                JPanel sector = generateSection(espacos);
                mainPainel.add(sector);
            }
        }
        addBotaoResetar(mainPainel);
        addbotaoChecarStatusJogo(mainPainel);
        addBotaoFinalizarJogo(mainPainel);
        mainMoldura.revalidate();
        mainMoldura.repaint();
    }
    

    private List<Espaco> getEspacosFromSector(final List<List<Espaco>> espacos,
                                             final int initCol, final int endCol,
                                             final int initRow, final int endRow){
        List<Espaco> espacoSector = new ArrayList<>();
        for (int r = initRow; r <= endRow; r++) {
            for (int c = initCol; c <= endCol; c++) {
                espacoSector.add(espacos.get(c).get(r));
            }
        }
        return espacoSector;
    }

    private JPanel generateSection(final List<Espaco> espacos){
        List<Numero> fields = new ArrayList<>(espacos.stream().map(Numero::new).toList());
        fields.forEach(t -> notifierService.subscribe(CLEAR_ESPACO, t));
        return new SudokuSector(fields);
    }

    private void addBotaoFinalizarJogo(final JPanel mainPainel) {
        BotaoFinalizarJogo = new BotaoFinalizarJogo(e -> {
            if (Servico_no_Quadro.gameIsFinished()){
                showMessageDialog(null, "Parabéns você concluiu o jogo");
                BotaoResetar.setEnabled(false);
                botaoChecarStatusJogo.setEnabled(false);
                BotaoFinalizarJogo.setEnabled(false);
            } else {
                var message = "Seu jogo tem alguma inconsistência, ajuste e tente novamente";
                showMessageDialog(null, message);
            }
        });
        mainPainel.add(BotaoFinalizarJogo);
    }

    private void addbotaoChecarStatusJogo(final JPanel mainPanel) {
        botaoChecarStatusJogo = new botaoChecarStatusJogo(e -> {
            var hasErros = Servico_no_Quadro.temErros();
            var gameStatus = Servico_no_Quadro.getStatus();
            var message = switch (gameStatus){
                case NON_STARTED -> "O jogo não foi iniciado";
                case INCOMPLETE -> "O jogo está imcompleto";
                case COMPLETE -> "O jogo está completo";
            };
            message += hasErros ? " e contém erros" : " e não contém erros";
            showMessageDialog(null, message);
        });
        mainPainel.add(MainTela.this.botaoChecarStatusJogo);
    }

    private void addBotaoResetar(final JPanel mainPainel) {
        BotaoResetar = new BotaoResetar(e ->{
            var dialogResult = showConfirmDialog(
                    null,
                    "Deseja realmente reiniciar o jogo?",
                    "Limpar o jogo",
                    YES_NO_OPTION,
                    QUESTION_MESSAGE
            );
            if (dialogResult == 0){
                Servico_no_Quadro.reset();
                notifierService.notify(CLEAR_ESPACO);
            }
        });
        mainPainel.add(BotaoResetar);
    }

}

