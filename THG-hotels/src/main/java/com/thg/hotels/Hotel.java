package com.thg.hotels;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Hotel {

	@Id
	private String hotel_id;
	private String branch_code;
	private String branch_city;
	private String branch_country;
	private String month_year; //format MM_YYYY
	private String water;
	private String energy;
	
	public Hotel() {
	}
	
	public Hotel(String branch_code, String branch_city, String branch_country, String month_year, String water,
			String energy) {
		super();
		this.branch_code = branch_code;
		this.branch_city = branch_city;
		this.branch_country = branch_country;
		this.month_year = month_year;
		this.water = water;
		this.energy = energy;
	}

	public String getBranch_code() {
		return branch_code;
	}

	public void setBranch_code(String branch_code) {
		this.branch_code = branch_code;
	}

	public String getBranch_city() {
		return branch_city;
	}

	public void setBranch_city(String branch_city) {
		this.branch_city = branch_city;
	}

	public String getBranch_country() {
		return branch_country;
	}

	public void setBranch_country(String branch_country) {
		this.branch_country = branch_country;
	}

	public String getMonth_year() {
		return month_year;
	}

	public void setMonth_year(String month_year) {
		this.month_year = month_year;
	}

	public String getWater() {
		return water;
	}

	public void setWater(String water) {
		this.water = water;
	}

	public String getEnergy() {
		return energy;
	}

	public void setEnergy(String energy) {
		this.energy = energy;
	}
	
	
	
}
