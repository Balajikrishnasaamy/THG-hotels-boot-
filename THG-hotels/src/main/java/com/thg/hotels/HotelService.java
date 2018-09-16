package com.thg.hotels;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

	@Autowired
	private HotelRepository hotelrepo;
	
	List<Hotel> hotel = new ArrayList<>();
	//create hotels
	public void create(Hotel h)
	{
		hotelrepo.save(h);
		hotel = hotelrepo.findAll();
	}
	
	//retrives hotes
	public List<Hotel> getAll(){
		if(hotel.isEmpty())
		{
			hotel = hotelrepo.findAll();
		}
		return hotel;
	}
	
	public List<Hotel> findByHotelID(String branch_id){
		List<Hotel> hotels = new ArrayList<>();
		hotel = getAll();
		Hotel h = null;
		for(int i = 0; i < hotel.size(); i++)
		{
			h = hotel.get(i);
			if(h.getBranch_code().equalsIgnoreCase(branch_id))
			{
				hotels.add(h);
			}
		}
		return hotels;
	}
	
	public List<Hotel> findByHotelCity(String branch_city){
		List<Hotel> hotels = new ArrayList<>();
		List<Hotel> shotels = new ArrayList<>();
		hotels = getAll();
		Hotel h = null;
		for(int i = 0; i < hotels.size(); i++)
		{
			h = hotels.get(i);
			if(h.getBranch_city().equalsIgnoreCase(branch_city))
			{
				shotels.add(h);
			}
		}
		return shotels;
	}
	
	public Hotel findByHotelbranchDate(String branch_code, String branch_date){
		List<Hotel> hotels = new ArrayList<>();
		hotels = getAll();
		Hotel h = null;
		for(int i = 0; i < hotels.size(); i++)
		{
			h = hotels.get(i);
			if(h.getBranch_code().equalsIgnoreCase(branch_code) && h.getMonth_year().equals(branch_date))
			{
				return h;
			}
			h = null;
		}
		return h;
	}
	//getting mesurement statistics for every branch
	 public String getStatisticsbybranchCode(String branch_code)
	 {
		 List<Hotel> htl =  findByHotelID(branch_code);
		 Hotel h = null;
		 String returnString = "";
		 int old_water = 0,curr_water = 0,old_energy = 0,curr_energy = 0;
		 double water = 0, energy = 0;
		 Calendar c = Calendar.getInstance();
		 String date = "";
		 int year = c.get(Calendar.YEAR);
		 int month = c.get(Calendar.MONTH);
		 String current_date = "";
		 String mth = ""+month;
		 if(month < 10)
		 {
			 mth = 0+""+month;
		 }
		 current_date = mth+"_"+year;
		 boolean six = false, three = false;
		 if(htl.size() > 5)
			 six = true;
		 else if(htl.size() > 2)
			 three = true;

			date = getdateRange(month,year,6);
		 if(six)
		 {
			h = findByHotelbranchDate(branch_code, current_date);
			Hotel old_htl = findByHotelbranchDate(branch_code, date);
			if(old_htl == null)
			return "-->"+date+"-->";
			if(h != null && old_htl != null)
			{
				curr_water = Integer.valueOf(h.getWater());
				curr_energy = Integer.valueOf(h.getEnergy());
				old_water = Integer.valueOf(old_htl.getWater());
				old_energy = Integer.valueOf(old_htl.getEnergy());
				
				water = ((curr_water * 100) / old_water) - 100;
				energy = ((curr_energy * 100) / old_energy) - 100;
				if (water < 0)
					returnString += "\nWater usage for last six months has been reduced to "+ Math.abs(water)+"% [Moving in a good direction]";
				else
					returnString += "\nWater usage for last six months has been increased to "+ water+"% [needs to be concerned]";
				if (energy < 0)
					returnString += "\nEnergy usage for last six months has been reduced to "+ Math.abs(energy)+"% [Moving in a good direction]";
				else
					returnString += "\nEnergy usage for last six months has been increased to "+ energy+"% [needs to be concerned]";
			}
			else
				return "no data available for current month";
		 }
		 else
		 {
			 returnString += "\nNo data available for last 6 months ["+date+"]";
		 }

		date = getdateRange(month,year,3);
		 if(six || three)
		 {
			h = findByHotelbranchDate(branch_code, current_date);
			Hotel old_htl = findByHotelbranchDate(branch_code, date);
			if(h != null && old_htl != null)
			{
				curr_water = Integer.valueOf(h.getWater());
				curr_energy = Integer.valueOf(h.getEnergy());
				old_water = Integer.valueOf(old_htl.getWater());
				old_energy = Integer.valueOf(old_htl.getEnergy());
				
				water = ((curr_water * 100) / old_water) - 100;
				energy = ((curr_energy * 100) / old_energy) - 100;
				if (water < 0)
					returnString += "\nWater usage for last three months has been reduced to "+ Math.abs(water)+"% [Moving in a good direction]";
				else
					returnString += "\nWater usage for last three months has been increased to "+ water+"% [needs to be concerned]";
				if (energy < 0)
					returnString += "\nEnergy usage for last three months has been reduced to "+ Math.abs(energy)+"% [Moving in a good direction]";
				else
					returnString += "\nEnergy usage for last three months has been increased to "+ energy+"% [needs to be concerned]";
			}
		 }
		 else
		 {
			 returnString += "\nNo data available for last 3 months ["+date+"]";
		 }
		 
		 return "\t*****Statistics for "+branch_code+"*****\n"+returnString;
	 }
	 public String getdateRange(int month, int year, int value)
	 {
		 String date = "";
		 String mnth = "";
		 month = month - value;
		 if(month < 1)
		 {
			 month = 12 - month;
			 year = year - 1;
		 }		 
		 mnth = ""+month;
		 if(month < 10)
		 {
			 mnth = 0+""+month;
		 }
		 return mnth+"_"+year;
	 }
	//update hotel
	public String update(Hotel hotel) {
		hotelrepo.save(hotel);
		return "updated";
	}

}
