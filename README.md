# Coding Challenge: Words Tokenizer

This repository implements the challenge described below.

## Challenge Description

Take this paragraph of text and return an alphabetized list of ALL unique words. A unique word is any form of a word often communicated with essentially the same meaning. For example, dish and dishes could be defined as a unique word by using their stem dish. For each unique word found in this entire paragraph, determine the how many times the word appears in total. Also, provide an analysis of what sentence index position or positions the word is found. The following words should not be included in your analysis or result set: "a", "the", "and", "of", "in", "be", "also" and "as"! Your final result **MUST** be displayed in a readable console output in the same format as the JSON sample object shown below.

### Sample Output

Ensure that the output of your code generates an output in the following format:

```
{
	"results":[
		{
			"word":"all",
			"total-occurrences":1,
			"sentence-indexes":[0]
		},
		{
			"word":"alphabetized",
			"total-occurrences":1,
			"sentence-indexes":[0]
		},
		{
			"word":"analysis",
			"total-occurrences":1,
			"sentence-indexes":[4]
		},
		...
	]
}
```

## Building & Running

To build the application, ensure you have the Java JDK installed, as well as Maven. Then run the following command:

```mvn clean package```

And to run the application with the sample input, run

```java -jar target/words-0.0.1.jar sample.txt```
