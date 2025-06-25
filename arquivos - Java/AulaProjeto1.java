/* Projeto 1:
Verificar se o email inserido pelo usuario
esta sendo cadastrado com o email correto
da emprersa.
*/

import java.util.Scanner;

public class AulaProjeto1 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        String expectedDomain = "@company.com";

        while(true) {
            System.out.println("\nCadastre um email adminitrativo valido.\nEX:'...@company.com':\n");
            String email = scanner.nextLine().trim();

            if (email.endsWith(expectedDomain)) { //.endWith = 'termina com'.
                // Está verificando se o email inserido termina com o dominio correto.
                System.out.println(email + " -> Valido\n\nEmail cadastrado com sucesso.");
                break;
            } else {
                System.out.println(email + " -> Invalido\n\nEmail não cadastrado.");
            }
        }
        scanner.close();
    }
}