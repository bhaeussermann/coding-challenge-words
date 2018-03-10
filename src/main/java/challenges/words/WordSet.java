package challenges.words;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class WordSet
{
	private Map<String, Word> words = new HashMap<>();
	
	public Collection<Word> getWords()
	{
		return words.values();
	}
	
	public void registerWord(String text, int wordIndex)
	{
		String stemmedText = WordHelper.getStem(text);
		
		Word word = words.get(stemmedText);
		if (word == null)
		{
			word = new Word(stemmedText);
			words.put(stemmedText, word);
		}
		
		word.addSentenceIndex(wordIndex);
	}
}
