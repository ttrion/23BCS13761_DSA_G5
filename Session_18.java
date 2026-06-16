//counting towers
import java.io.*;

public class Session_18 {
    static final long MOD = 1000000007L;
    static final int MAX = 1000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        long[][] dp = new long[MAX + 1][2];

        dp[1][0] = 1;
        dp[1][1] = 1;

        for (int i = 2; i <= MAX; i++) {
            dp[i][0] = (4 * dp[i - 1][0] + dp[i - 1][1]) % MOD;
            dp[i][1] = (dp[i - 1][0] + 2 * dp[i - 1][1]) % MOD;
        }

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append((dp[n][0] + dp[n][1]) % MOD).append('\n');
        }

        System.out.print(sb);
    }
}