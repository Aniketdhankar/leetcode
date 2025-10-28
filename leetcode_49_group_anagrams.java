import java.util.*;
public class leetcode_49_group_anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (String word : strs) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = String.valueOf(charArray); // Converting a char array to a string

            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            map.get(sortedWord).add(word);
        }

        result.addAll(map.values());
        return result;
    }

    public static void main(String[] args) {
        leetcode_49_group_anagrams sol = new leetcode_49_group_anagrams();
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> grouped = sol.groupAnagrams(input);

        for (List<String> group : grouped) {
            System.out.println(group);
        }
    }


    
}
