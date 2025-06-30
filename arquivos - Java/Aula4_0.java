/*Atvidade para uso do BigDecimal e do RoundingMode, que sao metodos feitos para arredondamento de numeros flutuantes.
Quando se vai fazer um calculo utilizando numeros flutuantes, geralmente recebemos do java uma resposta
com diversos numeros após ponto. Quando se usa o BigDecimal e o RoundingMode esse retorno se torna mais exato.

USE O BIGDECIMAL E O ROUNDINGMODE QUANDO:

Você trabalha com valores financeiros (dinheiro, impostos, etc.).
Precisa de alta precisão matemática.
Não pode correr risco de erros de arredondamento.
 */

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Aula4_0 {
    public static void main(String[] args){
        BigDecimal leite = new BigDecimal("4.75");
        BigDecimal arroz = new BigDecimal("22.40");
        BigDecimal chocolate = new BigDecimal("6.35");

        BigDecimal total = leite.add(arroz).add(chocolate);
        System.out.println("Total sem desconto: R$" + total);

        BigDecimal desconto = total.multiply(new BigDecimal("0.10"));
        BigDecimal totalComDesconto = total.subtract(desconto);
        totalComDesconto = totalComDesconto.setScale(2, RoundingMode.HALF_UP); // Arredondamento

        System.out.println("Total com 10% de desconto: R$" + totalComDesconto);
    }
}
