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
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class Main {

    public static void main(String[] args) throws IOException {

        LocalDateTime start = LocalDateTime.now();

        String logs = new String(Files.readAllBytes(Paths.get("G:/logs402.txt")));

        final String[] lines = logs.split("\n");

        System.out.println("Total number of lines :"+lines.length);

        int counter = 0;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].contains("ERROR")) counter++;
        }

        System.out.println("Number of ERROR Logs :" + counter);

        LocalDateTime finish = LocalDateTime.now();
        System.out.println("Operation with array of Strings took "+ChronoUnit.MILLIS.between(start, finish)+"ms");
        System.out.println("----------------------------------------------");

        start = LocalDateTime.now();
        System.out.println("Lines with ''ERROR'' by readAllLines: "+Files.readAllLines(Paths.get("G:/logs402.txt"))
                .stream().filter(line -> line.contains("ERROR")).count());

        finish = LocalDateTime.now();
        System.out.println("Operation with readAllLines took "+ChronoUnit.MILLIS.between(start, finish)+"ms");
        System.out.println("----------------------------------------------");

        start = LocalDateTime.now();
        System.out.println("Lines with ''ERROR'' by lines method: "+Files.lines(Paths.get("G:/logs402.txt"))
                .filter(line -> line.contains("ERROR")).count());
        finish = LocalDateTime.now();

        System.out.println("Operation with lines method took "+ChronoUnit.MILLIS.between(start, finish)+"ms");
        System.out.println("----------------------------------------------");
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
// So, File.lines is the fastest method for filtering large TXT file