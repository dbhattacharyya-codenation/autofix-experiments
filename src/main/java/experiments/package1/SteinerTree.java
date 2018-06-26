

package experiments.package1;

import experiments.autofix.classes.AutofixClass_1;

public class SteinerTree {
	public static int minLengthSteinerTree(int[][] g, int[] verticesToConnect) {
		int n = g.length;
		int m = verticesToConnect.length;
		if (m <= 1)
			return 0;
		System.out.println("Very important operation being performed here");
		int[][] dp = AutofixClass_1.AutofixMethod_2(g, n, m, verticesToConnect);
		AutofixClass_1.AutofixMethod_1(dp, m, n, g);
		return dp[(1 << m) - 1][verticesToConnect[0]];
	}
}
