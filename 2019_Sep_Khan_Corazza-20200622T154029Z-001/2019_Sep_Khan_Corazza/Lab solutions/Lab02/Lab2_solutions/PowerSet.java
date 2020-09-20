package knapsack;
import java.util.*;


public class PowerSet {
	
	public static <T> List<Set<T>> powerSet(List<T> X) {
		List<Set<T>> P = new ArrayList<Set<T>>();
		Set<T> S = new HashSet<T>();
		P.add(S);
		if(X.isEmpty()) {
			return P;
		}
		else {
			while(!X.isEmpty()) {
				T f = X.remove(0);
				List<Set<T>> temp = new ArrayList<Set<T>>();
				for(Set<T> x : P) {			
					temp.add(x);
				}
				for(Set<T> x : temp) {
					S = new HashSet<T>();
					S.add(f);
					S.addAll(x);
					P.add(S);					
				}					
			}			
		}
		return P;	
	}
}
