import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

//import org.apache.commons.lang3.StringUtils;
public class formulaBasketball
{
	private static PrintWriter writer, gameResults, stats, standings;
	private static createTeams create;
	private static Scanner kb;
	private static int startingGame;
	public static void main(String[] args)
	{
		boolean loadSave = false;

		System.out.println("Start with previous state?\nNo means begin with default jukebox?");
		kb = new Scanner(System.in);
		loadSave = kb.nextLine().toLowerCase().equals("yes");
		if(loadSave)
		{
			FileInputStream f_in;
			try
			{
				f_in = new 
						FileInputStream("teams.data");
				// Read object using ObjectInputStream
				ObjectInputStream obj_in = 
						new ObjectInputStream (f_in);

				// Read an object
				create = (createTeams) obj_in.readObject();

				obj_in.close();
			}
			catch (FileNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (ClassNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
			create = new createTeams();

		try
		{
			writer = new PrintWriter("Results.txt", "UTF-8");
			gameResults = new PrintWriter("GameResults.csv", "UTF-8");
			stats = new PrintWriter("stats.csv", "UTF-8");
			standings = new PrintWriter("standings.csv", "UTF-8");
			//standings.println("");
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

		//executeGame(33, 32);

		/*
	for(int i = 0; i<10000;i++)
	{
	    executeGame(11,32, false);
	 //   executeGame(35,36);
	   // executeGame(36,34);
	}
		 */
		while(true)
		{
			System.out.println("What would you like to do?");
			String result = kb.nextLine();
			if(result.toLowerCase().equals("play"))
				playGames();
			else if(result.toLowerCase().equals("changestarter"))
				changeStarter();
			else if(result.toLowerCase().equals("trade"))
				trade();
			else if(result.toLowerCase().equals("exit"))
				break;
			else if(result.toLowerCase().equals("print"))
				printTeam();
			else if(result.toLowerCase().equals("changename"))
				changeName();
			else if(result.toLowerCase().equals("addplayer"))
				addPlayer();
			else if(result.toLowerCase().equals("removeplayer"))
				removePlayer();
			else if(result.toLowerCase().equals("printplayers"))
				printPlayers();
		}
		calculateStandings();
		stats();
		saveData();
		kb.close();
		writer.close();
		stats.close();
		gameResults.close();
		standings.close();
	}
	private static void printPlayers()
	{
		for(int j = 1; j < 6; j++){
			PrintWriter listOfPlayers = null;
			try{
				listOfPlayers = new PrintWriter("Position: " + j + ".csv", "UTF-8");
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
			ArrayList<player> allPlayers = new ArrayList<player>();
			for(int i = 0; i < create.size(); i++)
			{
				allPlayers.addAll(create.getTeam(i).getPosition(j));
			}
			Collections.sort(allPlayers);
			for(int i  = 0; i < allPlayers.size(); i++)
			{
				listOfPlayers.println(allPlayers.get(i).getName() + "," + allPlayers.get(i).getTeam().getTeamName());
			}
			listOfPlayers.close();
		}

	}
	private static void removePlayer()
	{
		System.out.println("Enter the team number");
		int teamNum = kb.nextInt();
		System.out.println("Team: " + create.getTeam(teamNum).getTeamName());

		System.out.println("Enter the player number of the former player from " + create.getTeam(teamNum).getTeamName());
		int firstTeamPlayer = kb.nextInt();

		create.getTeam(teamNum).removePlayer(firstTeamPlayer);
	}
	private static void addPlayer()
	{
		System.out.println("Enter the team number");
		int teamNum = kb.nextInt();
		kb.nextLine();
		String playerName;
		int pos, layupStat, dunkStat, jumpStat, passing, shotContest, defenseIQ, jumping, seperation, staminaRating;

		System.out.println("Enter the name:");
		playerName = kb.nextLine();
		System.out.println("Enter pos: ");
		pos = kb.nextInt();
		layupStat = kb.nextInt();
		dunkStat = kb.nextInt();
		jumpStat = kb.nextInt();
		passing = kb.nextInt();
		shotContest = kb.nextInt();
		defenseIQ = kb.nextInt();
		jumping = kb.nextInt();
		seperation = kb.nextInt();
		staminaRating = kb.nextInt();
		create.getTeam(teamNum).addPlayer(new player(pos, layupStat, dunkStat, jumpStat, passing, shotContest, defenseIQ, jumping, seperation, staminaRating, playerName, false));
	}
	private static void changeName()
	{
		System.out.println("Enter the team number");
		int teamNum = kb.nextInt();
		System.out.println("Team: " + create.getTeam(teamNum).getTeamName());

		System.out.println("Enter the player number of the  player from " + create.getTeam(teamNum).getTeamName() + " that you wish to change the name of.");
		int firstTeamPlayer = kb.nextInt();
		kb.nextLine();

		System.out.println("What would you like to change his name to?");
		String newName = kb.nextLine();
		create.getTeam(teamNum).getPlayer(firstTeamPlayer).setName(newName);

	}
	private static void printTeam()
	{
		System.out.println("Enter the team number");
		int firstTeamNum = kb.nextInt();

		for(int i = 0; i < create.getTeam(firstTeamNum).getSize(); i++)
		{
			System.out.println(create.getTeam(firstTeamNum).getPlayer(i).getName() + " " + create.getTeam(firstTeamNum).getPlayer(i).getPosition() + " " + create.getTeam(firstTeamNum).getPlayer(i).isStarter());
		}

	}
	private static void trade()
	{
		System.out.println("Enter the first team number");
		int firstTeamNum = kb.nextInt();
		System.out.println("Team One: " + create.getTeam(firstTeamNum).getTeamName());
		System.out.println("Enter the second team number");
		int secondTeamNum = kb.nextInt();
		System.out.println("Team One: " + create.getTeam(secondTeamNum).getTeamName());

		System.out.println("Enter the player number of the former player from " + create.getTeam(firstTeamNum).getTeamName());
		int firstTeamPlayer = kb.nextInt();
		System.out.println("Enter the player number of the former player from " + create.getTeam(secondTeamNum).getTeamName());
		int secondTeamPlayer = kb.nextInt();

		player temp = create.getTeam(firstTeamNum).getPlayer(firstTeamPlayer);
		player othertemp = create.getTeam(secondTeamNum).getPlayer(secondTeamPlayer);

		create.getTeam(firstTeamNum).removePlayer(firstTeamPlayer);
		create.getTeam(secondTeamNum).removePlayer(secondTeamPlayer);

		create.getTeam(firstTeamNum).addPlayer(othertemp);
		create.getTeam(secondTeamNum).addPlayer(temp);
	}
	private static void calculateStandings()
	{
		ArrayList<team> DivisionA = new ArrayList<team>();

		DivisionA.add(create.getTeam(0));
		DivisionA.add(create.getTeam(4));
		DivisionA.add(create.getTeam(5));
		DivisionA.add(create.getTeam(7));
		DivisionA.add(create.getTeam(9));
		DivisionA.add(create.getTeam(11));
		DivisionA.add(create.getTeam(27));
		DivisionA.add(create.getTeam(29));

		Collections.sort(DivisionA);

		ArrayList<team> DivisionB = new ArrayList<team>();

		DivisionB.add(create.getTeam(1));
		DivisionB.add(create.getTeam(6));
		DivisionB.add(create.getTeam(8));
		DivisionB.add(create.getTeam(10));
		DivisionB.add(create.getTeam(14));
		DivisionB.add(create.getTeam(19));
		DivisionB.add(create.getTeam(25));
		DivisionB.add(create.getTeam(31));


		Collections.sort(DivisionB);

		ArrayList<team> DivisionC = new ArrayList<team>();

		DivisionC.add(create.getTeam(13));
		DivisionC.add(create.getTeam(15));
		DivisionC.add(create.getTeam(18));
		DivisionC.add(create.getTeam(20));
		DivisionC.add(create.getTeam(22));
		DivisionC.add(create.getTeam(24));
		DivisionC.add(create.getTeam(26));
		DivisionC.add(create.getTeam(28));


		Collections.sort(DivisionC);

		ArrayList<team> DivisionD = new ArrayList<team>();

		DivisionD.add(create.getTeam(2));
		DivisionD.add(create.getTeam(3));
		DivisionD.add(create.getTeam(12));
		DivisionD.add(create.getTeam(16));
		DivisionD.add(create.getTeam(17));
		DivisionD.add(create.getTeam(21));
		DivisionD.add(create.getTeam(23));
		DivisionD.add(create.getTeam(30));


		Collections.sort(DivisionD);

		ArrayList<team> ConferenceA = new ArrayList<team>();
		ConferenceA.addAll(DivisionA);
		ConferenceA.addAll(DivisionB);
		Collections.sort(ConferenceA);
		ArrayList<team> ConferenceB = new ArrayList<team>();
		ConferenceB.addAll(DivisionC);
		ConferenceB.addAll(DivisionD);
		Collections.sort(ConferenceB);

		ArrayList<team> League = new ArrayList<team>();
		League.addAll(ConferenceA);
		League.addAll(ConferenceB);
		Collections.sort(League);

		for(int i = 0; i < DivisionA.size(); i++)
		{
			DivisionA.get(i).setDivisionRank(i+1);
			DivisionB.get(i).setDivisionRank(i+1);
			DivisionC.get(i).setDivisionRank(i+1);
			DivisionD.get(i).setDivisionRank(i+1);
		}
		for(int i = 0; i < ConferenceA.size(); i++)
		{
			ConferenceA.get(i).setConferenceRank(i+1);
			ConferenceB.get(i).setConferenceRank(i+1);
		}
		for(int i = 0; i < League.size();i++)
		{
			League.get(i).setLeagueRank(i+1);
		}
		standings.println("Division A, Wins,Losses,Points Scored,Points Against,Division Rank,Conference Rank,League Rank");
		for(int i = 0; i < DivisionA.size(); i++)
		{
			standings(DivisionA.get(i));

		}
		standings.println("Division B");
		for(int i = 0; i < DivisionB.size(); i++)
		{
			standings(DivisionB.get(i));

		}
		standings.println("Division C");
		for(int i = 0; i < DivisionC.size(); i++)
		{
			standings(DivisionC.get(i));

		}
		standings.println("Division D");
		for(int i = 0; i < DivisionD.size(); i++)
		{
			standings(DivisionD.get(i));

		}

	}
	private static void changeStarter()
	{
		System.out.println("Enter the team number");
		int teamNum = kb.nextInt();
		System.out.println("Enter the player number of the former starter");
		int oldStarter = kb.nextInt();
		System.out.println("Enter the player number of the new starter");
		int newStarter = kb.nextInt();

		create.getTeam(teamNum).getPlayer(oldStarter).setStarter(false);
		create.getTeam(teamNum).getPlayer(newStarter).setStarter(true);
	}
	private static void playGames()
	{
		writer.println();

		startingGame = 21;
		executeGame(false,17, 0);
		executeGame(false,23, 12) ;
		executeGame(false,30, 2);
		executeGame(false,21, 28);
		executeGame(false,16, 26);
		executeGame(false,3, 24);
		executeGame(false,11, 22);
		executeGame(false,4, 20);
		executeGame(false,29, 18);
		executeGame(false,5, 15);
		executeGame(false,9, 13);
		executeGame(false,7, 19);
		executeGame(false,27, 14);
		executeGame(false,1, 6);
		executeGame(false,8, 31);
		executeGame(false,10, 25);
		
		writer.println();
		executeGame(false,16, 0);
		executeGame(false,3, 21);
		executeGame(false,11, 30);
		executeGame(false,4, 23);
		executeGame(false,29, 17);
		executeGame(false,5, 12) ;
		executeGame(false,9, 2);
		executeGame(false,7, 28);
		executeGame(false,27, 26);
		executeGame(false,1, 24);
		executeGame(false,8, 22);
		executeGame(false,10, 20);
		executeGame(false,25, 18);
		executeGame(false,31, 15);
		executeGame(false,6, 13);
		executeGame(false,14, 19);
		writer.println();
		executeGame(false,0, 24);
		executeGame(false,26, 22);
		executeGame(false,28, 20);
		executeGame(false,2, 18);
		executeGame(false,12, 15);
		executeGame(false,17, 13);
		executeGame(false,23, 19);
		executeGame(false,30, 14);
		executeGame(false,21, 6);
		executeGame(false,16, 31);
		executeGame(false,3, 25);
		executeGame(false,11, 10);
		executeGame(false,4, 8);
		executeGame(false,29, 1);
		executeGame(false,5, 27);
		executeGame(false,9, 7);
		writer.println();
		executeGame(false,0, 27);
		executeGame(false,1, 7);
		executeGame(false,8, 9);
		executeGame(false,10, 5);
		executeGame(false,25, 29);
		executeGame(false,31, 4);
		executeGame(false,6, 11);
		executeGame(false,14, 3) ;
		executeGame(false,19, 16) ;
		executeGame(false,13, 21);
		executeGame(false,15, 30);
		executeGame(false,18, 23);
		executeGame(false,20, 17);
		executeGame(false,22, 12) ;
		executeGame(false,24, 2);
		executeGame(false,26, 28);
		writer.println();
		executeGame(false,0, 27);
		executeGame(false,1, 7);
		executeGame(false,8, 9);
		executeGame(false,10, 5);
		executeGame(false,25, 29);
		executeGame(false,31, 4);
		executeGame(false,6, 11);
		executeGame(false,14, 3) ;
		executeGame(false,19, 16) ;
		executeGame(false,13, 21);
		executeGame(false,15, 30);
		executeGame(false,18, 23);
		executeGame(false,20, 17);
		executeGame(false,22, 12) ;
		executeGame(false,24, 2);
		executeGame(false,26, 28);
		writer.println();
		executeGame(false,0, 6);
		executeGame(false,14, 31);
		executeGame(false,19, 25);
		executeGame(false,13, 10);
		executeGame(false,15, 8);
		executeGame(false,18, 1);
		executeGame(false,20, 27);
		executeGame(false,22, 7);
		executeGame(false,24, 9);
		executeGame(false,26, 5);
		executeGame(false,28, 29);
		executeGame(false,2, 4);
		executeGame(false,12, 11);
		executeGame(false,17, 3) ;
		executeGame(false,23, 16) ;
		executeGame(false,30, 21);
		writer.println();
		executeGame(false,0, 29);
		executeGame(false,5, 4);
		executeGame(false,9, 11);
		executeGame(false,7, 27);
		executeGame(false,1, 25);
		executeGame(false,31, 10);
		executeGame(false,6, 8);
		executeGame(false,14, 19);
		executeGame(false,13, 20);
		executeGame(false,22, 18);
		executeGame(false,24, 15);
		executeGame(false,26, 28);
		executeGame(false,2, 23);
		executeGame(false,30, 17);
		executeGame(false,21, 12) ;
		executeGame(false,16, 3) ;
		writer.println();
		executeGame(false,0, 9);
		executeGame(false,7, 5);
		executeGame(false,27, 29);
		executeGame(false,11, 4);
		executeGame(false,1, 6);
		executeGame(false,14, 31);
		executeGame(false,19, 25);
		executeGame(false,8, 10);
		executeGame(false,13, 24);
		executeGame(false,26, 22);
		executeGame(false,28, 20);
		executeGame(false,15, 18);
		executeGame(false,2, 21);
		executeGame(false,16, 30);
		executeGame(false,3, 23);
		executeGame(false,12, 17);
		writer.println();
		executeGame(false,0, 27);
		executeGame(false,11, 7);
		executeGame(false,4, 9);
		executeGame(false,29, 5);
		executeGame(false,1, 19);
		executeGame(false,8, 14);
		executeGame(false,10, 6);
		executeGame(false,25, 31);
		executeGame(false,13, 28);
		executeGame(false,15, 26);
		executeGame(false,18, 24);
		executeGame(false,20, 22);
		executeGame(false,2, 3) ;
		executeGame(false,12, 16) ;
		executeGame(false,17, 21);
		executeGame(false,23, 30);
		writer.println();
		executeGame(false,10, 0);
		executeGame(false,25, 8);
		executeGame(false,31, 1);
		executeGame(false,6, 27);
		executeGame(false,14, 7);
		executeGame(false,19, 9);
		executeGame(false,13, 5);
		executeGame(false,15, 29);
		executeGame(false,18, 4);
		executeGame(false,20, 11);
		executeGame(false,22, 3) ;
		executeGame(false,24, 16) ;
		executeGame(false,26, 21);
		executeGame(false,28, 30);
		executeGame(false,2, 23);
		executeGame(false,12, 17);
		writer.println();
		executeGame(false,10, 0);
		executeGame(false,25, 8);
		executeGame(false,31, 1);
		executeGame(false,6, 27);
		executeGame(false,14, 7);
		executeGame(false,19, 9);
		executeGame(false,13, 5);
		executeGame(false,15, 29);
		executeGame(false,18, 4);
		executeGame(false,20, 11);
		executeGame(false,22, 3) ;
		executeGame(false,24, 16) ;
		executeGame(false,26, 21);
		executeGame(false,28, 30);
		executeGame(false,2, 23);
		executeGame(false,12, 17);
		writer.println();
		executeGame(false,18, 0);
		executeGame(false,20, 15);
		executeGame(false,22, 13);
		executeGame(false,24, 19);
		executeGame(false,26, 14);
		executeGame(false,28, 6);
		executeGame(false,2, 31);
		executeGame(false,12, 25);
		executeGame(false,17, 10);
		executeGame(false,23, 8);
		executeGame(false,30, 1);
		executeGame(false,21, 27);
		executeGame(false,16, 7);
		executeGame(false,3, 9);
		executeGame(false,11, 5);
		executeGame(false,4, 29);
		writer.println();
		executeGame(false,5, 0);
		executeGame(false,9, 29);
		executeGame(false,7, 4);
		executeGame(false,27, 11);
		executeGame(false,1, 3) ;
		executeGame(false,8, 16) ;
		executeGame(false,10, 21);
		executeGame(false,25, 30);
		executeGame(false,31, 23);
		executeGame(false,6, 17);
		executeGame(false,14, 12) ;
		executeGame(false,19, 2);
		executeGame(false,13, 28);
		executeGame(false,15, 26);
		executeGame(false,18, 24);
		executeGame(false,20, 22);
		writer.println();
		executeGame(false,0, 11);
		executeGame(false,4, 3) ;
		executeGame(false,29, 16) ;
		executeGame(false,5, 21);
		executeGame(false,9, 30);
		executeGame(false,7, 23);
		executeGame(false,27, 17);
		executeGame(false,1, 12) ;
		executeGame(false,8, 2);
		executeGame(false,10, 28);
		executeGame(false,25, 26);
		executeGame(false,31, 24);
		executeGame(false,6, 22);
		executeGame(false,14, 20);
		executeGame(false,19, 18);
		executeGame(false,13, 15);
		writer.println();
		executeGame(false,5, 0);
		executeGame(false,9, 29);
		executeGame(false,7, 4);
		executeGame(false,27, 11);
		executeGame(false,31, 1);
		executeGame(false,6, 25);
		executeGame(false,14, 10);
		executeGame(false,19, 8);
		executeGame(false,22, 13);
		executeGame(false,24, 20);
		executeGame(false,26, 18);
		executeGame(false,28, 15);
		executeGame(false,30, 2);
		executeGame(false,21, 23);
		executeGame(false,16, 17);
		executeGame(false,3, 12) ;
		writer.println();
		executeGame(false,4, 0);
		executeGame(false,29, 11);
		executeGame(false,5, 27);
		executeGame(false,9, 7);
		executeGame(false,10, 1);
		executeGame(false,25, 8);
		executeGame(false,31, 19);
		executeGame(false,6, 14);
		executeGame(false,18, 13);
		executeGame(false,20, 15);
		executeGame(false,22, 28);
		executeGame(false,24, 26);
		executeGame(false,17, 2);
		executeGame(false,23, 12) ;
		executeGame(false,30, 3) ;
		executeGame(false,21, 16) ;
		writer.println();
		executeGame(false,0, 29);
		executeGame(false,5, 4);
		executeGame(false,9, 11);
		executeGame(false,7, 3) ;
		executeGame(false,27, 16) ;
		executeGame(false,1, 21);
		executeGame(false,8, 30);
		executeGame(false,10, 23);
		executeGame(false,25, 17);
		executeGame(false,31, 12) ;
		executeGame(false,6, 2);
		executeGame(false,14, 28);
		executeGame(false,19, 26);
		executeGame(false,13, 24);
		executeGame(false,15, 22);
		executeGame(false,18, 20);
		writer.println();
		executeGame(false,13, 0);
		executeGame(false,15, 19);
		executeGame(false,18, 14);
		executeGame(false,20, 6);
		executeGame(false,22, 31);
		executeGame(false,24, 25);
		executeGame(false,26, 10);
		executeGame(false,28, 8);
		executeGame(false,2, 1);
		executeGame(false,12, 27);
		executeGame(false,17, 7);
		executeGame(false,23, 9);
		executeGame(false,30, 5);
		executeGame(false,21, 29);
		executeGame(false,16, 4);
		executeGame(false,3, 11);
		writer.println();
		executeGame(false,2, 0);
		executeGame(false,12, 28);
		executeGame(false,17, 26);
		executeGame(false,23, 24);
		executeGame(false,30, 22);
		executeGame(false,21, 20);
		executeGame(false,16, 18);
		executeGame(false,3, 15);
		executeGame(false,11, 13);
		executeGame(false,4, 19);
		executeGame(false,29, 14);
		executeGame(false,5, 6);
		executeGame(false,9, 31);
		executeGame(false,7, 25);
		executeGame(false,27, 10);
		executeGame(false,1, 8);
		writer.println();
		executeGame(false,0, 20);
		executeGame(false,22, 18);
		executeGame(false,24, 15);
		executeGame(false,26, 13);
		executeGame(false,28, 19);
		executeGame(false,2, 14);
		executeGame(false,12, 6);
		executeGame(false,17, 31);
		executeGame(false,23, 25);
		executeGame(false,30, 10);
		executeGame(false,21, 8);
		executeGame(false,16, 1);
		executeGame(false,3, 27);
		executeGame(false,11, 7);
		executeGame(false,4, 9);
		executeGame(false,29, 5);
		writer.println();
		executeGame(false,0, 11);
		executeGame(false,4, 27);
		executeGame(false,29, 7);
		executeGame(false,5, 9);
		executeGame(false,1, 8);
		executeGame(false,10, 19);
		executeGame(false,25, 14);
		executeGame(false,31, 6);
		executeGame(false,13, 15);
		executeGame(false,18, 28);
		executeGame(false,20, 26);
		executeGame(false,22, 24);
		executeGame(false,2, 12) ;
		executeGame(false,17, 3) ;
		executeGame(false,23, 16) ;
		executeGame(false,30, 21);
		writer.println();
		executeGame(false,7, 0);
		executeGame(false,27, 9);
		executeGame(false,1, 5);
		executeGame(false,8, 29);
		executeGame(false,10, 4);
		executeGame(false,25, 11);
		executeGame(false,31, 3) ;
		executeGame(false,6, 16) ;
		executeGame(false,14, 21);
		executeGame(false,19, 30);
		executeGame(false,13, 23);
		executeGame(false,15, 17);
		executeGame(false,18, 12) ;
		executeGame(false,20, 2);
		executeGame(false,22, 28);
		executeGame(false,24, 26);
		writer.println();
		executeGame(false,0, 11);
		executeGame(false,4, 27);
		executeGame(false,29, 7);
		executeGame(false,5, 9);
		executeGame(false,1, 8);
		executeGame(false,10, 19);
		executeGame(false,25, 14);
		executeGame(false,31, 6);
		executeGame(false,13, 15);
		executeGame(false,18, 28);
		executeGame(false,20, 26);
		executeGame(false,22, 24);
		executeGame(false,2, 12) ;
		executeGame(false,17, 3) ;
		executeGame(false,23, 16) ;
		executeGame(false,30, 21);
		writer.println();
		executeGame(false,0, 25);
		executeGame(false,31, 10);
		executeGame(false,6, 8);
		executeGame(false,14, 1);
		executeGame(false,19, 27);
		executeGame(false,13, 7);
		executeGame(false,15, 9);
		executeGame(false,18, 5);
		executeGame(false,20, 29);
		executeGame(false,22, 4);
		executeGame(false,24, 11);
		executeGame(false,26, 3) ;
		executeGame(false,28, 16) ;
		executeGame(false,2, 21);
		executeGame(false,12, 30);
		executeGame(false,17, 23);
		writer.println();
		executeGame(false,0, 9);
		executeGame(false,7, 5);
		executeGame(false,27, 29);
		executeGame(false,1, 4);
		executeGame(false,8, 11);
		executeGame(false,10, 3) ;
		executeGame(false,25, 16) ;
		executeGame(false,31, 21);
		executeGame(false,6, 30);
		executeGame(false,14, 23);
		executeGame(false,19, 17);
		executeGame(true,13, 12) ;
		executeGame(false,15, 2);
		executeGame(false,18, 28);
		executeGame(false,20, 26);
		executeGame(false,22, 24);
		writer.println();
		executeGame(false,0, 15);
		executeGame(false,18, 13);
		executeGame(false,20, 19);
		executeGame(false,22, 14);
		executeGame(false,24, 6);
		executeGame(false,26, 31);
		executeGame(false,28, 25);
		executeGame(false,2, 10);
		executeGame(false,12, 8);
		executeGame(false,17, 1);
		executeGame(false,23, 27);
		executeGame(false,30, 7);
		executeGame(false,21, 9);
		executeGame(false,16, 5);
		executeGame(false,3, 29);
		executeGame(false,11, 4);
		writer.println();
		executeGame(false,5, 0);
		executeGame(false,9, 29);
		executeGame(false,7, 4);
		executeGame(false,27, 11);
		executeGame(false,1, 3) ;
		executeGame(false,8, 16) ;
		executeGame(false,10, 21);
		executeGame(false,25, 30);
		executeGame(false,31, 23);
		executeGame(false,6, 17);
		executeGame(false,14, 12) ;
		executeGame(false,19, 2);
		executeGame(false,13, 28);
		executeGame(false,15, 26);
		executeGame(false,18, 24);
		executeGame(false,20, 22);
		writer.println();
		executeGame(false,14, 0);
		executeGame(false,19, 6);
		executeGame(false,13, 31);
		executeGame(false,15, 25);
		executeGame(false,18, 10);
		executeGame(false,20, 8);
		executeGame(false,22, 1);
		executeGame(false,24, 27);
		executeGame(false,26, 7);
		executeGame(false,28, 9);
		executeGame(false,2, 5);
		executeGame(false,12, 29);
		executeGame(false,17, 4);
		executeGame(false,23, 11);
		executeGame(false,30, 3) ;
		executeGame(false,21, 16) ;
		writer.println();
		executeGame(false,0, 23);
		executeGame(false,30, 17);
		executeGame(false,21, 12) ;
		executeGame(false,16, 2);
		executeGame(false,3, 28);
		executeGame(false,11, 26);
		executeGame(false,4, 24);
		executeGame(false,29, 22);
		executeGame(false,5, 20);
		executeGame(false,9, 18);
		executeGame(false,7, 15);
		executeGame(false,27, 13);
		executeGame(false,1, 19);
		executeGame(false,8, 14);
		executeGame(false,10, 6);
		executeGame(false,25, 31);
		writer.println();
		executeGame(false,7, 0);
		executeGame(false,27, 9);
		executeGame(false,1, 5);
		executeGame(false,8, 29);
		executeGame(false,10, 4);
		executeGame(false,25, 11);
		executeGame(false,31, 3) ;
		executeGame(false,6, 16) ;
		executeGame(false,14, 21);
		executeGame(false,19, 30);
		executeGame(false,13, 23);
		executeGame(false,15, 17);
		executeGame(false,18, 12) ;
		executeGame(false,20, 2);
		executeGame(false,22, 28);
		executeGame(false,24, 26);
		writer.println();
		executeGame(false,0, 9);
		executeGame(false,7, 5);
		executeGame(false,27, 29);
		executeGame(false,1, 4);
		executeGame(false,8, 11);
		executeGame(false,10, 3) ;
		executeGame(false,25, 16) ;
		executeGame(false,31, 21);
		executeGame(false,6, 30);
		executeGame(false,14, 23);
		executeGame(false,19, 17);
		executeGame(false,13, 12) ;
		executeGame(false,15, 2);
		executeGame(false,18, 28);
		executeGame(false,20, 26);
		executeGame(false,22, 24);
		writer.println();
		executeGame(false,0, 21);
		executeGame(false,16, 30);
		executeGame(false,3, 23);
		executeGame(false,11, 17);
		executeGame(false,4, 12) ;
		executeGame(false,29, 2);
		executeGame(false,5, 28);
		executeGame(false,9, 26);
		executeGame(false,7, 24);
		executeGame(false,27, 22);
		executeGame(false,1, 20);
		executeGame(false,8, 18);
		executeGame(false,10, 15);
		executeGame(false,25, 13);
		executeGame(false,31, 19);
		executeGame(false,6, 14);
		writer.println();
		executeGame(false,0, 19);
		executeGame(false,13, 14);
		executeGame(false,15, 6);
		executeGame(false,18, 31);
		executeGame(false,20, 25);
		executeGame(false,22, 10);
		executeGame(false,24, 8);
		executeGame(false,26, 1);
		executeGame(false,28, 27);
		executeGame(false,2, 7);
		executeGame(false,12, 9);
		executeGame(false,17, 5);
		executeGame(false,23, 29);
		executeGame(false,30, 4);
		executeGame(false,21, 11);
		executeGame(false,16, 3) ;
		writer.println();
		executeGame(false,0, 3) ;
		executeGame(false,11, 16) ;
		executeGame(false,4, 21);
		executeGame(false,29, 30);
		executeGame(false,5, 23);
		executeGame(false,9, 17);
		executeGame(false,7, 12) ;
		executeGame(false,27, 2);
		executeGame(false,1, 28);
		executeGame(false,8, 26);
		executeGame(false,10, 24);
		executeGame(false,25, 22);
		executeGame(false,31, 20);
		executeGame(false,6, 18);
		executeGame(false,14, 15);
		executeGame(false,19, 13);
		writer.println();
		executeGame(false,0, 15);
		executeGame(false,18, 13);
		executeGame(false,20, 19);
		executeGame(false,22, 14);
		executeGame(false,24, 6);
		executeGame(false,26, 31);
		executeGame(false,28, 25);
		executeGame(false,2, 10);
		executeGame(false,12, 8);
		executeGame(false,17, 1);
		executeGame(false,23, 27);
		executeGame(false,30, 7);
		executeGame(false,21, 9);
		executeGame(false,16, 5);
		executeGame(false,3, 29);
		executeGame(false,11, 4);
		writer.println();
		executeGame(false,0, 25);
		executeGame(false,31, 10);
		executeGame(false,6, 8);
		executeGame(false,14, 1);
		executeGame(false,19, 27);
		executeGame(false,13, 7);
		executeGame(false,15, 9);
		executeGame(false,18, 5);
		executeGame(false,20, 29);
		executeGame(false,22, 4);
		executeGame(false,24, 11);
		executeGame(false,26, 3) ;
		executeGame(false,28, 16) ;
		executeGame(false,2, 21);
		executeGame(false,12, 30);
		executeGame(false,17, 23);	
		
		
	executeGame(false,17, 0);
	executeGame(false,23, 12) ;
	executeGame(false,30, 2);
	executeGame(false,21, 28);
	executeGame(false,16, 26);
	executeGame(false,3, 24);
	executeGame(false,11, 22);
	executeGame(false,4, 20);
	executeGame(false,29, 18);
	executeGame(false,5, 15);
	executeGame(false,9, 13);
	executeGame(false,7, 19);
	executeGame(false,27, 14);
	executeGame(false,1, 6);
	executeGame(false,8, 31);
	executeGame(false,10, 25);
	
	writer.println();
	executeGame(false,16, 0);
	executeGame(false,3, 21);
	executeGame(false,11, 30);
	executeGame(false,4, 23);
	executeGame(false,29, 17);
	executeGame(false,5, 12) ;
	executeGame(false,9, 2);
	executeGame(false,7, 28);
	executeGame(false,27, 26);
	executeGame(false,1, 24);
	executeGame(false,8, 22);
	executeGame(false,10, 20);
	executeGame(false,25, 18);
	executeGame(false,31, 15);
	executeGame(false,6, 13);
	executeGame(false,14, 19);
	writer.println();
	executeGame(false,0, 24);
	executeGame(false,26, 22);
	executeGame(false,28, 20);
	executeGame(false,2, 18);
	executeGame(false,12, 15);
	executeGame(false,17, 13);
	executeGame(false,23, 19);
	executeGame(false,30, 14);
	executeGame(false,21, 6);
	executeGame(false,16, 31);
	executeGame(false,3, 25);
	executeGame(false,11, 10);
	executeGame(false,4, 8);
	executeGame(false,29, 1);
	executeGame(false,5, 27);
	executeGame(false,9, 7);
	writer.println();
	executeGame(false,0, 27);
	executeGame(false,1, 7);
	executeGame(false,8, 9);
	executeGame(false,10, 5);
	executeGame(false,25, 29);
	executeGame(false,31, 4);
	executeGame(false,6, 11);
	executeGame(false,14, 3) ;
	executeGame(false,19, 16) ;
	executeGame(false,13, 21);
	executeGame(false,15, 30);
	executeGame(false,18, 23);
	executeGame(false,20, 17);
	executeGame(false,22, 12) ;
	executeGame(false,24, 2);
	executeGame(false,26, 28);
	writer.println();
	executeGame(false,0, 27);
	executeGame(false,1, 7);
	executeGame(false,8, 9);
	executeGame(false,10, 5);
	executeGame(false,25, 29);
	executeGame(false,31, 4);
	executeGame(false,6, 11);
	executeGame(false,14, 3) ;
	executeGame(false,19, 16) ;
	executeGame(false,13, 21);
	executeGame(false,15, 30);
	executeGame(false,18, 23);
	executeGame(false,20, 17);
	executeGame(false,22, 12) ;
	executeGame(false,24, 2);
	executeGame(false,26, 28);
	writer.println();
	executeGame(false,0, 6);
	executeGame(false,14, 31);
	executeGame(false,19, 25);
	executeGame(false,13, 10);
	executeGame(false,15, 8);
	executeGame(false,18, 1);
	executeGame(false,20, 27);
	executeGame(false,22, 7);
	executeGame(false,24, 9);
	executeGame(false,26, 5);
	executeGame(false,28, 29);
	executeGame(false,2, 4);
	executeGame(false,12, 11);
	executeGame(false,17, 3) ;
	executeGame(false,23, 16) ;
	executeGame(false,30, 21);
	writer.println();
	executeGame(false,0, 29);
	executeGame(false,5, 4);
	executeGame(false,9, 11);
	executeGame(false,7, 27);
	executeGame(false,1, 25);
	executeGame(false,31, 10);
	executeGame(false,6, 8);
	executeGame(false,14, 19);
	executeGame(false,13, 20);
	executeGame(false,22, 18);
	executeGame(false,24, 15);
	executeGame(false,26, 28);
	executeGame(false,2, 23);
	executeGame(false,30, 17);
	executeGame(false,21, 12) ;
	executeGame(false,16, 3) ;
	writer.println();
	executeGame(false,0, 9);
	executeGame(false,7, 5);
	executeGame(false,27, 29);
	executeGame(false,11, 4);
	executeGame(false,1, 6);
	executeGame(false,14, 31);
	executeGame(false,19, 25);
	executeGame(false,8, 10);
	executeGame(false,13, 24);
	executeGame(false,26, 22);
	executeGame(false,28, 20);
	executeGame(false,15, 18);
	executeGame(false,2, 21);
	executeGame(false,16, 30);
	executeGame(false,3, 23);
	executeGame(false,12, 17);
	writer.println();
	executeGame(false,0, 27);
	executeGame(false,11, 7);
	executeGame(false,4, 9);
	executeGame(false,29, 5);
	executeGame(false,1, 19);
	executeGame(false,8, 14);
	executeGame(false,10, 6);
	executeGame(false,25, 31);
	executeGame(false,13, 28);
	executeGame(false,15, 26);
	executeGame(false,18, 24);
	executeGame(false,20, 22);
	executeGame(false,2, 3) ;
	executeGame(false,12, 16) ;
	executeGame(false,17, 21);
	executeGame(false,23, 30);
	writer.println();
	executeGame(false,10, 0);
	executeGame(false,25, 8);
	executeGame(false,31, 1);
	executeGame(false,6, 27);
	executeGame(false,14, 7);
	executeGame(false,19, 9);
	executeGame(false,13, 5);
	executeGame(false,15, 29);
	executeGame(false,18, 4);
	executeGame(false,20, 11);
	executeGame(false,22, 3) ;
	executeGame(false,24, 16) ;
	executeGame(false,26, 21);
	executeGame(false,28, 30);
	executeGame(false,2, 23);
	executeGame(false,12, 17);
	writer.println();
	executeGame(false,10, 0);
	executeGame(false,25, 8);
	executeGame(false,31, 1);
	executeGame(false,6, 27);
	executeGame(false,14, 7);
	executeGame(false,19, 9);
	executeGame(false,13, 5);
	executeGame(false,15, 29);
	executeGame(false,18, 4);
	executeGame(false,20, 11);
	executeGame(false,22, 3) ;
	executeGame(false,24, 16) ;
	executeGame(false,26, 21);
	executeGame(false,28, 30);
	executeGame(false,2, 23);
	executeGame(false,12, 17);
	writer.println();
	executeGame(false,18, 0);
	executeGame(false,20, 15);
	executeGame(false,22, 13);
	executeGame(false,24, 19);
	executeGame(false,26, 14);
	executeGame(false,28, 6);
	executeGame(false,2, 31);
	executeGame(false,12, 25);
	executeGame(false,17, 10);
	executeGame(false,23, 8);
	executeGame(false,30, 1);
	executeGame(false,21, 27);
	executeGame(false,16, 7);
	executeGame(false,3, 9);
	executeGame(false,11, 5);
	executeGame(false,4, 29);
	writer.println();
	executeGame(false,5, 0);
	executeGame(false,9, 29);
	executeGame(false,7, 4);
	executeGame(false,27, 11);
	executeGame(false,1, 3) ;
	executeGame(false,8, 16) ;
	executeGame(false,10, 21);
	executeGame(false,25, 30);
	executeGame(false,31, 23);
	executeGame(false,6, 17);
	executeGame(false,14, 12) ;
	executeGame(false,19, 2);
	executeGame(false,13, 28);
	executeGame(false,15, 26);
	executeGame(false,18, 24);
	executeGame(false,20, 22);
	writer.println();
	executeGame(false,0, 11);
	executeGame(false,4, 3) ;
	executeGame(false,29, 16) ;
	executeGame(false,5, 21);
	executeGame(false,9, 30);
	executeGame(false,7, 23);
	executeGame(false,27, 17);
	executeGame(false,1, 12) ;
	executeGame(false,8, 2);
	executeGame(false,10, 28);
	executeGame(false,25, 26);
	executeGame(false,31, 24);
	executeGame(false,6, 22);
	executeGame(false,14, 20);
	executeGame(false,19, 18);
	executeGame(false,13, 15);
	writer.println();
	executeGame(false,5, 0);
	executeGame(false,9, 29);
	executeGame(false,7, 4);
	executeGame(false,27, 11);
	executeGame(false,31, 1);
	executeGame(false,6, 25);
	executeGame(false,14, 10);
	executeGame(false,19, 8);
	executeGame(false,22, 13);
	executeGame(false,24, 20);
	executeGame(false,26, 18);
	executeGame(false,28, 15);
	executeGame(false,30, 2);
	executeGame(false,21, 23);
	executeGame(false,16, 17);
	executeGame(false,3, 12) ;
	writer.println();
	executeGame(false,4, 0);
	executeGame(false,29, 11);
	executeGame(false,5, 27);
	executeGame(false,9, 7);
	executeGame(false,10, 1);
	executeGame(false,25, 8);
	executeGame(false,31, 19);
	executeGame(false,6, 14);
	executeGame(false,18, 13);
	executeGame(false,20, 15);
	executeGame(false,22, 28);
	executeGame(false,24, 26);
	executeGame(false,17, 2);
	executeGame(false,23, 12) ;
	executeGame(false,30, 3) ;
	executeGame(false,21, 16) ;
	writer.println();
	executeGame(false,0, 29);
	executeGame(false,5, 4);
	executeGame(false,9, 11);
	executeGame(false,7, 3) ;
	executeGame(false,27, 16) ;
	executeGame(false,1, 21);
	executeGame(false,8, 30);
	executeGame(false,10, 23);
	executeGame(false,25, 17);
	executeGame(false,31, 12) ;
	executeGame(false,6, 2);
	executeGame(false,14, 28);
	executeGame(false,19, 26);
	executeGame(false,13, 24);
	executeGame(false,15, 22);
	executeGame(false,18, 20);
	writer.println();
	executeGame(false,13, 0);
	executeGame(false,15, 19);
	executeGame(false,18, 14);
	executeGame(false,20, 6);
	executeGame(false,22, 31);
	executeGame(false,24, 25);
	executeGame(false,26, 10);
	executeGame(false,28, 8);
	executeGame(false,2, 1);
	executeGame(false,12, 27);
	executeGame(false,17, 7);
	executeGame(false,23, 9);
	executeGame(false,30, 5);
	executeGame(false,21, 29);
	executeGame(false,16, 4);
	executeGame(false,3, 11);
	writer.println();
	executeGame(false,2, 0);
	executeGame(false,12, 28);
	executeGame(false,17, 26);
	executeGame(false,23, 24);
	executeGame(false,30, 22);
	executeGame(false,21, 20);
	executeGame(false,16, 18);
	executeGame(false,3, 15);
	executeGame(false,11, 13);
	executeGame(false,4, 19);
	executeGame(false,29, 14);
	executeGame(false,5, 6);
	executeGame(false,9, 31);
	executeGame(false,7, 25);
	executeGame(false,27, 10);
	executeGame(false,1, 8);
	writer.println();
	executeGame(false,0, 20);
	executeGame(false,22, 18);
	executeGame(false,24, 15);
	executeGame(false,26, 13);
	executeGame(false,28, 19);
	executeGame(false,2, 14);
	executeGame(false,12, 6);
	executeGame(false,17, 31);
	executeGame(false,23, 25);
	executeGame(false,30, 10);
	executeGame(false,21, 8);
	executeGame(false,16, 1);
	executeGame(false,3, 27);
	executeGame(false,11, 7);
	executeGame(false,4, 9);
	executeGame(false,29, 5);
	writer.println();
	executeGame(false,0, 11);
	executeGame(false,4, 27);
	executeGame(false,29, 7);
	executeGame(false,5, 9);
	executeGame(false,1, 8);
	executeGame(false,10, 19);
	executeGame(false,25, 14);
	executeGame(false,31, 6);
	executeGame(false,13, 15);
	executeGame(false,18, 28);
	executeGame(false,20, 26);
	executeGame(false,22, 24);
	executeGame(false,2, 12) ;
	executeGame(false,17, 3) ;
	executeGame(false,23, 16) ;
	executeGame(false,30, 21);
	writer.println();
	executeGame(false,7, 0);
	executeGame(false,27, 9);
	executeGame(false,1, 5);
	executeGame(false,8, 29);
	executeGame(false,10, 4);
	executeGame(false,25, 11);
	executeGame(false,31, 3) ;
	executeGame(false,6, 16) ;
	executeGame(false,14, 21);
	executeGame(false,19, 30);
	executeGame(false,13, 23);
	executeGame(false,15, 17);
	executeGame(false,18, 12) ;
	executeGame(false,20, 2);
	executeGame(false,22, 28);
	executeGame(false,24, 26);
	writer.println();
	executeGame(false,0, 11);
	executeGame(false,4, 27);
	executeGame(false,29, 7);
	executeGame(false,5, 9);
	executeGame(false,1, 8);
	executeGame(false,10, 19);
	executeGame(false,25, 14);
	executeGame(false,31, 6);
	executeGame(false,13, 15);
	executeGame(false,18, 28);
	executeGame(false,20, 26);
	executeGame(false,22, 24);
	executeGame(false,2, 12) ;
	executeGame(false,17, 3) ;
	executeGame(false,23, 16) ;
	executeGame(false,30, 21);
	writer.println();
	executeGame(false,0, 25);
	executeGame(false,31, 10);
	executeGame(false,6, 8);
	executeGame(false,14, 1);
	executeGame(false,19, 27);
	executeGame(false,13, 7);
	executeGame(false,15, 9);
	executeGame(false,18, 5);
	executeGame(false,20, 29);
	executeGame(false,22, 4);
	executeGame(false,24, 11);
	executeGame(false,26, 3) ;
	executeGame(false,28, 16) ;
	executeGame(false,2, 21);
	executeGame(false,12, 30);
	executeGame(false,17, 23);
	writer.println();
	executeGame(false,0, 9);
	executeGame(false,7, 5);
	executeGame(false,27, 29);
	executeGame(false,1, 4);
	executeGame(false,8, 11);
	executeGame(false,10, 3) ;
	executeGame(false,25, 16) ;
	executeGame(false,31, 21);
	executeGame(false,6, 30);
	executeGame(false,14, 23);
	executeGame(false,19, 17);
	executeGame(true,13, 12) ;
	executeGame(false,15, 2);
	executeGame(false,18, 28);
	executeGame(false,20, 26);
	executeGame(false,22, 24);
	writer.println();
	executeGame(false,0, 15);
	executeGame(false,18, 13);
	executeGame(false,20, 19);
	executeGame(false,22, 14);
	executeGame(false,24, 6);
	executeGame(false,26, 31);
	executeGame(false,28, 25);
	executeGame(false,2, 10);
	executeGame(false,12, 8);
	executeGame(false,17, 1);
	executeGame(false,23, 27);
	executeGame(false,30, 7);
	executeGame(false,21, 9);
	executeGame(false,16, 5);
	executeGame(false,3, 29);
	executeGame(false,11, 4);
	writer.println();
	executeGame(false,5, 0);
	executeGame(false,9, 29);
	executeGame(false,7, 4);
	executeGame(false,27, 11);
	executeGame(false,1, 3) ;
	executeGame(false,8, 16) ;
	executeGame(false,10, 21);
	executeGame(false,25, 30);
	executeGame(false,31, 23);
	executeGame(false,6, 17);
	executeGame(false,14, 12) ;
	executeGame(false,19, 2);
	executeGame(false,13, 28);
	executeGame(false,15, 26);
	executeGame(false,18, 24);
	executeGame(false,20, 22);
	writer.println();
	executeGame(false,14, 0);
	executeGame(false,19, 6);
	executeGame(false,13, 31);
	executeGame(false,15, 25);
	executeGame(false,18, 10);
	executeGame(false,20, 8);
	executeGame(false,22, 1);
	executeGame(false,24, 27);
	executeGame(false,26, 7);
	executeGame(false,28, 9);
	executeGame(false,2, 5);
	executeGame(false,12, 29);
	executeGame(false,17, 4);
	executeGame(false,23, 11);
	executeGame(false,30, 3) ;
	executeGame(false,21, 16) ;
	writer.println();
	executeGame(false,0, 23);
	executeGame(false,30, 17);
	executeGame(false,21, 12) ;
	executeGame(false,16, 2);
	executeGame(false,3, 28);
	executeGame(false,11, 26);
	executeGame(false,4, 24);
	executeGame(false,29, 22);
	executeGame(false,5, 20);
	executeGame(false,9, 18);
	executeGame(false,7, 15);
	executeGame(false,27, 13);
	executeGame(false,1, 19);
	executeGame(false,8, 14);
	executeGame(false,10, 6);
	executeGame(false,25, 31);
	writer.println();
	executeGame(false,7, 0);
	executeGame(false,27, 9);
	executeGame(false,1, 5);
	executeGame(false,8, 29);
	executeGame(false,10, 4);
	executeGame(false,25, 11);
	executeGame(false,31, 3) ;
	executeGame(false,6, 16) ;
	executeGame(false,14, 21);
	executeGame(false,19, 30);
	executeGame(false,13, 23);
	executeGame(false,15, 17);
	executeGame(false,18, 12) ;
	executeGame(false,20, 2);
	executeGame(false,22, 28);
	executeGame(false,24, 26);
	writer.println();
	executeGame(false,0, 9);
	executeGame(false,7, 5);
	executeGame(false,27, 29);
	executeGame(false,1, 4);
	executeGame(false,8, 11);
	executeGame(false,10, 3) ;
	executeGame(false,25, 16) ;
	executeGame(false,31, 21);
	executeGame(false,6, 30);
	executeGame(false,14, 23);
	executeGame(false,19, 17);
	executeGame(false,13, 12) ;
	executeGame(false,15, 2);
	executeGame(false,18, 28);
	executeGame(false,20, 26);
	executeGame(false,22, 24);
	writer.println();
	executeGame(false,0, 21);
	executeGame(false,16, 30);
	executeGame(false,3, 23);
	executeGame(false,11, 17);
	executeGame(false,4, 12) ;
	executeGame(false,29, 2);
	executeGame(false,5, 28);
	executeGame(false,9, 26);
	executeGame(false,7, 24);
	executeGame(false,27, 22);
	executeGame(false,1, 20);
	executeGame(false,8, 18);
	executeGame(false,10, 15);
	executeGame(false,25, 13);
	executeGame(false,31, 19);
	executeGame(false,6, 14);
	writer.println();
	executeGame(false,0, 19);
	executeGame(false,13, 14);
	executeGame(false,15, 6);
	executeGame(false,18, 31);
	executeGame(false,20, 25);
	executeGame(false,22, 10);
	executeGame(false,24, 8);
	executeGame(false,26, 1);
	executeGame(false,28, 27);
	executeGame(false,2, 7);
	executeGame(false,12, 9);
	executeGame(false,17, 5);
	executeGame(false,23, 29);
	executeGame(false,30, 4);
	executeGame(false,21, 11);
	executeGame(false,16, 3) ;
	writer.println();
	executeGame(false,0, 3) ;
	executeGame(false,11, 16) ;
	executeGame(false,4, 21);
	executeGame(false,29, 30);
	executeGame(false,5, 23);
	executeGame(false,9, 17);
	executeGame(false,7, 12) ;
	executeGame(false,27, 2);
	executeGame(false,1, 28);
	executeGame(false,8, 26);
	executeGame(false,10, 24);
	executeGame(false,25, 22);
	executeGame(false,31, 20);
	executeGame(false,6, 18);
	executeGame(false,14, 15);
	executeGame(false,19, 13);
	writer.println();
	executeGame(false,0, 15);
	executeGame(false,18, 13);
	executeGame(false,20, 19);
	executeGame(false,22, 14);
	executeGame(false,24, 6);
	executeGame(false,26, 31);
	executeGame(false,28, 25);
	executeGame(false,2, 10);
	executeGame(false,12, 8);
	executeGame(false,17, 1);
	executeGame(false,23, 27);
	executeGame(false,30, 7);
	executeGame(false,21, 9);
	executeGame(false,16, 5);
	executeGame(false,3, 29);
	executeGame(false,11, 4);
	writer.println();
	executeGame(false,0, 25);
	executeGame(false,31, 10);
	executeGame(false,6, 8);
	executeGame(false,14, 1);
	executeGame(false,19, 27);
	executeGame(false,13, 7);
	executeGame(false,15, 9);
	executeGame(false,18, 5);
	executeGame(false,20, 29);
	executeGame(false,22, 4);
	executeGame(false,24, 11);
	executeGame(false,26, 3) ;
	executeGame(false,28, 16) ;
	executeGame(false,2, 21);
	executeGame(false,12, 30);
	executeGame(false,17, 23);

		 







	}
	private static void saveData()
	{
		System.out.println("Would you like to save your basketball?");

		if (kb.nextLine().toLowerCase().equals("yes"))
		{
			// Write to disk with FileOutputStream
			FileOutputStream f_out;
			ObjectOutputStream obj_out;
			try
			{
				f_out = new FileOutputStream("teams.data");
				// Write object with ObjectOutputStream
				obj_out = new ObjectOutputStream (f_out);

				// Write object out to disk
				obj_out.writeObject(create);
				obj_out.close();

			}
			catch (FileNotFoundException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}



		}

	}

	private static void stats()
	{
		for(int i = 0; i<create.size() ;i++)
		{

			writer.println("" + create.getTeam(i).getTeamName() + " went " + create.getTeam(i).getWins() + " - " + (create.getTeam(i).getLosses()) + ". They scored " + create.getTeam(i).getPoints() + " points and gave up " + create.getTeam(i).getPointsAgainst() + " points. Here are their player stats!");
			stats.println(create.getTeam(i).getTeamName() + " players,Minutes,Assists,Points,Shots Taken,Shots Made,Field Goal Percentage,Threes Taken,Threes Made,Free Throws Taken,Free Throws Made,Turnovers,Steals,Rebounds,Offensive Rebounds,Defensive Rebounds,Fouls,Opponent Shots Against,Opponent Shots Made,Opponent Shot Percent");
			for(int k = 0; k <create.getTeam(i).getSize(); k++)
			{
				double shootingPercentage = 0.0, opponentPercentage = 0.0;
				if(create.getTeam(i).getPlayer(k).getShotsTaken() != 0)
				{

					shootingPercentage = ((double)create.getTeam(i).getPlayer(k).getShotsMade()/(double)create.getTeam(i).getPlayer(k).getShotsTaken())*100;
				}
				if(create.getTeam(i).getPlayer(k).getShotsAttemptedAgainst() != 0)
					opponentPercentage = ((double)create.getTeam(i).getPlayer(k).getShotsMadeAgainst()/(double)create.getTeam(i).getPlayer(k).getShotsAttemptedAgainst())*100;
				stats.println(create.getTeam(i).getPlayer(k).getName() + "," + create.getTeam(i).getPlayer(k).getMinutes() + "," + create.getTeam(i).getPlayer(k).getAssists() + "," + create.getTeam(i).getPlayer(k).getPoints() + "," + create.getTeam(i).getPlayer(k).getShotsTaken() + "," 
						+ create.getTeam(i).getPlayer(k).getShotsMade() + "," + shootingPercentage + "," + create.getTeam(i).getPlayer(k).getThreesTaken() + "," + create.getTeam(i).getPlayer(k).getThreePointersMade() + "," + create.getTeam(i).getPlayer(k).getFreeThrowsTaken() + "," + create.getTeam(i).getPlayer(k).getFreeThrowsMade() 
						+ "," + create.getTeam(i).getPlayer(k).getTurnovers() + "," + create.getTeam(i).getPlayer(k).getSteals() + "," + create.getTeam(i).getPlayer(k).getRebounds() + "," + create.getTeam(i).getPlayer(k).getOffensiveRebounds() + "," + create.getTeam(i).getPlayer(k).getDefensiveRebounds() 
						+ "," + create.getTeam(i).getPlayer(k).getFouls() + "," + create.getTeam(i).getPlayer(k).getShotsAttemptedAgainst() + "," + create.getTeam(i).getPlayer(k).getShotsMadeAgainst() + "," 
						+ opponentPercentage);
			}
			//standings(create.getTeam(i));
		}

	}

	private static void standings(team team)
	{
		standings.println("" + team.getTeamName() + "," + team.getWins() + "," + team.getLosses() + "," + team.getPoints() + "," + team.getPointsAgainst() + "," + team.getDivisionRank() + "," + team.getConferenceRank() + "," + team.getLeagueRank());

	}

	private static void executeGame(boolean b, int i, int j)
	{
		int away = create.getTeam(i).lastThreeGames(-1);
		int home = create.getTeam(j).lastThreeGames(-1);

		Random r = new Random();
		int randomValue = r.nextInt(100);
		boolean bob = false;
		if(away == 0 && home == 0)
		{
			if(randomValue < 10)
			{
				create.getTeam(i).setModifier(new BounceBackGame());
				create.getTeam(j).setModifier(new None());
			}
			else if(randomValue < 30)
			{
				create.getTeam(i).setModifier(new DefensiveNightmare());
				create.getTeam(j).setModifier(new DefensiveNightmare());
			}
			else if(randomValue < 40)
			{
				create.getTeam(i).setModifier(new None());
				create.getTeam(j).setModifier(new BounceBackGame());
			}
			else
			{
				create.getTeam(i).setModifier(new None());
				create.getTeam(j).setModifier(new None());
			}
		}
		else if((away == 0 || away == 1) && home == 3)
		{
			if(randomValue < 15)
			{
				create.getTeam(i).setModifier(new BounceBackGame());
				create.getTeam(j).setModifier(new LetDownGame());
				//System.out.println(create.getTeam(i).getTeamName() + " had a bounce back game against " + create.getTeam(j).getTeamName());
				bob = true;
			}
			else if(randomValue < 25)
			{
				create.getTeam(i).setModifier(new StrugglesContinue());
				create.getTeam(j).setModifier(new ContinueRolling());
			}
			else
			{
				create.getTeam(i).setModifier(new None());
				create.getTeam(j).setModifier(new None());
			}

		}
		else if((home == 0 || home == 1)&& away == 3)
		{
			if(randomValue < 15)
			{
				create.getTeam(j).setModifier(new BounceBackGame());
				create.getTeam(i).setModifier(new LetDownGame());
				//System.out.println(create.getTeam(j).getTeamName() + " had a bounce back game against " + create.getTeam(i).getTeamName());
				bob = true;
			}
			else if(randomValue < 25)
			{
				create.getTeam(j).setModifier(new StrugglesContinue());
				create.getTeam(i).setModifier(new ContinueRolling());
			}
			else
			{
				create.getTeam(j).setModifier(new None());
				create.getTeam(i).setModifier(new None());
			}
		}
		else if(away == 3 && home == 3)
		{
			if(randomValue < 5)
			{
				create.getTeam(i).setModifier(new ContinueRolling());
				create.getTeam(j).setModifier(new LetDownGame());
			}
			else if(randomValue < 10)
			{
				create.getTeam(i).setModifier(new LetDownGame());
				create.getTeam(j).setModifier(new ContinueRolling());
			}
			else
			{
				create.getTeam(i).setModifier(new None());
				create.getTeam(j).setModifier(new None());
			}

		}
		else
		{
			if(randomValue < 12)
			{
				create.getTeam(i).setModifier(new DefensiveNightmare());
				create.getTeam(j).setModifier(new None());
			}
			else if(randomValue < 25)
			{
				create.getTeam(i).setModifier(new OffenisveNightmare());
				create.getTeam(j).setModifier(new OffenisveNightmare());
			}
			else
			{
				create.getTeam(i).setModifier(new None());
				create.getTeam(j).setModifier(new None());
			}
		}

		game newGame = new game(create.getTeam(i), create.getTeam(j));

		try
		{


			//writer.println(votingList);
			if(newGame.getWinner())
			{
				writer.println(create.getTeam(i).getTeamName() + " wins! The score was " + newGame.getAwayTeamScore() + " - " + newGame.getHomeTeamScore());

				create.getTeam(i).addWin(1);
				create.getTeam(j).addLoss(1);
			}
			else 
			{
				writer.println(create.getTeam(j).getTeamName() + " wins! The score was " + newGame.getHomeTeamScore() + " - " + newGame.getAwayTeamScore());
				create.getTeam(j).addWin(1);
				create.getTeam(i).addLoss(1);
			}
			if(!bob)gameResults.println("," + create.getTeam(i).getTeamName() + "," + newGame.getAwayTeamScore() + "," + create.getTeam(j).getTeamName()+ "," + newGame.getHomeTeamScore());
			else gameResults.println("," + create.getTeam(i).getTeamName() + "," + newGame.getAwayTeamScore() + "," + create.getTeam(j).getTeamName() + "," + newGame.getHomeTeamScore() + ", BOUNCE");
			//System.out.println(create.getTeam(i).getTeamName() + " has " + create.getTeam(i).lastThreeGames(-1) + " wins in the last three games");
			//System.out.println(create.getTeam(j).getTeamName() + " has " + create.getTeam(j).lastThreeGames(-1) + " wins in the last three games");
			create.getTeam(i).addPoints(newGame.getAwayTeamScore());
			create.getTeam(j).addPoints(newGame.getHomeTeamScore());
			create.getTeam(j).addPointsAgainst(newGame.getAwayTeamScore());
			create.getTeam(i).addPointsAgainst(newGame.getHomeTeamScore());
			if(b)
			{
				PrintWriter writer = new PrintWriter("Game " + (startingGame-1) + " - " + create.getTeam(i).getTeamName() + " - " + create.getTeam(j).getTeamName() + " box score.txt", "UTF-8");
				writer.println("-----------------------------------------------------------");
				writer.printf("| " + StringUtils.rightPad(create.getTeam(i).getTeamName(), 25) + " | " + newGame.getQuarterOneScore()[0] + " | " + newGame.getQuarterTwoScore()[0] + " | " + newGame.getQuarterThreeScore()[0] + " | " + newGame.getQuarterFourScore()[0] + " | " + newGame.getQuarterOTScore()[0] + " | " + StringUtils.rightPad("" + newGame.getAwayTeamScore(),3) + " |\n");
				writer.printf("| " + StringUtils.rightPad(create.getTeam(j).getTeamName(), 25) + " | " + newGame.getQuarterOneScore()[1] + " | " + newGame.getQuarterTwoScore()[1] + " | " + newGame.getQuarterThreeScore()[1] + " | " + newGame.getQuarterFourScore()[1] + " | " + newGame.getQuarterOTScore()[1] + " | " + StringUtils.rightPad("" + newGame.getHomeTeamScore(),3) + " |\n");
				writer.println("-----------------------------------------------------------");
				writer.println(create.getTeam(i).getTeamName());
				writer.println("POS NAME                    MIN  PTS  AST  FGA  FGM    FG%  3TA  3TM  FTA FTM   TO  STL  REB  ORB  DRB  FLS  OSA  OSM    OS%");
				for(int k = 0; k <create.getTeam(i).getSize(); k++)
				{
					String position = "";
					switch(create.getTeam(i).getPlayer(k).getPosition())
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
					if(create.getTeam(i).getPlayer(k).getGameShotsTaken() != 0)
					{

						shootingPercentage = ((double)create.getTeam(i).getPlayer(k).getGameShotsMade()/(double)create.getTeam(i).getPlayer(k).getGameShotsTaken())*100;
					}
					if(create.getTeam(i).getPlayer(k).getGameShotsAttemptedAgainst() != 0)
						opponentPercentage = ((double)create.getTeam(i).getPlayer(k).getGameShotsMadeAgainst()/(double)create.getTeam(i).getPlayer(k).getGameShotsAttemptedAgainst())*100;
					writer.printf(position + StringUtils.rightPad(create.getTeam(i).getPlayer(k).getName(), 25) + "%2d   %2d   %2d   %2d   %2d   %4.1f   %2d   %2d   %2d  %2d   %2d   %2d   %2d   %2d   %2d   %2d   %2d   %2d   %3.1f\n", create.getTeam(i).getPlayer(k).getGameMinutes() , create.getTeam(i).getPlayer(k).getGamePoints() ,create.getTeam(i).getPlayer(k).getGameAssists() ,create.getTeam(i).getPlayer(k).getGameShotsTaken() 
							, create.getTeam(i).getPlayer(k).getGameShotsMade(), shootingPercentage, create.getTeam(i).getPlayer(k).getGameThreesTaken(), create.getTeam(i).getPlayer(k).getGameThreePointersMade(), create.getTeam(i).getPlayer(k).getGameFreeThrowsTaken(),create.getTeam(i).getPlayer(k).getGameFreeThrowsMade() 
							,create.getTeam(i).getPlayer(k).getGameTurnovers(), create.getTeam(i).getPlayer(k).getGameSteals(),create.getTeam(i).getPlayer(k).getGameRebounds(), create.getTeam(i).getPlayer(k).getGameOffensiveRebounds(), create.getTeam(i).getPlayer(k).getGameDefensiveRebounds() 
							, create.getTeam(i).getPlayer(k).getBoxScoreFouls(),create.getTeam(i).getPlayer(k).getGameShotsAttemptedAgainst(), create.getTeam(i).getPlayer(k).getGameShotsMadeAgainst(), 
							opponentPercentage);
				}
				writer.println(create.getTeam(j).getTeamName());
				writer.println("POS NAME                    MIN  PTS  AST  FGA  FGM    FG%  3TA  3TM  FTA FTM   TO  STL  REB  ORB  DRB  FLS  OSA  OSM    OS%");
				for(int k = 0; k <create.getTeam(j).getSize(); k++)
				{
					String position = "";
					switch(create.getTeam(j).getPlayer(k).getPosition())
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
					if(create.getTeam(j).getPlayer(k).getGameShotsTaken() != 0)
					{

						shootingPercentage = ((double)create.getTeam(j).getPlayer(k).getGameShotsMade()/(double)create.getTeam(j).getPlayer(k).getGameShotsTaken())*100;
					}
					if(create.getTeam(j).getPlayer(k).getGameShotsAttemptedAgainst() != 0)
						opponentPercentage = ((double)create.getTeam(j).getPlayer(k).getGameShotsMadeAgainst()/(double)create.getTeam(j).getPlayer(k).getGameShotsAttemptedAgainst())*100;
					writer.printf(position + StringUtils.rightPad(create.getTeam(j).getPlayer(k).getName(), 25) + "%2d   %2d   %2d   %2d   %2d   %4.1f   %2d   %2d   %2d  %2d   %2d   %2d   %2d   %2d   %2d   %2d   %2d   %2d   %3.1f\n", create.getTeam(j).getPlayer(k).getGameMinutes() , create.getTeam(j).getPlayer(k).getGamePoints() ,create.getTeam(j).getPlayer(k).getGameAssists() ,create.getTeam(j).getPlayer(k).getGameShotsTaken() 
							, create.getTeam(j).getPlayer(k).getGameShotsMade(), shootingPercentage, create.getTeam(j).getPlayer(k).getGameThreesTaken(), create.getTeam(j).getPlayer(k).getGameThreePointersMade(), create.getTeam(j).getPlayer(k).getGameFreeThrowsTaken(),create.getTeam(j).getPlayer(k).getGameFreeThrowsMade() 
							,create.getTeam(j).getPlayer(k).getGameTurnovers(), create.getTeam(j).getPlayer(k).getGameSteals(),create.getTeam(j).getPlayer(k).getGameRebounds(), create.getTeam(j).getPlayer(k).getGameOffensiveRebounds(), create.getTeam(j).getPlayer(k).getGameDefensiveRebounds() 
							, create.getTeam(j).getPlayer(k).getBoxScoreFouls(),create.getTeam(j).getPlayer(k).getGameShotsAttemptedAgainst(), create.getTeam(j).getPlayer(k).getGameShotsMadeAgainst(), 
							opponentPercentage);

				}


				writer.close();
			}

		}
		catch(Exception E)
		{
			E.printStackTrace();
			System.out.println("Fuck");
		}

		for(int k = 0; k < create.getTeam(i).getSize(); k++)
		{
			create.getTeam(i).getPlayer(k).resetGameStats();
		}
		for(int k = 0; k < create.getTeam(j).getSize(); k++)
		{
			create.getTeam(j).getPlayer(k).resetGameStats();
		}

	}

}
