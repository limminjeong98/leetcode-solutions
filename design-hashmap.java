import java.util.*;

// https://leetcode.com/problems/design-hashmap

class MyHashMap {

    static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node[] nodes;

    public MyHashMap() {
        nodes = new Node[1000000];
    }
    
    public void put(int key, int value) {
        // 해싱 결과를 인덱스로 지정
        int index = (key) % nodes.length;
        if (nodes[index] == null) {
            nodes[index] = new Node(key, value);
            return;
        }
        // 해싱한 인덱스에 노드가 존재한다면 연결 리스트로 처리
        Node node = nodes[index];
        while (node != null) {
            // 동일한 키가 있다면 값을 업데이트하고 종료
            if (node.key == key) {
                node.value = value;
                return;
            }
            // 다음 노드가 없다면 종료
            if (node.next == null) break;
            // 다음 노드로 진행
            node = node.next;
        }
        // 마지막 노드 다음으로 연결
        node.next = new Node(key, value);
    }
    
    public int get(int key) {
        int index = key % nodes.length;
        if (nodes[index] == null) return -1;
        // 해싱한 인덱스에 노드가 존재한다면 일치하는 키 탐색
        Node node = nodes[index];
        while (node != null) {
            if (node.key == key) return node.value;
            node = node.next;
        }
        // 인덱스를 모두 순회해도 일치하는 키가 없다면
        return -1;
    }
    
    public void remove(int key) {
        int index = key % nodes.length;
        if (nodes[index] == null) return;
        
        // 연결 리스트의 첫번째 노드일 때의 삭제 처리
        Node node = nodes[index];
        if (node.key == key) {
            // 다음 노드가 없으면 해당 인덱스를 null 처리
            if (node.next == null) {
                nodes[index] = null;
            } else {
                nodes[index] = node.next;
            }
            return;
        }
        // 연결 리스트의 첫번째 노드가 아닐 때의 삭제 처리
        Node prev = node;
        while (node != null) {
            if (node.key == key) {
                prev.next = node.next;
                return;
            }
            prev = node;
            node = node.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
