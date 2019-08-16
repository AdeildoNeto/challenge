package br.com.project.challenge.service;

import br.com.project.challenge.model.Transportadora;
import br.com.project.challenge.repository.TransportadoraRepository;
import br.com.project.challenge.resource.TransportadoraResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportadoraServiceImpl implements TransportadoraService {

    @Autowired
    private TransportadoraRepository repository;

    @Override
    public List<Transportadora> listar() {
        return repository.listar();
    }

    @Override
    public Transportadora cadastrar(Transportadora transportadora) {
        return repository.save(transportadora);
    }

    @Override
    public Optional<Transportadora> detalhar(Long id) {
        return repository.findById(id);
    }

    @Override
    public Transportadora atualizar(Long id, TransportadoraResource transportadoraResource) {

        Transportadora transportadora = repository.getOne(id);

        transportadora.setWhatsApp(transportadoraResource.getWhatsApp());
        transportadora.setTelefone(transportadoraResource.getTelefone());
        transportadora.setNome(transportadoraResource.getNome());
        transportadora.setModal(transportadoraResource.getModal());
        transportadora.setEmpresa(transportadoraResource.getEmpresa());
        transportadora.setEmail(transportadoraResource.getEmail());
        transportadora.setCelular(transportadoraResource.getCelular());
        transportadora.setEndereco(transportadoraResource.getEndereco().toEntity());

        return transportadora;
    }

    @Override
    public void excluir(Long id) {
        repository.deleteById(id);
    }
}

