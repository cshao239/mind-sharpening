package leetcode.util;

import com.google.common.collect.ImmutableMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Utils {
    public static String reserveString (String s) {
        if (s==null) {
            return null;
        }
        if (s.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i=s.length()-1;i>=0;i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    /**
     * return a 256-element array that represents the occurance of each character
     * @param s
     * @return
     */
    public static int[] countRepresentation(String s) {
        int[] count = new int[256];
        for (int i =0;i<s.length();i++) {
            count[s.charAt(i)]++;
        }
        return count;
    }

    /**
     * return whether two strings are composed of same set of characters, e.g. anagram
     * @param s
     * @param p
     * @return
     */
    public static boolean isAnagram(String s, String p) {
        int[] count1=countRepresentation(s);
        int[] count2=countRepresentation(p);
        return Arrays.equals(count1,count2);
    }

    /**
     * a number is strobogrammatic when it is itself when it is rotated for 180 degrees
     * 1,0,8 is self-strobogrammatic
     * 6 and 9 is strobogrammtic
     *
     * @param i
     * @return
     */
    public static Map<Character,Character> strobogrammticMap = ImmutableMap.of(
            '1','1',
            '0','0',
            '8','8',
            '6','9',
            '9','6'

    );

    public static boolean isStrobogrammatic(int i) {
        String s = String.valueOf(i);
        if (s.length()==1) {
            return s.equals("0") || s.equals("8") || s.equals("1");
        }


        return strobogrammticMap.get(s.charAt(s.length()-1)) !=null
                &&
                s.charAt(0)==strobogrammticMap.get(s.charAt(s.length()-1))
                &&
                (s.length()==2 || isStrobogrammatic(Integer.parseInt(s.substring(1,s.length()-1))));
    }

    /**
     * output all strobogrammtic numbers that have numberOfDigits
     * @param numberOfDigits
     * @return
     */
    public static List<String> allStrobogrammatic(int numberOfDigits, int max) {
        if(numberOfDigits==0) {
            return Arrays.asList("");
        }
        if(numberOfDigits==1) {
            return Arrays.asList("1","0","8");
        }
        List<String> list = allStrobogrammatic(numberOfDigits-2,numberOfDigits);
        List<String> result = new ArrayList<>();
        for(String i : list) {
            if (numberOfDigits!=max) {
                result.add("0"+i+"0");
            }
            result.add("1"+i+"1");
            result.add("8"+i+"8");
            result.add("6"+i+"9");
            result.add("9"+i+"6");
        }
        return result;
    }

    public static List<Integer> indexesOf(String s, String word) {
        List<Integer> result = new ArrayList<>();
        int index = s.indexOf(word);
        while (index >=0){
            System.out.println("Index : "+index);
            result.add(index);
            index = s.indexOf(word, index+1);
        }
        return result;
    }
}
