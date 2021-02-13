package com.example1.example1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VBean04Controller {
	public final VBean03Service usersService;

	@Autowired
	public VBean04Controller (VBean03Service usersService) {
		this.usersService=usersService;

	}
	@GetMapping(path="/users")
	public List<VBean01> getAllUsers(){
		return usersService.getUsers();
	}

	@GetMapping (path="getuserbyid/{id}")
	public Optional<VBean01> getUserById(@PathVariable(value="id") Integer userId){
		return VBean03Service.getStudentById(userId);
	}
	@PostMapping(path="/adduser")
	public void inserNewUser(@RequestBody VBean01 user) {
		VBean03Service.addnewUser(user);
	}
	@DeleteMapping(path="/deletebyid/{id}")
	public String deleteUserById(@PathVariable(value="id")Integer userId) {
		return VBean03Service.deleteuserById(userId);
	}
	@PutMapping(path="/updatebyid/{id}")
	public ResponseEntity<VBean01> updateUserById(@PathVariable(value="id") Integer userId,@Validated @RequestBody VBean01 newUser){
		return ResponseEntity.ok(VBean03Service.updateUser(userId, newUser));
	}
	/*
	 *@PutMapping(path="/api/v1/update/{studentId}")
	public ResponseEntity<SB20StudentBean> updateStudentById(@PathVariable(value="studentId") Long studentId, @Validated @RequestBody SB20StudentBean newStudent) {

		return ResponseEntity.ok(SB22StudentBeeanService.updateStudent(studentId, newStudent));
	}
	 */


}
