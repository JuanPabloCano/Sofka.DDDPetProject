package co.com.sofka.domain.emergencyRoom;

import co.com.sofka.domain.emergencyRoom.values.AccidentID;
import co.com.sofka.domain.emergencyRoom.values.Place;
import co.com.sofka.domain.emergencyRoom.values.TimeOfAccident;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.generics.Description;

import java.util.Objects;

public class Accident extends Entity<AccidentID> {

    protected AccidentID accidentID;
    protected Place place;
    protected TimeOfAccident timeOfAccident;
    protected Description description;

    public Accident(AccidentID accidentID, Place place, TimeOfAccident timeOfAccident,
                    Description description) {
        super(accidentID);
        this.accidentID = Objects.requireNonNull(accidentID);
        this.place = Objects.requireNonNull(place);
        this.timeOfAccident = Objects.requireNonNull(timeOfAccident);
        this.description = Objects.requireNonNull(description);
    }

    public void addPlace(Place place){
        this.place = place;
    }

    public void addTime(TimeOfAccident timeOfAccident){
        this.timeOfAccident = timeOfAccident;
    }

    public void addDescription(Description description){
        this.description = description;
    }

    public AccidentID accidentID() {
        return accidentID;
    }

    public Place place() {
        return place;
    }

    public TimeOfAccident timeOfAccident() {
        return timeOfAccident;
    }

    public Description description() {
        return description;
    }
}
