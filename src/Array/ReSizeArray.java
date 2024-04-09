package Array;

public class ReSizeArray {
	
	public static int[] resizeArray(int[] arr, int capacity) {
		int[] temp = new int[capacity];
		for(int i=0; i<arr.length; i++) {
			temp[i] = arr[i];
		}
		return temp;
	}
	
	public static void main(String[] args) {
		int[] arr = { 5, 1, 2, 9, 10};
		System.out.println("The Size of Original Array" + arr.length);
		arr = resizeArray(arr, 8);
		System.out.println("The Size of Original Array" + arr.length);
	}

}
