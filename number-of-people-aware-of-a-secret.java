// https://leetcode.com/problems/number-of-people-aware-of-a-secret

class Solution {
    private static final int MOD = (int)1e9 + 7;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int m = (n << 1) + 10;

        long[] d = new long[m];
        long[] cnt = new long[m];

        cnt[1] = 1;

        for (int i = 1; i <= n; i++) {
            if (cnt[i] == 0) continue;
            d[i] = (d[i] + cnt[i]) % MOD;
            d[i + forget] = (d[i + forget] - cnt[i] + MOD) % MOD;

            int next = i + delay;
            while (next < i + forget) {
                cnt[next] = (cnt[next] + cnt[i]) % MOD;
                next++;
            }
        }

        long answer = 0;
        for (int i = 1; i <= n; ++i) {
            answer = (answer + d[i]) % MOD;
        }
        return (int)answer;
    }
}
