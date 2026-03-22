import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class OperationWithList {
    public HashSet Uniqe(List<Integer> list){
        HashSet<Integer> Lists = new HashSet<>(list);
        return Lists;
    }
    public HashMap countOfObject (List<Integer> list){
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int l : list){
            map.put(l,map.getOrDefault(l,0) + 1);
        }
        return map;
    }
}
