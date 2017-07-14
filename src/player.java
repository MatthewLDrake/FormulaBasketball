import java.io.Serializable;

public class player implements Serializable, Comparable<player>
{
    //TODO: Add games
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private boolean isPlaying, isStarter;
    private int position, layupRating, dunkRating, jumpRating, shotContestRating, defenseIQRating, jumpingRating, seperation, passing, staminaRating, threeRating, gameFouls, durability, injuryTotal;
    private double stamina, shootingModifier, otherModifier, defensiveModifier ;
    private int[] stats, gameStats;
    private String name;
    private team team;
    private boolean isInjured;
    private int injuryLength;
    public player(int pos, int layupStat, int dunkStat, int jumpStat, int passing, int shotContest, int defenseIQ, int jumping, int seperation, int staminaRating, String first, String last, boolean starting)
    {
	setPosition(pos);
	setLayupRating(layupStat);
	setDunkRating(dunkStat);
	setJumpShotRating(jumpStat);
	
	setShotContestRating(shotContest);
	setDefenseIQRating(defenseIQ);
	setJumpingRating(jumping);
	setSeperation(seperation);
	setPassing(passing);
	setStaminaRating(staminaRating);
	isPlaying = starting;
	isStarter = starting;
	stamina = 100;
	shootingModifier = 0.0;
	otherModifier = 0.0; 
	defensiveModifier = 0.0;
	stats = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	gameStats = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	gameFouls = 0;
	name = first + " " + last;
    }
    public player(int pos, int layupStat, int dunkStat, int jumpStat,int threePoint, int passing, int shotContest, int defenseIQ, int jumping, int seperation,int durability, int staminaRating, String string, boolean starting)
    {
	setPosition(pos);
	setLayupRating(layupStat);
	setDunkRating(dunkStat);
	setJumpShotRating(jumpStat);
	setThreeShotRating(threePoint);
	setDurabilityRating(durability);
	setShotContestRating(shotContest);
	setDefenseIQRating(defenseIQ);
	setJumpingRating(jumping);
	setSeperation(seperation);
	setPassing(passing);
	setStaminaRating(staminaRating);
	isPlaying = starting;
	isStarter = starting;
	stamina = 100;
	shootingModifier = 0.0;
	otherModifier = 0.0; 
	defensiveModifier = 0.0;
	stats = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	gameStats = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	gameFouls = 0;
	name = string;
    }
    public double getStamina()
    {
	return stamina;
    }
    public void setStamina(double d)
    {
	stamina = d;
    }
    public void setStarter(boolean b)
    {
	isStarter = b;
	isPlaying = b;
    }
    public boolean isStarter()
    {
	return isStarter;
    }
    public void changeStamina(double d)
    {
	double modifier = 0;
	if(d > 0)
	{
	    modifier = 1;
	}
	else
	{

	    switch (getStaminaRating())
	    {
	    case 1:	modifier = 10;
	    break;
	    case 2: 	modifier = 5.625;	
	    break;
	    case 3:	modifier = 3.913043478;
	    break;
	    case 4:	modifier = 3;	
	    break;
	    case 5:	modifier = 2.43243243243243;
	    break;
	    case 6:	modifier = 2.04545454545455;
	    break;
	    case 7:	modifier = 1.76470588235294;
	    break;
	    case 8:	modifier = 1.55172413793103;	
	    break;
	    case 9:	modifier = 1.38461538461538;
	    break;
	    case 10:	modifier = 1.25;	
	    break;


	    }
	    //System.out.println("" + stamina + " " + modifier + " " + d + " " + getStaminaRating() +"");
	}

	stamina = stamina + (modifier *d);


	checkStamina();
    }
    private void checkStamina()
    {
	if(stamina>= 100)stamina = 100;
    }
    public int getPosition()
    {
	return position;
    }
    private void setPosition(int position)
    {
	this.position = position;
    }
    public double getLayupRating()
    {
	return (layupRating+shootingModifier)*getStamina()/100;
    }
    private void setLayupRating(int layupRating)
    {
	this.layupRating = layupRating;
    }
    public double getDunkRating()
    {
	return (dunkRating+shootingModifier)*getStamina()/100;
    }
    private void setDunkRating(int dunkRating)
    {
	this.dunkRating = dunkRating;
    }
    public double getJumpShotRating()
    {
	return (jumpRating+shootingModifier)*getStamina()/100;
    }
    private void setJumpShotRating(int jumpRating)
    {
	this.jumpRating = jumpRating;
    }
    public double getShotContestRating()
    {
	return (shotContestRating+defensiveModifier)*getStamina()/100;
    }
    private void setShotContestRating(int shotContestRating)
    {
	this.shotContestRating = shotContestRating;
    }
    public double getDefenseIQRating()
    {
	return (defenseIQRating+defensiveModifier)*getStamina()/100;
    }
    private void setDefenseIQRating(int defenseIQRating)
    {
	this.defenseIQRating = defenseIQRating;
    }
    public String getName()
    {
	return name;
    }
    public boolean isPlaying()
    {
	return isPlaying;
    }
    public void setIsPlaying(boolean b)
    {
	isPlaying = b;
    }
    public double getJumpingRating()
    {
	return (jumpingRating+otherModifier)*getStamina()/100;
    }
    private void setJumpingRating(int jumpingRating)
    {
	this.jumpingRating = jumpingRating;
    }
    public double getSeperation()
    {
	return (seperation+otherModifier)*getStamina()/100;
    }
    private void setSeperation(int seperation)
    {
	this.seperation = seperation;
    }
    public double getPassing()
    {
	return (passing+otherModifier)*getStamina()/100;
    }
    private void setPassing(int passing)
    {
	this.passing = passing;
    }
    public int getPoints()
    {
	return stats[0];
    }
    public int getGamePoints()
    {
	return gameStats[0];
    }
    public void addPoints(int p)
    {
	stats[0] += p;
	gameStats[0] += p;
    }
    public int getShotsTaken()
    {
	return stats[1];
    }
    public int getGameShotsTaken()
    {
	return gameStats[1];
    }
    public void addShotTaken(int p)
    {
	stats[1] += p;
	gameStats[1] += p;
    }
    public int getShotsMade()
    {
	return stats[2];
    }
    public int getGameShotsMade()
    {
	return gameStats[2];
    }
    public void addShotMade(int p)
    {
	stats[2] += p;
	gameStats[2] += p;
    }
    public int getAssists()
    {
	return stats[3];
    }
    public int getGameAssists()
    {
	return gameStats[3];
    }
    public void addAssists(int p)
    {
	stats[3] += p;
	gameStats[3] += p;
    }
    public int getTurnovers()
    {
	return stats[4];
    }
    public int getGameTurnovers()
    {
	return gameStats[4];
    }
    public void addTurnovers(int p)
    {
	stats[4] += p;
	gameStats[4] += p;
    }
    public int getSteals()
    {
	return stats[5];
    }
    public int getGameSteals()
    {
	return gameStats[5];
    }
    public void addSteals(int p)
    {
	stats[5] += p;
	gameStats[5] += p;
    }
    public int getMinutes()
    {
	return (int) Math.round(stats[6]/60);
    }
    public int getGameMinutes()
    {
	return (int) Math.round(gameStats[6]/60);
    }
    public void addMinutes(int p)
    {
	stats[6] += p;
	gameStats[6] += p;
    }
    public int getStaminaRating()
    {
	return staminaRating;
    }
    private void setStaminaRating(int staminaRating)
    {
	this.staminaRating = staminaRating;
    }
    public void addRebound(int i)
    {
	stats[7] += i;
	gameStats[7] += i;
    }
    public int getRebounds()
    {
	return stats[7];
    }
    public int getGameRebounds()
    {
	return gameStats[7];
    }
    public void addOffensiveRebound(int i)
    {
	stats[8] += i;
	gameStats[8] += i;

    }
    public int getOffensiveRebounds()
    {
	return stats[8];
    }
    public int getGameOffensiveRebounds()
    {
	return gameStats[8];
    }
    public void addDefensiveRebound(int i)
    {
	stats[9] += i;
	gameStats[9] += i;

    }
    public int getDefensiveRebounds()
    {
	return stats[9];
    }
    public int getGameDefensiveRebounds()
    {
	return gameStats[9];
    }
    public void addFoul(int i)
    {

	stats[10] += i;
	gameFouls += i;
	if(gameFouls == 6)System.out.println("tf");
    }
    public int getFouls()
    {
	return stats[10];
    }
    public void resetGame()
    {
	gameFouls = 0;
	if(injuryLength == 0)isInjured = false;
    }
    public int getBoxScoreFouls()
    {
	return gameStats[10];
    }
    public int getGameFouls()
    {
	gameStats[10] = gameFouls;
	return gameFouls;
    }
    public void setShootingModifier(double d)
    {
	this.shootingModifier = d;
    }
    public void setDefensiveModifier(double defenseModifier)
    {
	this.defensiveModifier = defenseModifier;

    }
    public void setOtherModifier(double otherModifier)
    {
	this.otherModifier = otherModifier;

    }
    public void addThreeTaken(int i)
    {
	stats[11] += i;
	gameStats[11] += i;

    }
    public int getThreesTaken()
    {
	return stats[11];
    }
    public int getGameThreesTaken()
    {
	return gameStats[11];
    }
    public void addFreeThrowsTaken(int i)
    {
	stats[12] += i;
	gameStats[12] += i;
    }
    public void addFreeThrowsMade(int i)
    {
	stats[13] += i;
	gameStats[13] += i;

    }
    public int getFreeThrowsTaken()
    {
	return stats[12];
    }
    public int getFreeThrowsMade()
    {
	return stats[13];
    }
    public int getGameFreeThrowsTaken()
    {
	return gameStats[12];
    }
    public int getGameFreeThrowsMade()
    {
	return gameStats[13];
    }
    public void addThreePointerMade(int i)
    {
	stats[14] += i;
	gameStats[14] += i;
    }
    public int getThreePointersMade()
    {
	return stats[14];
    }
    public int getGameThreePointersMade()
    {
	return gameStats[14];
    }
    public void addShotsAttemptedAgainst(int i)
    {
	stats[15] += i;
	gameStats[15] += i;
    }
    public int getShotsAttemptedAgainst()
    {
	return stats[15];
    }
    public int getGameShotsAttemptedAgainst()
    {
	return gameStats[15];
    }
    public void addShotsMadeAgainst(int i)
    {
	stats[16] += i;
	gameStats[16] += i;
    }
    public int getShotsMadeAgainst()
    {
	return stats[16];
    }
    public int getGameShotsMadeAgainst()
    {
	return gameStats[16];
    }
    public void resetGameStats()
    {
	gameStats = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    }
    public void setName(String newName)
    {
	name = newName;

    }
    @Override
    public int compareTo(player otherPlayer)
    {

	return this.getName().compareTo(otherPlayer.getName());
    }
    public void setTeam(team team)
    {
	this.team = team;

    }
    public team getTeam()
    {
	return team;
    }
    public int getInjuryLength()
    {
	return injuryLength;
    }
    public void setInjuryLength(int injuryLength)
    {
	this.injuryLength = injuryLength;
    }
    public boolean isInjured()
    {

	return isInjured;
    }
    public void setInjured(boolean b)
    {
	injuryTotal++;
	isInjured = b;
    }
    public int getInjuryTotal()
    {
	return injuryTotal;
    }
    public void decrementDay()
    {
	injuryLength--;

    }
    public void resetAllStats()
    {
	stats = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    }
    public void addShootingModifier(double d)
    {
	this.shootingModifier += d;
    }
    public void addDefensiveModifier(double defenseModifier)
    {
	this.defensiveModifier += defenseModifier;
	
    }
    public void addOtherModifier(double otherModifier)
    {
	this.otherModifier += otherModifier;
	
    }
    public double getThreeShotRating()
    {
	return (threeRating+shootingModifier)*getStamina()/100;
    }
    private void setThreeShotRating(int threeRating)
    {
	this.threeRating = threeRating;
    }
    public int getDurabilityRating()
    {
	return durability;
    }
    private void setDurabilityRating(int durability)
    {
	this.durability = durability;
    }
}

