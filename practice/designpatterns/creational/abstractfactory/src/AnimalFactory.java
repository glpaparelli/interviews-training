package designpatterns.creational.abstractfactory.src;
import designpatterns.creational.abstractfactory.src.animals.*;

public class AnimalFactory implements AbstractFactory<Animal> {
    @Override
    public Animal create(String choice) {
        switch (choice) {
            case "DOG":
                return new Dog();
            case "DUCK":
                return new Duck();
            default:
                return null;
        }
    }
}