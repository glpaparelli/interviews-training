package questions;
/*
 * > PROBLEM: Using L for long
 *   What will be the output of the main?
 * 
 * > SOLUTION: 
 *   The output will be the following: 
 *              31536000000
 *              1471228928
 *   
 *   In the first declaration we are expliciting creating a variable as long
 *   by adding an "L" suffix. So the compiler will treat it as long and assign
 *   it to the first variable "withL". 
 * 
 *   For the second statement the compiler will perform the 
 *   calculation and treat it as a 32-bit integer. Since the output is outside
 *   the range of integer max value the compiler will truncate the most 
 *   significant bits and then assign the result to the variable. 
 */
public class ULfL {
    public static void main(String[] args) {
        long withL = 1000*60*60*24*365L;
        long withoutL = 1000*60*60*24*365;

        System.out.println(withL);
        System.out.println(withoutL);
    }
}
