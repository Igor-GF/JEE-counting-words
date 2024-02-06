package nl.igf.tekst;

import java.util.*;

public class WordFrequencyData implements WordFrequencyAnalyzer {
    private final List<SingleWordFrequency> lijst = new ArrayList<>();

    @Override
    public int calculateHighestFrequency(String tekst) {
        setFrequencyList(tekst);

        return lijst.stream()
                .mapToInt(SingleWordFrequency::getFrequency)
                .reduce(0, Math::max);
    }

    @Override
    public int calculateFrequencyForWord(String tekst, String woord) {
        setFrequencyList(tekst);
        int frequency = 0;

        for (SingleWordFrequency wf : lijst) {
            if (woord.equals(wf.getWord())) {
                frequency = wf.getFrequency();
                break;
            };
        }
        return frequency;
    }

    @Override
    public List<WordFrequency> calculateMostFrequentNWords(String tekst, int aantal) {
        setFrequencyList(tekst);

        return lijst.stream()
                .sorted(Comparator
                        .comparingInt(WordFrequency::getFrequency).reversed()
                        .thenComparing(WordFrequency::getWord))
                .limit(aantal)
                .map(wf -> (WordFrequency) wf)// only for casting
                .toList();
    }

    private void setFrequencyList(String tekst) {
        ArrayList<String> woorden = createListFromText(tekst);
        Map<String, Integer> freqMap = new HashMap<>();

        // get a list of unique words
        woorden.forEach(w -> freqMap.put(w, Collections.frequency(woorden, w)));

        // add to lijst field
        lijst.clear();
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            lijst.add(new SingleWordFrequency(
                    entry.getKey(),
                    entry.getValue()
            ));
        }
    }

    private ArrayList<String> createListFromText(String tekst) {
        String[] woordenArray = tekst.toLowerCase().trim().split("[^a-z]+");
        ArrayList<String> woordenLijst = new ArrayList<>();

        woordenLijst.addAll(Arrays.asList(woordenArray));
        return woordenLijst;
    }
}
