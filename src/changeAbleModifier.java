
public class changeAbleModifier implements Modifier
{
    private double shootingModifier, defenseModifier;
    public changeAbleModifier(double shootingModifier, double defenseModifier)
    {
	this.shootingModifier = shootingModifier;
	this.defenseModifier = defenseModifier;
    }
    @Override
    public double getShootingModifier()
    {
	// TODO Auto-generated method stub
	return shootingModifier;
    }

    @Override
    public double getDefenseModifier()
    {
	// TODO Auto-generated method stub
	return defenseModifier;
    }

    @Override
    public double getOtherModifier()
    {
	// TODO Auto-generated method stub
	return 0;
    }

}
