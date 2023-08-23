package api.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CommonUtility {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public String path;
	
	public CommonUtility(String path)
	{
		this.path=path;
	}
	
	public int getRowcount(String SheetName) throws IOException
	{
		fi =new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(SheetName);
		int rowcount=sh.getLastRowNum();
		fi.close();
		return rowcount;
	}
	
	public int getcellCount(String SheetName,int rownum)throws IOException
	{
		fi =new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(SheetName);
		row=sh.getRow(rownum);
		int cellcount=row.getLastCellNum();
		return cellcount;
	}
	
	public String getCellDat(String SheetName,int rownum,int coulumn) throws IOException
	{
		fi =new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(SheetName);
		row=sh.getRow(rownum);
		cell=row.getCell(coulumn);
		
		DataFormatter formatter=new DataFormatter();
		String data;
		try
		{
		   data=formatter.formatCellValue(cell);
		}
		catch(Exception e)
		{
			data=" ";
		}
		
		wb.close();
		fi.close();
		return data;
	}
	
	
	
	
	
	
	
	
	
	
}
