package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.RegisterUser;
import com.employee.repository.UserRepository;

@RestController
public class LoginController {



  @Autowired private UserRepository userRepository;

  @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
  public ResponseEntity<String> persistPerson(@RequestBody RegisterUser registerUser) {
	  
	  List userList = userRepository.getUser(registerUser.getUsername(),registerUser.getPassword());
     
	  
   if(userList.size()!= 0){
	   RegisterUser registerUser1=(RegisterUser) userList.get(0);
      return new ResponseEntity<>( registerUser1.getId()+"", HttpStatus.OK);
  }else{
	 
	  return new ResponseEntity<>(" Invalid User Name / Password ...", HttpStatus.FORBIDDEN);
  }
  
  }
 
}
