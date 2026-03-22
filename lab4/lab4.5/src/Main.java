import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(5);
        numbers.add(8);
        System.out.println(Main.multiplyUnpair(numbers));
    }

    public static Optional<Integer> multiplyUnpair(List<Integer> list){
        return list.stream()
                .filter(x -> x%2 != 0)
                .reduce((a,b)->a*b);
    }
}