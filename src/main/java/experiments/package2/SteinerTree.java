

package experiments.package2;

import experiments.autofix.classes.AutofixClass_2;

import experiments.autofix.classes.AutofixClass_1;

public class SteinerTree {
	public static int minLengthSteinerTree(int[][] g, int[] verticesToConnect) {
		int n = g.length;
		int m = verticesToConnect.length;
		if (m <= 1)
			return 0;
		int[][] dp = AutofixClass_2.AutofixMethod(g, n, m, verticesToConnect);
		System.out.println("Random junk being printed");
		System.out.println("Codegraph test");
		AutofixClass_1.AutofixMethod(dp, m, n, g);
		return dp[(1 << m) - 1][verticesToConnect[0]];
	}
}