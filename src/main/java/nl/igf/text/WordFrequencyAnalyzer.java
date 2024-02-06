package nl.igf.text;

import java.util.List;

public interface WordFrequencyAnalyzer {

    // returns the highest frequency in the text
    int calculateHighestFrequency(String tekst);

    // returns the frequency of the specified word
    int calculateFrequencyForWord(String tekst, String woord);

    // returns n most frequent words in lower case -> alphabetical order
    List<WordFrequency> calculateMostFrequentNWords (String tekst, int n);
}
