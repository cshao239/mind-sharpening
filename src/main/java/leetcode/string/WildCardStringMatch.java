package leetcode.string;

import leetcode.util.Utils;

/**
 * Leecode 44 https://leetcode.com/problems/wildcard-matching/description/
 * matching two leetcode.string while second leetcode.string may have wild card such as ? or *
 * aaa aa false
 * aaa a* true
 * abc a?c true
 * abcbac *c true
 * abcdecfgc *c *cfgc *cdecfgc    true
 *
 */
public class WildCardStringMatch {

    public static boolean match (String s, String p) {
        //the reason we must do comparison on reversed string is
        //abcdecfgc *c
        //on abc *c, the point will jump and will return false because there is nothing after *c
        //but cba c* will return true
        return oneWayMatch(s,p) || oneWayMatch(Utils.reserveString(s),Utils.reserveString(p));
    }

    private static boolean oneWayMatch (String s, String p) {
        int sp=0,pp=0;
        int lastMatchedAtS=-1,starIndexAtP=-1;

        //replace double ** with * to simplify the logic
        while (p.contains("**")) {
            p.replace("**","*");
        }

        while (sp<s.length()) {
            //if s pointer is still within scope, but p pointer is out, return false
            if (pp>=p.length()) {
                return false;
            } else if (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?') { //handle ?
                sp++;
                pp++;
            } else if (p.charAt(pp)=='*' && pp==p.length()-1) { //handle * in p's last position
                sp++;
            } else if (p.charAt(pp)=='*' && p.charAt(pp+1) !=s.charAt(sp)){ //handle * is not in p's last position, and p's next character is not same as s's current character
                starIndexAtP=pp;
                lastMatchedAtS=sp;
                sp++;
            } else if (p.charAt(pp)=='*' && p.charAt(pp+1) ==s.charAt(sp)) {//abandon *'s wildcard if p's next char is same as s's current charactor
                starIndexAtP=-1;
                lastMatchedAtS=-1;
                sp++;
                pp+=2;
            } else {
                return false;
            }
        }

        //if s pointer is out of scope, but p pointer is within scope, then the remaining characters in p must be all *
        while (pp<p.length()) {
            if (p.charAt(pp)=='*') {
                pp++;
            } else {
                return false;
            }
        }
        //otherwise return true
        return true;
    }
}
