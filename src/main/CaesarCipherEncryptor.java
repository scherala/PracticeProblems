package main;

public class CaesarCipherEncryptor {

	
	public static String encrypt(String str, int key) {
		key = key%26;
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ;i< str.length(); i++) {
			int toMove = (int) str.charAt(i);
			if(toMove+key > 122) {
				toMove = 96 + (key - (122-toMove));
			}else {
				toMove = toMove+ key;
			}
			sb.append((char)toMove);
		}
		return sb.toString();
	}
	
	public static void main(String args[]) {
		System.out.println(encrypt("xyz", 2));
	}
}
