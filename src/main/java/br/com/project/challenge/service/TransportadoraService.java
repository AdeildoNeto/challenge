package br.com.project.challenge.service;

import br.com.project.challenge.filter.FiltrosDeListagem;
import br.com.project.challenge.model.ContadorUf;
import br.com.project.challenge.model.Transportadora;
import br.com.project.challenge.resource.TransportadoraResource;

import java.util.List;
import java.util.Optional;

public interface TransportadoraService {

    public List<Transportadora> listar(FiltrosDeListagem filtros);

    public List<ContadorUf> contarUfs();

    public Transportadora cadastrar(Transportadora transportadora);

    public Optional<Transportadora> detalhar (Long id);

    public Transportadora atualizar(Long id, TransportadoraResource transportadoraResource);

    public void excluir(Long id);
}
