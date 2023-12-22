package g3.controle.voitureservice.services;

import g3.controle.voitureservice.entities.Client;
import g3.controle.voitureservice.entities.Voiture;
import g3.controle.voitureservice.models.CarResponse;
import g3.controle.voitureservice.repositories.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VoitureService {
    @Autowired
    VoitureRepository voitureRepository;
    @Autowired
    RestTemplate restTemplate;
    private final String URL="http://localhost:8888/SERVICE-CLIENT";
    public List<CarResponse> FindAll(){
        List<Voiture> cars=voitureRepository.findAll();
        ResponseEntity<Client[]> response =restTemplate.getForEntity(this.URL+"/api/client",
                Client[].class);
        Client[] client=response.getBody();

        return cars.stream().map((Voiture v)->mapToCarResponse(v,client)).toList();
    }
    private CarResponse mapToCarResponse(Voiture v,Client [] clients){
        Client foundClient= Arrays.stream(clients).filter(client->client.getId().equals(v.getClient_id()))
                .findFirst().orElse(null);
        return CarResponse.builder().id(v.getId()).brand(v.getBrand()).client(foundClient).matricule(v.getMatricule())
                .model(v.getModel()).build();
    }

public CarResponse findById(Long id) throws Exception {
    Voiture voiture = voitureRepository.findById(id).orElseThrow(() -> new Exception("ID voiture not found"));
    Client client = restTemplate.getForObject(this.URL + "/api/client" + voiture.getClient_id(), Client.class);
    return CarResponse.builder().id(voiture.getId()).brand(voiture.getBrand()).client(client).matricule(voiture.getMatricule())
            .model(voiture.getModel()).build();
}
public void addVoiture(Voiture v){
        voitureRepository.save(v);
}
}
