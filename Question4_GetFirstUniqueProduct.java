import java.util.*;
public class FindUniqueProduct {

    public static String GetFirstUniqueProduct(String[] products) {
        Map<String, Integer> countMap = new LinkedHashMap<>();

        // Count occurrences
        for (String product : products) {
            countMap.put(product, countMap.getOrDefault(product, 0) + 1);
        }

        // Find the first product with count == 1
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return null; 
    }

    public static void main(String[] args) {
        String[] input = { "Apple", "Computer", "Apple", "Bag" };
        System.out.println(GetFirstUniqueProduct(input));  // Output: "Computer"

        String[] input2 = { "Phone", "Phone", "Laptop", "Laptop" };
        System.out.println(GetFirstUniqueProduct(input2));  // Output: null
    }
}
