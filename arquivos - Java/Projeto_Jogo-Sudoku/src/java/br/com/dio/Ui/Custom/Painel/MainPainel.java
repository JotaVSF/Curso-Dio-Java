package br.com.dio.Ui.Custom.Painel;
import javax.swing.JPanel;
import java.awt.Dimension;

public class MainPainel extends JPanel{
    public MainPainel(final Dimension dimension){
        this.setSize(dimension);
        this.setPreferredSize(dimension);
    }
}
