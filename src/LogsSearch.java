
/**
 * @author Bieliaiev Oleksandr
 * @version 1.0.0
 * @project Unit4
 * @class LogsSearch
 * @since 10.04.2021 - 17.40
 */


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class LogsSearch {

    private String file;

    public LogsSearch() {
    }

    public LogsSearch(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }


    public static List <String> logsByDate(String file, LocalDate date) throws IOException
    {
        String dateAsString = date.toString();
        List<String> list = Files.lines(Paths.get(file))
                .filter(log -> log.contains(dateAsString))
                .collect(Collectors.toList());

        return list;
    }

    public static void logsByDateToFile(String file, LocalDate date) throws IOException {

        String dateAsString = date.toString();
        List<String> list = Files.lines(Paths.get(file))
                .filter(log -> log.contains(dateAsString))
                .collect(Collectors.toList());

        String str = "";
        for(String log: list){
            str += log + '\n';
        }

        String fileOutput = "E:/LogsWith" +  "ERROR" + dateAsString + ".log";
        Files.write(Paths.get(fileOutput), str.getBytes(StandardCharsets.UTF_8));
        long bytes = Files.size(Paths.get(fileOutput));
        System.out.println("Size of Error logs file for"+fileOutput+" "+bytes/8000.0+"Kb");


    }

}
