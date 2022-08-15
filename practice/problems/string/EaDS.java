package problems.string;
import java.util.ArrayList;
import java.util.List;
/*
 * > PROBLEM 271 (medium): Encode and Decode Strings
 *   Design an algorithm to encode a list of strings to a string. 
 *   The encoded string is then sent over the network and is decoded 
 *   back to the original list of strings.
 * 
 *   - Machine 1 (sender) has the function:
 *      string encode(vector strs) {
 *          // ... your code
 *      }
 *   - Machine 2 (receiver) has the function:
 *      string decode(string s){
 *          // ... your code
 *      }
 * 
 *   So Machine 1 does: 
 *      string encoded_string = encode(strs);
 *   And Machine 2 does:
 *      vector strs2 = decode_string(encoded_string);
 * 
 *   strs2 should be equal to the original strs.
 * 
 *   Note: The string may contain any possible characters out of 256 valid ascii 
 *   characters. Your algorithm should be generalized enough to work on any possible
 *   characters. 
 *   Do not use class member/global/static variables to store states. Your encode and
 *   decode algorithms should be stateless.
 *   Do not rely on any library method such eval or serialize methods. You should 
 *   implement your own encode/decode algorithm.
 * 
 *   > SOLUTION: 
 *     - encoding: given a list of strings we encode it as as a single string by creating
 *       a string number of strings in the list + lenghts of every string + every string, 
 *       where every numeric information is separated by a semicolon :
 *          - eg: ["hi", "there"] -> 2:2:5:hithere
 *              - the first 2 is the number of strings in the list
 *              - the second 2 is the length of the first string "hi"
 *              - the 5 is the length of the second string "there"
 *     - decoding: 
 *          1) we read char by char untill we find the first :, that is the number of strings 
 *             encoded
 *          2) we iterate from 0 to the number of strings -1 and char by char we rebuild the list
 *             of lengths of each string
 *          3) for each length we read the strings and rebuild the list of strings
 */
public class EaDS {
    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.addAll(List.of("hi", "there"));
        assert(decode(encode(test)).equals(test));
    }

    // encode a list of strings into a single list
    public static String encode(List<String> strs) {
        String result = strs.size() + "";

        List<Integer> lengths = new ArrayList<>();
        strs.forEach(s -> lengths.add(s.length()));

        for (Integer i : lengths) 
            result += ":" + i;

        result += ":";

        for (String s : strs) 
            result += s;
        
        return result;
    }

    // Decodes a single string to a list of strings.
    public static List<String> decode(String s) {
        List<String> result = new ArrayList<>();

        // retrieve the number of strings char by char
        int i = 0;
        int numOfStr = 0;
        while (s.charAt(i) != ':') {
            numOfStr = numOfStr * 10 + (s.charAt(i) - '0');
            i++;
        }

        // build back the list of lengths char by char
        i++;
        List<Integer> lengths = new ArrayList<>();
        for (int j = 0; j < numOfStr; j ++) {
            int leng = 0;
            while (s.charAt(i) != ':') {
                leng = leng * 10 + (s.charAt(i) - '0');
                i++;
            }

            lengths.add(leng);
            i++;
        }

        // build back the list of strings by reading untill the lengths
        for (Integer l : lengths) {
            String tmp = "";
            for (int j = 0; j < l; j ++) {
                tmp +=s.charAt(i);
                i++;
            }
            result.add(tmp);
        }

        return result;
    }
}
