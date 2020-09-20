package subsetsum;

import java.util.ArrayList;
import java.util.*;

public class SubsetSumBruteForceOptimization {
	/**
	 * 
	 * @param S - array of positive integers
	 * @param k - nonnegative integer
	 * @return - array T whose sum is k, if found, otherwise null
	 */
	public static int[] subsetSum(int[] nums, int k) {
		int n = nums.length;
		List<Integer> setOfIndices = new ArrayList<Integer>();
		//create the set whose subsets we will examine
		for(int i = 0; i < n; ++i) {
			setOfIndices.add(i);		
		}
		List<Set<Integer>> subsets = PowerSet.powerSet(setOfIndices);
		for(Set<Integer> subset : subsets) {
			if(sum(nums, subset) == k) {
				return toPrimitive(valuesOf(nums, asArray(subset)));
			}
		}
		return null;
		
	}
	private static Integer[] valuesOf(int[] originalArray, int[] indices) {
		List<Integer> retval = new ArrayList<Integer>();
		for(int i = 0; i < indices.length; ++i) {
			retval.add(originalArray[indices[i]]);
		}
		return retval.toArray(new Integer[0]);
	}
	private static int[] toPrimitive(Integer[] arr) {
		int[] retval = new int[arr.length];
		for(int i = 0; i < arr.length; ++i) {
			retval[i] = arr[i];
		}
		return retval;
	}
	private static int[] asArray(Set<Integer> aSet) {
		int[] retval = new int[aSet.size()];
		int i = 0;
		for(int x : aSet) {
			retval[i++] = x;
		}
		return retval;
	}
	
	private static int sum(int[] arr, Set<Integer> subset) {
		int accum = 0;
		for(int i : subset) {
			accum += arr[i];
		}
		return accum;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 4, 7, 5, 3};
		int k = 11;
		int[] nums2 = {1, 4, 7, 5, 3};
		int k2 =2;
		int[] val = null;
		if( (val = subsetSum(nums, k)) != null) {
			System.out.println(Arrays.toString(val));
		} else {
			System.out.println("null");
		}
		if( (val = subsetSum(nums2, k2)) != null) {
			System.out.println(Arrays.toString(val));
		} else {
			System.out.println("null");
		}
	}
}
