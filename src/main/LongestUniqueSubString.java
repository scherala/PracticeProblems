package main;

import java.util.HashMap;

public class LongestUniqueSubString {
	
	public static void main(String args[]) {
		String input = "memoizatioment";
		System.out.println(longestSubstringWithoutDuplication(input));
	}
	public static String longestSubstringWithoutDuplication(String str) {
		// technique where we have a start index and a hash map
		HashMap<Character,Integer> lastseen = new HashMap<Character,Integer>();
		int startIdx = 0;
		int[] result = new int[] {0,1};
		for(int i = 0 ;i< str.length();i++) {
			if(lastseen.containsKey(str.charAt(i))) {
				startIdx = Math.max(startIdx, lastseen.get(str.charAt(i))+1);
			}
			if(result[1] - result[0] < i+1 -startIdx) {
				result = new int[] {startIdx, i+1};
			}
			lastseen.put(str.charAt(i), i);
		}
		return str.substring(result[0], result[1]);
	}
		//Brute force
		/*
	    int currentMax = Integer.MIN_VALUE;
			String result = "";
			for(int i = 0;i< str.length(); i++){
				for(int j = i ; j< str.length() ; j++){
					if(isStringUnique(str, i, j)){
						result =  currentMax < j-i ? str.substring(i,j+1): result;
						currentMax = Math.max(currentMax,j-i);
					}
				}
			}
			return result;
	  }*/
		/*
		public static boolean isStringUnique(String str, int start, int end){
			HashSet<Character> set = new HashSet<Character>();
			for(int i = start; i<= end; i++){
				if(set.contains(str.charAt(i))){
					return false;
				}
				set.add(str.charAt(i));
			}
			return true;
		}*/
}
