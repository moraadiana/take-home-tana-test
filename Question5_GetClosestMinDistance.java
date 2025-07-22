public class Question5_GetClosestMinDistance{

    public static int GetClosestMinDistance(int[] numbers) {
        int minValue = Integer.MAX_VALUE;

        //Find the minimum value in the array
        for (int number : numbers) {
            if (number < minValue) {
                minValue = number;
            }
        }

        int previousMinimumIndex = -1;
        int smallestDistance = Integer.MAX_VALUE;

        // Find the smallest distance between two occurrences of the minimum value
        for (int currentIndex = 0; currentIndex < numbers.length; currentIndex++) {
            if (numbers[currentIndex] == minValue) {
                if (previousMinimumIndex != -1) {
                    int currentDistance = currentIndex - previousMinimumIndex;
                    smallestDistance = Math.min(smallestDistance, currentDistance);
                }
                previousMinimumIndex = currentIndex;
            }
        }

        return smallestDistance;
    }

    // Test
    public static void main(String[] args) {
        int[] numbersTest = {1, 2, 3, 1, 4, 5, 2};
        int distance = GetClosestMinDistance(numbersTest);
        System.out.println("Closest minimum distance: " + distance); // Output: 3
    }
}
