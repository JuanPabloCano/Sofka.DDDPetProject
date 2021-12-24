package co.com.sofka.domain.emergencyRoom.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDateTime;
import java.util.Objects;

public class TimeOfAccident implements ValueObject<LocalDateTime> {

    private final LocalDateTime dateTime;

    public TimeOfAccident(LocalDateTime dateTime) {
        this.dateTime = Objects.requireNonNull(dateTime, "La fecha es requerida");

        if (this.dateTime.isBefore(LocalDateTime.now())){
            throw new IllegalArgumentException("La fecha no puede ser en pasado");
        }
    }

    @Override
    public LocalDateTime value() {
        return dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeOfAccident that = (TimeOfAccident) o;
        return Objects.equals(dateTime, that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime);
    }
}

