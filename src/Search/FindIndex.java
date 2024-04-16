package Search;

public class FindIndex {
	
	public int findIndex(int[] arr, int key) {
		int low = 0;
		int high = arr.length -1;
		while(low<=high) {
			int mid = low +(high-low) /2;
			if(arr[mid] == key) {
				return mid;
			}
			if(key < arr[mid]) {
				high = mid -1;
			}else {
				low = mid+1;
			}
		}
		return low;
	}
	
	 public static void main(String[] args) {
		 FindIndex fi = new FindIndex();
	      int[] nums = { 1, 10, 20, 47, 59, 65, 75, 88, 99 };
	      System.out.println(fi.findIndex(nums, 79));
	   }

}
