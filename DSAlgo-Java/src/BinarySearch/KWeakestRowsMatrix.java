package BinarySearch;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KWeakestRowsMatrix {
	public static int[] kWeakestRows(int[][] mat, int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
		int[] ans = new int[k];

		for (int i = 0; i < mat.length; i++) {
			pq.add(new int[] { numOnes(mat[i]), i });
			if (pq.size() > k)
				pq.poll();
		}

		while (k > 0)
			ans[--k] = pq.poll()[1];

		return ans;
	}

	private static int numOnes(int[] row) {
		int lo = 0;
		int hi = row.length;

		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;

			if (row[mid] == 1)
				lo = mid + 1;
			else
				hi = mid;
		}

		return lo;
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 1 } };
		int k = 3;
		int[] output = kWeakestRows(mat, k);
		Arrays.stream(output).forEach(num -> System.out.println(num));
	}
}
