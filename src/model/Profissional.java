package model;

import java.io.Serializable;

public class Profissional implements Serializable {
    private int idProfissional;
    private String nome;
    private String registroConselho;
    private String funcao;

    public Profissional(int idProfissional, String nome, String registroConselho, String funcao) {
        this.idProfissional = idProfissional;
        this.nome = nome;
        this.registroConselho = registroConselho;
        this.funcao = funcao;
    }

    public int getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(int idProfissional) {
        this.idProfissional = idProfissional;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getRegistroConselho() {
        return registroConselho;
    }

    public void setRegistroConselho(String registroConselho) {
        this.registroConselho = registroConselho;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return "Profissional {" +
                "idProfissional=" + idProfissional +
                ", nome='" + nome + '\'' +
                ", registroConselho='" + registroConselho + '\'' +
                ", funcao='" + funcao + '\'' +
                '}';
    }
}