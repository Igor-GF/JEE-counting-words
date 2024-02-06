package nl.igf.tekst;

import lombok.Value;

@Value
public class SingleWordFrequency implements WordFrequency {
    String word;
    int frequency;

    @Override
    public String toString() {
        return "{ \"" + word + "\", " + frequency + " }";
    }
}
