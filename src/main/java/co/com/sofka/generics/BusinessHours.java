package co.com.sofka.generics;

import co.com.sofka.domain.generic.ValueObject;

public class BusinessHours implements ValueObject<String> {

    private final String schedule;

    public BusinessHours(String schedule) {
        this.schedule = schedule;
    }

    public String value() {
        return null;
    }
}
