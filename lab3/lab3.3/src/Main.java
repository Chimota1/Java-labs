public class Main {
    public static void main(String[] args) {
        Box<String> boxString = new Box<String>();
        String message = "message1";
        String message1 = "message2";
        String message2 = "message3";
        boxString.Add(message);
        boxString.Add(message1);
        boxString.Add(message2);
        boxString.Delete(message1);
        System.out.println(boxString.Show());
        Box<Integer> boxInt = new Box<Integer>();
        int number = 1;
        int number1 = 2;
        int number2 = 3;
        boxInt.Add(number);
        boxInt.Add(number1);
        boxInt.Add(number2);
        System.out.println(boxInt.Show());
    }
}