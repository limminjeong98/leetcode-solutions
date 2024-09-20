import java.util.*;

// https://leetcode.com/problems/permutations

class Solution {
    public static List<List<Integer>> answer;
  
    public List<List<Integer>> permute(int[] nums) {
        answer = new ArrayList<>();
      
        List<Integer> notVisited = Arrays.stream(nums).boxed().collect(Collectors.toList());
      
        dfs(new ArrayList<Integer>(), notVisited); 
      
        return answer;
    }

    public void dfs(List<Integer> visited, List<Integer> notVisited) {
        if (notVisited.isEmpty()) {
            answer.add(new ArrayList<>(visited));
            return;
        }

        // int i 로 하면 int -> Integer 박싱 연산 발생함
        for (Integer i : notVisited) {
            List<Integer> newVisited = new ArrayList<>(notVisited);
            // remove 메서드 인자로 int가 오면 인덱스 삭제하고, Integer가 오면 값을 삭제함
            // newVisited.remove(Integer.valueOf(i));
            newVisited.remove(i);

            visited.add(i);
            dfs(visited, newVisited);
            visited.removeLast();
        }
    }
}
