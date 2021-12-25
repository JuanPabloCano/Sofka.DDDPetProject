package co.com.sofka.domain.emergencyRoom.commands;

import co.com.sofka.domain.emergencyRoom.values.Rooms;
import co.com.sofka.domain.generic.Command;

import java.util.Objects;

public class AddRoom extends Command {

    private final Rooms rooms;

    public AddRoom(Rooms rooms) {
        this.rooms = Objects.requireNonNull(rooms);
    }

    public Rooms getRooms() {
        return rooms;
    }
}
