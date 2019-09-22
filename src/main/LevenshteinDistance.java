package main;

public class LevenshteinDistance {
	public static void main(String args[]) {
		System.out.println(getMinDistanceBetweenTwoStrings("abc", "yabd"));
	}

	public static int getMinDistanceBetweenTwoStrings(String str1, String str2) {
		int rows = str1.length() + 1;
		int columns = str2.length() + 1;
		int[][] result = new int[rows][columns];
		for (int i = 0; i < result[0].length; i++) {
			result[0][i] = i;
		}
		for (int j = 0; j < result.length; j++) {
			result[j][0] = j;
		}

		for (int k = 1; k < rows; k++) {
			for (int l = 1; l < columns; l++) {
				if(str1.charAt(k-1) == str2.charAt(l-1)) {
					result[k][l] = result[k-1][l-1];
				}else {
					result[k][l] = Math.min(Math.min(result[k][l-1], result[k-1][l]), result[k-1][l-1])+1;
				}
			}
		}
		return result[rows-1][columns-1];
	}
}
