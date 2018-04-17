//needs apache poi jars to run
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Property_Data {
    private String FILE_NAME = "BoardData/PropertyTycoonBoardData.xlsx";
    List<List<String>> Excel = new ArrayList<>();
    
    public Property_Data() {

        try {

            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);
            
            for (int rowNum = 4; rowNum < 45; rowNum++) {
               Row r = sheet.getRow(rowNum);
               
               
               List<String> excelRow = new ArrayList();
               if (r != null) {
               for (int cn = 0; cn < 12; cn++) {
                  Cell c = r.getCell(cn);
                  
                  if (c == null) {
                      excelRow.add("N/A");
                  } else {
                    if (c.getCellTypeEnum() == CellType.STRING) {
                        excelRow.add(c.getStringCellValue());
                    } else {
                        String stringValue = Double.toString(c.getNumericCellValue());
                        excelRow.add(stringValue);
                    }
                      }
               }
               Excel.add(excelRow);
               }
               
               
            }
        } catch(IOException e){System.out.println("Cannot Find Excel File");}
        
    }
   
    public List getEntry(int i)
    {
        return Excel.get(i);
    }
}
