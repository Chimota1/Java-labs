import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        Pair<Integer,String> firstPair = new Pair<Integer,String>(5,"Hello");
        Pair<String,List<Integer>> secondPair = new Pair<String,List<Integer>>("Hi",list);
        Pair<Integer,String> thirdPair = new Pair<Integer,String>(5,"Hello");
        Pair<String,List<Integer>> fourthPair = new Pair<String,List<Integer>>("Hi",Arrays.asList(1,2,3,4,5));
        System.out.println(firstPair.ComparePairs(thirdPair));
        System.out.println(secondPair.ComparePairs(fourthPair));
    }
}