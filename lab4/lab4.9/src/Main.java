import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Optional<String>> products = Map.of(
                1, Optional.of("молоко"),
                2, Optional.empty(),
                3, Optional.of("кефір"),
                4, Optional.of("цукор")
        );
        Stream<Optional<String>> stream = products.values().stream();
        System.out.println(Main.nameInUpperCase(stream));
    }
    public static List<String> nameInUpperCase(Stream<Optional<String>> stream){
        return stream.filter(x -> x.isPresent())
                .map(x-> x.get().toUpperCase())
                .collect(Collectors.toList());
    }
}