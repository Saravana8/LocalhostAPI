package restassured;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilityClass {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
    public static Sheet s;
    public static Row r;
    public static Cell c;
    
    public static int getRowCount(String xlfile,String xlsheet ) throws IOException {
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		s=wb.getSheet(xlsheet);
		int rowcount=s.getLastRowNum();
		wb.close();
    	fi.close();
    	return rowcount;
    	
    }
    
    public static int getCellCount(String xlfile,String xlsheet, int rownum ) throws IOException {
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		s=wb.getSheet(xlsheet);
		r=s.getRow(rownum);
		int cellcount=r.getLastCellNum();
		wb.close();
    	fi.close();
    	return cellcount;
    	
    }
    
    public static String getCellData(String xlfile,String xlsheet, int rownum, int colnum ) throws IOException {
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		s=wb.getSheet(xlsheet);
		r=s.getRow(rownum);
		c=r.getCell(colnum);
		String data;
		try {
			DataFormatter formatter=new DataFormatter();
			String cellData = formatter.formatCellValue(c);
			return cellData;
			
		}
		catch(Exception e)
		{
			data="";
		}
		wb.close();
    	fi.close();
    	return data;
    	
    }
    public static void setCellData(String xlfile,String xlsheet, int rownum, int colnum, String data ) throws IOException {
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		s=wb.getSheet(xlsheet);
		r=s.getRow(rownum);
		c=r.createCell(colnum);
		c.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
    	fi.close();
    	fo.close();
    }
}
