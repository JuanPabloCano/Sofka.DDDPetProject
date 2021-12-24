package co.com.sofka.domain.doctorUserInterview.commands;

import co.com.sofka.domain.doctorUserInterview.values.DateSchedule;
import co.com.sofka.domain.doctorUserInterview.values.DoctorUserInterviewID;
import co.com.sofka.domain.generic.Command;

public class AddDate extends Command {

    private final DoctorUserInterviewID doctorUserInterviewID;
    private final DateSchedule dateSchedule;

    public AddDate(DoctorUserInterviewID doctorUserInterviewID, DateSchedule dateSchedule) {
        this.doctorUserInterviewID = doctorUserInterviewID;
        this.dateSchedule = dateSchedule;
    }

    public DoctorUserInterviewID getDoctorUserInterviewID() {
        return doctorUserInterviewID;
    }

    public DateSchedule getDateSchedule() {
        return dateSchedule;
    }
}
