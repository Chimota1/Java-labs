import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();
        Person person5 = new Person();
        List<Person> friends = new ArrayList<Person>();
        friends.add(person2);
        friends.add(person3);
        friends.add(person4);
        friends.add(person5);
        person1.setName("Andriy");
        person2.setName("Maksym");
        person3.setName("Misha");
        person4.setName("Igor");
        person5.setName("Igor");
        person1.setFriends(friends);
        System.out.println(Person.uniqeName(friends));
    }
}