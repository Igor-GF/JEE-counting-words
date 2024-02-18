package nl.igf.controller;

import nl.igf.service.WordFrequencyService;
import nl.igf.text.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WordFrequencyController {
    @Autowired
    private WordFrequencyService wordFrequencyService;

    @GetMapping("/highest-frequency")
    public ResponseEntity<Integer> calculateHighestFrequency(@RequestParam String text) {
        return new ResponseEntity<>(
                this.wordFrequencyService.calculateHighestFrequency(text),
                HttpStatus.OK
        );
    }

    @GetMapping("/frequency-for-word")
    public ResponseEntity<Integer> calculateFrequencyForWord(
        @RequestParam String text, @RequestParam String word
    ) {
        return new ResponseEntity<>(
                this.wordFrequencyService.calculateFrequencyForWord(text, word),
                HttpStatus.OK
        );
    }

    @GetMapping("/most-frequent-words")
    public ResponseEntity<List<WordFrequency>> calculateMostFrequentNWords(
        @RequestParam String text, @RequestParam int numberOfWords
    ) {
        return new ResponseEntity<> (
                this.wordFrequencyService.calculateMostFrequentNWords(text, numberOfWords),
                HttpStatus.OK
        );
    }
}
