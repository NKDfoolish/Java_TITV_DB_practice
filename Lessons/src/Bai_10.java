import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Bai_10 {
    public static void main(String[] args) {
        /*LocalDate local_date = LocalDate.now();
        System.out.println(local_date);*/

        /*LocalTime local_time = LocalTime.now();
        System.out.println(local_time);*/

        LocalDateTime local_date_time = LocalDateTime.now();
        System.out.println(local_date_time);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String fm = local_date_time.format(formatter);
        System.out.println(fm);
    }
}
