import java.util.*;

public class TransformedArray {
    public static int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) {
            return new int[0];
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> original = new ArrayList<>();

        
        for (int num : changed) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

       
        Arrays.sort(changed);

        // Traverse the sorted array and construct the original array
        for (int num : changed) {
            if (countMap.get(num) > 0) {
                if (countMap.containsKey(num * 2) && countMap.get(num * 2) > 0) {
                    original.add(num);
                    countMap.put(num, countMap.get(num) - 1);
                    countMap.put(num * 2, countMap.get(num * 2) - 1);
                } else {
                    return new int[0]; 
                }
            }
        }

        int[] result = new int[original.size()];
        for (int i = 0; i < original.size(); i++) {
            result[i] = original.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] changed = {1, 3, 4, 2, 6, 8};
        int[] original = findOriginalArray(changed);
        System.out.println(Arrays.toString(original));
    }
}
