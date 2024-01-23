package com.example.jpaexample.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.jpaexample.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	// custome finder methods
	
	public User findByName(String name);
	
	public List<User> findAllByName(String n);
	
	public List<User> findByNameAndCity(String n, String c);
	
	public User findByNameStartingWith(String prefix);
	
	public User findByNameEndingWith(String suffix);
	
	public User findByNameContaining(String word);
	
	public User findByNameLike(String likePattern);
	
	public User findByNameOrderByName(String n);
	
	// JPQL query
	@Query("select u from User u")
	public List<User> getAllUsers();
	
	@Query("select u from User u where u.name = :n")
	public List<User> getUserByName(@Param("n") String name);
	
	@Query("select u from User u where u.name=:n and u.city=:c")
	public List<User> getUserByNameAndCity(@Param("n") String n, @Param("c") String c);
	
	// native query
	@Query(nativeQuery = true, value = "select * from user")
	public List<User> getUsers();
	
}
