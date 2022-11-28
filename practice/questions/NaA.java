package questions;
/*
 * > QUESTION: what happens with > Null as Parameter < ?
 *   We have overloaded functions and we are passing null. Which function
 *   will be called and what will be the output of the program?
 * 
 * > SOLUTION: 
 *   According to java specs, in case of overloading, the jvm picks the 
 *   most specific function. 
 *   Since String is more specific than Object the output will always be
 *   "inside string s foo".
 * 
 *   Mind that a method "is more specific" than another if any invocation
 *   handled by the first method could be passed on to the other method 
 *   without a compile-time error. 
 * 
 *   - Java uses early binding: the most specific method is chosen at
 *     compile time.
 *     The most specific method is chosen by number of pars and type of pars.
 */
public class NaA {
    public static void main(String[] args) {
        foo(null);
    }

    public static void foo(Object o){
        System.out.println("inside object o foo");
    }
    public static void foo(String s){
        System.out.println("inside string s foo");
    }

    /*
        with the following method we would not be able to compile
        since the jvm has no way to choose which method to execute
        between this one and the string one!

        public static void foo(LinkedList<Integer> l){
            System.out.println("inside list l foo");
        }
    */
}
