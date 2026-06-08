package model;

public class TelemetriaSinaisVitais {
    private String idTelemetria;
    private Atendimento atendimento;
    private int frequenciaCardiaca;
    private String pressaoArterial;
    private int oxigenacao;
    private double temperatura;
    private String dataHoraLeitura;

    public TelemetriaSinaisVitais(String idTelemetria, Atendimento atendimento, int frequenciaCardiaca,
                                  String pressaoArterial, int oxigenacao, double temperatura,
                                  String dataHoraLeitura) {
        this.idTelemetria = idTelemetria;
        this.atendimento = atendimento;
        this.frequenciaCardiaca = frequenciaCardiaca;
        this.pressaoArterial = pressaoArterial;
        this.oxigenacao = oxigenacao;
        this.temperatura = temperatura;
        this.dataHoraLeitura = dataHoraLeitura;
    }

    public String getIdTelemetria() {
        return idTelemetria;
    }

    public void setIdTelemetria(String idTelemetria) {
        this.idTelemetria = idTelemetria;
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    public int getFrequenciaCardiaca() {
        return frequenciaCardiaca;
    }

    public void setFrequenciaCardiaca(int frequenciaCardiaca) {
        this.frequenciaCardiaca = frequenciaCardiaca;
    }

    public String getPressaoArterial() {
        return pressaoArterial;
    }

    public void setPressaoArterial(String pressaoArterial) {
        this.pressaoArterial = pressaoArterial;
    }

    public int getOxigenacao() {
        return oxigenacao;
    }

    public void setOxigenacao(int oxigenacao) {
        this.oxigenacao = oxigenacao;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public String getDataHoraLeitura() {
        return dataHoraLeitura;
    }

    public void setDataHoraLeitura(String dataHoraLeitura) {
        this.dataHoraLeitura = dataHoraLeitura;
    }

    @Override
    public String toString() {
        return "\nSinais Vitais" +
                "\nID: " + idTelemetria +
                "\nAtendimento: " + atendimento.getIdAtendimento() +
                "\nPaciente: " + atendimento.getPaciente().getIdPaciente() + " - " + atendimento.getPaciente().getNome() +
                "\nFrequência cardíaca: " + frequenciaCardiaca + " bpm" +
                "\nPressão arterial: " + pressaoArterial +
                "\nOxigenação: " + oxigenacao + "%" +
                "\nTemperatura: " + temperatura + "°C" +
                "\nData e hora da leitura: " + dataHoraLeitura;
    }
}