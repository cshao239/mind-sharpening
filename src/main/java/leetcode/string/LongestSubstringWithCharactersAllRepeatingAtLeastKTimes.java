package leetcode.string;

import leetcode.util.Utils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Leetcode 395
 */

public class LongestSubstringWithCharactersAllRepeatingAtLeastKTimes {


    public static int compute(String s, int k) {
        //edge case
        if (s==null || s.isEmpty() || s.length()<k) {
            return 0;
        }

        //find those characters that do no appear at least k times
        int[] count = Utils.countRepresentation(s);
        Set<Character> set = new HashSet<>();
        for (int i=0;i<s.length();i++) {
            if (count[s.charAt(i)]<k) {
                set.add(s.charAt(i));
            }
        }

        //construct a regular express to use those "illegal" characteres as separator to separate the String
        String regExpression=set.stream().map(c->c.toString()).collect(Collectors.joining("|"));

        //if the regular Express is empty, then it means the whole string is composed of characters that at least appear K times
        if (regExpression.isEmpty()) {
            return s.length();
        }

        //otherwise, split
        String[] subStrings = s.split(regExpression);

        //if the subString doesn't have any substring, that means every character in the String appears less than K times
        //return 0
        if (subStrings.length==0) {
            return 0;
        }
        //otherwise return largest length of the substrings
        return Arrays.stream(subStrings)
                .mapToInt(ss->ss.length())
                .max().getAsInt();
    }
}
