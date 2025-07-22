import java.util.*;

public class Question2_GetUniqueSums {

    public static int Combinations(int[] nums, int target) {
        Set<String> uniqueCombinations = new HashSet<>();
        GetCombinations(nums, 0, target, new ArrayList<>(), uniqueCombinations);
        return uniqueCombinations.size();
    }

    static void GetCombinations(int[] nums, int index, int remaining, List<Integer> current, Set<String> combinationsSet) {
        if (remaining == 0) {
            List<Integer> sortedCombinations = new ArrayList<>(current);
            Collections.sort(sortedCombinations);  // To treat [5,4,6] and [6,5,4] as same
            combinationsSet.add(sortedCombinations.toString());
            return;
        }

        if (remaining < 0 || index >= nums.length) return;

        // Include current number
        current.add(nums[index]);
        GetCombinations(nums, index + 1, remaining - nums[index], current, combinationsSet);
        current.remove(current.size() - 1); // backtrack

        // Exclude current number
        GetCombinations(nums, index + 1, remaining, current, combinationsSet);
    }
    //tests

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int result1 = 10;
        System.out.println("Combinations that sum up to " + result1 + ": " + Combinations(array1, result1)); // Output: 3

        int[] array2 = {1, 2, 4, 7, 5};
        int result2 = 17;
        System.out.println("Combinations that sum up to " + result2 + ": " + Combinations(array2, result2)); // Output: 1
    }
}
