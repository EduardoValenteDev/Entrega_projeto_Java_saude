package model;

public class UnidadeMovel {
    private String idUnidade;
    private String identificacaoSatelite;
    private String regiaoAtual;
    private String statusConexao;

    public UnidadeMovel(String idUnidade, String identificacaoSatelite, String regiaoAtual, String statusConexao) {
        this.idUnidade = idUnidade;
        this.identificacaoSatelite = identificacaoSatelite;
        this.regiaoAtual = regiaoAtual;
        this.statusConexao = statusConexao;
    }

    public String getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(String idUnidade) {
        this.idUnidade = idUnidade;
    }

    public String getIdentificacaoSatelite() {
        return identificacaoSatelite;
    }

    public void setIdentificacaoSatelite(String identificacaoSatelite) {
        this.identificacaoSatelite = identificacaoSatelite;
    }

    public String getRegiaoAtual() {
        return regiaoAtual;
    }

    public void setRegiaoAtual(String regiaoAtual) {
        this.regiaoAtual = regiaoAtual;
    }

    public String getStatusConexao() {
        return statusConexao;
    }

    public void setStatusConexao(String statusConexao) {
        this.statusConexao = statusConexao;
    }

    @Override
    public String toString() {
        return "\nUnidade Móvel" +
                "\nID: " + idUnidade +
                "\nIdentificação via satélite: " + identificacaoSatelite +
                "\nRegião atual: " + regiaoAtual +
                "\nStatus da conexão: " + statusConexao;
    }
}