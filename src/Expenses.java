import java.io.Serializable;

public class Expenses implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private double[] weeklyExpenses;
    private double sharedIncome;
    private double[] sponsers;
    private int weeklySponser;
    public Expenses(double[] expenses)
    {
	sharedIncome = 2000000;
	weeklyExpenses = new double[expenses.length];
	for(int i = 0; i < expenses.length; i++)
	{
	    weeklyExpenses[i] = (expenses[i]/21)*1000000;
	}
    }

    public int chargeExpenses(int fianance, double sponserMoney)
    {
	int retVal = (int) (fianance + sponserMoney);
	for(int i = 0; i < weeklyExpenses.length; i++)
	{
	    retVal -= weeklyExpenses[i];
	}
	retVal += sharedIncome + weeklySponser;
	
	return retVal;
    }

    public void setSponsers(double[] arr)
    {
	this.sponsers = arr;
	
    }

    public int homeGameOccurred(int fianance)
    {
	int retVal = fianance;
	if(sponsers != null)
	{
	    for(int i = 0; i < sponsers.length; i++)
	    {
		retVal += sponsers[i];
	    }
	}
	return retVal;
    }

    public void setWeeklySponser(int i)
    {
	weeklySponser = i;
	
    }
}
