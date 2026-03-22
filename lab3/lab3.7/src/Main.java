import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        List<Number> numberList = new ArrayList<>();

        Count.addToList(integerList);

        for (int i = 0; i < integerList.size(); i++){
            System.out.print(integerList.get(i) + " ");
        }

        System.out.println();

        Count.addToList(numberList);

        for (int i = 0; i < numberList.size(); i++){
            System.out.print(numberList.get(i) + " ");
        }
    }

}