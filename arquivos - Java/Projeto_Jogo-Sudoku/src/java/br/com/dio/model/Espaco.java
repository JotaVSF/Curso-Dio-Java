package br.com.dio.model;

public class Espaco {

    private Integer atual;
    private final int expected;
    private final boolean fixado;

    public Espaco(final int expected, final boolean fixado) {
        this.expected = expected;
        this.fixado = fixado;
        if (fixado){
            atual = expected;
        }
    }

    public Integer getAtual() {

        return atual;
    }
    public void setAtual(Integer actual) {
        if(fixado) return;
        this.atual = actual;
    }
    public void clearEspaco(){
        setAtual(null);
    }
    public int getEsperado() {

        return expected;
    }
    public boolean isFixado() {

        return fixado;
    }
}
