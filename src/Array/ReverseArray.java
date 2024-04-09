package Array;

public class ReverseArray {
	
	public static void printArray(int[] arr) {
		int n = arr.length;
		for(int i =0; i<n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void reverseArray(int[] arr, int start, int end) {
		while(start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {2,7,4,9,12,1,3};
		reverseArray(arr, 0, arr.length - 1);
		printArray(arr);
		
	}

}
