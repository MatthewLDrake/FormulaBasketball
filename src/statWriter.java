import java.util.Formatter;
import java.util.Locale;

public class statWriter
{
	private String temp = "";
	public statWriter(team team)
	{
		
		StringUtils StringUtils = new StringUtils();
		temp = "POS NAME                    MIN  PTS  AST  FGA  FGM    FG%  3TA  3TM  FTA FTM   TO  STL  REB  ORB  DRB  FLS  OSA  OSM    OS%+";
		for(int k = 0; k <team.getSize(); k++)
		{
			String position = "";
			switch(team.getPlayer(k).getPosition())
			{
			case 1:
				position = "C  ";
				break;
			case 2:
				position = "PF ";
				break;
			case 3:
				position = "SF ";
				break;
			case 4:
				position = "SG ";
				break;
			case 5:
				position = "PG ";
				break;
			}
			double shootingPercentage = 0.0, opponentPercentage = 0.0;
			if(team.getPlayer(k).getGameShotsTaken() != 0)
			{

				shootingPercentage = ((double)team.getPlayer(k).getGameShotsMade()/(double)team.getPlayer(k).getGameShotsTaken())*100;
			}
			StringBuilder sb = new StringBuilder();
		    Formatter formatter = new Formatter(sb, Locale.US);
			if(team.getPlayer(k).getGameShotsAttemptedAgainst() != 0)
				opponentPercentage = ((double)team.getPlayer(k).getGameShotsMadeAgainst()/(double)team.getPlayer(k).getGameShotsAttemptedAgainst())*100;
			formatter.format(position + StringUtils.rightPad(team.getPlayer(k).getName(), 25) + "%2d   %2d   %2d   %2d   %2d   %4.1f   %2d   %2d   %2d  %2d   %2d   %2d   %2d   %2d   %2d   %2d   %2d   %2d   %3.1f+", team.getPlayer(k).getGameMinutes() , team.getPlayer(k).getGamePoints() ,team.getPlayer(k).getGameAssists() ,team.getPlayer(k).getGameShotsTaken() 
					, team.getPlayer(k).getGameShotsMade(), shootingPercentage, team.getPlayer(k).getGameThreesTaken(), team.getPlayer(k).getGameThreePointersMade(), team.getPlayer(k).getGameFreeThrowsTaken(),team.getPlayer(k).getGameFreeThrowsMade() 
					,team.getPlayer(k).getGameTurnovers(), team.getPlayer(k).getGameSteals(),team.getPlayer(k).getGameRebounds(), team.getPlayer(k).getGameOffensiveRebounds(), team.getPlayer(k).getGameDefensiveRebounds() 
					, team.getPlayer(k).getBoxScoreFouls(),team.getPlayer(k).getGameShotsAttemptedAgainst(), team.getPlayer(k).getGameShotsMadeAgainst(), 
					opponentPercentage);
			temp = temp + sb.toString();
			formatter.close();
			
			
		}
		temp = temp + team.getTeamName() + "+";
		temp = temp + "POS NAME                    MIN  PTS  AST  FGA  FGM    FG%  3TA  3TM  FTA FTM   TO  STL  REB  ORB  DRB  FLS  OSA  OSM    OS%+";
		for(int k = 0; k <team.getSize(); k++)
		{
			String position = "";
			switch(team.getPlayer(k).getPosition())
			{
			case 1:
				position = "C  ";
				break;
			case 2:
				position = "PF ";
				break;
			case 3:
				position = "SF ";
				break;
			case 4:
				position = "SG ";
				break;
			case 5:
				position = "PG ";
				break;
			}
			double shootingPercentage = 0.0, opponentPercentage = 0.0;
			if(team.getPlayer(k).getGameShotsTaken() != 0)
			{

				shootingPercentage = ((double)team.getPlayer(k).getGameShotsMade()/(double)team.getPlayer(k).getGameShotsTaken())*100;
			}
			StringBuilder sb = new StringBuilder();
		    Formatter formatter = new Formatter(sb, Locale.US);
			if(team.getPlayer(k).getGameShotsAttemptedAgainst() != 0)				
				opponentPercentage = ((double)team.getPlayer(k).getGameShotsMadeAgainst()/(double)team.getPlayer(k).getGameShotsAttemptedAgainst())*100;
			formatter.format(position + StringUtils.rightPad(team.getPlayer(k).getName(), 25) + "%2d   %2d   %2d   %2d   %2d   %4.1f   %2d   %2d   %2d  %2d   %2d   %2d   %2d   %2d   %2d   %2d   %2d   %2d   %3.1f+", team.getPlayer(k).getGameMinutes() , team.getPlayer(k).getGamePoints() ,team.getPlayer(k).getGameAssists() ,team.getPlayer(k).getGameShotsTaken() 
					, team.getPlayer(k).getGameShotsMade(), shootingPercentage, team.getPlayer(k).getGameThreesTaken(), team.getPlayer(k).getGameThreePointersMade(), team.getPlayer(k).getGameFreeThrowsTaken(),team.getPlayer(k).getGameFreeThrowsMade() 
					,team.getPlayer(k).getGameTurnovers(), team.getPlayer(k).getGameSteals(),team.getPlayer(k).getGameRebounds(), team.getPlayer(k).getGameOffensiveRebounds(), team.getPlayer(k).getGameDefensiveRebounds() 
					, team.getPlayer(k).getBoxScoreFouls(),team.getPlayer(k).getGameShotsAttemptedAgainst(), team.getPlayer(k).getGameShotsMadeAgainst(), 
					opponentPercentage);
			temp = temp + sb.toString();
			formatter.close();

			
		}
	}
	public String toString()
	{
		return temp;
	}
}
