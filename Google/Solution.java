public class Solution {

	public int countPairs(TreeNode root, int distance) {
		int[] ans = new int[1]; // Using an array to allow updates within the dfs function
		dfs(root, distance, ans);
		return ans[0];
	}

	private int[] dfs(TreeNode node, int distance, int[] ans) {
		if (node == null) {
			return new int[0];
		}

		if (node.left == null && node.right == null) { // If it's a leaf node
			return new int[]{1};
		}

		int[] leftDistances = dfs(node.left, distance, ans);
		int[] rightDistances = dfs(node.right, distance, ans);

		// Count pairs across left and right subtrees
		for (int ld: leftDistances) {
			for (int rd: rightDistances) {
				if (ld + rd <= distance) {
					ans[0]++;
				}
			}
		}

		// Prepare and return distance list for the current node
		int[] distances = new int[leftDistances.length + rightDistances.length];
		int index = 0;

		for (int ld: leftDistances) {
			if (ld + 1 < distance) { // Only consider up to `distance-1`
				distances[index++] = ld + 1;
			}
		}

		for (int rd: rightDistances) {
			if (rd + 1 < distance) { // Only consider up to `distance-1`
				distances[index++] = rd + 1;
			}
		}

		return Arrays.copyOf(distances, index);
	}
}
