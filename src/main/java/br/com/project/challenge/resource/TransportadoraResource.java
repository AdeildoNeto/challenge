package br.com.project.challenge.resource;

import br.com.project.challenge.model.TipoModal;
import br.com.project.challenge.model.Transportadora;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TransportadoraResource {

    private Long id;

    @NotEmpty
    @NotNull
    private String nome;

    @NotEmpty
    @NotNull
    private String empresa;

    @NotEmpty
    @NotNull
    private String email;

    @NotEmpty
    @NotNull
    private String telefone;

    private String celular;

    private String whatsApp;

    @NotNull
    private TipoModal modal;

    @Valid
    @NotNull
    private EnderecoResource endereco;


    public TransportadoraResource() { }

    public TransportadoraResource(Transportadora transportadora) {

        this.setId(transportadora.getId());
        this.setCelular(transportadora.getCelular());
        this.setEmail(transportadora.getEmail());
        this.setEmpresa(transportadora.getEmpresa());
        this.setModal(transportadora.getModal());
        this.setNome(transportadora.getNome());
        this.setTelefone(transportadora.getTelefone());
        this.setWhatsApp(transportadora.getWhatsApp());

        if (transportadora.getEndereco() != null)
            this.setEndereco(new EnderecoResource(transportadora.getEndereco()));
    }


    public Transportadora toEntity() {
        Transportadora transportadora = new Transportadora();

        transportadora.setId(this.getId());
        transportadora.setCelular(this.getCelular());
        transportadora.setEmail(this.getEmail());
        transportadora.setEmpresa(this.getEmpresa());
        transportadora.setModal(this.getModal());
        transportadora.setNome(this.getNome());
        transportadora.setTelefone(this.getTelefone());
        transportadora.setWhatsApp(this.getWhatsApp());

        if (this.getEndereco() != null)
            transportadora.setEndereco(this.getEndereco().toEntity());

        return transportadora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getWhatsApp() {
        return whatsApp;
    }

    public void setWhatsApp(String whatsApp) {
        this.whatsApp = whatsApp;
    }

    public TipoModal getModal() {
        return modal;
    }

    public void setModal(TipoModal modal) {
        this.modal = modal;
    }

    public EnderecoResource getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoResource endereco) {
        this.endereco = endereco;
    }
}

