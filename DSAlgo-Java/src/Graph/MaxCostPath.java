//https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
package Graph;
//
//public class MaxCostPath {
//	public static void main(String[] args) {
//
//	}
//
//}

/*
 * https://www.geeksforgeeks.org/maximum-cost-path-in-an-undirected-graph-such-that-no-edge-is-visited-twice-in-a-row/
Card game design
https://leetcode.com/discuss/interview-question/482921/microsoft-phone-design-card-game
https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/

 */

import java.util.*;

class GFG {

	static int N = 100000;

	// To store the resulting
	// sum of the cost
	static int canTake;

	// To store largest
	// cost leaf vertex
	static int best;

	static int[] dp = new int[N];
	static boolean[] vis = new boolean[N];

	// DFS Traversal to find the update
	// the maximum cost of from any
	// node to leaf
	static boolean dfs(Vector<Integer>[] g, int[] cost, int u, int pre) {

		// Mark vertex as visited
		vis[u] = true;

		// Store vertex initial cost
		dp[u] = cost[u];

		// Initially assuming edge
		// not to be traversed
		boolean check = true;

		int cur = cost[u];
		for (int x : g[u]) {

			// Back edge found so,
			// edge can be part of
			// traversal
			if (vis[x] && x != pre) {
				check = false;
			}

			// New vertex is found
			else if (!vis[x]) {

				// Bitwise AND the current
				// check with the returned
				// check by the previous
				// DFS Call
				check = dfs(g, cost, x, u) ? false : true;

				// Adds parent and its
				// children cost
				cur = Math.max(cur, cost[u] + dp[x]);
			}
		}

		// Updates total cost of parent
		// including child nodes
		dp[u] = cur;

		// Edge is part of the cycle
		if (!check) {

			// Add cost of vertex
			// to the answer
			canTake += cost[u];
		} else {

			// Updates the largest
			// cost leaf vertex
			best = Math.max(best, dp[u]);
		}
		return check;
	}

	// Function to find the maximum cost
	// from source vertex such that no
	// two edges is traversed twice
	static void FindMaxCost(Vector<Integer>[] g, int[] cost, int source) {

		// DFS call
		dfs(g, cost, source, -1);

		// Print the maximum cost
		System.out.print(canTake + best);
	}

	// Driver Code
	public static void main(String[] args) {
		int n = 5, m = 5;

		// Cost Array
		int cost[] = { 2, 2, 8, 6, 9 };

		@SuppressWarnings("unchecked")
		Vector<Integer>[] g = new Vector[n];
		for (int i = 0; i < g.length; i++)
			g[i] = new Vector<Integer>();

		// Given Graph
		g[0].add(1);
		g[1].add(0);
		g[0].add(2);
		g[2].add(0);
		g[0].add(3);
		g[3].add(0);
		g[1].add(2);
		g[2].add(1);
		g[1].add(4);
		g[4].add(1);

		// Given Source Node
		int source = 1;

		// Function call
		FindMaxCost(g, cost, source);
	}
}


