public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Labrador labrador = new Labrador();
        AnimalShelter animalShelter = new AnimalShelter();

        animalShelter.addAnimal(dog);
        animalShelter.addAnimal(labrador);
        animalShelter.addAnimal2(cat);
        animalShelter.printAnimalSound();
    }
}