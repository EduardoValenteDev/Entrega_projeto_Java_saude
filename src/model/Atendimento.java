package model;

public class Atendimento {
    private int idAtendimento;
    private int idPaciente;
    private int idUnidade;
    private int idProfissionalLocal;
    private Integer idEspecialistaRemoto;
    private String dataHoraInicio;
    private String resultadoTriagemIa;
    private String nivelUrgencia;

    public Atendimento(int idAtendimento, int idPaciente, int idUnidade, int idProfissionalLocal,
                       Integer idEspecialistaRemoto, String dataHoraInicio,
                       String resultadoTriagemIa, String nivelUrgencia) {
        this.idAtendimento = idAtendimento;
        this.idPaciente = idPaciente;
        this.idUnidade = idUnidade;
        this.idProfissionalLocal = idProfissionalLocal;
        this.idEspecialistaRemoto = idEspecialistaRemoto;
        this.dataHoraInicio = dataHoraInicio;
        this.resultadoTriagemIa = resultadoTriagemIa;
        this.nivelUrgencia = nivelUrgencia;
    }

    public int getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(int idUnidade) {
        this.idUnidade = idUnidade;
    }

    public int getIdProfissionalLocal() {
        return idProfissionalLocal;
    }

    public void setIdProfissionalLocal(int idProfissionalLocal) {
        this.idProfissionalLocal = idProfissionalLocal;
    }

    public Integer getIdEspecialistaRemoto() {
        return idEspecialistaRemoto;
    }

    public void setIdEspecialistaRemoto(Integer idEspecialistaRemoto) {
        this.idEspecialistaRemoto = idEspecialistaRemoto;
    }

    public String getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(String dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public String getResultadoTriagemIa() {
        return resultadoTriagemIa;
    }

    public void setResultadoTriagemIa(String resultadoTriagemIa) {
        this.resultadoTriagemIa = resultadoTriagemIa;
    }

    public String getNivelUrgencia() {
        return nivelUrgencia;
    }

    public void setNivelUrgencia(String nivelUrgencia) {
        this.nivelUrgencia = nivelUrgencia;
    }

    @Override
    public String toString() {
        return "Atendimento {" +
                "idAtendimento=" + idAtendimento +
                ", idPaciente=" + idPaciente +
                ", idUnidade=" + idUnidade +
                ", idProfissionalLocal=" + idProfissionalLocal +
                ", idEspecialistaRemoto=" + idEspecialistaRemoto +
                ", dataHoraInicio='" + dataHoraInicio + '\'' +
                ", resultadoTriagemIa='" + resultadoTriagemIa + '\'' +
                ", nivelUrgencia='" + nivelUrgencia + '\'' +
                '}';
    }
}