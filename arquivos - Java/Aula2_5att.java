import java.util.Scanner;

public class Aula2_5att {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Insira um numero: ");
        var number = scanner.nextInt();
        while (true) {
            System.out.println("\nInforme o numero para verificação: ");
            var toVerify = scanner.nextInt();
            if (toVerify < number) {
                System.out.printf("Informe o numero maior que %s ", number);
                continue;
            }
            var result = toVerify % number;
            System.out.printf("%s %% %s = %s", toVerify, number, result);
            if (result != 0) break;
        }

    }

}
