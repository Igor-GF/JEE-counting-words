package nl.igf.service;

import nl.igf.model.WordFrequencyImpl;
import nl.igf.text.*;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class WordFrequencyService implements WordFrequencyAnalyzer {
    private TreeSet<WordFrequencyImpl> wordFrequencySet;

    @Override
    public int calculateHighestFrequency(String text) {
        makeTreeSet(text);

        // get first wordFrequency from the sorted TreeSet
        return wordFrequencySet.first().getFrequency();
    }

    @Override
    public int calculateFrequencyForWord(String text, String word) {
        makeTreeSet(text);

        return wordFrequencySet.stream()
                .filter(wf -> wf.getWord().equals(word))
                .mapToInt(WordFrequencyImpl::getFrequency)
                .findFirst()
                .orElse(0);
    }

    @Override
    public List<WordFrequency> calculateMostFrequentNWords(String text, int numberOfWords) {
        makeTreeSet(text);

        // since wordFrequencies is sorted we can return the first n elements
        return wordFrequencySet.stream()
                .limit(numberOfWords)
                .collect(Collectors.toList());
    }

    private void makeTreeSet(String text) {
        ArrayList<String> words = createListFromText(text);

        wordFrequencySet = new TreeSet<>();
        words.forEach(w -> wordFrequencySet.add(new WordFrequencyImpl(w, Collections.frequency(words, w))));
        wordFrequencySet = (TreeSet<WordFrequencyImpl>) wordFrequencySet.descendingSet();
    }

    private ArrayList<String> createListFromText(String text) {
        String[] wordArray = text.toLowerCase().trim().split("[^a-z]+");
        return new ArrayList<>(Arrays.asList(wordArray));
    }
}
