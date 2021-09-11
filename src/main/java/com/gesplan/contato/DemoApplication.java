package com.gesplan.contato;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gesplan.contato.entity.Contato;
import com.gesplan.contato.repositories.ContatoRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private ContatoRepository contactRepository; 
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {		
		
		
		/*Contato c1 = new Contato(null, "Devair", "devairdarolt@gmail.com", "Darolt", "obs 1");
		c1.getTelefones().add("(47) 9 9665-4736");
		c1.getTelefones().add("(66) 6 6666-6666");
		c1.getTelefones().add("(99) 9 9999-9999");
		Contato c2 = new Contato(null, "Denilso", "denilsodarolt@gmail.com", "Darolt", "obs 2");
		c2.getTelefones().add("(96) 9 9696-9696");
		
		contactRepository.saveAll(Arrays.asList(c1,c2));*/
	}

}
