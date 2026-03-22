public class Main{
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int number1 = 10;
        int number2 = 5;
        System.out.println(Division(number1,number2));
    }
    public static int Division(int n1, int n2){
     int result = n1 % n2;
     return result;
    }
}