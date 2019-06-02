package br.com.dcc193t2;

import java.util.Arrays;
import java.util.Collections;

import javax.crypto.NullCipher;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.dcc193t2.dao.AreaConhecimentoRepository;
import br.com.dcc193t2.dao.AvaliadorRepository;
import br.com.dcc193t2.dao.RevisaoRepository;
import br.com.dcc193t2.dao.TrabalhoRepository;
import br.com.dcc193t2.model.AreaConhecimento;
import br.com.dcc193t2.model.Avaliador;
import br.com.dcc193t2.model.Revisao;
import br.com.dcc193t2.model.Trabalho;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	AreaConhecimentoRepository areaConhecimentoRepository;

	@Autowired
	AvaliadorRepository avaliadorRepository;

	@Autowired
	RevisaoRepository revisaoRepository;

	@Autowired
	TrabalhoRepository trabalhoRepository;


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			areaConhecimentoRepository.save(new AreaConhecimento(null, "Exatas"));
			areaConhecimentoRepository.save(new AreaConhecimento(null, "Biológicas"));
			areaConhecimentoRepository.save(new AreaConhecimento(null, "Engenharias"));
			areaConhecimentoRepository.save(new AreaConhecimento(null, "Saúde"));
			areaConhecimentoRepository.save(new AreaConhecimento(null, "Socias Aplicadas"));
			areaConhecimentoRepository.save(new AreaConhecimento(null, "Humanas"));
			areaConhecimentoRepository.save(new AreaConhecimento(null, "Linguística, Letras e Artes"));
			trabalhoRepository.save(new Trabalho(null, "trabalho fisica", "teoria da relatividade", "google.com.br",
					areaConhecimentoRepository.findById(1L).get()));
			trabalhoRepository.save(new Trabalho(null, "trabalho asd", "teoria da relatividade", "google.com.br",
					areaConhecimentoRepository.findById(1L).get()));
			trabalhoRepository.save(new Trabalho(null, "Sulfamethoxazole/Trimethoprim", "soups", "Customer Relations",
					areaConhecimentoRepository.findById(6L).get()));
			trabalhoRepository.save(new Trabalho(null, "Abilify", "seafood", "Asset Management",
					areaConhecimentoRepository.findById(5L).get()));
			trabalhoRepository.save(new Trabalho(null, "Suboxone", "pies", "Media Relations",
					areaConhecimentoRepository.findById(6L).get()));
			trabalhoRepository.save(new Trabalho(null, "Amlodipine Besylate", "desserts", "Human Resources",
					areaConhecimentoRepository.findById(6L).get()));
			trabalhoRepository.save(new Trabalho(null, "Lexapro", "soups", "Sales and Marketing",
					areaConhecimentoRepository.findById(6L).get()));
			trabalhoRepository.save(new Trabalho(null, "Gabapentin", "noodles", "Accounting",
					areaConhecimentoRepository.findById(1L).get()));
			trabalhoRepository.save(new Trabalho(null, "Gabapentin", "desserts", "Asset Management",
					areaConhecimentoRepository.findById(7L).get()));
			trabalhoRepository.save(new Trabalho(null, "Gabapentin", "salads", "Finances",
					areaConhecimentoRepository.findById(6L).get()));
			trabalhoRepository.save(new Trabalho(null, "Simvastatin", "desserts", "Customer Relations",
					areaConhecimentoRepository.findById(4L).get()));
			trabalhoRepository.save(new Trabalho(null, "Advair Diskus", "soups", "Public Relations",
					areaConhecimentoRepository.findById(2L).get()));
			trabalhoRepository.save(new Trabalho(null, "Digoxin", "soups", "Legal Department",
					areaConhecimentoRepository.findById(5L).get()));
			trabalhoRepository.save(new Trabalho(null, "Amoxicillin Trihydrate/Potassium Clavulanate", "stews",
					"Legal Department", areaConhecimentoRepository.findById(7L).get()));
			trabalhoRepository.save(new Trabalho(null, "Gianvi", "noodles", "Customer Service",
					areaConhecimentoRepository.findById(2L).get()));
			trabalhoRepository.save(new Trabalho(null, "Zolpidem Tartrate", "cereals", "Human Resources",
					areaConhecimentoRepository.findById(6L).get()));
			trabalhoRepository.save(new Trabalho(null, "Ibuprofen (Rx)", "soups", "Tech Support",
					areaConhecimentoRepository.findById(6L).get()));
			trabalhoRepository.save(new Trabalho(null, "Metoprolol Tartrate ", "cereals", "Sales and Marketing",
					areaConhecimentoRepository.findById(3L).get()));
			trabalhoRepository.save(new Trabalho(null, "Amlodipine Besylate", "desserts", "Tech Support",
					areaConhecimentoRepository.findById(7L).get()));
			trabalhoRepository.save(new Trabalho(null, "Azithromycin", "soups", "Legal Department",
					areaConhecimentoRepository.findById(2L).get()));
			trabalhoRepository.save(new Trabalho(null, "Proair HFA", "sandwiches", "Asset Management",
					areaConhecimentoRepository.findById(3L).get()));
			trabalhoRepository.save(new Trabalho(null, "Vyvanse", "cereals", "Human Resources",
					areaConhecimentoRepository.findById(7L).get()));
			trabalhoRepository.save(new Trabalho(null, "Venlafaxine HCl ER", "pasta", "Quality Assurance",
					areaConhecimentoRepository.findById(5L).get()));
			trabalhoRepository.save(new Trabalho(null, "Carvedilol", "noodles", "Human Resources",
					areaConhecimentoRepository.findById(2L).get()));
			trabalhoRepository.save(new Trabalho(null, "Crestor", "soups", "Accounting",
					areaConhecimentoRepository.findById(6L).get()));
			trabalhoRepository.save(new Trabalho(null, "Zyprexa", "desserts", "Legal Department",
					areaConhecimentoRepository.findById(5L).get()));
			trabalhoRepository.save(new Trabalho(null, "Seroquel", "cereals", "Sales and Marketing",
					areaConhecimentoRepository.findById(3L).get()));
			trabalhoRepository.save(new Trabalho(null, "Amoxicillin Trihydrate/Potassium Clavulanate", "noodles",
					"Human Resources", areaConhecimentoRepository.findById(7L).get()));
			trabalhoRepository.save(new Trabalho(null, "Levaquin", "pasta", "Accounting",
					areaConhecimentoRepository.findById(7L).get()));
			trabalhoRepository.save(new Trabalho(null, "Glipizide", "stews", "Asset Management",
					areaConhecimentoRepository.findById(6L).get()));
			trabalhoRepository.save(new Trabalho(null, "Amlodipine Besylate", "pasta", "Finances",
					areaConhecimentoRepository.findById(3L).get()));
			trabalhoRepository.save(new Trabalho(null, "trabalho fisica", "teoria da relatividade", "google.com.br",
			areaConhecimentoRepository.findById(1L).get()));
			avaliadorRepository.save(new Avaliador(null, "welton", "aaa", "aaa",
			Collections.unmodifiableList(Arrays.asList(areaConhecimentoRepository.findById(1L).get(),
			 areaConhecimentoRepository.findById(2L).get(),
			 areaConhecimentoRepository.findById(3L).get(),
			 areaConhecimentoRepository.findById(4L).get(),
			 areaConhecimentoRepository.findById(5L).get(),
			 areaConhecimentoRepository.findById(6L).get(),
			 areaConhecimentoRepository.findById(7L).get()
			 ))));
			  revisaoRepository.save( new Revisao(avaliadorRepository.findAll().get(0),
			  trabalhoRepository.findAll().get(0), 2, "descricao", 1));
		};
	}

}
