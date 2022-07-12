package br.com.triersistemas.solar.repository;

import br.com.triersistemas.solar.domain.Farmaceutico;
import br.com.triersistemas.solar.model.FarmaceuticoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FarmaceuticoRepository extends JpaRepository<Farmaceutico,UUID> {
}
