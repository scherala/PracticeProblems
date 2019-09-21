package main;

public class QuickSort {
	
	public static void main(String args[]) {
		int[] arr = new int[] {18, 3, 5, 19, 20};
		arr = quickSort(arr);
		for(int i: arr) {
			System.out.println(i);
		}
	}
	public static int[] quickSort(int[] array) {
		quickSortHelper(array, 0, array.length-1);
		return array;
	}
	
	public static void quickSortHelper(int[] array, int startIdx, int endIdx) {
		//Base case
		if(startIdx >= endIdx) {
			return;
		}
		
		int pivot = startIdx;
		int leftIdx = startIdx +1;
		int rightIdx = endIdx;
		
		while(rightIdx >= leftIdx) {
			if(array[rightIdx] < array[pivot] && array[leftIdx] > array[pivot] ) {
				swap(array, leftIdx, rightIdx);
			}
			if(array[rightIdx] >= array[pivot]) {
				rightIdx -= 1;
			}
			if(array[leftIdx] <= array[pivot]) {
				leftIdx += 1;
			}
		}
		
		swap(array, pivot, rightIdx);
		
		boolean isLeftSmaller = rightIdx -1 -startIdx  < endIdx -(rightIdx+1);
		if(isLeftSmaller) {
			quickSortHelper(array, startIdx, rightIdx-1);
			quickSortHelper(array, rightIdx+1, endIdx);
		}else {
			quickSortHelper(array, rightIdx+1, endIdx);
			quickSortHelper(array, startIdx, rightIdx-1);
		}
	}
	
	public static void swap(int[] array, int i , int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
