package chp2;

import java.util.Arrays;

/*
* Topic 2.1 : Insertion Sort
* */
public class InsertionSort {
	public static void main(String[] args) {
		int[] A = {2, 3, 5, 4, 1, 3};

		for (int i = 1; i < A.length; i++) {
			System.out.println("Begin : " + Arrays.toString(A));
			int key = A[i];
			System.out.println("Key : " + key);
			int runEnd = i;
			for (int j = i - 1; j >= 0; j--) {
				System.out.println("\tj : " + j + ", A[j] : " + A[j]);
				if (key < A[j]) {
					A[j + 1] = A[j];
					runEnd = j;
				}
			}
			A[runEnd] = key;
			System.out.println("End : " + Arrays.toString(A));
			System.out.println("\n");
		}

		System.out.println(Arrays.toString(A));
	}
}
