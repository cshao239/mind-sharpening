package leetcode.string;

import leetcode.util.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Leetcode 451
 * https://leetcode.com/problems/sort-characters-by-frequency/description/
 */
public class SortCharactersByFrequency {
    public static String compute(String s) {
        int[] countRepresentation = Utils.countRepresentation(s);
        TreeMap<Integer,List<Character>> treeMap = new TreeMap<>();

        for (int i=0;i<countRepresentation.length;i++) {
            if (!treeMap.containsKey(countRepresentation[i])) {
                treeMap.put(countRepresentation[i],new ArrayList<>());
            }
            treeMap.get(countRepresentation[i]).add((char)i);
        }

        StringBuilder sb = new StringBuilder();

        for (Map.Entry entry: treeMap.descendingMap().entrySet()) {
            List list = (List) entry.getValue();
            list.stream().forEach(l ->
                    appendNTimes(sb, (Character) l,(Integer) entry.getKey())
            );
        }

        return sb.toString();
    }

    private static void appendNTimes(StringBuilder sb, char c, int n) {
        while (n>0){
            sb.append(c);
            n--;
        }
    }
}
