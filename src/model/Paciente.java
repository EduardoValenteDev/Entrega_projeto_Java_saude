package model;

public class Paciente {
    private String idPaciente;
    private String nome;
    private String dataNascimento;
    private Comunidade comunidade;
    private String historicoMedico;

    public Paciente(String idPaciente, String nome, String dataNascimento, Comunidade comunidade, String historicoMedico) {
        this.idPaciente = idPaciente;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.comunidade = comunidade;
        this.historicoMedico = historicoMedico;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Comunidade getComunidade() {
        return comunidade;
    }

    public void setComunidade(Comunidade comunidade) {
        this.comunidade = comunidade;
    }

    public String getHistoricoMedico() {
        return historicoMedico;
    }

    public void setHistoricoMedico(String historicoMedico) {
        this.historicoMedico = historicoMedico;
    }

    @Override
    public String toString() {
        return "\nPaciente" +
                "\nID: " + idPaciente +
                "\nNome: " + nome +
                "\nData de nascimento: " + dataNascimento +
                "\nComunidade: " + comunidade.getIdComunidade() + " - " + comunidade.getNome() +
                "\nHistórico médico: " + historicoMedico;
    }
}