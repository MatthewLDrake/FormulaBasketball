import java.io.Serializable;
import java.util.ArrayList;
public class createTeams implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private ArrayList<team> teams;
    public createTeams()
    {
	teams = new ArrayList<team>();
	createTeamOne();
	//createTeamTwo();
    }
    private void createTeamOne()
    {
	
    	teams.add(new team("Barsein Beggars"));
    	teams.add(new team("Aovensiiv Atoms"));
    	teams.add(new team("Errakyva Eruption"));
    	teams.add(new team("Aahrus Goosi"));
    	teams.add(new team("Daxanad Soldiers"));
    	teams.add(new team("Ebetxi Detro"));
    	teams.add(new team("Suggionic Infantry"));
    	teams.add(new team("Detroit Pumps"));
    	teams.add(new team("Kutapi Redwoods"));
    	teams.add(new team("Klákjábo Servals"));
    	teams.add(new team("Vincent Vikings"));
    	teams.add(new team("Bongatar Boppers"));
    	teams.add(new team("Ma-Popá Yiffs"));
    	teams.add(new team("Naskitrusk Brutes"));
    	teams.add(new team("Zaxon Zephyrs"));
    	teams.add(new team("Holy Yektonisa Hmongs"));
    	teams.add(new team("Yuofuan Jaguars"));
    	teams.add(new team("Autolik Rebels"));
    	teams.add(new team("Protopolis Progs"));
    	teams.add(new team("Lyintaria Kool Kats"));
    	teams.add(new team("Pyxanovia Elites"));
    	teams.add(new team("Boston Beavers"));
    	teams.add(new team("Red-Rainbow Reds"));
    	teams.add(new team("Bielosia Ghosts"));
    	teams.add(new team("Rockshaw Rave"));
    	teams.add(new team("Shmupland Tyrants"));
    	teams.add(new team("Shigua Boots"));
    	teams.add(new team("Hinaika Hurricanes"));
    	teams.add(new team("TND Force"));
    	teams.add(new team("Alteus Astronauts"));
    	teams.add(new team("Holylmao Bison"));
    	teams.add(new team("Aeridani Troopers"));
    	teams.get(0).addPlayer(new player(4, 8, 8, 4, 9, 4, 2, 5, 6, 8,"Shooting Guard #101", true));
    	teams.get(0).addPlayer(new player(2, 5, 7, 5, 5, 4, 7, 6, 3, 6,"Power Forward #128", true));
    	teams.get(0).addPlayer(new player(1, 5, 3, 2, 5, 10, 7, 6, 1, 7,"Center #154", true));
    	teams.get(0).addPlayer(new player(5, 3, 2, 3, 8, 3, 3, 2, 6, 9,"Point Guard #112", true));
    	teams.get(0).addPlayer(new player(3, 6, 7, 8, 4, 4, 2, 5, 5, 5,"Small Forward #147", true));
    	teams.get(0).addPlayer(new player(3, 5, 6, 2, 3, 5, 3, 7, 5, 8,"Small Forward #178", false));
    	teams.get(0).addPlayer(new player(5, 4, 2, 5, 7, 3, 4, 1, 5, 6,"Point Guard #135", false));
    	teams.get(0).addPlayer(new player(2, 4, 2, 2, 5, 2, 6, 9, 5, 5,"Power Forward #90", false));
    	teams.get(0).addPlayer(new player(4, 2, 5, 6, 4, 2, 1, 5, 4, 8,"Shooting Guard #144", false));
    	teams.get(0).addPlayer(new player(1, 9, 6, 2, 1, 2, 3, 6, 2, 5,"Keowynn Savang", false));
    	teams.get(0).addPlayer(new player(1, 5, 5, 8, 4, 4, 8, 4, 1, 5,"Center #102", false));
    	teams.get(0).addPlayer(new player(5, 4, 1, 3, 6, 5, 2, 3, 5, 6,"Point Guard #134", false));
    	teams.get(0).addPlayer(new player(2, 7, 1, 4, 5, 3, 1, 4, 3, 8,"Power Forward #133", false));
    	
    	teams.get(1).addPlayer(new player(3, 5, 3, 7, 6, 7, 7, 5, 6, 8,"Small Forward #143", true));
    	teams.get(1).addPlayer(new player(5, 6, 3, 3, 7, 5, 5, 4, 4, 8,"Point Guard #107", true));
    	teams.get(1).addPlayer(new player(2, 5, 6, 5, 4, 4, 7, 6, 5, 6,"Power Forward #150", true));
    	teams.get(1).addPlayer(new player(1, 7, 6, 3, 4, 4, 5, 4, 6, 7,"Center #143", true));
    	teams.get(1).addPlayer(new player(4, 5, 5, 5, 3, 5, 2, 4, 6, 6,"Shooting Guard #112", true));
    	teams.get(1).addPlayer(new player(5, 4, 2, 3, 7, 4, 6, 3, 3, 7,"Point Guard #105", false));
    	teams.get(1).addPlayer(new player(1, 5, 6, 2, 2, 5, 8, 6, 5, 5,"Center #106", false));
    	teams.get(1).addPlayer(new player(4, 2, 3, 8, 3, 3, 1, 5, 3, 8,"Shooting Guard #121", false));
    	teams.get(1).addPlayer(new player(2, 5, 1, 5, 5, 4, 7, 5, 3, 5,"Power Forward #138", false));
    	teams.get(1).addPlayer(new player(3, 7, 4, 3, 3, 6, 3, 5, 2, 7,"Small Forward #134", false));
    	teams.get(1).addPlayer(new player(5, 5, 1, 5, 5, 4, 5, 2, 5, 5,"Point Guard #125", false));
    	teams.get(1).addPlayer(new player(3, 4, 6, 1, 5, 2, 2, 5, 6, 8,"Small Forward #130", false));
    	teams.get(1).addPlayer(new player(4, 2, 4, 2, 5, 3, 5, 4, 3, 8,"Shooting Guard #159", false));
    	
    	teams.get(2).addPlayer(new player(4, 7, 2, 6, 7, 5, 2, 1, 5, 9,"Kudapa Zaxnax", true));
    	teams.get(2).addPlayer(new player(5, 4, 1, 8, 7, 5, 2, 2, 3, 7,"Point Guard #158", true));
    	teams.get(2).addPlayer(new player(3, 6, 3, 5, 2, 5, 7, 7, 7, 7,"Small Forward #133", true));
    	teams.get(2).addPlayer(new player(1, 5, 3, 2, 1, 7, 6, 7, 6, 6,"Center #107", true));
    	teams.get(2).addPlayer(new player(2, 6, 6, 5, 4, 3, 4, 6, 3, 7,"Power Forward #145", true));
    	teams.get(2).addPlayer(new player(2, 6, 1, 5, 6, 3, 3, 5, 4, 8,"Power Forward #153", false));
    	teams.get(2).addPlayer(new player(4, 3, 5, 5, 5, 4, 1, 2, 7, 5,"Shooting Guard #128", false));
    	teams.get(2).addPlayer(new player(1, 6, 4, 2, 2, 8, 5, 6, 2, 5,"Center #104", false));
    	teams.get(2).addPlayer(new player(5, 5, 3, 2, 8, 3, 5, 4, 5, 5,"Point Guard #120", false));
    	teams.get(2).addPlayer(new player(3, 4, 1, 2, 8, 1, 8, 8, 2, 9,"Small Forward #78", false));
    	teams.get(2).addPlayer(new player(2, 5, 4, 4, 1, 5, 2, 6, 7, 5,"Power Forward #79", false));
    	teams.get(2).addPlayer(new player(4, 4, 2, 4, 4, 1, 2, 2, 8, 6,"Shooting Guard #143", false));
    	teams.get(2).addPlayer(new player(3, 3, 6, 3, 5, 5, 5, 5, 1, 6,"Small Forward #117", false));
    	
    	teams.get(3).addPlayer(new player(1, 9, 8, 5, 2, 2, 5, 5, 3, 7,"Hamish Rooney", true));
    	teams.get(3).addPlayer(new player(4, 4, 2, 8, 5, 6, 4, 5, 1, 6,"Shooting Guard #161", true));
    	teams.get(3).addPlayer(new player(5, 6, 3, 5, 7, 5, 2, 1, 6, 7,"Point Guard #150", true));
    	teams.get(3).addPlayer(new player(3, 9, 5, 2, 3, 10, 1, 8, 1, 5,"Small Forward #80", true));
    	teams.get(3).addPlayer(new player(2, 6, 3, 5, 6, 4, 6, 3, 4, 7,"Power Forward #156", true));
    	teams.get(3).addPlayer(new player(4, 3, 1, 5, 4, 4, 8, 2, 5, 6,"Pau Vevapi", false));
    	teams.get(3).addPlayer(new player(1, 6, 5, 3, 5, 2, 5, 6, 7, 6,"Center #112", false));
    	teams.get(3).addPlayer(new player(3, 7, 7, 2, 2, 5, 6, 8, 1, 5,"Small Forward #29", false));
    	teams.get(3).addPlayer(new player(2, 4, 3, 3, 6, 7, 1, 5, 5, 8,"Power Forward #160", false));
    	teams.get(3).addPlayer(new player(5, 6, 3, 4, 6, 3, 3, 1, 4, 6,"Point Guard #104", false));
    	teams.get(3).addPlayer(new player(2, 6, 1, 5, 4, 2, 4, 6, 3, 6,"Power Forward #117", false));
    	teams.get(3).addPlayer(new player(4, 5, 2, 5, 1, 1, 5, 5, 6, 6,"Shooting Guard #108", false));
    	teams.get(3).addPlayer(new player(3, 2, 9, 2, 10, 2, 2, 8, 1, 5,"Small Forward #3", false));
    	
    	teams.get(4).addPlayer(new player(3, 7, 5, 1, 7, 6, 7, 4, 6, 8,"Small Forward #104", true));
    	teams.get(4).addPlayer(new player(4, 2, 1, 10, 5, 7, 3, 4, 2, 6,"Abi Gasbërr", true));
    	teams.get(4).addPlayer(new player(5, 5, 4, 5, 6, 5, 6, 3, 6, 6,"Point Guard #164", true));
    	teams.get(4).addPlayer(new player(1, 5, 6, 1, 5, 6, 8, 6, 1, 7,"Jake Kirk", true));
    	teams.get(4).addPlayer(new player(2, 7, 5, 5, 5, 7, 1, 1, 5, 8,"Power Forward #139", true));
    	teams.get(4).addPlayer(new player(2, 3, 4, 4, 2, 5, 6, 8, 6, 5,"Omeri Tetrisei", false));
    	teams.get(4).addPlayer(new player(5, 2, 4, 4, 5, 7, 3, 3, 6, 8,"Point Guard #47", false));
    	teams.get(4).addPlayer(new player(4, 2, 3, 4, 5, 6, 2, 6, 6, 5,"Shooting Guard #158", false));
    	teams.get(4).addPlayer(new player(1, 3, 6, 3, 4, 5, 6, 7, 5, 5,"Center #138", false));
    	teams.get(4).addPlayer(new player(3, 4, 6, 2, 7, 7, 4, 4, 1, 6,"Small Forward #175", false));
    	teams.get(4).addPlayer(new player(5, 1, 3, 4, 5, 4, 3, 2, 6, 10,"Midger", false));
    	teams.get(4).addPlayer(new player(3, 7, 5, 4, 2, 4, 4, 6, 2, 5,"Small Forward #103", false));
    	teams.get(4).addPlayer(new player(1, 4, 3, 1, 5, 5, 7, 4, 6, 6,"Center #163", false));
    	
    	teams.get(5).addPlayer(new player(5, 3, 3, 5, 10, 3, 4, 2, 4, 9,"Point Guard #149", true));
    	teams.get(5).addPlayer(new player(4, 6, 1, 7, 4, 2, 7, 4, 6, 5,"Shooting Guard #27", true));
    	teams.get(5).addPlayer(new player(1, 5, 6, 1, 4, 7, 7, 7, 4, 5,"Center #140", true));
    	teams.get(5).addPlayer(new player(2, 7, 1, 3, 6, 6, 7, 3, 3, 7,"Power Forward #170", true));
    	teams.get(5).addPlayer(new player(3, 5, 4, 1, 3, 7, 6, 5, 5, 8,"Small Forward #119", true));
    	teams.get(5).addPlayer(new player(4, 5, 4, 4, 4, 5, 2, 3, 2, 8,"Shooting Guard #110", false));
    	teams.get(5).addPlayer(new player(2, 6, 4, 4, 6, 5, 3, 1, 5, 8,"Power Forward #122", false));
    	teams.get(5).addPlayer(new player(3, 5, 6, 3, 1, 7, 4, 5, 5, 6,"Small Forward #122", false));
    	teams.get(5).addPlayer(new player(5, 3, 1, 3, 7, 5, 3, 4, 7, 7,"Point Guard #142", false));
    	teams.get(5).addPlayer(new player(1, 6, 3, 1, 2, 3, 6, 5, 6, 7,"Center #159", false));
    	teams.get(5).addPlayer(new player(5, 6, 1, 3, 5, 4, 6, 4, 3, 6,"Point Guard #12", false));
    	teams.get(5).addPlayer(new player(3, 6, 3, 1, 5, 5, 3, 5, 3, 7,"Small Forward #101", false));
    	teams.get(5).addPlayer(new player(1, 6, 9, 2, 1, 2, 1, 8, 1, 5,"Egrenat Alote", false));
    	
    	teams.get(6).addPlayer(new player(4, 1, 3, 8, 7, 5, 8, 1, 6, 8,"Nio Oipa", true));
    	teams.get(6).addPlayer(new player(3, 7, 4, 6, 6, 7, 4, 7, 1, 7,"Small Forward #139", true));
    	teams.get(6).addPlayer(new player(2, 7, 6, 5, 3, 4, 6, 4, 3, 8,"Power Forward #114", true));
    	teams.get(6).addPlayer(new player(5, 1, 2, 9, 6, 4, 3, 3, 6, 5,"Point Guard #93", true));
    	teams.get(6).addPlayer(new player(1, 6, 5, 6, 1, 10, 4, 4, 2, 7,"Center #157", true));
    	teams.get(6).addPlayer(new player(4, 6, 1, 5, 5, 6, 1, 2, 3, 5,"Shooting Guard #60", false));
    	teams.get(6).addPlayer(new player(3, 6, 6, 4, 2, 7, 5, 3, 3, 6,"Small Forward #150", false));
    	teams.get(6).addPlayer(new player(2, 4, 3, 5, 6, 6, 3, 5, 3, 7,"Power Forward #136", false));
    	teams.get(6).addPlayer(new player(1, 4, 2, 2, 5, 2, 8, 10, 1, 6,"Atomobei Dotrugo", false));
    	teams.get(6).addPlayer(new player(5, 3, 2, 6, 6, 3, 4, 3, 5, 5,"Point Guard #154", false));
    	teams.get(6).addPlayer(new player(5, 3, 1, 6, 4, 5, 5, 3, 6, 5,"Point Guard #20", false));
    	teams.get(6).addPlayer(new player(3, 4, 4, 3, 4, 6, 4, 7, 3, 5,"Small Forward #106", false));
    	teams.get(6).addPlayer(new player(4, 2, 2, 3, 4, 4, 6, 3, 7, 5,"Shooting Guard #140", false));
    	
    	teams.get(7).addPlayer(new player(1, 7, 7, 4, 4, 10, 3, 8, 2, 10,"Nopá Kánpovragá", true));
    	teams.get(7).addPlayer(new player(3, 5, 6, 5, 7, 5, 6, 7, 4, 8,"Small Forward #159", true));
    	teams.get(7).addPlayer(new player(5, 3, 2, 4, 8, 3, 5, 1, 7, 9,"Point Guard #126", true));
    	teams.get(7).addPlayer(new player(2, 5, 7, 5, 6, 5, 6, 1, 4, 8,"Power Forward #109", true));
    	teams.get(7).addPlayer(new player(4, 4, 3, 2, 5, 5, 5, 5, 6, 8,"Shooting Guard #169", true));
    	teams.get(7).addPlayer(new player(5, 2, 4, 3, 8, 5, 6, 2, 2, 6,"Point Guard #168", false));
    	teams.get(7).addPlayer(new player(1, 8, 8, 2, 1, 3, 6, 6, 2, 5,"Bruce Robertson", false));
    	teams.get(7).addPlayer(new player(4, 2, 3, 6, 5, 5, 6, 2, 1, 5,"Shooting Guard #123", false));
    	teams.get(7).addPlayer(new player(2, 5, 2, 3, 6, 2, 5, 7, 3, 6,"Power Forward #102", false));
    	teams.get(7).addPlayer(new player(3, 2, 4, 6, 5, 2, 10, 8, 3, 5,"Small Forward #61", false));
    	teams.get(7).addPlayer(new player(5, 4, 1, 3, 5, 6, 5, 4, 2, 7,"Point Guard #162", false));
    	teams.get(7).addPlayer(new player(1, 4, 6, 3, 2, 9, 7, 3, 2, 5,"Center #141", false));
    	teams.get(7).addPlayer(new player(4, 1, 2, 5, 4, 1, 5, 2, 6, 8,"Shooting Guard #75", false));
    	
    	teams.get(8).addPlayer(new player(1, 5, 7, 5, 2, 4, 7, 10, 4, 9,"Saiki Shunmyo", true));
    	teams.get(8).addPlayer(new player(3, 7, 5, 3, 4, 6, 7, 7, 4, 5,"Small Forward #167", true));
    	teams.get(8).addPlayer(new player(2, 3, 5, 3, 3, 9, 3, 9, 7, 6,"Malo Phoutthasinh", true));
    	teams.get(8).addPlayer(new player(4, 3, 3, 5, 6, 4, 2, 1, 9, 5,"Shooting Guard #99", true));
    	teams.get(8).addPlayer(new player(5, 2, 4, 2, 6, 5, 4, 4, 7, 10,"Point Guard #163", true));
    	teams.get(8).addPlayer(new player(4, 4, 2, 6, 2, 1, 5, 5, 7, 6,"Shooting Guard #167", false));
    	teams.get(8).addPlayer(new player(1, 7, 5, 2, 4, 2, 6, 7, 1, 7,"Center #125", false));
    	teams.get(8).addPlayer(new player(3, 7, 6, 2, 3, 3, 2, 2, 5, 5,"Small Forward #56", false));
    	teams.get(8).addPlayer(new player(2, 6, 6, 3, 4, 1, 6, 1, 4, 8,"Power Forward #119", false));
    	teams.get(8).addPlayer(new player(5, 2, 3, 5, 7, 4, 4, 3, 3, 5,"Point Guard #1", false));
    	teams.get(8).addPlayer(new player(3, 4, 6, 6, 1, 3, 3, 5, 7, 7,"Small Forward #160", false));
    	teams.get(8).addPlayer(new player(4, 4, 2, 6, 2, 1, 1, 4, 6, 8,"Shooting Guard #122", false));
    	teams.get(8).addPlayer(new player(5, 5, 1, 1, 6, 3, 6, 2, 5, 7,"Point Guard #106", false));
    	
    	teams.get(9).addPlayer(new player(4, 2, 4, 9, 9, 4, 3, 4, 5, 5,"Shooting Guard #105", true));
    	teams.get(9).addPlayer(new player(5, 4, 3, 5, 8, 6, 3, 3, 4, 6,"Point Guard #136", true));
    	teams.get(9).addPlayer(new player(1, 5, 3, 6, 4, 9, 6, 5, 3, 7,"Center #132", true));
    	teams.get(9).addPlayer(new player(3, 7, 6, 5, 5, 6, 3, 4, 4, 5,"Small Forward #162", true));
    	teams.get(9).addPlayer(new player(2, 4, 4, 5, 4, 6, 7, 5, 3, 6,"Power Forward #157", true));
    	teams.get(9).addPlayer(new player(4, 2, 2, 7, 4, 1, 7, 4, 4, 8,"Shooting Guard #47", false));
    	teams.get(9).addPlayer(new player(1, 6, 6, 3, 1, 2, 7, 7, 3, 7,"Center #153", false));
    	teams.get(9).addPlayer(new player(5, 6, 4, 3, 6, 6, 3, 2, 5, 5,"Point Guard #102", false));
    	teams.get(9).addPlayer(new player(3, 5, 3, 3, 4, 3, 7, 7, 3, 8,"Small Forward #114", false));
    	teams.get(9).addPlayer(new player(2, 5, 5, 2, 1, 1, 7, 7, 4, 5,"Power Forward #20", false));
    	teams.get(9).addPlayer(new player(1, 6, 6, 2, 3, 5, 7, 4, 1, 6,"Center #130", false));
    	teams.get(9).addPlayer(new player(5, 4, 4, 3, 5, 3, 4, 3, 7, 6,"Point Guard #115", false));
    	teams.get(9).addPlayer(new player(3, 4, 6, 5, 3, 4, 5, 3, 3, 5,"Small Forward #129", false));
    	
    	teams.get(10).addPlayer(new player(1, 6, 10, 1, 1, 9, 7, 5, 3, 8,"Center #101", true));
    	teams.get(10).addPlayer(new player(5, 4, 2, 4, 7, 5, 4, 4, 5, 10,"Point Guard #145", true));
    	teams.get(10).addPlayer(new player(2, 4, 7, 5, 6, 1, 4, 8, 3, 9,"Tipeprik Vokigei", true));
    	teams.get(10).addPlayer(new player(4, 4, 1, 10, 4, 3, 2, 3, 5, 5,"Shooting Guard #43", true));
    	teams.get(10).addPlayer(new player(3, 5, 4, 7, 4, 3, 6, 4, 5, 7,"Small Forward #148", true));
    	teams.get(10).addPlayer(new player(5, 5, 2, 3, 7, 3, 6, 2, 4, 7,"Point Guard #156", false));
    	teams.get(10).addPlayer(new player(3, 6, 4, 1, 6, 7, 4, 5, 1, 8,"Small Forward #135", false));
    	teams.get(10).addPlayer(new player(2, 4, 5, 3, 2, 1, 4, 7, 4, 10,"Bransby Jones", false));
    	teams.get(10).addPlayer(new player(4, 5, 5, 3, 4, 4, 1, 2, 5, 6,"Shooting Guard #148", false));
    	teams.get(10).addPlayer(new player(1, 6, 4, 3, 2, 3, 7, 6, 2, 6,"Center #111", false));
    	teams.get(10).addPlayer(new player(5, 2, 1, 3, 5, 5, 5, 2, 3, 10,"ąkoget lathíga kezel", false));
    	teams.get(10).addPlayer(new player(2, 7, 3, 5, 3, 1, 4, 2, 4, 7,"Power Forward #171", false));
    	teams.get(10).addPlayer(new player(1, 4, 3, 1, 5, 4, 8, 3, 6, 7,"Center #142", false));
    	
    	teams.get(11).addPlayer(new player(2, 7, 7, 4, 4, 6, 5, 7, 5, 6,"Power Forward #164", true));
    	teams.get(11).addPlayer(new player(3, 5, 7, 5, 2, 7, 7, 6, 2, 8,"Small Forward #115", true));
    	teams.get(11).addPlayer(new player(1, 5, 2, 4, 1, 10, 9, 5, 1, 8,"Lani Savang", true));
    	teams.get(11).addPlayer(new player(4, 5, 5, 6, 5, 2, 2, 6, 5, 6,"Shooting Guard #113", true));
    	teams.get(11).addPlayer(new player(5, 3, 4, 4, 6, 3, 5, 4, 3, 10,"Point Guard #140", true));
    	teams.get(11).addPlayer(new player(3, 5, 3, 7, 3, 5, 4, 3, 6, 7,"Small Forward #151", false));
    	teams.get(11).addPlayer(new player(4, 3, 4, 4, 4, 5, 3, 3, 4, 8,"Shooting Guard #114", false));
    	teams.get(11).addPlayer(new player(1, 4, 7, 3, 3, 1, 10, 8, 2, 5,"Asser Klostermann", false));
    	teams.get(11).addPlayer(new player(5, 3, 4, 3, 6, 4, 5, 1, 6, 8,"Point Guard #103", false));
    	teams.get(11).addPlayer(new player(2, 3, 2, 5, 5, 4, 5, 7, 4, 5,"Power Forward #92", false));
    	teams.get(11).addPlayer(new player(5, 6, 1, 3, 4, 6, 7, 3, 3, 5,"Point Guard #87", false));
    	teams.get(11).addPlayer(new player(1, 5, 8, 1, 2, 1, 6, 6, 5, 5,"Klanu Tanpratia", false));
    	teams.get(11).addPlayer(new player(2, 3, 4, 6, 5, 3, 1, 9, 3, 5,"Power Forward #73", false));
    	
    	teams.get(12).addPlayer(new player(1, 6, 7, 4, 3, 10, 8, 5, 1, 7,"Grant Pool", true));
    	teams.get(12).addPlayer(new player(4, 6, 2, 9, 5, 4, 3, 3, 1, 5,"Shooting Guard #14", true));
    	teams.get(12).addPlayer(new player(5, 5, 3, 4, 8, 3, 5, 3, 7, 6,"Point Guard #147", true));
    	teams.get(12).addPlayer(new player(2, 6, 7, 3, 6, 1, 6, 5, 4, 7,"Power Forward #152", true));
    	teams.get(12).addPlayer(new player(3, 6, 6, 3, 7, 3, 5, 6, 1, 8,"Small Forward #168", true));
    	teams.get(12).addPlayer(new player(4, 4, 3, 4, 4, 5, 2, 5, 7, 6,"Shooting Guard #165", false));
    	teams.get(12).addPlayer(new player(3, 5, 6, 6, 5, 4, 5, 6, 1, 6,"Small Forward #112", false));
    	teams.get(12).addPlayer(new player(5, 2, 1, 3, 8, 6, 6, 3, 3, 5,"Keon Saysamongdy", false));
    	teams.get(12).addPlayer(new player(2, 4, 2, 5, 6, 2, 6, 4, 4, 7,"Power Forward #104", false));
    	teams.get(12).addPlayer(new player(1, 4, 5, 3, 5, 9, 5, 3, 2, 7,"Center #149", false));
    	teams.get(12).addPlayer(new player(3, 4, 6, 1, 7, 4, 2, 5, 7, 6,"Small Forward #173", false));
    	teams.get(12).addPlayer(new player(1, 6, 6, 2, 5, 2, 2, 6, 5, 5,"Aseqa Fiqup", false));
    	teams.get(12).addPlayer(new player(2, 4, 1, 3, 5, 5, 4, 4, 5, 7,"Power Forward #134", false));
    	
    	teams.get(13).addPlayer(new player(1, 4, 4, 2, 5, 8, 10, 9, 2, 6,"Danombi Chejijar", true));
    	teams.get(13).addPlayer(new player(3, 7, 3, 6, 7, 3, 7, 7, 1, 5,"Small Forward #155", true));
    	teams.get(13).addPlayer(new player(4, 1, 2, 9, 4, 6, 5, 1, 3, 9,"Litsaw Lek'at", true));
    	teams.get(13).addPlayer(new player(2, 3, 3, 6, 4, 7, 6, 7, 3, 5,"Power Forward #46", true));
    	teams.get(13).addPlayer(new player(5, 3, 2, 4, 6, 4, 5, 4, 2, 7,"Point Guard #132", true));
    	teams.get(13).addPlayer(new player(5, 1, 2, 3, 4, 5, 6, 7, 8, 9,"LeBroccoli James", false));
    	teams.get(13).addPlayer(new player(4, 2, 3, 8, 1, 3, 6, 5, 6, 5,"Shooting Guard #111", false));
    	teams.get(13).addPlayer(new player(1, 4, 5, 6, 3, 1, 3, 8, 3, 7,"Kuronuma Kiyohira", false));
    	teams.get(13).addPlayer(new player(3, 3, 9, 1, 7, 1, 4, 1, 7, 9,"Small Forward #71", false));
    	teams.get(13).addPlayer(new player(2, 4, 3, 5, 4, 5, 4, 3, 4, 8,"Power Forward #127", false));
    	teams.get(13).addPlayer(new player(2, 6, 5, 4, 5, 4, 2, 2, 5, 6,"Power Forward #107", false));
    	teams.get(13).addPlayer(new player(1, 3, 4, 2, 2, 9, 7, 5, 3, 5,"Center #124", false));
    	teams.get(13).addPlayer(new player(5, 2, 1, 3, 6, 5, 7, 3, 3, 5,"Point Guard #78", false));
    	
    	teams.get(14).addPlayer(new player(2, 7, 7, 3, 6, 3, 7, 6, 4, 7,"Power Forward #113", true));
    	teams.get(14).addPlayer(new player(5, 5, 3, 3, 8, 6, 6, 3, 5, 6,"Point Guard #117", true));
    	teams.get(14).addPlayer(new player(4, 4, 2, 8, 1, 4, 6, 5, 7, 8,"Shooting Guard #151", true));
    	teams.get(14).addPlayer(new player(3, 6, 7, 1, 1, 5, 7, 4, 6, 8,"Small Forward #127", true));
    	teams.get(14).addPlayer(new player(1, 6, 4, 1, 1, 6, 8, 6, 6, 5,"Center #134", true));
    	teams.get(14).addPlayer(new player(5, 4, 3, 1, 8, 5, 6, 2, 5, 6,"Point Guard #144", false));
    	teams.get(14).addPlayer(new player(1, 5, 3, 2, 2, 6, 4, 7, 7, 6,"Center #164", false));
    	teams.get(14).addPlayer(new player(2, 4, 4, 5, 5, 2, 2, 6, 3, 10,"Power Forward #95", false));
    	teams.get(14).addPlayer(new player(3, 4, 6, 4, 3, 5, 4, 5, 4, 7,"Small Forward #146", false));
    	teams.get(14).addPlayer(new player(4, 4, 2, 3, 5, 4, 5, 6, 2, 6,"Shooting Guard #141", false));
    	teams.get(14).addPlayer(new player(1, 5, 7, 3, 5, 5, 3, 5, 2, 6,"Mornay", false));
    	teams.get(14).addPlayer(new player(4, 5, 3, 2, 2, 5, 1, 4, 6, 8,"Shooting Guard #153", false));
    	teams.get(14).addPlayer(new player(2, 6, 2, 5, 3, 4, 2, 3, 5, 7,"Power Forward #129", false));
    	
    	teams.get(15).addPlayer(new player(2, 7, 3, 5, 3, 6, 7, 7, 5, 6,"Power Forward #166", true));
    	teams.get(15).addPlayer(new player(1, 7, 3, 2, 5, 8, 8, 4, 6, 5,"Center #137", true));
    	teams.get(15).addPlayer(new player(5, 8, 2, 4, 3, 4, 5, 1, 2, 5,"Neat Mike", true));;
    	teams.get(15).addPlayer(new player(4, 3, 5, 6, 3, 3, 6, 3, 8, 7,"Shooting Guard #138", true));
    	teams.get(15).addPlayer(new player(3, 6, 3, 6, 3, 6, 2, 5, 6, 7,"Small Forward #166", true));
    	teams.get(15).addPlayer(new player(2, 3, 5, 6, 5, 1, 4, 9, 4, 6,"Vipoi Vuki", false));
    	teams.get(15).addPlayer(new player(1, 4, 6, 1, 2, 5, 7, 7, 6, 5,"Carsten Fein", false));
    	teams.get(15).addPlayer(new player(3, 4, 5, 2, 6, 6, 4, 6, 4, 6,"Small Forward #121", false));
    	teams.get(15).addPlayer(new player(5, 6, 1, 5, 5, 5, 4, 4, 5, 5,"Point Guard #118", false));
    	teams.get(15).addPlayer(new player(4, 4, 4, 3, 1, 4, 6, 2, 7, 7,"Shooting Guard #119", false));
    	teams.get(15).addPlayer(new player(2, 4, 3, 5, 4, 1, 7, 5, 3, 6,"Power Forward #158", false));
    	teams.get(15).addPlayer(new player(3, 5, 5, 3, 3, 2, 3, 4, 6, 8,"Small Forward #156", false));
    	teams.get(15).addPlayer(new player(4, 2, 1, 6, 3, 4, 3, 8, 3, 6,"Shooting Guard #104", false));
    	
    	teams.get(16).addPlayer(new player(4, 6, 2, 8, 6, 5, 8, 1, 1, 5,"Abi Rrasab", true));
    	teams.get(16).addPlayer(new player(2, 5, 7, 5, 6, 7, 3, 5, 3, 8,"Power Forward #106", true));
    	teams.get(16).addPlayer(new player(3, 7, 5, 3, 7, 6, 7, 4, 4, 5,"Small Forward #177", true));
    	teams.get(16).addPlayer(new player(1, 4, 5, 1, 1, 10, 7, 7, 1, 7,"Center #135", true));
    	teams.get(16).addPlayer(new player(5, 3, 2, 4, 8, 5, 6, 3, 2, 5,"Point Guard #127", true));
    	teams.get(16).addPlayer(new player(4, 5, 4, 6, 1, 5, 2, 3, 7, 6,"Shooting Guard #125", false));
    	teams.get(16).addPlayer(new player(3, 7, 6, 6, 5, 6, 3, 3, 1, 5,"Small Forward #113", false));
    	teams.get(16).addPlayer(new player(2, 6, 1, 3, 6, 3, 5, 5, 5, 6,"Power Forward #132", false));
    	teams.get(16).addPlayer(new player(1, 6, 9, 2, 4, 5, 1, 6, 3, 5,"Yondoora", false));
    	teams.get(16).addPlayer(new player(5, 2, 4, 3, 5, 6, 3, 2, 4, 10,"Ok Jae-Wook", false));
    	teams.get(16).addPlayer(new player(3, 4, 1, 4, 9, 2, 7, 10, 5, 3,"Small Forward #76", false));
    	teams.get(16).addPlayer(new player(5, 3, 1, 3, 7, 3, 4, 1, 7, 5,"Point Guard #119", false));
    	teams.get(16).addPlayer(new player(2, 7, 1, 4, 5, 6, 1, 2, 5, 6,"Power Forward #165", false));
    	
    	teams.get(17).addPlayer(new player(2, 6, 6, 4, 5, 6, 6, 5, 4, 7,"Power Forward #141", true));
    	teams.get(17).addPlayer(new player(1, 8, 7, 4, 3, 3, 7, 5, 3, 7,"Asser Gradl", true));
    	teams.get(17).addPlayer(new player(5, 2, 4, 7, 7, 5, 6, 1, 3, 5,"Point Guard #92", true));
    	teams.get(17).addPlayer(new player(4, 5, 1, 5, 4, 2, 4, 1, 8, 10,"Kolpa Hjetohje", true));
    	teams.get(17).addPlayer(new player(3, 3, 1, 7, 7, 6, 2, 10, 6, 5,"Small Forward #54", true));
    	teams.get(17).addPlayer(new player(5, 4, 4, 1, 8, 3, 5, 1, 4, 9,"Point Guard #138", false));
    	teams.get(17).addPlayer(new player(1, 6, 6, 7, 3, 6, 6, 4, 3, 5,"Center #119", false));
    	teams.get(17).addPlayer(new player(3, 4, 6, 3, 7, 2, 3, 7, 8, 5,"Small Forward #55", false));
    	teams.get(17).addPlayer(new player(4, 3, 2, 6, 4, 4, 3, 2, 5, 5,"Shooting Guard #49", false));
    	teams.get(17).addPlayer(new player(2, 5, 5, 5, 2, 2, 3, 7, 5, 5,"Paxathipatai Vongsay", false));
    	teams.get(17).addPlayer(new player(2, 7, 3, 3, 4, 5, 2, 2, 4, 7,"Power Forward #144", false));
    	teams.get(17).addPlayer(new player(5, 5, 4, 2, 5, 5, 5, 1, 6, 5,"Point Guard #169", false));
    	teams.get(17).addPlayer(new player(1, 3, 3, 2, 2, 4, 8, 6, 3, 7,"Center #147", false));
    	
    	teams.get(18).addPlayer(new player(3, 7, 5, 7, 6, 6, 6, 3, 4, 7,"Small Forward #161", true));
    	teams.get(18).addPlayer(new player(2, 6, 1, 4, 6, 5, 7, 7, 5, 6,"Power Forward #111", true));
    	teams.get(18).addPlayer(new player(1, 6, 6, 3, 2, 7, 1, 10, 1, 5,"Jasper Spivey", true));
    	teams.get(18).addPlayer(new player(5, 6, 2, 5, 5, 5, 4, 2, 4, 8,"kaf", true));
    	teams.get(18).addPlayer(new player(4, 3, 3, 10, 4, 1, 5, 1, 3, 6,"Kamil Fowler", true));
    	teams.get(18).addPlayer(new player(5, 3, 3, 5, 5, 7, 3, 3, 5, 7,"Point Guard #128", false));
    	teams.get(18).addPlayer(new player(4, 5, 3, 3, 5, 1, 3, 4, 7, 7,"Shooting Guard #137", false));
    	teams.get(18).addPlayer(new player(3, 6, 5, 3, 7, 2, 4, 6, 6, 5,"Small Forward #32", false));
    	teams.get(18).addPlayer(new player(1, 5, 6, 1, 4, 4, 9, 6, 2, 5,"Ijba Himadosadetsei", false));
    	teams.get(18).addPlayer(new player(2, 4, 5, 5, 4, 2, 2, 7, 4, 7,"Power Forward #103", false));
    	teams.get(18).addPlayer(new player(4, 5, 2, 3, 5, 4, 3, 4, 1, 7,"Shooting Guard #133", false));
    	teams.get(18).addPlayer(new player(5, 3, 3, 3, 7, 4, 3, 4, 2, 6,"Point Guard #148", false));
    	teams.get(18).addPlayer(new player(2, 7, 1, 4, 3, 2, 6, 2, 4, 6,"Power Forward #130", false));
    	
    	teams.get(19).addPlayer(new player(4, 7, 5, 6, 4, 3, 5, 6, 4, 8,"Shooting Guard #102", true));
    	teams.get(19).addPlayer(new player(1, 4, 8, 2, 2, 10, 4, 7, 3, 6,"Lilo Inthisane", true));
    	teams.get(19).addPlayer(new player(5, 4, 4, 3, 8, 4, 5, 2, 6, 7,"Point Guard #141", true));
    	teams.get(19).addPlayer(new player(3, 4, 4, 2, 6, 7, 7, 7, 1, 8,"Small Forward #124", true));
    	teams.get(19).addPlayer(new player(2, 4, 2, 4, 5, 6, 4, 6, 5, 8,"Power Forward #151", true));
    	teams.get(19).addPlayer(new player(1, 5, 9, 2, 4, 5, 3, 8, 2, 5,"Seino Seviba", false));
    	teams.get(19).addPlayer(new player(4, 3, 1, 5, 4, 4, 8, 2, 5, 5,"Shooting Guard #8", false));
    	teams.get(19).addPlayer(new player(2, 6, 2, 4, 5, 7, 2, 3, 4, 8,"Power Forward #110", false));
    	teams.get(19).addPlayer(new player(3, 3, 5, 4, 5, 3, 6, 6, 3, 8,"Small Forward #116", false));
    	teams.get(19).addPlayer(new player(5, 4, 4, 7, 4, 4, 4, 3, 4, 5,"Kiromi Hisei", false));
    	teams.get(19).addPlayer(new player(4, 1, 3, 6, 5, 2, 3, 4, 2, 9,"Charrat", false));
    	teams.get(19).addPlayer(new player(1, 5, 6, 1, 5, 2, 9, 5, 3, 5,"Mhasłanok Qjodlonhámh", false));
    	teams.get(19).addPlayer(new player(3, 5, 5, 2, 4, 3, 5, 4, 4, 6,"Small Forward #174", false));
    	
    	teams.get(20).addPlayer(new player(2, 8, 4, 3, 6, 5, 2, 8, 4, 7,"Zax Zaxnax", true));
    	teams.get(20).addPlayer(new player(4, 2, 5, 8, 4, 3, 3, 6, 7, 8,"Shooting Guard #157", true));
    	teams.get(20).addPlayer(new player(5, 4, 4, 5, 7, 4, 2, 4, 7, 7,"Point Guard #109", true));
    	teams.get(20).addPlayer(new player(1, 7, 3, 3, 2, 8, 5, 7, 1, 6,"Center #117", true));
    	teams.get(20).addPlayer(new player(3, 6, 7, 7, 1, 2, 7, 4, 2, 8,"Small Forward #140", true));
    	teams.get(20).addPlayer(new player(3, 5, 7, 5, 4, 3, 6, 7, 1, 7,"Small Forward #107", false));
    	teams.get(20).addPlayer(new player(5, 6, 2, 4, 5, 4, 6, 2, 6, 6,"Nathaniel Roberts", false));
    	teams.get(20).addPlayer(new player(1, 3, 4, 1, 1, 8, 8, 7, 5, 5,"Center #166", false));
    	teams.get(20).addPlayer(new player(2, 6, 4, 5, 3, 3, 2, 4, 4, 8,"Power Forward #159", false));
    	teams.get(20).addPlayer(new player(4, 4, 4, 1, 5, 3, 1, 2, 8, 8,"Shooting Guard #115", false));
    	teams.get(20).addPlayer(new player(2, 5, 3, 1, 3, 1, 3, 8, 4, 8,"Power Forward #23", false));
    	teams.get(20).addPlayer(new player(3, 4, 3, 6, 3, 5, 2, 5, 4, 7,"Small Forward #109", false));
    	teams.get(20).addPlayer(new player(4, 3, 4, 1, 3, 5, 4, 4, 7, 6,"Shooting Guard #142", false));
    	
    	teams.get(21).addPlayer(new player(4, 5, 5, 6, 5, 4, 5, 5, 6, 7,"Shooting Guard #103", true));
    	teams.get(21).addPlayer(new player(1, 7, 6, 1, 5, 6, 6, 4, 6, 7,"Center #113", true));
    	teams.get(21).addPlayer(new player(3, 6, 6, 3, 7, 7, 4, 7, 1, 7,"Small Forward #145", true));
    	teams.get(21).addPlayer(new player(5, 5, 4, 4, 6, 6, 4, 2, 5, 6,"Point Guard #131", true));
    	teams.get(21).addPlayer(new player(2, 6, 7, 3, 6, 4, 4, 2, 3, 8,"Power Forward #101", true));
    	teams.get(21).addPlayer(new player(4, 1, 2, 9, 4, 6, 5, 1, 3, 5,"Shooting Guard #12", false));
    	teams.get(21).addPlayer(new player(1, 5, 5, 2, 3, 6, 8, 6, 3, 5,"Center #145", false));
    	teams.get(21).addPlayer(new player(2, 4, 6, 1, 1, 7, 6, 7, 3, 6,"Danonio Asetxi", false));
    	teams.get(21).addPlayer(new player(3, 4, 7, 6, 6, 4, 3, 6, 1, 6,"Small Forward #128", false));
    	teams.get(21).addPlayer(new player(5, 6, 1, 4, 5, 3, 4, 10, 3, 7,"Point Guard #122", false));
    	teams.get(21).addPlayer(new player(5, 3, 3, 3, 5, 6, 3, 1, 2, 9,"Point Guard #108", false));
    	teams.get(21).addPlayer(new player(1, 5, 8, 1, 2, 1, 5, 6, 5, 6,"Mazló Nánpa", false));
    	teams.get(21).addPlayer(new player(2, 5, 1, 4, 6, 3, 2, 4, 5, 7,"Power Forward #143", false));
    	
    	teams.get(22).addPlayer(new player(1, 10, 6, 2, 3, 1, 8, 8, 3, 5,"Sagobesei Alote", true));
    	teams.get(22).addPlayer(new player(4, 5, 4, 6, 5, 4, 3, 4, 5, 7,"Shooting Guard #107", true));
    	teams.get(22).addPlayer(new player(5, 4, 3, 5, 7, 4, 5, 1, 2, 8,"Point Guard #146", true));
    	teams.get(22).addPlayer(new player(3, 4, 6, 6, 4, 5, 7, 5, 1, 8,"Small Forward #110", true));
    	teams.get(22).addPlayer(new player(2, 6, 4, 4, 4, 6, 6, 1, 5, 7,"Power Forward #149", true));
    	teams.get(22).addPlayer(new player(5, 4, 4, 2, 8, 3, 3, 3, 7, 7,"Yqt Messi", false));
    	teams.get(22).addPlayer(new player(3, 3, 7, 5, 5, 3, 6, 4, 4, 7,"Small Forward #141", false));
    	teams.get(22).addPlayer(new player(1, 5, 3, 3, 1, 6, 6, 6, 6, 6,"Center #116", false));
    	teams.get(22).addPlayer(new player(2, 5, 3, 4, 5, 3, 7, 3, 3, 6,"Power Forward #105", false));
    	teams.get(22).addPlayer(new player(4, 1, 1, 7, 4, 4, 6, 1, 5, 5,"Shooting Guard #57", false));
    	teams.get(22).addPlayer(new player(1, 4, 4, 2, 3, 9, 4, 6, 2, 5,"Center #121", false));
    	teams.get(22).addPlayer(new player(4, 1, 3, 6, 5, 2, 3, 4, 2, 8,"Shooting Guard #3", false));
    	teams.get(22).addPlayer(new player(3, 4, 6, 1, 3, 6, 7, 3, 2, 5,"Small Forward #142", false));
    	
    	teams.get(23).addPlayer(new player(2, 6, 3, 5, 6, 4, 6, 7, 5, 6,"Power Forward #125", true));
    	teams.get(23).addPlayer(new player(1, 6, 6, 1, 5, 8, 5, 7, 3, 5,"Center #161", true));
    	teams.get(23).addPlayer(new player(5, 1, 4, 7, 6, 7, 5, 2, 4, 5,"Point Guard #41", true));
    	teams.get(23).addPlayer(new player(4, 7, 2, 9, 4, 3, 1, 3, 3, 5,"Carsten Tischbein", true));
    	teams.get(23).addPlayer(new player(3, 7, 5, 3, 4, 4, 4, 1, 10, 5,"Small Forward #26", true));
    	teams.get(23).addPlayer(new player(2, 6, 2, 3, 6, 7, 2, 4, 4, 8,"Power Forward #168", false));
    	teams.get(23).addPlayer(new player(4, 6, 2, 8, 4, 1, 2, 4, 1, 5,"Shooting Guard #45", false));
    	teams.get(23).addPlayer(new player(3, 5, 4, 3, 7, 5, 2, 4, 4, 8,"Small Forward #169", false));
    	teams.get(23).addPlayer(new player(1, 4, 5, 6, 2, 9, 6, 3, 4, 6,"Center #162", false));
    	teams.get(23).addPlayer(new player(5, 6, 2, 3, 6, 3, 5, 2, 4, 7,"Point Guard #153", false));
    	teams.get(23).addPlayer(new player(3, 3, 6, 4, 1, 7, 6, 3, 3, 7,"Small Forward #102", false));
    	teams.get(23).addPlayer(new player(5, 3, 3, 4, 5, 3, 5, 4, 6, 6,"Point Guard #143", false));
    	teams.get(23).addPlayer(new player(4, 3, 2, 5, 6, 1, 4, 1, 2, 5,"Shooting Guard #72", false));
    	
    	teams.get(24).addPlayer(new player(5, 6, 3, 5, 7, 5, 5, 2, 2, 9,"Point Guard #167", true));
    	teams.get(24).addPlayer(new player(3, 7, 5, 7, 1, 5, 6, 6, 7, 6,"Small Forward #138", true));
    	teams.get(24).addPlayer(new player(2, 7, 6, 3, 3, 7, 2, 6, 5, 7,"Power Forward #116", true));
    	teams.get(24).addPlayer(new player(1, 7, 6, 7, 1, 3, 3, 7, 5, 6,"Center #115", true));
    	teams.get(24).addPlayer(new player(4, 1, 1, 8, 5, 6, 8, 4, 1, 5,"Shooting Guard #94", true));
    	teams.get(24).addPlayer(new player(4, 1, 1, 5, 7, 10, 4, 1, 2, 5,"Shooting Guard #89", false));
    	teams.get(24).addPlayer(new player(1, 6, 6, 1, 3, 5, 5, 6, 5, 5,"Sol Chin-Ho", false));
    	teams.get(24).addPlayer(new player(3, 7, 5, 2, 4, 4, 6, 7, 1, 7,"Small Forward #136", false));
    	teams.get(24).addPlayer(new player(2, 5, 5, 3, 3, 3, 7, 1, 4, 8,"Power Forward #124", false));
    	teams.get(24).addPlayer(new player(5, 2, 1, 5, 4, 8, 6, 3, 7, 5,"Point Guard #40", false));
    	teams.get(24).addPlayer(new player(5, 2, 4, 3, 7, 4, 3, 3, 2, 7,"Point Guard #160", false));
    	teams.get(24).addPlayer(new player(4, 2, 4, 3, 5, 2, 5, 5, 6, 6,"Shooting Guard #136", false));
    	teams.get(24).addPlayer(new player(3, 4, 4, 5, 6, 2, 3, 3, 5, 6,"Small Forward #149", false));
    	
    	teams.get(25).addPlayer(new player(5, 6, 3, 5, 8, 6, 2, 3, 7, 5,"Point Guard #155", true));
    	teams.get(25).addPlayer(new player(1, 7, 3, 1, 1, 10, 6, 6, 3, 7,"Center #128", true));
    	teams.get(25).addPlayer(new player(3, 4, 7, 7, 2, 6, 3, 7, 7, 6,"Small Forward #132", true));
    	teams.get(25).addPlayer(new player(2, 4, 4, 5, 6, 4, 4, 7, 5, 8,"Power Forward #146", true));
    	teams.get(25).addPlayer(new player(4, 4, 5, 4, 5, 6, 3, 2, 3, 6,"Shooting Guard #162", true));
    	teams.get(25).addPlayer(new player(4, 4, 5, 6, 2, 4, 2, 2, 7, 7,"Shooting Guard #147", false));
    	teams.get(25).addPlayer(new player(1, 6, 4, 1, 2, 5, 4, 6, 7, 6,"Center #150", false));
    	teams.get(25).addPlayer(new player(2, 6, 3, 1, 5, 2, 5, 7, 6, 5,"Power Forward #2", false));
    	teams.get(25).addPlayer(new player(3, 6, 7, 4, 2, 4, 2, 5, 6, 6,"Small Forward #153", false));
    	teams.get(25).addPlayer(new player(5, 6, 2, 4, 5, 4, 6, 2, 6, 5,"Point Guard #19", false));
    	teams.get(25).addPlayer(new player(2, 3, 5, 3, 4, 3, 5, 6, 5, 5,"Power Forward #9", false));
    	teams.get(25).addPlayer(new player(3, 6, 2, 3, 2, 7, 9, 1, 2, 5,"Small Forward #44", false));
    	teams.get(25).addPlayer(new player(4, 5, 2, 2, 1, 6, 5, 6, 3, 6,"Shooting Guard #126", false));
    	
    	teams.get(26).addPlayer(new player(2, 6, 3, 4, 5, 4, 7, 6, 4, 8,"Power Forward #108", true));
    	teams.get(26).addPlayer(new player(3, 7, 7, 8, 7, 2, 5, 4, 4, 8,"Small Forward #152", true));
    	teams.get(26).addPlayer(new player(1, 6, 8, 2, 5, 1, 4, 5, 6, 10,"Bilingulbut", true));
    	teams.get(26).addPlayer(new player(4, 5, 5, 6, 3, 4, 6, 3, 5, 6,"Shooting Guard #160", true));
    	teams.get(26).addPlayer(new player(5, 2, 3, 1, 5, 8, 8, 4, 6, 9,"Point Guard #133", true));
    	teams.get(26).addPlayer(new player(2, 5, 5, 5, 3, 4, 3, 7, 3, 7,"Power Forward #118", false));
    	teams.get(26).addPlayer(new player(5, 4, 4, 2, 7, 3, 5, 1, 6, 8,"Point Guard #114", false));
    	teams.get(26).addPlayer(new player(3, 6, 6, 8, 4, 2, 2, 3, 6, 6,"Small Forward #164", false));
    	teams.get(26).addPlayer(new player(4, 4, 4, 2, 3, 4, 6, 3, 5, 7,"Shooting Guard #131", false));
    	teams.get(26).addPlayer(new player(1, 4, 3, 3, 4, 2, 6, 7, 5, 7,"Center #139", false));
    	teams.get(26).addPlayer(new player(4, 4, 5, 1, 4, 3, 5, 4, 5, 7,"Shooting Guard #164", false));
    	teams.get(26).addPlayer(new player(1, 3, 6, 3, 4, 8, 3, 4, 4, 7,"Center #160", false));
    	teams.get(26).addPlayer(new player(2, 7, 1, 4, 4, 1, 5, 3, 5, 5,"Power Forward #163", false));
    	
    	teams.get(27).addPlayer(new player(4, 3, 3, 2, 7, 8, 9, 3, 3, 10,"Shooting Guard #106", true));
    	teams.get(27).addPlayer(new player(1, 5, 6, 2, 4, 10, 1, 8, 2, 8,"Om Kwang-Jo", true));
    	teams.get(27).addPlayer(new player(3, 7, 5, 6, 3, 5, 7, 4, 1, 8,"Small Forward #111", true));
    	teams.get(27).addPlayer(new player(5, 5, 3, 4, 7, 3, 5, 4, 4, 7,"Point Guard #129", true));
    	teams.get(27).addPlayer(new player(2, 5, 6, 5, 3, 7, 2, 5, 5, 6,"Power Forward #135", true));
    	teams.get(27).addPlayer(new player(4, 1, 3, 6, 4, 6, 1, 3, 5, 10,"Shooting Guard #86", false));
    	teams.get(27).addPlayer(new player(3, 3, 7, 4, 7, 3, 4, 5, 3, 8,"Small Forward #157", false));
    	teams.get(27).addPlayer(new player(1, 8, 3, 2, 2, 1, 6, 5, 6, 8,"Ivor Wade", false));
    	teams.get(27).addPlayer(new player(2, 5, 3, 5, 6, 3, 1, 6, 5, 6,"Power Forward #173", false));
    	teams.get(27).addPlayer(new player(5, 6, 2, 5, 5, 5, 4, 2, 4, 5,"Point Guard #3", false));
    	teams.get(27).addPlayer(new player(2, 5, 1, 4, 5, 7, 5, 2, 3, 6,"Power Forward #142", false));
    	teams.get(27).addPlayer(new player(5, 5, 4, 1, 7, 2, 2, 1, 2, 10,"Point Guard #121", false));
    	teams.get(27).addPlayer(new player(3, 1, 2, 4, 6, 6, 3, 10, 3, 5,"Small Forward #10", false));
    	
    	teams.get(28).addPlayer(new player(4, 7, 1, 9, 7, 1, 3, 1, 4, 5,"Woganure", true));
    	teams.get(28).addPlayer(new player(5, 7, 7, 4, 9, 4, 3, 2, 1, 5,"LeBryon Janes", true));
    	teams.get(28).addPlayer(new player(3, 6, 4, 7, 7, 6, 4, 4, 1, 7,"Small Forward #120", true));
    	teams.get(28).addPlayer(new player(2, 7, 4, 4, 4, 2, 6, 7, 4, 6,"Power Forward #131", true));
    	teams.get(28).addPlayer(new player(1, 3, 4, 3, 2, 9, 8, 7, 1, 7,"Center #151", true));
    	teams.get(28).addPlayer(new player(5, 3, 4, 5, 7, 4, 5, 3, 2, 6,"Point Guard #159", false));
    	teams.get(28).addPlayer(new player(2, 6, 5, 5, 4, 2, 1, 6, 4, 8,"Power Forward #161", false));
    	teams.get(28).addPlayer(new player(3, 3, 6, 6, 4, 5, 5, 4, 2, 8,"Small Forward #158", false));
    	teams.get(28).addPlayer(new player(4, 4, 3, 5, 2, 3, 5, 3, 3, 8,"Shooting Guard #134", false));
    	teams.get(28).addPlayer(new player(1, 5, 4, 1, 2, 6, 6, 7, 1, 6,"Center #103", false));
    	teams.get(28).addPlayer(new player(3, 4, 7, 1, 4, 7, 3, 6, 4, 5,"Small Forward #165", false));
    	teams.get(28).addPlayer(new player(5, 2, 4, 3, 5, 6, 3, 2, 4, 8,"Point Guard #13", false));
    	teams.get(28).addPlayer(new player(2, 6, 4, 5, 4, 5, 3, 2, 3, 5,"Power Forward #167", false));
    	
    	teams.get(29).addPlayer(new player(2, 4, 5, 5, 5, 7, 7, 2, 4, 8,"Power Forward #120", true));
    	teams.get(29).addPlayer(new player(4, 1, 1, 10, 1, 4, 3, 3, 10, 9,"Harver Borelli", true));
    	teams.get(29).addPlayer(new player(5, 10, 3, 10, 4, 1, 1, 1, 7, 5,"Iora Dani", true));
    	teams.get(29).addPlayer(new player(2, 7, 2, 1, 1, 4, 3, 7, 7, 5,"Power Forward #38", false));
    	teams.get(29).addPlayer(new player(1, 5, 8, 2, 1, 6, 5, 5, 6, 5,"Kuronuma Gihei", true));
    	teams.get(29).addPlayer(new player(3, 5, 5, 5, 3, 3, 5, 6, 7, 5,"Small Forward #172", true));
    	teams.get(29).addPlayer(new player(4, 4, 4, 4, 4, 1, 2, 2, 8, 6,"Shooting Guard #109", false));
    	teams.get(29).addPlayer(new player(3, 7, 5, 5, 5, 3, 2, 3, 6, 6,"Small Forward #118", false));
    	teams.get(29).addPlayer(new player(1, 7, 3, 2, 4, 5, 3, 5, 4, 7,"Center #118", false));
    	teams.get(29).addPlayer(new player(5, 6, 2, 4, 5, 6, 6, 1, 3, 5,"Point Guard #101", false));
    	teams.get(29).addPlayer(new player(1, 4, 4, 1, 2, 7, 6, 3, 7, 7,"Center #105", false));
    	teams.get(29).addPlayer(new player(3, 1, 9, 1, 3, 9, 4, 6, 2, 5,"Small Forward #39", false));
    	teams.get(29).addPlayer(new player(2, 5, 7, 5, 6, 2, 1, 1, 3, 8,"Power Forward #137", false));
    	
    	teams.get(30).addPlayer(new player(4, 5, 2, 7, 4, 5, 6, 6, 4, 7,"Shooting Guard #129", true));
    	teams.get(30).addPlayer(new player(2, 7, 6, 5, 6, 2, 4, 6, 3, 8,"Power Forward #174", true));
    	teams.get(30).addPlayer(new player(5, 5, 3, 3, 7, 5, 5, 1, 7, 6,"Point Guard #137", true));
    	teams.get(30).addPlayer(new player(3, 7, 5, 5, 4, 6, 4, 9, 2, 5,"Small Forward #67", true));
    	teams.get(30).addPlayer(new player(1, 5, 3, 2, 2, 6, 8, 6, 7, 5,"Center #131", true));
    	teams.get(30).addPlayer(new player(3, 4, 5, 4, 7, 6, 7, 3, 3, 5,"Small Forward #137", false));
    	teams.get(30).addPlayer(new player(4, 4, 3, 5, 4, 6, 2, 4, 2, 6,"Shooting Guard #156", false));
    	teams.get(30).addPlayer(new player(2, 6, 3, 3, 5, 7, 6, 1, 3, 7,"Power Forward #155", false));
    	teams.get(30).addPlayer(new player(5, 4, 4, 3, 5, 5, 3, 4, 3, 10,"Point Guard #33", false));
    	teams.get(30).addPlayer(new player(1, 7, 6, 1, 2, 4, 1, 6, 1, 9,"Alotra Asoertotrisei", false));
    	teams.get(30).addPlayer(new player(3, 4, 5, 7, 4, 3, 3, 3, 6, 6,"Small Forward #171", false));
    	teams.get(30).addPlayer(new player(5, 2, 1, 3, 8, 4, 2, 4, 6, 5,"Point Guard #165", false));
    	teams.get(30).addPlayer(new player(1, 7, 3, 1, 2, 3, 3, 4, 7, 6,"Center #108", false));
    	
    	teams.get(31).addPlayer(new player(4, 7, 3, 7, 4, 4, 8, 1, 2, 5,"Shooting Guard #21", true));
    	teams.get(31).addPlayer(new player(1, 7, 6, 1, 5, 7, 8, 6, 2, 6,"Center #133", true));
    	teams.get(31).addPlayer(new player(3, 6, 7, 2, 3, 7, 3, 4, 5, 8,"Small Forward #176", true));
    	teams.get(31).addPlayer(new player(5, 5, 2, 5, 7, 3, 6, 3, 5, 5,"Point Guard #111", true));
    	teams.get(31).addPlayer(new player(2, 3, 3, 6, 3, 8, 1, 8, 4, 8,"Tibiziŋag Ifet", true));
    	teams.get(31).addPlayer(new player(5, 5, 2, 4, 6, 4, 2, 4, 5, 9,"Point Guard #157", false));
    	teams.get(31).addPlayer(new player(3, 6, 6, 1, 6, 5, 6, 5, 2, 6,"Small Forward #125", false));
    	teams.get(31).addPlayer(new player(4, 2, 3, 7, 5, 3, 4, 4, 3, 5,"Shooting Guard #70", false));
    	teams.get(31).addPlayer(new player(2, 5, 3, 6, 2, 4, 2, 9, 3, 5,"Power Forward #15", false));
    	teams.get(31).addPlayer(new player(1, 6, 6, 3, 2, 2, 8, 7, 1, 5,"Henri Ulster", false));
    	teams.get(31).addPlayer(new player(1, 7, 5, 2, 4, 3, 7, 5, 1, 5,"Center #152", false));
    	teams.get(31).addPlayer(new player(3, 2, 4, 5, 10, 1, 2, 7, 6, 6,"Small Forward #37", false));
    	teams.get(31).addPlayer(new player(5, 5, 1, 5, 4, 2, 5, 1, 4, 7,"Point Guard #123", false));
    	

	
	
	Print theTeams = new Print(teams);

	theTeams.printAllTeams();



	
	//createTeamTwo();
    }
    /*
    private void createTeamTwo()
    {
	teams.add(new team("TMC's Cows"));
	teams.get(1).addPlayer(new player(1, 6, 4, 6, 1, 4, 8, 3, 1, 2, "First", "Last", true));
	teams.get(1).addPlayer(new player(2, 7, 2, 5, 1, 1, 10, 8, 10, 7, "First", "Last", true));
	teams.get(1).addPlayer(new player(3, 10, 9, 9, 5, 3, 2, 4, 8, 2, "First", "Last", true));
	teams.get(1).addPlayer(new player(4, 7, 5, 7, 10, 1, 8, 2, 1, 9, "First", "Last", true));
	teams.get(1).addPlayer(new player(5, 8, 5, 7, 2, 7, 8, 5, 5, 1, "First", "Last", true));
	teams.get(1).addPlayer(new player(1, 10, 9, 1, 9, 5, 6, 7, 2, 8, "First", "Last", false));
	teams.get(1).addPlayer(new player(2, 3, 8, 5, 1, 5, 10, 1, 1, 8, "First", "Last", false));
	teams.get(1).addPlayer(new player(3, 5, 5, 7, 2, 5, 3, 3, 1, 10, "First", "Last", false));
	teams.get(1).addPlayer(new player(4, 7, 2, 1, 7, 10, 10, 10, 1, 3, "First", "Last", false));
	teams.get(1).addPlayer(new player(5, 5, 3, 9, 7, 6, 1, 10, 10, 5, "First", "Last", false));
	teams.get(1).addPlayer(new player(2, 5, 6, 6, 6, 7, 6, 3, 6, 3, "First", "Last", false));
	teams.get(1).addPlayer(new player(4, 3, 1, 1, 8, 8, 2, 6, 4, 8, "First", "Last", false));
	teams.get(1).addPlayer(new player(5, 1, 8, 2, 4, 2, 10, 10, 6, 7, "First", "Last", false));


	
	
    }
    */
    public team getTeam(int teamNum)
    {
        return teams.get(teamNum);
    }
	public int size()
	{
		
		return teams.size();
	}
    
}
