package main;

public class FindRangeOfTarget {
	
	public static void main(String args[]) {
		int[] input = new int[] {2,5,45,45,45,45,56,67};
		int[] result = getRangeOfTarget(input, 45);
		for(int i: result) {
			System.out.println(i);
		}
	}
	
	public static int[] getRangeOfTarget(int[] array, int target) {
		
		int[] result = new int[] {-1,-1};
		alteredBinarySearch(array, target, 0, array.length-1, result, true);
		alteredBinarySearch(array, target, 0, array.length-1, result, false);
		return result;
	}

	public static void alteredBinarySearch(int[] array, int target, int leftIdx, int rightIdx, int[] result,
			boolean goLeft) {
		while(leftIdx <= rightIdx) {
			int mid = (leftIdx+rightIdx)/2;
			
			if(array[mid] < target) {
				leftIdx = mid+1;
			}else if(array[mid] > target) {
				rightIdx = mid-1;
			}else {
				if(goLeft) {
					if(mid == 0 || array[mid-1] != target) {
						result[0] = mid;
						return;
					}else {
						rightIdx = mid-1;
					}
				}else {
					if(mid == array.length || array[mid+1] != target) {
						result[1] = mid;
						return;
					}
					else {
						leftIdx = mid+1; 
					}
				}
			}
		}

	}
}
