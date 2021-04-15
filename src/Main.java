/**
 * @author Bieliaiev Oleksandr
 * @version 1.0.0
 * @project Unit4
 * @class Main
 * @since 10.04.2021 - 17.50
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.temporal.ChronoUnit;


public class Main {

    public static void main(String[] args) throws IOException {

        LocalDateTime start = LocalDateTime.now();

        String logs = new String(Files.readAllBytes(Paths.get("E:/logs402.txt")));

        final String[] lines = logs.split("\n");

        System.out.println("Total number of lines :" + lines.length);

        int counter = 0;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].contains("ERROR")) counter++;
        }

        System.out.println("Number of ERROR Logs :" + counter);

        LocalDateTime finish = LocalDateTime.now();
        System.out.println("Operation with array of Strings took " + ChronoUnit.MILLIS.between(start, finish) + "ms");
        System.out.println("----------------------------------------------");

        start = LocalDateTime.now();
        System.out.println("Lines with ''ERROR'' by readAllLines: " + Files.readAllLines(Paths.get("E:/logs402.txt"))
                .stream().filter(line -> line.contains("ERROR")).count());

        finish = LocalDateTime.now();
        System.out.println("Operation with readAllLines took " + ChronoUnit.MILLIS.between(start, finish) + "ms");
        System.out.println("----------------------------------------------");

        start = LocalDateTime.now();
        System.out.println("Lines with ''ERROR'' by lines method: " + Files.lines(Paths.get("E:/logs402.txt"))
                .filter(line -> line.contains("ERROR")).count());
        finish = LocalDateTime.now();

        System.out.println("Operation with lines method took " + ChronoUnit.MILLIS.between(start, finish) + "ms");
        System.out.println("----------------------------------------------");

        System.out.println("Task 2: ");


        start = LocalDateTime.now();


        LocalDate date = LocalDate.of(2020, Month.FEBRUARY, 14);

        for (int i = 0; i < 5; i++) {
            LogsSearch.logsByDateToFile("E:/logs402.txt", date.plusDays(i));
        }


        finish = LocalDateTime.now();

        System.out.println("Time for extracting ERROR logs for 5 days :"+ChronoUnit.MILLIS.between(start, finish)+"ms");

    }


}


//Total number of lines :2845607
//Number of ERROR Logs :361
//Operation with array of Strings took 3277ms
//----------------------------------------------
//Lines with ''ERROR'' by readAllLines: 361
//Operation with readAllLines took 1718ms
//----------------------------------------------
//Lines with ''ERROR'' by lines method: 361
//Operation with lines method took 1708ms
//----------------------------------------------
// So, File.lines is faster method for filtering large TXT file than String.split
//----------------------------------------------
//Task 2:
//Size of Error logs file forE:/LogsWithERROR2020-02-14.log 102.963125Kb
//Size of Error logs file forE:/LogsWithERROR2020-02-15.log 54.334625Kb
//Size of Error logs file forE:/LogsWithERROR2020-02-16.log 2.856375Kb
//Size of Error logs file forE:/LogsWithERROR2020-02-17.log 111.767125Kb
//Size of Error logs file forE:/LogsWithERROR2020-02-18.log 108.363625Kb
//Time for extracting ERROR logs for 5 days :8089ms