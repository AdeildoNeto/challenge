package br.com.project.challenge.repository;

import br.com.project.challenge.filter.FiltrosDeListagem;
import br.com.project.challenge.model.Transportadora;

import java.util.List;

public interface TransportadoraCustomRepository {

    public List<Transportadora> listar(FiltrosDeListagem filtros);
}
