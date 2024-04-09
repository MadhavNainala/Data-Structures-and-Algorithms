package Array;

public class findMissingNumber {
	
	public int findMissingNumber(int[] arr) {
		int n= arr.length + 1;
		int sum = n * (n+1)/2;
		for(int num : arr) {
			sum = sum - num;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		findMissingNumber n = new findMissingNumber();
		int[] arr = new int[] {2, 6, 3, 5, 4, 8, 1};
		int result = n.findMissingNumber(arr);
		System.out.println(result);
		
	}

}
