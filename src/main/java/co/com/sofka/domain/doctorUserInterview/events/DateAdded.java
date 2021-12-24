package co.com.sofka.domain.doctorUserInterview.events;

import co.com.sofka.domain.doctorUserInterview.values.DateSchedule;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Objects;

public class DateAdded extends DomainEvent {

    private final DateSchedule dateSchedule;

    public DateAdded(DateSchedule dateSchedule) {
        super("sofka.doctoruserinterview.dateadded");
        this.dateSchedule = Objects.requireNonNull(dateSchedule);
    }

    public DateSchedule getDateSchedule() {
        return dateSchedule;
    }
}
