package nl.igf.model;

import lombok.Value;
import nl.igf.text.WordFrequency;

@Value
public class WordFrequencyImpl implements WordFrequency, Comparable<WordFrequencyImpl> {
    String word;
    int frequency;

    /**
     * implement compareTo method to prevent duplicate words in the treeSet
     * and to keep the treeSet ordered by frequency (first) and alphabetical order (second)
     * @param that object to compare to
     * @return -1 if this wordFrequency is 'smaller' than "that"
     *          0 if this wordFrequency has the same word as "that"
     *          1 if this wordFrequency is 'greater' than "that"
     */

    @Override
    public int compareTo(WordFrequencyImpl that) {
        //if the words are equal we must return 0 to prevent duplicate words in the set
        if (this.getWord().equals(that.getWord())) return 0;

        //if two words have the same frequency, use reverse alphabetical order
        if (this.getFrequency() == that.getFrequency()) return that.getWord().compareTo(this.getWord());

        //compare based on frequency
        return this.getFrequency() < that.getFrequency() ? -1 : 1;
    }

    @Override
    public String toString() {
        return "{ \"" + word + "\", " + frequency + " }";
    }
}
