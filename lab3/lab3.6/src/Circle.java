public class Circle extends Shape {
    private int circleArea;

    public void setArea(int circleArea){
        this.circleArea = circleArea;
    }

    @Override
    public int getArea() {
        return circleArea;
    }
}
