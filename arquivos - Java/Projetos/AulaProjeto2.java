/* Projeto 2:
Convertendo a temperatura de Celsius
para Fahrenheit, e verificando se as entradas
inseridas pelo usuario são validas.
*/

import java.util.Scanner;

public class AulaProjeto2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira a temperatura em Celsius:");

        // Verifica se a próxima entrada é um número do tipo double
        if (scanner.hasNextDouble()) {
            double celsius = scanner.nextDouble();

            //Convertendo Celsius para Fahrenheit
            if (celsius >= -273.15){
               double Fahrenheit = (celsius*9/5) + 32;
               System.out.printf("Temperatura convertida para Fahrenheit: %.1f\n",Fahrenheit);
            }else{
                System.out.println("Entrada invalida");
            }
        } else {
            System.out.println("Entrada invalida");
        }

        scanner.close();
    }
}
