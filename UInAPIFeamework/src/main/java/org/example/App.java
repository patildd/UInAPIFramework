package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String datestr= "2022-07-30T10:15:30";


        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-YYYY:HH:MM:SS");
        LocalDateTime ld = LocalDateTime.parse(datestr,DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        ld= ld.plusDays(5);
        System.out.println(ld.getDayOfMonth()+" "+ld.getMonth());
        //ld.plusDays(5);

        try( BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\logs.ext"))) {
           writer.write(ld.format(dateTimeFormatter));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
