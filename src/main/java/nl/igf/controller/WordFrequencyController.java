package nl.igf.controller;

import nl.igf.service.WordFrequencyService;
import nl.igf.text.*;
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
    private WordFrequencyService wordFrequencyService;

    @GetMapping("/highest-frequency")
    public ResponseEntity<Integer> calculateHighestFrequency(@RequestParam String tekst) {
        return new ResponseEntity<>(
                this.wordFrequencyService.calculateHighestFrequency(tekst),
                HttpStatus.OK
        );
    }

    @GetMapping("/frequency-for-word")
    public ResponseEntity<Integer> calculateFrequencyForWord(
        @RequestParam String tekst, @RequestParam String woord
    ) {
        return new ResponseEntity<>(
                this.wordFrequencyService.calculateFrequencyForWord(tekst, woord),
                HttpStatus.OK
        );
    }

    @GetMapping("/most-frequent-words")
    public ResponseEntity<List<WordFrequency>> calculateMostFrequentNWords(
        @RequestParam String tekst, @RequestParam int aantal
    ) {
        return new ResponseEntity<> (
                this.wordFrequencyService.calculateMostFrequentNWords(tekst, aantal),
                HttpStatus.OK
        );
    }
}
