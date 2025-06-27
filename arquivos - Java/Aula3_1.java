//Este arquvio é um complemento do arquivo AulaUser3_1
//Os dois devem ser apertos juntos na IDE.

import domain.User;

import java.util.HashMap;
import java.util.Map;

public class Aula3_1 {
    public static void main(String[] args) {
        Map<String, User> users = new HashMap<>();
        users.put("joao@joao.com", new User("João", 24));
        users.put("chico@chico.com", new User("Chico", 26));
        users.put("rani@rani.com", new User("Rani", 23));
        users.put("clara@clara.com", new User("Clara", 25));
        users.put("bruno@bruno.com", new User("Bruno", 25));
        //System.out.print(users);

        System.out.println("===========================\n");
        users.keySet().forEach(System.out::println);
        System.out.println("\n===========================\n");
        users.values().forEach(System.out::println);


    }
}
