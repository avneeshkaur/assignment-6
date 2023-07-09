import java.util.HashMap;
import java.util.Map;

public class ContiguousSubarray {
    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, -1); // Initial count of zero difference

        int maxLength = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            // Increment count by 1 for 1 and decrement by 1 for 0
            count += (nums[i] == 1 ? 1 : -1);

            if (countMap.containsKey(count)) {
                // Calculate the length of the subarray with equal 0s and 1s
                int length = i - countMap.get(count);
                maxLength = Math.max(maxLength, length);
            } else {
                countMap.put(count, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1};
        int maxLength = findMaxLength(nums);
        System.out.println(maxLength);
    }
}
