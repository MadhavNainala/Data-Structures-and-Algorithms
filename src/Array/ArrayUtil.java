package Array;

public class ArrayUtil {
	
	public void printArray(int[] arr) {
		int n = arr.length;
		for(int i =0; i<n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		ArrayUtil arrUtil = new ArrayUtil();
		arrUtil.printArray(new int[] {5,3,6,10,1});
		
	}

}
