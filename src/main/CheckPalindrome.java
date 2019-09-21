package main;

public class CheckPalindrome {
	public static boolean isPalindrome(String str) {
		// Ideas: 
		// 1.Reverse the string and compare the reversed and actual4
		// If you reverse a string in the following way where each character is 
		// appended, the time complexity is O(n^2) since strings are immutable
		/*
		 * String changed = "";
		for(int i = str.length()-1 ;i >= 0 ;i--){
		 changed += str.charAt(i);
		}
		return str.equals(changed);*/
		//------------------------------------------------------------------------
		// Using a list/String builder instead of appending to string directly
		
		/*
		 * StringBuilder changed = new StringBuilder();
		for(int i = str.length()-1 ;i >= 0 ;i--){
		 changed.append(str.charAt(i));
		}
		
		return changed.toString().equals(str);
		*/
		//--------------------------------------------------------------------------
		//Using Recursion:
		return isPalindromeHelper(str, 0);
		
		//--------------------------------------------------------------------------
		/* Using iterative approach. Two Pointers
		int left = 0;
		int right = str.length()-1;
		while(left < right){
			if(str.charAt(left) != str.charAt(right)){
				return false;
			}
			left += 1;
			right -= 1;
		}
		return true;
		*/
  }
	
	public static boolean isPalindromeHelper(String str, int startIdx){
		int endIdx = str.length()-1-startIdx;
		
		return true ? startIdx >= endIdx : str.charAt(startIdx)== str.charAt(endIdx) && isPalindromeHelper(str, startIdx+1);
	}
}
