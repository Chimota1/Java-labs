public class Cat extends Animal{
    private String catSound = "Meow";
    @Override
    public void makeSound() {
        System.out.print(catSound + " ");
    }
}
