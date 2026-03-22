import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> Box = new ArrayList<T>();

    public void Add (T element){
        Box.add(element);
    }

    public List<T> Show(){
        return Box;
    }

    public void Delete (T element){
        Box.remove(element);
    }
}
