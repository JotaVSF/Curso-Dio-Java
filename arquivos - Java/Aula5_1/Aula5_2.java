import br.com.dio.dao.UserDAO;
import br.com.dio.model.MenuOption;
import br.com.dio.model.UserModel;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
 
public class Aula5_2 {

    private final static UserDAO dao = new UserDAO();
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        while(true){
            printMenu();
            var userInput = scanner.nextInt();
            var selectedOption = MenuOption.values()[userInput -1];
            switch (selectedOption){
                case SAVE -> {
                    var user = dao.save(requestToSave());
                    System.out.println("Usuario cadastrado com sucesso!!\n");
                }
                case UPDATE ->{
                    var user = dao.save(requestToUpdate());
                    System.out.println("Usuario atualizado com sucesso!!!\n");
                }
                case DELETE -> {
                    dao.delete(requestId());
                    System.out.println("Usuario deletado com sucesso!\n");
                }
                case FIND_BY_ID -> {
                    var id = requestId();
                    var user = dao.findById(id);
                    System.out.printf("Usuario com ID %s: ", id);
                    System.out.println(user);
                }
                case FIND_ALL -> {
                    var users = dao.findAll();
                    System.out.println("Usuario cadastrado:");
                    System.out.println("==================\n");
                    users.forEach(System.out::println);
                    System.out.println("=========fim=========\n");
                }
                case EXIT -> {
                    System.out.println("Encerrando o programa...");
                    scanner.close(); // libera o recurso
                    return;
                }
            }
        }
    }
    private static void printMenu() {
        System.out.println("""
            Bem-vindo ao cadastro de usuários, selecione a operação desejada:

            1 - Cadastrar
            2 - Atualizar
            3 - Excluir
            4 - Buscar por identificador
            5 - Listar
            6 - Sair""");
    }
    private static long requestId() {
        System.out.println("Informe o identificador do usuario:");
        return scanner.nextLong();
    }
    private static UserModel requestToSave(){
        System.out.println("Informe o identificador do usuario:");
        var id = scanner.nextLong();
        scanner.nextLine(); // <- limpa o ENTER deixado pelo nextLong()
        System.out.println("Informe o nome completo do usuario:");
        var name = scanner.nextLine();
        System.out.println("Informe o E-mail do usuario:");
        var email = scanner.next();
        System.out.println("Informe a data de nascimento do usuario (dd/MM/yyyy");
        var birthdayString = scanner.next();
        var formatter = DateTimeFormatter.ofPattern(("dd/MM/yyyy"));
        // Converte para LocalDate primeiro
        var localDate = LocalDate.parse(birthdayString, formatter);
        var birthday = localDate.atStartOfDay().atOffset(ZoneOffset.UTC);
        return new UserModel(id, name, email, birthday);

    }
    private static UserModel requestToUpdate(){
        System.out.println("Informe o identificador do usuario:");
        var id = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Informe o nome completo do usuario:");
        var name = scanner.nextLine();
        System.out.println("Informe o E-mail do usuario:");
        var email = scanner.next();
        System.out.println("Informe a data de nascimento do usuario (dd/MM/yyyy");
        var birthdayString = scanner.next();
        var formatter = DateTimeFormatter.ofPattern(("dd/MM/yyyy"));
        var localDate = LocalDate.parse(birthdayString, formatter);
        var birthday = localDate.atStartOfDay().atOffset(ZoneOffset.UTC);
        return new UserModel(id, name, email, birthday);

    }
}
