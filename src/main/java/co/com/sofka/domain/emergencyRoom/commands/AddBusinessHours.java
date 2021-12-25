package co.com.sofka.domain.emergencyRoom.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.generics.BusinessHours;

import java.util.Objects;

public class AddBusinessHours extends Command {

    private final BusinessHours businessHours;

    public AddBusinessHours(BusinessHours businessHours) {
        this.businessHours = Objects.requireNonNull(businessHours);
    }

    public BusinessHours getBusinessHours() {
        return businessHours;
    }
}
