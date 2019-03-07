package com.university;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
public class StudentCSVReader {
    private static final String SAMPLE_CSV_FILE_PATH = "student.csv";

    public static void main(String[] args) throws IOException {
        try (Reader reader = new BufferedReader(new FileReader(SAMPLE_CSV_FILE_PATH))) {
            try (CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {
                for (CSVRecord csvRecord : csvParser) {
                    // Accessing Values by Column Index
                    String number = csvRecord.get(0);
                    String name = csvRecord.get(1);
                    String lastname= csvRecord.get(2);
                    String group = csvRecord.get(3);

                    System.out.println("Record No - " + csvRecord.getRecordNumber());
                    System.out.println("---------------");
                    System.out.println("Number : " + number);
                    System.out.println("Name : " + name);
                    System.out.println("LastName : " + lastname);
                    System.out.println("Group : " + group);
                    System.out.println("---------------\n\n");
                }
            }
        }
    }
}
