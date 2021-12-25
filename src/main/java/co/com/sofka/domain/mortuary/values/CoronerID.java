package co.com.sofka.domain.mortuary.values;

import co.com.sofka.domain.generic.Identity;

public class CoronerID extends Identity {

    public CoronerID(String uuid) {
        super(uuid);
    }

    public CoronerID(){}

    public static CoronerID of(String uuid){
        return new CoronerID(uuid);
    }

}
