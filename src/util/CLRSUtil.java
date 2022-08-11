package util;

public class CLRSUtil<T> {
	public String ArrayToString(T[] A) {
		String[] A_ = new String[A.length];
		int i = 0;
		for (T t : A) {
			A_[i] = String.format("(%d=%s)", i, t);
			i++;
		}
		return "[" + String.join(", ", A_) + "]";
	}

	public void swapArrayElements(T[] A, int i, int j) {
		T temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
