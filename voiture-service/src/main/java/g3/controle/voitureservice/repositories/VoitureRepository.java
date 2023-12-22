package g3.controle.voitureservice.repositories;

import g3.controle.voitureservice.entities.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture,Long> {
}
