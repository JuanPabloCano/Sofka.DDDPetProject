package co.com.sofka.domain.doctorUserInterview;

import co.com.sofka.domain.doctorUserInterview.values.Area;
import co.com.sofka.domain.doctorUserInterview.values.RoomID;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Room extends Entity<RoomID> {

    protected RoomID roomID;
    protected Area area;


    public Room(RoomID roomID, Area area) {
        super(roomID);
        this.area = Objects.requireNonNull(area);
    }

    public void addArea(Area area){
        this.area = area;
    }

    public void updateArea(Area area){
        this.area = area;
    }

    public Area area() {
        return area;
    }

    public RoomID roomID() {
        return roomID;
    }
}
