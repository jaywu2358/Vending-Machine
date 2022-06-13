package com.techelevator.view;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Log {

    public static void log(String message) throws FileNotFoundException {
        DateFormat date = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
        String dateString = date.format(new Date()).toString();

        String fileName = LocalDate.now().format(DateTimeFormatter.ISO_DATE) + " Transaction.log";
        File savingLocation = new File("C:\\Users\\Student\\workspace\\java-mini-capstone-module-1-team-3\\capstone\\src\\main\\java\\com\\techelevator");
        File logFile = new File(savingLocation, fileName);
        OutputStream f = new FileOutputStream(logFile, true);

        try {
            logFile.createNewFile();

        } catch (IOException e) {
            throw new LogException(e.getMessage());

        }

        try (PrintWriter writer = new PrintWriter(f)) {

            writer.println(dateString + "\t" + message);

        }
    }
}
