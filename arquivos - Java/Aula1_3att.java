import java.util.Scanner;

public class Aula1_3att {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Insira o tamanho do lado de um quadrado:");
        var quadrado = scanner.nextInt();
        System.out.println("A area do quadrado mede " + (quadrado*quadrado) + " metros");
    }
}
