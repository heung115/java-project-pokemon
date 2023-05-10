package Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public static List<List<String>> readCSV(String filePath) {
        List<List<String>> csvData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                List<String> row = new ArrayList<>();
                for (String value : values) {
                    row.add(value);
                }
                csvData.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return csvData;
    }

    public CSVReader() {

    }
}