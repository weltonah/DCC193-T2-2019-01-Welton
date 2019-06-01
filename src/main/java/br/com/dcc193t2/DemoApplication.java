package br.com.dcc193t2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.dcc193t2.dao.AreaConhecimentoRepository;
import br.com.dcc193t2.model.AreaConhecimento;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(DemoApplication.class, args);

	}

}
