package Array;

public class RemoveEvenInteger {
	
	public static void printArray(int[] arr) {
		int n = arr.length;
		for(int i =0; i<n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static int[] removeEven(int[] arr) {
		int oddCount = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]%2 != 0) {
				oddCount++;
			}
		}
		int[] result = new int[oddCount];
		int count=0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]%2 != 0) {
				result[count] = arr[i];
				count++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 2, 4, 7, 10, 6, 5};
		int[] result = removeEven(arr);
		printArray(result);
	}

}
