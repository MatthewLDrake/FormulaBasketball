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
public class formulaBasketball
{
    private static PrintWriter writer, gameResults, stats, standings;
    private static createTeams create;
    private static Scanner kb;
    private static int startingGame;
    private static ArrayList<team> DivisionA, DivisionB, DivisionC, DivisionD, ConferenceA, ConferenceB, League;
    public static void main(String[] args)
    {
	
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
	saveData();
	kb.close();
	writer.close();
	stats.close();
	gameResults.close();
	standings.close();
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
	calculateStandings();
	for(int i = 0; i < create.size(); i++)
	{
	    create.getTeam(i).setTeamNum(i);
	}
	int[] conferenceAWinCounter = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0};
	int[] conferenceBWinCounter = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0};
	int gamesPlayed = 0;
	while(gamesPlayed < 7)
	{
	    startingGame = gamesPlayed + 2;
	    if(conferenceAWinCounter[0] != 4 && conferenceAWinCounter[7] != 4)
	    {
		boolean flag = executeGame(false, ConferenceA.get(0).getTeamNum(),ConferenceA.get(7).getTeamNum());
		if(flag)conferenceAWinCounter[0]++;
		else conferenceAWinCounter[7]++;
	    }
	    if(conferenceAWinCounter[1] != 4 && conferenceAWinCounter[6] != 4)
	    {
		boolean flag = executeGame(false, ConferenceA.get(1).getTeamNum(),ConferenceA.get(6).getTeamNum());
		if(flag)conferenceAWinCounter[1]++;
		else conferenceAWinCounter[6]++;
	    }
	    if(conferenceAWinCounter[2] != 4 && conferenceAWinCounter[5] != 4)
	    {
		boolean flag = executeGame(false, ConferenceA.get(2).getTeamNum(),ConferenceA.get(5).getTeamNum());
		if(flag)conferenceAWinCounter[2]++;
		else conferenceAWinCounter[5]++;
	    }
	    if(conferenceAWinCounter[3] != 4 && conferenceAWinCounter[4] != 4)
	    {
		boolean flag = executeGame(false, ConferenceA.get(3).getTeamNum(),ConferenceA.get(4).getTeamNum());
		if(flag)conferenceAWinCounter[3]++;
		else conferenceAWinCounter[4]++;
	    }
	    if(conferenceBWinCounter[0] != 4 && conferenceBWinCounter[7] != 4)
	    {
		boolean flag = executeGame(false, ConferenceB.get(0).getTeamNum(),ConferenceB.get(7).getTeamNum());
		if(flag)conferenceBWinCounter[0]++;
		else conferenceBWinCounter[7]++;
	    }
	    if(conferenceBWinCounter[1] != 4 && conferenceBWinCounter[6] != 4)
	    {
		boolean flag = executeGame(false, ConferenceB.get(1).getTeamNum(),ConferenceB.get(6).getTeamNum());
		if(flag)conferenceBWinCounter[1]++;
		else conferenceBWinCounter[6]++;
	    }
	    if(conferenceBWinCounter[2] != 4 && conferenceBWinCounter[5] != 4)
	    {
		boolean flag = executeGame(false, ConferenceB.get(2).getTeamNum(),ConferenceB.get(5).getTeamNum());
		if(flag)conferenceBWinCounter[2]++;
		else conferenceBWinCounter[5]++;
	    }
	    if(conferenceBWinCounter[3] != 4 && conferenceBWinCounter[4] != 4)
	    {
		boolean flag = executeGame(false, ConferenceB.get(3).getTeamNum(),ConferenceB.get(4).getTeamNum());
		if(flag)conferenceBWinCounter[3]++;
		else conferenceBWinCounter[4]++;
	    }
	    if(conferenceAWinCounter[8] != 4 && conferenceAWinCounter[15] != 4)
	    {
		boolean flag = executeGame(false, ConferenceA.get(8).getTeamNum(),ConferenceA.get(15).getTeamNum());
		if(flag)conferenceAWinCounter[8]++;
		else conferenceAWinCounter[15]++;
	    }
	    if(conferenceAWinCounter[9] != 4 && conferenceAWinCounter[14] != 4)
	    {
		boolean flag = executeGame(false, ConferenceA.get(9).getTeamNum(),ConferenceA.get(14).getTeamNum());
		if(flag)conferenceAWinCounter[9]++;
		else conferenceAWinCounter[14]++;
	    }
	    if(conferenceAWinCounter[10] != 4 && conferenceAWinCounter[13] != 4)
	    {
		boolean flag = executeGame(false, ConferenceA.get(10).getTeamNum(),ConferenceA.get(13).getTeamNum());
		if(flag)conferenceAWinCounter[10]++;
		else conferenceAWinCounter[13]++;
	    }
	    if(conferenceAWinCounter[11] != 4 && conferenceAWinCounter[12] != 4)
	    {
		boolean flag = executeGame(false, ConferenceA.get(11).getTeamNum(),ConferenceA.get(12).getTeamNum());
		if(flag)conferenceAWinCounter[11]++;
		else conferenceAWinCounter[12]++;
	    }
	    if(conferenceBWinCounter[8] != 4 && conferenceBWinCounter[15] != 4)
	    {
		boolean flag = executeGame(false, ConferenceB.get(8).getTeamNum(),ConferenceB.get(15).getTeamNum());
		if(flag)conferenceBWinCounter[8]++;
		else conferenceBWinCounter[15]++;
	    }
	    if(conferenceBWinCounter[9] != 4 && conferenceBWinCounter[14] != 4)
	    {
		boolean flag = executeGame(false, ConferenceB.get(9).getTeamNum(),ConferenceB.get(14).getTeamNum());
		if(flag)conferenceBWinCounter[9]++;
		else conferenceBWinCounter[14]++;
	    }
	    if(conferenceBWinCounter[10] != 4 && conferenceBWinCounter[13] != 4)
	    {
		boolean flag = executeGame(false, ConferenceB.get(10).getTeamNum(),ConferenceB.get(13).getTeamNum());
		if(flag)conferenceBWinCounter[10]++;
		else conferenceBWinCounter[13]++;
	    }
	    if(conferenceBWinCounter[11] != 4 && conferenceBWinCounter[12] != 4)
	    {
		boolean flag = executeGame(false, ConferenceB.get(11).getTeamNum(),ConferenceB.get(12).getTeamNum());
		if(flag)conferenceBWinCounter[11]++;
		else conferenceBWinCounter[12]++;
	    }
	    writer.println();
	    gameResults.println();
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
	    if(conferenceAWinCounter[0] != 4 && conferenceAWinCounter[7] != 4)
	    {
		boolean flag = executeGame(false, winnerOfMatchOne,winnerOfMatchFour);
		if(flag)conferenceAWinCounter[0]++;
		else conferenceAWinCounter[7]++;
	    }
	    if(conferenceAWinCounter[1] != 4 && conferenceAWinCounter[6] != 4)
	    {
		boolean flag = executeGame(false, winnerOfMatchTwo,winnerOfMatchThree);
		if(flag)conferenceAWinCounter[1]++;
		else conferenceAWinCounter[6]++;
	    }
	    if(conferenceAWinCounter[2] != 4 && conferenceAWinCounter[5] != 4)
	    {
		boolean flag = executeGame(false, loserOfMatchOne,loserOfMatchFour);
		if(flag)conferenceAWinCounter[2]++;
		else conferenceAWinCounter[5]++;
	    }
	    if(conferenceAWinCounter[3] != 4 && conferenceAWinCounter[4] != 4)
	    {
		boolean flag = executeGame(false, loserOfMatchTwo,loserOfMatchThree);
		if(flag)conferenceAWinCounter[3]++;
		else conferenceAWinCounter[4]++;
	    }
	    if(conferenceBWinCounter[0] != 4 && conferenceBWinCounter[7] != 4)
	    {
		boolean flag = executeGame(false, winnerOfMatchFive,winnerOfMatchEight);
		if(flag)conferenceBWinCounter[0]++;
		else conferenceBWinCounter[7]++;
	    }
	    if(conferenceBWinCounter[1] != 4 && conferenceBWinCounter[6] != 4)
	    {
		boolean flag = executeGame(false, winnerOfMatchSix,winnerOfMatchSeven);
		if(flag)conferenceBWinCounter[1]++;
		else conferenceBWinCounter[6]++;
	    }
	    if(conferenceBWinCounter[2] != 4 && conferenceBWinCounter[5] != 4)
	    {
		boolean flag = executeGame(false, loserOfMatchFive,loserOfMatchEight);
		if(flag)conferenceBWinCounter[2]++;
		else conferenceBWinCounter[5]++;
	    }
	    if(conferenceBWinCounter[3] != 4 && conferenceBWinCounter[4] != 4)
	    {
		boolean flag = executeGame(false, loserOfMatchSix,loserOfMatchSeven);
		if(flag)conferenceBWinCounter[3]++;
		else conferenceBWinCounter[4]++;
	    }
	    if(conferenceAWinCounter[8] != 4 && conferenceAWinCounter[15] != 4)
	    {
		boolean flag = executeGame(false, winnerOfMatchNine,winnerOfMatchTwelve);
		if(flag)conferenceAWinCounter[8]++;
		else conferenceAWinCounter[15]++;
	    }
	    if(conferenceAWinCounter[9] != 4 && conferenceAWinCounter[14] != 4)
	    {
		boolean flag = executeGame(false, winnerOfMatchTen,winnerOfMatchEleven);
		if(flag)conferenceAWinCounter[9]++;
		else conferenceAWinCounter[14]++;
	    }
	    if(conferenceAWinCounter[10] != 4 && conferenceAWinCounter[13] != 4)
	    {
		boolean flag = executeGame(false, loserOfMatchNine,loserOfMatchTwelve);
		if(flag)conferenceAWinCounter[10]++;
		else conferenceAWinCounter[13]++;
	    }
	    if(conferenceAWinCounter[11] != 4 && conferenceAWinCounter[12] != 4)
	    {
		boolean flag = executeGame(false, loserOfMatchTen,loserOfMatchEleven);
		if(flag)conferenceAWinCounter[11]++;
		else conferenceAWinCounter[12]++;
	    }
	    if(conferenceBWinCounter[8] != 4 && conferenceBWinCounter[15] != 4)
	    {
		boolean flag = executeGame(false, winnerOfMatchThirteen,winnerOfMatchSixteen);
		if(flag)conferenceBWinCounter[8]++;
		else conferenceBWinCounter[15]++;
	    }
	    if(conferenceBWinCounter[9] != 4 && conferenceBWinCounter[14] != 4)
	    {
		boolean flag = executeGame(false, winnerOfMatchForteen,winnerOfMatchFifteen);
		if(flag)conferenceBWinCounter[9]++;
		else conferenceBWinCounter[14]++;
	    }
	    if(conferenceBWinCounter[10] != 4 && conferenceBWinCounter[13] != 4)
	    {
		boolean flag = executeGame(false, loserOfMatchThirteen,loserOfMatchSixteen);
		if(flag)conferenceBWinCounter[10]++;
		else conferenceBWinCounter[13]++;
	    }
	    if(conferenceBWinCounter[11] != 4 && conferenceBWinCounter[12] != 4)
	    {
		boolean flag = executeGame(false, loserOfMatchForteen,loserOfMatchFifteen);
		if(flag)conferenceBWinCounter[11]++;
		else conferenceBWinCounter[12]++;
	    }
	    writer.println();
	    gamesPlayed++;
	    gameResults.println();


	}
	int winnerOfThirdRoundMatchOne = 0, loserOfThirdRoundMatchOne = 0;
	if(conferenceAWinCounter[0] == 4)
	{
	    winnerOfThirdRoundMatchOne = winnerOfMatchOne;
	    loserOfThirdRoundMatchOne = winnerOfMatchFour;

	}
	else
	{
	    loserOfThirdRoundMatchOne = winnerOfMatchOne;
	    winnerOfThirdRoundMatchOne = winnerOfMatchFour;
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
	}
	else
	{
	    loserOfThirdRoundMatchFive = winnerOfMatchFive;
	    winnerOfThirdRoundMatchFive = winnerOfMatchEight;
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
	    if(conferenceAWinCounter[0] != 4 && conferenceAWinCounter[7] != 4)
	    {
		boolean flag = executeGame(false, winnerOfThirdRoundMatchOne,winnerOfThirdRoundMatchTwo);
		if(flag)conferenceAWinCounter[0]++;
		else conferenceAWinCounter[7]++;
	    }
	    if(conferenceAWinCounter[1] != 4 && conferenceAWinCounter[6] != 4)
	    {
		boolean flag = executeGame(false, winnerOfThirdRoundMatchFour,winnerOfThirdRoundMatchThree);
		if(flag)conferenceAWinCounter[1]++;
		else conferenceAWinCounter[6]++;
	    }
	    if(conferenceAWinCounter[2] != 4 && conferenceAWinCounter[5] != 4)
	    {
		boolean flag = executeGame(false, loserOfThirdRoundMatchOne,loserOfThirdRoundMatchTwo);
		if(flag)conferenceAWinCounter[2]++;
		else conferenceAWinCounter[5]++;
	    }
	    if(conferenceAWinCounter[3] != 4 && conferenceAWinCounter[4] != 4)
	    {
		boolean flag = executeGame(false, loserOfThirdRoundMatchFour,loserOfThirdRoundMatchThree);
		if(flag)conferenceAWinCounter[3]++;
		else conferenceAWinCounter[4]++;
	    }
	    if(conferenceBWinCounter[0] != 4 && conferenceBWinCounter[7] != 4)
	    {
		boolean flag = executeGame(false, winnerOfThirdRoundMatchFive,winnerOfThirdRoundMatchSix);
		if(flag)conferenceBWinCounter[0]++;
		else conferenceBWinCounter[7]++;
	    }
	    if(conferenceBWinCounter[1] != 4 && conferenceBWinCounter[6] != 4)
	    {
		boolean flag = executeGame(false, winnerOfThirdRoundMatchEight,winnerOfThirdRoundMatchSeven);
		if(flag)conferenceBWinCounter[1]++;
		else conferenceBWinCounter[6]++;
	    }
	    if(conferenceBWinCounter[2] != 4 && conferenceBWinCounter[5] != 4)
	    {
		boolean flag = executeGame(false, loserOfThirdRoundMatchFive,loserOfThirdRoundMatchSix);
		if(flag)conferenceBWinCounter[2]++;
		else conferenceBWinCounter[5]++;
	    }
	    if(conferenceBWinCounter[3] != 4 && conferenceBWinCounter[4] != 4)
	    {
		boolean flag = executeGame(false, loserOfThirdRoundMatchEight,loserOfThirdRoundMatchSeven);
		if(flag)conferenceBWinCounter[3]++;
		else conferenceBWinCounter[4]++;
	    }
	    if(conferenceAWinCounter[8] != 4 && conferenceAWinCounter[15] != 4)
	    {
		boolean flag = executeGame(false, winnerOfThirdRoundMatchNine,winnerOfThirdRoundMatchTen);
		if(flag)conferenceAWinCounter[8]++;
		else conferenceAWinCounter[15]++;
	    }
	    if(conferenceAWinCounter[9] != 4 && conferenceAWinCounter[14] != 4)
	    {
		boolean flag = executeGame(false, winnerOfThirdRoundMatchTwelve,winnerOfThirdRoundMatchEleven);
		if(flag)conferenceAWinCounter[9]++;
		else conferenceAWinCounter[14]++;
	    }
	    if(conferenceAWinCounter[10] != 4 && conferenceAWinCounter[13] != 4)
	    {
		boolean flag = executeGame(false, loserOfThirdRoundMatchNine,loserOfThirdRoundMatchTen);
		if(flag)conferenceAWinCounter[10]++;
		else conferenceAWinCounter[13]++;
	    }
	    if(conferenceAWinCounter[11] != 4 && conferenceAWinCounter[12] != 4)
	    {
		boolean flag = executeGame(false, loserOfThirdRoundMatchTwelve,loserOfThirdRoundMatchEleven);
		if(flag)conferenceAWinCounter[11]++;
		else conferenceAWinCounter[12]++;
	    }
	    if(conferenceBWinCounter[8] != 4 && conferenceBWinCounter[15] != 4)
	    {
		boolean flag = executeGame(false, winnerOfThirdRoundMatchThirteen,winnerOfThirdRoundMatchForteen);
		if(flag)conferenceBWinCounter[8]++;
		else conferenceBWinCounter[15]++;
	    }
	    if(conferenceBWinCounter[9] != 4 && conferenceBWinCounter[14] != 4)
	    {
		boolean flag = executeGame(false, winnerOfThirdRoundMatchSixteen,winnerOfThirdRoundMatchFifteen);
		if(flag)conferenceBWinCounter[9]++;
		else conferenceBWinCounter[14]++;
	    }
	    if(conferenceBWinCounter[10] != 4 && conferenceBWinCounter[13] != 4)
	    {
		boolean flag = executeGame(false, loserOfThirdRoundMatchThirteen,loserOfThirdRoundMatchForteen);
		if(flag)conferenceBWinCounter[10]++;
		else conferenceBWinCounter[13]++;
	    }
	    if(conferenceBWinCounter[11] != 4 && conferenceBWinCounter[12] != 4)
	    {
		boolean flag = executeGame(false, loserOfThirdRoundMatchSixteen,loserOfThirdRoundMatchFifteen);
		if(flag)conferenceBWinCounter[11]++;
		else conferenceBWinCounter[12]++;
	    }
	    writer.println();
	    gamesPlayed++;
	    gameResults.println();


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
	    if(conferenceAWinCounter[0] != 4 && conferenceAWinCounter[7] != 4)
	    {
		boolean flag = executeGame(false, topSeedConferenceA,topSeedConferenceB);
		if(flag)conferenceAWinCounter[0]++;
		else conferenceAWinCounter[7]++;
	    }
	    if(conferenceAWinCounter[1] != 4 && conferenceAWinCounter[6] != 4)
	    {
		boolean flag = executeGame(false, secondSeedConferenceA,secondSeedConferenceB);
		if(flag)conferenceAWinCounter[1]++;
		else conferenceAWinCounter[6]++;
	    }
	    if(conferenceAWinCounter[2] != 4 && conferenceAWinCounter[5] != 4)
	    {
		boolean flag = executeGame(false, thirdSeedConferenceA,thirdSeedConferenceB);
		if(flag)conferenceAWinCounter[2]++;
		else conferenceAWinCounter[5]++;
	    }
	    if(conferenceAWinCounter[3] != 4 && conferenceAWinCounter[4] != 4)
	    {
		boolean flag = executeGame(false, fourthSeedConferenceA,fourthSeedConferenceB);
		if(flag)conferenceAWinCounter[3]++;
		else conferenceAWinCounter[4]++;
	    }
	    if(conferenceBWinCounter[0] != 4 && conferenceBWinCounter[7] != 4)
	    {
		boolean flag = executeGame(false, fifthSeedConferenceA,fifthSeedConferenceB);
		if(flag)conferenceBWinCounter[0]++;
		else conferenceBWinCounter[7]++;
	    }
	    if(conferenceBWinCounter[1] != 4 && conferenceBWinCounter[6] != 4)
	    {
		boolean flag = executeGame(false, sixthSeedConferenceA,sixthSeedConferenceB);
		if(flag)conferenceBWinCounter[1]++;
		else conferenceBWinCounter[6]++;
	    }
	    if(conferenceBWinCounter[2] != 4 && conferenceBWinCounter[5] != 4)
	    {
		boolean flag = executeGame(false, seventhSeedConferenceA,seventhSeedConferenceB);
		if(flag)conferenceBWinCounter[2]++;
		else conferenceBWinCounter[5]++;
	    }
	    if(conferenceBWinCounter[3] != 4 && conferenceBWinCounter[4] != 4)
	    {
		boolean flag = executeGame(false, eighthSeedConferenceA,eighthSeedConferenceB);
		if(flag)conferenceBWinCounter[3]++;
		else conferenceBWinCounter[4]++;
	    }
	    if(conferenceAWinCounter[8] != 4 && conferenceAWinCounter[15] != 4)
	    {
		boolean flag = executeGame(false, ninthSeedConferenceA,ninthSeedConferenceB);
		if(flag)conferenceAWinCounter[8]++;
		else conferenceAWinCounter[15]++;
	    }
	    if(conferenceAWinCounter[9] != 4 && conferenceAWinCounter[14] != 4)
	    {
		boolean flag = executeGame(false, tenthSeedConferenceA,tenthSeedConferenceB);
		if(flag)conferenceAWinCounter[9]++;
		else conferenceAWinCounter[14]++;
	    }
	    if(conferenceAWinCounter[10] != 4 && conferenceAWinCounter[13] != 4)
	    {
		boolean flag = executeGame(false, eleventhSeedConferenceA,eleventhSeedConferenceB);
		if(flag)conferenceAWinCounter[10]++;
		else conferenceAWinCounter[13]++;
	    }
	    if(conferenceAWinCounter[11] != 4 && conferenceAWinCounter[12] != 4)
	    {
		boolean flag = executeGame(false, twelfthSeedConferenceA,twelfthSeedConferenceB);
		if(flag)conferenceAWinCounter[11]++;
		else conferenceAWinCounter[12]++;
	    }
	    if(conferenceBWinCounter[8] != 4 && conferenceBWinCounter[15] != 4)
	    {
		boolean flag = executeGame(false, thirteenthSeedConferenceA,thirteenthSeedConferenceB);
		if(flag)conferenceBWinCounter[8]++;
		else conferenceBWinCounter[15]++;
	    }
	    if(conferenceBWinCounter[9] != 4 && conferenceBWinCounter[14] != 4)
	    {
		boolean flag = executeGame(false, forteenthSeedConferenceA,forteenthSeedConferenceB);
		if(flag)conferenceBWinCounter[9]++;
		else conferenceBWinCounter[14]++;
	    }
	    if(conferenceBWinCounter[10] != 4 && conferenceBWinCounter[13] != 4)
	    {
		boolean flag = executeGame(false, fifteenthSeedConferenceA,fifteenthSeedConferenceB);
		if(flag)conferenceBWinCounter[10]++;
		else conferenceBWinCounter[13]++;
	    }
	    if(conferenceBWinCounter[11] != 4 && conferenceBWinCounter[12] != 4)
	    {
		boolean flag = executeGame(false, sixteenthSeedConferenceA,sixteenthSeedConferenceB);
		if(flag)conferenceBWinCounter[11]++;
		else conferenceBWinCounter[12]++;
	    }
	    writer.println();
	    gamesPlayed++;
	    gameResults.println();


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
	if(topSeedConferenceA == 7 && topSeedConferenceB == 23)
	{
	    return true;
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

	DivisionA.add(create.getTeam(0));
	DivisionA.add(create.getTeam(4));
	DivisionA.add(create.getTeam(5));
	DivisionA.add(create.getTeam(7));
	DivisionA.add(create.getTeam(9));
	DivisionA.add(create.getTeam(11));
	DivisionA.add(create.getTeam(27));
	DivisionA.add(create.getTeam(29));

	Collections.sort(DivisionA);

	DivisionB.add(create.getTeam(1));
	DivisionB.add(create.getTeam(6));
	DivisionB.add(create.getTeam(8));
	DivisionB.add(create.getTeam(10));
	DivisionB.add(create.getTeam(14));
	DivisionB.add(create.getTeam(19));
	DivisionB.add(create.getTeam(25));
	DivisionB.add(create.getTeam(31));


	Collections.sort(DivisionB);


	DivisionC.add(create.getTeam(13));
	DivisionC.add(create.getTeam(15));
	DivisionC.add(create.getTeam(18));
	DivisionC.add(create.getTeam(20));
	DivisionC.add(create.getTeam(22));
	DivisionC.add(create.getTeam(24));
	DivisionC.add(create.getTeam(26));
	DivisionC.add(create.getTeam(28));


	Collections.sort(DivisionC);


	DivisionD.add(create.getTeam(2));
	DivisionD.add(create.getTeam(3));
	DivisionD.add(create.getTeam(12));
	DivisionD.add(create.getTeam(16));
	DivisionD.add(create.getTeam(17));
	DivisionD.add(create.getTeam(21));
	DivisionD.add(create.getTeam(23));
	DivisionD.add(create.getTeam(30));


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

	startingGame = 73;

	gameResults.println("Game " + startingGame + ",Home,Score,Away,Score");
	startingGame++;
	executeGame(false,1, 0);
	executeGame(false,8, 27);
	executeGame(false,10, 7);
	executeGame(false,25, 9);
	executeGame(false,31, 5);
	executeGame(false,6, 29);
	executeGame(false,14, 4);
	executeGame(true,19, 11);
	executeGame(false,13, 3) ;
	executeGame(false,15, 16) ;
	executeGame(false,18, 21);
	executeGame(false,20, 30);
	executeGame(true,22, 23);
	executeGame(false,24, 17);
	executeGame(false,26, 12) ;
	executeGame(false,28, 2);







	writer.println();
	gameResults.println("Game " + startingGame + ",Home,Score,Away,Score");
	startingGame++;
	executeGame(false,0, 27);
	executeGame(true,11, 7);
	executeGame(false,4, 9);
	executeGame(false,29, 5);
	executeGame(true,1, 19);
	executeGame(false,8, 14);
	executeGame(false,10, 6);
	executeGame(false,25, 31);
	executeGame(false,13, 28);
	executeGame(false,15, 26);
	executeGame(false,18, 24);
	executeGame(true,20, 22);
	executeGame(false,2, 3) ;
	executeGame(false,12, 16) ;
	executeGame(false,17, 21);
	executeGame(false,23, 30);







	writer.println();
	gameResults.println("Game " + startingGame + ",Home,Score,Away,Score");
	startingGame++;
	executeGame(false,4, 0);
	executeGame(true,29, 11);
	executeGame(false,5, 3) ;
	executeGame(false,9, 16) ;
	executeGame(false,7, 21);
	executeGame(false,27, 30);
	executeGame(false,1, 23);
	executeGame(false,8, 17);
	executeGame(false,10, 12) ;
	executeGame(false,25, 2);
	executeGame(false,31, 28);
	executeGame(false,6, 26);
	executeGame(false,14, 24);
	executeGame(true,19, 22);
	executeGame(false,13, 20);
	executeGame(false,15, 18);






	writer.println();
	gameResults.println("Game " + startingGame + ",Home,Score,Away,Score");
	startingGame++;
	executeGame(false,5, 0);
	executeGame(false,9, 29);
	executeGame(false,7, 4);
	executeGame(true,27, 11);
	executeGame(false,1, 3) ;
	executeGame(false,8, 16) ;
	executeGame(false,10, 21);
	executeGame(false,25, 30);
	executeGame(false,31, 23);
	executeGame(false,6, 17);
	executeGame(false,14, 12) ;
	executeGame(true,19, 2);
	executeGame(false,13, 28);
	executeGame(false,15, 26);
	executeGame(false,18, 24);
	executeGame(true,20, 22);





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

    private static boolean executeGame(boolean b, int i, int j)
    {
	if(i == 11 || i == 19 || i == 22 || j == 11 || j == 19 || j == 22)b = true;
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
		System.out.println(create.getTeam(i).getTeamName() + " had a bounce back game against " + create.getTeam(j).getTeamName());
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
		System.out.println(create.getTeam(j).getTeamName() + " had a bounce back game against " + create.getTeam(i).getTeamName());
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

	    retVal = newGame.getWinner();
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
	return retVal;
    }

}
