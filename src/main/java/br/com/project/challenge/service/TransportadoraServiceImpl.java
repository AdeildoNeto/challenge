package br.com.project.challenge.service;

import br.com.project.challenge.model.Transportadora;
import br.com.project.challenge.repository.TransportadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportadoraServiceImpl implements TransportadoraService {

    @Autowired
    private TransportadoraRepository repository;

    @Override
    public List<Transportadora> find() {
        return repository.listar();
    }

    @Override
    public Transportadora save(Transportadora transportadora) {
        return repository.save(transportadora);
    }
}

