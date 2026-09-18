package AssessmentDay10;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtility {
    public static String getData(int row, int cell) throws IOException {
        FileInputStream excel = new FileInputStream("./src/test/java/AssessmentDay10/Day10.xlsx");
        Workbook wb = WorkbookFactory.create(excel);
        DataFormatter df = new DataFormatter();//Even if postalCode is numeric in Excel, DataFormatter returns it as a String.
        String data = df.formatCellValue(
                wb.getSheet("Sheet1")
                        .getRow(row)
                        .getCell(cell)
        );
        wb.close();
        excel.close();
        return data;
    }
}
