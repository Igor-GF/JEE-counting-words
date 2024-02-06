package nl.igf.controller;

import nl.igf.tekst.WordFrequency;
import nl.igf.tekst.WordFrequencyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WordFrequencyController {
    @Autowired
    private WordFrequencyData wordFrequencyData;

    @GetMapping("/highest-frequency")
    public ResponseEntity<Integer> calculateHighestFrequency(@RequestParam String text) {
        return new ResponseEntity<>(
                this.wordFrequencyData.calculateHighestFrequency(text),
                HttpStatus.OK
        );
    }

    @GetMapping("/frequency-for-word")
    public ResponseEntity<Integer> calculateFrequencyForWord(
        @RequestParam String tekst, @RequestParam String woord
    ) {
        return new ResponseEntity<>(
                this.wordFrequencyData.calculateFrequencyForWord(tekst, woord),
                HttpStatus.OK
        );
    }

    @GetMapping("/most-frequent-words")
    public ResponseEntity<List<WordFrequency>> calculateMostFrequentNWords(
        @RequestParam String tekst, @RequestParam int aantal
    ) {
        return new ResponseEntity<> (
                this.wordFrequencyData.calculateMostFrequentNWords(tekst, aantal),
                HttpStatus.OK
        );
    }
}
