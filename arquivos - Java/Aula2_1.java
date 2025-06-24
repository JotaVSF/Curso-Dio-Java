import java.util.Scanner;
public class Aula2_1 {
    public static void main(String[] args){
        var scanner = new Scanner(System.in); //Scanner.in = input e serve para interação do usuario.
        System.out.println("Informe um numero de 1 a 7");
        var option = scanner.nextInt();
        switch (option){//switch serve como uma especie de condicional para dar opções ao usuario.
            case 1, 7 -> System.out.println("Fim de semana");
            case 2 -> System.out.println("Segunda-feira");
            case 3 -> System.out.println("Terça-feira");
            case 4 -> System.out.println("Quarta-feira");
            case 5 -> System.out.println("Quinta-feira");
            case 6 -> System.out.println("Sexta-feira");
            default -> System.out.println("Opção invalida!!!"); //default serve para acussar um erro.

        }
    }
}
