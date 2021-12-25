package co.com.sofka.domain.doctorUserInterview.events;

import co.com.sofka.domain.doctorUserInterview.values.Area;
import co.com.sofka.domain.doctorUserInterview.values.RoomID;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Objects;

public class RoomAdded extends DomainEvent {

    private final RoomID roomID;
    private final Area area;

    public RoomAdded(RoomID roomID, Area area) {
        super("sofka.doctoruserinterview.roomadded");
        this.roomID = Objects.requireNonNull(roomID);
        this.area = Objects.requireNonNull(area);
    }

    public RoomID getRoomID() {
        return roomID;
    }

    public Area getArea() {
        return area;
    }
}
