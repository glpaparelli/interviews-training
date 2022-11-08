package designpatterns.creational.abstractfactory.src.animals;
import designpatterns.creational.abstractfactory.src.Animal;

public class Dog implements Animal {
    @Override
    public String getAnimal() {
        return "dog";
    }

    @Override
    public String makeSound() {
        return "borkbork";
    }
}
