package com.bookmyflight.rest;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyflight.entity.Flight;
import com.bookmyflight.entity.User;
import com.bookmyflight.exception.FlightException;
import com.bookmyflight.service.FlightService;

@CrossOrigin()
@EnableTransactionManagement
@RestController
@RequestMapping("/flight")
public class FlightController {

	@Autowired
	FlightService fservice;
	
//	http://localhost:8980/flight/add
//	{
//    "flightNumber": 0,
//    "source": "Pune",
//    "destination": "Gujart",
//    "travelDate": "2021-05-01",
//    "arrivalTime": "15:20:00",
//    "departureTime": "16:30:00",
//    "price": 2000.0,
//    "availableSeats": 20
//	}

	@PostMapping(value = "/add",consumes = "application/json")
	public String addFlight(@RequestBody Flight flight, HttpSession session) {
		try {
//			User user = (User) session.getAttribute("USER");
//			
//			if(user != null && user.getIsadmin() == 1) {
				int id=fservice.addFlight(flight);
				return "Flight added with flight number "+id;
//			}else {
//				return "Only admin can add flight";
//			}
			
		} catch (FlightException e) {
			e.printStackTrace();
			return ""+e.getMessage();
		}
		
	}
	
//	http://localhost:8980/flight/fetchall
	@GetMapping(value="/fetchall",produces="application/json")
	public Collection<Flight> serachFlights(){
		return fservice.fetchAll();	
	}
	
	@GetMapping(value="/fetch",produces="application/json")  
	public ResponseEntity<?> searchFlight(@RequestParam String source,@RequestParam String destination
			,@RequestParam String date) {
		try {
			
			LocalDate dt=LocalDate.parse(date);
			Collection<Flight> flights = fservice.fetchFlightsOnCondition(source, destination, dt);
			return new ResponseEntity< Collection<Flight> >(flights,HttpStatus.OK);
			
		} catch (FlightException e) {
			
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
//	@DeleteMapping(value="/remove",produces="application/json")
//	public String removeFlight(@RequestBody Flight flight, HttpSession session) {
////		User user = (User) session.getAttribute("USER");
////		
////		if(user != null && user.getIsadmin() == 1) {
//			fservice.removeFlight(flight);
//			return "flight removed with id"+flight.getFlightNumber();
////		} else {
////			return "Only admin can remove flight";
////		}
//		
//	}
	
	@DeleteMapping(value="/remove/{fid}")
	public String removeFlight(@PathVariable int fid, HttpSession session) {
//		User user = (User) session.getAttribute("USER");
//		
//		if(user != null && user.getIsadmin() == 1) {
			fservice.removeFlight(fid);
			return "flight removed with id" + fid;
//		} else {
//			return "Only admin can remove flight";
//		}
		
	}
	
	@PutMapping(value="/update",produces="application/json")
	public String updateFlight(@RequestBody Flight flight, HttpSession session) {
		try {
//			User user = (User) session.getAttribute("USER");
//			
//			if(user != null && user.getIsadmin() == 1) {
				int id=fservice.updateFlight(flight);
				return "Flight updated with id "+id;
//			} else {
//				return "Only admin can remove flight";
//			}
//			
		} catch (FlightException e) {
			
			e.printStackTrace();
			return ""+e.getMessage();
		}
	}
}
