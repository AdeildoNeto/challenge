package br.com.project.challenge.model;

public class ContadorUf {

    private TipoUf estado;

    private Long quantidade;

    public ContadorUf(TipoUf estado, Long quantidade) {
        this.estado = estado;
        this.quantidade = quantidade;
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
