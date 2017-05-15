import java.util.Random;

public class Injury
{
	player injuredPlayer;
	public Injury(player injuredPlayer)
	{
		this.injuredPlayer = injuredPlayer;
		determineTypeOfInjury();
	}

	private void determineTypeOfInjury()
	{
		Random r = new Random();
		int type = r.nextInt(1250);
		if(type < 625)
		{
			injuredPlayer.setInjuryLength(0);
			System.out.println(injuredPlayer.getName() + " suffered a very minor injury");
		}
		else if(type < 938)
		{
			injuredPlayer.setInjuryLength(3);
			System.out.println(injuredPlayer.getName() + " suffered a minor injury");
		}
		else if(type < 1126)
		{
			injuredPlayer.setInjuryLength(12);
			System.out.println(injuredPlayer.getName() + " suffered a moderate injury");
		}
		else if(type == 1200)
		{
			injuredPlayer.setInjuryLength(Integer.MAX_VALUE);
			System.out.println(injuredPlayer.getName() + " suffered a career-ending injury");
			//System.exit(0);
		}
		else 
		{
			injuredPlayer.setInjuryLength(40);
			System.out.println(injuredPlayer.getName() + " suffered a major injury");

		}
	}
}
