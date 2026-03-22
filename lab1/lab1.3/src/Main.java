public class Main {
    public static void main(String[] args) {
        int a = 4;
        int b = 4;
        int c = 34;
        TypeOfTriangle(a,b,c);
    }
    public static void TypeOfTriangle(int a, int b, int c){
        int equalSides = 0;
        if (a == b && b == c) {
            equalSides = 3;
        }
        else if (a == b || a == c || b == c){
            equalSides = 2;
        }
        switch (equalSides){
            case 0:
                System.out.println("Трикутник різносторонній");
                break;
            case 2:
                System.out.println("Трикутник рівнобредненний");
                break;
            case 3:
                System.out.println("Трикутник рівносторонній");
                break;
        }
    }
}