package com.example1.example1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;



@Service
public class VBean03Service {
	public static VBean02Repo usersRepo;

	@Autowired
	public VBean03Service (VBean02Repo usersRepo) {
		this.usersRepo= usersRepo;

	}
	//For Get Method
	public static List<VBean01> getUsers(){
		return usersRepo.findAll();

	}

	//For Get Request By ID
	public static Optional<VBean01> getStudentById(Integer userId) {

		return usersRepo.findById(userId);

	}

	//for Post Request
	public static void addnewUser(VBean01 userBean) {
		Optional <VBean01> userIdOptional= usersRepo.findById(userBean.getJ_id());
		if(userIdOptional.isPresent()) {
			throw new IllegalStateException("Id Already used, use other id");
		}
		usersRepo.save(userBean);
	}


	//For Delete Request

	public static String deleteuserById(Integer userId) {
		boolean isExist=usersRepo.existsById(userId);
		if(!isExist) {
			throw new IllegalStateException("ID Cannot be Found, try with correct id, no any data deleted");

		}
		usersRepo.deleteById(userId);
		return "User with id: "+ userId+ " is deleted successfully";
	}

	//PutRequest
	@Transactional
	public static VBean01 updateUser(Integer userId, @RequestBody VBean01 newUser) {
		VBean01 existingUser=usersRepo.findById(userId).orElseThrow(()->new IllegalStateException("User with "+userId+" does not exist"));
		//String existingName=existingUser.getName();
		//String existingLName= existingUser.getLastName();
		if(newUser.getName()==null && newUser.getLastName()==null) {
			existingUser.setName(null);
			existingUser.setLastName(null);
		}else if(newUser.getName()==null) {
			existingUser.setName("You must Enter Name");

		}else if(newUser.getLastName()==null) {
			existingUser.setLastName("You Must Enter LastName");

		}

		else if(existingUser.getName()==null || existingUser.getLastName()==null) {
			existingUser.setName(newUser.getName());
			existingUser.setLastName(newUser.getLastName());
		}else if((!existingUser.equals(newUser.getName()) || !existingUser.equals(newUser.getLastName()))) {
			existingUser.setName(newUser.getName());
			existingUser.setLastName(newUser.getLastName());
		}


		double existingSalary= existingUser.getSalary();
		if(newUser.getSalary()==0.00) {
			existingUser.setSalary(0.00);

		}else if(existingUser.getSalary()==0.00) {

			existingUser.setSalary(newUser.getSalary());
		}else if(existingUser.getSalary()!=newUser.getSalary()) {

			existingUser.setSalary(newUser.getSalary());
		}else {
			existingUser.setSalary(existingSalary);
		}




		return usersRepo.save(existingUser);
	}
	/*


		/// To Update Email
		String existingEmail = existingStudent.getEmail();

		if(newStudent.getEmail()==null) {

			existingStudent.setEmail(null);

		}else if(existingStudent.getEmail()==null) {

			existingStudent.setEmail(newStudent.getEmail());

		}else if(!existingEmail.equals(newStudent.getEmail())) {

			existingStudent.setEmail(newStudent.getEmail());

		}else {
			throw new IllegalStateException("Email must be unique...");
		}




	 */



}
