package com.javaproject.rest.example.restfulwebservices;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.javaproject.rest.example.restfulwebservices.user.User;
import com.javaproject.rest.example.restfulwebservices.user.UserJPAResource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTests_CreateUser {

	@Autowired
	private UserJPAResource userResource;

	SimpleDateFormat dateformat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
	String strdate = "02-04-2013 11:35:42";
	String futureDate = "02-04-3013 11:35:42";

	@Test
	public void whenValid_thenUserShouldBeCreated() throws ParseException, URISyntaxException {
		ResponseEntity<Object> entity = userResource.createUser(new User(1, "Mary Jane", dateformat.parse(strdate)));
		assertEquals("201 CREATED", entity.getStatusCode().toString());

	}

	@Test(expected = Exception.class)
	public void whenNameInValid_thenExceptionThrown() throws ParseException {
		userResource.createUser(new User(1, "M", dateformat.parse(strdate)));
	}

	@Test(expected = Exception.class)
	public void whenDateInvalid_thenExceptionThrown() throws ParseException {
		userResource.createUser(new User(1, "Mary", dateformat.parse(futureDate)));
	}

	@Test
	public void whenIdNull_thenUserShouldBeCreated() throws ParseException {
		ResponseEntity<Object> entity = userResource.createUser(new User(null, "Mary", dateformat.parse(strdate)));
		assertEquals("201 CREATED", entity.getStatusCode().toString());

	}

}
