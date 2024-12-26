// https://leetcode.com/problems/calculate-amount-paid-in-taxes

class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double answer = 0d;
        int lowerBound = 0;
        for (int[] bracket : brackets) {
            int upperBound = bracket[0];
            int percent = bracket[1];
            if (upperBound > income) {
                answer += (income - lowerBound) / 100.0 * percent;
                break;
            } else {
                answer += (upperBound - lowerBound) / 100.0 * percent;
            }
            lowerBound = upperBound;
        }

        return answer;
    }
}
