import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private List<Person> friends = new ArrayList<Person>();

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setFriends(List<Person> friends){
        this.friends = friends;
    }

    public List<Person> getFriends(){
        return friends;
    }

    public static List<String> uniqeName(List<Person> friends){
        return friends.stream()
                .map(f -> f.getName().toUpperCase())
                .distinct()
                .collect(Collectors.toList());
    }
}
