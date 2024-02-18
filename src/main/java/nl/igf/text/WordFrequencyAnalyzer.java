package nl.igf.text;

import java.util.List;

public interface WordFrequencyAnalyzer {

    // returns the highest frequency in the text
    int calculateHighestFrequency(String text);

    // returns the frequency of the specified word
    int calculateFrequencyForWord(String text, String word);

    // returns n most frequent words in lower case -> alphabetical order
    List<WordFrequency> calculateMostFrequentNWords (String text, int n);
}
