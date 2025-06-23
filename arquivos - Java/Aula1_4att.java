import java.util.Scanner;

public class Aula1_4att {
    public static void main(String[] args){
        var scanner = new Scanner(System.in);
        System.out.println("Insira o primeiro nome: ");
        var name1 = scanner.nextLine();
        System.out.println("Insira a primeira idade: ");
        var age1 = scanner.nextInt();

        scanner.nextLine();  // <-- limpa o \n que ficou no buffer

        System.out.println("Insira o segundo nome: ");
        var newName = scanner.nextLine();
        System.out.println("Insira a segunda idade: ");
        var newAge = scanner.nextInt();

        int diferenca;
        if (age1 > newAge){
            diferenca = age1 - newAge;
        } else {
            diferenca = newAge - age1;
        }

        System.out.println("\nINFORMAÇÕES:\nUsuario 1: NOME: " + name1 + "\nIDADE: " + age1 + " anos");
        System.out.println("\nUsuario 2: NOME: " + newName + "\nIDADE: " + newAge + " anos");


        System.out.println("\nA diferença de idade entre o " + name1 + " e " + newName + " é de " + diferenca + " ano.");
    }
}
