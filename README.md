# Counting Words App (Version 2 JEE)
The App is aimed to split a given text into words, also excluding all symbols, spaces, and numbers from the text. 
The words are converted to low case so that their frequency can be counted no matter of the case of the characters (case insensitive).
Every other character, besides letters, are not considered as part of a word but as separators.

Link to version 1 (Java): https://github.com/Igor-GF/Counting-words

## Technologies
- Java Spring
- Maven

## How to test the app
Execute the CountingWordsMain, and Spring will serve at http://localhost:8080
Using a web API application tester, such as Insomnia or Postman, you can test the following endpoints:

/api/highest-frequency
    - Query parameter: text (expect a text as value)

/api/most-frequent-words
    - Query parameter: text (expect a text as value)
    - Query parameter: word (expect a word as value)

/api/frequency-for-word
    - Query parameter: text (expect a text as value)
    - Query parameter: numberOfWords (expect a number as value)

## author
[Igor Figueiredo](https://github.com/Igor-GF)

## Project status
... assessment.

## License
[MIT](https://choosealicense.com/licenses/mit/)