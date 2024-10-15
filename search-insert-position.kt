class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        return binarySearch(nums, target)
    }

    fun binarySearch(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size - 1
        var mid: Int
        var answer = nums.size
        while (start <= end) {
            mid = (start + end) / 2
            if (nums[mid] >= target) {
                answer = mid
                end = mid - 1
            } else {
                start = mid + 1
            }
        }
        return answer
    }
}
