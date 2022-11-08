package designpatterns.creational.abstractfactory.src.colors;
import designpatterns.creational.abstractfactory.src.Color;

public class Red implements Color {
    @Override
    public String getColor(){
        return "red";
    }
}
