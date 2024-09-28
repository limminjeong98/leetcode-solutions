import java.util.*;

// https://leetcode.com/problems/longest-common-prefix

class Solution {
    public String longestCommonPrefix(String[] strs) {
        // common prefix 문자열은 아무리 길어도 가장 짧은 문자열의 길이와 같음
        List<String> strings = Arrays.asList(strs);
        if (strings.contains("")) return "";
      
        strings.sort((a, b) -> a.length() - b.length());

        int n = strings.get(0).length();
        int size = strings.size();

        String prefix = "";
      
        for (int i = 0; i < n; i++) {
            prefix = strings.get(0).substring(0, i + 1);
          
            boolean passed = true;
          
            for (int j = 1; j < size; j++) {
                String target = strings.get(j).substring(0, i + 1);
              
                if (target.equals(prefix) == false) {
                    passed = false;
                    break;
                }
              
            }
          
            if (passed == false) {
                prefix = strings.get(0).substring(0, i);
                break;
            }
        }

        return prefix;
    }
}
