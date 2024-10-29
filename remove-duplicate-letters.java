import java.util.*;

// https://leetcode.com/problems/remove-duplicate-letters

class Solution {
    public String removeDuplicateLetters(String s) {
        // 문자 개수
        Map<Character, Integer> counter = new HashMap<>();
        // 문자별 처리 여부
        Map<Character, Boolean> visited = new HashMap<>();

        for (Character c : s.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (Character c : s.toCharArray()) {
            // 현재 처리하는 문자의 카운트 감소
            counter.put(c, counter.get(c) - 1);
            // 이미 처리가 끝난 문자인지 확인
            if (visited.containsKey(c) && visited.get(c) == true) continue;
            // 앞서 처리된 문자 중 정렬 순서상으로 현재 문자보다 뒤에 위치해야 하는 문자인지 확인
            // 앞서 처리된 문자가 현재 인덱스 이후로도 존재하고, 현재 문자보다 ascii 코드 값이 큰 경우 pop
            while (!stack.isEmpty() && counter.get(stack.peek()) > 0 && stack.peek() > c) {
                Character prev = stack.pop();
                visited.put(prev, false);
            }
            stack.push(c);
            visited.put(c, true);
        }

        StringBuilder sb = new StringBuilder();
        // push = addFirst / pop = removeFirst, pollFirst
        // pollLast -> pop과 반대 (pop은 pollFirst와 동일)
        // 스택의 pop() 메서드는 제일 최근에 삽입된 걸 삭제한다 (인덱스 상 맨 앞에 위치)
        // 큐의 pollLast() 메서드는 제일 최근에 삽입된 걸 삭제한다 (인덱스 상 맨 끝에 위치)
        while (!stack.isEmpty()) {
            // 스택에 있는 문자를 큐 순서대로 추출하여 리턴
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}
