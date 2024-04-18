package Sorting;

public class QuickSort {
	
	public void printArray(int[] arr) {
	      int n = arr.length;
	      for (int i = 0; i < n; i++) {
	         System.out.print(arr[i] + " ");
	      }
	      System.out.println();
	}
	
	public void sort(int[] arr, int low, int high) {
		if(low < high) {
			int p = partition(arr, low, high);
			sort(arr, low, p-1);
			sort(arr, p+1, high);
		}
	}
	
	public int partition(int[] arr, int low, int high) {
		int i=low,j = low;
		int pivot = arr[high];
		while(i<=high) {
			if(arr[i] <= pivot) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j++;
			}
			i++;
		}
		return j-1;
	}
	
	public static void main(String[] args) {
	      int[] arr = new int[] {9,5,4,2,3,7,4};
	      QuickSort st = new QuickSort();
	      st.printArray(arr);
	      st.sort(arr, 0, arr.length -1);
	      st.printArray(arr);
	}

}
