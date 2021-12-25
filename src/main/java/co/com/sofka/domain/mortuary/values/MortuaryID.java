package co.com.sofka.domain.mortuary.values;

import co.com.sofka.domain.generic.Identity;

public class MortuaryID extends Identity {

    public MortuaryID(String uuid) {
        super(uuid);
    }

    public MortuaryID(){}

    public static MortuaryID of(String uuid){
        return new MortuaryID(uuid);
    }

}
