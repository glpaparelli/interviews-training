package designpatterns.creational.abstractfactory.src;
import designpatterns.creational.abstractfactory.src.colors.*;

public class ColorFactory implements AbstractFactory<Color> {
    @Override
    public Color create(String choice) {
        switch (choice) {
            case "RED":
                return new Red();
            case "BLACK":
                return new Black();
            default:
                return null;
        }
    }
}
