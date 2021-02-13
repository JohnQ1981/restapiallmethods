package com.example1.example1;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VBean05Config {
	@Bean
	CommandLineRunner commandLineUsers(VBean02Repo usersRepo) {
		return arg->{
			for(int i=100; i<150; i++) {
				VBean01 p=new VBean01(100+i,"Name"+i, "LastName "+i, i+15000);
				i++;
				usersRepo.saveAll(List.of(p));
			}

		};

	}

}
