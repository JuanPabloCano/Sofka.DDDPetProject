package co.com.sofka.domain.doctorUserInterview.values;

import co.com.sofka.domain.generic.Identity;

public class RoomID extends Identity {

    public RoomID(String uuid) {
        super(uuid);
    }

    public RoomID(){}

    public static RoomID of(String uuid){
        return new RoomID(uuid);
    }

}
