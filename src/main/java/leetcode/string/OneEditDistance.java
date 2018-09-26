package leetcode.string;

/**
 * Leetcode 161
 * An edit between two strings is one of the following changes:
 *
 *     Add a character
 *     Delete a character
 *     Change a character
 *
 * Given two string s1 and s2, find if s1 can be converted to s2 with exactly one edit. Expected time complexity is O(m+n) where m and n are lengths of two strings.
 * Edit means: deleting, inserting, and replace a character
 */
public class OneEditDistance {

    public static boolean compute(String s, String t) {
        for (int i=0;i<Math.min(s.length(),t.length());i++) {
            if (s.charAt(i)!=t.charAt(i)) {
                if (s.length()>t.length()) {
                    //if s is longer than t, then the reminder of s excluding current char must be equal to the reminder of t
                    return s.substring(i+1).equals(t.substring(i));
                } else if (s.length()==t.length()) {
                    //if length is same, then the reminder of s must be equal to the reminder of t
                    return s.substring(i+1).equals(t.substring(i+1));
                } else {
                    //if t is longer than s, then the reminder of t excluding current char must be equal to the reminder of s
                    s.substring(i).equals(t.substring(i+1));
                }
            }
        }
        return Math.abs(s.length()-t.length())==1;
    }
}
