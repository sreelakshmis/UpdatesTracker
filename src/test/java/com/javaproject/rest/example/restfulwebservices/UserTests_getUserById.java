package com.javaproject.rest.example.restfulwebservices;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.javaproject.rest.example.restfulwebservices.exception.UserNotFoundException;
import com.javaproject.rest.example.restfulwebservices.user.User;
import com.javaproject.rest.example.restfulwebservices.user.UserJPAResource;
import com.javaproject.rest.example.restfulwebservices.user.UserRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTests_getUserById {

	@Autowired
	private UserJPAResource userResource;

	@MockBean
	private UserRepository userRepository;

	SimpleDateFormat dateformat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
	String strdate = "02-04-2013 11:35:42";

	@Before
	public void setUp() throws ParseException {
		User alex = new User(2, "alex", dateformat.parse(strdate));
		Optional<User> response = Optional.of(alex);
		Mockito.when(userRepository.findById(alex.getId())).thenReturn(response);
	}

	@Test
	public void whenValid_thenUserShouldBeFound() throws ParseException {
		Optional<User> actualFound = userResource.getUserById(2);
		assertEquals("alex", actualFound.get().getName());
		assertEquals(new Integer(2), actualFound.get().getId());
		assertEquals(dateformat.parse(strdate), actualFound.get().getBirthDate());

	}

	@Test(expected = UserNotFoundException.class)
	public void wheninValid_thenUserNotFoundException() throws ParseException {
		userResource.getUserById(0);
	}

	@Test(expected = UserNotFoundException.class)
	public void whenIdNull_thenUserNotFoundException() throws ParseException {
		userResource.getUserById(null);
	}

}
