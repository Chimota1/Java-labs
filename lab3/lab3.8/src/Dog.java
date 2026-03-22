public class Dog extends Animal {
    private String dogSound = "Bark";
    @Override
    public void makeSound() {
        System.out.print(dogSound + " ");
    }
}
