package com.thg.hotels;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThgHotelsApplicationTests {

	@Autowired
	private HotelRepository repo;
	
	@Before
	public void setup() throws Exception
	{
		Hotel htl = new Hotel();
		htl.setBranch_code("MDU_01");
		htl.setBranch_city("MDU");
		htl.setBranch_country("IN");
		htl.setMonth_year("09_2018");
		htl.setEnergy("45");
		htl.setWater("55");
		repo.save(htl);
		assertNotNull(htl.getBranch_code());
	}
	
	@Test
	public void getData()
	{
        Hotel htl = repo.findOne("MDU_01");
        assertNotNull(htl);
	}
	
	@Test
	public void contextLoads() {
	}

}
