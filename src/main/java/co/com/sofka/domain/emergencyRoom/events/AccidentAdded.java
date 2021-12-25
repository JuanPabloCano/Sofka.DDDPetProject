package co.com.sofka.domain.emergencyRoom.events;

import co.com.sofka.domain.emergencyRoom.values.AccidentID;
import co.com.sofka.domain.emergencyRoom.values.Place;
import co.com.sofka.domain.emergencyRoom.values.TimeOfAccident;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.Description;

import java.util.Objects;


public class AccidentAdded extends DomainEvent {

    private final AccidentID accidentID;
    private final Place place;
    private final TimeOfAccident timeOfAccident;
    private final Description description;

    public AccidentAdded(AccidentID accidentID, Place place, TimeOfAccident timeOfAccident, Description description) {
        super("sofka.emergencyroom.accidentadded");
        this.accidentID = Objects.requireNonNull(accidentID);
        this.place = Objects.requireNonNull(place);
        this.timeOfAccident = Objects.requireNonNull(timeOfAccident);
        this.description = Objects.requireNonNull(description);
    }

    public AccidentID getAccidentID() {
        return accidentID;
    }

    public Place getPlace() {
        return place;
    }

    public TimeOfAccident getTimeOfAccident() {
        return timeOfAccident;
    }

    public Description getDescription() {
        return description;
    }
}
