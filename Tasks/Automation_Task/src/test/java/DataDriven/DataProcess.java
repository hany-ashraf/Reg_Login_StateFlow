package DataDriven;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProcess {

    @DataProvider(name = "TestDriven")
    public static Object[][] provideData() throws IOException {
        List<Object[]> data = new ArrayList<>();
        FileInputStream fis = new FileInputStream(new File("src/main/resources/DataForTest.xlsx"));
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rows = sheet.iterator();
        rows.next(); // Skip header row

        while (rows.hasNext()) {
            Row row = rows.next();

            // Check if any of the cells in the row have data (non-empty)
            if (isRowNotEmpty(row)) {
                String firstName = getCellValueAsString(row.getCell(0));
                String lastName = getCellValueAsString(row.getCell(1));
                String country = getCellValueAsString(row.getCell(2));
                String phone = getCellValueAsString(row.getCell(3));
                String email = getCellValueAsString(row.getCell(4));
                String password = getCellValueAsString(row.getCell(5));

                data.add(new Object[]{firstName, lastName, country, phone, email, password});
            }
        }

        workbook.close();
        fis.close();

        return data.toArray(new Object[0][0]);
    }

    private static boolean isRowNotEmpty(Row row) {
        // Iterate through all cells in the row to check if any cell contains data
        for (Cell cell : row) {
            if (getCellValueAsString(cell).trim().length() > 0) {
                return true; // Row contains data
            }
        }
        return false; // Row is empty
    }

    private static String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return ""; // Return empty string if the cell is null
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((int) cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return ""; // Return empty string for other types or blank cells
        }
    }
}
