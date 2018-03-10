package challenges.words;

import java.util.ArrayList;
import java.util.List;

public class Word implements Comparable<Word>
{
	private String word;
	private int totalOccurrences;
	private List<Integer> sentenceIndexes = new ArrayList<>();
	
	public Word(String word)
	{
		this.word = word;
	}
	
	public String getWord()
	{
		return word;
	}
	
	public int getTotalOccurrences()
	{
		return totalOccurrences;
	}
	
	public void addSentenceIndex(int sentenceIndex)
	{
		sentenceIndexes.add(sentenceIndex);
		totalOccurrences = sentenceIndexes.size();
	}
	
	public List<Integer> getSentenceIndexes()
	{
		return sentenceIndexes;
	}

	@Override
	public int compareTo(Word other)
	{
		return word.compareTo(other.word);
	}
}
