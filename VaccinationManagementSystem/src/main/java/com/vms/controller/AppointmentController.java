package com.vms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vms.entity.Appointment;
import com.vms.exception.RecordNotFound;
import com.vms.service.AppointmentService;

@CrossOrigin
@RestController
@RequestMapping("/vms-appointment")
public class AppointmentController {
	
	
	@Autowired
	AppointmentService appointmentService;
	
	@PostMapping
	public Appointment addAppointment(@RequestBody Appointment appointment) throws RecordNotFound{
		return appointmentService.addAppointment(appointment);
	}
	
	@PutMapping("/updateAppointment")
	public Appointment updateAppointment(@RequestBody Appointment appointment) throws RecordNotFound{
		return appointmentService.updateAppointment(appointment);
	}
	
	@DeleteMapping("/deleteAppointment")
	public Appointment deleteAppointment(@RequestBody Appointment appointment) throws RecordNotFound{
		return appointmentService.deleteAppointment(appointment);
	}
	
	@GetMapping("{appointmentId}")
	public Appointment getAppointmentById(@PathVariable int appointmentId) throws RecordNotFound{
		return appointmentService.getAppointmentById(appointmentId);
	}
	
	
	@GetMapping
	public List<Appointment> getAllAppointments() throws RecordNotFound{
		return appointmentService.getAllAppointments();
	}

}

/*

http://localhost:8085/vms-appointment/getAppointmentById/1001

*/
