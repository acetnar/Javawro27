package pl.sda.rafal.zientara.programowanie2.lesson4;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class DatesMain {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now(); //dzien
        LocalDateTime dateTime = LocalDateTime.now(); // dzien, godzina
        ZonedDateTime zonedDataTime = ZonedDateTime.now(); // dzien, godzina, strefa czasowa

        System.out.println(localDate);
        System.out.println(dateTime);
        System.out.println(zonedDataTime.withZoneSameInstant(ZoneId.of("Libya")));


//        Set<String> allZones = ZoneId.getAvailableZoneIds();
//        for (String zone: allZones) {
//            System.out.println(zone);
//        }
        System.out.println("------------------");
        String input = "07-06-2017";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate output = LocalDate.parse(input, formatter);
        System.out.println(output);
        System.out.println( output.minusDays(10));

        findFridays();


//        System.out.println("------------------");
//        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//        String date2 = output.format(formatter2);
//        System.out.println(date2);
//        System.out.println( date2.minusDays(10l));

    }

    private static void findFridays() {
        LocalDate currentDate = LocalDate.now();
        System.out.println(currentDate.getDayOfWeek());
        int fridaysCount = 0;
        while (fridaysCount < 5) {
            DayOfWeek dayOFWeek = currentDate.getDayOfWeek();
            if (dayOFWeek != DayOfWeek.FRIDAY) {
                currentDate = currentDate.plusDays(1);
            }else {
                System.out.println(currentDate);
                currentDate = currentDate.plusWeeks(1);
                fridaysCount++;
            }
        }
    }
}
