package Array;

public class Palindrome {
	
	public static boolean isPalindrome(String word) {
		char[] charArray = word.toCharArray();
		int start =0;
		int end = word.length()-1;
		while(start<end) {
			if(charArray[start] != charArray[end]) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String word = "madam";
		boolean value = isPalindrome(word);
		System.out.println(value);
	}

}
