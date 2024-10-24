import java.util.*;

// https://leetcode.com/problems/guess-number-higher-or-lower

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        long start = 1;
        long end = n;
        long mid;

        while (start <= end) {
            mid = (start + end) / 2;
            // 자체적으로 pick한 number가 있고, guess 함수에서 pick한 number와 일치하는지 결과를 리턴해줌
            int answer = guess((int)mid);
            if (answer == 0) return (int)mid;
            else if (answer == 1) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        // 메서드 시그니처 때문에 기본 리턴 정의
        return 0;
    }
}
