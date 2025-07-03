/* Atividade responsavel por ensinar um pouco sobre API STREAMS*/
import domain.Contact;
import domain.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static domain.ContactType.EMAIL;
import static domain.ContactType.PHONE;
import static domain.Sex.FEMALE;
import static domain.Sex.MALE;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>(generateUsers());

        var values = users.stream()
                .flatMap(u -> u.contacts().stream())
                .filter(c -> c.type() == EMAIL)
                /*.filter(u -> u.contacts().size() >= 2 )*/
                .sorted(Comparator .comparing(Contact::description))
                .toList();

        values.forEach(System.out::println);

    }

    private static List<User> generateUsers(){
        var contacts1 = List.of(
                new Contact("(71)97742-6809", PHONE),
                new Contact("joaovdesouzaf@gmail.com", EMAIL)
        );
        var contacts2 = List.of(
                new Contact("(11)95587-0695", PHONE)
        );
        var contacts3 = List.of(
                new Contact("Madu.s@hotmail.com", EMAIL),
                new Contact("Maria.Duda@hotmail.com", EMAIL)
        );
        var contacts4 = List.of(
                new Contact("(11)99774-4555", PHONE),
                new Contact("Chicofran@gmail.com", EMAIL)
        );
        var contacts5 = List.of(
                new Contact("(13)99595-0038", PHONE),
                new Contact("(17)97766-3321", PHONE)
        );

        var user1 = new User("Joao Vitor", 24, MALE, new ArrayList<>(contacts1));
        var user2 = new User("Ana Clara", 25, FEMALE, new ArrayList<>(contacts2));
        var user3 = new User("Maria Eduarda", 16, FEMALE, new ArrayList<>(contacts3));
        var user4 = new User("Francisco", 27, MALE, new ArrayList<>(contacts4));
        var user5 = new User("Taina Ferreira", 25, FEMALE, new ArrayList<>(contacts5));

        return List.of(user1, user2, user3, user4, user5);
    }
}