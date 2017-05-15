import java.util.Random;

public class shots
{
	private double shotSkill, defenseSkill;
	private boolean madeShot, wasFouled;
	private int pointsScored;
	public shots(int variation, double shotType, double d)
	{
		this.shotSkill = shotType;
		this.defenseSkill = d;
		madeShot = false;
		wasFouled = false;
		pointsScored = 0;

		if(variation == 1)takeOpenShot();
		else if(variation == 2)takeMildlyContestedShot();
		else if(variation == 3)takeSmotheredShot();
		else if(variation == 4)takeFreeThrows(2);
		else if(variation == 5)takeFreeThrows(3);
		else if(variation == 6)takeFreeThrows(1);
		//takeShot();
	}
	private void takeFreeThrows(int i)
	{
		double temp = shotSkill;
		Random r = new Random();

		for(int j = 0; j<i;j++)
		{
			double temp2 = r.nextInt(15)+temp-3.5;

			if(temp2 > 5)pointsScored++;
		}

	}
	public int getPointsScored()
	{
		return pointsScored;
	}
	private void takeOpenShot()
	{
		double temp = shotSkill;

		Random r = new Random();
		double temp2 = r.nextInt(15)+temp-5;

		if(temp2 > 5)madeShot = true;
	}
	private void takeMildlyContestedShot()
	{
		double temp = shotSkill - defenseSkill;

		Random r = new Random();
		double temp2 = r.nextInt(15)+temp-5;

		if(temp2 > 5)madeShot = true;
		//if((Math.floor(temp2) == 3 && Math.round(temp2+.25) == 3) || (Math.floor(temp2) == 6 && Math.round(temp2+.4) == 6))
		if(Math.round(temp2+.25) == 3 || Math.floor(temp2) == 3 || Math.round(temp2+.4) == 6)
		{
			wasFouled = true;
		}
	}
	private void takeSmotheredShot()
	{
		double temp = shotSkill - (2*defenseSkill);

		Random r = new Random();
		double temp2 = r.nextInt(15)+temp-5;

		if(temp2 > 5)madeShot = true;
		//if((Math.floor(temp2) == 3 && Math.round(temp2+.25) == 3) || (Math.floor(temp2) == 6 && Math.round(temp2+.4) == 6))
		if(Math.round(temp2+.25) == 3 || Math.floor(temp2) == 3 || Math.round(temp2+.4) == 6)
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
