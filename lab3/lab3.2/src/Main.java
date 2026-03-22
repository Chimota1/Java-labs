import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        OperationWithList Operation = new OperationWithList();
        List<Integer> Numbers = new ArrayList<>();
        Numbers.add(1);
        Numbers.add(1);
        Numbers.add(5);
        Numbers.add(3);
        Numbers.add(7);
        System.out.println(Operation.Uniqe(Numbers));
        System.out.println(Operation.CountOfObject(Numbers));
    }
}