package com.example1.example1;

import org.springframework.data.jpa.repository.JpaRepository;



public interface VBean02Repo extends JpaRepository<VBean01, Integer> {

	//Optional<VBean01> findVBean01ById(Integer id);

}
