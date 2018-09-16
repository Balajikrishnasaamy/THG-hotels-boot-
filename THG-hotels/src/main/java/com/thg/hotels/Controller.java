package com.thg.hotels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotels")
public class Controller {

	@Autowired
	private HotelService hotelservice;
	
	List<Hotel> hotel = new ArrayList<>(Arrays.asList());
	
	@RequestMapping(method=RequestMethod.POST, value="/create")
	public String create(@RequestBody Hotel hotel){
		hotelservice.create(hotel);
		return "added";
	}
	
	@RequestMapping("/getall")
	public List <Hotel> getAll() {
		return hotelservice.getAll();
	}
	
	@RequestMapping("/code={Id}")
	public List<Hotel> getbyId(@PathVariable String Id){
		return hotelservice.findByHotelID(Id);
	}
	
	@RequestMapping("/city={city}")
	public List<Hotel> getbyCity(@PathVariable String city){
		return hotelservice.findByHotelCity(city);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/update")
	public String update(@RequestBody Hotel hotel) {
		return hotelservice.update(hotel);
	}
	
	@RequestMapping("/statistics/{id}")
	public String getStatisticsbybranchCode(@PathVariable String id){
		return hotelservice.getStatisticsbybranchCode(id);
	}
	
	@RequestMapping("/gethotel/{id}/{date}")
	public Hotel findByHotelbranchDate(@PathVariable String id, @PathVariable String date){
		return hotelservice.findByHotelbranchDate(id,date);
	}

}
