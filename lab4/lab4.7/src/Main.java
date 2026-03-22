import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class Main {
    public static void main() {
        Transanction transanction1 = new Transanction();
        transanction1.setSum(1200);
        transanction1.setCategory("Продукти");
        Transanction transanction2 = new Transanction();
        transanction2.setSum(5000);
        transanction2.setCategory("Розваги");
        Transanction transanction3 = new Transanction();
        transanction3.setSum(2000);
        transanction3.setCategory("Аптека");
        Transanction transanction4 = new Transanction();
        transanction4.setSum(3000);
        transanction4.setCategory("Інвестиції");
        Transanction transanction5 = new Transanction();
        transanction5.setSum(4000);
        transanction5.setCategory("На банку");
        List<Transanction> transanctionList = new ArrayList<Transanction>();
        transanctionList.add(transanction1);
        transanctionList.add(transanction2);
        transanctionList.add(transanction3);
        transanctionList.add(transanction4);
        transanctionList.add(transanction5);
        Map<String, Integer> result =
                transanctionList.stream()
                        .filter(x -> x.getCategory().equals("Продукти"))
                        .collect(Collectors.groupingBy(
                                x -> x.getCategory(),
                                Collectors.summingInt(x -> x.getSum())
                        ));
        System.out.println(result);
    }
}