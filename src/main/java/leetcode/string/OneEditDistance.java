package leetcode.string;

/**
 * Leetcode 161
 *
 * Edit means: deleting, inserting, and replace a character
 */
public class OneEditDistance {

    public static boolean compute(String s, String t) {
        for (int i=0;i<Math.min(s.length(),t.length());i++) {
            if (s.charAt(i)!=t.charAt(i)) {
                if (s.length()>t.length()) {
                    return s.substring(i+1).equals(t.substring(i));
                } else if (s.length()==t.length()) {
                    return s.substring(i+1).equals(t.substring(i+1));
                } else {
                    s.substring(i).equals(t.substring(i+1));
                }
            }
        }
        return Math.abs(s.length()-t.length())==1;
    }
}
