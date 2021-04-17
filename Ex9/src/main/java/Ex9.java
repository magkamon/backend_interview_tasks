import java.util.Arrays;

public class Ex9 {

    public static boolean doesContainSameLetters(String firstWord, String secondWord) {
        if (firstWord == null || secondWord == null) {
            return false;
        }
        if (firstWord.isEmpty() || secondWord.isEmpty()) {
            return false;
        }
        char[] firstString = firstWord.toLowerCase().toCharArray();
        char[] secondString = secondWord.toLowerCase().toCharArray();
        Arrays.sort(firstString);
        Arrays.sort(secondString);
        return Arrays.equals(firstString, secondString);
    }

}
