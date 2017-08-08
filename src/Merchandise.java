import java.util.Random;

public class Merchandise
{
	private int weeklyRevenue;
	public Merchandise()
	{
		Random r = new Random();
		weeklyRevenue = r.nextInt(100000)+1950000;
	}
	public int getWeeklyRevenue()
	{
		return weeklyRevenue;
	}
}
