import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class inputHelper 
{

	public static String getInput(String prompt)
	{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in)) ;
		
		System.out.print (prompt);
		System.out.flush();
		
		try
		{
			return stdin.readLine();
		}
		catch (Exception e)
		{
			return "Error: " + e.getMessage();
		}
		
	}
	
	
	// converts input to double and throws exception at failure
	public static double getDoubleInput(String prompt) throws NumberFormatException
	{
		String input = getInput(prompt) ;
		return Double.parseDouble(input);
	}
	
	public static int getIntInput (String prompt) throws NumberFormatException
	{
		String input = getInput(prompt);
		return Integer.parseInt(input);
	}
	public static Date getDateInput (String prompt) throws ParseException
	{
		String input = getInput(prompt);
		DateFormat format = new SimpleDateFormat("YYYY-MM-DD", Locale.ENGLISH);
		Date date = format.parse(input);
		return date;
		
	}
}
