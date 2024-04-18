package Sorting;

public class SortedSquares {
	
	public void printArray(int[] arr) {
	      int n = arr.length;
	      for (int i = 0; i < n; i++) {
	         System.out.print(arr[i] + " ");
	      }
	      System.out.println();
	}
	
	public int[] sortedSquare(int[] arr) {
		int i =0;
		int n = arr.length;
		int j= n-1;
		int[] result = new int[n];
		for(int k=n-1; k>=0; k--) {
			if(Math.abs(arr[i]) < Math.abs(arr[j])) {
				result[k] = arr[j] * arr[j];
				j--;
			}else {
				result[k] = arr[i] * arr[i];
				i++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
	      int[] arr = new int[] {-3, -2, 0, 5, 6, 10};
	      SortedSquares st = new SortedSquares();
	      st.printArray(arr);
	      int result[] = st.sortedSquare(arr);
	      st.printArray(result);
	   }


}
