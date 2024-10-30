import java.util.*;

// https://leetcode.com/problems/implement-queue-using-stacks

class MyQueue {

    Deque<Integer> input;
    Deque<Integer> output;

    public MyQueue() {
        input = new ArrayDeque<>();
        output = new ArrayDeque<>();
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        // 추출 스택 조회하면서 비어 있다면 처리 진행
        peek();
        // 추출 스택에 있는 마지막 값 추출
        return output.pop();
    }
    
    public int peek() {
        // 추출 스택에 저장된게 없다면 진행
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                // 삽입 스택에서 추출한 결과를 추출 스택에 삽입 (역순으로 저장)
                output.push(input.pop());
            }
        }
        // 가장 나중에 삽입된 결과
        return output.peek();
    }
    
    public boolean empty() {
        // 두 스택이 모두 비어야 비어있는 거승로 처리
        return input.isEmpty() && output.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
