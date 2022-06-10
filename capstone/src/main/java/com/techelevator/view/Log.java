package com.techelevator.view;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {

    public static void log(String message) throws FileNotFoundException {

        String fileName = LocalDate.now().format(DateTimeFormatter.ISO_DATE) + " Transaction.log";
        File savingLocation = new File("logs/");
        File logFile = new File(savingLocation, fileName);
        OutputStream f = new FileOutputStream(logFile, true);

        if (!savingLocation.exists()) {
            savingLocation.mkdir();

        }

        try {
            logFile.createNewFile();

        } catch (IOException e) {
            throw new LogException(e.getMessage());

        }

        try (PrintWriter writer = new PrintWriter(f)) {
            writer.println(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + " " + message);

        }

    }
}
