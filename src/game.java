import java.util.ArrayList;
import java.util.Random;

public class game
{
	private team awayTeam, homeTeam;
	private int awayTeamScore, homeTeamScore, staminaRegen;
	private int[] firstQuarterScore, secondQuarterScore, thirdQuarterScore, fourthQuarterScore, OTScore;
	private boolean awayTipOff;
	private player[] playingAwayTeam, playingHomeTeam;

	public game(team away, team home)
	{
		firstQuarterScore = new int[]{0,0};
		secondQuarterScore = new int[]{0,0}; 
		thirdQuarterScore = new int[]{0,0}; 
		fourthQuarterScore = new int[]{0,0};
		OTScore = new int[]{0,0};


		awayTeam = away;
		homeTeam = home;

		staminaRegen = 0;

		playingAwayTeam = new player[5];
		playingHomeTeam = new player[5];

		for(int i = 0; i<away.getSize();i++)
		{
			if(away.getPlayer(i).isPlaying())
			{
				if(away.getPlayer(i).getPosition() == 1)playingAwayTeam[0] = away.getPlayer(i);
				else if(away.getPlayer(i).getPosition() == 2)playingAwayTeam[1] = away.getPlayer(i);
				else if(away.getPlayer(i).getPosition() == 3)playingAwayTeam[2] = away.getPlayer(i);
				else if(away.getPlayer(i).getPosition() == 4)playingAwayTeam[3] = away.getPlayer(i);
				else if(away.getPlayer(i).getPosition() == 5)playingAwayTeam[4] = away.getPlayer(i);
			}

		}

		for(int i = 0; i<home.getSize();i++)
		{
			if(home.getPlayer(i).isPlaying())
			{
				if(home.getPlayer(i).getPosition() == 1)playingHomeTeam[0] = home.getPlayer(i);
				else if(home.getPlayer(i).getPosition() == 2)playingHomeTeam[1] = home.getPlayer(i);
				else if(home.getPlayer(i).getPosition() == 3)playingHomeTeam[2] = home.getPlayer(i);
				else if(home.getPlayer(i).getPosition() == 4)playingHomeTeam[3] = home.getPlayer(i);
				else if(home.getPlayer(i).getPosition() == 5)playingHomeTeam[4] = home.getPlayer(i);
			}
		}
		awayTeamScore = 0;
		homeTeamScore = 0;

		startGame();
	}
	public int[] getQuarterOneScore()
	{
		return firstQuarterScore;
	}
	public int[] getQuarterTwoScore()
	{
		return secondQuarterScore;
	}
	public int[] getQuarterThreeScore()
	{
		return thirdQuarterScore;
	}
	public int[] getQuarterFourScore()
	{
		return fourthQuarterScore;
	}
	public int[] getQuarterOTScore()
	{
		return OTScore;
	}
	private void startGame()
	{
		awayTipOff = tipOff();

		playQuarter(1, awayTipOff);
		firstQuarterScore[0] = awayTeamScore;
		firstQuarterScore[1] = homeTeamScore;
		inBetweenQuaters();
		playQuarter(2, !awayTipOff);
		secondQuarterScore[0] = awayTeamScore-firstQuarterScore[0];
		secondQuarterScore[1] = homeTeamScore-firstQuarterScore[1];
		inBetweenQuaters();
		playQuarter(3, !awayTipOff);
		thirdQuarterScore[0] = awayTeamScore-secondQuarterScore[0]-firstQuarterScore[0];
		thirdQuarterScore[1] = homeTeamScore-secondQuarterScore[1]-firstQuarterScore[1];
		inBetweenQuaters();
		playQuarter(4, awayTipOff);
		fourthQuarterScore[0] = awayTeamScore-thirdQuarterScore[0]-secondQuarterScore[0]-firstQuarterScore[0];
		fourthQuarterScore[1] = homeTeamScore-thirdQuarterScore[1]-secondQuarterScore[1]-firstQuarterScore[1];

		int OT = 5;
		while(awayTeamScore == homeTeamScore)
		{

			awayTipOff = tipOff();
			inBetweenQuaters();
			playQuarter(OT++, awayTipOff);
			//System.out.println(OT-1 + " (" + awayTeamScore + " - " + homeTeamScore + ")");
		}
		OTScore[0] = awayTeamScore-fourthQuarterScore[0]-thirdQuarterScore[0]-secondQuarterScore[0]-firstQuarterScore[0];
		OTScore[1] = homeTeamScore-fourthQuarterScore[1]-thirdQuarterScore[1]-secondQuarterScore[1]-firstQuarterScore[1];
		regenStamina();

	}
	private void regenStamina()
	{
		for(int i = 0; i < awayTeam.getSize();i++)
		{
			awayTeam.getPlayer(i).changeStamina(20);
			awayTeam.getPlayer(i).resetGameFouls();


		}
		for(int i = 0; i < homeTeam.getSize();i++)
		{
			homeTeam.getPlayer(i).changeStamina(20);
			homeTeam.getPlayer(i).resetGameFouls();
		}

	}
	private void inBetweenQuaters()
	{
		for(int i = 0; i < awayTeam.getSize();i++)
		{
			awayTeam.getPlayer(i).changeStamina(5);

		}
		for(int i = 0; i < homeTeam.getSize();i++)
		{
			homeTeam.getPlayer(i).changeStamina(5);
		}
	}
	private boolean tipOff()
	{

		double temp = playingAwayTeam[0].getJumpingRating() - playingHomeTeam[0].getJumpingRating();

		Random r = new Random();
		double temp2 = r.nextInt(10)+temp;

		return temp2 > 5;
	}
	private void playQuarter(int quarterNum, boolean awayPoss)
	{
		int timeRemaining = 720;
		while(timeRemaining > 0)
		{
			Random r = new Random();
			while(true)
			{

				int playersInPlay = r.nextInt(5)+1;
				player[] whichPlayers = new player[playersInPlay];
				ArrayList<Integer> temp = assignValues(5);
				int counter = 0;
				for(int i = whichPlayers.length;i >= 0;i--)
				{
					if(i != 0)
					{
						int temp2 = r.nextInt(temp.size());
						if(awayPoss)whichPlayers[counter++] = playingAwayTeam[temp.get(temp2)];
						else whichPlayers[counter++] =
								playingHomeTeam[temp.get(temp2)];
						temp.remove(temp2);
					}


				}
				int playResult = executePlay(whichPlayers,awayPoss);
				if(playResult == 1)
				{
					awayPoss = !awayPoss;
					break;
				}

				else if(playResult == 0)
				{
					break;
				}
				
			}
			int timePassed = r.nextInt(10)+12;
			if(timePassed > timeRemaining)timePassed = timeRemaining;
			staminaRegen += timePassed;
			timeRemaining = timeRemaining - timePassed;
			for(int i = 0; i<5;i++)
			{
				double temp1 = -60;
				playingHomeTeam[i].changeStamina(timePassed/(temp1));
				playingAwayTeam[i].changeStamina(timePassed/(temp1));
				playingHomeTeam[i].addMinutes(timePassed);
				playingAwayTeam[i].addMinutes(timePassed);
			}
			if(staminaRegen >= 60)
			{
				staminaRegen -= 60;
				for(int i = 0; i < awayTeam.getSize();i++)
				{
					if(!awayTeam.getPlayer(i).isPlaying())awayTeam.getPlayer(i).changeStamina(5);

				}
				for(int i = 0; i < homeTeam.getSize();i++)
				{
					if(!homeTeam.getPlayer(i).isPlaying())homeTeam.getPlayer(i).changeStamina(5);

				}
			}
			checkForInjuries();
			playingAwayTeam = substitutions(playingAwayTeam, awayTeam, true, quarterNum);
			playingHomeTeam = substitutions(playingHomeTeam, homeTeam, false, quarterNum);

		}
	}
	private void checkForInjuries()
	{
		Random r = new Random();
		for(int i = 0; i < playingAwayTeam.length; i++)
		{
			int injury = r.nextInt(5000);
			if(injury == 500)
			{
				new Injury(playingAwayTeam[i]);
				//System.out.println(playingAwayTeam[i].getName() + " is hurt");
			}
		}
		for(int i = 0; i < playingHomeTeam.length; i++)
		{
			int injury = r.nextInt(5000);
			if(injury == 500)
			{
				new Injury(playingHomeTeam[i]);
				//System.out.println(playingHomeTeam[i].getName() + " is hurt");
			}
		}
		
	}
	private player[] substitutions(player[] playing, team fullTeam, boolean b, int quarterNum)
	{
		player[] returnVal = playing;
		for(int i  = 0; i<playing.length;i++)
		{
			ArrayList<player> temp = new ArrayList<player>();
			double tempHolder = 0; 
			int newMember = 0;

			boolean bob = false;
			if(!playing[i].isStarter())
			{

				for(int j = 0; j<fullTeam.getSize();j++)
				{
					if(playing[i].getPosition() == fullTeam.getPlayer(j).getPosition())
					{
						if(fullTeam.getPlayer(j).isStarter())
						{

							if(fullTeam.getPlayer(j).getStamina() > 90.0 && acceptableAmountOfFouls(fullTeam.getPlayer(j),quarterNum))
							{
								bob = true;
							}
						}


					}
				}
			}

			if(playing[i].getStamina() < 65.0 || bob || !acceptableAmountOfFouls(playing[i],quarterNum))
			{
				if(bob)
				{
					//System.out.println("bob fired");
					temp = new ArrayList<player>();
					for(int j = 0; j<fullTeam.getSize();j++)
					{
						if(playing[i].getPosition() == fullTeam.getPlayer(j).getPosition() && fullTeam.getPlayer(j).isStarter())temp.add(fullTeam.getPlayer(j));
					}
				}
				else
				{		   

					temp = new ArrayList<player>();
					for(int j = 0; j<fullTeam.getSize();j++)
					{
						if(playing[i].getPosition() == fullTeam.getPlayer(j).getPosition() && !fullTeam.getPlayer(j).isPlaying() && acceptableAmountOfFouls(fullTeam.getPlayer(j), quarterNum))
						{
							temp.add(fullTeam.getPlayer(j));
						}
					}
					double[] relevantStats = new double[temp.size()];
					for(int j = 0; j<temp.size();j++)
					{
						if((b && getWinner()) || (!b && !getWinner()))
						{
							relevantStats[j] = temp.get(j).getDefenseIQRating()+ temp.get(j).getShotContestRating();
						}
						else
						{
							relevantStats[j] = temp.get(j).getDunkRating()+temp.get(j).getJumpShotRating() + temp.get(j).getLayupRating();
						}

					}

					for(int j = 0; j<temp.size();j++)
					{
						if(relevantStats[j] > tempHolder)
						{
							newMember = j;
							tempHolder = relevantStats[j];
						}
					}
				}

				if(!temp.isEmpty())
				{
					returnVal[i].setIsPlaying(false);
					returnVal[i] = temp.get(newMember);
					returnVal[i].setIsPlaying(true);
				}
			}
		}

		return returnVal;

	}
	private boolean acceptableAmountOfFouls(player player, int quarterNum)
	{
		if(quarterNum == 1)return player.getGameFouls() < 2;
		else if(quarterNum == 2)return player.getGameFouls() < 3;
		else if(quarterNum == 3)return player.getGameFouls() < 4;
		else return player.getGameFouls() < 5;
	}
	private int executePlay(player[] Players, boolean b)
	{
		boolean playIsOver = false;
		int lastPass = 0;
		while(!playIsOver)
		{
			for(int i = 0; i<Players.length-1;i++)
			{
				int temp = pass(Players[i], Players[i+1], b);
				if(temp < -6)
				{			
					if(b)
					{
						playingHomeTeam[Players[i+1].getPosition()-1].addSteals(1);
						playingHomeTeam[Players[i+1].getPosition()-1].changeStamina(-.1);
					}
					else 
					{
						playingAwayTeam[Players[i+1].getPosition()-1].addSteals(1);
						playingAwayTeam[Players[i+1].getPosition()-1].changeStamina(-.1);
					}

					Players[i].addTurnovers(1);
					Players[i].changeStamina(-.2);

					playIsOver = true;
					break;
				} 
				else
				{
					lastPass = temp;
				}
			}
			Random r = new Random();
			int randomTurnover = r.nextInt(100);
			if(randomTurnover == 4 || randomTurnover == 40 || randomTurnover == 30)
			{
				Players[Players.length-1].addTurnovers(1);
				Players[Players.length-1].changeStamina(-.2);
				playIsOver = true;
			}
			else if(randomTurnover == 12 || randomTurnover == 3)
			{
				Players[Players.length-1].addTurnovers(1);
				Players[Players.length-1].changeStamina(-.2);
				if(b)playingHomeTeam[Players[Players.length-1].getPosition()-1].addSteals(1);
				else playingAwayTeam[Players[Players.length-1].getPosition()-1].addSteals(1);
				
				playIsOver = true;
			}
			if(!playIsOver)
			{
				r = new Random();
				int shotType = r.nextInt(20);
				double shotSkill = 0.0;
				if(Players[Players.length-1].getJumpShotRating() > Math.max(Players[Players.length-1].getLayupRating(), Players[Players.length-1].getDunkRating()))
				{
					shotType -= 5;
				}
				else if(Players[Players.length-1].getJumpShotRating() < Math.max(Players[Players.length-1].getLayupRating(), Players[Players.length-1].getDunkRating()))
				{
					shotType += 5;
				}
				if(shotType > 10)
				{

					if(lastPass > 5 || Players[Players.length-1].getDunkRating() > Players[Players.length-1].getLayupRating())shotSkill = Players[Players.length-1].getDunkRating();
					else shotSkill = Players[Players.length-1].getLayupRating();


				}
				else
				{

					shotSkill = Players[Players.length-1].getJumpShotRating();

				}


				if(lastPass < 0)lastPass = 3;
				else if(lastPass < 5)lastPass = 2;
				else lastPass = 1;
				
				if(lastPass == 3 && shotSkill < 8)
				{
					int tempValue = r.nextInt(20);
					if(tempValue > 5)
					{
						return 2;
					}
				}
				if(lastPass == 2 && shotSkill < 5)
				{
					int tempValue = r.nextInt(20);
					if(tempValue > 10)
					{
						return 2;
					}
				}
				
				if(shotSkill <  3 && lastPass != 1)
				{
					int tempValue = r.nextInt(20);
					if(tempValue > 3)
					{
						return 2;
					}
				}

				player tempDef;
				if(b)tempDef = playingHomeTeam[Players[Players.length-1].getPosition()-1];
				else tempDef = playingAwayTeam[Players[Players.length-1].getPosition()-1];
				shots takeShot = new shots(lastPass, shotSkill,tempDef.getShotContestRating());
				Players[Players.length-1].addShotTaken(1);
				Players[Players.length-1].changeStamina(-.5);
				if(b)playingHomeTeam[Players[Players.length-1].getPosition()-1].addShotsAttemptedAgainst(1);
				else playingAwayTeam[Players[Players.length-1].getPosition()-1].addShotsAttemptedAgainst(1);
				if(b && takeShot.madeShot())
				{

					if(shotType  < 3)
					{
						awayTeamScore += 3;
						Players[Players.length-1].addPoints(3);
						Players[Players.length-1].addThreePointerMade(1);
						Players[Players.length-1].addThreeTaken(1);	

					}
					else 
					{
						Players[Players.length-1].addPoints(2);
						awayTeamScore += 2;
					}
					Players[Players.length-1].addShotMade(1);

				}
				else if(takeShot.madeShot())
				{
					if(shotType  < 3)
					{

						Players[Players.length-1].addPoints(3);
						homeTeamScore += 3;
					}
					else 
					{
						Players[Players.length-1].addPoints(2);
						homeTeamScore += 2;
					}
					Players[Players.length-1].addShotMade(1);

				}
				if(takeShot.wasFouled())
				{
					if(b)
					{
						playingHomeTeam[Players[Players.length-1].getPosition()-1].addFoul(1);
					}
					else 
					{
						playingAwayTeam[Players[Players.length-1].getPosition()-1].addFoul(1);
					}
				}
				if(takeShot.madeShot())
				{
					if(b)playingHomeTeam[Players[Players.length-1].getPosition()-1].addShotsMadeAgainst(1);
					else playingAwayTeam[Players[Players.length-1].getPosition()-1].addShotsMadeAgainst(1);
					r = new Random();
					int assist = 0;
					if(Players.length > 1)assist = (int) (r.nextInt(10) - Players[Players.length-2].getPassing()*2);
					if(assist < 2 && Players.length>1)
					{
						Players[Players.length-2].addAssists(1);
					}
					playIsOver = true;
					if(takeShot.wasFouled() && shotType < 3)
					{
						shots takeFreeThrows = new shots(6,Players[Players.length-1].getJumpShotRating(),0);
						Players[Players.length-1].addPoints(takeFreeThrows.getPointsScored());
						Players[Players.length-1].addFreeThrowsTaken(1);
						Players[Players.length-1].addFreeThrowsMade(takeFreeThrows.getPointsScored());
						if(!b)homeTeamScore += takeFreeThrows.getPointsScored();
						else awayTeamScore += takeFreeThrows.getPointsScored();
					}
				}
				else
				{
					if(takeShot.wasFouled() && shotType < 3)
					{
						shots takeFreeThrows = new shots(5,Players[Players.length-1].getJumpShotRating(),0);
						Players[Players.length-1].addPoints(takeFreeThrows.getPointsScored());
						Players[Players.length-1].addFreeThrowsTaken(3);
						Players[Players.length-1].addFreeThrowsMade(takeFreeThrows.getPointsScored());
						if(!b)homeTeamScore += takeFreeThrows.getPointsScored();
						else awayTeamScore += takeFreeThrows.getPointsScored();
					}
					else if(takeShot.wasFouled())
					{
						shots takeFreeThrows = new shots(4,Players[Players.length-1].getJumpShotRating(),0);
						Players[Players.length-1].addPoints(takeFreeThrows.getPointsScored());
						Players[Players.length-1].addFreeThrowsTaken(2);
						Players[Players.length-1].addFreeThrowsMade(takeFreeThrows.getPointsScored());
						if(!b)homeTeamScore += takeFreeThrows.getPointsScored();
						else awayTeamScore += takeFreeThrows.getPointsScored();
					}
					else if(shotType  < 3)
					{

						Players[Players.length-1].addThreeTaken(1);			
					}


					boolean reboundResult = !rebound(b);
					if(reboundResult)return 1;
					else return 0;
				}


			}


		}
		return 1;


	}
	private boolean rebound(boolean b)
	{
		Random r = new Random();
		int temp3 = r.nextInt(100);
		player offensivePlayer, defensivePlayer;

		if(temp3 > 70)
		{
			if(b)
			{
				offensivePlayer = playingHomeTeam[0];
				defensivePlayer = playingAwayTeam[0];
			}
			else
			{
				offensivePlayer = playingAwayTeam[0];
				defensivePlayer = playingHomeTeam[0];
			}
		}
		else if(temp3 > 45)
		{
			if(b)
			{
				offensivePlayer = playingHomeTeam[1];
				defensivePlayer = playingAwayTeam[1];
			}
			else
			{
				offensivePlayer = playingAwayTeam[1];
				defensivePlayer = playingHomeTeam[1];
			}
		}
		else if(temp3 > 30)
		{
			if(b)
			{
				offensivePlayer = playingHomeTeam[2];
				defensivePlayer = playingAwayTeam[2];
			}
			else
			{
				offensivePlayer = playingAwayTeam[2];
				defensivePlayer = playingHomeTeam[2];
			}
		}
		else if(temp3 > 15)
		{
			if(b)
			{
				offensivePlayer = playingHomeTeam[3];
				defensivePlayer = playingAwayTeam[3];
			}
			else
			{
				offensivePlayer = playingAwayTeam[3];
				defensivePlayer = playingHomeTeam[3];
			}
		}
		else
		{
			if(b)
			{
				offensivePlayer = playingHomeTeam[4];
				defensivePlayer = playingAwayTeam[4];
			}
			else
			{
				offensivePlayer = playingAwayTeam[4];
				defensivePlayer = playingHomeTeam[4];
			}
		}


		int temp = r.nextInt(11)-3;

		double temp2 = defensivePlayer.getJumpingRating()+temp - offensivePlayer.getJumpingRating();
		boolean retVal = temp2 > 0;

		if(retVal)
		{
			defensivePlayer.addRebound(1);
			defensivePlayer.addDefensiveRebound(1);
			if(Math.round(temp2+.25) == 5 && Math.floor(temp2) == 5)
			{
				defensivePlayer.addTurnovers(1);
				retVal = !retVal;
			}
		}   
		else
		{
			offensivePlayer.addRebound(1);
			offensivePlayer.addOffensiveRebound(1);
			if(Math.round(temp2+.25) == -3&& Math.floor(temp2) == -3)
			{
				offensivePlayer.addTurnovers(1);
				retVal = !retVal;
			}

		}
		return retVal;
	}
	private int pass(player player1, player player2, boolean b)
	{
		double temp = player1.getPassing()+player2.getSeperation();
		double temp2;
		if(b)temp2 = playingHomeTeam[player2.getPosition()-1].getDefenseIQRating();
		else temp2 = playingAwayTeam[player2.getPosition()-1].getDefenseIQRating();

		Random r = new Random();
		int temp3 = r.nextInt(8)-3;

		return (int) ((temp+temp3) - temp2);
	}
	public static ArrayList<Integer> assignValues(int length)
	{
		ArrayList<Integer> returnVal = new ArrayList<Integer>();
		for(int i = 0; i<length;i++)
		{
			returnVal.add(i);
		}
		return returnVal;
	}
	public boolean getWinner()
	{

		return awayTeamScore > homeTeamScore;

	}
	public int getAwayTeamScore()
	{
		return awayTeamScore;
	}
	public int getHomeTeamScore()
	{
		return homeTeamScore;
	}
}