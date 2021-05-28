package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.PatientRepository;
import com.example.demo.entites.Patient;

@SpringBootApplication
public class SpringMvcApplication implements CommandLineRunner {

	@Autowired
	private PatientRepository patientRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		patientRepository.save( new Patient(null, "toto", new Date(), false,7));
		patientRepository.save( new Patient(null, "tata", new Date(), false,98));
		patientRepository.save( new Patient(null, "titi", new Date(), true,5));
		patientRepository.save( new Patient(null, "bobo", new Date(), true,0));
		patientRepository.save( new Patient(null, "bibi", new Date(), false,7));
		patientRepository.save( new Patient(null, "toto", new Date(), false,7));
		patientRepository.save( new Patient(null, "tata", new Date(), false,3));
		patientRepository.save( new Patient(null, "titi", new Date(), true,98));
		patientRepository.save( new Patient(null, "bobo", new Date(), true,7));
		patientRepository.save( new Patient(null, "bibi", new Date(), false,90));
		patientRepository.save( new Patient(null, "toto", new Date(), false,45));
		patientRepository.save( new Patient(null, "tata", new Date(), false,54));
		patientRepository.save( new Patient(null, "titi", new Date(), true,45));
		patientRepository.save( new Patient(null, "bobo", new Date(), true,8));
		patientRepository.save( new Patient(null, "bibi", new Date(), false,22));
		patientRepository.save( new Patient(null, "toto", new Date(), false,700));
		patientRepository.save( new Patient(null, "tata", new Date(), false,456));
		patientRepository.save( new Patient(null, "titi", new Date(), true,98));
		patientRepository.save( new Patient(null, "bobo", new Date(), true,234));
		patientRepository.save( new Patient(null, "bibi", new Date(), false,70));
		
		patientRepository.findAll().forEach(p->{System.out.println(p.getName());});
	}

}
