package main;

import java.util.Arrays;

public class MinCoinsToMakeChange {
	
	public static void main(String args[]) {
		int[] denoms = new int[] {2,1};
		System.out.println(getMinNumOfCoinsToMakeChange(denoms, 3));
	}
	
	public static int getMinNumOfCoinsToMakeChange(int[] denoms, int target) {
		int[] result = new int[target+1];
		Arrays.fill(result, Integer.MAX_VALUE);
		result[0] = 0;
		
		for(int denom: denoms) {
			for(int amount = 0 ; amount < target+1 ; amount++) {
				if(denom <= amount) {
					//wrong becuase of integer overflow issue
					//result[amount]= Math.min(result[amount], result[amount-denom]+1);
					int toCompare = 0;
					if(result[amount - denom] == Integer.MAX_VALUE) {
						toCompare = result[amount-denom];
					}else {
						toCompare = result[amount-denom]+1;
					}
					result[amount] = Math.min(result[amount], toCompare);
				}
			}
		}
		return result[target] != Integer.MAX_VALUE ? result[target] : -1;
	}

}
