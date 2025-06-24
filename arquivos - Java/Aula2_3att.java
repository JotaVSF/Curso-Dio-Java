import java.util.Scanner;

public class Aula2_3att {
    public static void main(String[] args){
        var scanner = new Scanner(System.in);
        System.out.println("Escolha a tabuada que deseja utilizar: ");
        var numTabuada = scanner.nextInt();
        System.out.println("\nTABUADA do " + numTabuada + ":");
        for (var i = 0; i<=10; i++){
            System.out.println(numTabuada + " X " + i +" = " + (numTabuada*i));
        }
    }
}
