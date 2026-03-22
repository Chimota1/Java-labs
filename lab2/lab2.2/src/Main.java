import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> workerId = new ArrayList<Integer>();
        workerId.add(20);
        workerId.add(50);
        workerId.add(60);
        workerId.add(60);
        workerId.add(60);
        workerId.add(20);
        System.out.println("");
        for (int i = 0; i < workerId.size(); i++){
            System.out.print(" " + workerId.get(i));
        }

        System.out.println("");

        for (int i = 0; i < workerId.size() - 1; i++){
            for (int j = workerId.size() - 1; j > i; j--){
                if (workerId.get(i) == workerId.get(j)){
                    workerId.remove(j);
                }
            }
        }

        for (int i = 0; i < workerId.size(); i++){
            System.out.print(" " + workerId.get(i));
        }
    }
}