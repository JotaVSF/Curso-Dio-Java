import java.util.Scanner;

public class Aula1_0 {
    public static void main(String[] args){
        var scanner = new Scanner(System.in);
        System.out.println("Quantos anos voce tem?");
        var age = scanner.nextInt();
        var canDrive = age >=18;
        System.out.printf("Voce pode dirigir? (%s)", canDrive);
    }
}

