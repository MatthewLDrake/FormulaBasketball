import java.util.ArrayList;
import java.util.Random;

public class game
{
	private team awayTeam, homeTeam;
	private int awayTeamScore, homeTeamScore, staminaRegen;
	private int[] firstQuarterScore, secondQuarterScore, thirdQuarterScore, fourthQuarterScore, OTScore;
	private boolean awayTipOff;
	private currentTeam playingAwayTeam, playingHomeTeam;
	private gameWriter gameWriter;

	public game(gameWriter gameWriter, team away, team home)
	{
		this.gameWriter = gameWriter;
		this.gameWriter.listOfStrings.add("Game,"+ away.getTeamName() + "," + home.getTeamName());
		firstQuarterScore = new int[]{0,0};
		secondQuarterScore = new int[]{0,0}; 
		thirdQuarterScore = new int[]{0,0}; 
		fourthQuarterScore = new int[]{0,0};
		OTScore = new int[]{0,0};

		for(int i = 0; i < away.getSize();i++)
		{
			away.getPlayer(i).decrementDay();
		}
		for(int i = 0; i < home.getSize();i++)
		{
			home.getPlayer(i).decrementDay();
		}
		awayTeam = away;
		homeTeam = home;

		staminaRegen = 0;

		playingAwayTeam = new currentTeam(awayTeam);
		playingHomeTeam = new currentTeam(homeTeam);

		for(int i = 0; i<away.getSize();i++)
		{
			away.getPlayer(i).setIsPlaying(false);
			if(away.getPlayer(i).isStarter())
			{
				away.getPlayer(i).setIsPlaying(true);
				if(away.getPlayer(i).getPosition() == 1)playingAwayTeam.center = away.getPlayer(i);
				else if(away.getPlayer(i).getPosition() == 2)playingAwayTeam.powerForward = away.getPlayer(i);
				else if(away.getPlayer(i).getPosition() == 3)playingAwayTeam.smallForward = away.getPlayer(i);
				else if(away.getPlayer(i).getPosition() == 4)playingAwayTeam.shootingGuard = away.getPlayer(i);
				else if(away.getPlayer(i).getPosition() == 5)playingAwayTeam.pointGuard = away.getPlayer(i);
			}

		}

		for(int i = 0; i<home.getSize();i++)
		{
			home.getPlayer(i).setIsPlaying(false);
			if(home.getPlayer(i).isStarter())
			{
				home.getPlayer(i).setIsPlaying(true);
				if(home.getPlayer(i).getPosition() == 1)playingHomeTeam.center = home.getPlayer(i);
				else if(home.getPlayer(i).getPosition() == 2)playingHomeTeam.powerForward = home.getPlayer(i);
				else if(home.getPlayer(i).getPosition() == 3)playingHomeTeam.smallForward = home.getPlayer(i);
				else if(home.getPlayer(i).getPosition() == 4)playingHomeTeam.shootingGuard  = home.getPlayer(i);
				else if(home.getPlayer(i).getPosition() == 5)playingHomeTeam.pointGuard = home.getPlayer(i);
			}
		}
		playingAwayTeam = substitutions(playingAwayTeam, awayTeam, true, 1);
		playingHomeTeam = substitutions(playingHomeTeam, homeTeam, false, 1);

		playingAwayTeam.checkTeam();
		playingHomeTeam.checkTeam();

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
			awayTeam.getPlayer(i).resetGame();


		}
		for(int i = 0; i < homeTeam.getSize();i++)
		{
			homeTeam.getPlayer(i).changeStamina(20);
			homeTeam.getPlayer(i).resetGame();
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
		double temp = playingAwayTeam.center.getJumpingRating() - playingHomeTeam.center.getJumpingRating();

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
				player[] whichPlayers = new player[playersInPlay + 1];
				if(awayPoss)whichPlayers[0] = playingAwayTeam.playMaker;
				else whichPlayers[0] = playingHomeTeam.playMaker;
				ArrayList<Integer> temp = assignValues(5);
				int counter = 1;
				for(int i = playersInPlay;i >= 0;i--)
				{
					if(i != 0)
					{
						int temp2 = r.nextInt(temp.size());
						if(awayPoss)whichPlayers[counter++] = playingAwayTeam.get(temp.get(temp2));
						else whichPlayers[counter++] = playingHomeTeam.get(temp.get(temp2));
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
			int timePassed = r.nextInt(14)+8;
			if(timePassed > timeRemaining)timePassed = timeRemaining;
			
			staminaRegen += timePassed;
			timeRemaining = timeRemaining - timePassed;
			statWriter awayStats = new statWriter(awayTeam);
			statWriter homeStats = new statWriter(homeTeam);
			gameWriter.listOfStrings.add(awayTeamScore + "," + homeTeamScore + "," + timeRemaining + "_" + awayStats.toString() + "_" + homeStats.toString());
			for(int i = 0; i<5;i++)
			{
				double temp1 = -60;
				playingHomeTeam.get(i).changeStamina(timePassed/(temp1));
				playingAwayTeam.get(i).changeStamina(timePassed/(temp1));
				playingHomeTeam.get(i).addMinutes(timePassed);
				playingAwayTeam.get(i).addMinutes(timePassed);
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
			checkForInjuries(quarterNum, timeRemaining);
			playingAwayTeam = substitutions(playingAwayTeam, awayTeam, true, quarterNum);
			playingHomeTeam = substitutions(playingHomeTeam, homeTeam, false, quarterNum);

		}
	}
	private void checkForInjuries(int quarterNum, int timeRemaining)
	{
		Random r = new Random();
		for(int i = 0; i < playingAwayTeam.length; i++)
		{
			int injuryRate = (playingAwayTeam.get(i).getDurabilityRating()*13000);
			int injury = r.nextInt(injuryRate);
			if(injury == 500)
			{
				playingAwayTeam.get(i).setInjured(true);
				new Injury(playingAwayTeam.get(i),awayTeam, homeTeam, quarterNum, timeRemaining);
			}
		}
		for(int i = 0; i < playingHomeTeam.length; i++)
		{
			int injuryRate =  (playingHomeTeam.get(i).getDurabilityRating()*13000);
			int injury = r.nextInt(injuryRate);
			if(injury == 500)
			{
				playingHomeTeam.get(i).setInjured(true);
				new Injury(playingHomeTeam.get(i),awayTeam, homeTeam, quarterNum, timeRemaining);
			}
		}

	}
	private currentTeam substitutions(currentTeam playing, team fullTeam, boolean b, int quarterNum)
	{
		currentTeam returnVal = new currentTeam(playing);
		for(int i  = 0; i<playing.length;i++)
		{

			ArrayList<player> temp = new ArrayList<player>();
			double tempHolder = 0; 
			int newMember = 0;

			boolean bob = false;
			if(!playing.get(i).isStarter())
			{

				for(int j = 0; j<fullTeam.getSize();j++)
				{
					if(i+1 == fullTeam.getPlayer(j).getPosition())
					{
						if(fullTeam.getPlayer(j).isStarter() && !fullTeam.getPlayer(j).isInjured() && acceptableAmountOfFouls(fullTeam.getPlayer(j),quarterNum))
						{

							if(fullTeam.getPlayer(j).getStamina() > 90.0 && acceptableAmountOfFouls(fullTeam.getPlayer(j),quarterNum))
							{
								bob = true;
							}
						}


					}
				}
			}

			if(playing.get(i).isInjured() || playing.get(i).getStamina() < 65.0 || bob || !acceptableAmountOfFouls(playing.get(i),quarterNum))
			{
				boolean useOtherPositions = false;
				while(true)
				{
					if(bob)
					{
						temp = new ArrayList<player>();
						for(int j = 0; j<fullTeam.getSize();j++)
						{
							if(i+1 == fullTeam.getPlayer(j).getPosition() && fullTeam.getPlayer(j).isStarter())temp.add(fullTeam.getPlayer(j));
						}
					}
					else if(!playing.get(i).isInjured() && !useOtherPositions)
					{		   

						temp = new ArrayList<player>();
						for(int j = 0; j<fullTeam.getSize();j++)
						{
							if(i+1 == fullTeam.getPlayer(j).getPosition() && !fullTeam.getPlayer(j).isPlaying() && acceptableAmountOfFouls(fullTeam.getPlayer(j), quarterNum) && ! fullTeam.getPlayer(j).isInjured())
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
					else
					{
						temp = new ArrayList<player>();
						for(int j = 0; j<fullTeam.getSize();j++)
						{
							if(playing.get(i).getPosition() == fullTeam.getPlayer(j).getPosition() && !fullTeam.getPlayer(j).isPlaying() && acceptableAmountOfFouls(fullTeam.getPlayer(j), 4) && ! fullTeam.getPlayer(j).isInjured())
							{
								temp.add(fullTeam.getPlayer(j));
							}

						}
						for(int j = 0; j < fullTeam.getSize(); j++)
						{
							if(temp.isEmpty())
							{
								if(!fullTeam.getPlayer(j).isPlaying() && acceptableAmountOfFouls(fullTeam.getPlayer(j), 4) && ! fullTeam.getPlayer(j).isInjured() && fullTeam.getPlayer(j).getStamina() > 70)
								{
									temp.add(fullTeam.getPlayer(j));
								}
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
						returnVal.get(i).setIsPlaying(false);
						returnVal.set(i, temp.get(newMember));
						returnVal.get(i).setIsPlaying(true);
						break;
					}
					else
					{
						useOtherPositions = true;
					}
				}
			}
		}
		for(int i  = 0; i<returnVal.length;i++)
		{
			if(returnVal.get(i).isInjured())
			{
				System.out.println(returnVal.get(i).getName() + " is playing hurt tf");
				//System.exit(0);
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
						playingHomeTeam.get(Players[i+1].getPosition()-1).addSteals(1);
						playingHomeTeam.get(Players[i+1].getPosition()-1).changeStamina(-.1);
					}
					else 
					{
						playingAwayTeam.get(Players[i+1].getPosition()-1).addSteals(1);
						playingAwayTeam.get(Players[i+1].getPosition()-1).changeStamina(-.1);
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
				if(b)playingHomeTeam.get(Players[Players.length-1].getPosition()-1).addSteals(1);
				else playingAwayTeam.get(Players[Players.length-1].getPosition()-1).addSteals(1);

				playIsOver = true;
			}
			ShotType shot;
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

					if(lastPass > 5 || Players[Players.length-1].getDunkRating() > Players[Players.length-1].getLayupRating())
					{
						shotSkill = Players[Players.length-1].getDunkRating();
						shot = ShotType.DUNK;
					}
					else 
					{
						shotSkill = Players[Players.length-1].getLayupRating();
						shot = ShotType.LAYUP;
					}


				}
				else if(shotType >= 3)
				{

					shotSkill = Players[Players.length-1].getJumpShotRating();
					shot = ShotType.JUMP;
				}
				else
				{
					shotSkill = Players[Players.length-1].getThreeShotRating();
					shot = ShotType.THREE;
				}

				switch(shot)
				{
				case THREE:
					if(lastPass < -4)lastPass = 3;
					else if(lastPass < 0)lastPass = 2;
					else lastPass = 1;
					break;
				case JUMP:
					if(lastPass < -2.5)lastPass = 3;
					else if(lastPass < 2)lastPass = 2;
					else lastPass = 1;
					break;
				case LAYUP:
					if(lastPass < 2)lastPass = 3;
					else if(lastPass < 7)lastPass = 2;
					else lastPass = 1;
					break;
				case DUNK:
					if(lastPass < 0)lastPass = 3;
					else if(lastPass < 6)lastPass = 2;
					else lastPass = 1;
					break;
				default:
					break;
				}


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
				if(b)tempDef = playingHomeTeam.get(Players[Players.length-1].getPosition()-1);
				else tempDef = playingAwayTeam.get(Players[Players.length-1].getPosition()-1);
				shots takeShot = new shots(lastPass, shotSkill,tempDef.getShotContestRating(), shot);
				Players[Players.length-1].addShotTaken(1);
				Players[Players.length-1].changeStamina(-.5);
				if(b)playingHomeTeam.get(Players[Players.length-1].getPosition()-1).addShotsAttemptedAgainst(1);
				else playingAwayTeam.get(Players[Players.length-1].getPosition()-1).addShotsAttemptedAgainst(1);
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
						playingHomeTeam.get(Players[Players.length-1].getPosition()-1).addFoul(1);
					}
					else 
					{
						playingAwayTeam.get(Players[Players.length-1].getPosition()-1).addFoul(1);
					}
				}
				if(takeShot.madeShot())
				{
					if(b)playingHomeTeam.get(Players[Players.length-1].getPosition()-1).addShotsMadeAgainst(1);
					else playingAwayTeam.get(Players[Players.length-1].getPosition()-1).addShotsMadeAgainst(1);
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
						shots takeFreeThrows = new shots(6,Players[Players.length-1].getJumpShotRating(),0, ShotType.FREE);
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
						shots takeFreeThrows = new shots(5,Players[Players.length-1].getJumpShotRating(),0, ShotType.FREE);
						Players[Players.length-1].addPoints(takeFreeThrows.getPointsScored());
						Players[Players.length-1].addFreeThrowsTaken(3);
						Players[Players.length-1].addFreeThrowsMade(takeFreeThrows.getPointsScored());
						if(!b)homeTeamScore += takeFreeThrows.getPointsScored();
						else awayTeamScore += takeFreeThrows.getPointsScored();
					}
					else if(takeShot.wasFouled())
					{
						shots takeFreeThrows = new shots(4,Players[Players.length-1].getJumpShotRating(),0, ShotType.FREE);
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
		player offensivePlayer = null, defensivePlayer = null;
		boolean reboundOne = r.nextBoolean();
		boolean reboundTwo = r.nextBoolean();
		boolean reboundThree = r.nextBoolean();
		if(reboundOne && reboundTwo && reboundThree)
		{
			if(b)
			{
				offensivePlayer = playingHomeTeam.rebounder;
				defensivePlayer = playingAwayTeam.rebounder;
			}
			else
			{
				offensivePlayer = playingAwayTeam.rebounder;
				defensivePlayer = playingHomeTeam.rebounder;
			}
		}
		else
		{
			int temp3 = r.nextInt(100);


			if(temp3 > 70)
			{
				if(b)
				{
					offensivePlayer = playingHomeTeam.get(0);
					defensivePlayer = playingAwayTeam.get(0);
				}
				else
				{
					offensivePlayer = playingAwayTeam.get(0);
					defensivePlayer = playingHomeTeam.get(0);
				}
			}
			else if(temp3 > 45)
			{
				if(b)
				{
					offensivePlayer = playingHomeTeam.get(1);
					defensivePlayer = playingAwayTeam.get(1);
				}
				else
				{
					offensivePlayer = playingAwayTeam.get(1);
					defensivePlayer = playingHomeTeam.get(1);
				}
			}
			else if(temp3 > 30)
			{
				if(b)
				{
					offensivePlayer = playingHomeTeam.get(2);
					defensivePlayer = playingAwayTeam.get(2);
				}
				else
				{
					offensivePlayer = playingAwayTeam.get(2);
					defensivePlayer = playingHomeTeam.get(2);
				}
			}
			else if(temp3 > 15)
			{
				if(b)
				{
					offensivePlayer = playingHomeTeam.get(3);
					defensivePlayer = playingAwayTeam.get(3);
				}
				else
				{
					offensivePlayer = playingAwayTeam.get(3);
					defensivePlayer = playingHomeTeam.get(3);
				}
			}
			else
			{
				if(b)
				{
					offensivePlayer = playingHomeTeam.get(4);
					defensivePlayer = playingAwayTeam.get(4);
				}
				else
				{
					offensivePlayer = playingAwayTeam.get(4);
					defensivePlayer = playingHomeTeam.get(4);
				}
			}

		}
		int temp = r.nextInt(15)-6;

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
		if(b)temp2 = playingHomeTeam.get(player2.getPosition()-1).getDefenseIQRating();
		else temp2 = playingAwayTeam.get(player2.getPosition()-1).getDefenseIQRating();

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
