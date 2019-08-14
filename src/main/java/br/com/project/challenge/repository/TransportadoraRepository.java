package br.com.project.challenge.repository;

import br.com.project.challenge.model.Transportadora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportadoraRepository extends JpaRepository<Transportadora, Long>, TransportadoraCustomRepository {
}
