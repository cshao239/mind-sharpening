package leetcode.string;

public class ReadableNumbers {
    public static final String[] wordsEveryThreeDigits={"","thousand","million","billion","trillion"};

    public static final String[] wordsBelowTwenty={"zero","one","two","three","four","five","six","seven","eight","nine","ten",
        "eleven","twelve","thirteen","fourteen","fifteen", "sixteen","seventeen","eighteen","nineteen"};

    public static final String[] wordsEveryTen={"ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety","hundred"};

    public static final String[] wordsBetweenElevenAndNineTeen={"eleven",""};

    public static String readableNumbers(long number) {
        StringBuilder sb = new StringBuilder();
        int i=0;
        while (number>0) {
            long mod = number % 1000;
            number = number / 1000;
            sb.insert(0,readableNumbersBelowThousand(mod).append(" ").append(wordsEveryThreeDigits[i]).append(" "));
            i++;
        }

        return sb.toString().trim();
    }

    public static StringBuilder readableNumbersBelowThousand(long number) {
        if (number==0L) {
            return new StringBuilder();
        }
        int hundreds =  (int) number /100;
        int belowHundred = (int) number % 100;

        StringBuilder sb = new StringBuilder();
        if(hundreds!=0 && belowHundred==0){
            sb.append(wordsBelowTwenty[hundreds]).append(" hundred");
            return sb;
        } else if (hundreds!=0 && belowHundred!=0){
            sb.append(wordsBelowTwenty[hundreds]).append(" hundred and ");
        }

        if(belowHundred<=19) {
            sb.append(wordsBelowTwenty[belowHundred]).toString();
        } else {
            int k = belowHundred / 10;
            int m = belowHundred % 10;
            sb.append(wordsEveryTen[k-1]);
            if(m!=0) {
               sb.append(" ").append(wordsBelowTwenty[m]);
            }
        }
        return sb;
    }

    public static void main (String[] args) {
        System.out.println(readableNumbersBelowThousand(600L));
        System.out.println(readableNumbers(123111699L));
    }
}
