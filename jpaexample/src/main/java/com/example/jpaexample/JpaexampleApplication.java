package com.example.jpaexample;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.jpaexample.dao.UserRepository;
import com.example.jpaexample.entities.User;

@SpringBootApplication
public class JpaexampleApplication {

	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(JpaexampleApplication.class, args);
		
		UserRepository userRepository = context.getBean(UserRepository.class);
		
//		User user = new User();
//		user.setName("Shruti");
//		user.setCity("Pune");
//		
//		// save single object
//		User u1 = userRepository.save(user);
//		System.out.println(u1);
//		User user2 = new User();
//		user2.setName("Abhay");
//		user2.setCity("Pune");
//		
//		User user3 = new User();
//		user3.setName("Akshay");
//		user3.setCity("Pune");
//		
//		// Save multiple ibjects
//		Iterable<User> users = userRepository.saveAll(Arrays.asList(user2, user3));
//		
//		users.forEach(u -> {System.out.println(u);});
		
		
		// updating value
//		Optional<User> opt = userRepository.findById(4);	// returns Optional
//		User u1 = opt.get();
//		u1.setCity("Mumbai");
//		userRepository.save(u1);
//		System.out.println(u1);
		
		// getting data
//		Iterable<User> users = userRepository.findAll();	//returns Iterable
//		Iterator<User> iterator = users.iterator();
//		while(iterator.hasNext()) {
//			User u = iterator.next();
//			System.out.println(u);
//		}
		
		// delete user
//		userRepository.deleteById(2);
//		userRepository.findAll().forEach(u->System.out.println(u));
		
		// delete all users
//		Iterable<User> us = userRepository.findAll();
//		userRepository.deleteAll(us);
//		userRepository.findAll().forEach(u->System.out.println(u));
		
		// find by name
//		User u = userRepository.findByName("Abhay");
//		System.out.println(u);
		
		// find by name and city
//		userRepository.findByNameAndCity("Akshay", "Pune").stream().forEach(System.out::println);
//		userRepository.findByNameAndCity("Akshay", "Pune").forEach(System.out::println);
		
		// jpql queries
//		userRepository.getAllUsers().forEach(System.out::println);
		
//		userRepository.getUserByName("Abhay").forEach(System.out::println);
//		
//		userRepository.getUserByNameAndCity("Shruti", "Pune").forEach(System.out::println);
		
		// native queries
		userRepository.getUsers().forEach(System.out::println);
	}

}
