import java.util.Random;

public class shots
{
    private double shotSkill, defenseSkill;
    private boolean madeShot, wasFouled;
    private int pointsScored;
    private ShotType typeOfShot;
    public shots(int variation, double shotType, double d, ShotType shot)
    {
	typeOfShot = shot;
	this.shotSkill = shotType;
	this.defenseSkill = d;
	madeShot = false;
	wasFouled = false;
	pointsScored = 0;

	switch (typeOfShot){
	case FREE:
	    if(variation == 4)takeFreeThrows(2);
	    else if(variation == 5)takeFreeThrows(3);
	    else if(variation == 6)takeFreeThrows(1);
	    break;
	case THREE:
	    if(variation == 1)takeOpenShot(50);
	    else if(variation == 2)takeMildlyContestedShot(30);
	    else if(variation == 3)takeSmotheredShot(20);
	    break;
	case JUMP:
	    if(variation == 1)takeOpenShot(55);
	    else if(variation == 2)takeMildlyContestedShot(35);
	    else if(variation == 3)takeSmotheredShot(20);
	    break;
	case LAYUP:
	    if(variation == 1)takeOpenShot(70);
	    else if(variation == 2)takeMildlyContestedShot(35);
	    else if(variation == 3)takeSmotheredShot(20);
	    break;
	case DUNK:
	    if(variation == 1)takeOpenShot(75);
	    else if(variation == 2)takeMildlyContestedShot(40);
	    else if(variation == 3)takeSmotheredShot(15);
	    break;
	}
	//takeShot();
    }
    private void takeFreeThrows(int i)
    {
	double temp = shotSkill;
	Random r = new Random();

	for(int j = 0; j<i;j++)
	{
	    double temp2 = r.nextInt(15)+temp-3.5;

	    if(temp2 > 6)pointsScored++;
	}

    }
    public int getPointsScored()
    {
	return pointsScored;
    }
    private void takeOpenShot(int percent)
    {
	double temp = shotSkill;

	Random r = new Random();
	double num = percent+(r.nextInt(5)-2);
	temp -= 6;
	num = num + (temp);
	double temp2 = r.nextInt(105);

	if(temp2 < num)madeShot = true;
    }
    private void takeMildlyContestedShot(int percent)
    {
	double temp = shotSkill - defenseSkill;
	
	Random r = new Random();
	double num = percent+(r.nextInt(5)-2);
	num = num + (temp);
	double temp2 = r.nextInt(105);

	if(temp2 < num)madeShot = true;
	//if((Math.floor(temp2) == 3 && Math.round(temp2+.25) == 3) || (Math.floor(temp2) == 6 && Math.round(temp2+.4) == 6))
	if(temp2<35)
	{
	    wasFouled = true;
	}
    }
    private void takeSmotheredShot(int percent)
    {
	double temp = shotSkill - (2*defenseSkill);

	Random r = new Random();
	double num = percent+(r.nextInt(5)-2);
	num = num + (temp);
	double temp2 = r.nextInt(105);

	if(temp2 < num)madeShot = true;
	//if((Math.floor(temp2) == 3 && Math.round(temp2+.25) == 3) || (Math.floor(temp2) == 6 && Math.round(temp2+.4) == 6))
	if(temp2<50)
	{
	    wasFouled = true;
	}
    }
    public boolean madeShot()
    {
	return madeShot;
    }
    public boolean wasFouled()
    {
	return wasFouled;
    }


}
