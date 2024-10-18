import java.util.*;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number

class Solution {

    public static int N;
    public static Map<String, List<String>> digitsToString = new HashMap<>();

    public static void setUp() {
        digitsToString.put("2", List.of("a", "b", "c"));
        digitsToString.put("3", List.of("d", "e", "f"));
        digitsToString.put("4", List.of("g", "h", "i"));
        digitsToString.put("5", List.of("j", "k", "l"));
        digitsToString.put("6", List.of("m", "n", "o"));
        digitsToString.put("7", List.of("p", "q", "r", "s"));
        digitsToString.put("8", List.of("t", "u", "v"));
        digitsToString.put("9", List.of("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        int n = digits.length();
        if (n == 0) return answer;
        setUp();
        N = n;
        dfs(0, answer, digits, "");
        return answer;
    }

    public void dfs(int index, List<String> answer, String digits, String phoneNumber) {
        if (index == N) {
            answer.add(phoneNumber);
            return;
        }
        StringBuilder sb;
        String digit = String.valueOf(digits.charAt(index));
        List<String> letters = digitsToString.get(digit);

        for (String letter : letters) {
            sb = new StringBuilder(phoneNumber);
            sb.append(letter);
            dfs(index + 1, answer, digits, sb.toString());
        }
    }
}
