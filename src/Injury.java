import java.util.Random;

public class Injury
{
    
	private player injuredPlayer;
	private String teamOneName, teamTwoName;
	private String quarterNum, minutesRemaining, secondsRemaining;
	private Trainer trainer;
	public Injury(player injuredPlayer, team teamOne, team teamTwo, int quarterNum, int timeRemaining, Trainer trainer)
	{
		this.injuredPlayer = injuredPlayer;
		this.trainer = trainer;
		teamOneName = teamOne.toString();
		teamTwoName = teamTwo.toString();
		this.quarterNum = "" + quarterNum;
		this.minutesRemaining = "" + (timeRemaining/60);
		if(timeRemaining%60 < 10)
		    this.secondsRemaining = "0" + timeRemaining%60;
		else
		    this.secondsRemaining = "" + timeRemaining%60;
		determineTypeOfInjury();
	}

	private void determineTypeOfInjury()
	{
		Random r = new Random();
		int type = r.nextInt(1250);
		if(type < 625)
		{
			injuredPlayer.setInjuryLength(trainer.getInjuryDuration(0));
			System.out.println(injuredPlayer.getName() + " suffered a very minor injury in the game between the " + teamOneName + " and the " + teamTwoName + " in quarter " + quarterNum + " with " + minutesRemaining + ":" + secondsRemaining +" remaining on the clock");
		}
		else if(type < 938)
		{
			injuredPlayer.setInjuryLength(trainer.getInjuryDuration(1));
			System.out.println(injuredPlayer.getName() + " suffered a minor injury in the game between the " + teamOneName + " and the " + teamTwoName + " in quarter " + quarterNum + " with " + minutesRemaining + ":" + secondsRemaining +" remaining on the clock");
		}
		else if(type < 1126)
		{
			injuredPlayer.setInjuryLength(trainer.getInjuryDuration(2));
			System.out.println(injuredPlayer.getName() + " suffered a moderate injury in the game between the " + teamOneName + " and the " + teamTwoName + " in quarter " + quarterNum + " with " + minutesRemaining + ":" + secondsRemaining +" remaining on the clock");
		}
		else if(type == 1200)
		{
			injuredPlayer.setInjuryLength(Integer.MAX_VALUE);
			System.out.println(injuredPlayer.getName() + " suffered a career-ending injury in the game between the " + teamOneName + " and the " + teamTwoName + " in quarter " + quarterNum + " with " + minutesRemaining + ":" + secondsRemaining +" remaining on the clock");
		}
		else 
		{
			injuredPlayer.setInjuryLength(trainer.getInjuryDuration(3));
			System.out.println(injuredPlayer.getName() + " suffered a major injury in the game between the " + teamOneName + " and the " + teamTwoName + " in quarter " + quarterNum + " with " + minutesRemaining + ":" + secondsRemaining +" remaining on the clock");
		}
	}
}
