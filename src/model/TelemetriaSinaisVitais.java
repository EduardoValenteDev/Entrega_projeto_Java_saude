package model;

import java.io.Serializable;

public class TelemetriaSinaisVitais implements Serializable {
    private int idTelemetria;
    private int idAtendimento;
    private int frequenciaCardiaca;
    private String pressaoArterial;
    private int oxigenacao;
    private double temperatura;
    private String dataHoraLeitura;

    public TelemetriaSinaisVitais(int idTelemetria, int idAtendimento, int frequenciaCardiaca,
                                  String pressaoArterial, int oxigenacao, double temperatura,
                                  String dataHoraLeitura) {
        this.idTelemetria = idTelemetria;
        this.idAtendimento = idAtendimento;
        this.frequenciaCardiaca = frequenciaCardiaca;
        this.pressaoArterial = pressaoArterial;
        this.oxigenacao = oxigenacao;
        this.temperatura = temperatura;
        this.dataHoraLeitura = dataHoraLeitura;
    }

    public int getIdTelemetria() {
        return idTelemetria;
    }

    public void setIdTelemetria(int idTelemetria) {
        this.idTelemetria = idTelemetria;
    }

    public int getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
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
        return "TelemetriaSinaisVitais {" +
                "idTelemetria=" + idTelemetria +
                ", idAtendimento=" + idAtendimento +
                ", frequenciaCardiaca=" + frequenciaCardiaca +
                ", pressaoArterial='" + pressaoArterial + '\'' +
                ", oxigenacao=" + oxigenacao +
                ", temperatura=" + temperatura +
                ", dataHoraLeitura='" + dataHoraLeitura + '\'' +
                '}';
    }
}