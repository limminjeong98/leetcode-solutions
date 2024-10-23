import java.util.*;

// https://leetcode.com/problems/greatest-common-divisor-of-strings

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";

        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }

    public int gcd(int a, int b) {
        // 문자열 길이가 최소 1 이상이라 b가 a로 나누어지는 경우를 제외하면 b가 0일 가능성이 없음
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
