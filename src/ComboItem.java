public class ComboItem
{
	private String key;
	private String value;
	
	public ComboItem(String k, String v)
	{
		this.key = k;
		this.value = v;
	}
	
	@Override
	public String toString()
	{
		return key;
	}
	
	public String getKey()
	{
		return key;
	}
	
	public String getValue()
	{
		return value;
	}
}
