import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        names.add("Олександр");
        names.add("Олексій");
        names.add("Андрій");
        names.add("Владислав");
        System.out.println(Main.longestName(names));
    }

    public static Optional<String> longestName (List<String> list){
        return list.stream().max((x,y) -> Integer.compare(x.length(),y.length()));
    }
}