package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientAppointment {

    private Integer appointmentId;
    private Doctor doctor;
    private Date appointmentDate;
    private String slot;
    private String key;
    private String appointmentTime;

}
