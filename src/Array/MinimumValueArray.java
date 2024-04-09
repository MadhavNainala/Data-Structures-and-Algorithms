package Array;

public class MinimumValueArray {
	
	
	
	public static int findMinimum(int[] arr) {
		if( arr == null || arr.length == 0) {
			throw new IllegalArgumentException("Invalid Input");
		}
		
		int min = arr[0];
		for(int i=0; i<arr.length; i++) {
			if(arr[i] < min) {
				min = arr[i];
			}			
		}	
		return min;		
	}
	
	public static void main(String[] args) {
		int[] arr = {7,4,9,12,2};
		int result = findMinimum(arr);
		System.out.print(result);
	}
}
