package challenges.words;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import challenges.words.tokens.WordToken;
import challenges.words.tokens.WordTokenizer;

public class App
{
	private static final String[] STOP_WORDS = new String[] { "a", "an", "the", "and", "of", "in", "be", "also", "as" };

	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		if (args.length == 0)
		{
			System.out.println("Usage: java -jar words.jar [fileName]");
			return;
		}
		
		String text;
		try (InputStream stream = new FileInputStream(args[0]))
		{
			text = readAllText(stream);
		}

		WordSet wordSet = new WordSet();
		for (WordToken wordToken : new WordTokenizer(text))
			if (!isStopWord(wordToken.getWord()))
				wordSet.registerWord(wordToken.getWord(), wordToken.getIndex());
		
		List<Word> sortedWords = new ArrayList<>(wordSet.getWords());
		Collections.sort(sortedWords);
		Result result = new Result(sortedWords);
		
		System.out.println(toJson(result));
	}
	
	private static String readAllText(InputStream stream) throws IOException
	{
		StringBuilder stringBuilder = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream)))
		{
			String line;
			while ((line = reader.readLine()) != null)
				stringBuilder.append(line);
		}
		
		return stringBuilder.toString();
	}
	
	private static boolean isStopWord(String word)
	{
		for (String stopWord : STOP_WORDS)
			if (word.equalsIgnoreCase(stopWord))
				return true;
		
		return false;
	}
	
	private static String toJson(Object object)
	{
		Pattern followedByCapitalPattern = Pattern.compile("[a-z](?=[A-Z])");
		
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.setFieldNamingStrategy(new FieldNamingStrategy()
						{
							@Override
							public String translateName(Field f)
							{
								Matcher matcher = followedByCapitalPattern.matcher(f.getName());
								String name = f.getName(); 
								for (int dashesAdded = 0; matcher.find(); dashesAdded++)
								{
									int insertIndex = matcher.end() + dashesAdded;
									name = name.substring(0, insertIndex) + '-' + Character.toLowerCase(name.charAt(insertIndex)) + name.substring(insertIndex + 1);
								}
								return name;
							}
						})
				.create();
		return gson.toJson(object);
	}
	
	
	private static class Result
	{
		private List<Word> results;
		
		public Result(Collection<Word> words)
		{
			results = new ArrayList<Word>(words);
		}
		
		@SuppressWarnings("unused")
		public List<Word> getResults()
		{
			return results;
		}
	}
}
