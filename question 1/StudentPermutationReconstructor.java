import java.util.ArrayList;
import java.util.List;

public class StudentPermutationReconstructor {
    public static int[] findPermutation(String s) {
        int n = s.length();
        int[] perm = new int[n + 1];
        int minVal = 0;
        int maxVal = n;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                perm[i] = minVal++;
            } else {
                perm[i] = maxVal--;
            }
        }

        perm[n] = minVal; // or perm[n] = maxVal;

        return perm;
    }

    public static void main(String[] args) {
        String s = "IDID";
        int[] perm = findPermutation(s);

        // Print the reconstructed permutation
        for (int num : perm) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
