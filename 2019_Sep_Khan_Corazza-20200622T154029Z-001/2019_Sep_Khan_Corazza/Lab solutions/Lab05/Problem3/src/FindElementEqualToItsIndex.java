public class FindElementEqualToItsIndex {
    public static void main(String[] args) {
        FindElementEqualToItsIndex f = new FindElementEqualToItsIndex();
        //System.out.println(f.find(new int[] {-10, -2, 0, 1, 2, 3, 4, 5, 7, 9, 10, 11}, 0, 12));
        System.out.println(f.find(new int[] {0, 1}, 0, 2));
    }

    private boolean find(int[] A, int start, int end) {
        int mid = (start + end) / 2;
        if(A[mid]==mid) {
            return true;
        }
        if(A[mid] < mid && start != end) {
            return find(A, mid + 1, end);
        }
        if(A[mid] > mid && start != end) {
            return find(A, start, mid);
        }
        return false;
    }
}
