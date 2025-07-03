package domain;

import java.util.List; // <-- IMPORTANTE


public record User(String name, int age, Sex sex, List<Contact> contacts) {
}
