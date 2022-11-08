package designpatterns.creational.abstractfactory.src;

public interface AbstractFactory<T> {
    public T create(String choice);    
}
