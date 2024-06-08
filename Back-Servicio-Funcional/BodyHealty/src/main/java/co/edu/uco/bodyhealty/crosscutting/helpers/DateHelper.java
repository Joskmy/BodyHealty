package co.edu.uco.bodyhealty.crosscutting.helpers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public final class DateHelper {
	private DateHelper() {
        super();
    }
    
    public static final String DEFAULT_DATE = "01/01/0001";
    public static final String DEFAULT_TIME = "00:00";
    
    public static final LocalDate getDefaultDate() {
        return LocalDate.parse(DEFAULT_DATE, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static final LocalTime getDefaultTime() {
        return LocalTime.parse(DEFAULT_TIME, DateTimeFormatter.ofPattern("HH:mm"));
    }
}
