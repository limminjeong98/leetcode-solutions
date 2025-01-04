// https://leetcode.com/problems/find-all-anagrams-in-a-string

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> answer = new LinkedList<>();

        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        int targetLength = p.length();
        int length = s.length();

        Map<Character, Integer> targetCount = new HashMap<>();
        
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            // targetLength 길이 이하 인덱스까지는 맵에 추가만 해주면 됨
            if (i < targetLength) {
                targetCount.put(ch, targetCount.getOrDefault(ch, 0) + 1);
                if (i < targetLength - 1) continue;
            } else {
                // 증가 해주기
                targetCount.put(ch, targetCount.getOrDefault(ch, 0) + 1);
                // 감소도 해줘야함
                char removeChar = s.charAt(i - targetLength);
                int removeCharCount = targetCount.get(removeChar);
                if (removeCharCount == 1) {
                    targetCount.remove(removeChar);
                } else {
                    targetCount.put(removeChar, removeCharCount - 1);
                }
            }
            
            // 맵의 모든 원소를 만족하는지 확인
            boolean flag = true;
            for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
                // targetCount 맵에 키와 값이 일치하는지 확인
                char c = entry.getKey();
                // integer 동등비교할 때 -128~127 벗어나면 == 이 아니라 반드시 equals 비교해줘야 함
                if (!(targetCount.containsKey(c) && targetCount.get(c).equals(entry.getValue()))) {
                    flag = false;
                    break;
                } 
            }
            if (flag) {
                answer.add(i - targetLength + 1);
            }
        }

        return answer;
    }
}
