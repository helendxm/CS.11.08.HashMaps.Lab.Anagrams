import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.util.*;

public class AnagramSolver {
    private AnagramSolver() {};

    /**
     * Input: name of text file (containing English words).
     * Output: a hashmap of lists of words that are anagrams.
     * @param filename
     * @return
     */
    public static HashMap<String, ArrayList<String>> anagrams(String filename) throws FileNotFoundException {
        HashMap<String, ArrayList<String>> anagramsHash = new HashMap<>();
        Scanner scanner = new Scanner(new File(filename));
        while (scanner.hasNextLine()){
            String currentLine = scanner.nextLine().trim();
            String sortedWord = sortString(currentLine);

            //check sorted word already exists
            ArrayList<String> anagramsList;
            anagramsList = anagramsHash.get(sortedWord);

            if (anagramsList == null){
                anagramsList = new ArrayList<>();
            }
            anagramsList.add(currentLine);
            anagramsHash.put(sortedWord, anagramsList);
        }

        scanner.close();
        return anagramsHash;
    }

    public static String sortString(String original){
        char[] temp = original.toCharArray();
        Arrays.sort(temp);
        String sorted = new String(temp);
        return sorted;
    }

//    public static void main(String[] args) throws FileNotFoundException {
//        HashMap<String,ArrayList<String>> anagramHash;
//        anagramHash = anagrams("src/main/resources/simpler.txt");
//        System.out.println(anagramHash);
//
//        ArrayList<String> mostFreq = new ArrayList<>();
//        mostFreq = mostFrequentAnagram(anagramHash);
//        System.out.println(mostFreq);
//        printKeyValuePairs(anagramHash);
//    }

    /**
     * Input: hashmap of lists of words that are anagrams.
     * Output: largest list of words in hashmap that are anagrams.
     * @param anagrams
     * @return
     */
    public static ArrayList<String> mostFrequentAnagram(HashMap<String, ArrayList<String>> anagrams) {
        ArrayList<String> mostFrequent = new ArrayList<>();
        for (ArrayList<String> anagramList : anagrams.values()){
            if (anagramList.size() > mostFrequent.size()){
                mostFrequent = anagramList;
            }
        }
        return mostFrequent;
    }

    /**
     * Input: hashmap of lists of words that are anagrams.
     * Output: prints all key value pairs in the hashmap.
     * @param anagrams
     */
    public static void printKeyValuePairs(HashMap<String, ArrayList<String>> anagrams) {
        for (Map.Entry<String, ArrayList<String>> entry : anagrams.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
