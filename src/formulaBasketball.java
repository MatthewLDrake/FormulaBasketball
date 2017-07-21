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

public class formulaBasketball
{
	//TODO: Move aiyota with stedro
	private static PrintWriter writer, gameResults, stats, standings;
	private static createTeams create;
	private static Scanner kb;
	private static int startingGame;
	private static ArrayList<team> DivisionA, DivisionB, DivisionC, DivisionD, ConferenceA, ConferenceB, League;
	private static gameWriter gameWriter;
	private static StringUtils StringUtils;
	public static void main(String[] args)
	{
		StringUtils = new StringUtils();
		boolean loadSave = false;

		System.out.println("Start with previous state?\nNo means begin with default jukebox?");
		kb = new Scanner(System.in);
		loadSave = kb.nextLine().toLowerCase().equals("yes");
		if(loadSave)
		{
			load();
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
		for(int i = 0; i < create.size(); i++)
		{
			create.getTeam(i).setTeamNum(i);
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
			else if(result.toLowerCase().equals("mockplayoffs"))
				mockPlayoffs();
			else if(result.toLowerCase().equals("reload"))
				load();
			else if(result.toLowerCase().equals("wipestats"))
				resetStats();
		}
		calculateStandings();
		stats();


		writer.close();
		stats.close();
		gameResults.close();
		standings.close();
		saveData();
		kb.close();
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
	private static void resetStats()
	{
		try
		{
			writer = new PrintWriter("Results.txt", "UTF-8");
			gameResults = new PrintWriter("GameResults.csv", "UTF-8");
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		for(int i = 0; i < create.size(); i++)
		{
			for(int j = 0; j < create.getTeam(i).getAllPlayer().size(); j++)
			{
				create.getTeam(i).getAllPlayer().get(j).resetAllStats();
			}

		}
	}
	private static void load()
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
	private static boolean mockPlayoffs()
	{
		boolean retVal = true;
		calculateStandings();

		int[] conferenceAWinCounter = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0};
		int[] conferenceBWinCounter = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0};
		int gamesPlayed = 0;
		while(gamesPlayed < 7)
		{
			startingGame = gamesPlayed + 2;
			gameResults.println("Game " +  (startingGame-1) + ",Home,Score,Away,Score");

			if(conferenceAWinCounter[0] != 4 && conferenceAWinCounter[7] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(ConferenceA.get(0).getLeagueRank() < ConferenceA.get(7).getLeagueRank())
				{
					higherSeed = ConferenceA.get(0).getTeamNum();
					lowerSeed = ConferenceA.get(7).getTeamNum();
				}
				else
				{
					higherSeed = ConferenceA.get(7).getTeamNum(); 
					lowerSeed = ConferenceA.get(0).getTeamNum();
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != ConferenceA.get(0).getTeamNum())flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == ConferenceA.get(0).getTeamNum())flag = !flag;
				}
				//boolean flag = executeGame(false, ConferenceA.get(0).getTeamNum(),ConferenceA.get(7).getTeamNum());
				if(flag)conferenceAWinCounter[0]++;
				else conferenceAWinCounter[7]++;
			}
			if(conferenceAWinCounter[1] != 4 && conferenceAWinCounter[6] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(ConferenceA.get(1).getLeagueRank() < ConferenceA.get(6).getLeagueRank())
				{
					higherSeed = ConferenceA.get(1).getTeamNum();
					lowerSeed = ConferenceA.get(6).getTeamNum();
				}
				else
				{
					higherSeed = ConferenceA.get(6).getTeamNum(); 
					lowerSeed = ConferenceA.get(1).getTeamNum();
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != ConferenceA.get(1).getTeamNum())flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == ConferenceA.get(1).getTeamNum())flag = !flag;
				}
				//boolean flag = executeGame(false, ConferenceA.get(1).getTeamNum(),ConferenceA.get(6).getTeamNum());
				if(flag)conferenceAWinCounter[1]++;
				else conferenceAWinCounter[6]++;
			}
			if(conferenceAWinCounter[2] != 4 && conferenceAWinCounter[5] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(ConferenceA.get(2).getLeagueRank() < ConferenceA.get(5).getLeagueRank())
				{
					higherSeed = ConferenceA.get(2).getTeamNum();
					lowerSeed = ConferenceA.get(5).getTeamNum();
				}
				else
				{
					higherSeed = ConferenceA.get(5).getTeamNum(); 
					lowerSeed = ConferenceA.get(2).getTeamNum();
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != ConferenceA.get(2).getTeamNum())flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == ConferenceA.get(2).getTeamNum())flag = !flag;
				}
				//boolean flag = executeGame(false, ConferenceA.get(2).getTeamNum(),ConferenceA.get(5).getTeamNum());
				if(flag)conferenceAWinCounter[2]++;
				else conferenceAWinCounter[5]++;
			}
			if(conferenceAWinCounter[3] != 4 && conferenceAWinCounter[4] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(ConferenceA.get(3).getLeagueRank() < ConferenceA.get(4).getLeagueRank())
				{
					higherSeed = ConferenceA.get(3).getTeamNum();
					lowerSeed = ConferenceA.get(4).getTeamNum();
				}
				else
				{
					higherSeed = ConferenceA.get(4).getTeamNum(); 
					lowerSeed = ConferenceA.get(3).getTeamNum();
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != ConferenceA.get(3).getTeamNum())flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == ConferenceA.get(3).getTeamNum())flag = !flag;
				}
				//boolean flag = executeGame(false, ConferenceA.get(3).getTeamNum(),ConferenceA.get(4).getTeamNum());
				if(flag)conferenceAWinCounter[3]++;
				else conferenceAWinCounter[4]++;
			}
			if(conferenceBWinCounter[0] != 4 && conferenceBWinCounter[7] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(ConferenceB.get(0).getLeagueRank() < ConferenceB.get(7).getLeagueRank())
				{
					higherSeed = ConferenceB.get(0).getTeamNum();
					lowerSeed = ConferenceB.get(7).getTeamNum();
				}
				else
				{
					higherSeed = ConferenceB.get(7).getTeamNum(); 
					lowerSeed = ConferenceB.get(0).getTeamNum();
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != ConferenceB.get(0).getTeamNum())flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == ConferenceB.get(0).getTeamNum())flag = !flag;
				}
				//boolean flag = executeGame(false, ConferenceB.get(0).getTeamNum(),ConferenceB.get(7).getTeamNum());
				if(flag)conferenceBWinCounter[0]++;
				else conferenceBWinCounter[7]++;
			}
			if(conferenceBWinCounter[1] != 4 && conferenceBWinCounter[6] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(ConferenceB.get(1).getLeagueRank() < ConferenceB.get(6).getLeagueRank())
				{
					higherSeed = ConferenceB.get(1).getTeamNum();
					lowerSeed = ConferenceB.get(6).getTeamNum();
				}
				else
				{
					higherSeed = ConferenceB.get(6).getTeamNum(); 
					lowerSeed = ConferenceB.get(1).getTeamNum();
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != ConferenceB.get(1).getTeamNum())flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == ConferenceB.get(1).getTeamNum())flag = !flag;
				}
				//boolean flag = executeGame(false, ConferenceB.get(1).getTeamNum(),ConferenceB.get(6).getTeamNum());
				if(flag)conferenceBWinCounter[1]++;
				else conferenceBWinCounter[6]++;
			}
			if(conferenceBWinCounter[2] != 4 && conferenceBWinCounter[5] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(ConferenceB.get(2).getLeagueRank() < ConferenceB.get(5).getLeagueRank())
				{
					higherSeed = ConferenceB.get(2).getTeamNum();
					lowerSeed = ConferenceB.get(5).getTeamNum();
				}
				else
				{
					higherSeed = ConferenceB.get(5).getTeamNum(); 
					lowerSeed = ConferenceB.get(2).getTeamNum();
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != ConferenceB.get(2).getTeamNum())flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == ConferenceB.get(2).getTeamNum())flag = !flag;
				}
				//boolean flag = executeGame(false, ConferenceB.get(2).getTeamNum(),ConferenceB.get(5).getTeamNum());
				if(flag)conferenceBWinCounter[2]++;
				else conferenceBWinCounter[5]++;
			}
			if(conferenceBWinCounter[3] != 4 && conferenceBWinCounter[4] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(ConferenceB.get(3).getLeagueRank() < ConferenceB.get(4).getLeagueRank())
				{
					higherSeed = ConferenceB.get(3).getTeamNum();
					lowerSeed = ConferenceB.get(4).getTeamNum();
				}
				else
				{
					higherSeed = ConferenceB.get(4).getTeamNum(); 
					lowerSeed = ConferenceB.get(3).getTeamNum();
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != ConferenceB.get(3).getTeamNum())flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == ConferenceB.get(3).getTeamNum())flag = !flag;
				}
				//boolean flag = executeGame(false, ConferenceB.get(3).getTeamNum(),ConferenceB.get(4).getTeamNum());
				if(flag)conferenceBWinCounter[3]++;
				else conferenceBWinCounter[4]++;
			}
			if(conferenceAWinCounter[8] != 4 && conferenceAWinCounter[15] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(ConferenceA.get(8).getLeagueRank() < ConferenceA.get(15).getLeagueRank())
				{
					higherSeed = ConferenceA.get(8).getTeamNum();
					lowerSeed = ConferenceA.get(15).getTeamNum();
				}
				else
				{
					higherSeed = ConferenceA.get(15).getTeamNum(); 
					lowerSeed = ConferenceA.get(8).getTeamNum();
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != ConferenceA.get(8).getTeamNum())flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == ConferenceA.get(8).getTeamNum())flag = !flag;
				}
				//boolean flag = executeGame(false, ConferenceA.get(8).getTeamNum(),ConferenceA.get(15).getTeamNum());
				if(flag)conferenceAWinCounter[8]++;
				else conferenceAWinCounter[15]++;
			}
			if(conferenceAWinCounter[9] != 4 && conferenceAWinCounter[14] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(ConferenceA.get(9).getLeagueRank() < ConferenceA.get(14).getLeagueRank())
				{
					higherSeed = ConferenceA.get(9).getTeamNum();
					lowerSeed = ConferenceA.get(14).getTeamNum();
				}
				else
				{
					higherSeed = ConferenceA.get(14).getTeamNum(); 
					lowerSeed = ConferenceA.get(9).getTeamNum();
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != ConferenceA.get(9).getTeamNum())flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == ConferenceA.get(9).getTeamNum())flag = !flag;
				}
				//boolean flag = executeGame(false, ConferenceA.get(9).getTeamNum(),ConferenceA.get(14).getTeamNum());
				if(flag)conferenceAWinCounter[9]++;
				else conferenceAWinCounter[14]++;
			}
			if(conferenceAWinCounter[10] != 4 && conferenceAWinCounter[13] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(ConferenceA.get(10).getLeagueRank() < ConferenceA.get(13).getLeagueRank())
				{
					higherSeed = ConferenceA.get(10).getTeamNum();
					lowerSeed = ConferenceA.get(13).getTeamNum();
				}
				else
				{
					higherSeed = ConferenceA.get(13).getTeamNum(); 
					lowerSeed = ConferenceA.get(10).getTeamNum();
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != ConferenceA.get(10).getTeamNum())flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == ConferenceA.get(10).getTeamNum())flag = !flag;
				}
				//boolean flag = executeGame(false, ConferenceA.get(10).getTeamNum(),ConferenceA.get(13).getTeamNum());
				if(flag)conferenceAWinCounter[10]++;
				else conferenceAWinCounter[13]++;
			}
			if(conferenceAWinCounter[11] != 4 && conferenceAWinCounter[12] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(ConferenceA.get(11).getLeagueRank() < ConferenceA.get(12).getLeagueRank())
				{
					higherSeed = ConferenceA.get(11).getTeamNum();
					lowerSeed = ConferenceA.get(12).getTeamNum();
				}
				else
				{
					higherSeed = ConferenceA.get(12).getTeamNum(); 
					lowerSeed = ConferenceA.get(11).getTeamNum();
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != ConferenceA.get(11).getTeamNum())flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == ConferenceA.get(11).getTeamNum())flag = !flag;
				}
				//boolean flag = executeGame(false, ConferenceA.get(11).getTeamNum(),ConferenceA.get(12).getTeamNum());
				if(flag)conferenceAWinCounter[11]++;
				else conferenceAWinCounter[12]++;
			}
			if(conferenceBWinCounter[8] != 4 && conferenceBWinCounter[15] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(ConferenceB.get(8).getLeagueRank() < ConferenceB.get(15).getLeagueRank())
				{
					higherSeed = ConferenceB.get(8).getTeamNum();
					lowerSeed = ConferenceB.get(15).getTeamNum();
				}
				else
				{
					higherSeed = ConferenceB.get(15).getTeamNum(); 
					lowerSeed = ConferenceB.get(8).getTeamNum();
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != ConferenceB.get(8).getTeamNum())flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == ConferenceB.get(8).getTeamNum())flag = !flag;
				}
				//boolean flag = executeGame(false, ConferenceB.get(8).getTeamNum(),ConferenceB.get(15).getTeamNum());
				if(flag)conferenceBWinCounter[8]++;
				else conferenceBWinCounter[15]++;
			}
			if(conferenceBWinCounter[9] != 4 && conferenceBWinCounter[14] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(ConferenceB.get(9).getLeagueRank() < ConferenceB.get(14).getLeagueRank())
				{
					higherSeed = ConferenceB.get(9).getTeamNum();
					lowerSeed = ConferenceB.get(14).getTeamNum();
				}
				else
				{
					higherSeed = ConferenceB.get(14).getTeamNum(); 
					lowerSeed = ConferenceB.get(9).getTeamNum();
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != ConferenceB.get(9).getTeamNum())flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == ConferenceB.get(9).getTeamNum())flag = !flag;
				}
				//boolean flag = executeGame(false, ConferenceB.get(9).getTeamNum(),ConferenceB.get(14).getTeamNum());
				if(flag)conferenceBWinCounter[9]++;
				else conferenceBWinCounter[14]++;
			}
			if(conferenceBWinCounter[10] != 4 && conferenceBWinCounter[13] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(ConferenceB.get(10).getLeagueRank() < ConferenceB.get(13).getLeagueRank())
				{
					higherSeed = ConferenceB.get(10).getTeamNum();
					lowerSeed = ConferenceB.get(13).getTeamNum();
				}
				else
				{
					higherSeed = ConferenceB.get(13).getTeamNum(); 
					lowerSeed = ConferenceB.get(10).getTeamNum();
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != ConferenceB.get(10).getTeamNum())flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == ConferenceB.get(10).getTeamNum())flag = !flag;
				}
				//boolean flag = executeGame(false, ConferenceB.get(10).getTeamNum(),ConferenceB.get(13).getTeamNum());
				if(flag)conferenceBWinCounter[10]++;
				else conferenceBWinCounter[13]++;
			}
			if(conferenceBWinCounter[11] != 4 && conferenceBWinCounter[12] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(ConferenceB.get(11).getLeagueRank() < ConferenceB.get(12).getLeagueRank())
				{
					higherSeed = ConferenceB.get(11).getTeamNum();
					lowerSeed = ConferenceB.get(12).getTeamNum();
				}
				else
				{
					higherSeed = ConferenceB.get(12).getTeamNum(); 
					lowerSeed = ConferenceB.get(11).getTeamNum();
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != ConferenceB.get(11).getTeamNum())flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == ConferenceB.get(11).getTeamNum())flag = !flag;
				}
				//boolean flag = executeGame(false, ConferenceB.get(11).getTeamNum(),ConferenceB.get(12).getTeamNum());
				if(flag)conferenceBWinCounter[11]++;
				else conferenceBWinCounter[12]++;
			}
			writer.println();
			gamesPlayed++;
		}
		int winnerOfMatchOne = 0, loserOfMatchOne = 0;
		if(conferenceAWinCounter[0] == 4)
		{
			winnerOfMatchOne = ConferenceA.get(0).getTeamNum();
			loserOfMatchOne = ConferenceA.get(7).getTeamNum();

		}
		else
		{
			loserOfMatchOne = ConferenceA.get(0).getTeamNum();
			winnerOfMatchOne = ConferenceA.get(7).getTeamNum();
		}
		System.out.println(create.getTeam(winnerOfMatchOne) + " wins the series against" + create.getTeam(loserOfMatchOne) + " 4-" + Math.min(conferenceAWinCounter[0], conferenceAWinCounter[7]));
		int winnerOfMatchTwo = 0, loserOfMatchTwo = 0;
		if(conferenceAWinCounter[1] == 4)
		{
			winnerOfMatchTwo = ConferenceA.get(1).getTeamNum();
			loserOfMatchTwo = ConferenceA.get(6).getTeamNum();
		}
		else
		{
			loserOfMatchTwo = ConferenceA.get(1).getTeamNum();
			winnerOfMatchTwo = ConferenceA.get(6).getTeamNum();
		}
		int winnerOfMatchThree = 0, loserOfMatchThree = 0;
		if(conferenceAWinCounter[2] == 4)
		{
			winnerOfMatchThree = ConferenceA.get(2).getTeamNum();
			loserOfMatchThree = ConferenceA.get(5).getTeamNum();
		}
		else
		{
			loserOfMatchThree = ConferenceA.get(2).getTeamNum();
			winnerOfMatchThree = ConferenceA.get(5).getTeamNum();
		}
		int winnerOfMatchFour = 0, loserOfMatchFour = 0;
		if(conferenceAWinCounter[3] == 4)
		{
			winnerOfMatchFour = ConferenceA.get(3).getTeamNum();
			loserOfMatchFour = ConferenceA.get(4).getTeamNum();
		}
		else
		{
			loserOfMatchFour = ConferenceA.get(3).getTeamNum();
			winnerOfMatchFour = ConferenceA.get(4).getTeamNum();
		}
		int winnerOfMatchFive = 0, loserOfMatchFive = 0;
		if(conferenceBWinCounter[0] == 4)
		{
			winnerOfMatchFive = ConferenceB.get(0).getTeamNum();
			loserOfMatchFive = ConferenceB.get(7).getTeamNum();
		}
		else
		{
			loserOfMatchFive = ConferenceB.get(0).getTeamNum();
			winnerOfMatchFive = ConferenceB.get(7).getTeamNum();
		}
		int winnerOfMatchSix = 0, loserOfMatchSix = 0;
		if(conferenceBWinCounter[1] == 4)
		{
			winnerOfMatchSix = ConferenceB.get(1).getTeamNum();
			loserOfMatchSix = ConferenceB.get(6).getTeamNum();
		}
		else
		{
			loserOfMatchSix = ConferenceB.get(1).getTeamNum();
			winnerOfMatchSix = ConferenceB.get(6).getTeamNum();
		}
		int winnerOfMatchSeven = 0, loserOfMatchSeven = 0;
		if(conferenceBWinCounter[2] == 4)
		{
			winnerOfMatchSeven = ConferenceB.get(2).getTeamNum();
			loserOfMatchSeven = ConferenceB.get(5).getTeamNum();
		}
		else
		{
			loserOfMatchSeven = ConferenceB.get(2).getTeamNum();
			winnerOfMatchSeven = ConferenceB.get(5).getTeamNum();
		}
		int winnerOfMatchEight = 0, loserOfMatchEight = 0;
		if(conferenceBWinCounter[3] == 4)
		{
			winnerOfMatchEight = ConferenceB.get(3).getTeamNum();
			loserOfMatchEight = ConferenceB.get(4).getTeamNum();
		}
		else
		{
			loserOfMatchEight = ConferenceB.get(3).getTeamNum();
			winnerOfMatchEight = ConferenceB.get(4).getTeamNum();
		}
		int winnerOfMatchNine = 0, loserOfMatchNine = 0;
		if(conferenceAWinCounter[8] == 4)
		{
			winnerOfMatchNine = ConferenceA.get(8).getTeamNum();
			loserOfMatchNine = ConferenceA.get(15).getTeamNum();
		}
		else
		{
			loserOfMatchNine = ConferenceA.get(8).getTeamNum();
			winnerOfMatchNine = ConferenceA.get(15).getTeamNum();
		}
		int winnerOfMatchTen = 0, loserOfMatchTen = 0;
		if(conferenceAWinCounter[9] == 4)
		{
			winnerOfMatchTen = ConferenceA.get(9).getTeamNum();
			loserOfMatchTen = ConferenceA.get(14).getTeamNum();
		}
		else
		{
			loserOfMatchTen = ConferenceA.get(9).getTeamNum();
			winnerOfMatchTen = ConferenceA.get(14).getTeamNum();
		}
		int winnerOfMatchEleven = 0, loserOfMatchEleven = 0;
		if(conferenceAWinCounter[10] == 4)
		{
			winnerOfMatchEleven = ConferenceA.get(10).getTeamNum();
			loserOfMatchEleven = ConferenceA.get(13).getTeamNum();
		}
		else
		{
			loserOfMatchEleven = ConferenceA.get(10).getTeamNum();
			winnerOfMatchEleven = ConferenceA.get(13).getTeamNum();
		}
		int winnerOfMatchTwelve = 0, loserOfMatchTwelve = 0;
		if(conferenceAWinCounter[11] == 4)
		{
			winnerOfMatchTwelve = ConferenceA.get(11).getTeamNum();
			loserOfMatchTwelve = ConferenceA.get(12).getTeamNum();
		}
		else
		{
			loserOfMatchTwelve = ConferenceA.get(11).getTeamNum();
			winnerOfMatchTwelve = ConferenceA.get(12).getTeamNum();
		}
		int winnerOfMatchThirteen = 0, loserOfMatchThirteen = 0;
		if(conferenceBWinCounter[8] == 4)
		{
			winnerOfMatchThirteen = ConferenceB.get(8).getTeamNum();
			loserOfMatchThirteen = ConferenceB.get(15).getTeamNum();
		}
		else
		{
			loserOfMatchThirteen = ConferenceB.get(8).getTeamNum();
			winnerOfMatchThirteen = ConferenceB.get(15).getTeamNum();
		}
		int winnerOfMatchForteen = 0, loserOfMatchForteen = 0;
		if(conferenceBWinCounter[9] == 4)
		{
			winnerOfMatchForteen = ConferenceB.get(9).getTeamNum();
			loserOfMatchForteen = ConferenceB.get(14).getTeamNum();
		}
		else
		{
			loserOfMatchForteen = ConferenceB.get(9).getTeamNum();
			winnerOfMatchForteen = ConferenceB.get(14).getTeamNum();
		}
		int winnerOfMatchFifteen = 0, loserOfMatchFifteen = 0;
		if(conferenceBWinCounter[10] == 4)
		{
			winnerOfMatchFifteen = ConferenceB.get(10).getTeamNum();
			loserOfMatchFifteen = ConferenceB.get(13).getTeamNum();
		}
		else
		{
			loserOfMatchFifteen = ConferenceB.get(10).getTeamNum();
			winnerOfMatchFifteen = ConferenceB.get(13).getTeamNum();
		}
		int winnerOfMatchSixteen = 0, loserOfMatchSixteen = 0;
		if(conferenceBWinCounter[11] == 4)
		{
			winnerOfMatchSixteen = ConferenceB.get(11).getTeamNum();
			loserOfMatchSixteen = ConferenceB.get(12).getTeamNum();
		}
		else
		{
			loserOfMatchSixteen = ConferenceB.get(11).getTeamNum();
			winnerOfMatchSixteen = ConferenceB.get(12).getTeamNum();
		}
		gamesPlayed = 0;
		conferenceAWinCounter = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0};
		conferenceBWinCounter = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0};
		while(gamesPlayed < 7)
		{

			startingGame = gamesPlayed + 2;
			gameResults.println("Game " +  (startingGame-1) + ",Home,Score,Away,Score");
			if(conferenceAWinCounter[0] != 4 && conferenceAWinCounter[7] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(winnerOfMatchOne).getLeagueRank() < create.getTeam(winnerOfMatchFour).getLeagueRank())
				{
					higherSeed = winnerOfMatchOne;
					lowerSeed = winnerOfMatchFour;
				}
				else
				{
					higherSeed = winnerOfMatchFour; 
					lowerSeed = winnerOfMatchOne;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != winnerOfMatchOne)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == winnerOfMatchOne)flag = !flag;
				}
				//boolean flag = executeGame(false, winnerOfMatchOne,winnerOfMatchFour);
				if(flag)conferenceAWinCounter[0]++;
				else conferenceAWinCounter[7]++;
			}
			if(conferenceAWinCounter[1] != 4 && conferenceAWinCounter[6] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(winnerOfMatchTwo).getLeagueRank() < create.getTeam(winnerOfMatchThree).getLeagueRank())
				{
					higherSeed = winnerOfMatchTwo;
					lowerSeed = winnerOfMatchThree;
				}
				else
				{
					higherSeed = winnerOfMatchThree; 
					lowerSeed = winnerOfMatchTwo;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != winnerOfMatchTwo)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == winnerOfMatchTwo)flag = !flag;
				}
				//boolean flag = executeGame(false, winnerOfMatchTwo,winnerOfMatchThree);
				if(flag)conferenceAWinCounter[1]++;
				else conferenceAWinCounter[6]++;
			}
			if(conferenceAWinCounter[2] != 4 && conferenceAWinCounter[5] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(loserOfMatchOne).getLeagueRank() < create.getTeam(loserOfMatchFour).getLeagueRank())
				{
					higherSeed = loserOfMatchOne;
					lowerSeed = loserOfMatchFour;
				}
				else
				{
					higherSeed = loserOfMatchFour; 
					lowerSeed = loserOfMatchOne;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != loserOfMatchOne)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == loserOfMatchOne)flag = !flag;
				}
				//boolean flag = executeGame(false, loserOfMatchOne,loserOfMatchFour);
				if(flag)conferenceAWinCounter[2]++;
				else conferenceAWinCounter[5]++;
			}
			if(conferenceAWinCounter[3] != 4 && conferenceAWinCounter[4] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(loserOfMatchTwo).getLeagueRank() < create.getTeam(loserOfMatchThree).getLeagueRank())
				{
					higherSeed = loserOfMatchTwo;
					lowerSeed = loserOfMatchThree;
				}
				else
				{
					higherSeed = loserOfMatchThree; 
					lowerSeed = loserOfMatchTwo;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != loserOfMatchTwo)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == loserOfMatchTwo)flag = !flag;
				}
				//boolean flag = executeGame(false, loserOfMatchTwo,loserOfMatchThree);
				if(flag)conferenceAWinCounter[3]++;
				else conferenceAWinCounter[4]++;
			}
			if(conferenceBWinCounter[0] != 4 && conferenceBWinCounter[7] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(winnerOfMatchFive).getLeagueRank() < create.getTeam(winnerOfMatchEight).getLeagueRank())
				{
					higherSeed = winnerOfMatchFive;
					lowerSeed = winnerOfMatchEight;
				}
				else
				{
					higherSeed = winnerOfMatchEight; 
					lowerSeed = winnerOfMatchFive;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != winnerOfMatchFive)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == winnerOfMatchFive)flag = !flag;
				}
				//boolean flag = executeGame(false, winnerOfMatchFive,winnerOfMatchEight);
				if(flag)conferenceBWinCounter[0]++;
				else conferenceBWinCounter[7]++;
			}
			if(conferenceBWinCounter[1] != 4 && conferenceBWinCounter[6] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(winnerOfMatchSix).getLeagueRank() < create.getTeam(winnerOfMatchSeven).getLeagueRank())
				{
					higherSeed = winnerOfMatchSix;
					lowerSeed = winnerOfMatchSeven;
				}
				else
				{
					higherSeed = winnerOfMatchSeven; 
					lowerSeed = winnerOfMatchSix;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != winnerOfMatchSix)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == winnerOfMatchSix)flag = !flag;
				}
				//boolean flag = executeGame(false, winnerOfMatchSix,winnerOfMatchSeven);
				if(flag)conferenceBWinCounter[1]++;
				else conferenceBWinCounter[6]++;
			}
			if(conferenceBWinCounter[2] != 4 && conferenceBWinCounter[5] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(loserOfMatchFive).getLeagueRank() < create.getTeam(loserOfMatchEight).getLeagueRank())
				{
					higherSeed = loserOfMatchFive;
					lowerSeed = loserOfMatchEight;
				}
				else
				{
					higherSeed = loserOfMatchEight; 
					lowerSeed = loserOfMatchFive;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != loserOfMatchFive)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == loserOfMatchFive)flag = !flag;
				}
				//boolean flag = executeGame(false, loserOfMatchFive,loserOfMatchEight);
				if(flag)conferenceBWinCounter[2]++;
				else conferenceBWinCounter[5]++;
			}
			if(conferenceBWinCounter[3] != 4 && conferenceBWinCounter[4] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(loserOfMatchSix).getLeagueRank() < create.getTeam(loserOfMatchSeven).getLeagueRank())
				{
					higherSeed = loserOfMatchSix;
					lowerSeed = loserOfMatchSeven;
				}
				else
				{
					higherSeed = loserOfMatchSeven; 
					lowerSeed = loserOfMatchSix;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != loserOfMatchSix)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == loserOfMatchSix)flag = !flag;
				}
				//boolean flag = executeGame(false, loserOfMatchSix,loserOfMatchSeven);
				if(flag)conferenceBWinCounter[3]++;
				else conferenceBWinCounter[4]++;
			}
			if(conferenceAWinCounter[8] != 4 && conferenceAWinCounter[15] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(winnerOfMatchNine).getLeagueRank() < create.getTeam(winnerOfMatchTwelve).getLeagueRank())
				{
					higherSeed = winnerOfMatchNine;
					lowerSeed = winnerOfMatchTwelve;
				}
				else
				{
					higherSeed = winnerOfMatchTwelve; 
					lowerSeed = winnerOfMatchNine;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != winnerOfMatchNine)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == winnerOfMatchNine)flag = !flag;
				}
				//boolean flag = executeGame(false, winnerOfMatchNine,winnerOfMatchTwelve);
				if(flag)conferenceAWinCounter[8]++;
				else conferenceAWinCounter[15]++;
			}
			if(conferenceAWinCounter[9] != 4 && conferenceAWinCounter[14] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(winnerOfMatchTen).getLeagueRank() < create.getTeam(winnerOfMatchEleven).getLeagueRank())
				{
					higherSeed = winnerOfMatchTen;
					lowerSeed = winnerOfMatchEleven;
				}
				else
				{
					higherSeed = winnerOfMatchEleven; 
					lowerSeed = winnerOfMatchTen;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != winnerOfMatchTen)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == winnerOfMatchTen)flag = !flag;
				}
				//boolean flag = executeGame(false, winnerOfMatchTen,winnerOfMatchEleven);
				if(flag)conferenceAWinCounter[9]++;
				else conferenceAWinCounter[14]++;
			}
			if(conferenceAWinCounter[10] != 4 && conferenceAWinCounter[13] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(loserOfMatchNine).getLeagueRank() < create.getTeam(loserOfMatchTwelve).getLeagueRank())
				{
					higherSeed = loserOfMatchNine;
					lowerSeed = loserOfMatchTwelve;
				}
				else
				{
					higherSeed = loserOfMatchTwelve; 
					lowerSeed = loserOfMatchNine;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != loserOfMatchNine)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == loserOfMatchNine)flag = !flag;
				}
				//boolean flag = executeGame(false, loserOfMatchNine,loserOfMatchTwelve);
				if(flag)conferenceAWinCounter[10]++;
				else conferenceAWinCounter[13]++;
			}
			if(conferenceAWinCounter[11] != 4 && conferenceAWinCounter[12] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(loserOfMatchTen).getLeagueRank() < create.getTeam(loserOfMatchEleven).getLeagueRank())
				{
					higherSeed = loserOfMatchTen;
					lowerSeed = loserOfMatchEleven;
				}
				else
				{
					higherSeed = loserOfMatchEleven; 
					lowerSeed = loserOfMatchTen;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != loserOfMatchTen)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == loserOfMatchTen)flag = !flag;
				}
				//boolean flag = executeGame(false, loserOfMatchTen,loserOfMatchEleven);
				if(flag)conferenceAWinCounter[11]++;
				else conferenceAWinCounter[12]++;
			}
			if(conferenceBWinCounter[8] != 4 && conferenceBWinCounter[15] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(winnerOfMatchThirteen).getLeagueRank() < create.getTeam(winnerOfMatchSixteen).getLeagueRank())
				{
					higherSeed = winnerOfMatchThirteen;
					lowerSeed = winnerOfMatchSixteen;
				}
				else
				{
					higherSeed = winnerOfMatchSixteen; 
					lowerSeed = winnerOfMatchThirteen;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != winnerOfMatchThirteen)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == winnerOfMatchThirteen)flag = !flag;
				}
				//boolean flag = executeGame(false, winnerOfMatchThirteen,winnerOfMatchSixteen);
				if(flag)conferenceBWinCounter[8]++;
				else conferenceBWinCounter[15]++;
			}
			if(conferenceBWinCounter[9] != 4 && conferenceBWinCounter[14] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(winnerOfMatchForteen).getLeagueRank() < create.getTeam(winnerOfMatchFifteen).getLeagueRank())
				{
					higherSeed = winnerOfMatchForteen;
					lowerSeed = winnerOfMatchFifteen;
				}
				else
				{
					higherSeed = winnerOfMatchFifteen; 
					lowerSeed = winnerOfMatchForteen;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != winnerOfMatchForteen)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == winnerOfMatchForteen)flag = !flag;
				}
				//boolean flag = executeGame(false, winnerOfMatchForteen,winnerOfMatchFifteen);
				if(flag)conferenceBWinCounter[9]++;
				else conferenceBWinCounter[14]++;
			}
			if(conferenceBWinCounter[10] != 4 && conferenceBWinCounter[13] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(loserOfMatchThirteen).getLeagueRank() < create.getTeam(loserOfMatchSixteen).getLeagueRank())
				{
					higherSeed = loserOfMatchThirteen;
					lowerSeed = loserOfMatchSixteen;
				}
				else
				{
					higherSeed = loserOfMatchSixteen; 
					lowerSeed = loserOfMatchThirteen;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != loserOfMatchThirteen)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == loserOfMatchThirteen)flag = !flag;
				}
				//boolean flag = executeGame(false, loserOfMatchThirteen,loserOfMatchSixteen);
				if(flag)conferenceBWinCounter[10]++;
				else conferenceBWinCounter[13]++;
			}
			if(conferenceBWinCounter[11] != 4 && conferenceBWinCounter[12] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(loserOfMatchForteen).getLeagueRank() < create.getTeam(loserOfMatchFifteen).getLeagueRank())
				{
					higherSeed = loserOfMatchForteen;
					lowerSeed = loserOfMatchFifteen;
				}
				else
				{
					higherSeed = loserOfMatchFifteen; 
					lowerSeed = loserOfMatchForteen;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != loserOfMatchForteen)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == loserOfMatchForteen)flag = !flag;
				}
				//boolean flag = executeGame(false, loserOfMatchForteen,loserOfMatchFifteen);
				if(flag)conferenceBWinCounter[11]++;
				else conferenceBWinCounter[12]++;
			}
			writer.println();
			gamesPlayed++;


		}
		int winnerOfThirdRoundMatchOne = 0, loserOfThirdRoundMatchOne = 0;
		if(conferenceAWinCounter[0] == 4)
		{
			winnerOfThirdRoundMatchOne = winnerOfMatchOne;
			loserOfThirdRoundMatchOne = winnerOfMatchFour;
			if(conferenceAWinCounter[7] < 2)retVal = false;
		}
		else
		{
			loserOfThirdRoundMatchOne = winnerOfMatchOne;
			winnerOfThirdRoundMatchOne = winnerOfMatchFour;
			if(conferenceAWinCounter[0]  < 2)retVal = false;
		}

		int winnerOfThirdRoundMatchTwo;
		int loserOfThirdRoundMatchTwo;
		if(conferenceAWinCounter[1] == 4)
		{
			winnerOfThirdRoundMatchTwo = winnerOfMatchTwo;
			loserOfThirdRoundMatchTwo = winnerOfMatchThree;
		}
		else
		{
			loserOfThirdRoundMatchTwo = winnerOfMatchTwo;
			winnerOfThirdRoundMatchTwo = winnerOfMatchThree;
		}
		int winnerOfThirdRoundMatchThree;
		int loserOfThirdRoundMatchThree;
		if(conferenceAWinCounter[2] == 4)
		{
			winnerOfThirdRoundMatchThree = loserOfMatchOne;
			loserOfThirdRoundMatchThree = loserOfMatchFour;
		}
		else
		{
			loserOfThirdRoundMatchThree = loserOfMatchOne;
			winnerOfThirdRoundMatchThree = loserOfMatchFour;
		}
		int winnerOfThirdRoundMatchFour;
		int loserOfThirdRoundMatchFour;
		if(conferenceAWinCounter[3] == 4)
		{
			winnerOfThirdRoundMatchFour = loserOfMatchTwo;
			loserOfThirdRoundMatchFour = loserOfMatchThree;
		}
		else
		{
			loserOfThirdRoundMatchFour = loserOfMatchTwo;
			winnerOfThirdRoundMatchFour = loserOfMatchThree;
		}
		int winnerOfThirdRoundMatchFive;
		int loserOfThirdRoundMatchFive;
		if(conferenceBWinCounter[0] == 4)
		{
			winnerOfThirdRoundMatchFive = winnerOfMatchFive;
			loserOfThirdRoundMatchFive = winnerOfMatchEight;
			if(conferenceBWinCounter[7]  < 2)retVal = false;
		}
		else
		{
			loserOfThirdRoundMatchFive = winnerOfMatchFive;
			winnerOfThirdRoundMatchFive = winnerOfMatchEight;
			if(conferenceBWinCounter[0] < 2)retVal = false;
		}
		int winnerOfThirdRoundMatchSix;
		int loserOfThirdRoundMatchSix;
		if(conferenceBWinCounter[1] == 4)
		{
			winnerOfThirdRoundMatchSix = winnerOfMatchSix;
			loserOfThirdRoundMatchSix = winnerOfMatchSeven;
		}
		else
		{
			loserOfThirdRoundMatchSix = winnerOfMatchSix;
			winnerOfThirdRoundMatchSix = winnerOfMatchSeven;
		}
		int winnerOfThirdRoundMatchSeven;
		int loserOfThirdRoundMatchSeven;
		if(conferenceBWinCounter[2] == 4)
		{
			winnerOfThirdRoundMatchSeven = loserOfMatchFive;
			loserOfThirdRoundMatchSeven = loserOfMatchEight;
		}
		else
		{
			loserOfThirdRoundMatchSeven = loserOfMatchFive;
			winnerOfThirdRoundMatchSeven = loserOfMatchEight;
		}
		int winnerOfThirdRoundMatchEight;
		int loserOfThirdRoundMatchEight;
		if(conferenceBWinCounter[3] == 4)
		{
			winnerOfThirdRoundMatchEight = loserOfMatchSix;
			loserOfThirdRoundMatchEight = loserOfMatchSeven;
		}
		else
		{
			loserOfThirdRoundMatchEight = loserOfMatchSix;
			winnerOfThirdRoundMatchEight = loserOfMatchSeven;
		}
		int winnerOfThirdRoundMatchNine;
		int loserOfThirdRoundMatchNine;
		if(conferenceAWinCounter[8] == 4)
		{
			winnerOfThirdRoundMatchNine = winnerOfMatchNine;
			loserOfThirdRoundMatchNine = winnerOfMatchTwelve;
		}
		else
		{
			loserOfThirdRoundMatchNine = winnerOfMatchNine;
			winnerOfThirdRoundMatchNine = winnerOfMatchTwelve;
		}
		int winnerOfThirdRoundMatchTen;
		int loserOfThirdRoundMatchTen;
		if(conferenceAWinCounter[9] == 4)
		{
			winnerOfThirdRoundMatchTen = winnerOfMatchTen;
			loserOfThirdRoundMatchTen = winnerOfMatchEleven;
		}
		else
		{
			loserOfThirdRoundMatchTen = winnerOfMatchTen;
			winnerOfThirdRoundMatchTen = winnerOfMatchEleven;
		}
		int winnerOfThirdRoundMatchEleven;
		int loserOfThirdRoundMatchEleven;
		if(conferenceAWinCounter[10] == 4)
		{
			winnerOfThirdRoundMatchEleven = loserOfMatchNine;
			loserOfThirdRoundMatchEleven = loserOfMatchTwelve;
		}
		else
		{
			loserOfThirdRoundMatchEleven = loserOfMatchNine;
			winnerOfThirdRoundMatchEleven = loserOfMatchTwelve;
		}
		int winnerOfThirdRoundMatchTwelve;
		int loserOfThirdRoundMatchTwelve;
		if(conferenceAWinCounter[11] == 4)
		{
			winnerOfThirdRoundMatchTwelve = loserOfMatchTen;
			loserOfThirdRoundMatchTwelve = loserOfMatchEleven;
		}
		else
		{
			loserOfThirdRoundMatchTwelve = loserOfMatchTen;
			winnerOfThirdRoundMatchTwelve = loserOfMatchEleven;
		}
		int winnerOfThirdRoundMatchThirteen;
		int loserOfThirdRoundMatchThirteen;
		if(conferenceBWinCounter[8] == 4)
		{
			winnerOfThirdRoundMatchThirteen = winnerOfMatchThirteen;
			loserOfThirdRoundMatchThirteen = winnerOfMatchSixteen;
		}
		else
		{
			loserOfThirdRoundMatchThirteen = winnerOfMatchThirteen;
			winnerOfThirdRoundMatchThirteen = winnerOfMatchSixteen;
		}
		int winnerOfThirdRoundMatchForteen;
		int loserOfThirdRoundMatchForteen;
		if(conferenceBWinCounter[9] == 4)
		{
			winnerOfThirdRoundMatchForteen = winnerOfMatchForteen;
			loserOfThirdRoundMatchForteen = winnerOfMatchFifteen;
		}
		else
		{
			loserOfThirdRoundMatchForteen = winnerOfMatchForteen;
			winnerOfThirdRoundMatchForteen = winnerOfMatchFifteen;
		}
		int winnerOfThirdRoundMatchFifteen;
		int loserOfThirdRoundMatchFifteen;
		if(conferenceBWinCounter[10] == 4)
		{
			winnerOfThirdRoundMatchFifteen = loserOfMatchThirteen;
			loserOfThirdRoundMatchFifteen = loserOfMatchSixteen;
		}
		else
		{
			loserOfThirdRoundMatchFifteen = loserOfMatchThirteen;
			winnerOfThirdRoundMatchFifteen = loserOfMatchSixteen;
		}
		int winnerOfThirdRoundMatchSixteen;
		int loserOfThirdRoundMatchSixteen;
		if(conferenceBWinCounter[11] == 4)
		{
			winnerOfThirdRoundMatchSixteen = loserOfMatchForteen;
			loserOfThirdRoundMatchSixteen = loserOfMatchFifteen;
		}
		else
		{
			loserOfThirdRoundMatchSixteen = loserOfMatchForteen;
			winnerOfThirdRoundMatchSixteen = loserOfMatchFifteen;
		}
		gamesPlayed = 0;
		conferenceAWinCounter = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0};
		conferenceBWinCounter = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0};
		while(gamesPlayed < 7)
		{
			startingGame = gamesPlayed + 2;
			gameResults.println("Game " +  (startingGame-1) + ",Home,Score,Away,Score");
			if(conferenceAWinCounter[0] != 4 && conferenceAWinCounter[7] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(winnerOfThirdRoundMatchOne).getLeagueRank() < create.getTeam(winnerOfThirdRoundMatchTwo).getLeagueRank())
				{
					higherSeed = winnerOfThirdRoundMatchOne;
					lowerSeed = winnerOfThirdRoundMatchTwo;
				}
				else
				{
					higherSeed = winnerOfThirdRoundMatchTwo; 
					lowerSeed = winnerOfThirdRoundMatchOne;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != winnerOfThirdRoundMatchOne)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == winnerOfThirdRoundMatchOne)flag = !flag;
				}
				//boolean flag = executeGame(false, winnerOfThirdRoundMatchOne,winnerOfThirdRoundMatchTwo);
				if(flag)conferenceAWinCounter[0]++;
				else conferenceAWinCounter[7]++;
			}
			if(conferenceAWinCounter[1] != 4 && conferenceAWinCounter[6] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(winnerOfThirdRoundMatchFour).getLeagueRank() < create.getTeam(winnerOfThirdRoundMatchThree).getLeagueRank())
				{
					higherSeed = winnerOfThirdRoundMatchFour;
					lowerSeed = winnerOfThirdRoundMatchThree;
				}
				else
				{
					higherSeed = winnerOfThirdRoundMatchThree; 
					lowerSeed = winnerOfThirdRoundMatchFour;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != winnerOfThirdRoundMatchFour)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == winnerOfThirdRoundMatchFour)flag = !flag;
				}
				//boolean flag = executeGame(false, winnerOfThirdRoundMatchFour,winnerOfThirdRoundMatchThree);
				if(flag)conferenceAWinCounter[1]++;
				else conferenceAWinCounter[6]++;
			}
			if(conferenceAWinCounter[2] != 4 && conferenceAWinCounter[5] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(loserOfThirdRoundMatchOne).getLeagueRank() < create.getTeam(loserOfThirdRoundMatchTwo).getLeagueRank())
				{
					higherSeed = loserOfThirdRoundMatchOne;
					lowerSeed = loserOfThirdRoundMatchTwo;
				}
				else
				{
					higherSeed = loserOfThirdRoundMatchTwo; 
					lowerSeed = loserOfThirdRoundMatchOne;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != loserOfThirdRoundMatchOne)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == loserOfThirdRoundMatchOne)flag = !flag;
				}
				//boolean flag = executeGame(false, loserOfThirdRoundMatchOne,loserOfThirdRoundMatchTwo);
				if(flag)conferenceAWinCounter[2]++;
				else conferenceAWinCounter[5]++;
			}
			if(conferenceAWinCounter[3] != 4 && conferenceAWinCounter[4] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(loserOfThirdRoundMatchFour).getLeagueRank() < create.getTeam(loserOfThirdRoundMatchThree).getLeagueRank())
				{
					higherSeed = loserOfThirdRoundMatchFour;
					lowerSeed = loserOfThirdRoundMatchThree;
				}
				else
				{
					higherSeed = loserOfThirdRoundMatchThree; 
					lowerSeed = loserOfThirdRoundMatchFour;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != loserOfThirdRoundMatchFour)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == loserOfThirdRoundMatchFour)flag = !flag;
				}
				//boolean flag = executeGame(false, loserOfThirdRoundMatchFour,loserOfThirdRoundMatchThree);
				if(flag)conferenceAWinCounter[3]++;
				else conferenceAWinCounter[4]++;
			}
			if(conferenceBWinCounter[0] != 4 && conferenceBWinCounter[7] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(winnerOfThirdRoundMatchFive).getLeagueRank() < create.getTeam(winnerOfThirdRoundMatchSix).getLeagueRank())
				{
					higherSeed = winnerOfThirdRoundMatchFive;
					lowerSeed = winnerOfThirdRoundMatchSix;
				}
				else
				{
					higherSeed = winnerOfThirdRoundMatchSix; 
					lowerSeed = winnerOfThirdRoundMatchFive;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != winnerOfThirdRoundMatchFive)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == winnerOfThirdRoundMatchFive)flag = !flag;
				}
				//boolean flag = executeGame(false, winnerOfThirdRoundMatchFive,winnerOfThirdRoundMatchSix);
				if(flag)conferenceBWinCounter[0]++;
				else conferenceBWinCounter[7]++;
			}
			if(conferenceBWinCounter[1] != 4 && conferenceBWinCounter[6] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(winnerOfThirdRoundMatchEight).getLeagueRank() < create.getTeam(winnerOfThirdRoundMatchSeven).getLeagueRank())
				{
					higherSeed = winnerOfThirdRoundMatchEight;
					lowerSeed = winnerOfThirdRoundMatchSeven;
				}
				else
				{
					higherSeed = winnerOfThirdRoundMatchSeven; 
					lowerSeed = winnerOfThirdRoundMatchEight;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != winnerOfThirdRoundMatchEight)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == winnerOfThirdRoundMatchEight)flag = !flag;
				}
				//boolean flag = executeGame(false, winnerOfThirdRoundMatchEight,winnerOfThirdRoundMatchSeven);
				if(flag)conferenceBWinCounter[1]++;
				else conferenceBWinCounter[6]++;
			}
			if(conferenceBWinCounter[2] != 4 && conferenceBWinCounter[5] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(loserOfThirdRoundMatchFive).getLeagueRank() < create.getTeam(loserOfThirdRoundMatchSix).getLeagueRank())
				{
					higherSeed = loserOfThirdRoundMatchFive;
					lowerSeed = loserOfThirdRoundMatchSix;
				}
				else
				{
					higherSeed = loserOfThirdRoundMatchSix; 
					lowerSeed = loserOfThirdRoundMatchFive;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != loserOfThirdRoundMatchFive)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == loserOfThirdRoundMatchFive)flag = !flag;
				}
				//boolean flag = executeGame(false, loserOfThirdRoundMatchFive,loserOfThirdRoundMatchSix);
				if(flag)conferenceBWinCounter[2]++;
				else conferenceBWinCounter[5]++;
			}
			if(conferenceBWinCounter[3] != 4 && conferenceBWinCounter[4] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(loserOfThirdRoundMatchEight).getLeagueRank() < create.getTeam(loserOfThirdRoundMatchSeven).getLeagueRank())
				{
					higherSeed = loserOfThirdRoundMatchEight;
					lowerSeed = loserOfThirdRoundMatchSeven;
				}
				else
				{
					higherSeed = loserOfThirdRoundMatchSeven; 
					lowerSeed = loserOfThirdRoundMatchEight;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != loserOfThirdRoundMatchEight)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == loserOfThirdRoundMatchEight)flag = !flag;
				}
				//boolean flag = executeGame(false, loserOfThirdRoundMatchEight,loserOfThirdRoundMatchSeven);
				if(flag)conferenceBWinCounter[3]++;
				else conferenceBWinCounter[4]++;
			}
			if(conferenceAWinCounter[8] != 4 && conferenceAWinCounter[15] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(winnerOfThirdRoundMatchNine).getLeagueRank() < create.getTeam(winnerOfThirdRoundMatchTen).getLeagueRank())
				{
					higherSeed = winnerOfThirdRoundMatchNine;
					lowerSeed = winnerOfThirdRoundMatchTen;
				}
				else
				{
					higherSeed = winnerOfThirdRoundMatchTen; 
					lowerSeed = winnerOfThirdRoundMatchNine;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != winnerOfThirdRoundMatchNine)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == winnerOfThirdRoundMatchNine)flag = !flag;
				}
				//boolean flag = executeGame(false, winnerOfThirdRoundMatchNine,winnerOfThirdRoundMatchTen);
				if(flag)conferenceAWinCounter[8]++;
				else conferenceAWinCounter[15]++;
			}
			if(conferenceAWinCounter[9] != 4 && conferenceAWinCounter[14] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(winnerOfThirdRoundMatchTwelve).getLeagueRank() < create.getTeam(winnerOfThirdRoundMatchEleven).getLeagueRank())
				{
					higherSeed = winnerOfThirdRoundMatchTwelve;
					lowerSeed = winnerOfThirdRoundMatchEleven;
				}
				else
				{
					higherSeed = winnerOfThirdRoundMatchEleven; 
					lowerSeed = winnerOfThirdRoundMatchTwelve;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != winnerOfThirdRoundMatchTwelve)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == winnerOfThirdRoundMatchTwelve)flag = !flag;
				}
				//boolean flag = executeGame(false, winnerOfThirdRoundMatchTwelve,winnerOfThirdRoundMatchEleven);
				if(flag)conferenceAWinCounter[9]++;
				else conferenceAWinCounter[14]++;
			}
			if(conferenceAWinCounter[10] != 4 && conferenceAWinCounter[13] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(loserOfThirdRoundMatchNine).getLeagueRank() < create.getTeam(loserOfThirdRoundMatchTen).getLeagueRank())
				{
					higherSeed = loserOfThirdRoundMatchNine;
					lowerSeed = loserOfThirdRoundMatchTen;
				}
				else
				{
					higherSeed = loserOfThirdRoundMatchTen; 
					lowerSeed = loserOfThirdRoundMatchNine;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != loserOfThirdRoundMatchNine)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == loserOfThirdRoundMatchNine)flag = !flag;
				}
				//boolean flag = executeGame(false, loserOfThirdRoundMatchNine,loserOfThirdRoundMatchTen);
				if(flag)conferenceAWinCounter[10]++;
				else conferenceAWinCounter[13]++;
			}
			if(conferenceAWinCounter[11] != 4 && conferenceAWinCounter[12] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(loserOfThirdRoundMatchTwelve).getLeagueRank() < create.getTeam(loserOfThirdRoundMatchEleven).getLeagueRank())
				{
					higherSeed = loserOfThirdRoundMatchTwelve;
					lowerSeed = loserOfThirdRoundMatchEleven;
				}
				else
				{
					higherSeed = loserOfThirdRoundMatchEleven; 
					lowerSeed = loserOfThirdRoundMatchTwelve;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != loserOfThirdRoundMatchTwelve)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == loserOfThirdRoundMatchTwelve)flag = !flag;
				}
				//boolean flag = executeGame(false, loserOfThirdRoundMatchTwelve,loserOfThirdRoundMatchEleven);
				if(flag)conferenceAWinCounter[11]++;
				else conferenceAWinCounter[12]++;
			}
			if(conferenceBWinCounter[8] != 4 && conferenceBWinCounter[15] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(winnerOfThirdRoundMatchThirteen).getLeagueRank() < create.getTeam(winnerOfThirdRoundMatchForteen).getLeagueRank())
				{
					higherSeed = winnerOfThirdRoundMatchThirteen;
					lowerSeed = winnerOfThirdRoundMatchForteen;
				}
				else
				{
					higherSeed = winnerOfThirdRoundMatchForteen; 
					lowerSeed = winnerOfThirdRoundMatchThirteen;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != winnerOfThirdRoundMatchThirteen)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == winnerOfThirdRoundMatchThirteen)flag = !flag;
				}
				//boolean flag = executeGame(false, winnerOfThirdRoundMatchThirteen,winnerOfThirdRoundMatchForteen);
				if(flag)conferenceBWinCounter[8]++;
				else conferenceBWinCounter[15]++;
			}
			if(conferenceBWinCounter[9] != 4 && conferenceBWinCounter[14] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(winnerOfThirdRoundMatchSixteen).getLeagueRank() < create.getTeam(winnerOfThirdRoundMatchFifteen).getLeagueRank())
				{
					higherSeed = winnerOfThirdRoundMatchSixteen;
					lowerSeed = winnerOfThirdRoundMatchFifteen;
				}
				else
				{
					higherSeed = winnerOfThirdRoundMatchFifteen; 
					lowerSeed = winnerOfThirdRoundMatchSixteen;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != winnerOfThirdRoundMatchSixteen)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == winnerOfThirdRoundMatchSixteen)flag = !flag;
				}
				//boolean flag = executeGame(false, winnerOfThirdRoundMatchSixteen,winnerOfThirdRoundMatchFifteen);
				if(flag)conferenceBWinCounter[9]++;
				else conferenceBWinCounter[14]++;
			}
			if(conferenceBWinCounter[10] != 4 && conferenceBWinCounter[13] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(loserOfThirdRoundMatchThirteen).getLeagueRank() < create.getTeam(loserOfThirdRoundMatchForteen).getLeagueRank())
				{
					higherSeed = loserOfThirdRoundMatchThirteen;
					lowerSeed = loserOfThirdRoundMatchForteen;
				}
				else
				{
					higherSeed = loserOfThirdRoundMatchForteen; 
					lowerSeed = loserOfThirdRoundMatchThirteen;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != loserOfThirdRoundMatchThirteen)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == loserOfThirdRoundMatchThirteen)flag = !flag;
				}
				//boolean flag = executeGame(false, loserOfThirdRoundMatchThirteen,loserOfThirdRoundMatchForteen);
				if(flag)conferenceBWinCounter[10]++;
				else conferenceBWinCounter[13]++;
			}
			if(conferenceBWinCounter[11] != 4 && conferenceBWinCounter[12] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(loserOfThirdRoundMatchSixteen).getLeagueRank() < create.getTeam(loserOfThirdRoundMatchFifteen).getLeagueRank())
				{
					higherSeed = loserOfThirdRoundMatchSixteen;
					lowerSeed = loserOfThirdRoundMatchFifteen;
				}
				else
				{
					higherSeed = loserOfThirdRoundMatchFifteen; 
					lowerSeed = loserOfThirdRoundMatchSixteen;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != loserOfThirdRoundMatchSixteen)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == loserOfThirdRoundMatchSixteen)flag = !flag;
				}
				//boolean flag = executeGame(false, loserOfThirdRoundMatchSixteen,loserOfThirdRoundMatchFifteen);
				if(flag)conferenceBWinCounter[11]++;
				else conferenceBWinCounter[12]++;
			}
			writer.println();
			gamesPlayed++;


		}

		int topSeedConferenceA = 0, secondSeedConferenceA = 0;
		if(conferenceAWinCounter[0] == 4)
		{
			topSeedConferenceA = winnerOfThirdRoundMatchOne;
			secondSeedConferenceA = winnerOfThirdRoundMatchTwo;
		}
		else
		{
			secondSeedConferenceA = winnerOfThirdRoundMatchOne;
			topSeedConferenceA = winnerOfThirdRoundMatchTwo;
		}

		int thirdSeedConferenceA;
		int fourthSeedConferenceA;
		if(conferenceAWinCounter[1] == 4)
		{
			thirdSeedConferenceA = winnerOfThirdRoundMatchFour;
			fourthSeedConferenceA = winnerOfThirdRoundMatchThree;
		}
		else
		{
			fourthSeedConferenceA = winnerOfThirdRoundMatchFour;
			thirdSeedConferenceA = winnerOfThirdRoundMatchThree;
		}
		int fifthSeedConferenceA;
		int sixthSeedConferenceA;
		if(conferenceAWinCounter[2] == 4)
		{
			fifthSeedConferenceA = loserOfThirdRoundMatchOne;
			sixthSeedConferenceA = loserOfThirdRoundMatchTwo;
		}
		else
		{
			sixthSeedConferenceA = loserOfThirdRoundMatchOne;
			fifthSeedConferenceA = loserOfThirdRoundMatchTwo;
		}
		int seventhSeedConferenceA;
		int eighthSeedConferenceA;
		if(conferenceAWinCounter[3] == 4)
		{
			seventhSeedConferenceA = loserOfThirdRoundMatchFour;
			eighthSeedConferenceA = loserOfThirdRoundMatchThree;
		}
		else
		{
			eighthSeedConferenceA = loserOfThirdRoundMatchFour;
			seventhSeedConferenceA = loserOfThirdRoundMatchThree;
		}
		int topSeedConferenceB;
		int secondSeedConferenceB;
		if(conferenceBWinCounter[0] == 4)
		{
			topSeedConferenceB = winnerOfThirdRoundMatchFive;
			secondSeedConferenceB = winnerOfThirdRoundMatchSix;

		}
		else
		{
			secondSeedConferenceB = winnerOfThirdRoundMatchFive;
			topSeedConferenceB = winnerOfThirdRoundMatchSix;

		}
		int thirdSeedConferenceB;
		int fourthSeedConferenceB;
		if(conferenceBWinCounter[1] == 4)
		{
			thirdSeedConferenceB = winnerOfThirdRoundMatchEight;
			fourthSeedConferenceB = winnerOfThirdRoundMatchSeven;
		}
		else
		{
			fourthSeedConferenceB = winnerOfThirdRoundMatchEight;
			thirdSeedConferenceB = winnerOfThirdRoundMatchSeven;
		}
		int fifthSeedConferenceB;
		int sixthSeedConferenceB;
		if(conferenceBWinCounter[2] == 4)
		{
			fifthSeedConferenceB = loserOfThirdRoundMatchFive;
			sixthSeedConferenceB = loserOfThirdRoundMatchSix;
		}
		else
		{
			sixthSeedConferenceB = loserOfThirdRoundMatchFive;
			fifthSeedConferenceB = loserOfThirdRoundMatchSix;
		}
		int seventhSeedConferenceB;
		int eighthSeedConferenceB;
		if(conferenceBWinCounter[3] == 4)
		{
			seventhSeedConferenceB = loserOfThirdRoundMatchEight;
			eighthSeedConferenceB = loserOfThirdRoundMatchSeven;
		}
		else
		{
			eighthSeedConferenceB = loserOfThirdRoundMatchEight;
			seventhSeedConferenceB = loserOfThirdRoundMatchSeven;
		}
		int ninthSeedConferenceA;
		int tenthSeedConferenceA;
		if(conferenceAWinCounter[8] == 4)
		{
			ninthSeedConferenceA = winnerOfThirdRoundMatchNine;
			tenthSeedConferenceA = winnerOfThirdRoundMatchTen;
		}
		else
		{
			tenthSeedConferenceA = winnerOfThirdRoundMatchNine;
			ninthSeedConferenceA = winnerOfThirdRoundMatchTen;
		}
		int eleventhSeedConferenceA;
		int twelfthSeedConferenceA;
		if(conferenceAWinCounter[9] == 4)
		{
			eleventhSeedConferenceA = winnerOfThirdRoundMatchTwelve;
			twelfthSeedConferenceA = winnerOfThirdRoundMatchEleven;
		}
		else
		{
			twelfthSeedConferenceA = winnerOfThirdRoundMatchTwelve;
			eleventhSeedConferenceA = winnerOfThirdRoundMatchEleven;
		}
		int thirteenthSeedConferenceA;
		int forteenthSeedConferenceA;
		if(conferenceAWinCounter[10] == 4)
		{
			thirteenthSeedConferenceA = loserOfThirdRoundMatchNine;
			forteenthSeedConferenceA = loserOfThirdRoundMatchTen;
		}
		else
		{
			forteenthSeedConferenceA = loserOfThirdRoundMatchNine;
			thirteenthSeedConferenceA = loserOfThirdRoundMatchTen;
		}
		int fifteenthSeedConferenceA;
		int sixteenthSeedConferenceA;
		if(conferenceAWinCounter[11] == 4)
		{
			fifteenthSeedConferenceA = loserOfThirdRoundMatchTwelve;
			sixteenthSeedConferenceA = loserOfThirdRoundMatchEleven;
		}
		else
		{
			sixteenthSeedConferenceA = loserOfThirdRoundMatchTwelve;
			fifteenthSeedConferenceA = loserOfThirdRoundMatchEleven;
		}
		int ninthSeedConferenceB;
		int tenthSeedConferenceB;
		if(conferenceBWinCounter[8] == 4)
		{
			ninthSeedConferenceB = winnerOfThirdRoundMatchThirteen;
			tenthSeedConferenceB = winnerOfThirdRoundMatchForteen;
		}
		else
		{
			tenthSeedConferenceB = winnerOfThirdRoundMatchThirteen;
			ninthSeedConferenceB = winnerOfThirdRoundMatchForteen;
		}
		int eleventhSeedConferenceB;
		int twelfthSeedConferenceB;
		if(conferenceBWinCounter[9] == 4)
		{
			eleventhSeedConferenceB = winnerOfThirdRoundMatchSixteen;
			twelfthSeedConferenceB = winnerOfThirdRoundMatchFifteen;
		}
		else
		{
			twelfthSeedConferenceB = winnerOfThirdRoundMatchSixteen;
			eleventhSeedConferenceB = winnerOfThirdRoundMatchFifteen;
		}
		int thirteenthSeedConferenceB;
		int forteenthSeedConferenceB;
		if(conferenceBWinCounter[10] == 4)
		{
			thirteenthSeedConferenceB = loserOfThirdRoundMatchThirteen;
			forteenthSeedConferenceB = loserOfThirdRoundMatchForteen;
		}
		else
		{
			forteenthSeedConferenceB = loserOfThirdRoundMatchThirteen;
			thirteenthSeedConferenceB = loserOfThirdRoundMatchForteen;
		}
		int fifteenthSeedConferenceB;
		int sixteenthSeedConferenceB;
		if(conferenceBWinCounter[11] == 4)
		{
			fifteenthSeedConferenceB = loserOfThirdRoundMatchSixteen;
			sixteenthSeedConferenceB = loserOfThirdRoundMatchFifteen;
		}
		else
		{
			sixteenthSeedConferenceB = loserOfThirdRoundMatchSixteen;
			fifteenthSeedConferenceB = loserOfThirdRoundMatchFifteen;
		}
		gamesPlayed = 0;
		conferenceAWinCounter = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0};
		conferenceBWinCounter = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0};
		while(gamesPlayed < 7)
		{
			startingGame = gamesPlayed + 2;
			gameResults.println("Game " +  (startingGame-1) + ",Home,Score,Away,Score");
			if(conferenceAWinCounter[0] != 4 && conferenceAWinCounter[7] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(topSeedConferenceA).getLeagueRank() < create.getTeam(topSeedConferenceB).getLeagueRank())
				{
					higherSeed = topSeedConferenceA;
					lowerSeed = topSeedConferenceB;
				}
				else
				{
					higherSeed = topSeedConferenceB; 
					lowerSeed = topSeedConferenceA;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != topSeedConferenceA)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == topSeedConferenceA)flag = !flag;
				}
				//boolean flag = executeGame(false, topSeedConferenceA,topSeedConferenceB);
				if(flag)conferenceAWinCounter[0]++;
				else conferenceAWinCounter[7]++;
			}
			if(conferenceAWinCounter[1] != 4 && conferenceAWinCounter[6] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(secondSeedConferenceA).getLeagueRank() < create.getTeam(secondSeedConferenceB).getLeagueRank())
				{
					higherSeed = secondSeedConferenceA;
					lowerSeed = secondSeedConferenceB;
				}
				else
				{
					higherSeed = secondSeedConferenceB; 
					lowerSeed = secondSeedConferenceA;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != secondSeedConferenceA)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == secondSeedConferenceA)flag = !flag;
				}
				//boolean flag = executeGame(false, secondSeedConferenceA,secondSeedConferenceB);
				if(flag)conferenceAWinCounter[1]++;
				else conferenceAWinCounter[6]++;
			}
			if(conferenceAWinCounter[2] != 4 && conferenceAWinCounter[5] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(thirdSeedConferenceA).getLeagueRank() < create.getTeam(thirdSeedConferenceB).getLeagueRank())
				{
					higherSeed = thirdSeedConferenceA;
					lowerSeed = thirdSeedConferenceB;
				}
				else
				{
					higherSeed = thirdSeedConferenceB; 
					lowerSeed = thirdSeedConferenceA;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != thirdSeedConferenceA)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == thirdSeedConferenceA)flag = !flag;
				}
				//boolean flag = executeGame(false, thirdSeedConferenceA,thirdSeedConferenceB);
				if(flag)conferenceAWinCounter[2]++;
				else conferenceAWinCounter[5]++;
			}
			if(conferenceAWinCounter[3] != 4 && conferenceAWinCounter[4] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(fourthSeedConferenceA).getLeagueRank() < create.getTeam(fourthSeedConferenceB).getLeagueRank())
				{
					higherSeed = fourthSeedConferenceA;
					lowerSeed = fourthSeedConferenceB;
				}
				else
				{
					higherSeed = fourthSeedConferenceB; 
					lowerSeed = fourthSeedConferenceA;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != fourthSeedConferenceA)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == fourthSeedConferenceA)flag = !flag;
				}
				//boolean flag = executeGame(false, fourthSeedConferenceA,fourthSeedConferenceB);
				if(flag)conferenceAWinCounter[3]++;
				else conferenceAWinCounter[4]++;
			}
			if(conferenceBWinCounter[0] != 4 && conferenceBWinCounter[7] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(fifthSeedConferenceA).getLeagueRank() < create.getTeam(fifthSeedConferenceB).getLeagueRank())
				{
					higherSeed = fifthSeedConferenceA;
					lowerSeed = fifthSeedConferenceB;
				}
				else
				{
					higherSeed = fifthSeedConferenceB; 
					lowerSeed = fifthSeedConferenceA;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != fifthSeedConferenceA)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == fifthSeedConferenceA)flag = !flag;
				}
				//boolean flag = executeGame(false, fifthSeedConferenceA,fifthSeedConferenceB);
				if(flag)conferenceBWinCounter[0]++;
				else conferenceBWinCounter[7]++;
			}
			if(conferenceBWinCounter[1] != 4 && conferenceBWinCounter[6] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(sixthSeedConferenceA).getLeagueRank() < create.getTeam(sixthSeedConferenceB).getLeagueRank())
				{
					higherSeed = sixthSeedConferenceA;
					lowerSeed = sixthSeedConferenceB;
				}
				else
				{
					higherSeed = sixthSeedConferenceB; 
					lowerSeed = sixthSeedConferenceA;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != sixthSeedConferenceA)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == sixthSeedConferenceA)flag = !flag;
				}
				//boolean flag = executeGame(false, sixthSeedConferenceA,sixthSeedConferenceB);
				if(flag)conferenceBWinCounter[1]++;
				else conferenceBWinCounter[6]++;
			}
			if(conferenceBWinCounter[2] != 4 && conferenceBWinCounter[5] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(seventhSeedConferenceA).getLeagueRank() < create.getTeam(seventhSeedConferenceB).getLeagueRank())
				{
					higherSeed = seventhSeedConferenceA;
					lowerSeed = seventhSeedConferenceB;
				}
				else
				{
					higherSeed = seventhSeedConferenceB; 
					lowerSeed = seventhSeedConferenceA;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != seventhSeedConferenceA)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == seventhSeedConferenceA)flag = !flag;
				}
				//boolean flag = executeGame(false, seventhSeedConferenceA,seventhSeedConferenceB);
				if(flag)conferenceBWinCounter[2]++;
				else conferenceBWinCounter[5]++;
			}
			if(conferenceBWinCounter[3] != 4 && conferenceBWinCounter[4] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(eighthSeedConferenceA).getLeagueRank() < create.getTeam(eighthSeedConferenceB).getLeagueRank())
				{
					higherSeed = eighthSeedConferenceA;
					lowerSeed = eighthSeedConferenceB;
				}
				else
				{
					higherSeed = eighthSeedConferenceB; 
					lowerSeed = eighthSeedConferenceA;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != eighthSeedConferenceA)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == eighthSeedConferenceA)flag = !flag;
				}
				//boolean flag = executeGame(false, eighthSeedConferenceA,eighthSeedConferenceB);
				if(flag)conferenceBWinCounter[3]++;
				else conferenceBWinCounter[4]++;
			}
			if(conferenceAWinCounter[8] != 4 && conferenceAWinCounter[15] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(ninthSeedConferenceA).getLeagueRank() < create.getTeam(ninthSeedConferenceB).getLeagueRank())
				{
					higherSeed = ninthSeedConferenceA;
					lowerSeed = ninthSeedConferenceB;
				}
				else
				{
					higherSeed = ninthSeedConferenceB; 
					lowerSeed = ninthSeedConferenceA;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != ninthSeedConferenceA)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == ninthSeedConferenceA)flag = !flag;
				}
				//boolean flag = executeGame(false, ninthSeedConferenceA,ninthSeedConferenceB);
				if(flag)conferenceAWinCounter[8]++;
				else conferenceAWinCounter[15]++;
			}
			if(conferenceAWinCounter[9] != 4 && conferenceAWinCounter[14] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(tenthSeedConferenceA).getLeagueRank() < create.getTeam(tenthSeedConferenceB).getLeagueRank())
				{
					higherSeed = tenthSeedConferenceA;
					lowerSeed = tenthSeedConferenceB;
				}
				else
				{
					higherSeed = tenthSeedConferenceB; 
					lowerSeed = tenthSeedConferenceA;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != tenthSeedConferenceA)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == tenthSeedConferenceA)flag = !flag;
				}
				//boolean flag = executeGame(false, tenthSeedConferenceA,tenthSeedConferenceB);
				if(flag)conferenceAWinCounter[9]++;
				else conferenceAWinCounter[14]++;
			}
			if(conferenceAWinCounter[10] != 4 && conferenceAWinCounter[13] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(eleventhSeedConferenceA).getLeagueRank() < create.getTeam(eleventhSeedConferenceB).getLeagueRank())
				{
					higherSeed = eleventhSeedConferenceA;
					lowerSeed = eleventhSeedConferenceB;
				}
				else
				{
					higherSeed = eleventhSeedConferenceB; 
					lowerSeed = eleventhSeedConferenceA;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != eleventhSeedConferenceA)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == eleventhSeedConferenceA)flag = !flag;
				}
				//boolean flag = executeGame(false, eleventhSeedConferenceA,eleventhSeedConferenceB);
				if(flag)conferenceAWinCounter[10]++;
				else conferenceAWinCounter[13]++;
			}
			if(conferenceAWinCounter[11] != 4 && conferenceAWinCounter[12] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(twelfthSeedConferenceA).getLeagueRank() < create.getTeam(twelfthSeedConferenceB).getLeagueRank())
				{
					higherSeed = twelfthSeedConferenceA;
					lowerSeed = twelfthSeedConferenceB;
				}
				else
				{
					higherSeed = twelfthSeedConferenceB; 
					lowerSeed = twelfthSeedConferenceA;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != twelfthSeedConferenceA)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == twelfthSeedConferenceA)flag = !flag;
				}
				//boolean flag = executeGame(false, twelfthSeedConferenceA,twelfthSeedConferenceB);
				if(flag)conferenceAWinCounter[11]++;
				else conferenceAWinCounter[12]++;
			}
			if(conferenceBWinCounter[8] != 4 && conferenceBWinCounter[15] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(thirteenthSeedConferenceA).getLeagueRank() < create.getTeam(thirteenthSeedConferenceB).getLeagueRank())
				{
					higherSeed = thirteenthSeedConferenceA;
					lowerSeed = thirteenthSeedConferenceB;
				}
				else
				{
					higherSeed = thirteenthSeedConferenceB; 
					lowerSeed = thirteenthSeedConferenceA;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != thirteenthSeedConferenceA)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == thirteenthSeedConferenceA)flag = !flag;
				}
				//boolean flag = executeGame(false, thirteenthSeedConferenceA,thirteenthSeedConferenceB);
				if(flag)conferenceBWinCounter[8]++;
				else conferenceBWinCounter[15]++;
			}
			if(conferenceBWinCounter[9] != 4 && conferenceBWinCounter[14] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(forteenthSeedConferenceA).getLeagueRank() < create.getTeam(forteenthSeedConferenceB).getLeagueRank())
				{
					higherSeed = forteenthSeedConferenceA;
					lowerSeed = forteenthSeedConferenceB;
				}
				else
				{
					higherSeed = forteenthSeedConferenceB; 
					lowerSeed = forteenthSeedConferenceA;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != forteenthSeedConferenceA)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == forteenthSeedConferenceA)flag = !flag;
				}
				//boolean flag = executeGame(false, forteenthSeedConferenceA,forteenthSeedConferenceB);
				if(flag)conferenceBWinCounter[9]++;
				else conferenceBWinCounter[14]++;
			}
			if(conferenceBWinCounter[10] != 4 && conferenceBWinCounter[13] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(fifteenthSeedConferenceA).getLeagueRank() < create.getTeam(fifteenthSeedConferenceB).getLeagueRank())
				{
					higherSeed = fifteenthSeedConferenceA;
					lowerSeed = fifteenthSeedConferenceB;
				}
				else
				{
					higherSeed = fifteenthSeedConferenceB; 
					lowerSeed = fifteenthSeedConferenceA;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != fifteenthSeedConferenceA)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == fifteenthSeedConferenceA)flag = !flag;
				}
				//boolean flag = executeGame(false, fifteenthSeedConferenceA,fifteenthSeedConferenceB);
				if(flag)conferenceBWinCounter[10]++;
				else conferenceBWinCounter[13]++;
			}
			if(conferenceBWinCounter[11] != 4 && conferenceBWinCounter[12] != 4)
			{
				boolean flag = false;
				int higherSeed = 0, lowerSeed = 0;
				if(create.getTeam(sixteenthSeedConferenceA).getLeagueRank() < create.getTeam(sixteenthSeedConferenceB).getLeagueRank())
				{
					higherSeed = sixteenthSeedConferenceA;
					lowerSeed = sixteenthSeedConferenceB;
				}
				else
				{
					higherSeed = sixteenthSeedConferenceB; 
					lowerSeed = sixteenthSeedConferenceA;
				}
				if(gamesPlayed != 2 && gamesPlayed != 3 && gamesPlayed != 5)
				{
					flag = executeGame(false, higherSeed,lowerSeed);
					if(higherSeed != sixteenthSeedConferenceA)flag = !flag;
				}
				else
				{
					flag = executeGame(false, lowerSeed, higherSeed);
					if(higherSeed == sixteenthSeedConferenceA)flag = !flag;
				}
				//boolean flag = executeGame(false, sixteenthSeedConferenceA,sixteenthSeedConferenceB);
				if(flag)conferenceBWinCounter[11]++;
				else conferenceBWinCounter[12]++;
			}
			writer.println();
			gamesPlayed++;


		}

		if(conferenceAWinCounter[0] == 4)
		{
			System.out.println("01. " + create.getTeam(topSeedConferenceA).getTeamName());
			System.out.println("02. " + create.getTeam(topSeedConferenceB).getTeamName());

		}
		else
		{
			System.out.println("01. " + create.getTeam(topSeedConferenceB).getTeamName());
			System.out.println("02. " + create.getTeam(topSeedConferenceA).getTeamName());
		}
		if(conferenceAWinCounter[1] == 4)
		{
			System.out.println("03. " + create.getTeam(secondSeedConferenceA).getTeamName());
			System.out.println("04. " + create.getTeam(secondSeedConferenceB).getTeamName());
		}
		else
		{
			System.out.println("03. " + create.getTeam(secondSeedConferenceB).getTeamName());
			System.out.println("04. " + create.getTeam(secondSeedConferenceA).getTeamName());
		}

		if(conferenceBWinCounter[0] == 4)
		{
			System.out.println("05. " + create.getTeam(fifthSeedConferenceA).getTeamName());
			System.out.println("06. " + create.getTeam(fifthSeedConferenceB).getTeamName());
		}
		else
		{
			System.out.println("05. " + create.getTeam(fifthSeedConferenceB).getTeamName());
			System.out.println("06. " + create.getTeam(fifthSeedConferenceA).getTeamName());
		}
		if(conferenceBWinCounter[1] == 4)
		{
			System.out.println("07. " + create.getTeam(sixthSeedConferenceA).getTeamName());
			System.out.println("08. " + create.getTeam(sixthSeedConferenceB).getTeamName());
		}
		else
		{
			System.out.println("07. " + create.getTeam(sixthSeedConferenceB).getTeamName());
			System.out.println("08. " + create.getTeam(sixthSeedConferenceA).getTeamName());
		}
		if(conferenceAWinCounter[2] == 4)
		{
			System.out.println("09. " + create.getTeam(thirdSeedConferenceA).getTeamName());
			System.out.println("10. " + create.getTeam(thirdSeedConferenceB).getTeamName());
		}
		else
		{
			System.out.println("09. " + create.getTeam(thirdSeedConferenceB).getTeamName());
			System.out.println("10. " + create.getTeam(thirdSeedConferenceA).getTeamName());
		}
		if(conferenceAWinCounter[3] == 4)
		{
			System.out.println("11. " + create.getTeam(fourthSeedConferenceA).getTeamName());
			System.out.println("12. " + create.getTeam(fourthSeedConferenceB).getTeamName());
		}
		else
		{
			System.out.println("11. " + create.getTeam(fourthSeedConferenceB).getTeamName());
			System.out.println("12. " + create.getTeam(fourthSeedConferenceA).getTeamName());
		}
		if(conferenceBWinCounter[2] == 4)
		{
			System.out.println("13. " + create.getTeam(seventhSeedConferenceA).getTeamName());
			System.out.println("14. " + create.getTeam(seventhSeedConferenceB).getTeamName());
		}
		else
		{
			System.out.println("13. " + create.getTeam(seventhSeedConferenceB).getTeamName());
			System.out.println("14. " + create.getTeam(seventhSeedConferenceA).getTeamName());
		}
		if(conferenceBWinCounter[3] == 4)
		{
			System.out.println("15. " + create.getTeam(eighthSeedConferenceA).getTeamName());
			System.out.println("16. " + create.getTeam(eighthSeedConferenceB).getTeamName());
		}
		else
		{
			System.out.println("15. " + create.getTeam(eighthSeedConferenceB).getTeamName());
			System.out.println("16. " + create.getTeam(eighthSeedConferenceA).getTeamName());
		}
		if(conferenceAWinCounter[8] == 4)
		{
			System.out.println("17. " + create.getTeam(ninthSeedConferenceA).getTeamName());
			System.out.println("18. " + create.getTeam(ninthSeedConferenceB).getTeamName());
		}
		else
		{
			System.out.println("17. " + create.getTeam(ninthSeedConferenceB).getTeamName());
			System.out.println("18. " + create.getTeam(ninthSeedConferenceA).getTeamName());
		}
		if(conferenceAWinCounter[9] == 4)
		{
			System.out.println("19. " + create.getTeam(tenthSeedConferenceA).getTeamName());
			System.out.println("20. " + create.getTeam(tenthSeedConferenceB).getTeamName());
		}
		else
		{
			System.out.println("19. " + create.getTeam(tenthSeedConferenceB).getTeamName());
			System.out.println("20. " + create.getTeam(tenthSeedConferenceA).getTeamName());
		}

		if(conferenceBWinCounter[8] == 4)
		{
			System.out.println("21. " + create.getTeam(thirteenthSeedConferenceA).getTeamName());
			System.out.println("22. " + create.getTeam(thirteenthSeedConferenceB).getTeamName());
		}
		else
		{
			System.out.println("21. " + create.getTeam(thirteenthSeedConferenceB).getTeamName());
			System.out.println("22. " + create.getTeam(thirteenthSeedConferenceA).getTeamName());
		}
		if(conferenceBWinCounter[9] == 4)
		{
			System.out.println("23. " + create.getTeam(forteenthSeedConferenceA).getTeamName());
			System.out.println("24. " + create.getTeam(forteenthSeedConferenceB).getTeamName());
		}
		else
		{
			System.out.println("23. " + create.getTeam(forteenthSeedConferenceB).getTeamName());
			System.out.println("24. " + create.getTeam(forteenthSeedConferenceA).getTeamName());
		}
		if(conferenceAWinCounter[10] == 4)
		{
			System.out.println("25. " + create.getTeam(eleventhSeedConferenceA).getTeamName());
			System.out.println("26. " + create.getTeam(eleventhSeedConferenceB).getTeamName());
		}
		else
		{
			System.out.println("25. " + create.getTeam(eleventhSeedConferenceB).getTeamName());
			System.out.println("26. " + create.getTeam(eleventhSeedConferenceA).getTeamName());
		}
		if(conferenceAWinCounter[11] == 4)
		{
			System.out.println("27. " + create.getTeam(twelfthSeedConferenceA).getTeamName());
			System.out.println("28. " + create.getTeam(twelfthSeedConferenceB).getTeamName());
		}
		else
		{
			System.out.println("27. " + create.getTeam(twelfthSeedConferenceB).getTeamName());
			System.out.println("28. " + create.getTeam(twelfthSeedConferenceA).getTeamName());
		}
		if(conferenceBWinCounter[10] == 4)
		{
			System.out.println("29. " + create.getTeam(fifteenthSeedConferenceA).getTeamName());
			System.out.println("30. " + create.getTeam(fifteenthSeedConferenceB).getTeamName());
		}
		else
		{
			System.out.println("29. " + create.getTeam(fifteenthSeedConferenceB).getTeamName());
			System.out.println("30. " + create.getTeam(fifteenthSeedConferenceA).getTeamName());
		}
		if(conferenceBWinCounter[11] == 4)
		{
			System.out.println("31. " + create.getTeam(sixteenthSeedConferenceA).getTeamName());
			System.out.println("32. " + create.getTeam(sixteenthSeedConferenceB).getTeamName());
		}
		else
		{
			System.out.println("31. " + create.getTeam(sixteenthSeedConferenceB).getTeamName());
			System.out.println("32. " + create.getTeam(sixteenthSeedConferenceA).getTeamName());
		}
		if(secondSeedConferenceA == 7 && fifthSeedConferenceA == 11 && (topSeedConferenceB == 26 || topSeedConferenceB == 28) && fifthSeedConferenceB == 20 && (secondSeedConferenceB == 28 || secondSeedConferenceB == 26) && sixthSeedConferenceB == 17)
		{
			return retVal;
		}
		return false;
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
		int pos, layupStat, dunkStat, jumpStat, passing, shotContest, defenseIQ, jumping, seperation, staminaRating, threeStat, durabilityRating;

		System.out.println("Enter the name:");
		playerName = kb.nextLine();
		System.out.println("Enter pos: ");
		pos = kb.nextInt();
		layupStat = kb.nextInt();
		dunkStat = kb.nextInt();
		jumpStat = kb.nextInt();
		threeStat = kb.nextInt();
		passing = kb.nextInt();
		shotContest = kb.nextInt();
		defenseIQ = kb.nextInt();
		jumping = kb.nextInt();
		seperation = kb.nextInt();
		durabilityRating = kb.nextInt();
		staminaRating = kb.nextInt();
		create.getTeam(teamNum).addPlayer(new player(pos, layupStat, dunkStat, jumpStat, threeStat, passing, shotContest, defenseIQ, jumping, seperation, durabilityRating, staminaRating, playerName, false));
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
			System.out.println(create.getTeam(firstTeamNum).getPlayer(i).getName() + " " + create.getTeam(firstTeamNum).getPlayer(i).getPosition());
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
		player othertemp = null;
		if(secondTeamPlayer != 100)othertemp = create.getTeam(secondTeamNum).getPlayer(secondTeamPlayer);

		create.getTeam(firstTeamNum).removePlayer(firstTeamPlayer);
		if(secondTeamPlayer != 100)create.getTeam(secondTeamNum).removePlayer(secondTeamPlayer);

		if(secondTeamPlayer != 100)create.getTeam(firstTeamNum).addPlayer(othertemp);
		create.getTeam(secondTeamNum).addPlayer(temp);
	}
	private static void calculateStandings()
	{
		DivisionA = new ArrayList<team>();
		DivisionB = new ArrayList<team>();
		DivisionC = new ArrayList<team>();
		DivisionD = new ArrayList<team>();
		ConferenceA = new ArrayList<team>();
		ConferenceB = new ArrayList<team>();
		League = new ArrayList<team>();

		for(int i = 0; i < 8; i++)
		{
			DivisionA.add(create.getTeam(i));
			DivisionB.add(create.getTeam(i+8));
			DivisionC.add(create.getTeam(i+16));
			DivisionD.add(create.getTeam(i+24));
		}


		Collections.sort(DivisionA);


		Collections.sort(DivisionB);



		Collections.sort(DivisionC);




		Collections.sort(DivisionD);

		ConferenceA.addAll(DivisionA);
		ConferenceA.addAll(DivisionB);
		Collections.sort(ConferenceA);
		ConferenceB.addAll(DivisionC);
		ConferenceB.addAll(DivisionD);
		Collections.sort(ConferenceB);

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
		standings.println("Division A, Wins,Losses,Points Scored,Points Against,Division Rank,Conference Rank,League Rank, Division Wins, Division Losses, Conference Wins, Conference Losses");
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

		startingGame = 1;
		gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,21, 0);
		executeGame(false,20, 22);
		executeGame(false,19, 23);
		executeGame(false,18, 24);
		executeGame(false,17, 25);
		executeGame(false,16, 26);
		executeGame(false,15, 27);
		executeGame(false,14, 28);
		executeGame(false,13, 29);
		executeGame(false,12, 30);
		executeGame(false,11, 31);
		executeGame(false,10, 1);
		executeGame(false,9, 2);
		executeGame(false,8, 3);
		executeGame(false,7, 4);
		executeGame(false,6, 5);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,31, 22);
		executeGame(false,21, 23);
		executeGame(false,20, 24);
		executeGame(false,19, 25);
		executeGame(false,18, 26);
		executeGame(false,17, 27);
		executeGame(false,16, 28);
		executeGame(false,30, 29);
		executeGame(false,0, 9);
		executeGame(false,10, 8);
		executeGame(false,11, 7);
		executeGame(false,12, 6);
		executeGame(false,13, 5);
		executeGame(false,14, 4);
		executeGame(false,15, 3);
		executeGame(false,1, 2);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 3);
		executeGame(false,4, 2);
		executeGame(false,5, 1);
		executeGame(false,7, 6);
		executeGame(false,8, 11);
		executeGame(false,12, 10);
		executeGame(false,13, 9);
		executeGame(false,15, 14);
		executeGame(false,31, 28);
		executeGame(false,27, 29);
		executeGame(false,26, 30);
		executeGame(false,24, 25);
		executeGame(false,23, 20);
		executeGame(false,19, 21);
		executeGame(false,18, 22);
		executeGame(false,16, 17);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,2, 0);
		executeGame(false,3, 1);
		executeGame(false,4, 31);
		executeGame(false,5, 30);
		executeGame(false,6, 29);
		executeGame(false,7, 28);
		executeGame(false,8, 27);
		executeGame(false,9, 26);
		executeGame(false,10, 25);
		executeGame(false,11, 24);
		executeGame(false,12, 23);
		executeGame(false,13, 22);
		executeGame(false,14, 21);
		executeGame(false,15, 20);
		executeGame(false,16, 19);
		executeGame(false,17, 18);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,31, 18);
		executeGame(false,17, 19);
		executeGame(false,16, 20);
		executeGame(false,30, 21);
		executeGame(false,29, 22);
		executeGame(false,28, 23);
		executeGame(false,27, 24);
		executeGame(false,26, 25);
		executeGame(false,0, 13);
		executeGame(false,14, 12);
		executeGame(false,15, 11);
		executeGame(false,1, 10);
		executeGame(false,2, 9);
		executeGame(false,3, 8);
		executeGame(false,4, 7);
		executeGame(false,5, 6);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 10);
		executeGame(false,9, 11);
		executeGame(false,8, 12);
		executeGame(false,7, 13);
		executeGame(false,6, 14);
		executeGame(false,5, 15);
		executeGame(false,4, 16);
		executeGame(false,3, 17);
		executeGame(false,2, 18);
		executeGame(false,1, 19);
		executeGame(false,31, 20);
		executeGame(false,30, 21);
		executeGame(false,29, 22);
		executeGame(false,28, 23);
		executeGame(false,27, 24);
		executeGame(false,26, 25);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,20, 0);
		executeGame(false,21, 19);
		executeGame(false,22, 18);
		executeGame(false,23, 17);
		executeGame(false,24, 16);
		executeGame(false,25, 15);
		executeGame(false,26, 14);
		executeGame(false,27, 13);
		executeGame(false,28, 12);
		executeGame(false,29, 11);
		executeGame(false,30, 10);
		executeGame(false,31, 9);
		executeGame(false,1, 8);
		executeGame(false,2, 7);
		executeGame(false,3, 6);
		executeGame(false,4, 5);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,22, 0);
		executeGame(false,23, 21);
		executeGame(false,24, 20);
		executeGame(false,25, 19);
		executeGame(false,26, 18);
		executeGame(false,27, 17);
		executeGame(false,28, 16);
		executeGame(false,29, 15);
		executeGame(false,30, 14);
		executeGame(false,31, 13);
		executeGame(false,1, 12);
		executeGame(false,2, 11);
		executeGame(false,3, 10);
		executeGame(false,4, 9);
		executeGame(false,5, 8);
		executeGame(false,6, 7);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 14);
		executeGame(false,13, 15);
		executeGame(false,12, 16);
		executeGame(false,11, 17);
		executeGame(false,10, 18);
		executeGame(false,9, 19);
		executeGame(false,8, 20);
		executeGame(false,7, 21);
		executeGame(false,6, 22);
		executeGame(false,5, 23);
		executeGame(false,4, 24);
		executeGame(false,3, 25);
		executeGame(false,2, 26);
		executeGame(false,1, 27);
		executeGame(false,31, 28);
		executeGame(false,30, 29);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 27);
		executeGame(false,28, 26);
		executeGame(false,29, 25);
		executeGame(false,30, 24);
		executeGame(false,31, 23);
		executeGame(false,1, 22);
		executeGame(false,2, 21);
		executeGame(false,3, 20);
		executeGame(false,4, 19);
		executeGame(false,5, 18);
		executeGame(false,6, 17);
		executeGame(false,7, 16);
		executeGame(false,8, 15);
		executeGame(false,9, 14);
		executeGame(false,10, 13);
		executeGame(false,11, 12);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,16, 0);
		executeGame(false,17, 15);
		executeGame(false,18, 14);
		executeGame(false,19, 13);
		executeGame(false,20, 12);
		executeGame(false,21, 11);
		executeGame(false,22, 10);
		executeGame(false,23, 9);
		executeGame(false,24, 8);
		executeGame(false,25, 7);
		executeGame(false,26, 6);
		executeGame(false,27, 5);
		executeGame(false,28, 4);
		executeGame(false,29, 3);
		executeGame(false,30, 2);
		executeGame(false,31, 1);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,31, 24);
		executeGame(false,23, 25);
		executeGame(false,22, 26);
		executeGame(false,21, 27);
		executeGame(false,20, 28);
		executeGame(false,19, 29);
		executeGame(false,18, 30);
		executeGame(false,17, 16);
		executeGame(false,0, 7);
		executeGame(false,8, 6);
		executeGame(false,9, 5);
		executeGame(false,10, 4);
		executeGame(false,11, 3);
		executeGame(false,12, 2);
		executeGame(false,13, 1);
		executeGame(false,14, 15);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,31, 0);
		executeGame(false,30, 1);
		executeGame(false,29, 2);
		executeGame(false,28, 3);
		executeGame(false,27, 4);
		executeGame(false,26, 5);
		executeGame(false,25, 6);
		executeGame(false,24, 7);
		executeGame(false,23, 8);
		executeGame(false,22, 9);
		executeGame(false,21, 10);
		executeGame(false,20, 11);
		executeGame(false,19, 12);
		executeGame(false,18, 13);
		executeGame(false,17, 14);
		executeGame(false,16, 15);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,5, 0);
		executeGame(false,4, 6);
		executeGame(false,3, 7);
		executeGame(false,2, 8);
		executeGame(false,1, 9);
		executeGame(false,31, 10);
		executeGame(false,30, 11);
		executeGame(false,29, 12);
		executeGame(false,28, 13);
		executeGame(false,27, 14);
		executeGame(false,26, 15);
		executeGame(false,25, 16);
		executeGame(false,24, 17);
		executeGame(false,23, 18);
		executeGame(false,22, 19);
		executeGame(false,21, 20);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 11);
		executeGame(false,12, 10);
		executeGame(false,13, 9);
		executeGame(false,14, 8);
		executeGame(false,15, 7);
		executeGame(false,16, 6);
		executeGame(false,17, 5);
		executeGame(false,18, 4);
		executeGame(false,19, 3);
		executeGame(false,20, 2);
		executeGame(false,21, 1);
		executeGame(false,22, 31);
		executeGame(false,23, 30);
		executeGame(false,24, 29);
		executeGame(false,25, 28);
		executeGame(false,26, 27);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 2);
		executeGame(false,1, 3);
		executeGame(false,31, 4);
		executeGame(false,30, 5);
		executeGame(false,29, 6);
		executeGame(false,28, 7);
		executeGame(false,27, 8);
		executeGame(false,26, 9);
		executeGame(false,25, 10);
		executeGame(false,24, 11);
		executeGame(false,23, 12);
		executeGame(false,22, 13);
		executeGame(false,21, 14);
		executeGame(false,20, 15);
		executeGame(false,19, 16);
		executeGame(false,18, 17);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,4, 0);
		executeGame(false,5, 3);
		executeGame(false,6, 2);
		executeGame(false,7, 1);
		executeGame(false,12, 8);
		executeGame(false,13, 11);
		executeGame(false,14, 10);
		executeGame(false,15, 9);
		executeGame(false,27, 31);
		executeGame(false,26, 28);
		executeGame(false,25, 29);
		executeGame(false,24, 30);
		executeGame(false,19, 23);
		executeGame(false,18, 20);
		executeGame(false,17, 21);
		executeGame(false,16, 22);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 7);
		executeGame(false,8, 6);
		executeGame(false,9, 5);
		executeGame(false,10, 4);
		executeGame(false,11, 3);
		executeGame(false,12, 2);
		executeGame(false,13, 1);
		executeGame(false,14, 31);
		executeGame(false,15, 30);
		executeGame(false,16, 29);
		executeGame(false,17, 28);
		executeGame(false,18, 27);
		executeGame(false,19, 26);
		executeGame(false,20, 25);
		executeGame(false,21, 24);
		executeGame(false,22, 23);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 15);
		executeGame(false,16, 14);
		executeGame(false,17, 13);
		executeGame(false,18, 12);
		executeGame(false,19, 11);
		executeGame(false,20, 10);
		executeGame(false,21, 9);
		executeGame(false,22, 8);
		executeGame(false,23, 7);
		executeGame(false,24, 6);
		executeGame(false,25, 5);
		executeGame(false,26, 4);
		executeGame(false,27, 3);
		executeGame(false,28, 2);
		executeGame(false,29, 1);
		executeGame(false,30, 31);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 26);
		executeGame(false,25, 27);
		executeGame(false,24, 28);
		executeGame(false,23, 29);
		executeGame(false,22, 30);
		executeGame(false,21, 31);
		executeGame(false,20, 1);
		executeGame(false,19, 2);
		executeGame(false,18, 3);
		executeGame(false,17, 4);
		executeGame(false,16, 5);
		executeGame(false,15, 6);
		executeGame(false,14, 7);
		executeGame(false,13, 8);
		executeGame(false,12, 9);
		executeGame(false,11, 10);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,13, 0);
		executeGame(false,12, 14);
		executeGame(false,11, 15);
		executeGame(false,10, 16);
		executeGame(false,9, 17);
		executeGame(false,8, 18);
		executeGame(false,7, 19);
		executeGame(false,6, 20);
		executeGame(false,5, 21);
		executeGame(false,4, 22);
		executeGame(false,3, 23);
		executeGame(false,2, 24);
		executeGame(false,1, 25);
		executeGame(false,31, 26);
		executeGame(false,30, 27);
		executeGame(false,29, 28);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,7, 0);
		executeGame(false,6, 8);
		executeGame(false,5, 9);
		executeGame(false,4, 10);
		executeGame(false,3, 11);
		executeGame(false,2, 12);
		executeGame(false,1, 13);
		executeGame(false,31, 14);
		executeGame(false,30, 15);
		executeGame(false,29, 16);
		executeGame(false,28, 17);
		executeGame(false,27, 18);
		executeGame(false,26, 19);
		executeGame(false,25, 20);
		executeGame(false,24, 21);
		executeGame(false,23, 22);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,17, 31);
		executeGame(false,16, 18);
		executeGame(false,30, 19);
		executeGame(false,29, 20);
		executeGame(false,28, 21);
		executeGame(false,27, 22);
		executeGame(false,26, 23);
		executeGame(false,25, 24);
		executeGame(false,14, 0);
		executeGame(false,15, 13);
		executeGame(false,1, 12);
		executeGame(false,2, 11);
		executeGame(false,3, 10);
		executeGame(false,4, 9);
		executeGame(false,5, 8);
		executeGame(false,6, 7);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,15, 0);
		executeGame(false,14, 16);
		executeGame(false,13, 17);
		executeGame(false,12, 18);
		executeGame(false,11, 19);
		executeGame(false,10, 20);
		executeGame(false,9, 21);
		executeGame(false,8, 22);
		executeGame(false,7, 23);
		executeGame(false,6, 24);
		executeGame(false,5, 25);
		executeGame(false,4, 26);
		executeGame(false,3, 27);
		executeGame(false,2, 28);
		executeGame(false,1, 29);
		executeGame(false,31, 30);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 31);
		executeGame(false,1, 30);
		executeGame(false,2, 29);
		executeGame(false,3, 28);
		executeGame(false,4, 27);
		executeGame(false,5, 26);
		executeGame(false,6, 25);
		executeGame(false,7, 24);
		executeGame(false,8, 23);
		executeGame(false,9, 22);
		executeGame(false,10, 21);
		executeGame(false,11, 20);
		executeGame(false,12, 19);
		executeGame(false,13, 18);
		executeGame(false,14, 17);
		executeGame(false,15, 16);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 30);
		executeGame(false,29, 31);
		executeGame(false,28, 1);
		executeGame(false,27, 2);
		executeGame(false,26, 3);
		executeGame(false,25, 4);
		executeGame(false,24, 5);
		executeGame(false,23, 6);
		executeGame(false,22, 7);
		executeGame(false,21, 8);
		executeGame(false,20, 9);
		executeGame(false,19, 10);
		executeGame(false,18, 11);
		executeGame(false,17, 12);
		executeGame(false,16, 13);
		executeGame(false,15, 14);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 25);
		executeGame(false,26, 24);
		executeGame(false,27, 23);
		executeGame(false,28, 22);
		executeGame(false,29, 21);
		executeGame(false,30, 20);
		executeGame(false,31, 19);
		executeGame(false,1, 18);
		executeGame(false,2, 17);
		executeGame(false,3, 16);
		executeGame(false,4, 15);
		executeGame(false,5, 14);
		executeGame(false,6, 13);
		executeGame(false,7, 12);
		executeGame(false,8, 11);
		executeGame(false,9, 10);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 16);
		executeGame(false,15, 17);
		executeGame(false,14, 18);
		executeGame(false,13, 19);
		executeGame(false,12, 20);
		executeGame(false,11, 21);
		executeGame(false,10, 22);
		executeGame(false,9, 23);
		executeGame(false,8, 24);
		executeGame(false,7, 25);
		executeGame(false,6, 26);
		executeGame(false,5, 27);
		executeGame(false,4, 28);
		executeGame(false,3, 29);
		executeGame(false,2, 30);
		executeGame(false,1, 31);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 5);
		executeGame(false,6, 4);
		executeGame(false,7, 3);
		executeGame(false,8, 2);
		executeGame(false,9, 1);
		executeGame(false,10, 31);
		executeGame(false,11, 30);
		executeGame(false,12, 29);
		executeGame(false,13, 28);
		executeGame(false,14, 27);
		executeGame(false,15, 26);
		executeGame(false,16, 25);
		executeGame(false,17, 24);
		executeGame(false,18, 23);
		executeGame(false,19, 22);
		executeGame(false,20, 21);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 1);
		executeGame(false,2, 31);
		executeGame(false,3, 30);
		executeGame(false,4, 29);
		executeGame(false,5, 28);
		executeGame(false,6, 27);
		executeGame(false,7, 26);
		executeGame(false,8, 25);
		executeGame(false,9, 24);
		executeGame(false,10, 23);
		executeGame(false,11, 22);
		executeGame(false,12, 21);
		executeGame(false,13, 20);
		executeGame(false,14, 19);
		executeGame(false,15, 18);
		executeGame(false,16, 17);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,25, 0);
		executeGame(false,24, 26);
		executeGame(false,23, 27);
		executeGame(false,22, 28);
		executeGame(false,21, 29);
		executeGame(false,20, 30);
		executeGame(false,19, 31);
		executeGame(false,18, 1);
		executeGame(false,17, 2);
		executeGame(false,16, 3);
		executeGame(false,15, 4);
		executeGame(false,14, 5);
		executeGame(false,13, 6);
		executeGame(false,12, 7);
		executeGame(false,11, 8);
		executeGame(false,10, 9);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,21, 31);
		executeGame(false,20, 22);
		executeGame(false,19, 23);
		executeGame(false,18, 24);
		executeGame(false,17, 25);
		executeGame(false,16, 26);
		executeGame(false,30, 27);
		executeGame(false,29, 28);
		executeGame(false,10, 0);
		executeGame(false,11, 9);
		executeGame(false,12, 8);
		executeGame(false,13, 7);
		executeGame(false,14, 6);
		executeGame(false,15, 5);
		executeGame(false,1, 4);
		executeGame(false,2, 3);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 29);
		executeGame(false,30, 28);
		executeGame(false,31, 27);
		executeGame(false,1, 26);
		executeGame(false,2, 25);
		executeGame(false,3, 24);
		executeGame(false,4, 23);
		executeGame(false,5, 22);
		executeGame(false,6, 21);
		executeGame(false,7, 20);
		executeGame(false,8, 19);
		executeGame(false,9, 18);
		executeGame(false,10, 17);
		executeGame(false,11, 16);
		executeGame(false,12, 15);
		executeGame(false,13, 14);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,6, 0);
		executeGame(false,7, 5);
		executeGame(false,1, 4);
		executeGame(false,3, 2);
		executeGame(false,14, 8);
		executeGame(false,15, 13);
		executeGame(false,9, 12);
		executeGame(false,11, 10);
		executeGame(false,25, 31);
		executeGame(false,24, 26);
		executeGame(false,30, 27);
		executeGame(false,28, 29);
		executeGame(false,17, 23);
		executeGame(false,16, 18);
		executeGame(false,22, 19);
		executeGame(false,20, 21);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 21);
		executeGame(false,22, 20);
		executeGame(false,23, 19);
		executeGame(false,24, 18);
		executeGame(false,25, 17);
		executeGame(false,26, 16);
		executeGame(false,27, 15);
		executeGame(false,28, 14);
		executeGame(false,29, 13);
		executeGame(false,30, 12);
		executeGame(false,31, 11);
		executeGame(false,1, 10);
		executeGame(false,2, 9);
		executeGame(false,3, 8);
		executeGame(false,4, 7);
		executeGame(false,5, 6);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,4, 0);
		executeGame(false,5, 3);
		executeGame(false,6, 2);
		executeGame(false,7, 1);
		executeGame(false,8, 31);
		executeGame(false,9, 30);
		executeGame(false,10, 29);
		executeGame(false,11, 28);
		executeGame(false,12, 27);
		executeGame(false,13, 26);
		executeGame(false,14, 25);
		executeGame(false,15, 24);
		executeGame(false,16, 23);
		executeGame(false,17, 22);
		executeGame(false,18, 21);
		executeGame(false,19, 20);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,28, 0);
		executeGame(false,29, 27);
		executeGame(false,30, 26);
		executeGame(false,31, 25);
		executeGame(false,1, 24);
		executeGame(false,2, 23);
		executeGame(false,3, 22);
		executeGame(false,4, 21);
		executeGame(false,5, 20);
		executeGame(false,6, 19);
		executeGame(false,7, 18);
		executeGame(false,8, 17);
		executeGame(false,9, 16);
		executeGame(false,10, 15);
		executeGame(false,11, 14);
		executeGame(false,12, 13);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 28);
		executeGame(false,27, 29);
		executeGame(false,26, 30);
		executeGame(false,25, 31);
		executeGame(false,24, 1);
		executeGame(false,23, 2);
		executeGame(false,22, 3);
		executeGame(false,21, 4);
		executeGame(false,20, 5);
		executeGame(false,19, 6);
		executeGame(false,18, 7);
		executeGame(false,17, 8);
		executeGame(false,16, 9);
		executeGame(false,15, 10);
		executeGame(false,14, 11);
		executeGame(false,13, 12);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,14, 0);
		executeGame(false,15, 13);
		executeGame(false,16, 12);
		executeGame(false,17, 11);
		executeGame(false,18, 10);
		executeGame(false,19, 9);
		executeGame(false,20, 8);
		executeGame(false,21, 7);
		executeGame(false,22, 6);
		executeGame(false,23, 5);
		executeGame(false,24, 4);
		executeGame(false,25, 3);
		executeGame(false,26, 2);
		executeGame(false,27, 1);
		executeGame(false,28, 31);
		executeGame(false,29, 30);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,8, 0);
		executeGame(false,9, 7);
		executeGame(false,10, 6);
		executeGame(false,11, 5);
		executeGame(false,12, 4);
		executeGame(false,13, 3);
		executeGame(false,14, 2);
		executeGame(false,15, 1);
		executeGame(false,16, 31);
		executeGame(false,17, 30);
		executeGame(false,18, 29);
		executeGame(false,19, 28);
		executeGame(false,20, 27);
		executeGame(false,21, 26);
		executeGame(false,22, 25);
		executeGame(false,23, 24);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,19, 31);
		executeGame(false,18, 20);
		executeGame(false,17, 21);
		executeGame(false,16, 22);
		executeGame(false,30, 23);
		executeGame(false,29, 24);
		executeGame(false,28, 25);
		executeGame(false,27, 26);
		executeGame(false,12, 0);
		executeGame(false,13, 11);
		executeGame(false,14, 10);
		executeGame(false,15, 9);
		executeGame(false,1, 8);
		executeGame(false,2, 7);
		executeGame(false,3, 6);
		executeGame(false,4, 5);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 6);
		executeGame(false,5, 7);
		executeGame(false,4, 8);
		executeGame(false,3, 9);
		executeGame(false,2, 10);
		executeGame(false,1, 11);
		executeGame(false,31, 12);
		executeGame(false,30, 13);
		executeGame(false,29, 14);
		executeGame(false,28, 15);
		executeGame(false,27, 16);
		executeGame(false,26, 17);
		executeGame(false,25, 18);
		executeGame(false,24, 19);
		executeGame(false,23, 20);
		executeGame(false,22, 21);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,31, 26);
		executeGame(false,25, 27);
		executeGame(false,24, 28);
		executeGame(false,23, 29);
		executeGame(false,22, 30);
		executeGame(false,21, 16);
		executeGame(false,20, 17);
		executeGame(false,19, 18);
		executeGame(false,0, 5);
		executeGame(false,6, 4);
		executeGame(false,7, 3);
		executeGame(false,8, 2);
		executeGame(false,9, 1);
		executeGame(false,10, 15);
		executeGame(false,11, 14);
		executeGame(false,12, 13);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 24);
		executeGame(false,23, 25);
		executeGame(false,22, 26);
		executeGame(false,21, 27);
		executeGame(false,20, 28);
		executeGame(false,19, 29);
		executeGame(false,18, 30);
		executeGame(false,17, 31);
		executeGame(false,16, 1);
		executeGame(false,15, 2);
		executeGame(false,14, 3);
		executeGame(false,13, 4);
		executeGame(false,12, 5);
		executeGame(false,11, 6);
		executeGame(false,10, 7);
		executeGame(false,9, 8);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,27, 0);
		executeGame(false,26, 28);
		executeGame(false,25, 29);
		executeGame(false,24, 30);
		executeGame(false,23, 31);
		executeGame(false,22, 1);
		executeGame(false,21, 2);
		executeGame(false,20, 3);
		executeGame(false,19, 4);
		executeGame(false,18, 5);
		executeGame(false,17, 6);
		executeGame(false,16, 7);
		executeGame(false,15, 8);
		executeGame(false,14, 9);
		executeGame(false,13, 10);
		executeGame(false,12, 11);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,31, 30);
		executeGame(false,29, 16);
		executeGame(false,28, 17);
		executeGame(false,27, 18);
		executeGame(false,26, 19);
		executeGame(false,25, 20);
		executeGame(false,24, 21);
		executeGame(false,23, 22);
		executeGame(false,0, 1);
		executeGame(false,2, 15);
		executeGame(false,3, 14);
		executeGame(false,4, 13);
		executeGame(false,5, 12);
		executeGame(false,6, 11);
		executeGame(false,7, 10);
		executeGame(false,8, 9);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 18);
		executeGame(false,17, 19);
		executeGame(false,16, 20);
		executeGame(false,15, 21);
		executeGame(false,14, 22);
		executeGame(false,13, 23);
		executeGame(false,12, 24);
		executeGame(false,11, 25);
		executeGame(false,10, 26);
		executeGame(false,9, 27);
		executeGame(false,8, 28);
		executeGame(false,7, 29);
		executeGame(false,6, 30);
		executeGame(false,5, 31);
		executeGame(false,4, 1);
		executeGame(false,3, 2);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,26, 0);
		executeGame(false,27, 25);
		executeGame(false,28, 24);
		executeGame(false,29, 23);
		executeGame(false,30, 22);
		executeGame(false,31, 21);
		executeGame(false,1, 20);
		executeGame(false,2, 19);
		executeGame(false,3, 18);
		executeGame(false,4, 17);
		executeGame(false,5, 16);
		executeGame(false,6, 15);
		executeGame(false,7, 14);
		executeGame(false,8, 13);
		executeGame(false,9, 12);
		executeGame(false,10, 11);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 17);
		executeGame(false,18, 16);
		executeGame(false,19, 15);
		executeGame(false,20, 14);
		executeGame(false,21, 13);
		executeGame(false,22, 12);
		executeGame(false,23, 11);
		executeGame(false,24, 10);
		executeGame(false,25, 9);
		executeGame(false,26, 8);
		executeGame(false,27, 7);
		executeGame(false,28, 6);
		executeGame(false,29, 5);
		executeGame(false,30, 4);
		executeGame(false,31, 3);
		executeGame(false,1, 2);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,19, 0);
		executeGame(false,18, 20);
		executeGame(false,17, 21);
		executeGame(false,16, 22);
		executeGame(false,15, 23);
		executeGame(false,14, 24);
		executeGame(false,13, 25);
		executeGame(false,12, 26);
		executeGame(false,11, 27);
		executeGame(false,10, 28);
		executeGame(false,9, 29);
		executeGame(false,8, 30);
		executeGame(false,7, 31);
		executeGame(false,6, 1);
		executeGame(false,5, 2);
		executeGame(false,4, 3);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,23, 0);
		executeGame(false,22, 24);
		executeGame(false,21, 25);
		executeGame(false,20, 26);
		executeGame(false,19, 27);
		executeGame(false,18, 28);
		executeGame(false,17, 29);
		executeGame(false,16, 30);
		executeGame(false,15, 31);
		executeGame(false,14, 1);
		executeGame(false,13, 2);
		executeGame(false,12, 3);
		executeGame(false,11, 4);
		executeGame(false,10, 5);
		executeGame(false,9, 6);
		executeGame(false,8, 7);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,6, 0);
		executeGame(false,7, 5);
		executeGame(false,8, 4);
		executeGame(false,9, 3);
		executeGame(false,10, 2);
		executeGame(false,11, 1);
		executeGame(false,12, 31);
		executeGame(false,13, 30);
		executeGame(false,14, 29);
		executeGame(false,15, 28);
		executeGame(false,16, 27);
		executeGame(false,17, 26);
		executeGame(false,18, 25);
		executeGame(false,19, 24);
		executeGame(false,20, 23);
		executeGame(false,21, 22);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 8);
		executeGame(false,7, 9);
		executeGame(false,6, 10);
		executeGame(false,5, 11);
		executeGame(false,4, 12);
		executeGame(false,3, 13);
		executeGame(false,2, 14);
		executeGame(false,1, 15);
		executeGame(false,31, 16);
		executeGame(false,30, 17);
		executeGame(false,29, 18);
		executeGame(false,28, 19);
		executeGame(false,27, 20);
		executeGame(false,26, 21);
		executeGame(false,25, 22);
		executeGame(false,24, 23);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,24, 0);
		executeGame(false,25, 23);
		executeGame(false,26, 22);
		executeGame(false,27, 21);
		executeGame(false,28, 20);
		executeGame(false,29, 19);
		executeGame(false,30, 18);
		executeGame(false,31, 17);
		executeGame(false,1, 16);
		executeGame(false,2, 15);
		executeGame(false,3, 14);
		executeGame(false,4, 13);
		executeGame(false,5, 12);
		executeGame(false,6, 11);
		executeGame(false,7, 10);
		executeGame(false,8, 9);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,18, 0);
		executeGame(false,19, 17);
		executeGame(false,20, 16);
		executeGame(false,21, 15);
		executeGame(false,22, 14);
		executeGame(false,23, 13);
		executeGame(false,24, 12);
		executeGame(false,25, 11);
		executeGame(false,26, 10);
		executeGame(false,27, 9);
		executeGame(false,28, 8);
		executeGame(false,29, 7);
		executeGame(false,30, 6);
		executeGame(false,31, 5);
		executeGame(false,1, 4);
		executeGame(false,2, 3);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,30, 0);
		executeGame(false,31, 29);
		executeGame(false,1, 28);
		executeGame(false,2, 27);
		executeGame(false,3, 26);
		executeGame(false,4, 25);
		executeGame(false,5, 24);
		executeGame(false,6, 23);
		executeGame(false,7, 22);
		executeGame(false,8, 21);
		executeGame(false,9, 20);
		executeGame(false,10, 19);
		executeGame(false,11, 18);
		executeGame(false,12, 17);
		executeGame(false,13, 16);
		executeGame(false,14, 15);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 22);
		executeGame(false,21, 23);
		executeGame(false,20, 24);
		executeGame(false,19, 25);
		executeGame(false,18, 26);
		executeGame(false,17, 27);
		executeGame(false,16, 28);
		executeGame(false,15, 29);
		executeGame(false,14, 30);
		executeGame(false,13, 31);
		executeGame(false,12, 1);
		executeGame(false,11, 2);
		executeGame(false,10, 3);
		executeGame(false,9, 4);
		executeGame(false,8, 5);
		executeGame(false,7, 6);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,12, 0);
		executeGame(false,13, 11);
		executeGame(false,14, 10);
		executeGame(false,15, 9);
		executeGame(false,16, 8);
		executeGame(false,17, 7);
		executeGame(false,18, 6);
		executeGame(false,19, 5);
		executeGame(false,20, 4);
		executeGame(false,21, 3);
		executeGame(false,22, 2);
		executeGame(false,23, 1);
		executeGame(false,24, 31);
		executeGame(false,25, 30);
		executeGame(false,26, 29);
		executeGame(false,27, 28);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,23, 31);
		executeGame(false,22, 24);
		executeGame(false,21, 25);
		executeGame(false,20, 26);
		executeGame(false,19, 27);
		executeGame(false,18, 28);
		executeGame(false,17, 29);
		executeGame(false,16, 30);
		executeGame(false,8, 0);
		executeGame(false,9, 7);
		executeGame(false,10, 6);
		executeGame(false,11, 5);
		executeGame(false,12, 4);
		executeGame(false,13, 3);
		executeGame(false,14, 2);
		executeGame(false,15, 1);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,3, 0);
		executeGame(false,2, 4);
		executeGame(false,1, 5);
		executeGame(false,31, 6);
		executeGame(false,30, 7);
		executeGame(false,29, 8);
		executeGame(false,28, 9);
		executeGame(false,27, 10);
		executeGame(false,26, 11);
		executeGame(false,25, 12);
		executeGame(false,24, 13);
		executeGame(false,23, 14);
		executeGame(false,22, 15);
		executeGame(false,21, 16);
		executeGame(false,20, 17);
		executeGame(false,19, 18);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,11, 0);
		executeGame(false,10, 12);
		executeGame(false,9, 13);
		executeGame(false,8, 14);
		executeGame(false,7, 15);
		executeGame(false,6, 16);
		executeGame(false,5, 17);
		executeGame(false,4, 18);
		executeGame(false,3, 19);
		executeGame(false,2, 20);
		executeGame(false,1, 21);
		executeGame(false,31, 22);
		executeGame(false,30, 23);
		executeGame(false,29, 24);
		executeGame(false,28, 25);
		executeGame(false,27, 26);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,27, 31);
		executeGame(false,26, 28);
		executeGame(false,25, 29);
		executeGame(false,24, 30);
		executeGame(false,23, 16);
		executeGame(false,22, 17);
		executeGame(false,21, 18);
		executeGame(false,20, 19);
		executeGame(false,4, 0);
		executeGame(false,5, 3);
		executeGame(false,6, 2);
		executeGame(false,7, 1);
		executeGame(false,8, 15);
		executeGame(false,9, 14);
		executeGame(false,10, 13);
		executeGame(false,11, 12);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,31, 20);
		executeGame(false,19, 21);
		executeGame(false,18, 22);
		executeGame(false,17, 23);
		executeGame(false,16, 24);
		executeGame(false,30, 25);
		executeGame(false,29, 26);
		executeGame(false,28, 27);
		executeGame(false,0, 11);
		executeGame(false,12, 10);
		executeGame(false,13, 9);
		executeGame(false,14, 8);
		executeGame(false,15, 7);
		executeGame(false,1, 6);
		executeGame(false,2, 5);
		executeGame(false,3, 4);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 19);
		executeGame(false,20, 18);
		executeGame(false,21, 17);
		executeGame(false,22, 16);
		executeGame(false,23, 15);
		executeGame(false,24, 14);
		executeGame(false,25, 13);
		executeGame(false,26, 12);
		executeGame(false,27, 11);
		executeGame(false,28, 10);
		executeGame(false,29, 9);
		executeGame(false,30, 8);
		executeGame(false,31, 7);
		executeGame(false,1, 6);
		executeGame(false,2, 5);
		executeGame(false,3, 4);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 7);
		executeGame(false,1, 6);
		executeGame(false,2, 5);
		executeGame(false,3, 4);
		executeGame(false,8, 15);
		executeGame(false,9, 14);
		executeGame(false,10, 13);
		executeGame(false,11, 12);
		executeGame(false,31, 24);
		executeGame(false,30, 25);
		executeGame(false,29, 26);
		executeGame(false,28, 27);
		executeGame(false,23, 16);
		executeGame(false,22, 17);
		executeGame(false,21, 18);
		executeGame(false,20, 19);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 12);
		executeGame(false,11, 13);
		executeGame(false,10, 14);
		executeGame(false,9, 15);
		executeGame(false,8, 16);
		executeGame(false,7, 17);
		executeGame(false,6, 18);
		executeGame(false,5, 19);
		executeGame(false,4, 20);
		executeGame(false,3, 21);
		executeGame(false,2, 22);
		executeGame(false,1, 23);
		executeGame(false,31, 24);
		executeGame(false,30, 25);
		executeGame(false,29, 26);
		executeGame(false,28, 27);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,31, 28);
		executeGame(false,27, 29);
		executeGame(false,26, 30);
		executeGame(false,25, 16);
		executeGame(false,24, 17);
		executeGame(false,23, 18);
		executeGame(false,22, 19);
		executeGame(false,21, 20);
		executeGame(false,0, 3);
		executeGame(false,4, 2);
		executeGame(false,5, 1);
		executeGame(false,6, 15);
		executeGame(false,7, 14);
		executeGame(false,8, 13);
		executeGame(false,9, 12);
		executeGame(false,10, 11);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 4);
		executeGame(false,3, 5);
		executeGame(false,2, 6);
		executeGame(false,1, 7);
		executeGame(false,31, 8);
		executeGame(false,30, 9);
		executeGame(false,29, 10);
		executeGame(false,28, 11);
		executeGame(false,27, 12);
		executeGame(false,26, 13);
		executeGame(false,25, 14);
		executeGame(false,24, 15);
		executeGame(false,23, 16);
		executeGame(false,22, 17);
		executeGame(false,21, 18);
		executeGame(false,20, 19);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,25, 31);
		executeGame(false,24, 26);
		executeGame(false,23, 27);
		executeGame(false,22, 28);
		executeGame(false,21, 29);
		executeGame(false,20, 30);
		executeGame(false,19, 16);
		executeGame(false,18, 17);
		executeGame(false,6, 0);
		executeGame(false,7, 5);
		executeGame(false,8, 4);
		executeGame(false,9, 3);
		executeGame(false,10, 2);
		executeGame(false,11, 1);
		executeGame(false,12, 15);
		executeGame(false,13, 14);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,10, 0);
		executeGame(false,11, 9);
		executeGame(false,12, 8);
		executeGame(false,13, 7);
		executeGame(false,14, 6);
		executeGame(false,15, 5);
		executeGame(false,16, 4);
		executeGame(false,17, 3);
		executeGame(false,18, 2);
		executeGame(false,19, 1);
		executeGame(false,20, 31);
		executeGame(false,21, 30);
		executeGame(false,22, 29);
		executeGame(false,23, 28);
		executeGame(false,24, 27);
		executeGame(false,25, 26);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,29, 31);
		executeGame(false,28, 30);
		executeGame(false,27, 16);
		executeGame(false,26, 17);
		executeGame(false,25, 18);
		executeGame(false,24, 19);
		executeGame(false,23, 20);
		executeGame(false,22, 21);
		executeGame(false,2, 0);
		executeGame(false,3, 1);
		executeGame(false,4, 15);
		executeGame(false,5, 14);
		executeGame(false,6, 13);
		executeGame(false,7, 12);
		executeGame(false,8, 11);
		executeGame(false,9, 10);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,1, 0);
		executeGame(false,31, 2);
		executeGame(false,30, 3);
		executeGame(false,29, 4);
		executeGame(false,28, 5);
		executeGame(false,27, 6);
		executeGame(false,26, 7);
		executeGame(false,25, 8);
		executeGame(false,24, 9);
		executeGame(false,23, 10);
		executeGame(false,22, 11);
		executeGame(false,21, 12);
		executeGame(false,20, 13);
		executeGame(false,19, 14);
		executeGame(false,18, 15);
		executeGame(false,17, 16);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 23);
		executeGame(false,24, 22);
		executeGame(false,25, 21);
		executeGame(false,26, 20);
		executeGame(false,27, 19);
		executeGame(false,28, 18);
		executeGame(false,29, 17);
		executeGame(false,30, 16);
		executeGame(false,31, 15);
		executeGame(false,1, 14);
		executeGame(false,2, 13);
		executeGame(false,3, 12);
		executeGame(false,4, 11);
		executeGame(false,5, 10);
		executeGame(false,6, 9);
		executeGame(false,7, 8);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 20);
		executeGame(false,19, 21);
		executeGame(false,18, 22);
		executeGame(false,17, 23);
		executeGame(false,16, 24);
		executeGame(false,15, 25);
		executeGame(false,14, 26);
		executeGame(false,13, 27);
		executeGame(false,12, 28);
		executeGame(false,11, 29);
		executeGame(false,10, 30);
		executeGame(false,9, 31);
		executeGame(false,8, 1);
		executeGame(false,7, 2);
		executeGame(false,6, 3);
		executeGame(false,5, 4);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,2, 0);
		executeGame(false,3, 1);
		executeGame(false,4, 7);
		executeGame(false,5, 6);
		executeGame(false,10, 8);
		executeGame(false,11, 9);
		executeGame(false,12, 15);
		executeGame(false,13, 14);
		executeGame(false,29, 31);
		executeGame(false,28, 30);
		executeGame(false,27, 24);
		executeGame(false,26, 25);
		executeGame(false,21, 23);
		executeGame(false,20, 22);
		executeGame(false,19, 16);
		executeGame(false,18, 17);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 9);
		executeGame(false,10, 8);
		executeGame(false,11, 7);
		executeGame(false,12, 6);
		executeGame(false,13, 5);
		executeGame(false,14, 4);
		executeGame(false,15, 3);
		executeGame(false,16, 2);
		executeGame(false,17, 1);
		executeGame(false,18, 31);
		executeGame(false,19, 30);
		executeGame(false,20, 29);
		executeGame(false,21, 28);
		executeGame(false,22, 27);
		executeGame(false,23, 26);
		executeGame(false,24, 25);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,17, 0);
		executeGame(false,16, 18);
		executeGame(false,15, 19);
		executeGame(false,14, 20);
		executeGame(false,13, 21);
		executeGame(false,12, 22);
		executeGame(false,11, 23);
		executeGame(false,10, 24);
		executeGame(false,9, 25);
		executeGame(false,8, 26);
		executeGame(false,7, 27);
		executeGame(false,6, 28);
		executeGame(false,5, 29);
		executeGame(false,4, 30);
		executeGame(false,3, 31);
		executeGame(false,2, 1);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,1, 0);
		executeGame(false,2, 7);
		executeGame(false,3, 6);
		executeGame(false,5, 4);
		executeGame(false,9, 8);
		executeGame(false,10, 15);
		executeGame(false,11, 14);
		executeGame(false,13, 12);
		executeGame(false,30, 31);
		executeGame(false,29, 24);
		executeGame(false,28, 25);
		executeGame(false,26, 27);
		executeGame(false,22, 23);
		executeGame(false,21, 16);
		executeGame(false,20, 17);
		executeGame(false,18, 19);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 3);
		executeGame(false,4, 2);
		executeGame(false,5, 1);
		executeGame(false,6, 31);
		executeGame(false,7, 30);
		executeGame(false,8, 29);
		executeGame(true,9, 28);
		executeGame(false,10, 27);
		executeGame(false,11, 26);
		executeGame(false,12, 25);
		executeGame(false,13, 24);
		executeGame(false,14, 23);
		executeGame(false,15, 22);
		executeGame(false,16, 21);
		executeGame(false,17, 20);
		executeGame(false,18, 19);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,29, 0);
		executeGame(false,28, 30);
		executeGame(false,27, 31);
		executeGame(false,26, 1);
		executeGame(false,25, 2);
		executeGame(false,24, 3);
		executeGame(false,23, 4);
		executeGame(false,22, 5);
		executeGame(false,21, 6);
		executeGame(false,20, 7);
		executeGame(false,19, 8);
		executeGame(false,18, 9);
		executeGame(false,17, 10);
		executeGame(false,16, 11);
		executeGame(false,15, 12);
		executeGame(false,14, 13);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,9, 0);
		executeGame(false,8, 10);
		executeGame(false,7, 11);
		executeGame(false,6, 12);
		executeGame(false,5, 13);
		executeGame(false,4, 14);
		executeGame(false,3, 15);
		executeGame(false,2, 16);
		executeGame(false,1, 17);
		executeGame(false,31, 18);
		executeGame(false,30, 19);
		executeGame(false,29, 20);
		executeGame(false,28, 21);
		executeGame(false,27, 22);
		executeGame(false,26, 23);
		executeGame(false,25, 24);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 5);
		executeGame(false,6, 4);
		executeGame(false,7, 3);
		executeGame(false,1, 2);
		executeGame(false,8, 13);
		executeGame(false,14, 12);
		executeGame(false,15, 11);
		executeGame(false,9, 10);
		executeGame(false,31, 26);
		executeGame(false,25, 27);
		executeGame(false,24, 28);
		executeGame(false,30, 29);
		executeGame(false,23, 18);
		executeGame(false,17, 19);
		executeGame(false,16, 20);
		executeGame(false,22, 21);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,31, 16);
		executeGame(false,30, 17);
		executeGame(false,29, 18);
		executeGame(false,28, 19);
		executeGame(false,27, 20);
		executeGame(false,26, 21);
		executeGame(false,25, 22);
		executeGame(false,24, 23);
		executeGame(false,0, 15);
		executeGame(false,1, 14);
		executeGame(false,2, 13);
		executeGame(false,3, 12);
		executeGame(false,4, 11);
		executeGame(false,5, 10);
		executeGame(false,6, 9);
		executeGame(false,7, 8);
		gameWriter.writeLines(); gameResults.println("Game " +  startingGame + ",Home,Score,Away,Score");
		writer.println(); gameWriter = new gameWriter(startingGame);
		startingGame++;
		executeGame(false,0, 13);
		executeGame(false,14, 12);
		executeGame(false,15, 11);
		executeGame(false,16, 10);
		executeGame(false,17, 9);
		executeGame(false,18, 8);
		executeGame(false,19, 7);
		executeGame(false,20, 6);
		executeGame(false,21, 5);
		executeGame(false,22, 4);
		executeGame(false,23, 3);
		executeGame(false,24, 2);
		executeGame(false,25, 1);
		executeGame(false,26, 31);
		executeGame(false,27, 30);
		executeGame(false,28, 29);
		gameWriter.writeLines(); 





		printInjuries();
		/*
	for(int i = 32; i < 41; i++)
	{
	    for(int j = i; j < 41; j++)
	    {
		if(i != j)
		{
		    for(int k = 0; k < 1000; k++)
		    {
			executeGame(false, i, j);
		    }
		}
	    }
	}

		 */

	}

	private static void printInjuries()
	{
		PrintWriter injuryWriter = null;
		try
		{
			injuryWriter = new PrintWriter("Injuries.txt", "UTF-8");
		}
		catch(Exception E)
		{

		}
		for(int i = 0; i < create.size();i++)
		{
			int numInjuries = 0;
			for(int j = 0; j < create.getTeam(i).getAllPlayer().size(); j++)
			{
				numInjuries += create.getTeam(i).getPlayer(j).getInjuryTotal();
			}
			injuryWriter.println(create.getTeam(i).getTeamName() + " injuries: ("+ numInjuries + " total)");
			for(int j = 0; j < create.getTeam(i).getAllPlayer().size(); j++)
			{
				if(create.getTeam(i).getPlayer(j).isInjured())
				{
					injuryWriter.println("	" + create.getTeam(i).getPlayer(j).getName() + " is injured for " + create.getTeam(i).getPlayer(j).getInjuryLength() +" more games.");
				}
			}
			injuryWriter.println();
		}
		injuryWriter.close();
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
		standings.println("" + team.getTeamName() + "," + team.getWins() + "," + team.getLosses() + "," + team.getPoints() + "," + team.getPointsAgainst() + "," + team.getDivisionRank() + "," + team.getConferenceRank() + "," + team.getLeagueRank()+ "," + team.getDivisionWins()+ "," + team.getDivisionLosses()+ "," + team.getConferenceWins()+ "," + team.getConferenceLosses());

	}

	private static boolean executeGame(boolean b, int i, int j)
	{
		boolean retVal = false;
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
		if (i == 26)
		{
			create.getTeam(i).setModifier(new gettingHot());
		}

		else if(j == 26)
		{
			create.getTeam(j).setModifier(new gettingHot());
		}/*
	else if(i == 22)
	{
	    create.getTeam(j).setModifier(new gettingCold());
	}
	else if(j == 22)
	{
	    create.getTeam(i).setModifier(new gettingCold());
	}

	else if(i == 11)
	{
	    create.getTeam(j).setModifier(new gettingCold());
	}
	else if(j == 11)
	{
	    create.getTeam(i).setModifier(new gettingCold());
	}
		 */
		create.getTeam(i).addModifier(new HomeTeam());
		game newGame = new game(gameWriter, create.getTeam(i), create.getTeam(j));

		try
		{

			retVal = newGame.getWinner();
			//writer.println(votingList);
			if(newGame.getWinner())
			{
				writer.println(create.getTeam(i).getTeamName() + " wins! The score was " + newGame.getAwayTeamScore() + " - " + newGame.getHomeTeamScore());

				create.getTeam(i).addWin(1);
				create.getTeam(j).addLoss(1);
				if((i < 16 && j < 16) || (i > 15 && j > 15))
				{
					create.getTeam(i).addConferenceWin(1);
					create.getTeam(j).addConferenceLoss(1);
				}
				if(create.getTeam(i).getDivision() == create.getTeam(j).getDivision())
				{
					create.getTeam(i).addDivisionWin(1);
					create.getTeam(j).addDivisionLoss(1);
				}
			}
			else 
			{
				writer.println(create.getTeam(j).getTeamName() + " wins! The score was " + newGame.getHomeTeamScore() + " - " + newGame.getAwayTeamScore());
				create.getTeam(j).addWin(1);
				create.getTeam(i).addLoss(1);
				if((i < 16 && j < 16) || (i > 15 && j > 15))
				{
					create.getTeam(j).addConferenceWin(1);
					create.getTeam(i).addConferenceLoss(1);
				}
				if(create.getTeam(i).getDivision() == create.getTeam(j).getDivision())
				{
					create.getTeam(j).addDivisionWin(1);
					create.getTeam(i).addDivisionLoss(1);
				}

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
		return retVal;
	}

}
