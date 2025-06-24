import java.util.Scanner;

public class Aula2_4att {
    public static void main(String[] args){
        var scanner = new Scanner(System.in);

        //OBS: IDE está com a configuração regional, com isso o codigo aceita virgula ',' no numero decimal.
        System.out.println("Insira sua altura: ");
        var altura = scanner.nextDouble();

        System.out.println("Insira seu peso: ");
        var peso = scanner.nextDouble();

        var imc = peso/(altura*altura);
        //printf não recebe o sinal '+' como concatenação.
        //É preciso usar virgula ','
        System.out.printf("Seu indice de massa corporal é: %.2f\n ", imc);

        if (imc <=18) {
            System.out.println("Abaixo do peso");
        }else if (imc > 18 && imc < 25){
            System.out.println("- " + "Peso ideal");
        }else if (imc > 25 && imc < 30){
            System.out.println("- " + "Levemente acima do peso");
        }else if (imc > 30 && imc < 35){
            System.out.println("- " + "Obesidade grau I");
        }else if(imc > 35 && imc < 40){
            System.out.println("- " + "Obesidade grau II");
        }else{
            System.out.println("- " + "Obesidade grau III (Mórbida)");
        }
    }
}
