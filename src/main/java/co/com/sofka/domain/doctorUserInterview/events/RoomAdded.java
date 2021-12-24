package co.com.sofka.domain.doctorUserInterview.events;

import co.com.sofka.domain.doctorUserInterview.Room;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Objects;

public class RoomAdded extends DomainEvent {

    private final Room room;

    public RoomAdded(Room room) {
        super("sofka.doctoruserinterview.roomadded");
        this.room = Objects.requireNonNull(room);
    }

    public Room getRoom() {
        return room;
    }
}
