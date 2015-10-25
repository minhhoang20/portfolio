package ground;

public class Solution {
	private static final int MAX_SIZE = 100000;
	private static final int MIN_SIZE = 3;

	public int solution(int[] A) {
		if (A.length > MAX_SIZE) {
			throw new IllegalArgumentException("Size of array is too big.");
		}
		if (A.length < MIN_SIZE) {
			throw new IllegalArgumentException("Size of array is too small.");
		}
		Integer lastDist = null;
		Integer currentDist = null;
		Integer slices = 0;

		for (int i = 1; i < A.length; i++) {
			currentDist = A[i] - A[i - 1];
			if (lastDist != null && currentDist == lastDist) {
				slices++;
			}
			lastDist = currentDist;
		}
		return slices;
	}

	public static void main(String args[]) {
		Solution sol = new Solution();
		int[] input = { -1, 1, 3, 3, 3, 2, 1, 0 };
		System.out.println(sol.solution(input));
	}
}