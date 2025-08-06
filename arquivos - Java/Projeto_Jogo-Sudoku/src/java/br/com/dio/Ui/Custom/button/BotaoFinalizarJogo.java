package br.com.dio.Ui.Custom.button;

import javax.swing.JButton;
import java.awt.event.ActionListener;

public class BotaoFinalizarJogo extends JButton{
        public BotaoFinalizarJogo(final ActionListener actionListener){
            this.setText("Concluir");
            this.addActionListener(actionListener);
        }
}
