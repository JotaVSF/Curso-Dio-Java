package br.com.dio.Ui.Custom.button;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class botaoChecarStatusJogo extends JButton {
    public botaoChecarStatusJogo(final ActionListener actionListener){
        this.setText("Verificar jogo");
        this.addActionListener(actionListener);
    }
}
