package api.Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "Data")
	public String[][] getAllData() throws IOException
	{
		String path=System.getProperty("user.dir")+"//TestData//Book1.xlsx";
		CommonUtility common=new CommonUtility(path);
		
		int rownum=common.getRowcount("Sheet1");
		int columnCount=common.getcellCount("Sheet1",1);
		
		String apidata[][]=new String [rownum][columnCount];
		
		for(int a=1;a<=rownum;a++)
		{
			for(int b=0;b<columnCount;b++)
			{
				apidata[a-1][b]=common.getCellDat("Sheet1",a,b);
			}
		}
		return apidata;
	}
	
	@DataProvider(name = "UserNames")
	public String[] getUserNames() throws IOException
	{
		String path=System.getProperty("user.dir")+"//TestData//Book1.xlsx";
		CommonUtility common=new CommonUtility(path);
		
		int rownum=common.getRowcount("Sheet1");
		String apidata[] =new String [rownum];
		for(int a=1;a<=rownum;a++)
		{
			apidata[a-1]=common.getCellDat("Sheet1", a, 1);
		}
		return apidata;
		
	}	
	
	
	
	
	
	
	
	
	
	
	
}
