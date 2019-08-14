package br.com.project.challenge.controller;

import br.com.project.challenge.model.Transportadora;
import br.com.project.challenge.resource.TransportadoraResource;
import br.com.project.challenge.service.TransportadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/transportadoras")
public class TransportadoraController {

    @Autowired
    private TransportadoraService transportadoraService;

    @GetMapping("/")
    public List<TransportadoraResource> list() {
        return transportadoraService.find().stream().map(TransportadoraResource::new).collect(Collectors.toList());
    }

    @PostMapping("/")
    public ResponseEntity<TransportadoraResource> cadastrar(@RequestBody TransportadoraResource transportadoraResource) {
        if (transportadoraResource.getId() != null)
            transportadoraResource.setId(null);

        Transportadora entity = transportadoraResource.toEntity();
        Transportadora transportadora = transportadoraService.save(entity);

        return new ResponseEntity<>(new TransportadoraResource(transportadora), HttpStatus.CREATED);
    }
}
