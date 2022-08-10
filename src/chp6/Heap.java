package chp6;

import util.CLRSUtil;

public class Heap {
	private static final CLRSUtil<Integer> clrsUtil = new CLRSUtil<>();

	public static void main(String[] args) {
		Integer[] A = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};

		System.out.println("A : " + clrsUtil.ArrayToString(A));
		buildMaxHeap(A);
		System.out.println("A : " + clrsUtil.ArrayToString(A));
	}

	private static void buildMaxHeap(Integer[] A) {
		for (int i = (A.length / 2) - 1; i >= 0; i--) {
			System.out.printf("i : %d, A[i] : %d\n", i, A[i]);
			maxHeapify(A, i);
		}
	}

	private static void maxHeapify(Integer[] A, int i) {
		int l = left(i);
		int r = right(i);

		System.out.println("\tA : " + clrsUtil.ArrayToString(A));
		System.out.printf("\tComparing %d, %d, %d", i, l, r);
		int largest = i;
		if (l < A.length && A[l] > A[i]) largest = l;
		if (r < A.length && A[r] > A[largest]) largest = r;
		System.out.printf(" : %d\n", largest);

		if (largest != i) {
			System.out.printf("\tSwapping %d and %d\n", i, largest);
			int temp = A[i];
			A[i] = A[largest];
			A[largest] = temp;
			System.out.println("\tA : " + clrsUtil.ArrayToString(A));
			maxHeapify(A, largest);
		}
	}

	private static int right(int i) {
		return 2 * (i + 1);
	}

	private static int left(int i) {
		return (2 * i) + 1;
	}
}
