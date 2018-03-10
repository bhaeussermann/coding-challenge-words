package challenges.words.tokens;

public class WordToken
{
	private String word;
	private int index;
	
	public WordToken(String word, int index)
	{
		this.word = word;
		this.index = index;
	}
	
	public String getWord()
	{
		return word;
	}
	
	public int getIndex()
	{
		return index;
	}
}
