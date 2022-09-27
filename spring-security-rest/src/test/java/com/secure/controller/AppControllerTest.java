package com.secure.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.Base64Utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.secure.entity.Employee;

@RunWith(SpringRunner.class)
@WebMvcTest({ AppController.class })
@ActiveProfiles(value = "true")
public class AppControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Value("${user.user1.username}")
	private String user1Name;

	@Value("${user.user1.password}")
	private String user1Password;

	@Value("${user.user2.username}")
	private String user2Name;

	@Value("${user.user2.password}")
	private String user2Password;

	@Value("${emp.get.url}")
	private String getUrl;

	@Value("${emp.post.url}")
	private String postUrl;

	@Value("${emp.put.url}")
	private String putUrl;

	@Value("${emp.delete.url}")
	private String deleteUrl;

	@Test
	public void testEmployeeGet() throws Exception {

		ResultActions responseEntity = processApiRequest(getUrl, HttpMethod.GET, null, null, user1Name, user1Password);
		responseEntity.andExpect(status().isOk());
		String result = responseEntity.andReturn().getResponse().getContentAsString();
		assertEquals("Get Employee", result);
	}

	private ResultActions processApiRequest(String api, HttpMethod methodType, String name, Employee employee,
			String username, String password) {

		ResultActions response = null;
		String secret = "Basic " + Base64Utils.encodeToString((username + ":" + password).getBytes());
		try {
			switch (methodType) {
			case GET:
				// response = mockMvc.perform(get(api).header(HttpHeaders.AUTHORIZATION, secret));
				 response = mockMvc.perform(get(api).with(user(username).password(password).roles("USER")));
				break;
			case POST:
				response = mockMvc.perform(post(api)
						          .with(user(username).password(password).roles("ADMIN"))
						          .contentType(MediaType.APPLICATION_JSON)
						          .content(asJsonString(employee))
						          .accept(MediaType.APPLICATION_JSON));
				break;
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		return response;
	}

	private String asJsonString(Employee employee) {
		try {
           final ObjectMapper mapper =new ObjectMapper();
           final String jsonContentString = mapper.writeValueAsString(employee);
           return jsonContentString;
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		return null;
	}

	@Test
	public void testEmployeePost() throws Exception {
		Employee employee = createEmployee("test", "dev");
		ResultActions responseEntity = processApiRequest(postUrl, HttpMethod.POST, null, employee, user2Name,
				user2Password);
		responseEntity.andExpect(status().isOk());
		ObjectMapper mapper = new ObjectMapper();

		Employee result = mapper.readValue(responseEntity.andReturn().getResponse().getContentAsString(),
				Employee.class);

		assertEquals("test", result.getName());
		assertEquals("dev", result.getRole());
	}

	private Employee createEmployee(String name, String role) {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		emp.setName(name);
		emp.setRole(role);
		return emp;
	}

}
