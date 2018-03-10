package challenges.words;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class WordHelperTest extends TestCase
{
	public static Test suite()
	{
		return new TestSuite(WordHelperTest.class);
	}
	
	public void testWordStem()
	{
		assertEquals("dish", WordHelper.getStem("dish"));
		assertEquals("dish", WordHelper.getStem("dishes"));
		assertEquals("sample", WordHelper.getStem("Samples"));
		assertEquals("occurrence", WordHelper.getStem("occurrences"));
		assertEquals("analysis", WordHelper.getStem("analysis"));
	}
}
