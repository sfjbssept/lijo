package com.secure;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ActiveProfiles(value = "true")
//@WebMvcTest(Application.class)
////@AutoConfigureMockMvc
@SpringBootTest
public class ApplicationTest {
	
	
	@Value("${user.user1.username}")
	private String user1Name;
	
	
	@Test 
	public void contextLoads() {
		System.out.print(user1Name);
		
	}
	
	

}
