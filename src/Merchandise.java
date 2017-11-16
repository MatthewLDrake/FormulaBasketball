import java.io.Serializable;
import java.util.Random;

public class Merchandise implements Serializable
{
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
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
