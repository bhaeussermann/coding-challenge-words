package challenges.words.tokens;

import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordTokenizer implements Iterable<WordToken>
{
	private static final Pattern wordPattern = Pattern.compile("[A-Za-z]([^ ]*[A-Za-z])?");
	
	private String input;
	
	public WordTokenizer(String input)
	{
		this.input = input;
	}

	@Override
	public Iterator<WordToken> iterator()
	{
		return new WordIterator();
	}
	
	
	private class WordIterator implements Iterator<WordToken>
	{
		private Matcher matcher;
		private MatchResult nextMatch;
		
		public WordIterator()
		{
			matcher = wordPattern.matcher(input);
			if (matcher.find())
				nextMatch = matcher.toMatchResult();
		}
		
		@Override
		public boolean hasNext()
		{
			return nextMatch != null;
		}

		@Override
		public WordToken next()
		{
			MatchResult match = nextMatch;
			
			nextMatch = matcher.find() ? matcher.toMatchResult() : null;
			
			return new WordToken(match.group(), match.start());
		}	
	}
}
