package co.com.sofka.domain.doctorUserInterview.values;

import co.com.sofka.domain.generic.Identity;

public class UserID extends Identity {

    public UserID(String uuid) {
        super(uuid);
    }

    public UserID(){}

    public static UserID of(String uuid){
        return new UserID(uuid);
    }

}
