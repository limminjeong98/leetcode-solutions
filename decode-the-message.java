// https://leetcode.com/problems/decode-the-message

class Solution {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> table = new HashMap<>();
        int code = (int)'a';
        System.out.println(code);
        for (char c : key.toCharArray()) {
            if (c == ' ') continue;
            if (table.containsKey(c)) continue;
            table.put(c, (char)code);
            code++;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c == ' ') sb.append(' ');
            else sb.append(table.get(c));
        }
        return sb.toString();
    }
}
