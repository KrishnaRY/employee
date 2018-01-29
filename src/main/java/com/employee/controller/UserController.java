package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.RegisterUser;
import com.employee.repository.UserRepository;

@RestController
public class UserController {



  @Autowired private UserRepository userRepository;

  @RequestMapping(value = "/addUser", method = RequestMethod.POST)
  public ResponseEntity<String> persistPerson(@RequestBody RegisterUser registerUser) {
   if(userRepository.getUserCount(registerUser.getUsername())== 0){
    	userRepository.persist(registerUser);
  	
      return new ResponseEntity<>( HttpStatus.CREATED);
  }else{
	 
	  return new ResponseEntity<>("User Name Already Exist...", HttpStatus.FOUND);
  }
  
  }
  
  /*** Retrieve all Users ***/
  
  @RequestMapping(value="/users",produces="application/json",
          method=RequestMethod.GET)
  public List getAllUsers()
  {
      List userList = userRepository.getAllUsers();
      return userList;
  }
  
  /*** Update a User ***/
  
  @RequestMapping(value="/updateUser", method=RequestMethod.POST, 
          produces="application/json", consumes="application/json")
  public ResponseEntity<String> updateUser(@RequestBody RegisterUser registerUser)
  {
	  userRepository.updateUser(registerUser);
	  return ResponseEntity.status(HttpStatus.OK).build();
  }
  
  /*** Delete a User ***/
  
  @RequestMapping(value="/delete/{user_ID}",method = RequestMethod.DELETE,
           produces="application/json")
  public ResponseEntity<String> deleteUser(@PathVariable("user_ID") int user_ID)
  {
	  userRepository.deleteUser(user_ID);
	  return ResponseEntity.status(HttpStatus.OK).build();
  }
  
  
 /*** Retrieve all Users ***/
  
  @RequestMapping(value="/getUser/{userId}",produces="application/json",
          method=RequestMethod.GET)
  public List getAllUsers(@PathVariable("userId") int userId)
  {
      List userList = userRepository.getUser(userId);
      return userList;
  }
  
}
