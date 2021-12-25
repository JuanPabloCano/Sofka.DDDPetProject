package co.com.sofka.domain.emergencyRoom.values;
import co.com.sofka.domain.generic.Identity;

public class SpecialistID extends Identity {

    public SpecialistID(String uuid) {
        super(uuid);
    }
    public SpecialistID() {}

    public static SpecialistID of(String uuid){
        return new SpecialistID(uuid);
    }

}
