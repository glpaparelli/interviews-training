package questions;
/*
 * > QUESTION: Tricky One Divided Zero
 *   What happens if we compute 1.0 / 0.0? 
 *   What happens if we compute 1 / 0?
 * 
 * > SOLUTION: 
 *   shorturl.at/ELNTX
 *   - 1 / 0 gives the obvious aritmethic exception
 *   - 1.0 / 0.0 gives Double.Infinity
 *   
 *   Mathematically division by zero is undefined, althoug it can be 
 *   loosely be regarded as being infinity
 *      - infinity is a number x which is bigger than any other number y
 *      - the "emptyness" 0 is inside anything an infinite amount of times
 *   
 *   An IEEE754 floating point double (used by Java) has a representation of 
 *   infinity, which is result of 1.0/0.0. In that sense 1.0/0.0 is calculable.
 * 
 *   An integral type has no representation of infinity: hence the thrown execption
 */
public class TODZ {
    public static void main(String[] args) {
        // this is just fine
        double d1 = 1.0 / 0.0; 
        System.out.println("1.0 / 0.0 = " + d1);

        // this gives arithmentic exception
        double d2 = 1/0;
        System.out.println("1 / 0 = " + d2);
    }
}
