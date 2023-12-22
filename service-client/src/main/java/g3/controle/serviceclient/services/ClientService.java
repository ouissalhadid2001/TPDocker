package g3.controle.serviceclient.services;

import g3.controle.serviceclient.entities.Client;
import g3.controle.serviceclient.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public List<Client> FindAll(){
        return clientRepository.findAll();
    }
    public Client FindById(Long id) throws Exception {
        return clientRepository.findById(id).orElseThrow(()->new  Exception("invalid client id"));
    }
    public void addClient(Client c){
        clientRepository.save(c);
    }

}
