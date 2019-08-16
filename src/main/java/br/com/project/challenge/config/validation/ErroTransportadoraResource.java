package br.com.project.challenge.config.validation;

public class ErroTransportadoraResource {

    private String campo;
    private String erro;

    public ErroTransportadoraResource(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
