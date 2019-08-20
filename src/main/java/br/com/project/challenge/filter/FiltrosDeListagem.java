package br.com.project.challenge.filter;

import br.com.project.challenge.model.TipoModal;
import br.com.project.challenge.model.TipoUf;

public class FiltrosDeListagem {

    private String q;

    private String cidade;

    private TipoUf estado;

    private TipoModal modal;

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public TipoUf getEstado() {
        return estado;
    }

    public void setEstado(TipoUf estado) {
        this.estado = estado;
    }

    public TipoModal getModal() {
        return modal;
    }

    public void setModal(TipoModal modal) {
        this.modal = modal;
    }
}
