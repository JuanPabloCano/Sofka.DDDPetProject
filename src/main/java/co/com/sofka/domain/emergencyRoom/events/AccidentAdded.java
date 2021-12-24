package co.com.sofka.domain.emergencyRoom.events;

import co.com.sofka.domain.emergencyRoom.Accident;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Objects;

public class AccidentAdded extends DomainEvent {

    private final Accident accident;

    public AccidentAdded(Accident accident) {
        super("sofka.emergencyroom.accidentadded");
        this.accident = Objects.requireNonNull(accident);
    }

    public Accident getAccident() {
        return accident;
    }
}
