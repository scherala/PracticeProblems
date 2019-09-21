package main;

public class BubbleSort {
	
	public static void main(String args[]) {
		int[] arr = new int[] {3,10,5,1,23,89};
		bubbleSort(arr);
		for(int a : arr) {
			System.out.print(a + " ");
		}
		
	}

	public static void bubbleSort(int[] array) {
		boolean isSorted = false;
		int counter = 0;
		while(!isSorted) {
			isSorted = true;
			for(int i = 0 ; i< array.length -1 - counter; i++)
			{
				if(array[i] > array[i+1]) {
					swap(array, i, i+1);
					isSorted = false;
				}
			}
			counter++;
		}
	}

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		
	}
}
