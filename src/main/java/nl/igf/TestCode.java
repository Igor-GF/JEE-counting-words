package nl.igf;

import nl.igf.tekst.*;
import java.util.List;

public class TestCode {

    public static void testWithDummyData() {
        String tekst = """
                    Ordina understands the power of disruptive digital technologies /and cooperation in a digital ecosystems. 
                    And we can #put ourselves in ** our customers’ shoes and in their digital and business and world. 
                """;

        WordFrequencyData count = new WordFrequencyData();
        int hf = count.calculateHighestFrequency(tekst);
        int wf = count.calculateFrequencyForWord(tekst, "digital");
        List<WordFrequency> sortedList = count.calculateMostFrequentNWords(tekst, 4);

        System.out.println("Method: Highest frequency: " + hf);
        System.out.println("Method: Frequency for a word: " + wf);
        System.out.println("Method: The most frequent words: ");
        sortedList.forEach(System.out::println);
    }
}
