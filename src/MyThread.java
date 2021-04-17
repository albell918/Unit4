import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author Bieliaiev Oleksandr
 * @version 1.0.0
 * @project Unit4
 * @class MyThread
 * @since 17.04.2021 - 14.27
 */
public class MyThread extends Thread {
    private LocalDate date;
    private String file;

    public MyThread(LocalDate date, String file) {
        this.date = date;
        this.file = file;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public void run() {

        LocalDateTime start = LocalDateTime.now();

        try {
            LogsSearch.logsByDateToFile(this.getFile(), this.getDate());
        } catch (IOException e) {
            e.printStackTrace();
        }

        LocalDateTime finish = LocalDateTime.now();

        System.out.println(this.getName() + " has been finished at " + finish);

        System.out.println(this.getName() + " DURATION is  " +
                ChronoUnit.MILLIS.between(start, finish));


    }
}