import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class gameWriter
{
	private PrintWriter writer;
	public ArrayList<String> listOfStrings;
	private int gameNum;
	public gameWriter(int gameNum)
	{
		this.gameNum = gameNum;
		listOfStrings = new ArrayList<String>();
	}
	public void writeLines()
	{
		try
		{
			writer = new PrintWriter("Game " + gameNum + ".txt", "UTF-8");
		} 
		catch (FileNotFoundException e)
		{
			return;
		} 
		catch (UnsupportedEncodingException e)
		{
			return;
		}
		for(String s: listOfStrings)
		{
			writer.println(s);
		}
		writer.close();
		
	}
}
