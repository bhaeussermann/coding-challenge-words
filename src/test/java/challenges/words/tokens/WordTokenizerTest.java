package challenges.words.tokens;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import challenges.words.tokens.WordToken;
import challenges.words.tokens.WordTokenizer;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junitx.framework.ArrayAssert;

public class WordTokenizerTest extends TestCase
{
	public static Test suite()
	{
		return new TestSuite(WordTokenizerTest.class);
	}
	
	public void test() throws IOException
	{
		String input = "This is some text with some words-joined-by-dashes, and quoted words such as \"the\", and \"and\".";

		List<WordToken> words = new ArrayList<>();
		for (WordToken word : new WordTokenizer(input))
			words.add(word);
		
		ArrayAssert.assertEquals(new String[] { "This", "is", "some", "text", "with", "some", "words-joined-by-dashes", "and", "quoted", "words", "such", "as", "the", "and", "and" },
				words.stream().map(t -> t.getWord()).toArray());
	}
}
