import java.util.*;

// https://leetcode.com/problems/can-place-flowers

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        int length = flowerbed.length;
        int i = 0;

        while (i < length && n > 0) {
            if (flowerbed[i] == 1) {
                // 초기 배열은 한칸씩 떨어져 있는 상태이므로 2칸을 더함
                i += 2;
            } else if (i == length - 1 || flowerbed[i + 1] == 0) {
                // 마지막 칸이거나, 현재 칸과 다음 칸이 모두 꽃이 없는 상태
                n--;
                i += 2;
            } else {
                // 현재 칸은 꽃이 없지만 다음 칸에 꽃이 있는 상태
                i += 3;
            }
        }
        return n == 0;
    }
}
