import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Optional<Integer>> list = new ArrayList<Optional<Integer>>();
        list.add(Optional.of(2));
        list.add(Optional.empty());
        list.add(Optional.of(3));
        System.out.println(list.stream()
                .filter(x -> x.isPresent())
                .map(x -> x.get())
                .collect(Collectors.toList()));
    }
}
