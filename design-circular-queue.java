import java.util.*;

// https://leetcode.com/problems/design-circular-queue

class MyCircularQueue {

    int[] q;
    int front = 0, rear = -1;
    int length = 0;

    public MyCircularQueue(int k) {
        q = new int[k];
    }
    
    public boolean enQueue(int value) {
        // 큐가 꽉 차 있다면 진행하지 않음
        if (isFull()) return false;
        // rear 포인터 한 칸 앞으로 이동, 최대 크기를 초과하면 나머지 위치로 이동
        rear = (rear + 1) % q.length;
        // rear 위치에 값 삽입
        q[rear] = value;
        length++;
        return true;
    }
    
    public boolean deQueue() {
        // 큐가 비어있다면 진행하지 않음
        if (isEmpty()) return false;
        // front 포인터 한 칸 앞으로 이동, 최대 크기를 초과하면 나머지 위치로 이동
        front = (front + 1) % q.length;
        length--;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) return -1;
        return q[front];
    }
    
    public int Rear() {
        if (isEmpty()) return -1;
        return q[rear];
    }
    
    public boolean isEmpty() {
        return length == 0;
    }
    
    public boolean isFull() {
        return length == q.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
