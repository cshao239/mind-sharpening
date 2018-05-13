package leetcode.string;


import leetcode.util.Utils;

import java.util.List;
import java.util.Set;

/**
 * LeetCode 758. Bold Words in String
 * Given a set of keywords words and a string S,
 * make all appearances of all keywords in S bold. Any letters between <b> and </b> tags become bold.
 *
 * The returned string should use the least number of tags possible, and of course the tags should form a valid combination.
 *
 * For example, given that words = ["ab", "bc"] and S = "aabcd", we should return "a<b>abc</b>d".
 * Note that returning "a<b>a<b>b</b>c</b>d" would use more tags, so it is incorrect.
 */
public class BoldWordsinString {


    public static String compute(String s, Set<String> words) {
        if (words.isEmpty() || s==null || s.isEmpty()) {
            return s;
        }
        int[] boldFlag = new int[s.length()];
        for (String word : words) {
            List<Integer> indexes = Utils.indexesOf(s, word);
            indexes.stream().forEach(i -> fill(boldFlag,i,word.length()));
        }

        StringBuilder sb = new StringBuilder();

        for (int i=0;i<s.length();i++) {
            if(boldFlag[i]==1 && (i==0 || boldFlag[i-1]==0)){
                sb.append("<b>");
            }
            sb.append(s.charAt(i));
            if(boldFlag[i]==1 && (i==s.length()-1 || boldFlag[i+1]==0)){
                sb.append("</b>");
            }
        }
        return sb.toString();


    }

    public static void fill(int[] array, int start, int length) {

        for (int i=start;i<=start+length-1;i++) {
            array[i]=1;
        }

    }
}
