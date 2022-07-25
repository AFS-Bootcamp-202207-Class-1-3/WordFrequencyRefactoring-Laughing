import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class WordFrequencyGame {
    public String calculateWordFrequency(String inputStr) {


        if (inputStr.split("\\s+").length == 1) {
            return inputStr + " 1";
        } else {

            try {

                //split the input string with 1 to n pieces of spaces
                String[] words = inputStr.split("\\s+");

                Map<String, Integer> mapWordAndFrequency = getWordAndFrequencyMap(words);

                List<WordFrequency> wordList = new ArrayList<>();

                for (Map.Entry<String, Integer> entryWordAndFrequency : mapWordAndFrequency.entrySet()) {
                    wordList.add(new WordFrequency(entryWordAndFrequency.getKey(), entryWordAndFrequency.getValue()));
                }

                wordList.sort((word1, word2) -> word2.getWordCount() - word1.getWordCount());

                StringJoiner joiner = new StringJoiner("\n");
                for (WordFrequency wordFrequency : wordList) {
                    String s = wordFrequency.getValue() + " " + wordFrequency.getWordCount();
                    joiner.add(s);
                }
                return joiner.toString();
            } catch (Exception e) {


                return "Calculate Error";
            }
        }
    }



    private Map<String,Integer> getWordAndFrequencyMap(String[]  wordList) {
        Map<String,Integer> WordAndFrequencyMap=new HashMap<>();
       for(String word:wordList){
           int count= WordAndFrequencyMap.getOrDefault(word, 0);
           WordAndFrequencyMap.put(word,count+1);
       }
       return WordAndFrequencyMap;
    }


}
