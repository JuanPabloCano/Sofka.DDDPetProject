package co.com.sofka.domain.mortuary.values;

import co.com.sofka.domain.generic.Identity;

public class EmbalmerID extends Identity {

    public EmbalmerID(String uuid) {
        super(uuid);
    }

    public EmbalmerID(){}

    public static EmbalmerID of(String uuid){
        return new EmbalmerID(uuid);
    }

}
