package leetcode.string;

import leetcode.util.Utils;

/**
 * Leecode 423
 *
 *
 * 0 zero z
 * 1 one
 * 2 two z
 * 3 three
 * 4 four
 * 5 five
 * 6 six
 * 7 seven
 * 8 eight
 * 9 nine
 */
public class ReconstructDigitsFromEnglish {
    public static String compute(String s) {
        int[] countRepresentation = Utils.countRepresentation(s);
        StringBuilder sb = new StringBuilder();
        //handle unique presence first
        //zero
        while (countRepresentation['z']>0) {
            sb.append("0");
            countRepresentation['z']--;
            countRepresentation['e']--;
            countRepresentation['r']--;
            countRepresentation['o']--;
        }
        //two
        while(countRepresentation['w']>0) {
            sb.append("2");
            countRepresentation['t']--;
            countRepresentation['w']--;
            countRepresentation['o']--;
        }

        //six
        while(countRepresentation['x']>0) {
            sb.append("6");
            countRepresentation['s']--;
            countRepresentation['i']--;
            countRepresentation['x']--;
        }
        //seven because x is unique to seven after six are removed
        while(countRepresentation['s']>0) {
            sb.append("7");
            countRepresentation['s']--;
            countRepresentation['e']--;
            countRepresentation['v']--;
            countRepresentation['e']--;
            countRepresentation['n']--;
        }
        //eight
        while(countRepresentation['g']>0) {
            sb.append("8");
            countRepresentation['e']--;
            countRepresentation['i']--;
            countRepresentation['g']--;
            countRepresentation['h']--;
            countRepresentation['t']--;
        }
        //three because h is unique to three after eight is removed
        while(countRepresentation['h']>0) {
            sb.append("3");
            countRepresentation['t']--;
            countRepresentation['h']--;
            countRepresentation['r']--;
            countRepresentation['e']--;
            countRepresentation['e']--;
        }
        //five because v is unique to five after seven is removed
        while(countRepresentation['v']>0) {
            sb.append("5");
            countRepresentation['f']--;
            countRepresentation['i']--;
            countRepresentation['v']--;
            countRepresentation['e']--;
        }

        //four because f is unique to four after five is removed
        while(countRepresentation['f']>0) {
            sb.append("4");
            countRepresentation['f']--;
            countRepresentation['o']--;
            countRepresentation['u']--;
            countRepresentation['r']--;
        }

        //one because o is unique to one after zero, two, four is removed
        while(countRepresentation['o']>0) {
            sb.append("1");
            countRepresentation['o']--;
            countRepresentation['n']--;
            countRepresentation['e']--;
        }

        //nine because n is unique to nice after one is removed
        while(countRepresentation['n']>0) {
            sb.append("9");
            countRepresentation['n']--;
            countRepresentation['i']--;
            countRepresentation['n']--;
            countRepresentation['e']--;
        }
        return sb.toString();
    }
}
