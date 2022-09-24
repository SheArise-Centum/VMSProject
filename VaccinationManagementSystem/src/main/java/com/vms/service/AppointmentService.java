package com.vms.service;

import java.util.List;

import com.vms.entity.Appointment;
import com.vms.entity.VaccineRegistration;
import com.vms.exception.RecordNotFound;

public interface AppointmentService {
	
	public Appointment addAppointment(Appointment appointment) throws RecordNotFound;
	public Appointment updateAppointment(Appointment appointment) throws RecordNotFound;
	public Appointment deleteAppointment(Appointment appointment) throws RecordNotFound;
	public Appointment getAppointmentById(int appointmentId) throws RecordNotFound;
	public List<Appointment> getAllAppointments() throws RecordNotFound;

}
