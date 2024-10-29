import java.util.*;

// https://leetcode.com/problems/number-of-common-factors

class Solution {
    public int commonFactors(int a, int b) {
        // 최대 공약수의 약수의 개수
        int n = gcm(a, b);
        if (n == 1) return 1;
        int answer = 2;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) answer++;
        }
        return answer;
    }

    public int gcm(int a, int b) {
        // a >= b
        if (b == 0) return a;
        return gcm(b, a % b);
    }
}
