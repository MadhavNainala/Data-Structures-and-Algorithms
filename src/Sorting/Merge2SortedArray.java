package Sorting;

public class Merge2SortedArray {
	

	public void printArray(int[] arr) {
	      int n = arr.length;
	      for (int i = 0; i < n; i++) {
	         System.out.print(arr[i] + " ");
	      }
	      System.out.println();
	}
	
	public int[] merge(int[] arr1, int[] arr2, int n, int m) {
		int[] result = new int[n+m];
		int i=0,j=0,k=0;
		while(i<n && j<m) {
			if(arr1[i] < arr2[j]) {
				result[k] = arr1[i];
				i++;
			}else {
				result[k] = arr2[j];
				j++;
			}
			k++;
		}
		while(i<n) {
			result[k] = arr1[i];
			i++;k++;
		}
		while(j<m) {
			result[k] = arr2[j];
			j++;k++;
		}
		return result;
	}
	
	public static void main(String[] args) {
	      int[] arr1 = new int[] {0, 3, 5,9 };
	      int[] arr2 = new int[] {2, 4, 10, 13, 19, 22 };
	      Merge2SortedArray ms = new Merge2SortedArray();
	      int[] result = ms.merge(arr1, arr2, arr1.length, arr2.length);
	      ms.printArray(result);
	}

}
