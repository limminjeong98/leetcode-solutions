import java.util.*;

// https://leetcode.com/problems/4sum
// https://www.youtube.com/watch?v=8_bJLk5up_M&t=6s

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);

        int length = nums.length;

        // 첫번째 값
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // 두번째 값
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int k = j + 1, m = length - 1;
                while (k < m) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        k++;
                        continue;
                    }

                    if (m < length - 1 && nums[m] == nums[m + 1]) {
                        m--;
                        continue;
                    }

                    Long sum = Long.valueOf(nums[i]);
                    sum += Long.valueOf(nums[j]);
                    sum += Long.valueOf(nums[k]); 
                    sum += Long.valueOf(nums[m]);
                  
                    if (sum.equals(Long.valueOf(target))) {
                        answer.add(Arrays.asList(nums[i], nums[j], nums[k], nums[m]));
                        k++;
                    } else if (sum < target) {
                        k++;
                    } else {
                        m--;
                    }
                }
            }
        }

        return answer;
    }
}
