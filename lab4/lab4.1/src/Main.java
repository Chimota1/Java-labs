import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("Speed");
        list.add("Xstreme");
        list.add("Height");
        list.add("Xray");
        System.out.print(Main.findWord(list));
    }

    public static Optional<String> findWord(List<String> list) {
        return Optional.of(list.stream()
                .filter(x -> x.startsWith("X"))
                .filter(x -> x.length() > 5)
                .findFirst()
                .orElse("Default"));
    }
}