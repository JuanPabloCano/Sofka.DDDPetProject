package co.com.sofka.domain.doctorUserInterview.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Area implements ValueObject<String> {

    private final String hospitalArea;

    public Area(String hospitalArea) {
        this.hospitalArea = Objects.requireNonNull(hospitalArea);
        if (this.hospitalArea.isBlank()){
            throw new IllegalArgumentException("El área del hospital no puede estar vacía");
        }
    }

    @Override
    public String value() {
        return hospitalArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return Objects.equals(hospitalArea, area.hospitalArea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hospitalArea);
    }
}
