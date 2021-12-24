package co.com.sofka.domain.doctorUserInterview.commands;

import co.com.sofka.domain.doctorUserInterview.Room;
import co.com.sofka.domain.doctorUserInterview.values.DoctorUserInterviewID;
import co.com.sofka.domain.generic.Command;

public class AddRoom extends Command {

    private final DoctorUserInterviewID doctorUserInterviewID;
    private final Room room;

    public AddRoom(DoctorUserInterviewID doctorUserInterviewID, Room room) {
        this.doctorUserInterviewID = doctorUserInterviewID;
        this.room = room;
    }

    public DoctorUserInterviewID getDoctorUserInterviewID() {
        return doctorUserInterviewID;
    }

    public Room getRoom() {
        return room;
    }
}
