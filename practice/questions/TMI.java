package questions;
/*
 * > QUESTION: Tricky Method Inheritance
 *   It is possible to override a private method? And a Static method?
 * 
 * > SOLUTION: 
 *   - it is not possible to override a static method in java: static elements
 *     are bounded to the classes while overriding is a concept related to the
 *     inheritance, which affects objects. You can't override a static method 
 *     because a static method is not inherited to begin with! (kinda)
 *     - if you try to create an instance method on the child class with the same
 *       name and parameters of the static method of the parent class you will 
 *       get a compile time error
 *     - if you create a static method on the child class with the same name and 
 *       parameters of the static method of the parent class you will hide the
 *       the static parent method!
 *          - this is called method hiding
 * 
 *  - it is not possible to override a private instance method of the parent class
 *    in the child class because, since the method is private, it is not accessible 
 *    in the child class
 */
public class TMI{
    public static void main(String[] args) {
        B b = new B();
        b.bork();
        b.quack();
        // remember: if you want to call the father method instead of the overridden 
        // you have to do it inside the overridden method itself! 
        // from the outside there is no way to decide which method call between the 
        // inherited and the overridden version!
    }
}

class A {
    public final String s;

    public A(){
        this.s = new String("hello");
        this.bork();
    }

    private void bork(){
        System.out.println("A says bork");
    }

    public static void meow(){
        System.out.println("A says meow");
    }

    public void quack(){
        System.out.println("A says quack");
    }
}

class B extends A {
    public void bork(){
        System.out.println("B says bork");
        System.out.println(super.s);
    }

    public static void meow(){
        System.out.println("B says meow");
    }

    @Override
    public void quack(){
        System.out.println("B says quack!");
    }
}


