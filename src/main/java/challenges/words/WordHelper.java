package challenges.words;

import java.util.regex.Pattern;

public class WordHelper
{
	private static Pattern suffixPattern;
	
	static
	{
		suffixPattern = Pattern.compile("(?<=sh)es$|(?<![is])s$");
	}
	
	public static String getStem(String word)
	{
		return suffixPattern.matcher(word.toLowerCase()).replaceAll("");
	}
}
