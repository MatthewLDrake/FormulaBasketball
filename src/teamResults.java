import java.io.Serializable;
import java.util.ArrayList;
public class teamResults implements Comparable<teamResults>, Serializable
{
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
	private ArrayList<Integer> history;
	private teamTier tier;
	private double average;
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
		average = sum/Math.max(history.size(), 5);
		if(average > 22)tier = teamTier.BOTTOMFEEDER;
		else if(average > 10)tier = teamTier.MIDRANGE;
		else tier = teamTier.ELITE;
	}
	public double getAverage()
	{
		return average;
	}
	public void setTeamTier(teamTier teamTier)
	{
		tier = teamTier;
	}
	public teamTier getTeamTier()
	{
		return tier;
	}
	@Override
	public int compareTo(teamResults o)
	{
		return tier.compareTo(o.getTeamTier());
	}
}
