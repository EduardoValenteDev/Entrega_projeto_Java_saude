package model;

import java.io.Serializable;

public class UnidadeMovel implements Serializable {
    private int idUnidade;
    private String identificacaoSatelite;
    private String regiaoAtual;
    private String statusConexao;

    public UnidadeMovel(int idUnidade, String identificacaoSatelite, String regiaoAtual, String statusConexao) {
        this.idUnidade = idUnidade;
        this.identificacaoSatelite = identificacaoSatelite;
        this.regiaoAtual = regiaoAtual;
        this.statusConexao = statusConexao;
    }

    public int getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(int idUnidade) {
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
        return "UnidadeMovel {" +
                "idUnidade=" + idUnidade +
                ", identificacaoSatelite='" + identificacaoSatelite + '\'' +
                ", regiaoAtual='" + regiaoAtual + '\'' +
                ", statusConexao='" + statusConexao + '\'' +
                '}';
    }
}