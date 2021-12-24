package co.com.sofka.domain.emergencyRoom.events;

import co.com.sofka.domain.emergencyRoom.values.Rooms;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Objects;

public class RoomAdded extends DomainEvent {

    private final Rooms rooms;

    public RoomAdded(Rooms rooms) {
        super("sofka.emergencyroom.roomadded");
        this.rooms = Objects.requireNonNull(rooms);
    }

    public Rooms getRooms() {
        return rooms;
    }
}
