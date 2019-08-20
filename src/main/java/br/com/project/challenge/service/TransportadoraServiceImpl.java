package br.com.project.challenge.service;

import br.com.project.challenge.filter.FiltrosDeListagem;
import br.com.project.challenge.model.ContadorUf;
import br.com.project.challenge.model.Endereco;
import br.com.project.challenge.model.Transportadora;
import br.com.project.challenge.repository.EnderecoRepository;
import br.com.project.challenge.repository.TransportadoraRepository;
import br.com.project.challenge.resource.EnderecoResource;
import br.com.project.challenge.resource.TransportadoraResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportadoraServiceImpl implements TransportadoraService {

    @Autowired
    private TransportadoraRepository transportadoraRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public List<Transportadora> listar(FiltrosDeListagem filtros) {
        return transportadoraRepository.listar(filtros);
    }

    @Override
    public List<ContadorUf> contarUfs() {
        return transportadoraRepository.contarUfs();
    }

    @Override
    public Transportadora cadastrar(Transportadora transportadora) {
        return transportadoraRepository.save(transportadora);
    }

    @Override
    public Optional<Transportadora> detalhar(Long id) {
        return transportadoraRepository.findById(id);
    }

    @Override
    public Transportadora atualizar(Long id, TransportadoraResource transportadoraResource) {

        EnderecoResource enderecoResource = transportadoraResource.getEndereco();
        Endereco endereco = enderecoRepository.getOne(enderecoResource.getId());

        endereco.setBairro(enderecoResource.getBairro());
        endereco.setCidade(enderecoResource.getCidade());
        endereco.setEstado(enderecoResource.getEstado());
        endereco.setNumero(enderecoResource.getNumero());
        endereco.setRua(enderecoResource.getRua());

        if (enderecoResource.getCep() != null && !enderecoResource.getCep().equals(""))
            endereco.setCep(enderecoResource.getCep());

        Transportadora transportadora = transportadoraRepository.getOne(id);

        transportadora.setTelefone(transportadoraResource.getTelefone());
        transportadora.setNome(transportadoraResource.getNome());
        transportadora.setModal(transportadoraResource.getModal());
        transportadora.setEmpresa(transportadoraResource.getEmpresa());
        transportadora.setEmail(transportadoraResource.getEmail());

        if (transportadoraResource.getWhatsApp() != null && !transportadoraResource.getWhatsApp().equals(""))
            transportadora.setWhatsApp(transportadoraResource.getWhatsApp());

        if ( transportadoraResource.getCelular() != null && !transportadoraResource.getCelular().equals(""))
            transportadora.setCelular(transportadoraResource.getCelular());

        return transportadora;
    }

    @Override
    public void excluir(Long id) {
        transportadoraRepository.deleteById(id);
    }
}

