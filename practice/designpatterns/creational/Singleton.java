package designpatterns.creational;
/*
 * In OOP a singleton class is a class that can only have one object at a time. 
 * After the first time, if we try to instantiate the Singleton class, the new 
 * variable still points to the first instance created. 
 * 
 * > The key points while creating a singleton are: 
 *   1) make a constructor private
 *   2) write a static method that has the return type object of this singleton class
 * 
 * > How to design a Singleton Class in Java?
 *   1) ensure that only one instance of the class exists
 *   2) provide global access to that instance by 
 *      - declaring all constructors of the class private
 *      - providing a static method that returns a reference to the instance. 
 *        The lazy inizialization concept is used to write the static methods. 
 *      - the instance is stored as a private static variable
 * 
 * > Difference between Normal Class and Singleton Class
 *   We can distinguish a Singleton class from the usual classes with respect to the
 *   process of instantiating the object of the class. To instantiate a normal class we
 *   use the constructor. On the other hand to instantiate a singleton class we use
 *   the method getInstance()
 * 
 * > Forms of Singleton Class Pattern
 *   - early instantiation: the object creation takes place at the load time
 *   - lazy instantiation: the object creation is done according to the requirement
 * 
 * > Mind that this can easly be adapted to allow only N instance of an object
 */
public class Singleton {
    // static variable reference to the unique instance of Singleton
    private static Singleton instance = null;

    // here the fields that the instance may have
    private String key;

    // Construcotr: private method restricted to this class itself
    private Singleton(){
        key = "singleton example";
    }

    public static Singleton getInstance(){
        if(instance == null)
            instance = new Singleton();
        
        return instance;
    }

    public String getKey(){
        if(instance == null)
            return "";

        return key;
    }
}
