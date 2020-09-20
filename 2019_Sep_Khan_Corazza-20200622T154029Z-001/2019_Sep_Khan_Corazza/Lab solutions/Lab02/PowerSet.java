import java.util.*;

public class PowerSet {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);


        System.out.println(powerSet(list));
    }

    private static ArrayList<Set<Integer>> powerSet(ArrayList<Integer> X) {

        ArrayList<Set<Integer>> p = new ArrayList<>();
        Set<Integer> s = new HashSet<Integer>();

        p.add(s);

        while (!X.isEmpty()) {
            int f = X.remove(0);

            ArrayList<Set<Integer>> tempList = new ArrayList<>();
            // Loop for creating temporary list from P
            //To make sure that next loop don't get stuck in infinite loop
            for (Set<Integer> setTemp : p) {
                tempList.add(setTemp);
            }
            //loop for adding sets to P
            for (Set<Integer> x : tempList) {
                Set<Integer> T = new HashSet<>();
                T.addAll(x);
                T.add(f);
                p.add(T);
            }
        }
        return p;

    }



}
