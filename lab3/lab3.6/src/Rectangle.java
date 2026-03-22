public class Rectangle extends Shape {
    private int rectangleArea;

    public void setArea(int rectangleArea){
        this.rectangleArea = rectangleArea;
    }

    @Override
    public int getArea() {
        return rectangleArea;
    }
}
