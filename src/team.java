import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class team implements Serializable, Comparable<team>
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int losses = 0;
    private Coach coach;
    private ArrayList<player> players;
    private String teamName;
    private int[] playersPerPos;
    private int wins, pointsScored, pointsAgainst;
    private int divisionRank, conferenceRank, leagueRank, teamNum, divisionWins, conferenceWins, divisionLosses, conferenceLosses;
    private Queue<Integer> lastGames;
    private Stadium stadium;
    private teamResults teamResults;
    private int fianance;
    private Expenses expenses;
    private Trainer trainer;
    private double sponserMoney;
    private double currentSponsers;
    public team(String teamName)
    {
	coach = null;
	this.teamName = teamName;
	players = new ArrayList<player>();
	playersPerPos = new int[5];
	wins = 0;
	pointsScored = 0;
	pointsAgainst = 0;
	lastGames = new LinkedList<Integer>();
	
	fianance = 50000000;
    }
    public void setSponserMoney(double money)
    {
	sponserMoney = money;
    }
    public void addSponsers(double[] arr)
    {
	expenses.setSponsers(arr);
    }
    public void setExpenses(double[] arr)
    {
	expenses = new Expenses(arr);
    }
    public int getFianances()
    {
	return fianance;
    }
    public void setFianances(int money)
    {
	fianance += money;
    }
    public teamResults getTeamResults()
    {
	return teamResults;
    }
    public void setTeamResults(teamResults results)
    {
	teamResults = results;
    }
    public void createStadium(float[] arr)
    {
	stadium = new Stadium(arr);
    }
    public Stadium getStadium()
    {
	return stadium;
    }
    public void addCoach(Coach coach)
    {
	this.coach = coach;
    }
    public Coach getCoach()
    {
	return coach;
    }
    public void addPlayer(player newPlayer)
    {
	players.add(newPlayer);
	addPos(newPlayer.getPosition()-1);
    }
    public player getPlayer(int playerNum)
    {
	return players.get(playerNum);
    }
    public void removePlayer(int playerNum)
    {
	players.remove(playerNum);
    }
    public ArrayList<player> getAllPlayer()
    {
	return players;
    }
    public String toString()
    {
	return teamName;
    }
    public int getSize()
    {
	return players.size();
    }
    private void addPos(int pos)
    {
	playersPerPos[pos]++;
    }
    public int getCenters()
    {
	return playersPerPos[0];
    }
    public int getPowerForwards()
    {
	return playersPerPos[1];
    }
    public int getSmallForwards()
    {
	return playersPerPos[2];
    }
    public int getShootingGuards()
    {
	return playersPerPos[3];
    }
    public int getPointGuards()
    {
	return playersPerPos[4];
    }
    public void addPoints(int i)
    {
	pointsScored = pointsScored + i;

    }
    public int getPoints()
    {
	return pointsScored;
    }
    public void addPointsAgainst(int i)
    {
	pointsAgainst = pointsAgainst + i;

    }
    public int getPointsAgainst()
    {
	return pointsAgainst;
    }
    public void addWin(int i)
    {
	wins = wins+i;
	currentSponsers += sponserMoney;
	lastThreeGames(1);
    }
    public int getWins()
    {

	return wins;
    }
    public void addDivisionWin(int i)
    {
	divisionWins = divisionWins+i;
    }
    public int getDivisionWins()
    {
	return divisionWins;
    }
    public void addConferenceWin(int i)
    {
	conferenceWins = conferenceWins+i;
    }
    public int getConferenceWins()
    {
	return conferenceWins;
    }
    public void addLoss(int i)
    {
	losses = losses+i;
	lastThreeGames(0);
    }
    public int getLosses()
    {
	return losses;
    }
    public void addDivisionLoss(int i)
    {
	divisionLosses = divisionLosses+i;
    }
    public int getDivisionLosses()
    {
	return divisionLosses;
    }
    public void addConferenceLoss(int i)
    {
	conferenceLosses = conferenceLosses+i;
    }
    public int getConferenceLosses()
    {
	return conferenceLosses;
    }
    /*
     * return codes:
     * 0: Three Losses
     * 1: Two Losses
     * 2: One Loss
     * 3: Zero Losses
     */
    public int lastThreeGames(int num)
    {
	if(num != -1)
	{
	    if(lastGames.size() == 3)lastGames.poll();
	    lastGames.add(num);
	}


	int retVal = 0;


	int temp = 0;

	for(int i = 0; i < lastGames.size(); i++)
	{
	    temp = lastGames.poll(); 
	    retVal += temp;
	    lastGames.add(temp);
	}


	return retVal;
    }
    public void setModifier(Modifier modifier)
    {
	for(int i = 0; i < players.size();i++)
	{
	    players.get(i).setShootingModifier(modifier.getShootingModifier());
	    players.get(i).setDefensiveModifier(modifier.getDefenseModifier());
	    players.get(i).setOtherModifier(modifier.getOtherModifier());
	}

    }
    public int getDivisionRank()
    {
	return divisionRank;
    }
    public void setDivisionRank(int divisionRank)
    {
	this.divisionRank = divisionRank;
    }
    public int getConferenceRank()
    {
	return conferenceRank;
    }
    public void setConferenceRank(int conferenceRank)
    {
	this.conferenceRank = conferenceRank;
    }
    public int getLeagueRank()
    {
	return leagueRank;
    }
    public void setLeagueRank(int leagueRank)
    {
	this.leagueRank = leagueRank;
    }
    @Override
    public int compareTo(team otherTeam)
    {
	if(this.wins == otherTeam.getWins())
	{
	    if(this.getPoints()-this.getPointsAgainst() == otherTeam.getPoints()-otherTeam.getPointsAgainst())
	    {
		if(this.getPoints() == otherTeam.getPoints())return this.toString().compareTo(otherTeam.toString());
		return otherTeam.getPoints()-this.getPoints();
	    }
	    return (otherTeam.getPoints()-otherTeam.getPointsAgainst()) - (this.getPoints()-this.getPointsAgainst());
	}
	return otherTeam.getWins()-this.wins;
    }
    public void setTeamNum(int i)
    {
	teamNum = i;

    }
    public int getTeamNum()
    {
	return teamNum;
    }
    public void addModifier(Modifier modifier)
    {
	for(int i = 0; i < players.size();i++)
	{
	    players.get(i).addShootingModifier(modifier.getShootingModifier());
	    players.get(i).addDefensiveModifier(modifier.getDefenseModifier());
	    players.get(i).addOtherModifier(modifier.getOtherModifier());
	}

    }
    public int getDivision()
    {
	if(teamNum < 8)return 1;
	else if (teamNum < 16)return 2;
	else if(teamNum < 24)return 3;
	else return 4;

    }
    private player[] presets = null;
    public void setPresets(player[] presets)
    {
	this.presets = presets;
    }
    public player[] getPresets()
    {
	return presets;
    }
    public Modifier getCoachModifier()
    {
	double offense = 0, defense = 0;
	Random r = new Random();
	int offenseNum = r.nextInt(100);
	if(offenseNum < coach.getOffenseModifierProbability())
	{
	    offense = coach.getOffenseModifier();
	}
	int defenseNum = r.nextInt(100);

	if(defenseNum < coach.getDefenseModifierProbability())
	{
	    defense = coach.getDefenseModifier();
	}

	return new changeAbleModifier(offense, defense);
    }
    public void doExpenses()
    {
	fianance = expenses.chargeExpenses(fianance, currentSponsers);
	currentSponsers = 0;

    }
    public void addTrainer(Trainer trainer)
    {
	this.trainer = trainer;

    }
    public Trainer getTrainer()
    {
	return trainer;
    }
    public void homeGameOccurred()
    {
	fianance = expenses.homeGameOccurred(fianance);
	
    }
    public void setWeeklySponser(int i)
    {
	expenses.setWeeklySponser(i);
	
    }
}
