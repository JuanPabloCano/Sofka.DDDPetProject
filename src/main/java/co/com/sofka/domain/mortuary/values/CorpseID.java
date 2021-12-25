package co.com.sofka.domain.mortuary.values;

import co.com.sofka.domain.generic.Identity;

public class CorpseID extends Identity {

    public CorpseID(String uuid) {
        super(uuid);
    }

    public CorpseID(){}

    public static CorpseID of(String uuid){
        return new CorpseID(uuid);
    }

}
