package co.com.sofka.domain.doctorUserInterview.commands;

import co.com.sofka.domain.doctorUserInterview.values.DoctorUserInterviewID;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.generics.BusinessHours;

import java.util.Objects;

public class AddBusinessHours extends Command {

    private final DoctorUserInterviewID doctorUserInterviewID;
    private final BusinessHours businessHours;

    public AddBusinessHours(DoctorUserInterviewID doctorUserInterviewID, BusinessHours businessHours) {
        this.doctorUserInterviewID = Objects.requireNonNull(doctorUserInterviewID);
        this.businessHours = Objects.requireNonNull(businessHours);
    }

    public DoctorUserInterviewID getDoctorUserInterviewID() {
        return doctorUserInterviewID;
    }

    public BusinessHours getBusinessHours() {
        return businessHours;
    }
}
