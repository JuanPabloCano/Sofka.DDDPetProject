package co.com.sofka.domain.emergencyRoom.commands;

import co.com.sofka.domain.emergencyRoom.values.AccidentID;
import co.com.sofka.domain.emergencyRoom.values.EmergencyRoomID;
import co.com.sofka.domain.emergencyRoom.values.Place;
import co.com.sofka.domain.emergencyRoom.values.TimeOfAccident;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.generics.Description;

import java.util.Objects;

public class AddAccident extends Command {

    private final EmergencyRoomID emergencyRoomID;
    private final AccidentID accidentID;
    private final Place place;
    private final TimeOfAccident timeOfAccident;
    private final Description description;

    public AddAccident(EmergencyRoomID emergencyRoomID, AccidentID accidentID, Place place,
                       TimeOfAccident timeOfAccident,
                       Description description) {
        this.emergencyRoomID = Objects.requireNonNull(emergencyRoomID);
        this.accidentID = Objects.requireNonNull(accidentID);
        this.place = Objects.requireNonNull(place);
        this.timeOfAccident = Objects.requireNonNull(timeOfAccident);
        this.description = Objects.requireNonNull(description);
    }

    public EmergencyRoomID getEmergencyRoomID() {
        return emergencyRoomID;
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
