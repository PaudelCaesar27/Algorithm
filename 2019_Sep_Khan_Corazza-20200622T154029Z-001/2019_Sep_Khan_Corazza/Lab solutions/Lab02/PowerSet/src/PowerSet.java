import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static void main(String[] args) {
        int [] myArr = {1, 2, 3};
        PowerSet ps = new PowerSet();
        System.out.println(ps.powerSet(myArr));
    }

    public List powerSet (int[] X) {
        int size = X.length;
        List<Integer>[] p = new ArrayList[(int)Math.pow(2, size)];
        int [] s;
        int [] t;
        int firstElement = 0;
        while (firstElement < X.length) {
            int f = X[firstElement++];
            for(ArrayList<Integer>[] x : p) {

            }
        }

    }
}
