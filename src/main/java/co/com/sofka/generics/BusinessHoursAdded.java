package co.com.sofka.generics;

import co.com.sofka.domain.generic.DomainEvent;

import java.util.Objects;

public class BusinessHoursAdded extends DomainEvent {

    private final BusinessHours businessHours;

    public BusinessHoursAdded(BusinessHours businessHours) {
        super("sofka.generics.businesshoursadded");
        this.businessHours = Objects.requireNonNull(businessHours);
    }

    public BusinessHours getBusinessHours() {
        return businessHours;
    }
}
