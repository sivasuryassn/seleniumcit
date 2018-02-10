package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider

{
	
	// Why we required global variable here i need to use in different methods
	Properties pro;
	
	
public ConfigDataProvider()
{
	File src = new File(System.getProperty("user.dir") + "/Configuration/config.properties");
	
	try {
		FileInputStream fis = new FileInputStream(src);
		
		pro=new Properties();
		
		pro.load(fis);
	} catch (Exception e) {
		
		System.out.println("Error: Failed to load config file"+e.getMessage());
		
	}
	}
	

//Below method never be void  since it returning string 

public String getTestApplicationURL()
{
	
	String data=pro.getProperty("testUrl");
	
	return data;
	
}
public String getPtodApplicationURL()
{
	
	String data=pro.getProperty("prodUrl");
	return data;
}
public String getUATApplicationURL()
{
	
	String data=pro.getProperty("uatUrl");
	return data;
}


// This method will return whatever we pass // This one is called jeneric method
public String getValue(String key)
{
	String data=pro.getProperty(key);
	
	return data;
	
}

}
