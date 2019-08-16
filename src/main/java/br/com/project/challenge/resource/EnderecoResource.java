package br.com.project.challenge.resource;

import br.com.project.challenge.model.Endereco;
import br.com.project.challenge.model.TipoUf;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EnderecoResource {

    private Long id;

    @NotEmpty
    @NotNull
    private String rua;

    @NotNull
    @Min(0)
    private Long numero;

    @NotEmpty
    @NotNull
    private String bairro;

    @NotEmpty
    @NotNull
    private String cidade;

    private String cep;

    @NotNull
    private TipoUf estado;


    public EnderecoResource() {}

    public EnderecoResource(Endereco endereco) {
        this.setId(endereco.getId());
        this.setRua(endereco.getRua());
        this.setNumero(endereco.getNumero());
        this.setBairro(endereco.getBairro());
        this.setCidade(endereco.getCidade());
        this.setCep(endereco.getCep());
        this.setEstado(endereco.getEstado());
    }


    public Endereco toEntity(){

        Endereco endereco = new Endereco();

        endereco.setId(this.getId());
        endereco.setBairro(this.getBairro());
        endereco.setCep(this.getCep());
        endereco.setCidade(this.getCidade());
        endereco.setEstado(this.getEstado());
        endereco.setNumero(this.getNumero());
        endereco.setRua(this.getRua());

        return endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public TipoUf getEstado() {
        return estado;
    }

    public void setEstado(TipoUf estado) {
        this.estado = estado;
    }


}
