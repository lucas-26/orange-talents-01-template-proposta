package br.com.zup.CriacaoDePropostas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CriacaoDePropostasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CriacaoDePropostasApplication.class, args);
	}

}
