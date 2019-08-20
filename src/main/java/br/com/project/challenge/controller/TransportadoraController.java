package br.com.project.challenge.controller;

import br.com.project.challenge.filter.FiltrosDeListagem;
import br.com.project.challenge.model.Transportadora;
import br.com.project.challenge.resource.ContadorUfResource;
import br.com.project.challenge.resource.TransportadoraResource;
import br.com.project.challenge.service.TransportadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/api")
public class TransportadoraController {

    @Autowired
    private TransportadoraService transportadoraService;

    @GetMapping("/transportadoras")
    public List<TransportadoraResource> listar(FiltrosDeListagem filtros) {
        return transportadoraService.listar(filtros).stream().map(TransportadoraResource::new).collect(Collectors.toList());
    }

    @GetMapping("/transportadoras/ufs")
    public  List<ContadorUfResource> contarUfs() {
        return transportadoraService.contarUfs().stream().map(ContadorUfResource::new).collect(Collectors.toList());
    }

    @PostMapping("/transportadoras")
    @Transactional
    public ResponseEntity<TransportadoraResource> cadastrar(@Valid @RequestBody TransportadoraResource transportadoraResource) {
        transportadoraResource.setId(null);
        transportadoraResource.getEndereco().setId(null);

        Transportadora entity = transportadoraResource.toEntity();
        Transportadora transportadora = transportadoraService.cadastrar(entity);

        return new ResponseEntity<>(new TransportadoraResource(transportadora), HttpStatus.CREATED);
    }

    @GetMapping("/transportadoras/{id}")
    public ResponseEntity<TransportadoraResource> detalhar(@PathVariable Long id) {

        Optional<Transportadora> transportadora = transportadoraService.detalhar(id);

        if (transportadora.isPresent()) {
            return ResponseEntity.ok(new TransportadoraResource(transportadora.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/transportadoras/{id}")
    @Transactional
    public ResponseEntity<TransportadoraResource> atualizar(@PathVariable Long id, @Valid @RequestBody TransportadoraResource transportadoraResource) {

        Optional<Transportadora> transportadora = transportadoraService.detalhar(id);

        if (transportadora.isPresent()) {
            Transportadora transportadoraAtualizada = transportadoraService.atualizar(id, transportadoraResource);
            return ResponseEntity.ok(new TransportadoraResource(transportadoraAtualizada));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/transportadoras/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id) {

        Optional<Transportadora> transportadora = transportadoraService.detalhar(id);

        if (transportadora.isPresent()) {
            transportadoraService.excluir(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
