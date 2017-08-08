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
    
    private long sharedIncomeCount;
    private double[] totalExpenses;
    
    public Expenses(double[] expenses)
    {
    	totalExpenses = new double[expenses.length];
	sharedIncome = 2380952;
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
	    totalExpenses[i] += weeklyExpenses[i];
	}
	retVal += sharedIncome + weeklySponser;
	sharedIncomeCount += sharedIncome;
	return retVal;
    }

    public void setSponsers(double[] arr)
    {
	this.sponsers = arr;
	
    }
    private int homeGameMoneyEarned = 0;
    public int homeGameOccurred(int fianance)
    {
	int retVal = fianance;
	if(sponsers != null)
	{
	    for(int i = 0; i < sponsers.length; i++)
	    {
		retVal += sponsers[i];
		homeGameMoneyEarned += sponsers[i];
	    }
	}
	return retVal;
    }
    public int getHomeMoneyEarned()
    {
    	int retVal = homeGameMoneyEarned;
    	homeGameMoneyEarned = 0;
    	return retVal;
    }
    public void setWeeklySponser(int i)
    {
	weeklySponser = i;
	
    }
    public int getWeeklySponser()
    {
    	return weeklySponser;
    }

	public double getSharedRevenue()
	{
		return sharedIncomeCount;
	}

	public double[] getTotalExpenses()
	{
		return totalExpenses;
	}
    
}
