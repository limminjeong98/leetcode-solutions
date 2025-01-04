// https://leetcode.com/problems/fizz-buzz

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> answer = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            int mod3 = i % 3;
            int mod5 = i % 5;
            if (mod3 == 0 && mod5 == 0) {
                answer.add("FizzBuzz");
            } else if (mod3 == 0) {
                answer.add("Fizz");
            } else if (mod5 == 0) {
                answer.add("Buzz");
            } else {
                answer.add(String.valueOf(i));
            }
        }
        return answer;
    }
}
