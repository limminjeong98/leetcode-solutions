import java.util.*;

// https://leetcode.com/problems/reverse-vowels-of-a-string

class Solution {
    public static char[] vowels = new char[] {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
    // ascii A ~ z : 65 ~ 122
    public static boolean[] isVowel = new boolean[128];
    public String reverseVowels(String s) {
        for (char vowel : vowels) {
            isVowel[vowel] = true;
        }

        char[] charArray = s.toCharArray();

        int left = 0;
        int right = s.length() - 1;

        char swapTemp;

        while (left < right) {
            // 왼쪽의 모음을 찾을 때까지
            while (left < right && !isVowel[charArray[left]]) {
                left++;
            }
            // 오른쪽의 모음을 찾을 때까지
            while (left < right && !isVowel[charArray[right]]) {
                right--;
            }
            if (left < right) {
                swapTemp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = swapTemp;
                left++;
                right--;
            }
        }

        return new String(charArray);
    }
}
