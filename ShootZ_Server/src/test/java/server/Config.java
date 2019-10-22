package test.java.server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config
{
	private static final String FILE = "./config.properties";
	public static int PORT;
	public static String HOST, LOGIN, PASSWORD;
	static
	{
		Properties property = new Properties();
		FileInputStream in = null;
		
		try
		{
			in = new FileInputStream(FILE);
			property.load(in);
			
			PORT = Integer.parseInt(property.getProperty("PORT"));
			HOST = property.getProperty("DB_HOST");
			LOGIN = property.getProperty("DB_LOGIN");
			PASSWORD = property.getProperty("DB_PASSWORD");		
		} catch (FileNotFoundException ex)
		{
			System.err.println("Konfig ne nayden!");
		} catch (IOException ex)
		{
			System.err.println("Oshibka pri chtenii fayla!");
		} finally
		{
			try
			{
				in.close();
			} catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
