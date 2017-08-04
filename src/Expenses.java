
public class Expenses
{
	private double[] weeklyExpenses;
	public Expenses(double[] expenses)
	{
		weeklyExpenses = new double[expenses.length];
		for(int i = 0; i < expenses.length; i++)
		{
			weeklyExpenses[i] = (expenses[i]/21)*1000000;
		}
	}
	
	public int chargeExpenses(int fianance)
	{
		int retVal = fianance;
		for(int i = 0; i < weeklyExpenses.length; i++)
		{
			retVal -= weeklyExpenses[i];
		}
		return retVal;
	}
}
