package challenges.words;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junitx.framework.ArrayAssert;

public class WordSetTest extends TestCase
{
	public static Test suite()
	{
		return new TestSuite(WordSetTest.class);
	}
	
	public void testAddWordTwice()
	{
		WordSet wordSet = new WordSet();
		wordSet.registerWord("Positions", 1);
		wordSet.registerWord("Position", 15);
		
		assertEquals(1, wordSet.getWords().size());
		Word word = wordSet.getWords().iterator().next();
		assertEquals("position", word.getWord());
		ArrayAssert.assertEquals(new Integer[] { 1, 15 }, word.getSentenceIndexes().toArray(new Integer[0]));
	}
}
