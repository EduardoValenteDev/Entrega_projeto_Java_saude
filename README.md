# Sistema de Atendimento em Unidades Móveis de Saúde

Projeto Java desenvolvido para simular um sistema de atendimento em saúde utilizando Programação Orientada a Objetos.

## Funcionalidades

Cadastro, listagem, busca e atualização de pacientes.

Cadastro e listagem de unidades móveis.

Cadastro e listagem de profissionais de saúde.

Registro e listagem de atendimentos.

Registro e listagem de sinais vitais.

## Diagrama UML de Classes

```mermaid
classDiagram
    class Paciente {
        - int idPaciente
        - String nome
        - String dataNascimento
        - String comunidadeOrigem
        - String historicoMedico
        + Paciente(int, String, String, String, String)
        + getIdPaciente() int
        + setIdPaciente(int)
        + getNome() String
        + setNome(String)
        + getDataNascimento() String
        + setDataNascimento(String)
        + getComunidadeOrigem() String
        + setComunidadeOrigem(String)
        + getHistoricoMedico() String
        + setHistoricoMedico(String)
        + toString() String
    }

    class UnidadeMovel {
        - int idUnidade
        - String identificacaoSatelite
        - String regiaoAtual
        - String statusConexao
        + UnidadeMovel(int, String, String, String)
        + getIdUnidade() int
        + setIdUnidade(int)
        + getIdentificacaoSatelite() String
        + setIdentificacaoSatelite(String)
        + getRegiaoAtual() String
        + setRegiaoAtual(String)
        + getStatusConexao() String
        + setStatusConexao(String)
        + toString() String
    }

    class Profissional {
        - int idProfissional
        - String nome
        - String registroConselho
        - String funcao
        + Profissional(int, String, String, String)
        + getIdProfissional() int
        + setIdProfissional(int)
        + getNome() String
        + setNome(String)
        + getRegistroConselho() String
        + setRegistroConselho(String)
        + getFuncao() String
        + setFuncao(String)
        + toString() String
    }

    class Atendimento {
        - int idAtendimento
        - int idPaciente
        - int idUnidade
        - int idProfissionalLocal
        - Integer idEspecialistaRemoto
        - String dataHoraInicio
        - String resultadoTriagemIa
        - String nivelUrgencia
        + Atendimento(int, int, int, int, Integer, String, String, String)
        + getIdAtendimento() int
        + setIdAtendimento(int)
        + getIdPaciente() int
        + setIdPaciente(int)
        + getIdUnidade() int
        + setIdUnidade(int)
        + getIdProfissionalLocal() int
        + setIdProfissionalLocal(int)
        + getIdEspecialistaRemoto() Integer
        + setIdEspecialistaRemoto(Integer)
        + getDataHoraInicio() String
        + setDataHoraInicio(String)
        + getResultadoTriagemIa() String
        + setResultadoTriagemIa(String)
        + getNivelUrgencia() String
        + setNivelUrgencia(String)
        + toString() String
    }

    class TelemetriaSinaisVitais {
        - int idTelemetria
        - int idAtendimento
        - int frequenciaCardiaca
        - String pressaoArterial
        - int oxigenacao
        - double temperatura
        - String dataHoraLeitura
        + TelemetriaSinaisVitais(int, int, int, String, int, double, String)
        + getIdTelemetria() int
        + setIdTelemetria(int)
        + getIdAtendimento() int
        + setIdAtendimento(int)
        + getFrequenciaCardiaca() int
        + setFrequenciaCardiaca(int)
        + getPressaoArterial() String
        + setPressaoArterial(String)
        + getOxigenacao() int
        + setOxigenacao(int)
        + getTemperatura() double
        + setTemperatura(double)
        + getDataHoraLeitura() String
        + setDataHoraLeitura(String)
        + toString() String
    }

    Paciente "1" --> "0..*" Atendimento : possui
    UnidadeMovel "1" --> "0..*" Atendimento : realiza
    Profissional "1" --> "0..*" Atendimento : participa
    Atendimento "1" --> "0..*" TelemetriaSinaisVitais : registra
```

## Organização do Projeto

```text
src
  Main.java
  model
    Atendimento.java
    Paciente.java
    Profissional.java
    TelemetriaSinaisVitais.java
    UnidadeMovel.java
```
