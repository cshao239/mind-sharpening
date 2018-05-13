package leetcode.string;


import leetcode.util.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Leetcode 248
 * return all strobogrammtic number between given int a and b
 *
 */
public class Strobogrammtic {

    public static List<Integer> compute(int a, int b) {
        List<String> result = new ArrayList<>();
        int n = String.valueOf(a).length();
        int m = String.valueOf(b).length();
        for (int i=n;i<=m;i++) {
            //find all strobogrammtic numbers that have number of digits between digits of a and digits of b
            result.addAll(Utils.allStrobogrammatic(i,i));
        }
        //filter them to make sure between a and b numerically
        //it is faster than compute each number between a and b
        return result.stream().map(s -> Integer.parseInt(s))
                .filter(integer -> integer<=b && integer>=a)
                .collect(Collectors.toList());
    }
}
