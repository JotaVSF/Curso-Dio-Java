//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Aula2_0 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Informe seu nome: ");
        var name = scanner.nextLine();
        System.out.println("Informe sua idade: ");
        var age = scanner.nextInt();
        System.out.println("Voce possui cnh (SIM/NAO)? ");
        var drivesLicence = scanner.next();

        if (age>=18 && drivesLicence.equals("SIM")){ //.equals() serve para verificar se Strings são exatamente iguais.
            System.out.println("\nINFOMRAÇÕES\nNOME: " + name + "\nIDADE: " + age + " anos" + "\nSTATUS CNH: Condutor habilitado");
            System.out.println("\nAVISO:\nVocê é maior de idade e pode dirigir.");
        }else if (age >=18 && drivesLicence.equals("NAO")){
            System.out.println("\nINFOMRAÇÕES\nNOME: " + name + "\nIDADE: " + age + " anos" + "\nSTATUS CNH: Condutor não habilitado");
            System.out.println("\nAVISO:\nVocê é maior mas não possui cnh." );
        }else{
            System.out.println("\nINFOMRAÇÕES\nNOME: " + name + "\nIDADE: " + age + " anos");
            System.out.println("\nAVISO:\nVocê é menor de idade e não pode possuir cnh. ");
        }
    }
}