package Sorting;

public class MaxMin {
	
	public void printArray(int[] arr) {
	      int n = arr.length;
	      for (int i = 0; i < n; i++) {
	         System.out.print(arr[i] + " ");
	      }
	      System.out.println();
	}
	
	public void arrangeMaxMin(int[] arr) {
		int minId =0;
		int maxId = arr.length -1;
		int max = arr[maxId] + 1;
		for(int i=0; i< arr.length; i++) {
			if(i%2 == 0) {
				arr[i] = arr[i] + (arr[maxId] % max) * max;
				maxId --;
			}else {
				arr[i] = arr[i] + (arr[minId] % max) * max;
				minId ++;
			}
		}
		
		for(int i=0; i<arr.length;i++) {
			arr[i] = arr[i] / max;
		}
	}
	
	public static void main(String[] args) {
	      int[] arr = new int[] {2, 3, 5, 7, 9};
	      MaxMin st = new MaxMin();
	      st.printArray(arr);
	      st.arrangeMaxMin(arr);
	      st.printArray(arr);
	   }

}
