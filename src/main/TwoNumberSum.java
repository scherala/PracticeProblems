package main;

import java.util.Arrays;

public class TwoNumberSum {

	// Input: Non-empty Array of distinct integers
	// and an integer representing the target sum
	public static void main(String args[]) {

		int[] arr = new int[] { 3, 5, -4, 8, 11, 1, -1, 6 };
		int[] result = getTwoNumbersOfTargetSum(arr, 10);
		for (int res : result) {
			System.out.print(res + " ");
		}
	}

	public static int[] getTwoNumbersOfTargetSum(int[] arr, int i) {
		// Using HashSet
		/*
		 * HashSet<Integer> set = new HashSet<Integer>(); for (int num : arr) { if
		 * (set.contains(i - num)) { return num > (i - num) ? new int[] { (i - num), num
		 * } : new int[] { num, (i - num) }; } set.add(num); } return new int[] {};
		 */
		Arrays.sort(arr);
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int sum = arr[left] + arr[right];
			if (sum < i) {
				left += 1;
			} else if (sum > i) {
				right -= 1;
			} else {
				return arr[left] > arr[right] ? new int[] { arr[right], arr[left] }
						: new int[] { arr[left], arr[right] };
			}
		}
		return new int[] {};

	}

}
