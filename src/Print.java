import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Print
{
    private PrintWriter writer;
    private ArrayList<team> teams; 
    public Print(ArrayList<team> teams)
    {
	this.teams = teams;
	
    }
    public void printAllTeams()
    {
	for(int i  = 0; i < teams.size(); i++)
	{
	    try
		{
		    writer = new PrintWriter(teams.get(i).toString() + ".csv", "UTF-8");
		}
		catch (FileNotFoundException e)
		{
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		catch (UnsupportedEncodingException e)
		{
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    ArrayList<player> players = teams.get(i).getAllPlayer();
	    writer.println("Player,Position,Layup,Dunk,Jumpshot,Pass,ShotContest,DefenseIQ,Jumping,Seperation,Staminia");
	    for(int j = 0; j < players.size(); j++)
	    {
		writer.println(players.get(j).getName() + "," + players.get(j).getPosition() + "," + players.get(j).getLayupRating() + "," + players.get(j).getDunkRating() + "," + players.get(j).getJumpShotRating() + "," + players.get(j).getPassing() + "," + players.get(j).getShotContestRating() + "," + players.get(j).getDefenseIQRating() + "," + players.get(j).getJumpingRating() + "," + players.get(j).getSeperation() + "," + players.get(j).getStaminaRating());
	    }
	    writer.close();
	}
	
    }
}
