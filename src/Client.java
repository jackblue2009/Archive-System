
public class Client
{
	private String name, aName;
	private long fileNum;
	private int cpr;
	private String mCType;
	private String sCType, aType;
	private String ruling;
	
	public Client(String n, String aN, long fileNum2, int c, String mC, String sC, String aT, String r)
	{
		name = n;
		aName = aN;
		fileNum = fileNum2;
		cpr = c;
		mCType = mC;
		sCType = sC;
		aType = aT;
		ruling = r;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getAccusedName()
	{
		return aName;
	}
	
	public long getFileNumber()
	{
		return fileNum;
	}
	
	public int getCPR()
	{
		return cpr;
	}
	
	public String getMainCase()
	{
		return mCType;
	}
	
	public String getSubCase()
	{
		return sCType;
	}
	
	public String getType()
	{
		return aType;
	}
	
	public String getRuling()
	{
		return ruling;
	}
	
	public void setName (String n)
	{
		name = n;
	}
	
	public void setAccusedName (String n)
	{
		aName = n;
	}
	
	public void setFileNumber(long fN)
	{
		fileNum = fN;
	}
	
	public void setCPR(int c)
	{
		cpr = c;
	}
	
	public void setMainCase(String mC)
	{
		mCType = mC;
	}
	
	public void setSubCase(String sC)
	{
		sCType = sC;
	}
	
	public void setType (String t)
	{
		aType = t;
	}
}
