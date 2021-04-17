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

        System.out.println("Time for extracting ERROR logs for 5 days :" + ChronoUnit.MILLIS.between(start, finish) + "ms");

        System.out.println("----------------------------------------------");

        System.out.println("Task3 - Multithreading:");

        for (int i = 0; i < 5; i++) {
            new MyThread(date.plusDays(i), "E:/logs402.txt").start();

        }

    }


}


//        Total number of lines :2845607
//        Number of ERROR Logs :361
//        Operation with array of Strings took 3177ms
//        ----------------------------------------------
//        Lines with ''ERROR'' by readAllLines: 361
//        Operation with readAllLines took 1714ms
//        ----------------------------------------------
//        Lines with ''ERROR'' by lines method: 361
//        Operation with lines method took 1579ms
//        ----------------------------------------------
//        Task 2:
//        Time for extracting ERROR logs for 5 days :7494ms
//        ----------------------------------------------
//        Task3 - Multithreading:
//        Thread-2 has been finished at 2021-04-17T15:54:21.389710800
//        Thread-2 DURATION is  1669
//        Thread-1 has been finished at 2021-04-17T15:54:21.528632
//        Thread-1 DURATION is  1808
//        Thread-3 has been finished at 2021-04-17T15:54:22.081287100
//        Thread-3 DURATION is  2361
//        Thread-0 has been finished at 2021-04-17T15:54:22.107275
//        Thread-0 DURATION is  2390
//        Thread-4 has been finished at 2021-04-17T15:54:22.132253700
//        Thread-4 DURATION is  2365
//
//Conclusion: By paralleling tasks on threads, we can greatly reduce time, required for task execution.
//In this case from 7.5 to 2.5 seconds.
// However, threads are chaotic and the order in which they complete their work cannot be predicted.
