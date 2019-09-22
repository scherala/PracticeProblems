package main;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeNumberSum {

	public static void main(String args[]) {
		int[] input = new int[] {12,3,1,2,-6,5,-8,6};
		int targetSum = 0;
		ArrayList<Integer[]> result = getThreeNumberSum(input, targetSum);
		for(Integer[] res: result) {
			for(int res_v : res) {
				System.out.print(res_v + " ");
			}
			System.out.println();
		}
	}
	
	public static ArrayList<Integer[]> getThreeNumberSum(int[] input, int targetSum){
		Arrays.sort(input);
		ArrayList<Integer[]> result = new ArrayList<Integer[]>();
		
		for(int i = 0; i< input.length;i++) {
			int left = i+1;
			int right = input.length-1;
			while(left < right) {
				int currentSum = input[i]+ input[left]+input[right];
				if(currentSum < targetSum) {
					left += 1;
				}else if(currentSum > targetSum) {
					right -= 1;
				}else {
					left += 1;
					right -= 1;
					result.add(new Integer[] {input[i],input[left],input[right]});
				}
			}
		}
		return result;
	}
}
