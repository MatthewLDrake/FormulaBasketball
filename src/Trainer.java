import java.io.Serializable;
import java.util.Random;

public class Trainer implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
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
    public int getInjuryPrevention(player player)
    {
	int injuryNumber = player.getDurabilityRating()+injuryPrevention;

	return injuryNumber*1250;
    }
    public void setInjuryPrevention(int injuryPrevention)
    {
	this.injuryPrevention = injuryPrevention;
    }
    public int getInjuryDuration(int i)
    {
	Random r = new Random();
	if(i == 0)
	{
	    if(injuryDuration > 4)return 0;
	    else if(injuryDuration == 3)return 1;
	    else if(injuryDuration == 2)return r.nextInt(2);
	    else return r.nextInt(5);		
	}
	else if(i == 1)
	{
	    if(injuryDuration == 10)return r.nextInt(2)+1;
	    else if(injuryDuration == 9)return r.nextInt(3)+1;
	    else if(injuryDuration == 8)return r.nextInt(5)+2;
	    else if(injuryDuration == 7)return r.nextInt(5)+2;
	    else if(injuryDuration == 6)return r.nextInt(5)+3;
	    else if(injuryDuration == 5)return r.nextInt(7)+3;
	    else if(injuryDuration == 4)return r.nextInt(7)+5;
	    else if(injuryDuration == 3)return r.nextInt(7)+7;
	    else if(injuryDuration == 2)return r.nextInt(7)+9;
	    else if(injuryDuration == 1)return r.nextInt(10)+10;
	}
	else if(i == 2)
	{
	    if(injuryDuration == 10)return r.nextInt(5)+5;
	    else if(injuryDuration == 9)return r.nextInt(7)+5;
	    else if(injuryDuration == 8)return r.nextInt(7)+10;
	    else if(injuryDuration == 7)return r.nextInt(10)+12;
	    else if(injuryDuration == 6)return r.nextInt(10)+15;
	    else if(injuryDuration == 5)return r.nextInt(13)+15;
	    else if(injuryDuration == 4)return r.nextInt(13)+17;
	    else if(injuryDuration == 3)return r.nextInt(15)+17;
	    else if(injuryDuration == 2)return r.nextInt(15)+20;
	    else if(injuryDuration == 1)return r.nextInt(20)+20;
	}
	else if(i == 3)
	{
	    if(injuryDuration == 10)return r.nextInt(5)+15;
	    else if(injuryDuration == 9)return r.nextInt(5)+20;
	    else if(injuryDuration == 8)return r.nextInt(10)+22;
	    else if(injuryDuration == 7)return r.nextInt(15)+25;
	    else if(injuryDuration == 6)return r.nextInt(20)+25;
	    else if(injuryDuration == 5)return r.nextInt(25)+25;
	    else if(injuryDuration == 4)return r.nextInt(30)+30;
	    else if(injuryDuration == 3)return r.nextInt(35)+30;
	    else if(injuryDuration == 2)return r.nextInt(35)+35;
	    else if(injuryDuration == 1)return r.nextInt(40)+40;
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
