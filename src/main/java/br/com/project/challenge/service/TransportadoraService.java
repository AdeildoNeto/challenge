package br.com.project.challenge.service;

import br.com.project.challenge.model.Transportadora;

import java.util.List;

public interface TransportadoraService {

    public List<Transportadora> find();

    public Transportadora save(Transportadora transportadora);
}
