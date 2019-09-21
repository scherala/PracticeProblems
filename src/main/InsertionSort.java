package main;

public class InsertionSort {

	public static void main(String args[]) {
		int[] arr = new int[] {3,10,5,1,23,89};
		insertionSort(arr);
		for(int a : arr) {
			System.out.print(a + " ");
		}
		
	}

	public static void insertionSort(int[] array) {
		if(array.length== 0) {
			return;
		}
		for(int i = 1; i< array.length ;i++) {
			int j = i;
			while(j > 0 && array[j] < array[j-1]) {
				swap(array, j, j-1);
				j-= 1;
			}
		}
	}
	
	public static void swap(int[] arr, int i , int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
