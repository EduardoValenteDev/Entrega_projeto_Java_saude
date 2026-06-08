package model;

import java.io.Serializable;

public class Paciente implements Serializable {
    private int idPaciente;
    private String nome;
    private String dataNascimento;
    private String comunidadeOrigem;
    private String historicoMedico;

    public Paciente(int idPaciente, String nome, String dataNascimento, String comunidadeOrigem, String historicoMedico) {
        this.idPaciente = idPaciente;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.comunidadeOrigem = comunidadeOrigem;
        this.historicoMedico = historicoMedico;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
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

    public String getComunidadeOrigem() {
        return comunidadeOrigem;
    }

    public void setComunidadeOrigem(String comunidadeOrigem) {
        this.comunidadeOrigem = comunidadeOrigem;
    }

    public String getHistoricoMedico() {
        return historicoMedico;
    }

    public void setHistoricoMedico(String historicoMedico) {
        this.historicoMedico = historicoMedico;
    }

    @Override
    public String toString() {
        return "Paciente {" +
                "idPaciente=" + idPaciente +
                ", nome='" + nome + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", comunidadeOrigem='" + comunidadeOrigem + '\'' +
                ", historicoMedico='" + historicoMedico + '\'' +
                '}';
    }
}