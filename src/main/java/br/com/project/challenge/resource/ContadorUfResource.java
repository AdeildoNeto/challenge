package br.com.project.challenge.resource;

import br.com.project.challenge.model.ContadorUf;
import br.com.project.challenge.model.TipoUf;

public class ContadorUfResource {

    private TipoUf estado;

    private Long quantidade;

    public ContadorUfResource(ContadorUf contadorUf) {
        this.estado = contadorUf.getEstado();
        this.quantidade = contadorUf.getQuantidade();
    }

    public TipoUf getEstado() {
        return estado;
    }

    public void setEstado(TipoUf estado) {
        this.estado = estado;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
}
