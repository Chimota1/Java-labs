import java.util.ArrayList;
import java.util.List;

public class AnimalShelter {
    private List<Dog> dogs = new ArrayList<>();
    private List<Animal> animals = new ArrayList<>();

    public void addAnimal(Dog newDog){
        dogs.add(newDog);
    }

    public void addAnimal2(Animal animal){
        animals.add(animal);
    }

    public void printAnimalSound(){
        for (Animal animal : animals){
            animal.makeSound();
        }
        for (Dog dog : dogs){
            dog.makeSound();
        }
    }
}
