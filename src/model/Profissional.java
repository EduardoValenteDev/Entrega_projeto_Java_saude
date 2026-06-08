package model;

public class Profissional {
    private String idProfissional;
    private String nome;
    private String registroConselho;
    private String funcao;

    public Profissional(String idProfissional, String nome, String registroConselho, String funcao) {
        this.idProfissional = idProfissional;
        this.nome = nome;
        this.registroConselho = registroConselho;
        this.funcao = funcao;
    }

    public String getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(String idProfissional) {
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
        return "\nProfissional" +
                "\nID: " + idProfissional +
                "\nNome: " + nome +
                "\nRegistro no conselho: " + registroConselho +
                "\nFunção: " + funcao;
    }
}