import java.util.*;

public class Question6_GetThreeCommonWords{

    public static List<String> GetThreeCommonWords(String sentence) {
        // convert to lowercase and split words
        String[] words = sentence.toLowerCase().split("\\s+");

        // Count frequency of each word
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        for (String word : words) {
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }

        // Create a list from the map's entry set and sort it by frequency (descending)
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordFrequencyMap.entrySet());
        wordList.sort((entry1, entry2) -> {
            int frequency = Integer.compare(entry2.getValue(), entry1.getValue());
            return frequency != 0 ? frequency : entry1.getKey().compareTo(entry2.getKey());
        });

        // Select the top 3 words
        List<String> topThreeWords = new ArrayList<>();
        for (int i = 0; i < Math.min(3, wordList.size()); i++) {
            topThreeWords.add(wordList.get(i).getKey());
        }

        //Sort the result alphabetically 
        Collections.sort(topThreeWords);
        return topThreeWords;
    }

    //Test
    public static void main(String[] args) {
        String sentence = "hi there care to discuss algorithm basis or how to solve algorithm or";
        List<String> result = GetThreeCommonWords(sentence);
        System.out.println("Top 3 common words: " + result); 
        // Result : [algorithm, or, to]
    }
}
