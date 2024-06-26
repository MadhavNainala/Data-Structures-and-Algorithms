package Sorting;

public class MergeSort {
	
	public void printArray(int[] arr) {
	      int n = arr.length;
	      for (int i = 0; i < n; i++) {
	         System.out.print(arr[i] + " ");
	      }
	      System.out.println();
	}
	
	public void sort(int[] arr,int[] temp, int low, int high) {
		if(low<high) {
			int mid = low + (high - low)/2;
			sort(arr, temp, low, mid);
			sort(arr, temp, mid+1, high);
			merge(arr,temp, low, mid, high);
		}
	}
	
	public void merge(int[] arr, int[] temp, int low, int mid, int high) {
		for(int i =0; i<=high; i++) {
			temp[i] = arr[i];
		}
		
		int i=low, j= mid+1, k=low;
		
		while(i<=mid && j<=high) {
			if(temp[i] <= temp[j]) {
				arr[k] = temp[i];
				i++;
			}else {
				arr[k] = temp[j];
				j++;
			}
			k++;
		}
		
		while(i<=mid) {
			arr[k] = temp[i];
            k++;
            i++;
		}
	}
	
	public static void main(String[] args) {
		  int[] arr = new int[] {9,5,4,2,3};
	      MergeSort ms = new MergeSort();
	      ms.sort(arr, new int[arr.length], 0, arr.length - 1);
	      ms.printArray(arr);
	}

}
