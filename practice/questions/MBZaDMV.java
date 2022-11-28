package questions;
/*
 * > Question: what is the > Minimum Between Zero and Double.MIN_VALUE < ?
 *   aka: what will the println print?
 * 
 * > SOLUTION: 
 *   The main will print 0.0.
 *   Unlike Integer.MIN_VALUE, which is negative, Double.MIN_VALUE is positive and 
 *   it is 2^(-1074)
 *   - this is obvious: the "smallest" double number is > 0.0, is has a bigger deciaml
 *     part than .0 because otherwise it would be an integer (plain 0)
 */
public class MBZaDMV {
    public static void main(String[] args) {
        System.out.println(Math.min(Double.MIN_VALUE, 0.0));
    }
}