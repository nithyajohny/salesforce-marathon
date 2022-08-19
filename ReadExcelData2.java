package marathon3;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelData2 {


	public static String[][] readData(String excelFileName) throws IOException {
		// TODO Auto-generated method stub

		XSSFWorkbook wbk=new XSSFWorkbook("data/"+excelFileName+".xlsx");
		XSSFSheet sheet=wbk.getSheetAt(0);
		int rowcount=sheet.getLastRowNum();
		short columncount=sheet.getRow(0).getLastCellNum();
		//System.out.println("row count"+rowcount);
		//System.out.println("Column count"+columncount);
		 
		String[][] data=new String [rowcount][columncount];
		for(int i=1;i<=rowcount;i++)
		 {
			 XSSFRow row=sheet.getRow(i);
			 for (int j=0;j<columncount;j++)
			 {
				 XSSFCell cell=row.getCell(j);
				 System.out.println(cell.getStringCellValue());
				 data[i-1][j]=cell.getStringCellValue();
			 }
		 }
		
		wbk.close();
		return data;
	}

}
