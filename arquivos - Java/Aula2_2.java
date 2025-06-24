import java.util.Scanner;
import java.util.ArrayList; //importando a estrutura de dados (lista)

public class Aula2_2 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);//Scanner.in = input e serve para interação do usuario.
        var list_names = new ArrayList<String>(); //Criando uma lista para armazenar os nomes adcionados
        for (; ; ) {// Gera um loop infinito, como se fosse um while True.
            System.out.println("Insira o seu nome: ");
            var name = scanner.nextLine();// nextLine aceita varios tipos de String.

            if (name.equalsIgnoreCase("exit"))
                break; // equalsIgnoreCase serve para pegar tanto texto normal quanto caixa alta.
            list_names.add(name); //Metodo usdado para adcionar os nomes a nossa lista.
        }
        System.out.println("\nNOMES REGISTRADOS: ");

        /*Usando o FOR para percorrer e imprimir nome por nome.
          E contar e adcionar numeros junto a esses nomes
         */
        for (var i = 0; i < list_names.size(); i++) {
            System.out.println((i + 1) + " - " + list_names.get(i));

            try {
                Thread.sleep(700); // Thread.sleep() serve para uma pausa na iteração das expressoes
            } catch (InterruptedException e) {
                System.out.println("Erro na pausa.");
            }
        }

            try {
                Thread.sleep(1000); // pausa de 1 segundo até aparecer a mensagem de encerramento.
            } catch (InterruptedException e) {
                System.out.println("Erro na pausa.");
            }
        System.out.println("\nEncerrando o programa...");
        }
}

