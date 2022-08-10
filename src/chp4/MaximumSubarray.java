package chp4;

import java.util.Arrays;

public class MaximumSubarray {
	public static void main(String[] args) {
		int[] prices = {100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97};
		int[] changes = new int[prices.length - 1];

		for (int i = 1; i < prices.length; i++) {
			changes[i - 1] = prices[i] - prices[i - 1];
		}

		System.out.println("Prices : " + Arrays.toString(prices));
		System.out.println("Changes : " + Arrays.toString(changes));

		Solution s = maxSubarray(changes, 0, 15);
		System.out.println(s);
	}

	public static Solution maxSubarray(int[] A, int low, int high) {
		if (low == high) {
			return new Solution(low, high, A[low]);
		}
		int mid = (low + high) / 2;
		System.out.printf("%d, %d, %d\n", low, mid, high);
		Solution leftSolution = maxSubarray(A, low, mid);
		Solution rightSolution = maxSubarray(A, mid + 1, high);
		Solution crossingSolution = findMaxCrossingSubarray(A, low, mid, high);
		if (leftSolution.sum >= rightSolution.sum && leftSolution.sum >= crossingSolution.sum) {
			return leftSolution;
		} else if (rightSolution.sum >= crossingSolution.sum) {
			return rightSolution;
		} else return crossingSolution;
	}

	public static Solution findMaxCrossingSubarray(int[] A, int low, int mid, int high) {
		int leftSum = Integer.MIN_VALUE;
		int maxLeft = 0;
		int sum = 0;
		for (int i = mid; i >= low; i--) {
			sum += A[i];
			if (sum > leftSum) {
				leftSum = sum;
				maxLeft = i;
			}
		}

		int rightSum = Integer.MIN_VALUE;
		int maxRight = 0;
		sum = 0;
		for (int i = mid + 1; i <= high; i++) {
			sum += A[i];
			if (sum > rightSum) {
				rightSum = sum;
				maxRight = i;
			}
		}

		return new Solution(maxLeft, maxRight, leftSum + rightSum);
	}

	private static class Solution {
		public int maxLeft, maxRight, sum;

		public Solution(int maxLeft, int maxRight, int sum) {
			this.maxLeft = maxLeft;
			this.maxRight = maxRight;
			this.sum = sum;
		}

		@Override
		public String toString() {
			return "Solution{" +
					"maxLeft=" + maxLeft +
					", maxRight=" + maxRight +
					", sum=" + sum +
					'}';
		}
	}
}
