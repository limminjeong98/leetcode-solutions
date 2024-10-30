import java.util.*;

// https://leetcode.com/problems/design-circular-deque

class MyCircularDeque {

    static class DoublyLinkedList {
        DoublyLinkedList left;
        DoublyLinkedList right;
        int value;

        public DoublyLinkedList(int value) {
            this.value = value;
        }
    }

    DoublyLinkedList head;
    DoublyLinkedList tail;
    
    int k;
    int length;

    public MyCircularDeque(int k) {
        // head와 tail은 실제 값을 갖는 노드가 아니라 연산을 쉽게 하기 위한 더미 노드
        head = new DoublyLinkedList(0);
        tail = new DoublyLinkedList(0);
        head.right = tail;
        tail.left = head;
        this.k = k;
        this.length = 0;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) return false;
        DoublyLinkedList node = new DoublyLinkedList(value);
        // 노드의 왼쪽 처리
        node.left = head;
        node.right = head.right;
        // 노드의 오른쪽 처리
        head.right.left = node;
        head.right = node;
        length++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) return false;
        DoublyLinkedList node = new DoublyLinkedList(value);
        // 노드의 왼쪽 처리
        node.left = tail.left;
        node.right = tail;
        // 노드의 오른쪽 처리
        tail.left.right = node;
        tail.left = node;
        length++;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) return false;
        head.right.right.left = head;
        head.right = head.right.right;
        length--;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) return false;
        tail.left.left.right = tail;
        tail.left = tail.left.left;
        length--;
        return true;
    }
    
    public int getFront() {
        if (isEmpty()) return -1;
        return head.right.value;
    }
    
    public int getRear() {
        if (isEmpty()) return -1;
        return tail.left.value;
    }
    
    public boolean isEmpty() {
        return length == 0;
    }
    
    public boolean isFull() {
        return length == k;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
