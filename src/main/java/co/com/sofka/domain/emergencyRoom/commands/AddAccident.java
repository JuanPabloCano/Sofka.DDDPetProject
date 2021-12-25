package co.com.sofka.domain.emergencyRoom.commands;

import co.com.sofka.domain.emergencyRoom.Accident;
import co.com.sofka.domain.generic.Command;

import java.util.Objects;

public class AddAccident extends Command {

    private final Accident accident;

    public AddAccident(Accident accident) {
        this.accident = Objects.requireNonNull(accident);
    }

    public Accident getAccident() {
        return accident;
    }
}
