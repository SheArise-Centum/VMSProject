package com.vms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.entity.Appointment;
import com.vms.exception.RecordNotFound;
import com.vms.repositories.AppointmentRepository;

@Service("AppointmentService")
public class AppointmentServiceImpl implements AppointmentService{
	
	@Autowired
	AppointmentRepository appointmentRepository;

	@Override
	public Appointment addAppointment(Appointment appointment)  throws RecordNotFound  {
		appointmentRepository.saveAndFlush(appointment);
		return appointment;
	}

	@Override
	public List<Appointment> getAllAppointments()  throws RecordNotFound  {
		return appointmentRepository.findAll();
	}

	@Override
	public Appointment getAppointmentById(int appointmentId) throws RecordNotFound {
		Appointment  bean = null;
		try {
			bean = appointmentRepository.findById(appointmentId).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Appointment details not found!");
		}
		return bean;
	}

	@Override
	public Appointment updateAppointment(Appointment appointment)  throws RecordNotFound {
		Appointment  bean = null;
		try {
			bean = appointmentRepository.findById(appointment.getBookingId()).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Appointment details not found!");
		}
		appointmentRepository.saveAndFlush(appointment);
		return appointment;
	}

	@Override
	public Appointment deleteAppointment(Appointment appointment)  throws RecordNotFound  {
		Appointment  bean = null;
		try {
			bean = appointmentRepository.findById(appointment.getBookingId()).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Appointment details not found!");
		}
		appointmentRepository.deleteById(appointment.getBookingId());
		return appointment;
	}

}
