package com.javaproject.rest.example.restfulwebservices;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.javaproject.rest.example.restfulwebservices.user.User;
import com.javaproject.rest.example.restfulwebservices.user.UserJPAResource;
import com.javaproject.rest.example.restfulwebservices.user.UserRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTests_getUsers {

	@Autowired
	private UserJPAResource userResource;

	@MockBean
	private UserRepository userRepository;

	SimpleDateFormat dateformat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
	String strdate = "02-04-2013 11:35:42";

	public void dataSeup() throws ParseException {
		List<User> response = new ArrayList<>();
		response.add(new User(2, "alex", dateformat.parse(strdate)));
		response.add(new User(4, "jim cook", dateformat.parse(strdate)));
		Mockito.when(userRepository.findAll()).thenReturn(response);
	}

	@Test
	public void whenValid_thenUserListShouldBeFound() throws ParseException {
		dataSeup();
		List<User> userList = userResource.getAllUsers();
		assertEquals(2, userList.size());
		assertEquals("alex", userList.get(0).getName());
		assertEquals("jim cook", userList.get(1).getName());
		assertEquals(new Integer(2), userList.get(0).getId());
		assertEquals(new Integer(4), userList.get(1).getId());
		assertEquals(dateformat.parse(strdate), userList.get(0).getBirthDate());
		assertEquals(dateformat.parse(strdate), userList.get(1).getBirthDate());

	}

	@Test
	public void whenNull_thenEmptyListShouldBeReturned() {
		assertEquals(0, userResource.getAllUsers().size());
	}

}
