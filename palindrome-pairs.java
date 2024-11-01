import java.util.*;

// https://leetcode.com/problems/palindrome-pairs

class Solution {
    static class TrieNode {
        // 단어 id
        int wordId;

        TrieNode[] children;
        List<Integer> palindromeWordIds;

        public TrieNode() {
            // 단어 id의 초기값은 의미 없는 값으로 선언
            wordId = -1;
            // 자식 노드는 알파벳의 개수인 최대 26개까지 가능
            children = new TrieNode[26];
            // 팰린드롬 단어 id 목록을 빈 값으로 초기화
            palindromeWordIds = new ArrayList<>();
        }
    }

    static class Trie {
        TrieNode root;

        // 클래스 생성 시 루트로 빈 트라이 노드 생성
        public Trie() {
            root = new TrieNode();
        }

        // 인덱스를 받아서 팰린드롬 여부를 판별하는 메서드
        public boolean isPalindrome(String str, int start, int end) {
            // 시작 지점이 종료 지점보다 앞에 있으면 계속 반복
            while (start < end) {
                // 시작 지점은 증가, 종료 지점은 감소하면서 문자가 일치하는지 확인
                if (str.charAt(start++) != str.charAt(end--)) return false;
            }
            return true;
        }

        // 단어 삽입
        public void insert(int index, String word) {
            // 루트부터 시작
            TrieNode cur = root;
            // 단어를 뒤집어서 트라이로 저장
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                // 정방향으로 해당 위치까지 팰린드롬인 경우 단어의 인덱스 저장
                if (isPalindrome(word, 0, i)) {
                    cur.palindromeWordIds.add(index);
                }
                // 해당 문자의 자식 노드가 존재하지 않으면 신규 트라이 노드 생성
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                // 자식 노드를 현재 노드로 교체
                cur = cur.children[c - 'a'];
            }
            // 단어가 완성된 후 단어의 인덱스 저장
            cur.wordId = index;
        }

        // 팰린드롬 여부 판별
        public List<List<Integer>> search(int index, String word) {
            TrieNode cur = root;
            List<List<Integer>> result = new ArrayList<>();

            // 단어의 문자를 차례대로 반복하며 처리
            for (int j = 0; j < word.length(); j++) {
                // 탐색 중에 단어 id가 있고, 나머지 문자가 팰린드롬인 경우
                if (cur.wordId >= 0 && isPalindrome(word, j, word.length() - 1)) {
                    result.add(Arrays.asList(new Integer[] { index, cur.wordId }));
                }
                // 자식 노드가 없으면 더 이상 팰린드롬이 아니므로 지금까지의 결과를 리턴하면서 중단
                if (cur.children[word.charAt(j) - 'a'] == null) return result;
                // 자식 노드를 현재 노드로 교체
                cur = cur.children[word.charAt(j) - 'a'];
            }
            // 끝까지 탐색했을 때 단어 id가 있는 경우
            if (cur.wordId >= 0 && cur.wordId != index) {
                result.add(Arrays.asList(new Integer[] { index, cur.wordId }));
            }
            // 끝까지 탐색했을 때 팰린드롬 단어 id가 있는 경우
            for (int palindromeWordId : cur.palindromeWordIds) {
                result.add(Arrays.asList(new Integer[] { index, palindromeWordId }));
            }
            return result;
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        Trie t = new Trie();
        List<List<Integer>> results = new ArrayList<>();

        // 단어 목록을 하나씩 트라이에 추가
        for (int i = 0; i < words.length; i++) {
            t.insert(i, words[i]);
        }

        // 단어 목록에서 하나씩 팰린드롬 여부를 판별하고 결과를 누적
        for (int i = 0; i < words.length; i++) {
            results.addAll(t.search(i, words[i]));
        }
        return results;
    }
}
