import java.util.ArrayList;
public class teamResults
{
	private ArrayList<Integer> history;
	private teamTier tier;
	public teamResults(int[] results)
	{
		history = new ArrayList<Integer>();
		for(int i = 0; i < results.length; i++)
		{
			history.add(results[i]);
		}
		
		int sum = 0;
		for(int i = history.size()-1; i >= Math.max(0, history.size() - 6); i--)
		{
			sum += history.get(i);
		}
		double average = sum/Math.max(history.size(), 5);
		if(average > 22)tier = teamTier.BOTTOMFEEDER;
		else if(average > 10)tier = teamTier.MIDRANGE;
		else tier = teamTier.ELITE;
	}
	public teamTier getTeamTier()
	{
		return tier;
	}
}
