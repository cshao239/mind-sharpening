package leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Leetcode 784. Letter Case Permutation
 * https://leetcode.com/problems/letter-case-permutation/description/
 */
public class LetterCasePermutation {



    //recursive
    public static List<String> compute(String s) {
        if(s.length()==0) {
            return Arrays.asList("");
        }
        char c = s.charAt(0);
        if (Character.isDigit(s.charAt(0))) {
            List<String> result = new ArrayList<>();
            compute(s.substring(1)).stream().forEach(ss -> result.add(String.valueOf(c)+ss));
            return result;
        } else if (Character.isLetter(s.charAt(0))) {
            List<String> result = new ArrayList<>();
            compute(s.substring(1)).stream().forEach(ss -> {
                result.add(String.valueOf(c).toLowerCase()+ss);
                result.add(String.valueOf(c).toUpperCase()+ss);
            });
            return result;
        }
        //if not digit nor letter, then bad
        return null;
    }

    //recursive2
    public static List<String> compute2(String s) {
        List<String> result = new ArrayList<>();
        compute2(s.toCharArray(),0,result);
        return result;
    }


    public static void compute2(char[] ss, int i, List<String> resultCollector) {
        if (i==ss.length) {
            resultCollector.add(new String(ss));
            return;
        }

        compute2(ss,i+1,resultCollector);
        if(Character.isLetter(ss[i])) {
            ss[i] ^= (1<<5);
            compute2(ss,i+1,resultCollector);
            ss[i] ^= (1<<5);
        }
    }

}
