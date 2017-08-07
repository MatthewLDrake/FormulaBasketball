
public enum ssInvolvment
{
    LOW(15), MEDIUM(35), HIGH(50);
    private int value;
    ssInvolvment(int val)
    {
	value = val;
    }
    public int getValue()
    {
	return value;
    }
}
