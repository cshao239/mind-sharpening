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
            result.addAll(Utils.allStrobogrammatic(i,i));
        }
        return result.stream().map(s -> Integer.parseInt(s))
                .filter(integer -> integer<=b && integer>=a)
                .collect(Collectors.toList());
    }
}
