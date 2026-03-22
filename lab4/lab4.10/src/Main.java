import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Map<String, List<Integer>> city = Map.of(
          "Житомир", List.of(-4,7,15,23),
          "Київ", List.of(-5,5,13,20),
          "Одеса", List.of(-1,9,18,29),
          "Львів", List.of(-5,6,15,21)
        );
        System.out.println(Main.cityWithHighestTemperature(city));
    }
    public static Optional<String> cityWithHighestTemperature(Map<String, List<Integer>> map){
        return map.entrySet().stream()
                .max((x, y) -> Double.compare(
                        x.getValue().stream().mapToInt(i -> i).average().orElse(0),
                        y.getValue().stream().mapToInt(i -> i).average().orElse(0)
                ))
                .map(entry -> entry.getKey());
    }
}