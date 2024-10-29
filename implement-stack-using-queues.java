import java.util.*;

// https://leetcode.com/problems/implement-stack-using-queues

class MyStack {

    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.add(x);
        // 기존에 저장된 값들을 삭제하고 뒤로 넣으면서, 방금 추가한 값을 맨 앞으로 이동시킴
        for (int i = 1; i < queue.size(); i++) {
            queue.add(queue.remove());
        }
    }
    
    public int pop() {
        // LinkedList의 remove는 첫번째 값 제거
        return queue.remove();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
