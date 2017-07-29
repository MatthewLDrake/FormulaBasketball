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
	createTheTeams();
	//createTeamTwo();
    }
    public int size()
    {
	return teams.size();
    }
    private void createTheTeams()
    {
	teams.add(new team("Aahrus Moosi"));
	
	teams.get(0).addPlayer(new player(1 ,7 ,10 ,4 ,2 ,5 ,10 ,9 ,12 ,8 ,9 ,5 ,"Ajanis Vealerko", true));
	teams.get(0).addPlayer(new player(2 ,8 ,9 ,4 ,4 ,5 ,6 ,5 ,9 ,7 ,5 ,10 ,"Yombeen", true));
	teams.get(0).addPlayer(new player(3 ,10 ,5 ,1 ,1 ,8 ,9 ,6 ,10 ,7 ,5 ,9 ,"Aahrus Player #1", true));
	teams.get(0).addPlayer(new player(4 ,5 ,4 ,10 ,10 ,7 ,8 ,6 ,2 ,10 ,5 ,8 ,"Kardo Gasbërr", true));
	teams.get(0).addPlayer(new player(5 ,2 ,3 ,10 ,10 ,9 ,4 ,7 ,3 ,10 ,5 ,7 ,"Venniti Flautika", true));
	teams.get(0).addPlayer(new player(5 ,3 ,6 ,10 ,10 ,10 ,6 ,3 ,1 ,6 ,5 ,5 ,"Aahrus Player #10", false));
	teams.get(0).addPlayer(new player(4 ,5 ,5 ,8 ,8 ,4 ,6 ,7 ,3 ,3 ,5 ,10 ,"Aahrus Player #4", false));
	teams.get(0).addPlayer(new player(3 ,1 ,8 ,10 ,10 ,2 ,2 ,10 ,9 ,9 ,5 ,7 ,"Aahrus Player #5", false));
	teams.get(0).addPlayer(new player(3 ,2 ,6 ,5 ,9 ,9 ,8 ,5 ,3 ,10 ,1 ,9 ,"Carsten Meyer", false));
	teams.get(0).addPlayer(new player(1 ,8 ,8 ,2 ,2 ,3 ,10 ,5 ,9 ,4 ,5 ,7 ,"Aahrus Player #2", false));
	teams.get(0).addPlayer(new player(5 ,5 ,4 ,7 ,7 ,10 ,7 ,5 ,1 ,1 ,5 ,5 ,"Omumesomobesa Lemrombatdesi", false));
	teams.get(0).addPlayer(new player(1 ,6 ,9 ,2 ,2 ,5 ,7 ,6 ,8 ,4 ,5 ,7 ,"Kersuvi Himei", false));
	teams.get(0).addPlayer(new player(2 ,7 ,8 ,1 ,1 ,5 ,7 ,4 ,9 ,3 ,5 ,10 ,"Oisín Barnett", false));
	teams.get(0).addPlayer(new player(2 ,7 ,9 ,6 ,6 ,3 ,6 ,4 ,10 ,3 ,5 ,10 ,"P'uyo Unup'a", false));
	teams.get(0).addPlayer(new player(4 ,5 ,1 ,7 ,7 ,4 ,8 ,7 ,4 ,6 ,5 ,10 ,"Takishima Kazuko", false));
	teams.add(new team("Auspikitan Golden Falcons"));
	teams.get(1).addPlayer(new player(1 ,7 ,7 ,1 ,1 ,4 ,9 ,10 ,9 ,6 ,5 ,6 ,"Yadingallie", true));
	teams.get(1).addPlayer(new player(2 ,8 ,7 ,8 ,8 ,7 ,7 ,7 ,9 ,6 ,5 ,9 ,"Jesse McSteve", true));
	teams.get(1).addPlayer(new player(3 ,9 ,3 ,10 ,10 ,10 ,7 ,5 ,8 ,6 ,5 ,7 ,"Sago Alodetsei", true));
	teams.get(1).addPlayer(new player(4 ,10 ,8 ,7 ,10 ,8 ,9 ,7 ,2 ,8 ,6 ,7 ,"Lato Ikro", true));
	teams.get(1).addPlayer(new player(5 ,4 ,4 ,6 ,6 ,15 ,9 ,8 ,5 ,6 ,5 ,5 ,"Billingulbut", true));
	teams.get(1).addPlayer(new player(3 ,9 ,10 ,2 ,5 ,5 ,6 ,9 ,5 ,10 ,3 ,9 ,"Nupa Ixau", false));
	teams.get(1).addPlayer(new player(2 ,8 ,4 ,6 ,6 ,2 ,7 ,7 ,6 ,7 ,5 ,5 ,"Itausŋaŋufi Utipŋiqe", false));
	teams.get(1).addPlayer(new player(3 ,5 ,8 ,3 ,3 ,8 ,9 ,7 ,7 ,7 ,5 ,8 ,"Small Forward #114", false));
	teams.get(1).addPlayer(new player(2 ,5 ,9 ,2 ,2 ,3 ,10 ,8 ,8 ,2 ,5 ,5 ,"Chip Hancock", false));
	teams.get(1).addPlayer(new player(5 ,5 ,4 ,9 ,9 ,5 ,4 ,7 ,4 ,6 ,5 ,5 ,"Nasi Pindaiabu", false));
	teams.get(1).addPlayer(new player(5 ,4 ,3 ,10 ,10 ,8 ,7 ,6 ,1 ,7 ,7 ,7 ,"Gerard Mortlock", false));
	teams.get(1).addPlayer(new player(1 ,10 ,9 ,2 ,2 ,1 ,8 ,2 ,8 ,4 ,5 ,5 ,"Peika Baisoŋa", false));
	teams.get(1).addPlayer(new player(1 ,8 ,7 ,1 ,1 ,3 ,10 ,3 ,8 ,6 ,5 ,5 ,"Qili Kedi", false));
	teams.get(1).addPlayer(new player(4 ,6 ,2 ,10 ,10 ,4 ,8 ,6 ,3 ,6 ,5 ,7 ,"Taneba Nole", false));
	teams.get(1).addPlayer(new player(4 ,2 ,4 ,9 ,9 ,5 ,5 ,6 ,1 ,3 ,5 ,10 ,"Tuk Kauqepei", false));
	teams.add(new team("Calto Cows"));
	teams.get(2).addPlayer(new player(1 ,10 ,4 ,6 ,6 ,8 ,8 ,10 ,8 ,7 ,5 ,8 ,"vo", true));
	teams.get(2).addPlayer(new player(2 ,10 ,8 ,6 ,3 ,5 ,10 ,10 ,12 ,10 ,5 ,9 ,"Trevor Oosterhout", true));
	teams.get(2).addPlayer(new player(3 ,8 ,3 ,7 ,7 ,7 ,10 ,10 ,9 ,8 ,5 ,6 ,"Asher Turner", true));
	teams.get(2).addPlayer(new player(4 ,6 ,3 ,10 ,10 ,6 ,10 ,7 ,2 ,9 ,5 ,5 ,"Selby Schneiders", true));
	teams.get(2).addPlayer(new player(5 ,6 ,2 ,10 ,10 ,9 ,9 ,8 ,1 ,9 ,5 ,7 ,"Its'a Lełqutyi", true));
	teams.get(2).addPlayer(new player(1 ,7 ,8 ,4 ,4 ,6 ,8 ,7 ,9 ,6 ,5 ,7 ,"Alukeili Asoertotrisei", false));
	teams.get(2).addPlayer(new player(5 ,7 ,5 ,8 ,8 ,10 ,7 ,7 ,4 ,8 ,5 ,8 ,"Michael Barnett", false));
	teams.get(2).addPlayer(new player(2 ,3 ,8 ,2 ,2 ,4 ,10 ,6 ,8 ,7 ,5 ,8 ,"Bongatar Player #5", false));
	teams.get(2).addPlayer(new player(2 ,10 ,10 ,4 ,4 ,5 ,4 ,3 ,9 ,6 ,5 ,6 ,"Uozumi Izo", false));
	teams.get(2).addPlayer(new player(3 ,3 ,8 ,9 ,9 ,7 ,8 ,8 ,7 ,6 ,5 ,5 ,"Dalton Ariesen", false));
	teams.get(2).addPlayer(new player(3 ,1 ,9 ,5 ,5 ,4 ,4 ,8 ,9 ,9 ,5 ,8 ,"guz", false));
	teams.get(2).addPlayer(new player(4 ,4 ,2 ,7 ,7 ,5 ,10 ,8 ,4 ,7 ,5 ,6 ,"Seong-Hyeon Moon", false));
	teams.get(2).addPlayer(new player(4 ,7 ,3 ,10 ,10 ,5 ,7 ,5 ,1 ,8 ,5 ,10 ,"Yuguchi Sofu", false));
	teams.get(2).addPlayer(new player(1 ,10 ,7 ,3 ,1 ,4 ,7 ,6 ,8 ,7 ,5 ,5 ,"Yoade Perch", false));
	teams.get(2).addPlayer(new player(5 ,5 ,3 ,9 ,9 ,7 ,6 ,8 ,3 ,6 ,1 ,8 ,"Xaisomboun Saengsavang", false));
	teams.add(new team("Height Sagua Cats"));
	teams.get(3).addPlayer(new player(1 ,8 ,7 ,6 ,6 ,3 ,7 ,7 ,6 ,5 ,5 ,8 ,"Red Rainbow Player #3", true));
	teams.get(3).addPlayer(new player(2 ,7 ,9 ,6 ,6 ,6 ,6 ,8 ,10 ,6 ,5 ,6 ,"Hvanne Takakazu", true));
	teams.get(3).addPlayer(new player(3 ,8 ,10 ,7 ,7 ,6 ,5 ,6 ,8 ,9 ,5 ,8 ,"Height Sagua Player #3", true));
	teams.get(3).addPlayer(new player(4 ,7 ,3 ,9 ,9 ,7 ,6 ,8 ,4 ,8 ,5 ,10 ,"Sova Kłó", true));
	teams.get(3).addPlayer(new player(5 ,5 ,8 ,7 ,7 ,10 ,7 ,6 ,6 ,7 ,5 ,8 ,"Laurence Chandler", true));
	teams.get(3).addPlayer(new player(5 ,5 ,8 ,6 ,7 ,9 ,10 ,9 ,3 ,8 ,2 ,7 ,"No Kwang-Jo", false));
	teams.get(3).addPlayer(new player(2 ,9 ,8 ,3 ,4 ,3 ,5 ,4 ,9 ,3 ,10 ,9 ,"Autanblanaix Sovkol", false));
	teams.get(3).addPlayer(new player(1 ,6 ,10 ,4 ,3 ,4 ,6 ,10 ,7 ,4 ,5 ,9 ,"Naxnoxsoya Liksov", false));
	teams.get(3).addPlayer(new player(5 ,1 ,4 ,9 ,9 ,6 ,8 ,5 ,3 ,5 ,5 ,10 ,"Height Sagua Player #2", false));
	teams.get(3).addPlayer(new player(4 ,1 ,3 ,8 ,8 ,7 ,5 ,8 ,1 ,6 ,5 ,10 ,"Height Sagua Player #4", false));
	teams.get(3).addPlayer(new player(4 ,2 ,2 ,6 ,6 ,7 ,7 ,8 ,3 ,8 ,5 ,5 ,"Height Sagua Player #6", false));
	teams.get(3).addPlayer(new player(1 ,5 ,7 ,5 ,5 ,2 ,4 ,7 ,10 ,4 ,5 ,9 ,"Saiki Shunmyo", false));
	teams.get(3).addPlayer(new player(3 ,7 ,2 ,4 ,4 ,7 ,8 ,5 ,4 ,9 ,5 ,5 ,"Height Sagua Player #9", false));
	teams.get(3).addPlayer(new player(2 ,8 ,6 ,6 ,6 ,3 ,9 ,3 ,9 ,6 ,5 ,5 ,"Jumpe", false));
	teams.get(3).addPlayer(new player(3 ,7 ,7 ,8 ,8 ,7 ,2 ,5 ,4 ,4 ,5 ,8 ,"Small Forward #152", false));
	teams.add(new team("Key to Don Yees"));
	teams.get(4).addPlayer(new player(1 ,10 ,9 ,6 ,6 ,5 ,6 ,5 ,10 ,6 ,5 ,8 ,"Gerard Holzer", true));
	teams.get(4).addPlayer(new player(2 ,9 ,8 ,5 ,5 ,4 ,5 ,6 ,7 ,7 ,5 ,9 ,"Kapel Hilo", true));
	teams.get(4).addPlayer(new player(3 ,10 ,6 ,10 ,5 ,8 ,9 ,10 ,7 ,9 ,5 ,10 ,"Litsaw Wap't'ebw", true));
	teams.get(4).addPlayer(new player(4 ,3 ,2 ,9 ,9 ,7 ,8 ,4 ,1 ,7 ,5 ,9 ,"Key To Don Player #3", true));
	teams.get(4).addPlayer(new player(5 ,6 ,2 ,5 ,5 ,10 ,7 ,7 ,4 ,6 ,1 ,7 ,"Kaliso Hatemosei", true));
	teams.get(4).addPlayer(new player(3 ,7 ,4 ,7 ,7 ,1 ,8 ,6 ,4 ,4 ,5 ,8 ,"Blalikki Tanpratia", false));
	teams.get(4).addPlayer(new player(1 ,10 ,8 ,3 ,3 ,5 ,7 ,1 ,7 ,7 ,5 ,8 ,"Key To Don Player #2", false));
	teams.get(4).addPlayer(new player(1 ,6 ,7 ,4 ,4 ,3 ,10 ,8 ,5 ,1 ,5 ,7 ,"Grant Pool", false));
	teams.get(4).addPlayer(new player(4 ,5 ,3 ,9 ,8 ,7 ,7 ,6 ,1 ,6 ,7 ,6 ,"Alomibamobei Olalomundi", false));
	teams.get(4).addPlayer(new player(2 ,4 ,10 ,6 ,6 ,4 ,3 ,5 ,9 ,5 ,5 ,10 ,"Key To Don Player #5", false));
	teams.get(4).addPlayer(new player(2 ,8 ,4 ,1 ,1 ,3 ,10 ,7 ,10 ,7 ,5 ,6 ,"Ethanthova Player #3", false));
	teams.get(4).addPlayer(new player(4 ,4 ,2 ,10 ,10 ,5 ,3 ,6 ,3 ,7 ,5 ,5 ,"Key To Don Player #7", false));
	teams.get(4).addPlayer(new player(3 ,6 ,7 ,6 ,6 ,7 ,4 ,7 ,4 ,2 ,5 ,8 ,"Key To Don Player #8", false));
	teams.get(4).addPlayer(new player(5 ,6 ,5 ,6 ,6 ,9 ,6 ,4 ,4 ,4 ,2 ,8 ,"Guvggillmào Nùx́iś", false));
	teams.get(4).addPlayer(new player(5 ,1 ,4 ,7 ,7 ,8 ,6 ,4 ,3 ,4 ,5 ,8 ,"Kimo Rattanvongsa", false));
	teams.add(new team("Manwx Saguans"));
	teams.get(5).addPlayer(new player(1 ,10 ,8 ,1 ,1 ,4 ,7 ,10 ,10 ,4 ,5 ,10 ,"Himi Azumamaro", true));
	teams.get(5).addPlayer(new player(2 ,8 ,9 ,6 ,6 ,5 ,3 ,6 ,10 ,7 ,5 ,10 ,"Eipe Hawo", true));
	teams.get(5).addPlayer(new player(3 ,8 ,10 ,7 ,7 ,5 ,6 ,7 ,8 ,9 ,5 ,8 ,"Rusty Harries", true));
	teams.get(5).addPlayer(new player(4 ,9 ,5 ,10 ,10 ,4 ,8 ,8 ,6 ,7 ,5 ,8 ,"Shooting Guard #102", true));
	teams.get(5).addPlayer(new player(5 ,7 ,5 ,6 ,10 ,10 ,8 ,7 ,4 ,7 ,5 ,6 ,"Xolin Hialerko", true));
	teams.get(5).addPlayer(new player(3 ,9 ,9 ,3 ,3 ,10 ,7 ,5 ,2 ,2 ,5 ,8 ,"Charlie", false));
	teams.get(5).addPlayer(new player(5 ,4 ,2 ,10 ,9 ,9 ,5 ,8 ,4 ,7 ,7 ,9 ,"Blalikki Kiixrit", false));
	teams.get(5).addPlayer(new player(1 ,6 ,8 ,3 ,3 ,5 ,5 ,10 ,7 ,2 ,5 ,5 ,"Fox", false));
	teams.get(5).addPlayer(new player(2 ,5 ,2 ,6 ,6 ,5 ,10 ,1 ,7 ,6 ,5 ,8 ,"George", false));
	teams.get(5).addPlayer(new player(1 ,6 ,10 ,1 ,1 ,1 ,9 ,8 ,5 ,3 ,5 ,8 ,"Center #101", false));
	teams.get(5).addPlayer(new player(5 ,5 ,3 ,7 ,7 ,7 ,7 ,5 ,4 ,10 ,5 ,5 ,"Item", false));
	teams.get(5).addPlayer(new player(4 ,4 ,6 ,6 ,10 ,5 ,7 ,7 ,4 ,9 ,10 ,10 ,"Ok Yeong-Jin", false));
	teams.get(5).addPlayer(new player(2 ,10 ,1 ,1 ,1 ,3 ,7 ,8 ,9 ,10 ,5 ,7 ,"Kiromi Kersidomobek", false));
	teams.get(5).addPlayer(new player(4 ,7 ,3 ,10 ,10 ,7 ,7 ,5 ,3 ,5 ,5 ,5 ,"Sitwa Luvepiri", false));
	teams.get(5).addPlayer(new player(3 ,4 ,5 ,8 ,8 ,7 ,6 ,5 ,4 ,6 ,5 ,6 ,"Pezi Vuki", false));
	teams.add(new team("Sagua Ocelots"));
	teams.get(6).addPlayer(new player(1 ,9 ,4 ,3 ,3 ,1 ,10 ,10 ,13 ,7 ,5 ,8 ,"Colin Hutchison", true));
	teams.get(6).addPlayer(new player(2 ,10 ,9 ,3 ,3 ,3 ,6 ,4 ,10 ,4 ,5 ,10 ,"Mawatari Kane", true));
	teams.get(6).addPlayer(new player(3 ,8 ,8 ,9 ,3 ,4 ,6 ,9 ,9 ,10 ,5 ,5 ,"Mavótáfika Vilikó", true));
	teams.get(6).addPlayer(new player(4 ,7 ,1 ,10 ,8 ,7 ,10 ,8 ,4 ,6 ,5 ,6 ,"Sagua Player #2", true));
	teams.get(6).addPlayer(new player(5 ,4 ,4 ,9 ,9 ,5 ,8 ,4 ,3 ,7 ,5 ,5 ,"Sagua Player #6", true));
	teams.get(6).addPlayer(new player(2 ,9 ,3 ,5 ,5 ,3 ,5 ,3 ,10 ,4 ,5 ,7 ,"Biplatza Bitsekzeba", false));
	teams.get(6).addPlayer(new player(1 ,6 ,6 ,3 ,3 ,4 ,5 ,9 ,9 ,5 ,5 ,5 ,"Biplatza Ifet", false));
	teams.get(6).addPlayer(new player(4 ,3 ,1 ,8 ,8 ,6 ,8 ,7 ,3 ,3 ,5 ,5 ,"Holy Yektonesia Player #5", false));
	teams.get(6).addPlayer(new player(3 ,9 ,3 ,10 ,10 ,10 ,1 ,5 ,4 ,6 ,5 ,7 ,"Neville Spicer", false));
	teams.get(6).addPlayer(new player(5 ,4 ,4 ,5 ,5 ,10 ,7 ,8 ,5 ,4 ,5 ,6 ,"Danomobei Subeina", false));
	teams.get(6).addPlayer(new player(4 ,4 ,1 ,10 ,10 ,7 ,8 ,7 ,3 ,8 ,5 ,5 ,"Pwa Lefinu", false));
	teams.get(6).addPlayer(new player(3 ,5 ,2 ,10 ,7 ,5 ,7 ,8 ,2 ,8 ,5 ,9 ,"Alomibamobei Osadolsei", false));
	teams.get(6).addPlayer(new player(2 ,8 ,7 ,4 ,4 ,3 ,5 ,8 ,10 ,7 ,5 ,5 ,"The Moo Saχi", false));
	teams.get(6).addPlayer(new player(1 ,9 ,7 ,1 ,1 ,5 ,2 ,9 ,10 ,6 ,5 ,7 ,"Timblejoornay", false));
	teams.get(6).addPlayer(new player(5 ,2 ,3 ,8 ,8 ,7 ,7 ,7 ,4 ,8 ,5 ,8 ,"hex", false));
	teams.add(new team("Solea Geysers"));
	teams.get(7).addPlayer(new player(1 ,10 ,4 ,6 ,5 ,8 ,8 ,10 ,9 ,8 ,5 ,8 ,"Alomundi Bituna", true));
	teams.get(7).addPlayer(new player(2 ,7 ,10 ,7 ,5 ,6 ,7 ,8 ,9 ,10 ,5 ,7 ,"Hënila Ūnā", true));
	teams.get(7).addPlayer(new player(3 ,10 ,8 ,9 ,9 ,10 ,8 ,7 ,2 ,10 ,5 ,5 ,"Uelv Lganne", true));
	teams.get(7).addPlayer(new player(4 ,6 ,2 ,10 ,10 ,10 ,9 ,8 ,2 ,9 ,6 ,7 ,"voput epoikez tapnatiš", true));
	teams.get(7).addPlayer(new player(5 ,9 ,5 ,10 ,10 ,8 ,7 ,8 ,4 ,9 ,5 ,8 ,"Makiaipisi Fana", true));
	teams.get(7).addPlayer(new player(1 ,10 ,10 ,1 ,1 ,5 ,10 ,9 ,10 ,7 ,5 ,5 ,"Eric Newton", false));
	teams.get(7).addPlayer(new player(2 ,4 ,9 ,3 ,4 ,5 ,10 ,10 ,10 ,8 ,5 ,9 ,"Msenne Prai", false));
	teams.get(7).addPlayer(new player(3 ,4 ,7 ,10 ,10 ,6 ,8 ,7 ,5 ,8 ,5 ,7 ,"Aseqa Poi", false));
	teams.get(7).addPlayer(new player(4 ,5 ,2 ,9 ,9 ,5 ,8 ,7 ,2 ,9 ,5 ,5 ,"Zhali Mpetaec", false));
	teams.get(7).addPlayer(new player(5 ,2 ,8 ,7 ,7 ,10 ,7 ,8 ,4 ,7 ,5 ,10 ,"zeppak itehíl tikítákh", false));
	teams.get(7).addPlayer(new player(1 ,7 ,7 ,4 ,2 ,4 ,5 ,3 ,10 ,4 ,4 ,9 ,"Leilani Somphonpadee", false));
	teams.get(7).addPlayer(new player(2 ,8 ,8 ,4 ,4 ,3 ,6 ,3 ,8 ,7 ,5 ,7 ,"Aseqa Tituqu", false));
	teams.get(7).addPlayer(new player(4 ,5 ,4 ,9 ,10 ,6 ,6 ,5 ,2 ,6 ,7 ,10 ,"Murata Yoshifumi", false));
	teams.get(7).addPlayer(new player(5 ,3 ,3 ,9 ,9 ,5 ,8 ,6 ,2 ,7 ,5 ,8 ,"Namia Akaleta", false));
	teams.get(7).addPlayer(new player(3 ,1 ,9 ,3 ,4 ,9 ,7 ,9 ,4 ,5 ,1 ,10 ,"Xaisomboun Tayvihane", false));

	teams.add(new team("Autolik Autonomy"));
	teams.get(8).addPlayer(new player(1 ,10 ,7 ,1 ,1 ,3 ,9 ,8 ,8 ,5 ,7 ,7 ,"Boolway", true));
	teams.get(8).addPlayer(new player(2 ,7 ,7 ,4 ,4 ,4 ,10 ,3 ,8 ,5 ,5 ,10 ,"Nopá Kánpovragá", true));
	teams.get(8).addPlayer(new player(3 ,10 ,4 ,8 ,6 ,4 ,5 ,10 ,9 ,10 ,4 ,10 ,"Pakomha Pjagwazwi", true));
	teams.get(8).addPlayer(new player(4 ,4 ,3 ,8 ,8 ,8 ,7 ,7 ,3 ,7 ,7 ,7 ,"Keoki Vongsay", true));
	teams.get(8).addPlayer(new player(5 ,2 ,3 ,10 ,10 ,10 ,8 ,6 ,4 ,8 ,7 ,8 ,"enoikh apéka zeilun", true));
	teams.get(8).addPlayer(new player(3 ,9 ,3 ,10 ,10 ,4 ,4 ,6 ,10 ,8 ,10 ,8 ,"Nopá Nonhkwaqan", false));
	teams.get(8).addPlayer(new player(3 ,9 ,6 ,6 ,6 ,4 ,1 ,1 ,7 ,6 ,5 ,5 ,"Autolik Player #11", false));
	teams.get(8).addPlayer(new player(4 ,5 ,5 ,7 ,7 ,6 ,5 ,6 ,3 ,10 ,4 ,8 ,"Ikaika Kethavongsa", false));
	teams.get(8).addPlayer(new player(1 ,10 ,8 ,2 ,2 ,3 ,8 ,5 ,6 ,3 ,5 ,5 ,"Autolik Player #5", false));
	teams.get(8).addPlayer(new player(1 ,9 ,9 ,1 ,1 ,1 ,7 ,8 ,6 ,6 ,5 ,5 ,"Autolik Player #7", false));
	teams.get(8).addPlayer(new player(2 ,8 ,10 ,1 ,1 ,3 ,6 ,6 ,9 ,6 ,5 ,5 ,"Atotra Bexek", false));
	teams.get(8).addPlayer(new player(5 ,5 ,4 ,6 ,7 ,9 ,3 ,8 ,1 ,5 ,1 ,7 ,"Ḿavwápŕi Makŕavamhan", false));
	teams.get(8).addPlayer(new player(5 ,7 ,7 ,4 ,4 ,7 ,5 ,5 ,7 ,5 ,5 ,9 ,"Kamil Harris", false));
	teams.get(8).addPlayer(new player(4 ,2 ,4 ,10 ,10 ,4 ,5 ,7 ,4 ,3 ,5 ,5 ,"Mornay", false));
	teams.get(8).addPlayer(new player(2 ,10 ,10 ,5 ,5 ,2 ,5 ,6 ,8 ,3 ,5 ,5 ,"William Fudge", false));
	teams.add(new team("Barsein Bats"));
	teams.get(9).addPlayer(new player(1 ,9 ,9 ,2 ,2 ,1 ,10 ,6 ,10 ,5 ,5 ,6 ,"Keon Saengsavang", true));
	teams.get(9).addPlayer(new player(2 ,9 ,7 ,3 ,5 ,6 ,8 ,7 ,8 ,9 ,5 ,7 ,"Keahi Saengsavang", true));
	teams.get(9).addPlayer(new player(3 ,3 ,8 ,9 ,9 ,7 ,8 ,8 ,7 ,6 ,5 ,9 ,"Matthew Grabochov", true));
	teams.get(9).addPlayer(new player(4 ,8 ,5 ,9 ,7 ,8 ,6 ,5 ,4 ,10 ,5 ,10 ,"pot", true));
	teams.get(9).addPlayer(new player(5 ,4 ,4 ,5 ,5 ,10 ,10 ,10 ,5 ,4 ,5 ,6 ,"Danomobei Subeina", true));
	teams.get(9).addPlayer(new player(2 ,7 ,6 ,2 ,2 ,3 ,8 ,5 ,6 ,7 ,5 ,8 ,"Barsein Player #3", false));
	teams.get(9).addPlayer(new player(2 ,9 ,6 ,6 ,2 ,5 ,4 ,5 ,10 ,8 ,4 ,5 ,"Quinten Grabochov", false));
	teams.get(9).addPlayer(new player(4 ,7 ,3 ,6 ,6 ,7 ,9 ,8 ,4 ,6 ,5 ,6 ,"Barsein Player #1", false));
	teams.get(9).addPlayer(new player(1 ,6 ,6 ,3 ,2 ,2 ,7 ,10 ,8 ,7 ,9 ,6 ,"Yembeane", false));
	teams.get(9).addPlayer(new player(3 ,8 ,4 ,9 ,9 ,2 ,4 ,4 ,8 ,1 ,5 ,10 ,"Barsein Player #7", false));
	teams.get(9).addPlayer(new player(1 ,8 ,2 ,5 ,5 ,1 ,10 ,3 ,9 ,6 ,5 ,5 ,"kalassak vekel álutep", false));
	teams.get(9).addPlayer(new player(5 ,3 ,3 ,8 ,10 ,6 ,5 ,5 ,5 ,9 ,5 ,7 ,"Keahi Siyavong", false));
	teams.get(9).addPlayer(new player(5 ,3 ,1 ,10 ,10 ,5 ,8 ,4 ,4 ,4 ,5 ,7 ,"Dimitri Lolant", false));
	teams.get(9).addPlayer(new player(3 ,5 ,4 ,9 ,9 ,4 ,3 ,6 ,5 ,7 ,5 ,8 ,"Om Kwang-Seok", false));
	teams.get(9).addPlayer(new player(4 ,6 ,2 ,6 ,6 ,6 ,8 ,7 ,2 ,9 ,5 ,6 ,"Yuguchi Tomiji", false));
	teams.add(new team("Blanaxon Hammers"));
	teams.get(10).addPlayer(new player(1 ,9 ,8 ,3 ,3 ,4 ,9 ,4 ,8 ,5 ,5 ,10 ,"Blanaxon Player #1", true));
	teams.get(10).addPlayer(new player(2 ,5 ,5 ,6 ,6 ,2 ,10 ,6 ,9 ,5 ,5 ,7 ,"Blanaxon Player #3", true));
	teams.get(10).addPlayer(new player(3 ,9 ,5 ,6 ,6 ,10 ,3 ,10 ,10 ,8 ,5 ,8 ,"Nobira Nariaki", true));
	teams.get(10).addPlayer(new player(4 ,3 ,3 ,10 ,8 ,8 ,7 ,8 ,4 ,10 ,8 ,5 ,"Brian Lolant", true));
	teams.get(10).addPlayer(new player(5 ,1 ,3 ,8 ,8 ,9 ,5 ,6 ,4 ,10 ,5 ,8 ,"Baker", true));
	teams.get(10).addPlayer(new player(4 ,2 ,3 ,9 ,9 ,4 ,5 ,5 ,4 ,10 ,5 ,10 ,"Edgar Fichtner", false));
	teams.get(10).addPlayer(new player(3 ,9 ,8 ,1 ,1 ,3 ,10 ,6 ,9 ,7 ,7 ,6 ,"Autolik Player #4", false));
	teams.get(10).addPlayer(new player(4 ,5 ,1 ,7 ,7 ,4 ,8 ,7 ,4 ,6 ,5 ,5 ,"Blanaxon Player #6", false));
	teams.get(10).addPlayer(new player(5 ,5 ,4 ,7 ,6 ,10 ,8 ,5 ,6 ,7 ,4 ,6 ,"Versi Alovek", false));
	teams.get(10).addPlayer(new player(5 ,4 ,5 ,6 ,5 ,9 ,6 ,4 ,3 ,8 ,5 ,8 ,"Ikaika Phomsouvanh", false));
	teams.get(10).addPlayer(new player(3 ,2 ,9 ,3 ,2 ,5 ,5 ,6 ,6 ,10 ,8 ,9 ,"Chu Chin-Ho", false));
	teams.get(10).addPlayer(new player(1 ,7 ,6 ,7 ,8 ,4 ,6 ,4 ,8 ,8 ,5 ,7 ,"Bob Gagodo", false));
	teams.get(10).addPlayer(new player(2 ,4 ,5 ,4 ,4 ,6 ,8 ,5 ,9 ,4 ,5 ,9 ,"Iggy Bolter", false));
	teams.get(10).addPlayer(new player(2 ,8 ,4 ,3 ,3 ,1 ,7 ,7 ,9 ,7 ,5 ,5 ,"TND Player #7", false));
	teams.get(10).addPlayer(new player(1 ,9 ,9 ,3 ,3 ,3 ,6 ,5 ,9 ,3 ,5 ,6 ,"Mungymia", false));
	teams.add(new team("Kaeshar Kaisers"));
	teams.get(11).addPlayer(new player(1 ,9 ,10 ,3 ,2 ,5 ,6 ,9 ,10 ,5 ,6 ,9 ,"Lilo Vatthana", true));
	teams.get(11).addPlayer(new player(2 ,10 ,6 ,6 ,6 ,3 ,10 ,5 ,7 ,7 ,5 ,7 ,"Pxalit'k'a Player #6", true));
	teams.get(11).addPlayer(new player(3 ,1 ,2 ,8 ,4 ,10 ,8 ,6 ,9 ,9 ,5 ,10 ,"Key To Don Player #4", true));
	teams.get(11).addPlayer(new player(4 ,5 ,4 ,8 ,8 ,6 ,7 ,9 ,2 ,10 ,5 ,8 ,"Akamine Naizen", true));
	teams.get(11).addPlayer(new player(5 ,6 ,4 ,7 ,6 ,9 ,7 ,4 ,5 ,8 ,9 ,7 ,"Carlos Harris", true));
	teams.get(11).addPlayer(new player(5 ,5 ,4 ,8 ,8 ,7 ,4 ,4 ,3 ,7 ,5 ,8 ,"Pxalit'k'a Player #2", false));
	teams.get(11).addPlayer(new player(1 ,10 ,9 ,2 ,2 ,3 ,6 ,5 ,8 ,7 ,5 ,10 ,"Boltway Player #1", false));
	teams.get(11).addPlayer(new player(4 ,8 ,3 ,10 ,10 ,5 ,6 ,5 ,3 ,10 ,5 ,5 ,"Xavier McSteve", false));
	teams.get(11).addPlayer(new player(3 ,1 ,1 ,9 ,6 ,8 ,4 ,8 ,9 ,10 ,10 ,6 ,"Sol Song-Jin", false));
	teams.get(11).addPlayer(new player(5 ,5 ,1 ,9 ,9 ,8 ,8 ,6 ,2 ,6 ,5 ,5 ,"Pxalit'k'a Player #7", false));
	teams.get(11).addPlayer(new player(4 ,3 ,2 ,9 ,9 ,7 ,2 ,4 ,4 ,7 ,5 ,9 ,"Pxalit'k'a Player #8", false));
	teams.get(11).addPlayer(new player(1 ,10 ,9 ,2 ,2 ,3 ,6 ,5 ,8 ,7 ,5 ,10 ,"Boltway Player #1", false));
	teams.get(11).addPlayer(new player(3 ,5 ,2 ,8 ,8 ,6 ,6 ,6 ,5 ,8 ,5 ,8 ,"Swanano Nonhkwaqan", false));
	teams.get(11).addPlayer(new player(2 ,9 ,8 ,4 ,4 ,3 ,3 ,9 ,7 ,4 ,5 ,7 ,"Tansov Liksov", false));
	teams.get(11).addPlayer(new player(2 ,8 ,5 ,4 ,4 ,5 ,5 ,7 ,8 ,10 ,5 ,10 ,"Uxnax Prokexov", false));
	teams.add(new team("Naxda Nomads"));
	teams.get(12).addPlayer(new player(1 ,5 ,10 ,2 ,2 ,4 ,9 ,5 ,10 ,4 ,5 ,6 ,"Height Sagua Player #5", true));
	teams.get(12).addPlayer(new player(2 ,4 ,10 ,4 ,4 ,4 ,6 ,6 ,9 ,6 ,5 ,10 ,"Pitro Tenopro", true));
	teams.get(12).addPlayer(new player(3 ,7 ,4 ,3 ,4 ,6 ,10 ,9 ,6 ,9 ,8 ,8 ,"Maik Phothisarath", true));
	teams.get(12).addPlayer(new player(4 ,8 ,3 ,9 ,9 ,8 ,8 ,7 ,1 ,8 ,5 ,6 ,"Tixen Prokol", true));
	teams.get(12).addPlayer(new player(5 ,7 ,3 ,9 ,9 ,10 ,6 ,5 ,3 ,10 ,5 ,5 ,"Alomundi Gagolomundi", true));
	teams.get(12).addPlayer(new player(5 ,6 ,4 ,8 ,8 ,5 ,5 ,5 ,3 ,7 ,5 ,10 ,"Barsein Player #2", false));
	teams.get(12).addPlayer(new player(3 ,5 ,3 ,7 ,7 ,6 ,7 ,7 ,5 ,9 ,5 ,8 ,"Small Forward #143", false));
	teams.get(12).addPlayer(new player(4 ,6 ,2 ,8 ,8 ,6 ,5 ,8 ,1 ,1 ,5 ,5 ,"Darkon Piklo", false));
	teams.get(12).addPlayer(new player(1 ,7 ,10 ,4 ,3 ,3 ,4 ,6 ,8 ,5 ,8 ,10 ,"Yamataka Sadaharu", false));
	teams.get(12).addPlayer(new player(1 ,10 ,7 ,2 ,2 ,6 ,5 ,6 ,6 ,5 ,5 ,5 ,"Malo Sengtavisouk", false));
	teams.get(12).addPlayer(new player(5 ,3 ,3 ,9 ,9 ,5 ,8 ,6 ,2 ,7 ,5 ,5 ,"Lizaxon Rova", false));
	teams.get(12).addPlayer(new player(3 ,10 ,4 ,1 ,1 ,8 ,8 ,9 ,1 ,5 ,5 ,7 ,"Blaxanon Bonits", false));
	teams.get(12).addPlayer(new player(2 ,7 ,7 ,4 ,4 ,4 ,6 ,5 ,7 ,5 ,5 ,6 ,"Power Forward #164", false));
	teams.get(12).addPlayer(new player(4 ,2 ,3 ,7 ,7 ,6 ,6 ,5 ,1 ,7 ,5 ,9 ,"Pŋševa Ke'una", false));
	teams.get(12).addPlayer(new player(2 ,8 ,6 ,5 ,5 ,3 ,9 ,1 ,8 ,3 ,5 ,6 ,"Rizaxon Klegna", false));
	teams.add(new team("Red Rainbow Sickles"));
	teams.get(13).addPlayer(new player(1 ,9 ,8 ,4 ,4 ,6 ,10 ,7 ,7 ,7 ,10 ,5 ,"Caleb Jervis", true));
	teams.get(13).addPlayer(new player(2 ,9 ,10 ,7 ,5 ,5 ,8 ,6 ,7 ,6 ,7 ,10 ,"Cabodu Kanix", true));
	teams.get(13).addPlayer(new player(3 ,6 ,10 ,9 ,9 ,7 ,7 ,5 ,10 ,7 ,10 ,10 ,"Red Rainbow Player #1", true));
	teams.get(13).addPlayer(new player(4 ,4 ,4 ,8 ,8 ,6 ,9 ,6 ,2 ,9 ,5 ,7 ,"Palani Phomsouvanh", true));
	teams.get(13).addPlayer(new player(5 ,5 ,5 ,10 ,8 ,8 ,5 ,8 ,1 ,10 ,5 ,6 ,"Dano Mesiaertoxek", true));
	teams.get(13).addPlayer(new player(5 ,3 ,3 ,10 ,10 ,7 ,4 ,3 ,1 ,5 ,5 ,9 ,"Atotra Danomane", false));
	teams.get(13).addPlayer(new player(4 ,2 ,4 ,10 ,10 ,4 ,5 ,7 ,4 ,6 ,5 ,10 ,"Sagua Player #3", false));
	teams.get(13).addPlayer(new player(5 ,4 ,3 ,3 ,3 ,8 ,8 ,6 ,3 ,6 ,5 ,10 ,"Autolik Player #3", false));
	teams.get(13).addPlayer(new player(2 ,4 ,5 ,5 ,5 ,4 ,3 ,7 ,9 ,5 ,5 ,5 ,"Red Rainbow Player #10", false));
	teams.get(13).addPlayer(new player(3 ,6 ,5 ,9 ,10 ,2 ,6 ,7 ,10 ,7 ,3 ,5 ,"Murata Sofu", false));
	teams.get(13).addPlayer(new player(2 ,7 ,4 ,6 ,6 ,1 ,8 ,6 ,6 ,5 ,5 ,9 ,"Red Rainbow Player #4", false));
	teams.get(13).addPlayer(new player(4 ,6 ,2 ,8 ,8 ,7 ,2 ,2 ,4 ,7 ,5 ,8 ,"Red Rainbow Player #6", false));
	teams.get(13).addPlayer(new player(1 ,7 ,7 ,3 ,3 ,5 ,7 ,4 ,8 ,2 ,5 ,5 ,"Red Rainbow Player #7", false));
	teams.get(13).addPlayer(new player(3 ,8 ,7 ,5 ,5 ,10 ,1 ,2 ,2 ,10 ,5 ,7 ,"Red Rainbow Player #8", false));
	teams.get(13).addPlayer(new player(1 ,8 ,8 ,3 ,1 ,4 ,4 ,6 ,7 ,5 ,2 ,9 ,"Métro Sanraku", false));
	teams.add(new team("Serkr Atolls"));
	teams.get(14).addPlayer(new player(1 ,8 ,4 ,4 ,4 ,5 ,10 ,9 ,5 ,6 ,5 ,10 ,"Vrá Nonhkwaqan", true));
	teams.get(14).addPlayer(new player(2 ,9 ,3 ,9 ,9 ,8 ,8 ,8 ,4 ,10 ,5 ,6 ,"Moke Douangvily", true));
	teams.get(14).addPlayer(new player(3 ,9 ,10 ,10 ,5 ,9 ,10 ,9 ,10 ,10 ,5 ,8 ,"Klaxon Nixoka", true));
	teams.get(14).addPlayer(new player(4 ,6 ,2 ,10 ,10 ,7 ,9 ,8 ,2 ,9 ,5 ,5 ,"Danomobei Motxev", true));
	teams.get(14).addPlayer(new player(5 ,6 ,2 ,10 ,10 ,10 ,10 ,6 ,4 ,6 ,5 ,9 ,"Transhilmalia Player #2", true));
	teams.get(14).addPlayer(new player(5 ,3 ,5 ,9 ,10 ,9 ,6 ,4 ,1 ,8 ,2 ,10 ,"Nathaniel Bate", false));
	teams.get(14).addPlayer(new player(2 ,10 ,9 ,3 ,3 ,4 ,6 ,8 ,9 ,8 ,8 ,8 ,"Iveo Vokigei", false));
	teams.get(14).addPlayer(new player(4 ,7 ,1 ,9 ,9 ,5 ,8 ,7 ,2 ,8 ,5 ,7 ,"Niko Stengel", false));
	teams.get(14).addPlayer(new player(3 ,10 ,8 ,9 ,9 ,5 ,8 ,4 ,7 ,7 ,5 ,7 ,"K'ita Senako", false));
	teams.get(14).addPlayer(new player(4 ,4 ,4 ,8 ,8 ,6 ,5 ,7 ,4 ,7 ,5 ,8 ,"Nupa Auprat", false));
	teams.get(14).addPlayer(new player(3 ,4 ,10 ,7 ,7 ,4 ,4 ,8 ,3 ,7 ,5 ,6 ,"Pergo Elomosei", false));
	teams.get(14).addPlayer(new player(5 ,3 ,5 ,8 ,10 ,10 ,7 ,5 ,3 ,7 ,10 ,10 ,"Pakomha Dakómh", false));
	teams.get(14).addPlayer(new player(1 ,10 ,6 ,2 ,2 ,4 ,10 ,1 ,8 ,7 ,5 ,8 ,"Om \"Joakim\" Kwang-Jo", false));
	teams.get(14).addPlayer(new player(2 ,9 ,8 ,6 ,6 ,5 ,4 ,4 ,7 ,7 ,5 ,10 ,"Dimitri Ebron", false));
	teams.get(14).addPlayer(new player(1 ,5 ,9 ,5 ,3 ,4 ,4 ,9 ,9 ,7 ,6 ,7 ,"Teva Gekxakŋi", false));
	teams.add(new team("Shmupland Dictators"));
	teams.get(15).addPlayer(new player(1 ,8 ,3 ,5 ,5 ,3 ,7 ,8 ,9 ,6 ,5 ,6 ,"Power Forward #166", true));
	teams.get(15).addPlayer(new player(2 ,8 ,9 ,4 ,2 ,3 ,7 ,8 ,8 ,8 ,9 ,9 ,"Kibibei Hatemosei", true));
	teams.get(15).addPlayer(new player(3 ,8 ,5 ,10 ,10 ,10 ,7 ,7 ,5 ,6 ,5 ,7 ,"Eun Cho", true));
	teams.get(15).addPlayer(new player(4 ,5 ,9 ,9 ,9 ,5 ,7 ,6 ,4 ,10 ,4 ,7 ,"Steve Sho", true));
	teams.get(15).addPlayer(new player(5 ,4 ,3 ,7 ,7 ,10 ,8 ,8 ,2 ,10 ,5 ,6 ,"Billingulbut", true));
	teams.get(15).addPlayer(new player(2 ,10 ,2 ,4 ,4 ,5 ,6 ,7 ,6 ,5 ,5 ,8 ,"Power Forward #151", false));
	teams.get(15).addPlayer(new player(5 ,6 ,5 ,5 ,5 ,8 ,3 ,5 ,3 ,7 ,5 ,7 ,"Fletcher Templeton", false));
	teams.get(15).addPlayer(new player(4 ,5 ,2 ,8 ,8 ,4 ,2 ,8 ,2 ,8 ,5 ,9 ,"Carlos Garber", false));
	teams.get(15).addPlayer(new player(5 ,1 ,4 ,10 ,10 ,8 ,8 ,3 ,4 ,3 ,5 ,5 ,"Ji-Min Choi", false));
	teams.get(15).addPlayer(new player(1 ,7 ,5 ,2 ,2 ,5 ,9 ,1 ,6 ,6 ,5 ,8 ,"Joon-Ho Jo", false));
	teams.get(15).addPlayer(new player(4 ,6 ,1 ,6 ,6 ,7 ,9 ,6 ,3 ,7 ,5 ,6 ,"Aiyota Player #3", false));
	teams.get(15).addPlayer(new player(3 ,5 ,4 ,8 ,8 ,9 ,6 ,4 ,5 ,3 ,5 ,6 ,"Malo Sayasone", false));
	teams.get(15).addPlayer(new player(1 ,4 ,5 ,3 ,3 ,2 ,1 ,9 ,6 ,5 ,5 ,10 ,"Su-Bin Lee", false));
	teams.get(15).addPlayer(new player(3 ,7 ,7 ,7 ,7 ,1 ,6 ,5 ,7 ,5 ,5 ,9 ,"Sung-Soo Song", false));
	teams.get(15).addPlayer(new player(2 ,8 ,7 ,4 ,4 ,5 ,4 ,7 ,10 ,5 ,5 ,6 ,"Zax Kaxpa", false));

	teams.add(new team("Aiyota Pumps"));
	teams.get(16).addPlayer(new player(1 ,10 ,9 ,4 ,4 ,6 ,8 ,9 ,7 ,7 ,5 ,7 ,"Kardo Cows", true));
	teams.get(16).addPlayer(new player(2 ,8 ,4 ,3 ,3 ,8 ,10 ,9 ,9 ,5 ,5 ,8 ,"Hevek Gagomos", true));
	teams.get(16).addPlayer(new player(3 ,4 ,5 ,9 ,9 ,8 ,9 ,8 ,7 ,6 ,5 ,10 ,"Aiyota Player #5", true));
	teams.get(16).addPlayer(new player(4 ,4 ,2 ,9 ,9 ,10 ,7 ,9 ,1 ,9 ,5 ,10 ,"San Holo", true));
	teams.get(16).addPlayer(new player(5 ,5 ,3 ,8 ,8 ,11 ,4 ,7 ,4 ,6 ,5 ,10 ,"Aiyota Player #2", true));
	teams.get(16).addPlayer(new player(1 ,8 ,9 ,1 ,1 ,1 ,10 ,6 ,7 ,6 ,5 ,7 ,"Aiyota Player #1", false));
	teams.get(16).addPlayer(new player(5 ,4 ,5 ,6 ,7 ,10 ,8 ,5 ,4 ,7 ,10 ,8 ,"Olandi Olamos", false));
	teams.get(16).addPlayer(new player(4 ,4 ,2 ,9 ,9 ,6 ,6 ,1 ,1 ,5 ,5 ,5 ,"Aiyota Player #12", false));
	teams.get(16).addPlayer(new player(2 ,9 ,6 ,5 ,4 ,5 ,6 ,6 ,9 ,4 ,3 ,9 ,"Günther Umlauf", false));
	teams.get(16).addPlayer(new player(3 ,5 ,5 ,6 ,6 ,8 ,7 ,1 ,2 ,8 ,5 ,10 ,"Aiyota Player #6", false));
	teams.get(16).addPlayer(new player(5 ,5 ,5 ,7 ,6 ,7 ,4 ,8 ,10 ,6 ,6 ,9 ,"Niclas Unterberger", false));
	teams.get(16).addPlayer(new player(1 ,7 ,6 ,1 ,1 ,5 ,7 ,8 ,6 ,2 ,5 ,6 ,"Bro McBeth", false));
	teams.get(16).addPlayer(new player(4 ,3 ,3 ,7 ,7 ,6 ,2 ,7 ,2 ,8 ,5 ,5 ,"Aiyota Player #9", false));
	teams.get(16).addPlayer(new player(2 ,7 ,6 ,5 ,5 ,6 ,3 ,2 ,7 ,5 ,5 ,8 ,"Amari Yakumo", false));
	teams.get(16).addPlayer(new player(3 ,5 ,6 ,5 ,5 ,7 ,5 ,6 ,7 ,4 ,5 ,8 ,"Small Forward #159", false));
	teams.add(new team("Ãvura Aviators"));
	teams.get(17).addPlayer(new player(1 ,7 ,9 ,5 ,2 ,4 ,7 ,8 ,8 ,8 ,2 ,8 ,"Omumiba Keget", true));
	teams.get(17).addPlayer(new player(2 ,10 ,3 ,6 ,6 ,4 ,8 ,7 ,8 ,8 ,5 ,8 ,"Tibiziŋag Ifet", true));
	teams.get(17).addPlayer(new player(3 ,9 ,9 ,5 ,6 ,9 ,8 ,8 ,8 ,7 ,9 ,7 ,"Kilik Farhje", true));
	teams.get(17).addPlayer(new player(4 ,4 ,2 ,9 ,9 ,10 ,7 ,6 ,4 ,8 ,5 ,7 ,"Floenne Zan", true));
	teams.get(17).addPlayer(new player(5 ,5 ,6 ,8 ,8 ,10 ,7 ,7 ,6 ,10 ,5 ,6 ,"b 9u", true));
	teams.get(17).addPlayer(new player(5 ,6 ,2 ,8 ,9 ,8 ,6 ,7 ,2 ,7 ,4 ,8 ,"Hannes Ehrenstein", false));
	teams.get(17).addPlayer(new player(3 ,8 ,6 ,7 ,7 ,6 ,6 ,5 ,4 ,6 ,5 ,8 ,"Ijba Bexotrugo", false));
	teams.get(17).addPlayer(new player(4 ,6 ,1 ,9 ,9 ,7 ,1 ,7 ,4 ,10 ,5 ,5 ,"Itso Bigo", false));
	teams.get(17).addPlayer(new player(2 ,8 ,4 ,4 ,4 ,4 ,8 ,7 ,7 ,6 ,7 ,8 ,"Autolik Player #1", false));
	teams.get(17).addPlayer(new player(5 ,4 ,4 ,4 ,4 ,8 ,8 ,4 ,3 ,6 ,5 ,6 ,"Blanaxon Player #7", false));
	teams.get(17).addPlayer(new player(1 ,7 ,5 ,4 ,4 ,2 ,1 ,8 ,10 ,3 ,5 ,8 ,"Sael Yen", false));
	teams.get(17).addPlayer(new player(1 ,10 ,6 ,2 ,2 ,3 ,1 ,8 ,8 ,3 ,5 ,5 ,"Sagobesei Alote", false));
	teams.get(17).addPlayer(new player(4 ,2 ,3 ,9 ,9 ,5 ,7 ,3 ,4 ,6 ,5 ,5 ,"Siolle Lago", false));
	teams.get(17).addPlayer(new player(2 ,5 ,3 ,6 ,6 ,2 ,9 ,4 ,9 ,6 ,5 ,5 ,"Sundaa Wen", false));
	teams.get(17).addPlayer(new player(3 ,8 ,1 ,5 ,5 ,10 ,7 ,10 ,7 ,7 ,5 ,10 ,"Sichaizei Sha", false));
	teams.add(new team("Boltway Bad Dragons"));
	teams.get(18).addPlayer(new player(1 ,9 ,8 ,3 ,3 ,2 ,8 ,10 ,6 ,5 ,5 ,6 ,"Bongatar Player #2", true));
	teams.get(18).addPlayer(new player(2 ,10 ,3 ,6 ,6 ,7 ,9 ,7 ,9 ,8 ,10 ,5 ,"Kosiro Omundi", true));
	teams.get(18).addPlayer(new player(3 ,7 ,5 ,10 ,6 ,7 ,6 ,9 ,5 ,5 ,5 ,10 ,"Boltway Player #2", true));
	teams.get(18).addPlayer(new player(4 ,7 ,2 ,10 ,10 ,7 ,5 ,8 ,2 ,10 ,5 ,5 ,"Boltway Player #3", true));
	teams.get(18).addPlayer(new player(5 ,5 ,3 ,8 ,8 ,10 ,4 ,7 ,4 ,6 ,5 ,8 ,"Paparto Subeina", true));
	teams.get(18).addPlayer(new player(5 ,1 ,3 ,8 ,8 ,7 ,5 ,8 ,1 ,6 ,5 ,8 ,"Nio Oipa", false));
	teams.get(18).addPlayer(new player(3 ,9 ,7 ,6 ,6 ,3 ,8 ,4 ,1 ,3 ,5 ,5 ,"Boltway Player #5", false));
	teams.get(18).addPlayer(new player(4 ,6 ,1 ,7 ,7 ,4 ,2 ,7 ,4 ,6 ,5 ,5 ,"Boltway Player #8", false));
	teams.get(18).addPlayer(new player(2 ,7 ,10 ,3 ,3 ,3 ,6 ,4 ,5 ,6 ,5 ,8 ,"Wilbert Fudge", false));
	teams.get(18).addPlayer(new player(4 ,6 ,5 ,9 ,6 ,7 ,7 ,5 ,3 ,10 ,9 ,10 ,"Robert Kershaw", false));
	teams.get(18).addPlayer(new player(1 ,10 ,5 ,3 ,3 ,4 ,4 ,7 ,7 ,7 ,5 ,6 ,"Pxalit'k'a Player #3", false));
	teams.get(18).addPlayer(new player(3 ,8 ,5 ,7 ,5 ,2 ,5 ,5 ,7 ,6 ,5 ,7 ,"Konrad Waldstein", false));
	teams.get(18).addPlayer(new player(1 ,7 ,8 ,2 ,2 ,3 ,6 ,8 ,8 ,4 ,5 ,5 ,"Andries Martinez", false));
	teams.get(18).addPlayer(new player(5 ,4 ,3 ,9 ,9 ,8 ,6 ,7 ,3 ,10 ,5 ,5 ,"vun", false));
	teams.get(18).addPlayer(new player(2 ,9 ,6 ,5 ,4 ,5 ,4 ,8 ,9 ,6 ,10 ,7 ,"Jonathan Wagenseil", false));
	teams.add(new team("Dotruga Falno"));
	teams.get(19).addPlayer(new player(1 ,7 ,8 ,1 ,1 ,2 ,9 ,9 ,8 ,7 ,5 ,5 ,"Osiei Bituna", true));
	teams.get(19).addPlayer(new player(2 ,10 ,3 ,8 ,8 ,6 ,8 ,9 ,10 ,9 ,5 ,10 ,"Atumobei Tute", true));
	teams.get(19).addPlayer(new player(3 ,7 ,9 ,10 ,10 ,10 ,10 ,10 ,8 ,10 ,5 ,9 ,"Atakri Kalauni", true));
	teams.get(19).addPlayer(new player(4 ,8 ,2 ,9 ,9 ,4 ,10 ,9 ,1 ,9 ,5 ,10 ,"Vanhik Slivókŕámhomhók", true));
	teams.get(19).addPlayer(new player(5 ,7 ,4 ,10 ,10 ,10 ,6 ,9 ,4 ,10 ,5 ,8 ,"Persa Mersa", true));
	teams.get(19).addPlayer(new player(1 ,7 ,6 ,4 ,3 ,2 ,4 ,8 ,10 ,6 ,8 ,9 ,"Dylan Cass", false));
	teams.get(19).addPlayer(new player(4 ,6 ,2 ,7 ,7 ,8 ,9 ,7 ,4 ,8 ,5 ,7 ,"Lato Naixi", false));
	teams.get(19).addPlayer(new player(2 ,10 ,8 ,5 ,4 ,3 ,5 ,6 ,8 ,3 ,2 ,7 ,"Keahi Bokeo", false));
	teams.get(19).addPlayer(new player(2 ,9 ,10 ,6 ,4 ,3 ,8 ,7 ,8 ,3 ,1 ,6 ,"Melebin Kixidodotsei", false));
	teams.get(19).addPlayer(new player(5 ,3 ,3 ,7 ,9 ,10 ,5 ,4 ,2 ,4 ,5 ,9 ,"Kaliso Alolundi", false));
	teams.get(19).addPlayer(new player(3 ,8 ,7 ,8 ,10 ,1 ,7 ,10 ,3 ,4 ,10 ,10 ,"Sovtanzax Uxyakro", false));
	teams.get(19).addPlayer(new player(1 ,8 ,5 ,5 ,5 ,3 ,6 ,4 ,9 ,8 ,5 ,6 ,"Kudapa Kaxpa", false));
	teams.get(19).addPlayer(new player(3 ,4 ,4 ,10 ,10 ,5 ,5 ,6 ,5 ,8 ,5 ,5 ,"Volker Kluck", false));
	teams.get(19).addPlayer(new player(4 ,3 ,2 ,9 ,9 ,4 ,1 ,6 ,1 ,10 ,5 ,9 ,"Pakomha Nhoñsła", false));
	teams.get(19).addPlayer(new player(5 ,6 ,6 ,6 ,10 ,8 ,7 ,4 ,2 ,5 ,10 ,9 ,"Phetdum Vongsay", false));
	teams.add(new team("Ethanthova Ponies"));
	teams.get(20).addPlayer(new player(1 ,5 ,9 ,2 ,2 ,5 ,10 ,5 ,10 ,6 ,5 ,6 ,"Ethanthova Player #4", true));
	teams.get(20).addPlayer(new player(2 ,8 ,4 ,1 ,1 ,3 ,10 ,7 ,10 ,7 ,5 ,6 ,"Ethanthova Player #3", true));
	teams.get(20).addPlayer(new player(3 ,6 ,4 ,8 ,8 ,8 ,10 ,7 ,8 ,6 ,5 ,8 ,"Ethanthova Player #5", true));
	teams.get(20).addPlayer(new player(4 ,7 ,4 ,10 ,10 ,7 ,8 ,6 ,4 ,7 ,5 ,6 ,"Fihana Jo", true));
	teams.get(20).addPlayer(new player(5 ,7 ,3 ,7 ,7 ,10 ,9 ,7 ,5 ,7 ,5 ,8 ,"Errol James", true));
	teams.get(20).addPlayer(new player(5 ,7 ,2 ,9 ,9 ,8 ,4 ,6 ,4 ,6 ,5 ,9 ,"Ixbla Kibla", false));
	teams.get(20).addPlayer(new player(4 ,3 ,2 ,6 ,6 ,6 ,6 ,8 ,1 ,10 ,5 ,5 ,"Ametsuchi Kamlyn", false));
	teams.get(20).addPlayer(new player(4 ,5 ,3 ,9 ,9 ,5 ,9 ,5 ,1 ,8 ,5 ,8 ,"Ethanthova Player #1", false));
	teams.get(20).addPlayer(new player(5 ,5 ,1 ,9 ,9 ,6 ,4 ,7 ,3 ,6 ,5 ,10 ,"Ethanthova Player #2", false));
	teams.get(20).addPlayer(new player(1 ,8 ,7 ,1 ,1 ,1 ,2 ,5 ,8 ,5 ,5 ,10 ,"Ethanthova Player #6", false));
	teams.get(20).addPlayer(new player(2 ,9 ,6 ,6 ,6 ,2 ,6 ,2 ,7 ,4 ,5 ,5 ,"Ethanthova Player #7", false));
	teams.get(20).addPlayer(new player(3 ,5 ,3 ,9 ,9 ,1 ,7 ,5 ,10 ,2 ,5 ,9 ,"Ethanthova Player #8", false));
	teams.get(20).addPlayer(new player(2 ,8 ,5 ,2 ,2 ,4 ,6 ,4 ,8 ,5 ,5 ,7 ,"Teyvada Khouphongsy", false));
	teams.get(20).addPlayer(new player(3 ,8 ,4 ,5 ,5 ,3 ,4 ,6 ,7 ,8 ,5 ,6 ,"Till Hutto", false));
	teams.get(20).addPlayer(new player(1 ,6 ,9 ,5 ,1 ,4 ,4 ,9 ,7 ,5 ,1 ,8 ,"Analu Rattanavongsa", false));
	teams.add(new team("Faehrenfall Feathercats"));
	teams.get(21).addPlayer(new player(1 ,7 ,7 ,3 ,2 ,2 ,6 ,10 ,10 ,7 ,1 ,8 ,"Mónhin Mipjódló", true));
	teams.get(21).addPlayer(new player(2 ,9 ,2 ,6 ,6 ,6 ,8 ,7 ,7 ,7 ,5 ,5 ,"Tha Tricka", true));
	teams.get(21).addPlayer(new player(3 ,7 ,8 ,6 ,6 ,6 ,7 ,8 ,4 ,8 ,5 ,8 ,"Alubembi Hadosa", true));
	teams.get(21).addPlayer(new player(4 ,7 ,3 ,8 ,8 ,7 ,9 ,8 ,4 ,9 ,5 ,9 ,"Kamil Jones", true));
	teams.get(21).addPlayer(new player(5 ,4 ,2 ,10 ,10 ,11 ,7 ,7 ,3 ,10 ,5 ,5 ,"Three Point Masta", true));
	teams.get(21).addPlayer(new player(5 ,6 ,1 ,6 ,6 ,9 ,5 ,6 ,2 ,2 ,5 ,8 ,"Adam Lettmann", false));
	teams.get(21).addPlayer(new player(4 ,4 ,3 ,9 ,7 ,8 ,4 ,8 ,3 ,6 ,5 ,10 ,"Naxto Zaxnax", false));
	teams.get(21).addPlayer(new player(4 ,3 ,1 ,7 ,7 ,6 ,7 ,6 ,4 ,10 ,5 ,5 ,"Big G", false));
	teams.get(21).addPlayer(new player(3 ,10 ,4 ,10 ,10 ,8 ,8 ,9 ,1 ,10 ,5 ,7 ,"Blanaxon Player #5", false));
	teams.get(21).addPlayer(new player(1 ,8 ,7 ,2 ,2 ,5 ,8 ,8 ,7 ,8 ,5 ,5 ,"Savage Soleani", false));
	teams.get(21).addPlayer(new player(5 ,2 ,1 ,3 ,3 ,8 ,6 ,6 ,3 ,3 ,5 ,8 ,"Crispy Dribble", false));
	teams.get(21).addPlayer(new player(2 ,10 ,9 ,3 ,3 ,5 ,6 ,8 ,7 ,5 ,5 ,10 ,"Tagawa Kazuko", false));
	teams.get(21).addPlayer(new player(3 ,7 ,9 ,6 ,6 ,6 ,7 ,9 ,1 ,6 ,5 ,5 ,"Papa Ogre", false));
	teams.get(21).addPlayer(new player(1 ,6 ,6 ,3 ,3 ,5 ,5 ,8 ,7 ,5 ,5 ,8 ,"Jote Ávura", false));
	teams.get(21).addPlayer(new player(2 ,8 ,7 ,3 ,3 ,3 ,6 ,4 ,8 ,4 ,5 ,9 ,"Okasei Bexemetadotsei", false));
	teams.add(new team("Stedro Boulders"));
	teams.get(22).addPlayer(new player(1 ,8 ,9 ,3 ,3 ,3 ,10 ,7 ,7 ,6 ,5 ,5 ,"Mabebosei Alotro", true));
	teams.get(22).addPlayer(new player(2 ,6 ,5 ,5 ,5 ,3 ,10 ,6 ,10 ,4 ,5 ,9 ,"eneŋ zekek zeilunaven", true));
	teams.get(22).addPlayer(new player(3 ,9 ,9 ,8 ,8 ,10 ,10 ,8 ,9 ,10 ,5 ,8 ,"Okaget Mabipet", true));
	teams.get(22).addPlayer(new player(4 ,3 ,5 ,10 ,8 ,7 ,8 ,7 ,1 ,6 ,7 ,9 ,"Gorga Ektxr", true));
	teams.get(22).addPlayer(new player(5 ,3 ,5 ,8 ,8 ,10 ,10 ,6 ,6 ,7 ,5 ,6 ,"Yasutake Yasuoka", true));
	teams.get(22).addPlayer(new player(1 ,5 ,9 ,4 ,2 ,4 ,7 ,7 ,10 ,5 ,10 ,7 ,"Nagata Taki", false));
	teams.get(22).addPlayer(new player(4 ,5 ,3 ,10 ,10 ,4 ,5 ,6 ,1 ,8 ,5 ,5 ,"Lavrenti Ogden", false));
	teams.get(22).addPlayer(new player(2 ,6 ,2 ,7 ,7 ,7 ,10 ,3 ,6 ,3 ,5 ,8 ,"Blanaxon Player #2", false));
	teams.get(22).addPlayer(new player(2 ,6 ,8 ,4 ,3 ,5 ,7 ,6 ,9 ,7 ,10 ,7 ,"Keahi Saenthavisouk", false));
	teams.get(22).addPlayer(new player(1 ,6 ,8 ,3 ,3 ,1 ,9 ,3 ,7 ,2 ,5 ,9 ,"Mabebesa Imbiedopei", false));
	teams.get(22).addPlayer(new player(5 ,4 ,4 ,7 ,7 ,7 ,1 ,5 ,4 ,7 ,5 ,10 ,"Sovlik Naxki", false));
	teams.get(22).addPlayer(new player(3 ,5 ,6 ,7 ,7 ,10 ,2 ,4 ,4 ,7 ,5 ,8 ,"Sagolegotosiei Sagotxile", false));
	teams.get(22).addPlayer(new player(4 ,6 ,2 ,7 ,7 ,6 ,7 ,3 ,4 ,10 ,5 ,5 ,"Veno Kibiget", false));
	teams.get(22).addPlayer(new player(5 ,2 ,3 ,10 ,10 ,6 ,1 ,8 ,3 ,3 ,5 ,8 ,"Dude McBeth", false));
	teams.get(22).addPlayer(new player(3 ,9 ,2 ,6 ,1 ,5 ,5 ,8 ,6 ,10 ,5 ,10 ,"Nadaklo Praxo", false));
	teams.add(new team("TND Tanks"));
	teams.get(23).addPlayer(new player(1 ,10 ,6 ,2 ,2 ,5 ,10 ,8 ,7 ,6 ,5 ,5 ,"TND Player #1", true));
	teams.get(23).addPlayer(new player(2 ,10 ,6 ,6 ,5 ,3 ,5 ,6 ,10 ,6 ,1 ,8 ,"Wilbert Harries", true));
	teams.get(23).addPlayer(new player(3 ,8 ,9 ,10 ,10 ,8 ,7 ,7 ,3 ,8 ,5 ,9 ,"Phetdum Vatthana", true));
	teams.get(23).addPlayer(new player(4 ,7 ,3 ,9 ,9 ,6 ,7 ,8 ,3 ,8 ,5 ,8 ,"TND Player #2", true));
	teams.get(23).addPlayer(new player(5 ,10 ,7 ,6 ,6 ,9 ,7 ,6 ,2 ,5 ,8 ,5 ,"LeBryon James", true));
	teams.get(23).addPlayer(new player(1 ,9 ,10 ,2 ,2 ,3 ,3 ,9 ,6 ,3 ,5 ,7 ,"Blanoxium Toxium", false));
	teams.get(23).addPlayer(new player(5 ,4 ,1 ,7 ,7 ,7 ,6 ,3 ,1 ,7 ,5 ,6 ,"Brodie Cropper", false));
	teams.get(23).addPlayer(new player(4 ,6 ,3 ,6 ,6 ,4 ,6 ,6 ,3 ,8 ,5 ,10 ,"Phetdum Phanivong", false));
	teams.get(23).addPlayer(new player(3 ,9 ,7 ,8 ,8 ,1 ,8 ,5 ,6 ,4 ,5 ,5 ,"TND Player #10", false));
	teams.get(23).addPlayer(new player(3 ,7 ,10 ,9 ,7 ,5 ,8 ,4 ,9 ,7 ,6 ,7 ,"Lvieknim Yuji", false));
	teams.get(23).addPlayer(new player(2 ,5 ,6 ,4 ,4 ,5 ,4 ,6 ,8 ,7 ,5 ,10 ,"Pyxanovia Player #5", false));
	teams.get(23).addPlayer(new player(2 ,3 ,5 ,3 ,3 ,5 ,5 ,7 ,8 ,5 ,5 ,10 ,"TND Player #5", false));
	teams.get(23).addPlayer(new player(4 ,7 ,1 ,9 ,9 ,7 ,1 ,3 ,1 ,4 ,5 ,9 ,"TND Player #6", false));
	teams.get(23).addPlayer(new player(5 ,5 ,2 ,8 ,8 ,8 ,7 ,7 ,4 ,7 ,5 ,5 ,"TND Player #3", false));
	teams.get(23).addPlayer(new player(1 ,5 ,5 ,1 ,1 ,5 ,6 ,7 ,8 ,2 ,5 ,7 ,"TND Player #9", false));
	
	teams.add(new team("Bongatar Banging Bongos"));
	teams.get(24).addPlayer(new player(1 ,10 ,9 ,4 ,2 ,4 ,8 ,9 ,13 ,8 ,5 ,6 ,"Kalani Saysamongdy", true));
	teams.get(24).addPlayer(new player(2 ,10 ,5 ,6 ,6 ,4 ,10 ,7 ,8 ,7 ,5 ,5 ,"Dvinme Player #11", true));
	teams.get(24).addPlayer(new player(3 ,10 ,10 ,7 ,7 ,10 ,6 ,2 ,1 ,5 ,5 ,6 ,"Bongatar Player #3", true));
	teams.get(24).addPlayer(new player(4 ,5 ,3 ,10 ,10 ,8 ,7 ,8 ,3 ,8 ,5 ,6 ,"Miyoshi Masami", true));
	teams.get(24).addPlayer(new player(5 ,7 ,3 ,4 ,4 ,10 ,9 ,9 ,7 ,4 ,5 ,10 ,"Fujikawa Masuhiro", true));
	teams.get(24).addPlayer(new player(4 ,5 ,1 ,9 ,9 ,5 ,8 ,6 ,2 ,6 ,5 ,5 ,"Blanox Farhje", false));
	teams.get(24).addPlayer(new player(5 ,4 ,1 ,8 ,8 ,8 ,8 ,5 ,4 ,3 ,5 ,10 ,"Bongatar Player #1", false));
	teams.get(24).addPlayer(new player(5 ,7 ,2 ,9 ,8 ,10 ,7 ,7 ,3 ,9 ,8 ,10 ,"Wongduan Sengtavisouk", false));
	teams.get(24).addPlayer(new player(3 ,4 ,8 ,5 ,5 ,6 ,7 ,2 ,5 ,4 ,5 ,8 ,"Hoeki Pakana", false));
	teams.get(24).addPlayer(new player(1 ,8 ,9 ,1 ,1 ,1 ,8 ,5 ,7 ,6 ,5 ,5 ,"Bongatar Player #7", false));
	teams.get(24).addPlayer(new player(2 ,1 ,8 ,8 ,8 ,1 ,8 ,4 ,4 ,9 ,5 ,9 ,"Fast Break", false));
	teams.get(24).addPlayer(new player(3 ,1 ,2 ,10 ,10 ,10 ,3 ,3 ,2 ,8 ,5 ,6 ,"Bongatar Player #9", false));
	teams.get(24).addPlayer(new player(1 ,4 ,4 ,2 ,2 ,5 ,8 ,10 ,9 ,2 ,5 ,6 ,"Danombi Chejijar", false));
	teams.get(24).addPlayer(new player(2 ,8 ,7 ,3 ,3 ,2 ,6 ,4 ,10 ,7 ,5 ,9 ,"kotheket tŋpel eqovkogh", false));
	teams.get(24).addPlayer(new player(4 ,4 ,3 ,7 ,6 ,6 ,7 ,7 ,3 ,10 ,10 ,7 ,"Dugaro Gagodosa", false));
	teams.add(new team("Czalliso Pythons"));
	teams.get(25).addPlayer(new player(1 ,9 ,6 ,2 ,2 ,3 ,10 ,10 ,9 ,5 ,5 ,5 ,"Sagolnasei Korsobo", true));
	teams.get(25).addPlayer(new player(2 ,4 ,9 ,5 ,5 ,5 ,6 ,10 ,8 ,6 ,5 ,5 ,"Dylan Fowler", true));
	teams.get(25).addPlayer(new player(3 ,4 ,9 ,7 ,7 ,10 ,7 ,7 ,4 ,10 ,5 ,9 ,"war", true));
	teams.get(25).addPlayer(new player(4 ,7 ,2 ,8 ,8 ,6 ,8 ,8 ,1 ,8 ,5 ,8 ,"mu", true));
	teams.get(25).addPlayer(new player(5 ,6 ,1 ,10 ,10 ,9 ,8 ,9 ,3 ,9 ,5 ,8 ,"Naxto Lizaxium", true));
	teams.get(25).addPlayer(new player(1 ,8 ,9 ,3 ,3 ,3 ,7 ,10 ,7 ,5 ,7 ,8 ,"kekh okepekít", false));
	teams.get(25).addPlayer(new player(5 ,7 ,5 ,5 ,5 ,8 ,6 ,6 ,2 ,5 ,5 ,7 ,"Matsuyama Tadashi", false));
	teams.get(25).addPlayer(new player(4 ,5 ,4 ,6 ,6 ,6 ,5 ,7 ,1 ,8 ,8 ,10 ,"Pau Finapeke", false));
	teams.get(25).addPlayer(new player(4 ,7 ,3 ,9 ,9 ,6 ,3 ,5 ,4 ,7 ,5 ,5 ,"hig", false));
	teams.get(25).addPlayer(new player(2 ,8 ,4 ,6 ,6 ,1 ,6 ,2 ,6 ,7 ,5 ,6 ,"son", false));
	teams.get(25).addPlayer(new player(2 ,7 ,7 ,3 ,3 ,5 ,9 ,1 ,6 ,6 ,5 ,5 ,"Holy Yektonesia Player #8", false));
	teams.get(25).addPlayer(new player(1 ,7 ,5 ,5 ,3 ,4 ,4 ,9 ,9 ,4 ,8 ,9 ,"Ha Chihu", false));
	teams.get(25).addPlayer(new player(3 ,10 ,9 ,1 ,1 ,4 ,5 ,5 ,7 ,1 ,5 ,5 ,"elp", false));
	teams.get(25).addPlayer(new player(5 ,5 ,2 ,8 ,8 ,7 ,6 ,4 ,3 ,7 ,1 ,9 ,"Nagasawa Okitsugu", false));
	teams.get(25).addPlayer(new player(3 ,4 ,3 ,9 ,9 ,1 ,7 ,5 ,10 ,2 ,5 ,8 ,"Mónhin Nasa", false));
	teams.add(new team("Dvimne Spirits"));
	teams.get(26).addPlayer(new player(1 ,6 ,7 ,3 ,3 ,3 ,8 ,9 ,12 ,5 ,5 ,5 ,"Seong-Su Gang", true));
	teams.get(26).addPlayer(new player(2 ,10 ,7 ,6 ,6 ,4 ,10 ,5 ,10 ,10 ,5 ,10 ,"Mazló Plókli", true));
	teams.get(26).addPlayer(new player(3 ,10 ,4 ,14 ,14 ,9 ,10 ,10 ,1 ,12 ,5 ,6 ,"Kersok Milan", true));
	teams.get(26).addPlayer(new player(4 ,6 ,3 ,8 ,8 ,6 ,7 ,10 ,3 ,10 ,5 ,5 ,"kuŋevok eɰnak gevunáh", true));
	teams.get(26).addPlayer(new player(5 ,1 ,7 ,10 ,10 ,6 ,8 ,10 ,3 ,9 ,5 ,9 ,"Wiley Ambrose", true));
	teams.get(26).addPlayer(new player(1 ,6 ,8 ,2 ,2 ,4 ,7 ,9 ,6 ,6 ,5 ,10 ,"Argos Pebek", false));
	teams.get(26).addPlayer(new player(5 ,5 ,3 ,8 ,8 ,9 ,5 ,7 ,4 ,10 ,5 ,6 ,"Benben", false));
	teams.get(26).addPlayer(new player(2 ,8 ,7 ,4 ,4 ,5 ,8 ,7 ,8 ,7 ,5 ,8 ,"Detrio Marzovius", false));
	teams.get(26).addPlayer(new player(4 ,6 ,3 ,10 ,10 ,6 ,7 ,7 ,1 ,7 ,5 ,5 ,"Markoli Strawlo", false));
	teams.get(26).addPlayer(new player(1 ,6 ,10 ,4 ,2 ,3 ,4 ,9 ,8 ,8 ,9 ,9 ,"Shishido Goro", false));
	teams.get(26).addPlayer(new player(4 ,7 ,1 ,10 ,10 ,6 ,3 ,3 ,3 ,9 ,5 ,9 ,"Tekle Doko", false));
	teams.get(26).addPlayer(new player(2 ,10 ,7 ,3 ,2 ,3 ,6 ,6 ,8 ,5 ,5 ,9 ,"Midger", false));
	teams.get(26).addPlayer(new player(3 ,6 ,10 ,3 ,3 ,8 ,5 ,6 ,5 ,6 ,5 ,8 ,"Litsaw Unup'a", false));
	teams.get(26).addPlayer(new player(5 ,2 ,4 ,9 ,9 ,9 ,4 ,3 ,4 ,5 ,5 ,5 ,"Sagotru Vealerko", false));
	teams.get(26).addPlayer(new player(1 ,6 ,10 ,4 ,2 ,3 ,4 ,9 ,8 ,8 ,9 ,9 ,"Shishido Goro", false));
	teams.add(new team("Holy Yektonisa Bishops"));
	teams.get(27).addPlayer(new player(1 ,6 ,10 ,1 ,1 ,3 ,9 ,10 ,9 ,8 ,5 ,5 ,"Shitt Hessar", true));
	teams.get(27).addPlayer(new player(2 ,9 ,6 ,4 ,4 ,3 ,8 ,7 ,7 ,7 ,5 ,3 ,"Eban Korsobo", true));
	teams.get(27).addPlayer(new player(3 ,3 ,7 ,5 ,5 ,5 ,10 ,8 ,5 ,7 ,5 ,9 ,"apseŋ kép tónaqig", true));
	teams.get(27).addPlayer(new player(4 ,7 ,4 ,7 ,7 ,8 ,9 ,6 ,3 ,8 ,5 ,7 ,"Omumiba Ektxr", true));
	teams.get(27).addPlayer(new player(5 ,5 ,4 ,10 ,10 ,12 ,8 ,8 ,2 ,10 ,5 ,7 ,"Hivek Ekxtr", true));
	teams.get(27).addPlayer(new player(3 ,9 ,8 ,5 ,5 ,10 ,6 ,7 ,3 ,2 ,5 ,10 ,"Ailiqaeu Okohae", false));
	teams.get(27).addPlayer(new player(2 ,8 ,7 ,6 ,6 ,2 ,6 ,6 ,9 ,7 ,5 ,10 ,"Kolpa Uxyakro", false));
	teams.get(27).addPlayer(new player(5 ,5 ,1 ,9 ,9 ,4 ,9 ,4 ,4 ,9 ,5 ,10 ,"Dano Subeina", false));
	teams.get(27).addPlayer(new player(1 ,9 ,7 ,3 ,3 ,5 ,9 ,6 ,8 ,3 ,5 ,8 ,"Holy Yektonesia Player #1", false));
	teams.get(27).addPlayer(new player(3 ,5 ,1 ,4 ,4 ,9 ,9 ,8 ,10 ,3 ,5 ,5 ,"Ji Gim", false));
	teams.get(27).addPlayer(new player(4 ,6 ,2 ,8 ,8 ,5 ,4 ,8 ,1 ,10 ,5 ,7 ,"Holy Yektonesia Player #3", false));
	teams.get(27).addPlayer(new player(4 ,4 ,3 ,10 ,10 ,5 ,7 ,6 ,1 ,7 ,5 ,5 ,"Holy Yektonesia Player #6", false));
	teams.get(27).addPlayer(new player(2 ,7 ,9 ,3 ,1 ,3 ,7 ,7 ,9 ,7 ,1 ,5 ,"pot", false));
	teams.get(27).addPlayer(new player(5 ,4 ,3 ,8 ,7 ,7 ,7 ,5 ,3 ,6 ,9 ,6 ,"Ingo Nesselrode", false));
	teams.get(27).addPlayer(new player(1 ,9 ,6 ,5 ,3 ,3 ,6 ,6 ,8 ,8 ,10 ,7 ,"Atumiba Bexomos", false));
	teams.add(new team("Holykol Bears"));
	teams.get(28).addPlayer(new player(1 ,10 ,8 ,1 ,1 ,4 ,9 ,4 ,9 ,6 ,5 ,8 ,"Ikaika Savang", true));
	teams.get(28).addPlayer(new player(2 ,8 ,9 ,4 ,4 ,4 ,6 ,7 ,9 ,8 ,5 ,10 ,"Konala Somphousiharath", true));
	teams.get(28).addPlayer(new player(3 ,4 ,10 ,5 ,5 ,7 ,6 ,5 ,8 ,7 ,5 ,9 ,"Jesse Svensson", true));
	teams.get(28).addPlayer(new player(4 ,6 ,1 ,9 ,9 ,7 ,10 ,4 ,2 ,10 ,5 ,6 ,"la", true));
	teams.get(28).addPlayer(new player(5 ,10 ,3 ,10 ,10 ,10 ,10 ,10 ,4 ,10 ,5 ,10 ,"Red Rainbow Player #2", true));
	teams.get(28).addPlayer(new player(4 ,4 ,2 ,9 ,9 ,7 ,7 ,6 ,4 ,8 ,5 ,6 ,"Alwin Gradl", false));
	teams.get(28).addPlayer(new player(2 ,9 ,4 ,2 ,2 ,4 ,10 ,6 ,9 ,5 ,5 ,5 ,"dot", false));
	teams.get(28).addPlayer(new player(3 ,2 ,7 ,10 ,10 ,3 ,9 ,5 ,1 ,8 ,5 ,7 ,"hax", false));
	teams.get(28).addPlayer(new player(1 ,10 ,3 ,2 ,2 ,5 ,8 ,8 ,7 ,6 ,5 ,5 ,"Center #137", false));
	teams.get(28).addPlayer(new player(1 ,9 ,7 ,3 ,1 ,4 ,7 ,8 ,10 ,6 ,10 ,10 ,"Koa Savang", false));
	teams.get(28).addPlayer(new player(4 ,3 ,4 ,7 ,9 ,7 ,6 ,8 ,1 ,10 ,2 ,7 ,"Rusty Berry", false));
	teams.get(28).addPlayer(new player(5 ,6 ,2 ,10 ,10 ,7 ,7 ,1 ,4 ,4 ,5 ,5 ,"quj", false));
	teams.get(28).addPlayer(new player(5 ,5 ,4 ,6 ,6 ,8 ,5 ,6 ,2 ,8 ,6 ,8 ,"Travis Traenfeglia", false));
	teams.get(28).addPlayer(new player(3 ,6 ,8 ,7 ,7 ,2 ,9 ,4 ,6 ,6 ,5 ,10 ,"Tsekon Wap't'ebw", false));
	teams.get(28).addPlayer(new player(2 ,7 ,8 ,3 ,4 ,5 ,4 ,8 ,9 ,5 ,6 ,5 ,"Lilo Thepsenavong", false));
	teams.add(new team("Lyintaria Lynx"));
	teams.get(29).addPlayer(new player(1 ,10 ,7 ,1 ,1 ,2 ,10 ,10 ,10 ,6 ,5 ,5 ,"Lyintaria Player #4", true));
	teams.get(29).addPlayer(new player(2 ,10 ,6 ,9 ,7 ,3 ,5 ,8 ,10 ,6 ,10 ,7 ,"Éxànnecig Hàŕselàn", true));
	teams.get(29).addPlayer(new player(3 ,8 ,9 ,7 ,10 ,9 ,4 ,10 ,7 ,5 ,7 ,10 ,"Bingarra", true));
	teams.get(29).addPlayer(new player(4 ,9 ,4 ,10 ,10 ,8 ,9 ,8 ,3 ,6 ,5 ,7 ,"Waltoko", true));
	teams.get(29).addPlayer(new player(5 ,3 ,3 ,10 ,10 ,10 ,8 ,5 ,1 ,5 ,5 ,5 ,"Phetdum Vongsay", true));
	teams.get(29).addPlayer(new player(3 ,7 ,5 ,10 ,10 ,8 ,10 ,6 ,3 ,10 ,5 ,5 ,"Lyintaria Player #1", false));
	teams.get(29).addPlayer(new player(3 ,8 ,6 ,5 ,5 ,4 ,4 ,10 ,5 ,2 ,5 ,5 ,"Lyintaria Player #10", false));
	teams.get(29).addPlayer(new player(5 ,7 ,3 ,7 ,7 ,10 ,4 ,8 ,1 ,2 ,5 ,5 ,"Lyintaria Player #11", false));
	teams.get(29).addPlayer(new player(5 ,6 ,6 ,7 ,9 ,9 ,7 ,3 ,1 ,4 ,1 ,9 ,"Meka Bokeo", false));
	teams.get(29).addPlayer(new player(2 ,8 ,7 ,2 ,2 ,4 ,7 ,7 ,8 ,3 ,5 ,10 ,"Lyintaria Player #2", false));
	teams.get(29).addPlayer(new player(4 ,7 ,1 ,8 ,8 ,7 ,7 ,8 ,1 ,3 ,5 ,5 ,"Lyintaria Player #3", false));
	teams.get(29).addPlayer(new player(4 ,2 ,1 ,10 ,10 ,5 ,5 ,8 ,2 ,7 ,5 ,7 ,"Lyintaria Player #6", false));
	teams.get(29).addPlayer(new player(1 ,8 ,9 ,1 ,1 ,2 ,6 ,10 ,6 ,5 ,5 ,9 ,"Sagua Player #1", false));
	teams.get(29).addPlayer(new player(1 ,4 ,6 ,1 ,1 ,1 ,8 ,7 ,11 ,3 ,5 ,5 ,"Lyintaria Player #8", false));
	teams.get(29).addPlayer(new player(2 ,6 ,8 ,5 ,4 ,4 ,4 ,5 ,9 ,8 ,10 ,5 ,"Bernard Wade", false));
	teams.add(new team("Pyxanovia Pixies"));
	teams.get(30).addPlayer(new player(1 ,10 ,7 ,4 ,4 ,1 ,6 ,8 ,8 ,5 ,5 ,6 ,"Pyxanovia Player #1", true));
	teams.get(30).addPlayer(new player(2 ,9 ,6 ,4 ,4 ,5 ,5 ,10 ,9 ,6 ,5 ,5 ,"tag", true));
	teams.get(30).addPlayer(new player(3 ,2 ,8 ,10 ,10 ,7 ,8 ,3 ,10 ,6 ,5 ,8 ,"Pyxanovia Player #4", true));
	teams.get(30).addPlayer(new player(4 ,7 ,2 ,10 ,10 ,9 ,8 ,9 ,3 ,10 ,5 ,8 ,"Handa Senichi", true));
	teams.get(30).addPlayer(new player(5 ,5 ,2 ,10 ,10 ,10 ,8 ,7 ,4 ,3 ,5 ,6 ,"Pyxanovia Player #2", true));
	teams.get(30).addPlayer(new player(4 ,7 ,1 ,10 ,10 ,5 ,6 ,7 ,3 ,2 ,5 ,10 ,"Autolik Player #2", false));
	teams.get(30).addPlayer(new player(4 ,7 ,2 ,10 ,10 ,9 ,8 ,9 ,3 ,10 ,5 ,8 ,"Handa Senichi", false));
	teams.get(30).addPlayer(new player(2 ,5 ,10 ,3 ,3 ,4 ,4 ,8 ,7 ,5 ,5 ,8 ,"Niclas Umlauf", false));
	teams.get(30).addPlayer(new player(5 ,4 ,5 ,8 ,8 ,10 ,5 ,5 ,5 ,7 ,5 ,5 ,"Ixux Naixi", false));
	teams.get(30).addPlayer(new player(3 ,5 ,5 ,6 ,6 ,8 ,7 ,1 ,2 ,8 ,5 ,6 ,"Nathaniel Starks", false));
	teams.get(30).addPlayer(new player(4 ,10 ,3 ,6 ,6 ,5 ,8 ,9 ,5 ,6 ,5 ,8 ,"Shooting Guard #169", false));
	teams.get(30).addPlayer(new player(3 ,10 ,4 ,1 ,2 ,6 ,7 ,6 ,8 ,8 ,7 ,9 ,"Mom Slivókŕámhomhók", false));
	teams.get(30).addPlayer(new player(5 ,2 ,2 ,6 ,6 ,7 ,7 ,6 ,3 ,4 ,5 ,5 ,"Pyxanovia Player #7", false));
	teams.get(30).addPlayer(new player(1 ,10 ,1 ,5 ,5 ,3 ,7 ,6 ,8 ,2 ,5 ,7 ,"Pyxanovia Player #8", false));
	teams.get(30).addPlayer(new player(1 ,6 ,6 ,3 ,3 ,5 ,7 ,5 ,6 ,4 ,5 ,7 ,"Pyxanovia Player #9", false));
	teams.add(new team("Transhimalia Disasters"));
	teams.get(31).addPlayer(new player(1 ,10 ,5 ,3 ,3 ,5 ,7 ,9 ,7 ,6 ,5 ,5 ,"Stuyr'et the Dominator", true));
	teams.get(31).addPlayer(new player(2 ,6 ,8 ,4 ,4 ,4 ,7 ,5 ,6 ,7 ,5 ,7 ,"Qrux'uhz the Enraged", true));
	teams.get(31).addPlayer(new player(3 ,9 ,3 ,10 ,10 ,4 ,8 ,8 ,7 ,1 ,5 ,8 ,"King Kalassak", true));
	teams.get(31).addPlayer(new player(4 ,4 ,1 ,10 ,10 ,5 ,8 ,8 ,2 ,10 ,5 ,5 ,"The Dimension Slaughterer", true));
	teams.get(31).addPlayer(new player(5 ,6 ,4 ,10 ,10 ,10 ,8 ,8 ,1 ,9 ,8 ,9 ,"Steve Masuhiro", true));
	teams.get(31).addPlayer(new player(2 ,9 ,5 ,3 ,3 ,6 ,7 ,3 ,9 ,4 ,5 ,10 ,"Akamu Tayvyihane", false));
	teams.get(31).addPlayer(new player(1 ,9 ,10 ,4 ,4 ,3 ,9 ,3 ,6 ,2 ,5 ,6 ,"Ingo Gradl", false));
	teams.get(31).addPlayer(new player(5 ,6 ,2 ,7 ,7 ,8 ,4 ,7 ,3 ,5 ,5 ,8 ,"Klabo Bexoxek", false));
	teams.get(31).addPlayer(new player(2 ,10 ,6 ,3 ,3 ,5 ,6 ,6 ,8 ,6 ,5 ,7 ,"Center #113", false));
	teams.get(31).addPlayer(new player(1 ,9 ,8 ,1 ,1 ,5 ,6 ,6 ,7 ,3 ,5 ,8 ,"Pruv'uorf the Extinguisher", false));
	teams.get(31).addPlayer(new player(5 ,6 ,4 ,7 ,7 ,7 ,7 ,6 ,3 ,4 ,5 ,10 ,"Sreotruyphoe the Expunger", false));
	teams.get(31).addPlayer(new player(4 ,4 ,2 ,8 ,8 ,7 ,4 ,8 ,2 ,1 ,5 ,9 ,"Dalmylphoe the Devourer", false));
	teams.get(31).addPlayer(new player(3 ,9 ,4 ,9 ,9 ,1 ,4 ,9 ,9 ,1 ,5 ,9 ,"Ceokmihza the Igniter", false));
	teams.get(31).addPlayer(new player(4 ,5 ,2 ,7 ,7 ,6 ,10 ,4 ,3 ,8 ,5 ,10 ,"Kmeav'hsoe the Wretched", false));
	teams.get(31).addPlayer(new player(3 ,4 ,6 ,8 ,10 ,8 ,7 ,6 ,6 ,9 ,8 ,8 ,"Kalani Phanivong", false));
	
	teams.get(0).addCoach(new Coach("Coach #1", 69, 86, 0.9, 27, -0.4, 11, Tempo.SLOW, coachShotType.BALANCED, ssInvolvment.HIGH));
	teams.get(1).addCoach(new Coach("Coach #2", 59, 94, -0.1, 28, 0.8, 7, Tempo.MEDIUM, coachShotType.BALANCED, ssInvolvment.LOW));
	teams.get(2).addCoach(new Coach("Coach #3", 62, 100, 0.4, 16, 0.2, 30, Tempo.MEDIUM, coachShotType.BALANCED, ssInvolvment.MEDIUM));
	teams.get(3).addCoach(new Coach("Coach #4", 83, 93, -0.6, 19, 0.2, 26, Tempo.MEDIUM, coachShotType.INSIDE, ssInvolvment.HIGH));
	teams.get(4).addCoach(new Coach("Coach #5", 85, 99, 0.6, 11, 0.5, 7, Tempo.MEDIUM, coachShotType.BALANCED, ssInvolvment.HIGH));
	teams.get(5).addCoach(new Coach("Coach #6", 59, 84, 0.8, 6, 0.9, 28, Tempo.MEDIUM, coachShotType.BALANCED, ssInvolvment.MEDIUM));
	teams.get(6).addCoach(new Coach("Coach #7", 65, 99, 0.3, 29, -0.8, 13, Tempo.MEDIUM, coachShotType.OUTSIDE, ssInvolvment.HIGH));
	teams.get(7).addCoach(new Coach("Coach #8", 73, 86, -0.7, 16, -0.6, 5, Tempo.FAST, coachShotType.BALANCED, ssInvolvment.HIGH));
	teams.get(8).addCoach(new Coach("Coach #9", 54, 92, 0.3, 5, -0.8, 24, Tempo.FAST, coachShotType.BALANCED, ssInvolvment.LOW));
	teams.get(9).addCoach(new Coach("Coach #10", 65, 89, 0, 12, 0.9, 29, Tempo.SLOW, coachShotType.BALANCED, ssInvolvment.MEDIUM));
	teams.get(10).addCoach(new Coach("Coach #11", 82, 94, 0.7, 14, -0.3, 13, Tempo.FAST, coachShotType.BALANCED, ssInvolvment.MEDIUM));
	teams.get(11).addCoach(new Coach("Coach #12", 80, 91, 0.9, 23, 0, 29, Tempo.SLOW, coachShotType.BALANCED, ssInvolvment.MEDIUM));
	teams.get(12).addCoach(new Coach("Coach #13", 65, 92, 0.7, 7, 0.8, 10, Tempo.SLOW, coachShotType.BALANCED, ssInvolvment.MEDIUM));
	teams.get(13).addCoach(new Coach("Coach #14", 73, 86, 0.2, 10, -0.3, 30, Tempo.SLOW, coachShotType.BALANCED, ssInvolvment.HIGH));
	teams.get(14).addCoach(new Coach("Coach #15", 55, 92, 0.3, 18, 0.6, 26, Tempo.FAST, coachShotType.BALANCED, ssInvolvment.HIGH));
	teams.get(15).addCoach(new Coach("Coach #16", 57, 89, 0.4, 22, 0.1, 16, Tempo.SLOW, coachShotType.OUTSIDE, ssInvolvment.MEDIUM));
	teams.get(16).addCoach(new Coach("Coach #17", 59, 92, 0.4, 7, 0.8, 24, Tempo.FAST, coachShotType.OUTSIDE, ssInvolvment.LOW));
	teams.get(17).addCoach(new Coach("Coach #18", 71, 92, 0.2, 22, 0.5, 13, Tempo.MEDIUM, coachShotType.BALANCED, ssInvolvment.LOW));
	teams.get(18).addCoach(new Coach("Coach #19", 56, 82, 0.9, 30, -0.4, 22, Tempo.MEDIUM, coachShotType.INSIDE, ssInvolvment.MEDIUM));
	teams.get(19).addCoach(new Coach("Coach #20", 69, 90, -1, 28, 0, 26, Tempo.MEDIUM, coachShotType.BALANCED, ssInvolvment.LOW));
	teams.get(20).addCoach(new Coach("Coach #21", 68, 99, -0.2, 5, 1, 11, Tempo.SLOW, coachShotType.BALANCED, ssInvolvment.MEDIUM));
	teams.get(21).addCoach(new Coach("Coach #22", 56, 89, 0.1, 5, 0.5, 11, Tempo.MEDIUM, coachShotType.BALANCED, ssInvolvment.LOW));
	teams.get(22).addCoach(new Coach("Coach #23", 73, 85, -0.3, 11, -0.4, 29, Tempo.MEDIUM, coachShotType.BALANCED, ssInvolvment.MEDIUM));
	teams.get(23).addCoach(new Coach("Coach #24", 83, 100, 0.8, 16, 0, 29, Tempo.SLOW, coachShotType.BALANCED, ssInvolvment.MEDIUM));
	teams.get(24).addCoach(new Coach("Coach #25", 54, 91, 0.1, 17, 0.3, 10, Tempo.MEDIUM, coachShotType.INSIDE, ssInvolvment.LOW));
	teams.get(25).addCoach(new Coach("Coach #26", 70, 90, -0.5, 19, -0.2, 28, Tempo.SLOW, coachShotType.BALANCED, ssInvolvment.LOW));
	teams.get(26).addCoach(new Coach("Coach #27", 80, 92, 0.9, 24, -0.4, 6, Tempo.SLOW, coachShotType.BALANCED, ssInvolvment.HIGH));
	teams.get(27).addCoach(new Coach("Coach #28", 83, 96, 0.9, 30, -1, 19, Tempo.SLOW, coachShotType.OUTSIDE, ssInvolvment.LOW));
	teams.get(28).addCoach(new Coach("Coach #29", 73, 90, -0.2, 29, -1, 23, Tempo.SLOW, coachShotType.INSIDE, ssInvolvment.LOW));
	teams.get(29).addCoach(new Coach("Coach #30", 53, 92, 0.7, 11, 0.3, 15, Tempo.MEDIUM, coachShotType.OUTSIDE, ssInvolvment.LOW));
	teams.get(30).addCoach(new Coach("Coach #31", 76, 89, -0.7, 10, -0.6, 26, Tempo.MEDIUM, coachShotType.BALANCED, ssInvolvment.LOW));
	teams.get(31).addCoach(new Coach("Coach #32", 45, 91, -0.3, 17, -0.6, 22, Tempo.MEDIUM, coachShotType.OUTSIDE, ssInvolvment.MEDIUM));
	
	teams.get(0).setTeamResults(new teamResults(new int[] {25, 12, 13}));
	
	teams.get(1).setTeamResults(new teamResults(new int[] {20, 2, 2}));
	
	teams.get(2).setTeamResults(new teamResults(new int[] {2, 4, 5}));
	
	teams.get(3).setTeamResults(new teamResults(new int[] {26, 11, 26}));
	
	teams.get(4).setTeamResults(new teamResults(new int[] {15, 20, 30}));
	
	teams.get(5).setTeamResults(new teamResults(new int[] {32, 6, 14}));
	
	teams.get(6).setTeamResults(new teamResults(new int[] {18, 23, 8}));
	
	teams.get(7).setTeamResults(new teamResults(new int[] {4, 10, 3}));
	
	teams.get(8).setTeamResults(new teamResults(new int[] {29, 16, 21}));
	
	teams.get(9).setTeamResults(new teamResults(new int[] {27, 8, 10}));
	
	teams.get(10).setTeamResults(new teamResults(new int[] {10, 18, 17}));
	
	teams.get(11).setTeamResults(new teamResults(new int[] {8, 29, 27}));
	
	teams.get(12).setTeamResults(new teamResults(new int[] {12, 25, 15}));
	
	teams.get(13).setTeamResults(new teamResults(new int[] {14, 27, 19}));
	
	teams.get(14).setTeamResults(new teamResults(new int[] {23, 31, 32}));
	
	teams.get(15).setTeamResults(new teamResults(new int[] {6, 13, 11}));
	
	teams.get(16).setTeamResults(new teamResults(new int[] {24, 24, 7}));
	
	teams.get(17).setTeamResults(new teamResults(new int[] {3, 7, 18}));
	
	teams.get(18).setTeamResults(new teamResults(new int[] {22, 32, 31}));
	
	teams.get(19).setTeamResults(new teamResults(new int[] {9, 5, 6}));
	
	teams.get(20).setTeamResults(new teamResults(new int[] {5, 9, 9}));
	
	teams.get(21).setTeamResults(new teamResults(new int[] {7, 17, 22}));
	
	teams.get(22).setTeamResults(new teamResults(new int[] {21, 22, 23}));
	
	teams.get(23).setTeamResults(new teamResults(new int[] {13, 19, 29}));
	
	teams.get(24).setTeamResults(new teamResults(new int[] {16, 26, 28}));
	
	teams.get(25).setTeamResults(new teamResults(new int[] {19, 28, 16}));
	
	teams.get(26).setTeamResults(new teamResults(new int[] {1, 1, 1}));
	
	teams.get(27).setTeamResults(new teamResults(new int[] {31, 30, 25}));
	
	teams.get(28).setTeamResults(new teamResults(new int[] {17, 15, 4}));
	
	teams.get(29).setTeamResults(new teamResults(new int[] {11, 21, 24}));
	
	teams.get(30).setTeamResults(new teamResults(new int[] {28, 3, 12}));
	
	teams.get(31).setTeamResults(new teamResults(new int[] {30, 14, 20}));
	
	
	
	/*
	teams.add(new team("10 Durability"));
	teams.add(new team("1 Durability"));
	
	teams.get(32).addPlayer(new player(1 ,10 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1,10 ,5 ,"10", true));
	teams.get(32).addPlayer(new player(2 ,10 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1,10 ,5 ,"10", true));
	teams.get(32).addPlayer(new player(3 ,10 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1,10 ,5 ,"10", true));
	teams.get(32).addPlayer(new player(4 ,10 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1,10 ,5 ,"10", true));
	teams.get(32).addPlayer(new player(5 ,10 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1,10 ,5 ,"10", true));
	teams.get(32).addPlayer(new player(1 ,10 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1,10 ,5 ,"10", false));
	teams.get(32).addPlayer(new player(2 ,10 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1,10 ,5 ,"10", false));
	teams.get(32).addPlayer(new player(3 ,10 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1,10 ,5 ,"10", false));
	teams.get(32).addPlayer(new player(4 ,10 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1,10 ,5 ,"10", false));
	teams.get(32).addPlayer(new player(5 ,10 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1,10 ,5 ,"10", false));
	teams.get(32).addPlayer(new player(1 ,10 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1,10 ,5 ,"10", false));
	teams.get(32).addPlayer(new player(2 ,10 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1,10 ,5 ,"10", false));
	teams.get(32).addPlayer(new player(3 ,10 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1,10 ,5 ,"10", false));
	teams.get(32).addPlayer(new player(4 ,10 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1,10 ,5 ,"10", false));
	teams.get(32).addPlayer(new player(5 ,10 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1,10 ,5 ,"10", false));

	teams.get(33).addPlayer(new player(1 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,1,1,1 ,5 ,"", true));
	teams.get(33).addPlayer(new player(2 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,1,1,1 ,5 ,"", true));
	teams.get(33).addPlayer(new player(3 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,1,1,1 ,5 ,"", true));
	teams.get(33).addPlayer(new player(4 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,1,1,1 ,5 ,"", true));
	teams.get(33).addPlayer(new player(5 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,1,1,1 ,5 ,"", true));
	teams.get(33).addPlayer(new player(1 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,1,1,1 ,5 ,"", false));
	teams.get(33).addPlayer(new player(2 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,1,1,1 ,5 ,"", false));
	teams.get(33).addPlayer(new player(3 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,1,1,1 ,5 ,"", false));
	teams.get(33).addPlayer(new player(4 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,1,1,1 ,5 ,"", false));
	teams.get(33).addPlayer(new player(5 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,1,1,1 ,5 ,"", false));
	teams.get(33).addPlayer(new player(1 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,1,1,1 ,5 ,"", false));
	teams.get(33).addPlayer(new player(2 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,1,1,1 ,5 ,"", false));
	teams.get(33).addPlayer(new player(3 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,1,1,1 ,5 ,"", false));
	teams.get(33).addPlayer(new player(4 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,1,1,1 ,5 ,"", false));
	teams.get(33).addPlayer(new player(5 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,1,1,1 ,5 ,"", false));

	
	teams.add(new team("10 Layup"));
	teams.add(new team("10 Dunk"));
	teams.add(new team("10 Jumpshot"));
	teams.add(new team("10 Pass"));
	teams.add(new team("10 ShotContest"));
	teams.add(new team("10 DefenseIQ"));
	teams.add(new team("10 Jumping"));
	teams.add(new team("10 Seperation"));
	teams.add(new team("10 Stamina"));
	
	teams.get(32).addPlayer(new player(1 ,10 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1,10 ,5 ,"", true));
	teams.get(32).addPlayer(new player(2 ,10 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1,10 ,5 ,"", true));
	teams.get(32).addPlayer(new player(3 ,10 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1,10 ,5 ,"", true));
	teams.get(32).addPlayer(new player(4 ,10 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1,10 ,5 ,"", true));
	teams.get(32).addPlayer(new player(5 ,10 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1,10 ,5 ,"", true));
	teams.get(32).addPlayer(new player(1 ,10 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1,10 ,5 ,"", false));
	teams.get(32).addPlayer(new player(2 ,10 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1,10 ,5 ,"", false));
	teams.get(32).addPlayer(new player(3 ,10 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1,10 ,5 ,"", false));
	teams.get(32).addPlayer(new player(4 ,10 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1,10 ,5 ,"", false));
	teams.get(32).addPlayer(new player(5 ,10 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1,10 ,5 ,"", false));
	teams.get(32).addPlayer(new player(1 ,10 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1,10 ,5 ,"", false));
	teams.get(32).addPlayer(new player(2 ,10 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1,10 ,5 ,"", false));
	teams.get(32).addPlayer(new player(3 ,10 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1,10 ,5 ,"", false));
	teams.get(32).addPlayer(new player(4 ,10 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1,10 ,5 ,"", false));
	teams.get(32).addPlayer(new player(5 ,10 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1,10 ,5 ,"", false));

	teams.get(33).addPlayer(new player(1 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,1,1,1 ,5 ,"", true));
	teams.get(33).addPlayer(new player(2 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,1,1,1 ,5 ,"", true));
	teams.get(33).addPlayer(new player(3 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,1,1,1 ,5 ,"", true));
	teams.get(33).addPlayer(new player(4 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,1,1,1 ,5 ,"", true));
	teams.get(33).addPlayer(new player(5 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,1,1,1 ,5 ,"", true));
	teams.get(33).addPlayer(new player(1 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,1,1,1 ,5 ,"", false));
	teams.get(33).addPlayer(new player(2 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,1,1,1 ,5 ,"", false));
	teams.get(33).addPlayer(new player(3 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,1,1,1 ,5 ,"", false));
	teams.get(33).addPlayer(new player(4 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,1,1,1 ,5 ,"", false));
	teams.get(33).addPlayer(new player(5 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,1,1,1 ,5 ,"", false));
	teams.get(33).addPlayer(new player(1 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,1,1,1 ,5 ,"", false));
	teams.get(33).addPlayer(new player(2 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,1,1,1 ,5 ,"", false));
	teams.get(33).addPlayer(new player(3 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,1,1,1 ,5 ,"", false));
	teams.get(33).addPlayer(new player(4 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,1,1,1 ,5 ,"", false));
	teams.get(33).addPlayer(new player(5 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,1,1,1 ,5 ,"", false));

	teams.get(34).addPlayer(new player(1 ,1 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,5 ,"", true));
	teams.get(34).addPlayer(new player(2 ,1 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,5 ,"", true));
	teams.get(34).addPlayer(new player(3 ,1 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,5 ,"", true));
	teams.get(34).addPlayer(new player(4 ,1 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,5 ,"", true));
	teams.get(34).addPlayer(new player(5 ,1 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,5 ,"", true));
	teams.get(34).addPlayer(new player(1 ,1 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,5 ,"", false));
	teams.get(34).addPlayer(new player(2 ,1 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,5 ,"", false));
	teams.get(34).addPlayer(new player(3 ,1 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,5 ,"", false));
	teams.get(34).addPlayer(new player(4 ,1 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,5 ,"", false));
	teams.get(34).addPlayer(new player(5 ,1 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,5 ,"", false));
	teams.get(34).addPlayer(new player(1 ,1 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,5 ,"", false));
	teams.get(34).addPlayer(new player(2 ,1 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,5 ,"", false));
	teams.get(34).addPlayer(new player(3 ,1 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,5 ,"", false));
	teams.get(34).addPlayer(new player(4 ,1 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,5 ,"", false));
	teams.get(34).addPlayer(new player(5 ,1 ,1 ,10 ,1 ,1 ,1 ,1 ,1 ,5 ,"", false));

	teams.get(35).addPlayer(new player(1 ,1 ,1 ,1 ,10 ,1 ,1 ,1 ,1 ,5 ,"", true));
	teams.get(35).addPlayer(new player(2 ,1 ,1 ,1 ,10 ,1 ,1 ,1 ,1 ,5 ,"", true));
	teams.get(35).addPlayer(new player(3 ,1 ,1 ,1 ,10 ,1 ,1 ,1 ,1 ,5 ,"", true));
	teams.get(35).addPlayer(new player(4 ,1 ,1 ,1 ,10 ,1 ,1 ,1 ,1 ,5 ,"", true));
	teams.get(35).addPlayer(new player(5 ,1 ,1 ,1 ,10 ,1 ,1 ,1 ,1 ,5 ,"", true));
	teams.get(35).addPlayer(new player(1 ,1 ,1 ,1 ,10 ,1 ,1 ,1 ,1 ,5 ,"", false));
	teams.get(35).addPlayer(new player(2 ,1 ,1 ,1 ,10 ,1 ,1 ,1 ,1 ,5 ,"", false));
	teams.get(35).addPlayer(new player(3 ,1 ,1 ,1 ,10 ,1 ,1 ,1 ,1 ,5 ,"", false));
	teams.get(35).addPlayer(new player(4 ,1 ,1 ,1 ,10 ,1 ,1 ,1 ,1 ,5 ,"", false));
	teams.get(35).addPlayer(new player(5 ,1 ,1 ,1 ,10 ,1 ,1 ,1 ,1 ,5 ,"", false));
	teams.get(35).addPlayer(new player(1 ,1 ,1 ,1 ,10 ,1 ,1 ,1 ,1 ,5 ,"", false));
	teams.get(35).addPlayer(new player(2 ,1 ,1 ,1 ,10 ,1 ,1 ,1 ,1 ,5 ,"", false));
	teams.get(35).addPlayer(new player(3 ,1 ,1 ,1 ,10 ,1 ,1 ,1 ,1 ,5 ,"", false));
	teams.get(35).addPlayer(new player(4 ,1 ,1 ,1 ,10 ,1 ,1 ,1 ,1 ,5 ,"", false));
	teams.get(35).addPlayer(new player(5 ,1 ,1 ,1 ,10 ,1 ,1 ,1 ,1 ,5 ,"", false));

	teams.get(36).addPlayer(new player(1 ,1 ,1 ,1 ,1 ,10 ,1 ,1 ,1 ,5 ,"", true));
	teams.get(36).addPlayer(new player(2 ,1 ,1 ,1 ,1 ,10 ,1 ,1 ,1 ,5 ,"", true));
	teams.get(36).addPlayer(new player(3 ,1 ,1 ,1 ,1 ,10 ,1 ,1 ,1 ,5 ,"", true));
	teams.get(36).addPlayer(new player(4 ,1 ,1 ,1 ,1 ,10 ,1 ,1 ,1 ,5 ,"", true));
	teams.get(36).addPlayer(new player(5 ,1 ,1 ,1 ,1 ,10 ,1 ,1 ,1 ,5 ,"", true));
	teams.get(36).addPlayer(new player(1 ,1 ,1 ,1 ,1 ,10 ,1 ,1 ,1 ,5 ,"", false));
	teams.get(36).addPlayer(new player(2 ,1 ,1 ,1 ,1 ,10 ,1 ,1 ,1 ,5 ,"", false));
	teams.get(36).addPlayer(new player(3 ,1 ,1 ,1 ,1 ,10 ,1 ,1 ,1 ,5 ,"", false));
	teams.get(36).addPlayer(new player(4 ,1 ,1 ,1 ,1 ,10 ,1 ,1 ,1 ,5 ,"", false));
	teams.get(36).addPlayer(new player(5 ,1 ,1 ,1 ,1 ,10 ,1 ,1 ,1 ,5 ,"", false));
	teams.get(36).addPlayer(new player(1 ,1 ,1 ,1 ,1 ,10 ,1 ,1 ,1 ,5 ,"", false));
	teams.get(36).addPlayer(new player(2 ,1 ,1 ,1 ,1 ,10 ,1 ,1 ,1 ,5 ,"", false));
	teams.get(36).addPlayer(new player(3 ,1 ,1 ,1 ,1 ,10 ,1 ,1 ,1 ,5 ,"", false));
	teams.get(36).addPlayer(new player(4 ,1 ,1 ,1 ,1 ,10 ,1 ,1 ,1 ,5 ,"", false));
	teams.get(36).addPlayer(new player(5 ,1 ,1 ,1 ,1 ,10 ,1 ,1 ,1 ,5 ,"", false));

	teams.get(37).addPlayer(new player(1 ,1 ,1 ,1 ,1 ,1 ,10 ,1 ,1 ,5 ,"", true));
	teams.get(37).addPlayer(new player(2 ,1 ,1 ,1 ,1 ,1 ,10 ,1 ,1 ,5 ,"", true));
	teams.get(37).addPlayer(new player(3 ,1 ,1 ,1 ,1 ,1 ,10 ,1 ,1 ,5 ,"", true));
	teams.get(37).addPlayer(new player(4 ,1 ,1 ,1 ,1 ,1 ,10 ,1 ,1 ,5 ,"", true));
	teams.get(37).addPlayer(new player(5 ,1 ,1 ,1 ,1 ,1 ,10 ,1 ,1 ,5 ,"", true));
	teams.get(37).addPlayer(new player(1 ,1 ,1 ,1 ,1 ,1 ,10 ,1 ,1 ,5 ,"", false));
	teams.get(37).addPlayer(new player(2 ,1 ,1 ,1 ,1 ,1 ,10 ,1 ,1 ,5 ,"", false));
	teams.get(37).addPlayer(new player(3 ,1 ,1 ,1 ,1 ,1 ,10 ,1 ,1 ,5 ,"", false));
	teams.get(37).addPlayer(new player(4 ,1 ,1 ,1 ,1 ,1 ,10 ,1 ,1 ,5 ,"", false));
	teams.get(37).addPlayer(new player(5 ,1 ,1 ,1 ,1 ,1 ,10 ,1 ,1 ,5 ,"", false));
	teams.get(37).addPlayer(new player(1 ,1 ,1 ,1 ,1 ,1 ,10 ,1 ,1 ,5 ,"", false));
	teams.get(37).addPlayer(new player(2 ,1 ,1 ,1 ,1 ,1 ,10 ,1 ,1 ,5 ,"", false));
	teams.get(37).addPlayer(new player(3 ,1 ,1 ,1 ,1 ,1 ,10 ,1 ,1 ,5 ,"", false));
	teams.get(37).addPlayer(new player(4 ,1 ,1 ,1 ,1 ,1 ,10 ,1 ,1 ,5 ,"", false));
	teams.get(37).addPlayer(new player(5 ,1 ,1 ,1 ,1 ,1 ,10 ,1 ,1 ,5 ,"", false));

	teams.get(38).addPlayer(new player(1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,1 ,5 ,"", true));
	teams.get(38).addPlayer(new player(2 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,1 ,5 ,"", true));
	teams.get(38).addPlayer(new player(3 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,1 ,5 ,"", true));
	teams.get(38).addPlayer(new player(4 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,1 ,5 ,"", true));
	teams.get(38).addPlayer(new player(5 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,1 ,5 ,"", true));
	teams.get(38).addPlayer(new player(1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,1 ,5 ,"", false));
	teams.get(38).addPlayer(new player(2 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,1 ,5 ,"", false));
	teams.get(38).addPlayer(new player(3 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,1 ,5 ,"", false));
	teams.get(38).addPlayer(new player(4 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,1 ,5 ,"", false));
	teams.get(38).addPlayer(new player(5 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,1 ,5 ,"", false));
	teams.get(38).addPlayer(new player(1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,1 ,5 ,"", false));
	teams.get(38).addPlayer(new player(2 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,1 ,5 ,"", false));
	teams.get(38).addPlayer(new player(3 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,1 ,5 ,"", false));
	teams.get(38).addPlayer(new player(4 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,1 ,5 ,"", false));
	teams.get(38).addPlayer(new player(5 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,1 ,5 ,"", false));

	teams.get(39).addPlayer(new player(1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,5 ,"", true));
	teams.get(39).addPlayer(new player(2 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,5 ,"", true));
	teams.get(39).addPlayer(new player(3 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,5 ,"", true));
	teams.get(39).addPlayer(new player(4 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,5 ,"", true));
	teams.get(39).addPlayer(new player(5 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,5 ,"", true));
	teams.get(39).addPlayer(new player(1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,5 ,"", false));
	teams.get(39).addPlayer(new player(2 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,5 ,"", false));
	teams.get(39).addPlayer(new player(3 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,5 ,"", false));
	teams.get(39).addPlayer(new player(4 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,5 ,"", false));
	teams.get(39).addPlayer(new player(5 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,5 ,"", false));
	teams.get(39).addPlayer(new player(1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,5 ,"", false));
	teams.get(39).addPlayer(new player(2 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,5 ,"", false));
	teams.get(39).addPlayer(new player(3 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,5 ,"", false));
	teams.get(39).addPlayer(new player(4 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,5 ,"", false));
	teams.get(39).addPlayer(new player(5 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,5 ,"", false));

	teams.get(40).addPlayer(new player(1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,"", true));
	teams.get(40).addPlayer(new player(2 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,"", true));
	teams.get(40).addPlayer(new player(3 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,"", true));
	teams.get(40).addPlayer(new player(4 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,"", true));
	teams.get(40).addPlayer(new player(5 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,"", true));
	teams.get(40).addPlayer(new player(1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,"", false));
	teams.get(40).addPlayer(new player(2 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,"", false));
	teams.get(40).addPlayer(new player(3 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,"", false));
	teams.get(40).addPlayer(new player(4 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,"", false));
	teams.get(40).addPlayer(new player(5 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,"", false));
	teams.get(40).addPlayer(new player(1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,"", false));
	teams.get(40).addPlayer(new player(2 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,"", false));
	teams.get(40).addPlayer(new player(3 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,"", false));
	teams.get(40).addPlayer(new player(4 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,"", false));
	teams.get(40).addPlayer(new player(5 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,10 ,"", false));

	/*
	teams.add(new team("Scout team 1"));
	teams.add(new team("Scout team 2"));
	teams.get(32).addPlayer(new player(1, 6, 7, 4, 3, 10, 8, 5, 1, 7, "Grant", "Pool", true));
	teams.get(33).addPlayer(new player(1, 5, 6, 2, 4, 10, 1, 8, 2, 8, "Om", "Kwang-Jo", true));
	teams.get(32).addPlayer(new player(1, 10, 9, 4, 6, 8, 9, 7, 2, 5, "Kardo", "Cows", false));
	teams.get(33).addPlayer(new player(1, 6, 4, 4, 5, 10, 9, 5, 5, 10, "Vrá", "Nonhkwaqan", false));
	teams.get(32).addPlayer(new player(2, 8, 7, 8, 7, 4, 4, 9, 6, 9, "Jesse", "McSteve", true));
	teams.get(33).addPlayer(new player(2, 8, 6, 6, 3, 9, 3, 9, 6, 5, "Jumpe", "", false));
	teams.get(32).addPlayer(new player(2, 9, 8, 6, 5, 4, 4, 7, 7, 10, "Dimitri", "Ebron", false));
	teams.get(33).addPlayer(new player(2, 9, 7, 3, 6, 7, 2, 8, 3, 7, "Keahi", "Saengsavang", false));
	teams.get(33).addPlayer(new player(2, 3, 4, 3, 8, 10, 9, 9, 5, 8, "Hevek", "Gagomos", true));
	teams.get(32).addPlayer(new player(3, 3, 8, 9, 7, 8, 8, 7, 3, 9, "Matthew", "Grabochov", false));
	teams.get(32).addPlayer(new player(3, 8, 10, 7, 5, 6, 7, 8, 9, 8, "Rusty", "Harries", true));
	teams.get(33).addPlayer(new player(3, 5, 5, 6, 8, 7, 1, 2, 8, 6, "Nathaniel", "Starks", false));
	teams.get(33).addPlayer(new player(3, 8, 9, 10, 8, 4, 2, 3, 8, 9, "Phetdum", "Vatthana", true));
	teams.get(33).addPlayer(new player(4, 7, 3, 6, 7, 9, 8, 4, 6, 9, "Kamil", "Jones", true));
	teams.get(32).addPlayer(new player(4, 6, 2, 5, 5, 9, 8, 2, 9, 5, "Danomobei", "Motxev", false));
	teams.get(32).addPlayer(new player(4, 4, 2, 9, 7, 7, 6, 4, 8, 6, "Alwin", "Gradl", true));
	teams.get(33).addPlayer(new player(4, 7, 3, 9, 4, 6, 8, 3, 6, 10, "Sova", "Kłó", false));
	teams.get(33).addPlayer(new player(5, 3, 3, 9, 8, 6, 7, 4, 4, 6, "Moke", "Douangvily", true));
	teams.get(32).addPlayer(new player(5, 1, 3, 4, 7, 8, 7, 1, 6, 7, "Quartermarra", "", false));
	teams.get(33).addPlayer(new player(5, 3, 3, 9, 5, 8, 6, 2, 7, 8, "Namia", "", false));
	teams.get(32).addPlayer(new player(5, 5, 3, 8, 8, 4, 7, 4, 6, 8, "Paparto", "Subeina", true));
	
	teams.add(new team("Player Type team 1"));
	teams.add(new team("Player Type team 2"));
	teams.add(new team("Player Type team 3"));
	teams.get(34).addPlayer(new player(5,7,7,4,7,5,5,7,5,9,"Athletic Point PG", true));
	teams.get(34).addPlayer(new player(5,6,2,7,9,4,7,3,5,8,"Playmaker PG", false));
	teams.get(34).addPlayer(new player(5,5,2,8,5,4,4,3,8,8,"Shoot First PG", false));
	teams.get(34).addPlayer(new player(4,4,4,9,4,5,4,4,9,7,"Sharpshooter SG", true));
	teams.get(34).addPlayer(new player(4,7,4,5,5,7,7,5,6,8,"Two-Way SG", false));
	teams.get(34).addPlayer(new player(4,6,8,3,3,5,5,8,5,9,"Athletic SG SG", false));
	teams.get(34).addPlayer(new player(3,7,6,5,5,5,6,5,6,8,"Wing Player SF", true));
	teams.get(34).addPlayer(new player(3,8,7,4,5,5,5,6,7,8,"Slasher SF", false));
	teams.get(34).addPlayer(new player(3,4,4,9,5,5,4,5,8,7,"Sharpshooter SF", false));
	teams.get(34).addPlayer(new player(2,4,4,7,5,4,4,5,8,7,"Faceup PF", true));
	teams.get(34).addPlayer(new player(2,8,7,2,3,6,6,7,6,8,"Interior Scorer PF", false));
	teams.get(34).addPlayer(new player(2,7,9,2,3,7,6,9,4,8,"Athletic Big PF", false));
	teams.get(34).addPlayer(new player(1,8,7,1,2,7,7,7,6,7,"Interior Scorer C", true));
	teams.get(34).addPlayer(new player(1,6,6,1,2,9,8,9,4,7,"Rim Protector C", false));
	teams.get(34).addPlayer(new player(1,7,9,1,1,8,6,9,2,8,"Athletic Center C", false));

	
	teams.get(35).addPlayer(new player(5,7,7,4,7,5,5,7,5,9,"Athletic Point PG", false));
	teams.get(35).addPlayer(new player(5,6,2,7,9,4,7,3,5,8,"Playmaker PG", true));
	teams.get(35).addPlayer(new player(5,5,2,8,5,4,4,3,8,8,"Shoot First PG", false));
	teams.get(35).addPlayer(new player(4,4,4,9,4,5,4,4,9,7,"Sharpshooter SG", false));
	teams.get(35).addPlayer(new player(4,7,4,5,5,7,7,5,6,8,"Two-Way SG", true));
	teams.get(35).addPlayer(new player(4,6,8,3,3,5,5,8,5,9,"Athletic SG SG", false));
	teams.get(35).addPlayer(new player(3,7,6,5,5,5,6,5,6,8,"Wing Player SF", false));
	teams.get(35).addPlayer(new player(3,8,7,4,5,5,5,6,7,8,"Slasher SF", true));
	teams.get(35).addPlayer(new player(3,4,4,9,5,5,4,5,8,7,"Sharpshooter SF", false));
	teams.get(35).addPlayer(new player(2,4,4,7,5,4,4,5,8,7,"Faceup PF", false));
	teams.get(35).addPlayer(new player(2,8,7,2,3,6,6,7,6,8,"Interior Scorer PF", true));
	teams.get(35).addPlayer(new player(2,7,9,2,3,7,6,9,4,8,"Athletic Big PF", false));
	teams.get(35).addPlayer(new player(1,8,7,1,2,7,7,7,6,7,"Interior Scorer C", false));
	teams.get(35).addPlayer(new player(1,6,6,1,2,9,8,9,4,7,"Rim Protector C", true));
	teams.get(35).addPlayer(new player(1,7,9,1,1,8,6,9,2,8,"Athletic Center C", false));

	teams.get(36).addPlayer(new player(5,7,7,4,7,5,5,7,5,9,"Athletic Point PG", false));
	teams.get(36).addPlayer(new player(5,6,2,7,9,4,7,3,5,8,"Playmaker PG", false));
	teams.get(36).addPlayer(new player(5,5,2,8,5,4,4,3,8,8,"Shoot First PG", true));
	teams.get(36).addPlayer(new player(4,4,4,9,4,5,4,4,9,7,"Sharpshooter SG", false));
	teams.get(36).addPlayer(new player(4,7,4,5,5,7,7,5,6,8,"Two-Way SG", false));
	teams.get(36).addPlayer(new player(4,6,8,3,3,5,5,8,5,9,"Athletic SG SG", true));
	teams.get(36).addPlayer(new player(3,7,6,5,5,5,6,5,6,8,"Wing Player SF", false));
	teams.get(36).addPlayer(new player(3,8,7,4,5,5,5,6,7,8,"Slasher SF", false));
	teams.get(36).addPlayer(new player(3,4,4,9,5,5,4,5,8,7,"Sharpshooter SF", true));
	teams.get(36).addPlayer(new player(2,4,4,7,5,4,4,5,8,7,"Faceup PF", false));
	teams.get(36).addPlayer(new player(2,8,7,2,3,6,6,7,6,8,"Interior Scorer PF", false));
	teams.get(36).addPlayer(new player(2,7,9,2,3,7,6,9,4,8,"Athletic Big PF", true));
	teams.get(36).addPlayer(new player(1,8,7,1,2,7,7,7,6,7,"Interior Scorer C", false));
	teams.get(36).addPlayer(new player(1,6,6,1,2,9,8,9,4,7,"Rim Protector C", false));
	teams.get(36).addPlayer(new player(1,7,9,1,1,8,6,9,2,8,"Athletic Center C", true));

	
	
	Print theTeams = new Print(teams);

	theTeams.printAllTeams();*/



	
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
    
}
