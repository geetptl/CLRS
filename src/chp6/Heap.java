package chp6;

import java.util.Arrays;
import util.CLRSUtil;

public class Heap {
	private static final CLRSUtil<Integer> clrsUtil = new CLRSUtil<>();

	public static void main(String[] args) {
		Integer[] A = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7, 2};

		Integer[] A_ = Arrays.copyOf(A, A.length);
		System.out.println("A : " + clrsUtil.ArrayToString(A_));
		buildMaxHeap(A_);
		System.out.println("A : " + clrsUtil.ArrayToString(A_));
		increaseKey(A_, 4, 20);
		System.out.println("A : " + clrsUtil.ArrayToString(A_));

		System.out.println("A : " + clrsUtil.ArrayToString(A));
		heapSort(A);
		System.out.println("A : " + clrsUtil.ArrayToString(A));
	}

	private static void increaseKey(Integer[] A, int i, int key) {
		if (key < A[i]) {
			return;
		}
		A[i] = key;
		while (i > 0 && A[parent(i)] < A[i]) {
			swap(A, i, parent(i));
			i = parent(i);
		}
	}

	private static void heapSort(Integer[] A) {
		buildMaxHeap(A);
		int elemCount = 1;
		for (int i = A.length - 1; i >= 0; i--) {
			swap(A, 0, i);
			maxHeapify(A, 0, A.length - elemCount);
			elemCount++;
		}
	}

	private static void buildMaxHeap(Integer[] A) {
		for (int i = (A.length / 2) - 1; i >= 0; i--) {
			maxHeapify(A, i, A.length);
		}
	}

	private static void maxHeapify(Integer[] A, int i, int heapSize) {
		int l = left(i);
		int r = right(i);

		System.out.printf("\tComparing %d, %d, %d for heapSize %d\n", i, l, r, heapSize);
		int largest = i;
		if (l < heapSize && A[l] > A[i]) largest = l;
		if (r < heapSize && A[r] > A[largest]) largest = r;

		if (largest != i) {
			System.out.printf("\tSwapping %d and %d\n", i, largest);
			swap(A, i, largest);
			maxHeapify(A, largest, heapSize);
		}
	}

	private static void swap(Integer[] A, int i, int largest) {
		int temp = A[i];
		A[i] = A[largest];
		A[largest] = temp;
	}

	private static int right(int i) {
		return 2 * (i + 1);
	}

	private static int left(int i) {
		return (2 * i) + 1;
	}

	private static int parent(int i) {
		return (i - 1) / 2;
	}
}
