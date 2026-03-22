public class Main {
    public static void main(String[] args) {
        char letter = 'A';
        TypeOfLetter(letter);
    }

    public static void TypeOfLetter(char letter){
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E','I','O','U'};
        boolean isVowel = false;
        for (char vowel : vowels) {
            if (vowel == letter){
                isVowel = true;
            }
        }
        if (isVowel){
            System.out.println("Літера голосна");
        }
        else {
            System.out.println("Літера приголосна");
        }
    }
}
