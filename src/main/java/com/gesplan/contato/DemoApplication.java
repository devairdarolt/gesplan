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
		
		
		Contato c1 = new Contato(null, "Alfa", "alfadelta@omega.com", "Delta", "Observação 1");
		c1.getTelefones().add("(11) 1 1111-1111");
		c1.getTelefones().add("(22) 2 2222-2222");		
		
		Contato c2 = new Contato(null, "Beta", "betadelta@omega.com", "Delta", "Observação 2");
		c2.getTelefones().add("(33) 3 3333-3333");
		
		contactRepository.saveAll(Arrays.asList(c1,c2));
	}

}
