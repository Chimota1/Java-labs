public class Main {
    public static void main(String[] args) {
        Algorithm<Integer> intAlg = new Algorithm<>();
        Integer[] intArray = {5, 23, 8, 14, 2};
        System.out.print("Integer масив -> ");
        intAlg.FindMax(intArray);

        Algorithm<Double> doubleAlg = new Algorithm<>();
        Double[] doubleArray = {3.14, 9.81, 2.71, 7.5};
        System.out.print("Double масив -> ");
        doubleAlg.FindMax(doubleArray);

        Algorithm<Character> charAlg = new Algorithm<>();
        Character[] charArray = {'a', 'x', 'k', 'b'};
        System.out.print("Character масив -> ");
        charAlg.FindMax(charArray);

        Algorithm<String> stringAlg = new Algorithm<>();
        String[] stringArray = {"Яблуко", "Кавун", "Банан", "Апельсин"};
        System.out.print("String масив -> ");
        stringAlg.FindMax(stringArray);
    }
}