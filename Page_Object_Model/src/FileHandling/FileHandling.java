package FileHandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileHandling {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		/*FileHandling obj= new FileHandling();
		obj.createFolder();
		obj.createFile();
		obj.writeFile();
		obj.ReadFile();*/
		//String data ="data.xlsx";
	//int l=	data.indexOf(".");
		//System.out.println(data.substring(l));
			ReadExcel("C:\\Users\\abc\\Desktop", "Book1.xlsx", "Sheet1");
	}
	public  void createFolder()
	{
		File file = new File("D:\\TestFolder");
		if(!file.exists())
			file.mkdirs();
	}
	
	public void createFile() throws IOException
	{
		File file= new File("D:\\TestFolder\\test.txt");
		file.createNewFile();
	}

	public void writeFile() throws IOException
	{
		FileWriter fw = new FileWriter(new File("D:\\TestFolder\\test.txt"));
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("here are the content");
		bw.flush();
		bw.close();
		
	}
	
	public void ReadFile() throws IOException
	{String val;
		FileReader fr = new FileReader(new File("D:\\TestFolder\\test.txt"));
		BufferedReader br = new BufferedReader(fr);
		while ((val=br.readLine())!=null)
		{
			System.out.println(val);
		}
		br.close();
		
	}
	public static void ReadExcel(String filePath,String fileName,String sheetName) throws IOException{
    	
    	//Create a object of File class to open xlsx file

		File file =    new File(filePath+"\\"+fileName);

		 
       
        //Create an object of FileInputStream class to read excel file

        FileInputStream inputStream = new FileInputStream(file);
        Workbook obj = null;
        
        //Find the file extension by spliting file name in substring and getting only extension name

        String fileExtensionName = fileName.substring(fileName.indexOf("."));
        
     
        
        //Check condition if the file is xlsx file

        if(fileExtensionName.equals(".xlsx")){

        //If it is xlsx file then create object of XSSFWorkbook class

        obj = new XSSFWorkbook(inputStream);

        }

        //Check condition if the file is xls file

        else if(fileExtensionName.equals(".xls")){

            //If it is xls file then create object of XSSFWorkbook class

            obj = new HSSFWorkbook(inputStream);

        }

        //Read sheet inside the workbook by its name

        Sheet sheet = obj.getSheet(sheetName);

        //Find number of rows in excel file

        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

        //Create a loop over all the rows of excel file to read it

        for (int i = 0; i < rowCount+1; i++) {

            Row row = sheet.getRow(i);

            //Create a loop to print cell values in a row

            for (int j = 0; j < row.getLastCellNum(); j++) {

                //Print excel data in console

                System.out.print(row.getCell(j).getStringCellValue()+"|| ");

            }

            System.out.println();

        }

        

    }

    
 public static void writeExcel(String filePath,String fileName,String sheetName,String[] dataToWrite) throws IOException{

        //Create a object of File class to open xlsx file

        File file =    new File(filePath+"\\"+fileName);

        //Create an object of FileInputStream class to read excel file

        FileInputStream inputStream = new FileInputStream(file);

        Workbook obj = null;

        //Find the file extension by spliting file name in substing and getting only extension name

        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        //Check condition if the file is xlsx file

        if(fileExtensionName.equals(".xlsx")){

        //If it is xlsx file then create object of XSSFWorkbook class

        	obj = new XSSFWorkbook(inputStream);

        }

        //Check condition if the file is xls file

        else if(fileExtensionName.equals(".xls")){

            //If it is xls file then create object of XSSFWorkbook class

        	obj = new HSSFWorkbook(inputStream);

        }

        

    //Read excel sheet by sheet name    

    Sheet sheet = obj.getSheet(sheetName);

    //Get the current count of rows in excel file

    int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

    //Get the first row from the sheet

    Row row = sheet.getRow(0);

    //Create a new row and append it at last of sheet

    Row newRow = sheet.createRow(rowCount+1);

    //Create a loop over the cell of newly created Row

    for(int j = 0; j < row.getLastCellNum(); j++){
        //Fill data in row

        Cell cell = newRow.createCell(j);
        cell.setCellValue(dataToWrite[j]);
    }
    //Close input stream

    inputStream.close();

    //Create an object of FileOutputStream class to create write data in excel file

    FileOutputStream outputStream = new FileOutputStream(file);

    //write data in the excel file

    obj.write(outputStream);

    //close output stream

    outputStream.close();    

    }
 
  
 
 
 

}

	

