package br.com.dio.Ui.Custom.Input;

import br.com.dio.Service.EventoEnum;
import br.com.dio.Service.EventoListener;
import br.com.dio.model.Espaco;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Dimension;
import java.awt.Font;

import static br.com.dio.Service.EventoEnum.CLEAR_ESPACO;
import static java.awt.Font.PLAIN;
public class Numero extends JTextField implements EventoListener {
    private final Espaco espaco;
    public Numero(final Espaco espaco){
        this.espaco = espaco;
        var dimension = new Dimension(50,50);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setVisible(true);
        this.setFont(new Font("Arial", PLAIN, 20));
        this.setHorizontalAlignment(CENTER);
        this.setDocument(new NumeroLimitado());
        this.setEnabled(!espaco.isFixado());
        if (espaco.isFixado()){
            this.setText(espaco.getAtual().toString());
        }
        this.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(final DocumentEvent e) {
                changeSpace();
            }

            @Override
            public void removeUpdate(final DocumentEvent e) {
                changeSpace();
            }

            @Override
            public void changedUpdate(final DocumentEvent e) {
                changeSpace();
            }

            private void changeSpace(){
                if (getText().isEmpty()){
                    espaco.clearEspaco();
                    return;
                }
                espaco.setAtual(Integer.parseInt(getText()));
            }

        });
    }

    @Override
    public void update(final EventoEnum eventType) {
        if (eventType.equals(CLEAR_ESPACO) && (this.isEnabled())){
            this.setText("");
        }
    }
}


