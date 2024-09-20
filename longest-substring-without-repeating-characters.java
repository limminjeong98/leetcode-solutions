import java.util.*;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution {
    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> used = new HashMap<>();

        int maxLength = 0;
        int left = 0;
        int right = 0;
        char[] arr = s.toCharArray();

        for (char c : arr) {
            // 이미 등장했던 문자이고, 슬라이딩 윈도우의 안쪽에 있다면 left 업데이트
            // left 인덱스 이후의 문자열부터 새로운 부분문자열 시작
            if (used.containsKey(c) && left <= used.get(c)) {
                left = used.get(c) + 1;
            } else {
                // 최대 부분 문자열 길이 업데이트
                maxLength = Math.max(maxLength, right - left + 1);
            }

            // 현재 문자의 위치 삽입
            used.put(c, right);
            right++;
        }
        return maxLength;
    }
}
