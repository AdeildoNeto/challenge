package br.com.project.challenge.service;

import br.com.project.challenge.filter.FiltrosDeListagem;
import br.com.project.challenge.model.*;
import br.com.project.challenge.repository.TransportadoraRepository;
import br.com.project.challenge.resource.EnderecoResource;
import br.com.project.challenge.resource.TransportadoraResource;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest
class TransportadoraServiceImplTest {

    @Autowired
    private TransportadoraRepository transportadoraRepository;

//    @PersistenceContext
//    private EntityManager em;

    @Autowired
    private TransportadoraService transportadoraService;

    @Test
    @Order(1)
    void detalhar() {

        Optional<Transportadora> detalhar = transportadoraService.detalhar(new Long(1));

        if (detalhar.isPresent())
            assertEquals(1, detalhar.get().getId());
    }

    @Test
    @Order(2)
    void listarSemFiltros(){

        FiltrosDeListagem filtros = new FiltrosDeListagem();
        List<Transportadora> listaRepositorio = transportadoraRepository.listar(filtros);
        List<Transportadora> listaServico = transportadoraService.listar(filtros);

        assertEquals(listaRepositorio.size(), listaServico.size());
    }

    @Test
    @Order(3)
    public void contarUfs() {
        List<ContadorUf> ufs = transportadoraService.contarUfs();

        assertEquals(2, ufs.size());
        assertEquals(2, ufs.get(0).getQuantidade());
        assertEquals(2, ufs.get(1).getQuantidade());

    }

    @Test
    @Order(4)
    public void cadastro() {

        int tamanhoListaInicial = transportadoraRepository.listar(new FiltrosDeListagem()).size();

        Endereco endereco = new Endereco();
        endereco.setEstado(TipoUf.AC);
        endereco.setNumero(new Long(12));
        endereco.setRua("Rua tal");
        endereco.setCidade("Rell");
        endereco.setBairro("aosaoskoka");

        Transportadora transportadora = new Transportadora();
        transportadora.setEndereco(endereco);
        transportadora.setTelefone("818182182");
        transportadora.setNome("okakosa");
        transportadora.setModal(TipoModal.AEREO);
        transportadora.setEmpresa("Emroaksa");
        transportadora.setEmail("oaskoska@email");

        assertEquals(null, transportadora.getId());

        Transportadora transportadoraCadastrada = transportadoraService.cadastrar(transportadora);
        assertNotEquals(null, transportadoraCadastrada.getId());

        int tamanhoListaAposCadastro = transportadoraRepository.listar(new FiltrosDeListagem()).size();

        assertEquals((tamanhoListaInicial + 1), tamanhoListaAposCadastro);

    }

    @Test
    @Transactional
    public void atualizarNomeDaTransportadora() {

        TransportadoraResource transportadoraResource = new TransportadoraResource(transportadoraRepository.getOne(new Long(1)));
        transportadoraResource.setNome("Novo Nome");

        Transportadora atualizar = transportadoraService.atualizar(new Long(1), transportadoraResource);

        assertEquals("Novo Nome", atualizar.getNome());
    }
}