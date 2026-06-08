package model;

public class Atendimento {
    private String idAtendimento;
    private Paciente paciente;
    private UnidadeMovel unidade;
    private Profissional profissionalLocal;
    private Profissional especialistaRemoto;
    private String dataHoraInicio;
    private String resultadoTriagemIa;
    private String nivelUrgencia;

    public Atendimento(String idAtendimento, Paciente paciente, UnidadeMovel unidade,
                       Profissional profissionalLocal, Profissional especialistaRemoto,
                       String dataHoraInicio, String resultadoTriagemIa, String nivelUrgencia) {
        this.idAtendimento = idAtendimento;
        this.paciente = paciente;
        this.unidade = unidade;
        this.profissionalLocal = profissionalLocal;
        this.especialistaRemoto = especialistaRemoto;
        this.dataHoraInicio = dataHoraInicio;
        this.resultadoTriagemIa = resultadoTriagemIa;
        this.nivelUrgencia = nivelUrgencia;
    }

    public String getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(String idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public UnidadeMovel getUnidade() {
        return unidade;
    }

    public void setUnidade(UnidadeMovel unidade) {
        this.unidade = unidade;
    }

    public Profissional getProfissionalLocal() {
        return profissionalLocal;
    }

    public void setProfissionalLocal(Profissional profissionalLocal) {
        this.profissionalLocal = profissionalLocal;
    }

    public Profissional getEspecialistaRemoto() {
        return especialistaRemoto;
    }

    public void setEspecialistaRemoto(Profissional especialistaRemoto) {
        this.especialistaRemoto = especialistaRemoto;
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
        String especialistaTexto;

        if (especialistaRemoto == null) {
            especialistaTexto = "Não informado";
        } else {
            especialistaTexto = especialistaRemoto.getIdProfissional() + " - " + especialistaRemoto.getNome();
        }

        return "\nAtendimento" +
                "\nID: " + idAtendimento +
                "\nPaciente: " + paciente.getIdPaciente() + " - " + paciente.getNome() +
                "\nComunidade: " + paciente.getComunidade().getIdComunidade() + " - " + paciente.getComunidade().getNome() +
                "\nUnidade móvel: " + unidade.getIdUnidade() + " - " + unidade.getIdentificacaoSatelite() +
                "\nProfissional local: " + profissionalLocal.getIdProfissional() + " - " + profissionalLocal.getNome() +
                "\nEspecialista remoto: " + especialistaTexto +
                "\nData e hora do início: " + dataHoraInicio +
                "\nResultado da triagem por IA: " + resultadoTriagemIa +
                "\nNível de urgência: " + nivelUrgencia;
    }
}