/* Ativida que ensina a criar objetos e sets. Nesse caso estou adicionando novos usuarios,
e utilizando HashSet (estrutura de dados) para armazen-los.
Utilizo tambem o hashCode para gerar um codigo unico (como se fosse uma credencial) para cada novo usario.
E por fim o metodo equals para verificar se existem objetos repetidos já dentro da nossa estrutura,
isso evita duplicidade.
Em uma situação real. Essa atividade pode me ajudar a desenvolver um sistema bem mais robusto para
cadastro de usuario em um sistema por exemplo; Ou para pertir que o cliente compre apenas um unico produto por cpf
(isso acontece muito no site da nike); Para marcar quais alunos já entregaram a atividade; Ou por fim para registrar
IPs únicos que acessaram um site.
Enfim. trata-se de uma atividade simples que bem estruturada pode servir na criação de importantes sistemas.
 */
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class Aula6_0 {
    public static void main(String[] args){
        /* HashSet é uma estrutura de dados que pertence ao pacote
        Util, e representa um conjunto.*/
        Scanner scanner = new Scanner(System.in);
        Set<User> users = new HashSet<>();
        int id = 1;
        System.out.println("Digite seu nome para cadastro VIP: ");
        String nomeUsuario = scanner.nextLine();
        System.out.println("Nome cadastrado com sucesso!!!");

        users.add(new User( id++, nomeUsuario));
        users.add(new User( id++, "Maria Eduarda de Souza"));
        users.add(new User( id++, "Ana Clara dos Santos"));
        users.add(new User( id++, "Taina F. Oliveira"));
        users.add(new User( id++, "Roberto dos Santos"));
        users.add(new User( id++, "Francisco Wander"));
        users.add(new User( id++, "Mateus Paiva"));
        users.add(new User( id++, "David Lobo"));

        System.out.println("\n--- Lista de usuários cadastrados ---");
        for (User u : users) { //User é o objeto onde os nomes estao sendo armazenados
            System.out.println("ID: " + u.getId() + " | Nome: " + u.getName());
        }

        System.out.println("\nDigite o nome completo do convidado para consultar a credencial:");
        String nomeConsulta = scanner.nextLine();

        boolean encontrado = false;
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(nomeConsulta)){
                System.out.println("\nContém " + nomeConsulta + "? " + users.contains(user));
                System.out.println("HashCode (credencial) de " + nomeConsulta + ": " + user.hashCode());
                encontrado = true;
                break;
            }
        }

        if (!encontrado){
            int newId = 0;
            User consulta = new User(newId, nomeConsulta);

            System.out.println("\nContém " + nomeConsulta + "? " + users.contains(consulta));
            System.out.println("HashCode (credencial) de " + nomeConsulta + ": " + newId);
            System.out.println("→ Esse nome ainda **não está** cadastrado na lista VIP.");
        }
    }
}
