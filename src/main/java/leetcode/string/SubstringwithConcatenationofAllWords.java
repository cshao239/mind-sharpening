package leetcode.string;


import java.util.*;

/**
 * Leetcode 30: https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
 * s: a single string to be search
 * allWords: words that have same length
 */
public class SubstringwithConcatenationofAllWords {

    public static List<Integer> compute(String s, String[] allWords) {
        int lengthOfEach = allWords[0].length();
        int totalLength = lengthOfEach * allWords.length;
        if (s==null || s.isEmpty() || s.length() < totalLength) {
            return Arrays.asList();
        }

        List<Integer> result = new ArrayList<>();

        Map<String,Integer> signature = new HashMap<>();
        Arrays.stream(allWords).forEach( ss -> {
            signature.put(ss,signature.getOrDefault(ss,0)+1);
        });

        for (int i=0;i<s.length()-totalLength+1;i++) {
            Map<String,Integer> tobedelete = new HashMap<>(signature);
            for (int j=i+lengthOfEach;j<i+totalLength+1;j=j+lengthOfEach) {
                String thisSub = s.substring(j-lengthOfEach,j);
                if (!tobedelete.containsKey(thisSub) || tobedelete.get(thisSub)<=0){
                    break;
                } else {
                    tobedelete.put(thisSub,tobedelete.get(thisSub)-1);
                }
                if(j==i+totalLength) {
                    result.add(i);
                }
            }
        }
        return result;
    }
}
