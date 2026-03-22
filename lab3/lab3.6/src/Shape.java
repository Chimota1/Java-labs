import java.util.List;

abstract public class Shape {
    public abstract int getArea();

    public static int calculateTotalArea(List<? extends Shape> areas){
        int allAreas = 0;
        for (int i = 0; i < areas.size(); i++){
                allAreas += areas.get(i).getArea();
        }
        return allAreas;
    }
}
