package Hashing;

import java.util.Set;
import java.util.HashSet;

public class CheckDuplicates {
	
	public boolean containsDuplicates(int[] arr) {
		Set<Integer> set = new HashSet<>();
		for(int i=0; i< arr.length; i++) {
			if(set.contains(arr[i])) {
				return true;
			}
			set.add(arr[i]);
		}
		return false;
	}
	
	public static void main(String[] args) {
		CheckDuplicates d = new CheckDuplicates();
		int[] arr = new int[] {1,2,3,4};
		d.containsDuplicates(arr);
		if(d.containsDuplicates(arr)) {
			System.out.println("Array contain duplicates");
		}else {
			System.out.println("Array doesn't contain duplicates");
		}
	}

}
