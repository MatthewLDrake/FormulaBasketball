
public enum Tempo
{
    SLOW(12,12), MEDIUM(14,8), FAST(10,8);
    private int randTime, minimumTime;
    Tempo(int randTime, int minimumTime)
    {
	this.randTime = randTime;
	this.minimumTime = minimumTime;
    }
    public int getRandomTime()
    {
	return randTime;
    }
    public int getMinimumTime()
    {
	return minimumTime;
    }
}
