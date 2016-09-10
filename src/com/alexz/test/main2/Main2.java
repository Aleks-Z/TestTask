package com.alexz.test.main2;

public class Main2 {
	public static void main(String[] args) {
		Long[] x = new Long[]{1L, 2L, 3L};
		Long[] y = new Long[]{1L, 2L, 3L, 4L};
		System.out.println(Subsequence.exec(x, y));
	}

	static class Subsequence {
		private static int[][] mMatrix;

		static boolean exec(Object[] x, Object[] y) {
			if (x == null || y == null) throw new IllegalArgumentException();
			if (x.length > y.length) return false;
			if (x.length == 0) return true;
			mMatrix = new int[x.length + 1][y.length + 1];
			for (int i = 1; i <= x.length; i++) {
				for (int j = 1; j <= y.length; j++) {
					if (checkEqual(x[i - 1], y[j - 1]))
						mMatrix[i][j] = mMatrix[i - 1][j - 1] + 1;
					else {
						if (mMatrix[i - 1][j] >= mMatrix[i][j - 1])
							mMatrix[i][j] = mMatrix[i - 1][j];
						else
							mMatrix[i][j] = mMatrix[i][j - 1];
					}
				}
			}
			return x.length == mMatrix[x.length][y.length];
		}

		private static boolean checkEqual(Object a, Object b) {
			return (a == null && b == null) || (a != null && b != null && a.equals(b) && b.equals(a));
		}

	}


}
