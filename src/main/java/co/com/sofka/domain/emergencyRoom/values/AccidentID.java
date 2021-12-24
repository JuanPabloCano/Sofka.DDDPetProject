package co.com.sofka.domain.emergencyRoom.values;
import co.com.sofka.domain.generic.Identity;

public class AccidentID extends Identity {

    public AccidentID(String uuid) {
        super(uuid);
    }

    public AccidentID(){}

    public static AccidentID of(String uuid){
        return new AccidentID(uuid);
    }

}
