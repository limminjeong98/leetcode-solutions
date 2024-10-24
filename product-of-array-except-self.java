import java.util.*;

// https://leetcode.com/problems/product-of-array-except-self

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int left = 1;
        int right = 1;

        int n = nums.length;
        int[] products = new int[n];
        Arrays.fill(products, 1);
        for (int i = 0; i < n; i++) {
            products[i] *= left;
            left *= nums[i];

            products[n - 1 - i] *= right;
            right *= nums[n - 1 - i];
        }
        return products;
    }
}
