package chp2;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] A = {2, 4, 5, 7, 1, 2, 3, 6};
		mergeSort(A, 0, 7);
		System.out.println("A : " + Arrays.toString(A));
	}

	public static void mergeSort(int[] A, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			System.out.printf("%d, %d, %d\n", p, q, r);
			mergeSort(A, p, q);
			mergeSort(A, q + 1, r);
			merge(A, p, q, r);
		}
	}

	public static void merge(int[] A, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;

		int[] L = new int[n1 + 1];
		int[] R = new int[n2 + 1];

		if (n1 >= 0) System.arraycopy(A, p, L, 0, n1);
		if (n2 >= 0) System.arraycopy(A, q + 1, R, 0, n2);

		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;

		int i = 0;
		int j = 0;
		for (int k = p; k <= r; k++) {
			if (L[i] <= R[j]) {
				A[k] = L[i];
				i++;
			} else {
				A[k] = R[j];
				j++;
			}
		}
	}
}
