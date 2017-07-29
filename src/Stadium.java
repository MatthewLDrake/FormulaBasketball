import java.util.Random;

public class Stadium
{
	private int capacityLevel, concessionLevel, overallQualityLevel;
	private float cheapSeatsPrice, averageSeatsPrice, highEndSeatsPrice, luxuryBoxesPrice;
	private int cheapSeatsCount, averageSeatsCount, highEndSeatsCount, luxuryBoxesCount;
	public Stadium(float[] seatPrices)
	{
		capacityLevel = 1;
		concessionLevel = 1;
		overallQualityLevel = 1;

		cheapSeatsPrice = seatPrices[0];
		averageSeatsPrice = seatPrices[1];
		highEndSeatsPrice = seatPrices[2];
		luxuryBoxesPrice = seatPrices[3];

		startUp();
	}
	public Stadium(int[] levels, float[] seatPrices)
	{
		capacityLevel = levels[0];
		concessionLevel = levels[1];
		overallQualityLevel = levels[2];

		cheapSeatsPrice = seatPrices[0];
		averageSeatsPrice = seatPrices[1];
		highEndSeatsPrice = seatPrices[2];
		luxuryBoxesPrice = seatPrices[3];

		startUp();
	}
	private void startUp()
	{
		int maxCapacity = getMaxCapacity();

		cheapSeatsCount = Math.round(maxCapacity * (1/3));
		averageSeatsCount = Math.round(maxCapacity * (1/2));
		highEndSeatsCount = maxCapacity - (cheapSeatsCount+averageSeatsCount);
		luxuryBoxesCount = 5;
	}
	public void upgradeCapacity()
	{
		capacityLevel++;
		startUp();
	}
	public void upgradeConcessions()
	{
		concessionLevel++;		
	}
	public void upgradeOverallQuality()
	{
		overallQualityLevel++;		
	}
	public attendance getAttendance(team teamOne, team teamTwo, boolean playoffs)
	{
		int numCheapSeats = cheapSeatsCount;
		int numAverageSeats = averageSeatsCount;
		int numHighEndSeats = highEndSeatsCount;
		int numLuxurySeats = luxuryBoxesCount*10;
		int numLuxuryBoxesUsed = 5;
		if(!playoffs)
		{
			numCheapSeats = getCheapSeatsAttending(teamOne.getTeamResults().getTeamTier(), teamTwo.getTeamResults().getTeamTier());
			numAverageSeats = getAverageSeatsAttending(teamOne.getTeamResults().getTeamTier(), teamTwo.getTeamResults().getTeamTier());
			numHighEndSeats = getHighEndSeatsAttending(teamOne.getTeamResults().getTeamTier(), teamTwo.getTeamResults().getTeamTier());
			int temp[] = getLuxuryBoxSeatsAttending(teamOne.getTeamResults().getTeamTier(), teamTwo.getTeamResults().getTeamTier());
			numLuxurySeats = temp[0];
			numLuxuryBoxesUsed = temp[1];
		}
		int price = Math.round(numCheapSeats*cheapSeatsPrice+numAverageSeats*averageSeatsPrice+numHighEndSeats*highEndSeatsPrice+numLuxuryBoxesUsed*luxuryBoxesPrice);

		return new attendance(numCheapSeats+numAverageSeats+numHighEndSeats+numLuxurySeats,price);
	}
	private int[] getLuxuryBoxSeatsAttending(teamTier teamTier, teamTier teamTier2)
	{
		int max = 0;
		int min = 0;
		int peopleInBoxMin = 0;
		int peopleInBoxMax = 0;
		
		Random rand = new Random();
		
		if(teamTier.equals(teamTier2))
		{
			max = luxuryBoxesCount;
			peopleInBoxMax = 10;
			peopleInBoxMin = peopleInBoxMax - (5-overallQualityLevel);
			int temp = 0;
			if(overallQualityLevel == 1)temp = -3;
			else if(overallQualityLevel <= 3)temp = -2;
			else if(overallQualityLevel == 4)temp = -1;
			min = max+temp;
		}
		else if(teamTier.compareTo(teamTier2) > 0)
		{
			max = luxuryBoxesCount;
			peopleInBoxMax = 10;
			peopleInBoxMin = peopleInBoxMax - (8-overallQualityLevel);
			int temp = overallQualityLevel - 6;
			min = max+temp;
		}
		else
		{
			max = luxuryBoxesCount;
			peopleInBoxMax = 10;
			peopleInBoxMin = peopleInBoxMax - (10-(overallQualityLevel*2));
			int temp = -1;
			if(overallQualityLevel <= 2)temp = -5;
			else if(overallQualityLevel <= 4)temp = -3;
			min = max+temp;
		}
		
		

		int randomNum = rand.nextInt((max - min) + 1) + min;
		int sum = 0;
		for(int i = 0; i < randomNum; i ++)
		{
			sum += rand.nextInt((peopleInBoxMax - peopleInBoxMin) + 1) + peopleInBoxMin;
		}
		
		return new int[] {sum, randomNum};
	}
	private int getHighEndSeatsAttending(teamTier teamTier, teamTier teamTier2)
	{
		int max = 0;
		int min = 0;
		if(highEndSeatsPrice < 60)return highEndSeatsCount;
		if(teamTier.equals(teamTier2))
		{
			max = highEndSeatsCount;
			min = max - (5-overallQualityLevel)*100;
		}
		else if(teamTier.compareTo(teamTier2) > 0)
		{
			max = highEndSeatsCount;
			min = max - (5-overallQualityLevel)*250;
		}
		else
		{
			max = highEndSeatsCount- (5-overallQualityLevel)*100;
			min = max - (5-overallQualityLevel)*1000;
		}
		
		Random rand = new Random();

		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
	private int getAverageSeatsAttending(teamTier teamTier, teamTier teamTier2)
	{
		int max = 0;
		int min = 0;
		
		if(averageSeatsPrice < 30)return averageSeatsCount;
		
		if(teamTier.equals(teamTier2))
		{
			max = averageSeatsCount;
			min = max - (5-overallQualityLevel)*100;
		}
		else if(teamTier.compareTo(teamTier2) > 0)
		{
			max = averageSeatsCount;
			min = max - (5-overallQualityLevel)*250;
		}
		else
		{
			max = averageSeatsCount- (5-overallQualityLevel)*100;
			min = max - (5-overallQualityLevel)*1000;
		}
		
		Random rand = new Random();

		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
	private int getCheapSeatsAttending(teamTier teamTier, teamTier teamTier2)
	{
		int max = 0;
		int min = 0;

		if(cheapSeatsPrice < 10)
		{
			return cheapSeatsCount;
		}
		else if(cheapSeatsPrice < 25)
		{
			max = cheapSeatsCount;
			min = max - (5-overallQualityLevel)*100;
		}
		else
		{
			max = cheapSeatsCount- (5-overallQualityLevel)*100;
			min = max - (5-overallQualityLevel)*100;
		}
		Random rand = new Random();

		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
	public int getConcessionsSold(int attendance)
	{
		return attendance*this.concessionLevel;
	}
	private int getMaxCapacity()
	{
		int maxCapacity = 0;
		switch(capacityLevel)
		{
		case 1:
			maxCapacity = 10000;
			break;
		case 2:
			maxCapacity = 12500;
			break;
		case 3:
			maxCapacity = 15000;
			break;
		case 4:
			maxCapacity = 17500;
			break;
		case 5:
			maxCapacity = 20000;
			break;
		}
		return maxCapacity;
	}
}
class attendance
{
	int numberAttending, income;
	attendance(int number, int income)
	{
		this.numberAttending = number;
		this.income = income;

	}
}
