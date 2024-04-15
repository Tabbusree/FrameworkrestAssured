package api.utilities;
import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.opencsv.exceptions.CsvValidationException;
public class DataProviders {
    @DataProvider(name = "Data")
    public String[][] getAllData() throws IOException, CsvValidationException {
        String path = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\UserData.csv";
        CSVUtility csv = new CSVUtility(path);

        int rownum = csv.getRowCount();
        int colcount = csv.getCellCount(0); // Assuming first row contains headers

        // Exclude header ro\

        rownum--;

        String apidata[][] = new String[rownum][colcount];

        for (int i = 1; i <= rownum; i++) {
            for (int j = 0; j < colcount; j++) {
                // Exclude headers by starting from the second row (index 1)
                apidata[i - 1][j] = csv.getCellData(i, j);
            }
        }
        return apidata;
    }

    @DataProvider(name = "UserNames")
    public String[] getUserNames() throws IOException, CsvValidationException {
        String path = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\UserData.csv";
        CSVUtility csv = new CSVUtility(path);

        int rownum = csv.getRowCount();

        // Exclude header row
        rownum--;

        String apidata[] = new String[rownum];

        for (int i = 1; i <= rownum; i++) {
            // Exclude headers by starting from the second row (index 1)
            apidata[i - 1] = csv.getCellData(i, 1);
        }
        return apidata;
    }
}
