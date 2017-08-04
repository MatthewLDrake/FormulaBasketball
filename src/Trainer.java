
public class Trainer
{
	private String name;
	private int injuryPrevention, injuryDuration;
	private double staminaModifier;
	public Trainer(String name, int injuryPrevention, int injuryDuration, double staminaModifier)
	{
		this.setName(name);
		this.setInjuryDuration(injuryDuration);
		this.setInjuryPrevention(injuryPrevention);
		this.setStaminaModifier(staminaModifier);
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getInjuryPrevention()
	{
		return -80*(injuryPrevention*injuryPrevention)+ 2200*injuryPrevention + 1000;
		//return injuryPreventation;
	}
	public void setInjuryPrevention(int injuryPrevention)
	{
		this.injuryPrevention = injuryPrevention;
	}
	public int getInjuryDuration(int i)
	{
		switch(injuryDuration)
		{
		case 1:
			if(i == 0)
			{
				return 3;
			}
			else if(i == 1)
			{
				return 15;
			}
			else if(i == 2)
			{
				return 30;
			}
			else if(i == 3)
			{
				return 80;
			}
			break;
		case 2:
			if(i == 0)
			{
				return 2;	
			}
			else if(i == 1)
			{

			}
			else if(i == 2)
			{

			}
			else if(i == 3)
			{

			}
			break;
		case 3:
			if(i == 0)
			{

			}
			else if(i == 1)
			{

			}
			else if(i == 2)
			{

			}
			else if(i == 3)
				break;
		case 4:
			if(i == 0)
			{

			}
			else if(i == 1)
			{

			}
			else if(i == 2)
			{

			}
			else if(i == 3)
				break;
		case 5:
			if(i == 0)
			{

			}
			else if(i == 1)
			{

			}
			else if(i == 2)
			{

			}
			else if(i == 3)
			{

			}
			break;
		case 6:
			if(i == 0)
			{

			}
			else if(i == 1)
			{

			}
			else if(i == 2)
			{

			}
			else if(i == 3)
			{

			}
			break;
		case 7:
			if(i == 0)
			{

			}
			else if(i == 1)
			{

			}
			else if(i == 2)
			{

			}
			else if(i == 3)
			{

			}
			break;
		case 8:
			if(i == 0)
			{

			}
			else if(i == 1)
			{

			}
			else if(i == 2)
			{

			}
			else if(i == 3)
			{

			}
			break;
		case 9:
			if(i == 0)
			{

			}
			else if(i == 1)
			{

			}
			else if(i == 2)
			{

			}
			else if(i == 3)
			{

			}
			break;
		case 10:
			if(i == 0)
			{

			}
			else if(i == 1)
			{

			}
			else if(i == 2)
			{

			}
			else if(i == 3)
			{

			}
			break;
		}

		return injuryDuration;
	}
	public void setInjuryDuration(int injuryDuration)
	{
		this.injuryDuration = injuryDuration;
	}
	public double getStaminaModifier()
	{
		return staminaModifier;
	}
	public void setStaminaModifier(double staminaModifier)
	{
		this.staminaModifier = staminaModifier;
	}

}
