package leetcode.string;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode 763
 * https://leetcode.com/problems/partition-labels/description/
 * A string S of lowercase letters is given. We want to partition this string into as many parts as possible
 * so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 *
 * greedy
 */
public class PartitionLabels {

    public static List<String> compute (String s) {
        if(s==null) {
            return null;
        }
        if(s.isEmpty()) {
            return Arrays.asList();
        }


        List<String> result = new ArrayList<>();
        int furthestIndex = s.lastIndexOf(s.charAt(0));
        int i=1;
        while (i<furthestIndex) {
            furthestIndex=Math.max(furthestIndex,s.lastIndexOf(s.charAt(i)));
            i++;
        }
        result.add(s.substring(0,furthestIndex+1));
        if (furthestIndex<s.length()-1) {
            result.addAll(compute(s.substring(furthestIndex+1)));
        }

        return result;
    }
}
