import java.util.*;

// https://leetcode.com/problems/powx-n

class Solution {
    public double myPow(double x, int n) {
        return binaryExponential(x, n);
    }

    public double binaryExponential(double x, long n) {
        if (n == 0) return 1.0;
        // 입력 n: -2147483648인 경우 때문에 함수 파라미터 long으로 처리
        else if (n < 0) return 1.0 / binaryExponential(x, -n);
        else if (n % 2 == 1) return x * binaryExponential(x * x, (n - 1) / 2);
        else return binaryExponential(x * x, n / 2);
    }
}
