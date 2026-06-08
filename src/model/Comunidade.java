package model;

public class Comunidade {
    private String idComunidade;
    private String nome;
    private int populacao;
    private String riscos;
    private double distanciaHospitalar;
    private String conectividade;

    public Comunidade(String idComunidade, String nome, int populacao, String riscos,
                      double distanciaHospitalar, String conectividade) {
        this.idComunidade = idComunidade;
        this.nome = nome;
        this.populacao = populacao;
        this.riscos = riscos;
        this.distanciaHospitalar = distanciaHospitalar;
        this.conectividade = conectividade;
    }

    public String getIdComunidade() {
        return idComunidade;
    }

    public void setIdComunidade(String idComunidade) {
        this.idComunidade = idComunidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public int getPopulacao() {
        return populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public String getRiscos() {
        return riscos;
    }

    public void setRiscos(String riscos) {
        this.riscos = riscos;
    }

    public double getDistanciaHospitalar() {
        return distanciaHospitalar;
    }

    public void setDistanciaHospitalar(double distanciaHospitalar) {
        this.distanciaHospitalar = distanciaHospitalar;
    }

    public String getConectividade() {
        return conectividade;
    }

    public void setConectividade(String conectividade) {
        this.conectividade = conectividade;
    }

    @Override
    public String toString() {
        return "Comunidade {" +
                "idComunidade='" + idComunidade + '\'' +
                ", nome='" + nome + '\'' +
                ", populacao=" + populacao +
                ", riscos='" + riscos + '\'' +
                ", distanciaHospitalar=" + distanciaHospitalar +
                ", conectividade='" + conectividade + '\'' +
                '}';
    }
}