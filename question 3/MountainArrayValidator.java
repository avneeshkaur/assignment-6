public class MountainArrayValidator {
    public static boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }

        int i = 0;

        // Check if the array is increasing
        while (i < arr.length - 1 && arr[i] < arr[i + 1]) {
            i++;
        }

        // Check if the peak is not at the beginning or end of the array
        if (i == 0 || i == arr.length - 1) {
            return false;
        }

        // Check if the array is decreasing
        while (i < arr.length - 1 && arr[i] > arr[i + 1]) {
            i++;
        }

        // If i reaches the end of the array, it is a valid mountain array
        return i == arr.length - 1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1};
        boolean isValidMountainArray = validMountainArray(arr);
        System.out.println(isValidMountainArray);
    }
}
