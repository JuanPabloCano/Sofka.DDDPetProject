package co.com.sofka.domain.doctorUserInterview.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.BusinessHours;

import java.util.Objects;

public class BusinessHoursAdded extends DomainEvent {

    private final BusinessHours businessHours;

    public BusinessHoursAdded(BusinessHours businessHours) {
        super("sofka.doctoruserinterview.businesshoursadded");
        this.businessHours = Objects.requireNonNull(businessHours);
    }

    public BusinessHours getBusinessHours() {
        return businessHours;
    }
}
