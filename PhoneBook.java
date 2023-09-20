import java.util.*;

public class PhoneBook {
    private Map<String, List<String>> contacts;

    public PhoneBook() {
        this.contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        if (!contacts.containsKey(name)) {
            contacts.put(name, new ArrayList<>());
        }
        contacts.get(name).add(phoneNumber);
    }

    public List<String> getPhoneNumbers(String name) {
        return contacts.get(name);
    }

    public void removeContact(String name) {
        contacts.remove(name);
    }

    public void printPhoneBook() {
        for (String name : contacts.keySet()) {
            System.out.println("Имя: " + name);
            System.out.println("Номер телефона: " + contacts.get(name));
            System.out.println("---------------------------");
        }
    }

    public void reverseSortPhoneBook() {
        Map<String, List<String>> reverseSortedMap = new TreeMap<>(Collections.reverseOrder());
        reverseSortedMap.putAll(contacts);
        contacts = reverseSortedMap;
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addContact("Анна", "777444222");
        phoneBook.addContact("Иван", "555111785");
        phoneBook.addContact("Петр", "123456");
        phoneBook.addContact("Дмитрий", "1029384756");

        System.out.println("Телефонная книга:");
        phoneBook.printPhoneBook();

        System.out.println("Обратная сортировка:");
        phoneBook.reverseSortPhoneBook();
        phoneBook.printPhoneBook();
    }
}