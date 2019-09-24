package main;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllPermutations {
	public static void main(String args[]) {
		char[] input = new char[] { 'b', 'o', 'a', 't' };
		ArrayList<List<Character>> result = new ArrayList<>();
		getAllPermutations(input, result, new ArrayList<Character>());
		for (List<Character> res : result) {
			for (Character c : res) {
				System.out.print(c + " ");
			}
			System.out.println();
		}
	}

	public static void getAllPermutations(char[] input, ArrayList<List<Character>> result,
			ArrayList<Character> runningChoices) {
		if(runningChoices.size() == input.length) {
			result.add(new ArrayList<Character>(runningChoices));
			return;
		}
		
		for(int i = 0 ;i< input.length;i++) {
			Character choice = input[i];
			
			if(runningChoices.contains(choice)) {
				continue;
			}
			runningChoices.add(choice);
			getAllPermutations(input, result, runningChoices);
			runningChoices.remove(runningChoices.size()-1);
		}
	}

}
