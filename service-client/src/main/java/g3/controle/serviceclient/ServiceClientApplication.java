package g3.controle.serviceclient;

import g3.controle.serviceclient.entities.Client;
import g3.controle.serviceclient.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServiceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceClientApplication.class, args);
	}
@Bean
	CommandLineRunner initialiserH2Database(ClientRepository clientRepository){
return  args -> {
clientRepository.save(new Client(Long.parseLong("1"),"Amine Safi",Float.parseFloat("23")));
clientRepository.save(new Client(Long.parseLong("2"),"Amal Alaoui",Float.parseFloat("23")));
clientRepository.save(new Client(Long.parseLong("3"),"Samir Rami",Float.parseFloat("22")));

};
}
}
