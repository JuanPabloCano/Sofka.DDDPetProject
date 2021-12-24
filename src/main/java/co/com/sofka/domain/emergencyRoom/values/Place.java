package co.com.sofka.domain.emergencyRoom.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Place implements ValueObject<String> {

    private final String address;
    private final String description;

    public Place(String address, String description) {
        this.address = Objects.requireNonNull(address, "La dirección es requerida");
        this.description = Objects.requireNonNull(description, "La descripción es requerida");

        if (this.address.isBlank()){
            throw new IllegalArgumentException("La dirección no puede estar vacía");
        }
        if (this.description.isBlank()){
            throw new IllegalArgumentException("La descripción no puede estar vacía");
        }
        if (this.description.length() > 150){
            throw new IllegalArgumentException("La descripción no puede ser mayor a 150 caracteres");
        }
    }

    @Override
    public String value() {
        return address + " " + description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return Objects.equals(address, place.address) && Objects.equals(description, place.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, description);
    }
}
