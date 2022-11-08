package designpatterns.creational.abstractfactory.src.animals;
import designpatterns.creational.abstractfactory.src.Animal;

public class Duck implements Animal{
    @Override
    public String getAnimal() {
        return "duck";
    }

    @Override
    public String makeSound() {
        return "quackquack";
    }
}
