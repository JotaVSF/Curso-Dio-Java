package br.com.dio.Ui.Custom.button;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class BotaoResetar extends JButton{
    public BotaoResetar(final ActionListener actionListener){
        this.setText("Reiniciar jogo");
        this.addActionListener(actionListener);
    }
}
