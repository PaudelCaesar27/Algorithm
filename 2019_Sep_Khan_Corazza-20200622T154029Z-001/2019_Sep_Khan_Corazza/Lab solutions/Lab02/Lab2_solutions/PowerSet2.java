package selfawarearray;
import java.util.*;

/**
 * This version of the class focuses on sets as integer arrays
 *
 */
public class PowerSet2 {
	/**
	 * Returns a List of int[]'s representing
	 * all subsets of {0,1,2,...,n-1}. For example
	 * one input {0,1,2} the method returns
	 * {
	 * 	{}
	 * 	{0},{1},{2},
	 *  {0,1}, {1,2}, {0,2},
	 *  {0,1,2}
	 * } 	
	 */
	public static List<int[]> powerset(int n){
		if(n<0) return null;
		int[] emptyset = new int[0];
		List<int[]> retVal = new ArrayList<int[]>();
		
		if(n==0) {
			retVal.add(emptyset);
			return retVal;
		}
		List<int[]> smallerSubsets = powerset(n-1);
		
		for(int[] subset : smallerSubsets) {
			int[] subset2 = adjoin(subset,n-1);
			retVal.add(subset);
			retVal.add(subset2);
		}
		return retVal;
	}
	
	private static int[] adjoin(int[] set, int k) {
		int n = set.length+1;
		int[] retVal = new int[n];
		for(int i = 0; i < set.length; ++i) {
			retVal[i]= set[i];
		}
		retVal[n-1] = k;
		return retVal;
		
	}
	public static void main(String[] args) {
		List<int[]> allsubsets = powerset(3);
		for(int[] arr : allsubsets) {
			System.out.println(Arrays.toString(arr));
		}
	}
}
