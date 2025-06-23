import java.util.Scanner;

public class Aula1_1 {
    public static void main(String[] args){
        var scanner = new Scanner(System.in);
        System.out.println("Quantos anos voce tem?");
        var age = scanner.nextInt();
        System.out.println("Você é emancipado? (true/false)");
        var isEmancipated = scanner.nextBoolean();
        var canDrive = age >=18 || isEmancipated && age >=16;  // Sinal de OU em Java -> ||
        System.out.printf("Voce pode dirigir? (%s)", canDrive);
    }
}

// Sinal de Or em Java -> ||
// Or inteligente = ||
// Sinal de AND em Java -> &&
// AND = &&