import java.util.*;

// https://leetcode.com/problems/3sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> answer = new ArrayList<>();

        int n = nums.length;
        int left;
        int right;
        int sum;

        // 세 숫자 = nums[i], nums[left], nums[right]
        for (int i = 0; i < n - 2; i++) {
            // [5, -1, -1, 0, 1, 2] 와 같이 중복된 값 연속될 수 있음
            // 중복된 값 건너뛰기
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            // 간격을 좁혀가며 합 sum 계산
            left = i + 1;
            right = n - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    // 합이 0보다 크다면 오른쪽 포인터 이동
                    right--;
                } else if (sum < 0) {
                    // 합이 0보다 작다면 왼쪽 포인터 이동
                    left++;
                } else {
                    // sum == 0 인 경우이므로 정답 처리
                    answer.add(List.of(nums[i], nums[left], nums[right]));
                    // 같은 숫자가 여러 개 있을 수 있기 때문에 중복된 답이 있을 수 있음
                    // 중복된 값 건너뛰기, 이 처리를 하지 않으면 같은 정답이 두 번 나올 수 있다
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // 정답이 나왔으므로 투 포인터 모두 한칸씩 이동. sum == 0인 상황이므로 양쪽 모두 이동해야 한다
                    left++;
                    right--;
                }
            }
        }
        return answer;
    }
}
