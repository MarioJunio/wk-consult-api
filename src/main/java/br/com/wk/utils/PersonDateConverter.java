package br.com.wk.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonDateConverter {

    public static String convertDateFormat(String inputDate) {
        try {
            // Create a SimpleDateFormat with the input format
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");

            // Parse the input date string to a Date object
            Date date = inputDateFormat.parse(inputDate);

            // Create a new SimpleDateFormat with the MySQL default format
            SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Format the Date object to the MySQL default format
            return outputDateFormat.format(date);
        } catch (ParseException e) {
            // Handle the exception if the input date is not in the expected format
            System.err.println("Error parsing date: " + e.getMessage());
            return null;
        }
    }

    public static String processSqlInsert(String sqlInsert) {
        // Extract the date from the SQL insert instruction
        String inputDate = sqlInsert.split("VALUES")[1].split(",")[3].replace("'", "").trim();

        // Convert the date format
        String convertedDate = convertDateFormat(inputDate);

        // Replace the original date in the SQL insert instruction with the converted date
        return sqlInsert.replace(inputDate, convertedDate);
    }

    public static void main(String[] args) {
        String inputFile = "C:\\Users\\devma\\workspace\\wk-consult\\src\\main\\resources\\db\\migration\\V2__insert_data.sql"; // Provide the path to your SQL insert instructions file

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Process each SQL insert instruction
                String updatedSqlInsert = processSqlInsert(line);
                System.out.println(updatedSqlInsert);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
