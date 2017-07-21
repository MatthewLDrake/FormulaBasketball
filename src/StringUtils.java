
public class StringUtils
{

	public String rightPad(String teamName, int i)
	{
		if(teamName.length() >= i)return teamName;
		for(int j = teamName.length(); j < i; j++)
		{
			teamName = teamName + " ";
		}
		
		
		return teamName;
	}

}
