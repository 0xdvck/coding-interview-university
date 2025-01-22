//https://www.youtube.com/watch?v=AqMiMkPOutQ
class QuickSelect {
	// partition
	// pick random pivot
	// All element smaller than pivot is on the left
	// All element larger than pivot is on the right
	private int partition(int[] arr, int l, int r) {

		int pivot = r;
		int j = l;
		for (int i = l; i < r; i++) {
			if (arr[i] <= arr[pivot]) {
				// swap
				swap(arr, i, j);
				j++;

			}

		}
		swap(arr, j, pivot);

		return j;

	}

	// quickselect
	// partition list according to random pivot
	// if random pivot is in index k - 1 => return k element
	// else we do quickselect
	// pivot index > k - 1 -> quickselect on the left (pivot index larger than k
	// index)
	// pivot index < k - 1 -> quickselect on the right (pivot index smaller than k
	// index)
	private int quickSelect(int[] arr, int l, int r, int k) {
		int pivot = partition(arr, l, r);

		if (pivot == k - 1)
			return arr[pivot];

		if (pivot > k - 1)
			return quickSelect(arr, l, pivot - 1, k);
		else
			return quickSelect(arr, pivot + 1, r, k);

	}

	// swap using xor
	// if 2 swap element is equal then return
	private void swap(int[] arr, int l, int r) {
		if (arr[l] == arr[r])
			return;

		arr[l] ^= arr[r];
		arr[r] ^= arr[l];
		arr[l] ^= arr[r];

	}
}
