package g3.controle.voitureservice.controllers;

import g3.controle.voitureservice.entities.Voiture;
import g3.controle.voitureservice.models.CarResponse;
import g3.controle.voitureservice.services.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/car")
public class VoitureController {
    @Autowired
    VoitureService voitureService;
    @GetMapping
    List<CarResponse> FindAll(){
        return voitureService.FindAll();
    }
    @GetMapping("/{id}")
    public CarResponse FindById(@PathVariable Long id) throws Exception {
        return voitureService.findById(id);
    }
    @PostMapping
    public void addVoiture(@RequestBody Voiture v){
        voitureService.addVoiture(v);
    }
}
