package api.utilities;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class CSVUtility {
    private String path;

    public CSVUtility(String path) {
        this.path = path;
    }

    public int getRowCount() throws IOException, CsvValidationException {
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            int rowCount = 0;
            while (reader.readNext() != null) {
                rowCount++;
            }
            return rowCount;
        }
    }

    public int getCellCount(int rowNum) throws IOException, CsvValidationException {
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            int cellCount = 0;
            String[] row = null;
            for (int i = 0; i <= rowNum; i++) {
                row = reader.readNext();
            }
            if (row != null) {
                cellCount = row.length;
            }
            return cellCount;
        }
    }

    public String getCellData(int rowNum, int colNum) throws IOException, CsvValidationException {
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            String[] row = null;
            for (int i = 0; i <= rowNum; i++) {
                row = reader.readNext();
            }
            if (row != null && colNum < row.length) {
                return row[colNum];
            }
            return "";
        }
    }
}
