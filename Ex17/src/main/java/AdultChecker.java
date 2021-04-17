import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AdultChecker {

    public boolean isAdult(String pesel) {
        LocalDate today = LocalDate.now();
        long diff = ChronoUnit.YEARS.between(peselToYear(pesel), today);
        return diff >= 18;
    }

    private LocalDate peselToYear(String pesel) {
        boolean isXXICentury = pesel.charAt(2) == '2' || pesel.charAt(2) == '3';

        int year = isXXICentury ? 2000 : 1900;
        year += Integer.parseInt(pesel.subSequence(0, 2).toString());
        int month = Integer.parseInt(pesel.subSequence(2, 4).toString());
        int day = Integer.parseInt(pesel.subSequence(4, 6).toString());

        if (isXXICentury) {
            month -= 20;
        }
        return LocalDate.of(year, month, day);
    }

}
