//import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Encoding
{
	private String encodedString, encodedTwo, decodedTwo, decodedString;
	
	public Encoding()
	{
		
	}
	
	public void SetEncoding (String encrypt)
	{
		encodedString = Base64.getEncoder().encodeToString(encrypt.getBytes());
		encodedTwo = Base64.getEncoder().encodeToString(encodedString.getBytes());
	}
	
	public String GetEncoding ()
	{
		return encodedTwo;
	}
	
	public void SetDecoding (String decrypt)
	{
		byte[] decodedTwoBytes = Base64.getDecoder().decode(encodedTwo);
		decodedTwo = new String(decodedTwoBytes);
		byte[] decodedBytes = Base64.getDecoder().decode(decodedTwo);
		decodedString = new String(decodedBytes);
	}
	
	public String GetDecoding ()
	{
		return decodedString;
	}
}
