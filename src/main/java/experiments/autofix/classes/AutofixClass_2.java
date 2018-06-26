

package experiments.autofix.classes;

import experiments.autofix.classes.AutofixClass_1;

public class AutofixClass_2 {
	public static int[][] AutofixMethod(int[][] g, int n, int m, int[] verticesToConnect) {
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
}