package chp7;

import util.CLRSUtil;

public class QuickSort {
	private static final CLRSUtil<Integer> clrsUtil = new CLRSUtil<>();

	public static void main(String[] args) {
		Integer[] A = {2, 8, 7, 1, 3, 5, 6, 4, 4};

		System.out.println("A : " + clrsUtil.ArrayToString(A));
		quickSort(A, 0, A.length - 1);
		System.out.println("A : " + clrsUtil.ArrayToString(A));
	}

	private static void quickSort(Integer[] A, int p, int r) {
		if (p < r) {
			int q = partition(A, p, r);
			quickSort(A, p, q - 1);
			quickSort(A, q + 1, r);
		}
	}

	private static int partition(Integer[] A, int p, int r) {
		int pivot = A[r];
		int i = p - 1;
		for (int j = p; j <= r - 1; j++) {
			if (A[j] <= pivot) {
				i++;
				clrsUtil.swapArrayElements(A, i, j);
			}
		}
		clrsUtil.swapArrayElements(A, i + 1, r);
		return i + 1;
	}
}
