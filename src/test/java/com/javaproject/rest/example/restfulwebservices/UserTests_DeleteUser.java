package com.javaproject.rest.example.restfulwebservices;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.javaproject.rest.example.restfulwebservices.user.User;
import com.javaproject.rest.example.restfulwebservices.user.UserRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTests_DeleteUser {

	@Autowired
	private UserRepository userRepository;

	SimpleDateFormat dateformat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
	String strdate = "02-04-2013 11:35:42";

	@Test
	public void whenValid_thenUserDeleted() throws ParseException {
		userRepository.delete(new User(2, "alex", dateformat.parse(strdate)));

	}

	@Test(expected = Exception.class)
	public void whenNull_thenThrowException() throws ParseException {
		userRepository.delete(new User(null, "", new Date()));
	}

}
