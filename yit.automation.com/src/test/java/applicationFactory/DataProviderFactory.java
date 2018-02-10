package applicationFactory;

import dataProvider.ConfigDataProvider;
import dataProvider.ExcelDataProvider;

public class DataProviderFactory {
	
	//As name says Dataprovider Factory it will only return only which we have written
	
	
	public static ConfigDataProvider getConfig()
	{
		ConfigDataProvider config=new ConfigDataProvider();
		return config;
	}
	
	public static ExcelDataProvider getExcel()
	{
		ExcelDataProvider excel=new ExcelDataProvider();
		
			return excel;	
	}

}
