import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Emplyoee emplyoee1 = new Emplyoee();
        Emplyoee emplyoee2 = new Emplyoee();
        Emplyoee emplyoee3 = new Emplyoee();
        Emplyoee emplyoee4 = new Emplyoee();
        emplyoee1.setName("Іван");
        emplyoee1.setSalary(2000);
        emplyoee2.setName("Олег");
        emplyoee2.setSalary(3000);
        emplyoee3.setName("Валера");
        emplyoee3.setSalary(4000);
        emplyoee4.setName("Микола");
        emplyoee4.setSalary(6000);
        List<Emplyoee> emplyoees = new ArrayList<Emplyoee>();
        emplyoees.add(emplyoee1);
        emplyoees.add(emplyoee2);
        emplyoees.add(emplyoee3);
        emplyoees.add(emplyoee4);
        Main.Group(emplyoees);
    }

    public static void Group(List<Emplyoee> e) {
        Map<String, Optional<Emplyoee>> result = e.stream()
                .collect(Collectors.groupingBy(
                        p -> {
                            if (p.getSalary() < 3000) {
                                return "< 3000";
                            } else if (p.getSalary() >= 3000 && p.getSalary() < 5000) {
                                return "3000 - 5000";
                            } else {
                                return "> 5000";
                            }
                        },
                        Collectors.maxBy((p1, p2) -> Integer.compare(p1.getSalary(), p2.getSalary()))
                ));

        result.forEach((group, employee) ->
                System.out.println(group + " → " + employee.map(Emplyoee::getName).orElse("немає"))
        );
    }
}