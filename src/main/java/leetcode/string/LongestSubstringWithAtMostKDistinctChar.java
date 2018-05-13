package leetcode.string;


/**
 * Leetcode 340
 * sliding window
 */
public class LongestSubstringWithAtMostKDistinctChar {


    public static String compute(String s, int k) {
        if (s==null || s.isEmpty() || s.length()<k) {
            return s;
        }

        //start is the left pointer, end is the right pointer
        //count is how many unique characters between start and end, inclusive
        int start=0,end=0,count=0;
        int[] counts = new int[26];
        int longest=0;
        String result=null;
        while (end<s.length()) {
            //if this character is a new character, count +1
            //right pointer move right
            //current position+1
            if (counts[s.charAt(end++)-'a']++==0) {
                count++;
            }
            //OK, if count is more than k, then we need to remove one
            //then we move left point to right, until we encounter a character that is last one in the substring
            //then we count-1
            if (count>k) {
                while (--counts[s.charAt(start++)-'a']>0) {
                }
                count--;
            }
            //then compare and update the longest
            if (end-start>longest) {
                longest=end-start;
                result=s.substring(start,end);
            }

        }
        return result;
    }
}
