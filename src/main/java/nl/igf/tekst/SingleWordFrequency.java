package nl.igf.tekst;

import jdk.jfr.DataAmount;

@Data
public final class SingleWordFrequency implements WordFrequency {
    private String word;
    private int frequency;

    public SingleWordFrequency(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    public String getWord() {
        return word;
    }

    public int getFrequency() {
        return frequency;
    }

    @Override
    public String toString() {
        return "{ \"" + word + "\", " + frequency + " }";
    }
}
