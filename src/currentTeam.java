
public class currentTeam
{
    public player pointGuard, shootingGuard, smallForward, powerForward, center;
    public int length = 5;
    public player superStar, playMaker, rebounder, shooter;
    public team team;
    public Coach coach;
    public player lastPlayer;
    public currentTeam(team team)
    {
	pointGuard = null; 
	shootingGuard = null;
	smallForward = null;
	powerForward =null;
	center = null;
	this.team = team;
	superStar = null;
	playMaker = null;
	rebounder = null;
	shooter = null;
	coach = team.getCoach();
    }
    public currentTeam(currentTeam copy)
    {
	pointGuard = copy.pointGuard; 
	shootingGuard = copy.shootingGuard;
	smallForward = copy.smallForward;
	powerForward =copy.powerForward;
	center = copy.center;
	team = copy.team;
	superStar = copy.superStar;
	playMaker = copy.playMaker;
	rebounder = copy.rebounder;
	coach = copy.coach;
	shooter = copy.shooter;
    }
    public player get(int i)
    {
	switch(i)
	{
	case 0:
	    return center;
	case 1:
	    return powerForward;
	case 2: 
	    return smallForward;
	case 3:
	    return shootingGuard;
	case 4: 
	    return pointGuard;
	}
	return null;
    }
    public void set(int i, player player)
    {
	switch(i)
	{
	case 0:
	    center = player;
	    break;
	case 1:
	    powerForward = player;
	    break;
	case 2: 
	    smallForward = player;
	    break;
	case 3:
	    shootingGuard = player;
	    break;
	case 4: 
	    pointGuard = player;
	    break;
	}

    }
    public int getPos(player player)
    {
	if(player.equals(center))return 1;
	else if(player.equals(powerForward))return 2;
	else if(player.equals(smallForward))return 3;
	else if(player.equals(shootingGuard))return 4;
	else if(player.equals(pointGuard))return 5;

	return -1;
    }

    public void checkTeam()
    {
	player[] arr = team.getPresets();
	if(arr != null)	
	{
	    if(arr[0].isPlaying())superStar = arr[0];
	    else superStar = null;
	    if(arr[1].isPlaying())playMaker = arr[1];
	    else playMaker = null;
	    if(arr[2].isPlaying())rebounder = arr[2];
	    else rebounder = null;
	    if(arr[3].isPlaying())shooter = arr[3];
	    else shooter = null;
	}
	if(superStar == null)
	{
	    superStar = findSuperStar();
	}
	if(playMaker == null)
	{
	    playMaker = findPlayMaker();
	}
	if(rebounder == null)
	{
	    rebounder = findRebounder();
	}
	if(shooter == null)
	{
	    shooter = findShooter();
	}


    }
    private player findShooter()
    {
	int pos = 0;
	double highestTotal = 0.0;
	for(int i = 0; i < 5; i++)
	{
	    player temp = get(i);
	    double tempTotal = Math.max(temp.getDunkRating(), temp.getLayupRating()) + temp.getJumpShotRating() + temp.getThreeShotRating();
	    if(tempTotal > highestTotal)
	    {
		highestTotal = tempTotal;
		pos = i;
	    }
	}
	return get(pos);
    }
    private player findRebounder()
    {
	int pos = 0;

	double highestTotal = 0;
	for(int i = 0; i < 5; i++)
	{
	    player temp = get(i);
	    double tempTotal = temp.getJumpingRating();
	    if(tempTotal > highestTotal)
	    {
		highestTotal = tempTotal;
		pos = i;
	    }
	}

	return get(pos);
    }
    private player findPlayMaker()
    {
	int pos = 0;

	double highestTotal = 0;
	for(int i = 4; i >= 0; i--)
	{
	    player temp = get(i);
	    double tempTotal = temp.getPassing();
	    if(tempTotal > highestTotal)
	    {
		highestTotal = tempTotal;
		pos = i;
	    }
	}

	return get(pos);
    }
    private player findSuperStar()
    {
	int pos = 0;

	double highestTotal = 0;
	for(int i = 0; i < 5; i++)
	{
	    player temp = get(i);
	    double tempTotal = temp.getDefenseIQRating()+Math.max(temp.getDunkRating(), temp.getLayupRating())+temp.getShotContestRating() + temp.getJumpingRating() + temp.getJumpShotRating() + temp.getSeperation() + temp.getPassing() + temp.getThreeShotRating();
	    //System.out.println(temp.getName() + " " + tempTotal);
	    if(tempTotal > highestTotal)
	    {
		highestTotal = tempTotal;
		pos = i;
	    }
	}
	//System.out.println(get(pos).getName());
	return get(pos);
    }
}
