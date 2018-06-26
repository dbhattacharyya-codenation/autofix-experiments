

package experiments.autofix.classes;

import java.util.*;

public class AutofixClass_1 {
	public static int[][] AutofixMethod_2(int[][] g, int n, int m, int[] verticesToConnect) {
		for (int k = 0; k < n; k++)
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
		int[][] dp = new int[1 << m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				dp[1 << i][j] = g[verticesToConnect[i]][j];
		return dp;
	}
	public static void AutofixMethod_1(int[][] dp, int m, int n, int[][] g) {
		for (int i = 1; i < 1 << m; i++) {
			if (((i - 1) & i) != 0) {
				for (int j = 0; j < n; j++) {
					dp[i][j] = Integer.MAX_VALUE / 2;
					for (int k = (i - 1) & i; k > 0; k = (k - 1) & i) {
						dp[i][j] = Math.min(dp[i][j], dp[k][j] + dp[i ^ k][j]);
					}
				}
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < n; k++) {
						dp[i][j] = Math.min(dp[i][j], dp[i][k] + g[k][j]);
					}
				}
			}
		}
	}
}