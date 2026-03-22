public class Main {
    public static void main(String[] args) {
        int number = 0;
        System.out.println(CountOfNumbers(number));
    }
    public static int CountOfNumbers (int n){
        int count = 0;
        if (n < 0){
            n = Math.abs(n);
        }
        while (n >= 0){
            if (n == 0) {
                return 1;
            }
            else {
                n = n/10;
                count++;
            }
        }
        return count;
    };
}