import java.util.Scanner;

public class Aula1_2att {
    public static void main(String[] args){
       var scanner = new Scanner(System.in);
       System.out.println("Qual o seu nome?");
       var name = scanner.nextLine();
       System.out.println("Qual o sua idade?");
       var age = scanner.nextInt();
       System.out.printf("Nome: " + name + "\nIdade: " + age + " anos");
    }
}
