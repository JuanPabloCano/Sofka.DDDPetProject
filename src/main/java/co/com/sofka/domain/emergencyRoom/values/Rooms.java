package co.com.sofka.domain.emergencyRoom.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
import java.util.Set;

public class Rooms implements ValueObject<Set<String>> {

    private final Set<String> rooms;

    public Rooms(Set<String> rooms) {
        this.rooms = Objects.requireNonNull(rooms, "Los cuartos son requeridos");

        if (this.rooms.isEmpty()){
            throw new IllegalArgumentException("Los cuartos no pueden estar vacíos");
        }
    }

    @Override
    public Set<String> value() {
        return rooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rooms rooms1 = (Rooms) o;
        return Objects.equals(rooms, rooms1.rooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rooms);
    }
}
