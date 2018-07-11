package experiments.package2;

import java.util.List;
import java.util.Arrays;

public class SteinerTree {

	public static int minLengthSteinerTree(int[][] g, int[] verticesToConnect) {
		int a = 100;
        Long l = 6000L;
        String str = "Dummy Again";
        char c = 'd';
        boolean b = false;
        short sh = 2;
        List<Integer> list = Arrays.asList(2,3,4);
		System.out.println(list.get(1));
		System.out.println(list.toArray()[2]);
		int n = g.length;
		int m = verticesToConnect.length;
		if (m <= 1)
			return 0;

		if (a == 10)
			return 0;
		else if (l == 5000L) {
			String dummyString = "Just a dummy";
			return 1;
		}
		else {
			if (b == true) {
				return -1;
			}
			else {
				System.out.println("No return here");
			}
		}

		for (int k = 0; k < n; k++)
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);

		int[][] dp = new int[1 << m][n];

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				dp[1 << i][j] = g[verticesToConnect[i]][j];

		if (c == 'e')
			return 0;
		else if (b == false) {
			String dummyString = "Just a dummy";
			return 1;
		}

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

		if (a == 11) {
			if (l == 5500L) {
				return 0;
			}
			else {
				return -1;
			}
		}
		else if (l == 7000L) {
			String dummyString = "Just a dummy";
			return 1;
		}
		else {
			System.out.println("Time to return");
			return dp[(1 << m) - 1][verticesToConnect[0]];
		}
	}
}