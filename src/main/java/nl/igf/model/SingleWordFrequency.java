package nl.igf.model;

import lombok.Value;
import nl.igf.text.WordFrequency;

@Value
public class SingleWordFrequency implements WordFrequency {
    String word;
    int frequency;

    @Override
    public String toString() {
        return "{ \"" + word + "\", " + frequency + " }";
    }
}
