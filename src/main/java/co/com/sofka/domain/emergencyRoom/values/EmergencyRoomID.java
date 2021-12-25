package co.com.sofka.domain.emergencyRoom.values;

import co.com.sofka.domain.generic.Identity;

public class EmergencyRoomID extends Identity {

    public EmergencyRoomID(String uuid) {
        super(uuid);
    }
    public EmergencyRoomID() {}

    public static EmergencyRoomID of(String uuid){
        return new EmergencyRoomID(uuid);
    }

}
