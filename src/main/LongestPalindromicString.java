package main;

public class LongestPalindromicString {
	public static void main(String args[]) {
		String input = "abaxyzzyxf";
		String result = longestPalindromicSubstring(input);
		System.out.println(result);
	}
	public static String longestPalindromicSubstring(String str) {
		//Technique where we expand from center
		int[] result = new int[] {0,1};
		for(int i = 1; i< str.length();i++) {
			int[] odd = getLongestPalindromeFrom(str, i-1, i+1);
			int[] even = getLongestPalindromeFrom(str, i-1,i);
			int[] temp = odd[1]-odd[0] > even[1]-even[0]? odd :even;
			result = temp[1]-temp[0]> result[1]-result[0]? temp: result;
		}
		return str.substring(result[0], result[1]);
	}
	
	public static int[] getLongestPalindromeFrom(String str, int left, int right) {
		while(left >=0 && right < str.length()) {
			if(str.charAt(left) != str.charAt(right)) {
				break;
			}
			left -= 1;
			right += 1;
		}
		return new int[] {left+1, right};
	}
	    //BruteForce
		/*
			int currentMax = Integer.MIN_VALUE;
			String result = "";
			for(int i = 0;i< str.length(); i++){
				for(int j = i ; j< str.length() ; j++){
					if(isPalindrome(str, i, j)){
						result =  currentMax < j-i ? str.substring(i,j+1) : result;
						currentMax = Math.max(currentMax,j-i);
					}
				}
			}
			return result;
	  }
		public static boolean isPalindrome(String str, int start, int end){
			int left = start;
			int right = end;
			while(left < right){
				if(str.charAt(left) != str.charAt(right)){
					return false;
				}
				left += 1;
				right -= 1;
			}
			return true;
		}*/
}
